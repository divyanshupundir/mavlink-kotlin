package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt64(armingTimeUtc)
    buffer.encodeUInt64(takeoffTimeUtc)
    buffer.encodeUInt64(flightUuid)
    buffer.encodeUInt32(timeBootMs)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(armingTimeUtc)
    buffer.encodeUInt64(takeoffTimeUtc)
    buffer.encodeUInt64(flightUuid)
    buffer.encodeUInt32(timeBootMs)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlightInformation> {
    public override val id: UInt = 264u

    public override val crcExtra: Byte = 49

    public override fun deserialize(bytes: ByteArray): FlightInformation {
      val buffer = Buffer().write(bytes)

      val armingTimeUtc = buffer.decodeUInt64()
      val takeoffTimeUtc = buffer.decodeUInt64()
      val flightUuid = buffer.decodeUInt64()
      val timeBootMs = buffer.decodeUInt32()

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
