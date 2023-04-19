package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message
 * supersedes SERVO_OUTPUT_RAW.
 */
@GeneratedMavMessage(
  id = 375u,
  crcExtra = -5,
)
public data class ActuatorOutputStatus(
  /**
   * Timestamp (since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Active outputs
   */
  @GeneratedMavField(type = "uint32_t")
  public val active: UInt = 0u,
  /**
   * Servo / motor output array values. Zero values indicate unused channels.
   */
  @GeneratedMavField(type = "float[32]")
  public val actuator: List<Float> = emptyList(),
) : MavMessage<ActuatorOutputStatus> {
  public override val instanceMetadata: MavMessage.Metadata<ActuatorOutputStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(active)
    outputBuffer.encodeFloatArray(actuator, 128)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(active)
    outputBuffer.encodeFloatArray(actuator, 128)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 375u

    private const val CRC_EXTRA: Byte = -5

    private const val SIZE_V1: Int = 140

    private const val SIZE_V2: Int = 140

    private val DESERIALIZER: MavDeserializer<ActuatorOutputStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val active = inputBuffer.decodeUInt32()
      val actuator = inputBuffer.decodeFloatArray(128)

      ActuatorOutputStatus(
        timeUsec = timeUsec,
        active = active,
        actuator = actuator,
      )
    }


    private val METADATA: MavMessage.Metadata<ActuatorOutputStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ActuatorOutputStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ActuatorOutputStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var active: UInt = 0u

    public var actuator: List<Float> = emptyList()

    public fun build(): ActuatorOutputStatus = ActuatorOutputStatus(
      timeUsec = timeUsec,
      active = active,
      actuator = actuator,
    )
  }
}
