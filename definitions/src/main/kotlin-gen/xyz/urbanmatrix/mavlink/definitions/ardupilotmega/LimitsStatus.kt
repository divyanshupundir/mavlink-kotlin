package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled.
 */
@GeneratedMavMessage(
  id = 167,
  crc = 144,
)
public data class LimitsStatus(
  /**
   * State of AP_Limits.
   */
  @GeneratedMavField(type = "uint8_t")
  public val limitsState: MavEnumValue<LimitsState> = MavEnumValue.fromValue(0),
  /**
   * Time (since boot) of last breach.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastTrigger: Long = 0L,
  /**
   * Time (since boot) of last recovery action.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastAction: Long = 0L,
  /**
   * Time (since boot) of last successful recovery.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastRecovery: Long = 0L,
  /**
   * Time (since boot) of last all-clear.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastClear: Long = 0L,
  /**
   * Number of fence breaches.
   */
  @GeneratedMavField(type = "uint16_t")
  public val breachCount: Int = 0,
  /**
   * AP_Limit_Module bitfield of enabled modules.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modsEnabled: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0),
  /**
   * AP_Limit_Module bitfield of required modules.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modsRequired: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0),
  /**
   * AP_Limit_Module bitfield of triggered modules.
   */
  @GeneratedMavField(type = "uint8_t")
  public val modsTriggered: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0),
) : MavMessage<LimitsStatus> {
  public override val instanceMetadata: MavMessage.Metadata<LimitsStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(lastTrigger)
    outputBuffer.encodeUint32(lastAction)
    outputBuffer.encodeUint32(lastRecovery)
    outputBuffer.encodeUint32(lastClear)
    outputBuffer.encodeUint16(breachCount)
    outputBuffer.encodeEnumValue(limitsState.value, 1)
    outputBuffer.encodeBitmaskValue(modsEnabled.value, 1)
    outputBuffer.encodeBitmaskValue(modsRequired.value, 1)
    outputBuffer.encodeBitmaskValue(modsTriggered.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(lastTrigger)
    outputBuffer.encodeUint32(lastAction)
    outputBuffer.encodeUint32(lastRecovery)
    outputBuffer.encodeUint32(lastClear)
    outputBuffer.encodeUint16(breachCount)
    outputBuffer.encodeEnumValue(limitsState.value, 1)
    outputBuffer.encodeBitmaskValue(modsEnabled.value, 1)
    outputBuffer.encodeBitmaskValue(modsRequired.value, 1)
    outputBuffer.encodeBitmaskValue(modsTriggered.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 167

    private const val CRC: Int = 144

    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    private val DESERIALIZER: MavDeserializer<LimitsStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lastTrigger = inputBuffer.decodeUint32()
      val lastAction = inputBuffer.decodeUint32()
      val lastRecovery = inputBuffer.decodeUint32()
      val lastClear = inputBuffer.decodeUint32()
      val breachCount = inputBuffer.decodeUint16()
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


    private val METADATA: MavMessage.Metadata<LimitsStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LimitsStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var limitsState: MavEnumValue<LimitsState> = MavEnumValue.fromValue(0)

    public var lastTrigger: Long = 0L

    public var lastAction: Long = 0L

    public var lastRecovery: Long = 0L

    public var lastClear: Long = 0L

    public var breachCount: Int = 0

    public var modsEnabled: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0)

    public var modsRequired: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0)

    public var modsTriggered: MavBitmaskValue<LimitModule> = MavBitmaskValue.fromValue(0)

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
