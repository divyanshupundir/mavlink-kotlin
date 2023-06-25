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
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(lastTrigger)
    buffer.encodeUInt32(lastAction)
    buffer.encodeUInt32(lastRecovery)
    buffer.encodeUInt32(lastClear)
    buffer.encodeUInt16(breachCount)
    buffer.encodeEnumValue(limitsState.value, 1)
    buffer.encodeBitmaskValue(modsEnabled.value, 1)
    buffer.encodeBitmaskValue(modsRequired.value, 1)
    buffer.encodeBitmaskValue(modsTriggered.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(lastTrigger)
    buffer.encodeUInt32(lastAction)
    buffer.encodeUInt32(lastRecovery)
    buffer.encodeUInt32(lastClear)
    buffer.encodeUInt16(breachCount)
    buffer.encodeEnumValue(limitsState.value, 1)
    buffer.encodeBitmaskValue(modsEnabled.value, 1)
    buffer.encodeBitmaskValue(modsRequired.value, 1)
    buffer.encodeBitmaskValue(modsTriggered.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LimitsStatus> {
    public override val id: UInt = 167u

    public override val crcExtra: Byte = -112

    public override fun deserialize(bytes: ByteArray): LimitsStatus {
      val buffer = Buffer().write(bytes)

      val lastTrigger = buffer.decodeUInt32()
      val lastAction = buffer.decodeUInt32()
      val lastRecovery = buffer.decodeUInt32()
      val lastClear = buffer.decodeUInt32()
      val breachCount = buffer.decodeUInt16()
      val limitsState = buffer.decodeEnumValue(1).let { value ->
        val entry = LimitsState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modsEnabled = buffer.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsRequired = buffer.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsTriggered = buffer.decodeBitmaskValue(1).let { value ->
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
