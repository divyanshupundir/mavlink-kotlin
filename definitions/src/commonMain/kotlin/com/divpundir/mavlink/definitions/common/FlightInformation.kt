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
 * Flight information.
 *         This includes time since boot for arm, takeoff, and land, and a flight number.
 *         Takeoff and landing values reset to zero on arm.
 *         This can be requested using MAV_CMD_REQUEST_MESSAGE.
 *         Note, some fields are misnamed - timestamps are from boot (not UTC) and the flight_uuid
 * is a sequence number.
 *       
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param armingTimeUtc Timestamp at arming (since system boot). Set to 0 on boot. Set value on
 * arming. Note, field is misnamed UTC.
 * units = us
 * @param takeoffTimeUtc Timestamp at takeoff (since system boot). Set to 0 at boot and on arming.
 * Note, field is misnamed UTC.
 * units = us
 * @param flightUuid Flight number. Note, field is misnamed UUID.
 * @param landingTime Timestamp at landing (in ms since system boot). Set to 0 at boot and on
 * arming.
 * units = ms
 */
@GeneratedMavMessage(
  id = 264u,
  crcExtra = 49,
)
public data class FlightInformation(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Timestamp at arming (since system boot). Set to 0 on boot. Set value on arming. Note, field is
   * misnamed UTC.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val armingTimeUtc: ULong = 0uL,
  /**
   * Timestamp at takeoff (since system boot). Set to 0 at boot and on arming. Note, field is
   * misnamed UTC.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val takeoffTimeUtc: ULong = 0uL,
  /**
   * Flight number. Note, field is misnamed UUID.
   */
  @GeneratedMavField(type = "uint64_t")
  public val flightUuid: ULong = 0uL,
  /**
   * Timestamp at landing (in ms since system boot). Set to 0 at boot and on arming.
   * units = ms
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val landingTime: UInt = 0u,
) : MavMessage<FlightInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<FlightInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(armingTimeUtc)
    encoder.encodeUInt64(takeoffTimeUtc)
    encoder.encodeUInt64(flightUuid)
    encoder.encodeUInt32(timeBootMs)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(armingTimeUtc)
    encoder.encodeUInt64(takeoffTimeUtc)
    encoder.encodeUInt64(flightUuid)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(landingTime)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlightInformation> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 32

    override val id: UInt = 264u

    override val crcExtra: Byte = 49

    override fun deserialize(bytes: ByteArray): FlightInformation {
      val decoder = MavDataDecoder(bytes)

      val armingTimeUtc = decoder.safeDecodeUInt64()
      val takeoffTimeUtc = decoder.safeDecodeUInt64()
      val flightUuid = decoder.safeDecodeUInt64()
      val timeBootMs = decoder.safeDecodeUInt32()
      val landingTime = decoder.safeDecodeUInt32()

      return FlightInformation(
        timeBootMs = timeBootMs,
        armingTimeUtc = armingTimeUtc,
        takeoffTimeUtc = takeoffTimeUtc,
        flightUuid = flightUuid,
        landingTime = landingTime,
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

    public var landingTime: UInt = 0u

    public fun build(): FlightInformation = FlightInformation(
      timeBootMs = timeBootMs,
      armingTimeUtc = armingTimeUtc,
      takeoffTimeUtc = takeoffTimeUtc,
      flightUuid = flightUuid,
      landingTime = landingTime,
    )
  }
}
