package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Information about flight since last arming.
 *         This can be requested using MAV_CMD_REQUEST_MESSAGE.
 *       
 */
@GeneratedMavMessage(
  id = 264,
  crc = 49,
)
public data class FlightInformation(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown
   */
  @GeneratedMavField(type = "uint64_t")
  public val armingTimeUtc: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown
   */
  @GeneratedMavField(type = "uint64_t")
  public val takeoffTimeUtc: BigInteger = BigInteger.ZERO,
  /**
   * Universally unique identifier (UUID) of flight, should correspond to name of log files
   */
  @GeneratedMavField(type = "uint64_t")
  public val flightUuid: BigInteger = BigInteger.ZERO,
) : MavMessage<FlightInformation> {
  public override val instanceMetadata: MavMessage.Metadata<FlightInformation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(armingTimeUtc)
    outputBuffer.encodeUint64(takeoffTimeUtc)
    outputBuffer.encodeUint64(flightUuid)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(armingTimeUtc)
    outputBuffer.encodeUint64(takeoffTimeUtc)
    outputBuffer.encodeUint64(flightUuid)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 264

    private const val CRC: Int = 49

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<FlightInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val armingTimeUtc = inputBuffer.decodeUint64()
      val takeoffTimeUtc = inputBuffer.decodeUint64()
      val flightUuid = inputBuffer.decodeUint64()
      val timeBootMs = inputBuffer.decodeUint32()

      FlightInformation(
        timeBootMs = timeBootMs,
        armingTimeUtc = armingTimeUtc,
        takeoffTimeUtc = takeoffTimeUtc,
        flightUuid = flightUuid,
      )
    }


    private val METADATA: MavMessage.Metadata<FlightInformation> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlightInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var armingTimeUtc: BigInteger = BigInteger.ZERO

    public var takeoffTimeUtc: BigInteger = BigInteger.ZERO

    public var flightUuid: BigInteger = BigInteger.ZERO

    public fun build(): FlightInformation = FlightInformation(
      timeBootMs = timeBootMs,
      armingTimeUtc = armingTimeUtc,
      takeoffTimeUtc = takeoffTimeUtc,
      flightUuid = flightUuid,
    )
  }
}
