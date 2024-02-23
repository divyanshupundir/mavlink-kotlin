package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low
 * regular rate (e.g. 5Hz).
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param flags High level gimbal manager flags currently applied.
 * @param gimbalDeviceId Gimbal device ID that this gimbal manager is responsible for. Component ID
 * of gimbal device (or 1-6 for non-MAVLink gimbal).
 * @param primaryControlSysid System ID of MAVLink component with primary control, 0 for none.
 * @param primaryControlCompid Component ID of MAVLink component with primary control, 0 for none.
 * @param secondaryControlSysid System ID of MAVLink component with secondary control, 0 for none.
 * @param secondaryControlCompid Component ID of MAVLink component with secondary control, 0 for
 * none.
 */
@GeneratedMavMessage(
  id = 281u,
  crcExtra = 48,
)
public data class GimbalManagerStatus(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * High level gimbal manager flags currently applied.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal device ID that this gimbal manager is responsible for. Component ID of gimbal device (or
   * 1-6 for non-MAVLink gimbal).
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
  override val instanceCompanion: MavMessage.MavCompanion<GimbalManagerStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeUInt8(gimbalDeviceId)
    encoder.encodeUInt8(primaryControlSysid)
    encoder.encodeUInt8(primaryControlCompid)
    encoder.encodeUInt8(secondaryControlSysid)
    encoder.encodeUInt8(secondaryControlCompid)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeBitmaskValue(flags.value, 4)
    encoder.encodeUInt8(gimbalDeviceId)
    encoder.encodeUInt8(primaryControlSysid)
    encoder.encodeUInt8(primaryControlCompid)
    encoder.encodeUInt8(secondaryControlSysid)
    encoder.encodeUInt8(secondaryControlCompid)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GimbalManagerStatus> {
    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    override val id: UInt = 281u

    override val crcExtra: Byte = 48

    override fun deserialize(bytes: ByteArray): GimbalManagerStatus {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val flags = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val gimbalDeviceId = decoder.safeDecodeUInt8()
      val primaryControlSysid = decoder.safeDecodeUInt8()
      val primaryControlCompid = decoder.safeDecodeUInt8()
      val secondaryControlSysid = decoder.safeDecodeUInt8()
      val secondaryControlCompid = decoder.safeDecodeUInt8()

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
