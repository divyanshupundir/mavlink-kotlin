package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled.
 *
 * @param limitsState State of AP_Limits.
 * @param lastTrigger Time (since boot) of last breach.
 * units = ms
 * @param lastAction Time (since boot) of last recovery action.
 * units = ms
 * @param lastRecovery Time (since boot) of last successful recovery.
 * units = ms
 * @param lastClear Time (since boot) of last all-clear.
 * units = ms
 * @param breachCount Number of fence breaches.
 * @param modsEnabled AP_Limit_Module bitfield of enabled modules.
 * @param modsRequired AP_Limit_Module bitfield of required modules.
 * @param modsTriggered AP_Limit_Module bitfield of triggered modules.
 */
@GeneratedMavMessage(
  id = 167u,
  crcExtra = -112,
)
public data class LimitsStatus(
  /**
   * State of AP_Limits.
   */
  @GeneratedMavField(type = "uint8_t")
  public val limitsState: MavEnumValue<LimitsState> = MavEnumValue.fromValue(0u),
  /**
   * Time (since boot) of last breach.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastTrigger: UInt = 0u,
  /**
   * Time (since boot) of last recovery action.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastAction: UInt = 0u,
  /**
   * Time (since boot) of last successful recovery.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastRecovery: UInt = 0u,
  /**
   * Time (since boot) of last all-clear.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastClear: UInt = 0u,
  /**
   * Number of fence breaches.
   */
  @GeneratedMavField(type = "uint16_t")
  public val breachCount: UShort = 0u,
  /**
   * AP_Limit_Module bitfield of enabled modules.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modsEnabled: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0u),
  /**
   * AP_Limit_Module bitfield of required modules.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modsRequired: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0u),
  /**
   * AP_Limit_Module bitfield of triggered modules.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modsTriggered: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0u),
) : MavMessage<LimitsStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<LimitsStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(lastTrigger)
    encoder.encodeUInt32(lastAction)
    encoder.encodeUInt32(lastRecovery)
    encoder.encodeUInt32(lastClear)
    encoder.encodeUInt16(breachCount)
    encoder.encodeEnumValue(limitsState.value, 1)
    encoder.encodeBitmaskValue(modsEnabled.value, 1)
    encoder.encodeBitmaskValue(modsRequired.value, 1)
    encoder.encodeBitmaskValue(modsTriggered.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(lastTrigger)
    encoder.encodeUInt32(lastAction)
    encoder.encodeUInt32(lastRecovery)
    encoder.encodeUInt32(lastClear)
    encoder.encodeUInt16(breachCount)
    encoder.encodeEnumValue(limitsState.value, 1)
    encoder.encodeBitmaskValue(modsEnabled.value, 1)
    encoder.encodeBitmaskValue(modsRequired.value, 1)
    encoder.encodeBitmaskValue(modsTriggered.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LimitsStatus> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    override val id: UInt = 167u

    override val crcExtra: Byte = -112

    override fun deserialize(bytes: ByteArray): LimitsStatus {
      val decoder = MavDataDecoder(bytes)

      val lastTrigger = decoder.safeDecodeUInt32()
      val lastAction = decoder.safeDecodeUInt32()
      val lastRecovery = decoder.safeDecodeUInt32()
      val lastClear = decoder.safeDecodeUInt32()
      val breachCount = decoder.safeDecodeUInt16()
      val limitsState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = LimitsState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modsEnabled = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsRequired = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsTriggered = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return LimitsStatus(
        limitsState = limitsState,
        lastTrigger = lastTrigger,
        lastAction = lastAction,
        lastRecovery = lastRecovery,
        lastClear = lastClear,
        breachCount = breachCount,
        modsEnabled = modsEnabled,
        modsRequired = modsRequired,
        modsTriggered = modsTriggered,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LimitsStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var limitsState: MavEnumValue<LimitsState> = MavEnumValue.fromValue(0u)

    public var lastTrigger: UInt = 0u

    public var lastAction: UInt = 0u

    public var lastRecovery: UInt = 0u

    public var lastClear: UInt = 0u

    public var breachCount: UShort = 0u

    public var modsEnabled: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0u)

    public var modsRequired: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0u)

    public var modsTriggered: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0u)

    public fun build(): LimitsStatus = LimitsStatus(
      limitsState = limitsState,
      lastTrigger = lastTrigger,
      lastAction = lastAction,
      lastRecovery = lastRecovery,
      lastClear = lastClear,
      breachCount = breachCount,
      modsEnabled = modsEnabled,
      modsRequired = modsRequired,
      modsTriggered = modsTriggered,
    )
  }
}
