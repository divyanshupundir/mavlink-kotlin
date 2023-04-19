package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<LimitsStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(lastTrigger)
    outputBuffer.encodeUInt32(lastAction)
    outputBuffer.encodeUInt32(lastRecovery)
    outputBuffer.encodeUInt32(lastClear)
    outputBuffer.encodeUInt16(breachCount)
    outputBuffer.encodeEnumValue(limitsState.value, 1)
    outputBuffer.encodeBitmaskValue(modsEnabled.value, 1)
    outputBuffer.encodeBitmaskValue(modsRequired.value, 1)
    outputBuffer.encodeBitmaskValue(modsTriggered.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(lastTrigger)
    outputBuffer.encodeUInt32(lastAction)
    outputBuffer.encodeUInt32(lastRecovery)
    outputBuffer.encodeUInt32(lastClear)
    outputBuffer.encodeUInt16(breachCount)
    outputBuffer.encodeEnumValue(limitsState.value, 1)
    outputBuffer.encodeBitmaskValue(modsEnabled.value, 1)
    outputBuffer.encodeBitmaskValue(modsRequired.value, 1)
    outputBuffer.encodeBitmaskValue(modsTriggered.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 167u

    private const val CRC_EXTRA: Byte = -112

    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    private val DESERIALIZER: MavDeserializer<LimitsStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lastTrigger = inputBuffer.decodeUInt32()
      val lastAction = inputBuffer.decodeUInt32()
      val lastRecovery = inputBuffer.decodeUInt32()
      val lastClear = inputBuffer.decodeUInt32()
      val breachCount = inputBuffer.decodeUInt16()
      val limitsState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = LimitsState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modsEnabled = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsRequired = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val modsTriggered = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = LimitModule.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      LimitsStatus(
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


    private val METADATA: MavMessage.Metadata<LimitsStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LimitsStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LimitsStatus =
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
