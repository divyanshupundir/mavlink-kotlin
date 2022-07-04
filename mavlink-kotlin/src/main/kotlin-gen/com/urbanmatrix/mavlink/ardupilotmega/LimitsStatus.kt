package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Status of AP_Limits. Sent in extended status stream when AP_Limits is enabled.
 */
public data class LimitsStatus(
  /**
   * State of AP_Limits.
   */
  public val limitsState: MavEnumValue<LimitsState> = MavEnumValue.fromValue(0),
  /**
   * Time (since boot) of last breach.
   */
  public val lastTrigger: Long = 0L,
  /**
   * Time (since boot) of last recovery action.
   */
  public val lastAction: Long = 0L,
  /**
   * Time (since boot) of last successful recovery.
   */
  public val lastRecovery: Long = 0L,
  /**
   * Time (since boot) of last all-clear.
   */
  public val lastClear: Long = 0L,
  /**
   * Number of fence breaches.
   */
  public val breachCount: Int = 0,
  /**
   * AP_Limit_Module bitfield of enabled modules.
   */
  public val modsEnabled: MavEnumValue<LimitModule> = MavEnumValue.fromValue(0),
  /**
   * AP_Limit_Module bitfield of required modules.
   */
  public val modsRequired: MavEnumValue<LimitModule> = MavEnumValue.fromValue(0),
  /**
   * AP_Limit_Module bitfield of triggered modules.
   */
  public val modsTriggered: MavEnumValue<LimitModule> = MavEnumValue.fromValue(0),
) : MavMessage<LimitsStatus> {
  public override val instanceMetadata: MavMessage.Metadata<LimitsStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(lastTrigger)
    outputBuffer.encodeUint32(lastAction)
    outputBuffer.encodeUint32(lastRecovery)
    outputBuffer.encodeUint32(lastClear)
    outputBuffer.encodeUint16(breachCount)
    outputBuffer.encodeEnumValue(limitsState.value, 1)
    outputBuffer.encodeEnumValue(modsEnabled.value, 1)
    outputBuffer.encodeEnumValue(modsRequired.value, 1)
    outputBuffer.encodeEnumValue(modsTriggered.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 167

    private const val CRC: Int = 144

    private const val SIZE: Int = 22

    private val DESERIALIZER: MavDeserializer<LimitsStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for LimitsStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
      val modsEnabled = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = LimitModule.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modsRequired = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = LimitModule.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val modsTriggered = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = LimitModule.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
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
  }
}
