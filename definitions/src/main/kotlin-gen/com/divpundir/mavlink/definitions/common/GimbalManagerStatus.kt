package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low
 * regular rate (e.g. 5Hz).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 281u,
  crcExtra = 48,
)
public data class GimbalManagerStatus(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * High level gimbal manager flags currently applied.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal device ID that this gimbal manager is responsible for.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: UByte = 0u,
  /**
   * System ID of MAVLink component with primary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val primaryControlSysid: UByte = 0u,
  /**
   * Component ID of MAVLink component with primary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val primaryControlCompid: UByte = 0u,
  /**
   * System ID of MAVLink component with secondary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val secondaryControlSysid: UByte = 0u,
  /**
   * Component ID of MAVLink component with secondary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val secondaryControlCompid: UByte = 0u,
) : MavMessage<GimbalManagerStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeBitmaskValue(flags.value, 4)
    buffer.encodeUInt8(gimbalDeviceId)
    buffer.encodeUInt8(primaryControlSysid)
    buffer.encodeUInt8(primaryControlCompid)
    buffer.encodeUInt8(secondaryControlSysid)
    buffer.encodeUInt8(secondaryControlCompid)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeBitmaskValue(flags.value, 4)
    buffer.encodeUInt8(gimbalDeviceId)
    buffer.encodeUInt8(primaryControlSysid)
    buffer.encodeUInt8(primaryControlCompid)
    buffer.encodeUInt8(secondaryControlSysid)
    buffer.encodeUInt8(secondaryControlCompid)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerStatus> {
    public override val id: UInt = 281u

    public override val crcExtra: Byte = 48

    public override fun deserialize(bytes: ByteArray): GimbalManagerStatus {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val flags = buffer.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val gimbalDeviceId = buffer.decodeUInt8()
      val primaryControlSysid = buffer.decodeUInt8()
      val primaryControlCompid = buffer.decodeUInt8()
      val secondaryControlSysid = buffer.decodeUInt8()
      val secondaryControlCompid = buffer.decodeUInt8()

      return GimbalManagerStatus(
        timeBootMs = timeBootMs,
        flags = flags,
        gimbalDeviceId = gimbalDeviceId,
        primaryControlSysid = primaryControlSysid,
        primaryControlCompid = primaryControlCompid,
        secondaryControlSysid = secondaryControlSysid,
        secondaryControlCompid = secondaryControlCompid,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GimbalManagerStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u)

    public var gimbalDeviceId: UByte = 0u

    public var primaryControlSysid: UByte = 0u

    public var primaryControlCompid: UByte = 0u

    public var secondaryControlSysid: UByte = 0u

    public var secondaryControlCompid: UByte = 0u

    public fun build(): GimbalManagerStatus = GimbalManagerStatus(
      timeBootMs = timeBootMs,
      flags = flags,
      gimbalDeviceId = gimbalDeviceId,
      primaryControlSysid = primaryControlSysid,
      primaryControlCompid = primaryControlCompid,
      secondaryControlSysid = secondaryControlSysid,
      secondaryControlCompid = secondaryControlCompid,
    )
  }
}
