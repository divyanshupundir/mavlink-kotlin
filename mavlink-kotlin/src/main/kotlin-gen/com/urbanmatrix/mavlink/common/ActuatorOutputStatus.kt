package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message
 * supersedes SERVO_OUTPUT_RAW.
 */
public data class ActuatorOutputStatus(
  /**
   * Timestamp (since system boot).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Active outputs
   */
  public val active: Long = 0L,
  /**
   * Servo / motor output array values. Zero values indicate unused channels.
   */
  public val actuator: List<Float> = emptyList(),
) : MavMessage<ActuatorOutputStatus> {
  public override val instanceMetadata: MavMessage.Metadata<ActuatorOutputStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(140).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(active)
    outputBuffer.encodeFloatArray(actuator, 128)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 375

    private const val CRC: Int = 210

    private val DESERIALIZER: MavDeserializer<ActuatorOutputStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val active = inputBuffer.decodeUint32()
      val actuator = inputBuffer.decodeFloatArray(128)
      ActuatorOutputStatus(
        timeUsec = timeUsec,
        active = active,
        actuator = actuator,
      )
    }


    private val METADATA: MavMessage.Metadata<ActuatorOutputStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ActuatorOutputStatus> = METADATA
  }
}
