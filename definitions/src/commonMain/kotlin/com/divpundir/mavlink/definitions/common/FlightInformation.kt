package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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
  public override val instanceCompanion: MavMessage.MavCompanion<FlightInformation> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(armingTimeUtc)
    encoder.encodeUInt64(takeoffTimeUtc)
    encoder.encodeUInt64(flightUuid)
    encoder.encodeUInt32(timeBootMs)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(armingTimeUtc)
    encoder.encodeUInt64(takeoffTimeUtc)
    encoder.encodeUInt64(flightUuid)
    encoder.encodeUInt32(timeBootMs)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlightInformation> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 264u

    public override val crcExtra: Byte = 49

    public override fun deserialize(bytes: ByteArray): FlightInformation {
      val decoder = MavDataDecoder(bytes)

      val armingTimeUtc = decoder.safeDecodeUInt64()
      val takeoffTimeUtc = decoder.safeDecodeUInt64()
      val flightUuid = decoder.safeDecodeUInt64()
      val timeBootMs = decoder.safeDecodeUInt32()

      return FlightInformation(
        timeBootMs = timeBootMs,
        armingTimeUtc = armingTimeUtc,
        takeoffTimeUtc = takeoffTimeUtc,
        flightUuid = flightUuid,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlightInformation =
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
