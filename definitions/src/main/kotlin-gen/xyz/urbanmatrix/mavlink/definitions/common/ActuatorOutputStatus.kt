package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message
 * supersedes SERVO_OUTPUT_RAW.
 */
@GeneratedMavMessage(
  id = 375,
  crc = 251,
)
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
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(active)
    outputBuffer.encodeFloatArray(actuator, 128)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 375

    private const val CRC: Int = 251

    private const val SIZE: Int = 140

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var active: Long = 0L

    public var actuator: List<Float> = emptyList()

    public fun build(): ActuatorOutputStatus = ActuatorOutputStatus(
      timeUsec = timeUsec,
      active = active,
      actuator = actuator,
    )
  }
}
