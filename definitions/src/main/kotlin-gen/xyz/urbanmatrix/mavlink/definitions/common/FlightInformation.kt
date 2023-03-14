package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Information about flight since last arming.
 *         This can be requested using MAV_CMD_REQUEST_MESSAGE.
 *       
 */
@GeneratedMavMessage(
  id = 264u,
  crcExtra = 49,
)
public data class FlightInformation(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Timestamp at arming (time since UNIX epoch) in UTC, 0 for unknown
   */
  @GeneratedMavField(type = "uint64_t")
  public val armingTimeUtc: ULong = 0uL,
  /**
   * Timestamp at takeoff (time since UNIX epoch) in UTC, 0 for unknown
   */
  @GeneratedMavField(type = "uint64_t")
  public val takeoffTimeUtc: ULong = 0uL,
  /**
   * Universally unique identifier (UUID) of flight, should correspond to name of log files
   */
  @GeneratedMavField(type = "uint64_t")
  public val flightUuid: ULong = 0uL,
) : MavMessage<FlightInformation> {
  public override val instanceMetadata: MavMessage.Metadata<FlightInformation> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(armingTimeUtc)
    outputBuffer.encodeUInt64(takeoffTimeUtc)
    outputBuffer.encodeUInt64(flightUuid)
    outputBuffer.encodeUInt32(timeBootMs)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(armingTimeUtc)
    outputBuffer.encodeUInt64(takeoffTimeUtc)
    outputBuffer.encodeUInt64(flightUuid)
    outputBuffer.encodeUInt32(timeBootMs)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 264u

    private const val CRC_EXTRA: Byte = 49

    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    private val DESERIALIZER: MavDeserializer<FlightInformation> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val armingTimeUtc = inputBuffer.decodeUInt64()
      val takeoffTimeUtc = inputBuffer.decodeUInt64()
      val flightUuid = inputBuffer.decodeUInt64()
      val timeBootMs = inputBuffer.decodeUInt32()

      FlightInformation(
        timeBootMs = timeBootMs,
        armingTimeUtc = armingTimeUtc,
        takeoffTimeUtc = takeoffTimeUtc,
        flightUuid = flightUuid,
      )
    }


    private val METADATA: MavMessage.Metadata<FlightInformation> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlightInformation> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FlightInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var armingTimeUtc: ULong = 0uL

    public var takeoffTimeUtc: ULong = 0uL

    public var flightUuid: ULong = 0uL

    public fun build(): FlightInformation = FlightInformation(
      timeBootMs = timeBootMs,
      armingTimeUtc = armingTimeUtc,
      takeoffTimeUtc = takeoffTimeUtc,
      flightUuid = flightUuid,
    )
  }
}
