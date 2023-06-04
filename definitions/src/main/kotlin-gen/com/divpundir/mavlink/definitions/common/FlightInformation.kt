package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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

  public companion object : MavMessage.MavCompanion<FlightInformation> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 264u

    public override val crcExtra: Byte = 49

    public override fun deserialize(bytes: ByteArray): FlightInformation {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val armingTimeUtc = inputBuffer.decodeUInt64()
      val takeoffTimeUtc = inputBuffer.decodeUInt64()
      val flightUuid = inputBuffer.decodeUInt64()
      val timeBootMs = inputBuffer.decodeUInt32()

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
