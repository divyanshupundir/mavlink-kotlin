package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.GimbalDeviceFlags
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Message reporting the current status of a gimbal manager. This message should be broadcast at a
 * low regular rate (e.g. 1 Hz, may be increase momentarily to e.g. 5 Hz for a period of 1 sec after a
 * change).
 *
 * @param gimbalId Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager
 * is responsible for.
 * @param supervisor Client who is currently supervisor (0 = none).
 * @param deviceFlags Gimbal device flags currently applied. Same flags as reported by
 * GIMBAL_DEVICE_ATTITUDE_STATUS.
 * @param managerFlags Gimbal manager flags currently applied.
 * @param profile Profile currently applied (0 = default).
 */
@GeneratedMavMessage(
  id = 60_011u,
  crcExtra = -73,
)
public data class Storm32GimbalManagerStatus(
  /**
   * Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible
   * for.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalId: UByte = 0u,
  /**
   * Client who is currently supervisor (0 = none).
   */
  @GeneratedMavField(type = "uint8_t")
  public val supervisor: MavEnumValue<MavStorm32GimbalManagerClient> = MavEnumValue.fromValue(0u),
  /**
   * Gimbal device flags currently applied. Same flags as reported by GIMBAL_DEVICE_ATTITUDE_STATUS.
   */
  @GeneratedMavField(type = "uint16_t")
  public val deviceFlags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal manager flags currently applied.
   */
  @GeneratedMavField(type = "uint16_t")
  public val managerFlags: MavBitmaskValue<MavStorm32GimbalManagerFlags> =
      MavBitmaskValue.fromValue(0u),
  /**
   * Profile currently applied (0 = default).
   */
  @GeneratedMavField(type = "uint8_t")
  public val profile: MavEnumValue<MavStorm32GimbalManagerProfile> = MavEnumValue.fromValue(0u),
) : MavMessage<Storm32GimbalManagerStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<Storm32GimbalManagerStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(deviceFlags.value, 2)
    encoder.encodeBitmaskValue(managerFlags.value, 2)
    encoder.encodeUInt8(gimbalId)
    encoder.encodeEnumValue(supervisor.value, 1)
    encoder.encodeEnumValue(profile.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(deviceFlags.value, 2)
    encoder.encodeBitmaskValue(managerFlags.value, 2)
    encoder.encodeUInt8(gimbalId)
    encoder.encodeEnumValue(supervisor.value, 1)
    encoder.encodeEnumValue(profile.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Storm32GimbalManagerStatus> {
    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    override val id: UInt = 60_011u

    override val crcExtra: Byte = -73

    override fun deserialize(bytes: ByteArray): Storm32GimbalManagerStatus {
      val decoder = MavDataDecoder(bytes)

      val deviceFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = GimbalDeviceFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val managerFlags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = MavStorm32GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val gimbalId = decoder.safeDecodeUInt8()
      val supervisor = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavStorm32GimbalManagerClient.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val profile = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavStorm32GimbalManagerProfile.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return Storm32GimbalManagerStatus(
        gimbalId = gimbalId,
        supervisor = supervisor,
        deviceFlags = deviceFlags,
        managerFlags = managerFlags,
        profile = profile,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Storm32GimbalManagerStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var gimbalId: UByte = 0u

    public var supervisor: MavEnumValue<MavStorm32GimbalManagerClient> = MavEnumValue.fromValue(0u)

    public var deviceFlags: MavBitmaskValue<GimbalDeviceFlags> = MavBitmaskValue.fromValue(0u)

    public var managerFlags: MavBitmaskValue<MavStorm32GimbalManagerFlags> =
        MavBitmaskValue.fromValue(0u)

    public var profile: MavEnumValue<MavStorm32GimbalManagerProfile> = MavEnumValue.fromValue(0u)

    public fun build(): Storm32GimbalManagerStatus = Storm32GimbalManagerStatus(
      gimbalId = gimbalId,
      supervisor = supervisor,
      deviceFlags = deviceFlags,
      managerFlags = managerFlags,
      profile = profile,
    )
  }
}
