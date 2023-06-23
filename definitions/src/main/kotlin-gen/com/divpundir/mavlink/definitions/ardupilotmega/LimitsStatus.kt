package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled.
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
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastTrigger: UInt = 0u,
  /**
   * Time (since boot) of last recovery action.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastAction: UInt = 0u,
  /**
   * Time (since boot) of last successful recovery.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastRecovery: UInt = 0u,
  /**
   * Time (since boot) of last all-clear.
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
  public override val instanceCompanion: MavMessage.MavCompanion<LimitsStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(lastTrigger)
    output.encodeUInt32(lastAction)
    output.encodeUInt32(lastRecovery)
    output.encodeUInt32(lastClear)
    output.encodeUInt16(breachCount)
    output.encodeEnumValue(limitsState.value, 1)
    output.encodeBitmaskValue(modsEnabled.value, 1)
    output.encodeBitmaskValue(modsRequired.value, 1)
    output.encodeBitmaskValue(modsTriggered.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(lastTrigger)
    output.encodeUInt32(lastAction)
    output.encodeUInt32(lastRecovery)
    output.encodeUInt32(lastClear)
    output.encodeUInt16(breachCount)
    output.encodeEnumValue(limitsState.value, 1)
    output.encodeBitmaskValue(modsEnabled.value, 1)
    output.encodeBitmaskValue(modsRequired.value, 1)
    output.encodeBitmaskValue(modsTriggered.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LimitsStatus> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    public override val id: UInt = 167u

    public override val crcExtra: Byte = -112

    public override fun deserialize(source: BufferedSource): LimitsStatus {
      val lastTrigger = source.decodeUInt32()
      val lastAction = source.decodeUInt32()
      val lastRecovery = source.decodeUInt32()
      val lastClear = source.decodeUInt32()
      val breachCount = source.decodeUInt16()
      val limitsState = source.decodeEnumValue(1).let { value ->
        val entry = LimitsState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modsEnabled = source.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsRequired = source.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsTriggered = source.decodeBitmaskValue(1).let { value ->
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
