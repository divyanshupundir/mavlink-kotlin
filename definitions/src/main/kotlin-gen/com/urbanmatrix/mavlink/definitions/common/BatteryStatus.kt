package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.decodeUint16Array
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeInt8
import com.urbanmatrix.mavlink.serialization.encodeUint16Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Battery information. Updates GCS with flight controller battery status. Smart batteries also use
 * this message, but may additionally send SMART_BATTERY_INFO.
 */
public data class BatteryStatus(
  /**
   * Battery ID
   */
  public val id: Int = 0,
  /**
   * Function of the battery
   */
  public val batteryFunction: MavEnumValue<MavBatteryFunction> = MavEnumValue.fromValue(0),
  /**
   * Type (chemistry) of the battery
   */
  public val type: MavEnumValue<MavBatteryType> = MavEnumValue.fromValue(0),
  /**
   * Temperature of the battery. INT16_MAX for unknown temperature.
   */
  public val temperature: Int = 0,
  /**
   * Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above
   * the valid cell count for this battery should have the UINT16_MAX value. If individual cell
   * voltages are unknown or not measured for this battery, then the overall battery voltage should be
   * filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than
   * (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining
   * voltage. This can be extended to multiple cells if the total voltage is greater than 2 *
   * (UINT16_MAX - 1).
   */
  public val voltages: List<Int> = emptyList(),
  /**
   * Battery current, -1: autopilot does not measure the current
   */
  public val currentBattery: Int = 0,
  /**
   * Consumed charge, -1: autopilot does not provide consumption estimate
   */
  public val currentConsumed: Int = 0,
  /**
   * Consumed energy, -1: autopilot does not provide energy consumption estimate
   */
  public val energyConsumed: Int = 0,
  /**
   * Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining
   * battery.
   */
  public val batteryRemaining: Int = 0,
  /**
   * Remaining battery time, 0: autopilot does not provide remaining battery time estimate
   */
  public val timeRemaining: Int = 0,
  /**
   * State for extent of discharge, provided by autopilot for warning or external reactions
   */
  public val chargeState: MavEnumValue<MavBatteryChargeState> = MavEnumValue.fromValue(0),
  /**
   * Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should
   * have a value of 0, where zero indicates not supported (note, this is different than for the
   * voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be sent
   * instead.
   */
  public val voltagesExt: List<Int> = emptyList(),
  /**
   * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in
   * normal-use mode.
   */
  public val mode: MavEnumValue<MavBatteryMode> = MavEnumValue.fromValue(0),
  /**
   * Fault/health indications. These should be set when charge_state is
   * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault reporting is
   * not supported).
   */
  public val faultBitmask: MavEnumValue<MavBatteryFault> = MavEnumValue.fromValue(0),
) : MavMessage<BatteryStatus> {
  public override val instanceMetadata: MavMessage.Metadata<BatteryStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(currentConsumed)
    outputBuffer.encodeInt32(energyConsumed)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUint16Array(voltages, 20)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeEnumValue(batteryFunction.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeInt8(batteryRemaining)
    outputBuffer.encodeInt32(timeRemaining)
    outputBuffer.encodeEnumValue(chargeState.value, 1)
    outputBuffer.encodeUint16Array(voltagesExt, 8)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeEnumValue(faultBitmask.value, 4)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 147

    private const val CRC: Int = 154

    private const val SIZE: Int = 54

    private val DESERIALIZER: MavDeserializer<BatteryStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val currentConsumed = inputBuffer.decodeInt32()
      val energyConsumed = inputBuffer.decodeInt32()
      val temperature = inputBuffer.decodeInt16()
      val voltages = inputBuffer.decodeUint16Array(20)
      val currentBattery = inputBuffer.decodeInt16()
      val id = inputBuffer.decodeUint8()
      val batteryFunction = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryFunction.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val batteryRemaining = inputBuffer.decodeInt8()
      val timeRemaining = inputBuffer.decodeInt32()
      val chargeState = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryChargeState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val voltagesExt = inputBuffer.decodeUint16Array(8)
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val faultBitmask = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavBatteryFault.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      BatteryStatus(
        id = id,
        batteryFunction = batteryFunction,
        type = type,
        temperature = temperature,
        voltages = voltages,
        currentBattery = currentBattery,
        currentConsumed = currentConsumed,
        energyConsumed = energyConsumed,
        batteryRemaining = batteryRemaining,
        timeRemaining = timeRemaining,
        chargeState = chargeState,
        voltagesExt = voltagesExt,
        mode = mode,
        faultBitmask = faultBitmask,
      )
    }


    private val METADATA: MavMessage.Metadata<BatteryStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<BatteryStatus> = METADATA
  }
}
