package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Battery information. Updates GCS with flight controller battery status. Smart batteries also use
 * this message, but may additionally send SMART_BATTERY_INFO.
 */
@GeneratedMavMessage(
  id = 147u,
  crcExtra = -102,
)
public data class BatteryStatus(
  /**
   * Battery ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Function of the battery
   */
  @GeneratedMavField(type = "uint8_t")
  public val batteryFunction: MavEnumValue<MavBatteryFunction> = MavEnumValue.fromValue(0u),
  /**
   * Type (chemistry) of the battery
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavBatteryType> = MavEnumValue.fromValue(0u),
  /**
   * Temperature of the battery. INT16_MAX for unknown temperature.
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above
   * the valid cell count for this battery should have the UINT16_MAX value. If individual cell
   * voltages are unknown or not measured for this battery, then the overall battery voltage should be
   * filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than
   * (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining
   * voltage. This can be extended to multiple cells if the total voltage is greater than 2 *
   * (UINT16_MAX - 1).
   */
  @GeneratedMavField(type = "uint16_t[10]")
  public val voltages: List<UShort> = emptyList(),
  /**
   * Battery current, -1: autopilot does not measure the current
   */
  @GeneratedMavField(type = "int16_t")
  public val currentBattery: Short = 0,
  /**
   * Consumed charge, -1: autopilot does not provide consumption estimate
   */
  @GeneratedMavField(type = "int32_t")
  public val currentConsumed: Int = 0,
  /**
   * Consumed energy, -1: autopilot does not provide energy consumption estimate
   */
  @GeneratedMavField(type = "int32_t")
  public val energyConsumed: Int = 0,
  /**
   * Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining
   * battery.
   */
  @GeneratedMavField(type = "int8_t")
  public val batteryRemaining: Byte = 0,
  /**
   * Remaining battery time, 0: autopilot does not provide remaining battery time estimate
   */
  @GeneratedMavField(
    type = "int32_t",
    extension = true,
  )
  public val timeRemaining: Int = 0,
  /**
   * State for extent of discharge, provided by autopilot for warning or external reactions
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val chargeState: MavEnumValue<MavBatteryChargeState> = MavEnumValue.fromValue(0u),
  /**
   * Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should
   * have a value of 0, where zero indicates not supported (note, this is different than for the
   * voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be sent
   * instead.
   */
  @GeneratedMavField(
    type = "uint16_t[4]",
    extension = true,
  )
  public val voltagesExt: List<UShort> = emptyList(),
  /**
   * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in
   * normal-use mode.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val mode: MavEnumValue<MavBatteryMode> = MavEnumValue.fromValue(0u),
  /**
   * Fault/health indications. These should be set when charge_state is
   * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault reporting is
   * not supported).
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val faultBitmask: MavBitmaskValue<MavBatteryFault> = MavBitmaskValue.fromValue(0u),
) : MavMessage<BatteryStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<BatteryStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(currentConsumed)
    outputBuffer.encodeInt32(energyConsumed)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUInt16Array(voltages, 20)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeEnumValue(batteryFunction.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeInt8(batteryRemaining)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(currentConsumed)
    outputBuffer.encodeInt32(energyConsumed)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUInt16Array(voltages, 20)
    outputBuffer.encodeInt16(currentBattery)
    outputBuffer.encodeUInt8(id)
    outputBuffer.encodeEnumValue(batteryFunction.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeInt8(batteryRemaining)
    outputBuffer.encodeInt32(timeRemaining)
    outputBuffer.encodeEnumValue(chargeState.value, 1)
    outputBuffer.encodeUInt16Array(voltagesExt, 8)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeBitmaskValue(faultBitmask.value, 4)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<BatteryStatus> {
    private const val SIZE_V1: Int = 36

    private const val SIZE_V2: Int = 54

    public override val id: UInt = 147u

    public override val crcExtra: Byte = -102

    public override fun deserialize(bytes: ByteArray): BatteryStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val currentConsumed = inputBuffer.decodeInt32()
      val energyConsumed = inputBuffer.decodeInt32()
      val temperature = inputBuffer.decodeInt16()
      val voltages = inputBuffer.decodeUInt16Array(20)
      val currentBattery = inputBuffer.decodeInt16()
      val id = inputBuffer.decodeUInt8()
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
      val voltagesExt = inputBuffer.decodeUInt16Array(8)
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val faultBitmask = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = MavBatteryFault.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return BatteryStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): BatteryStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var batteryFunction: MavEnumValue<MavBatteryFunction> = MavEnumValue.fromValue(0u)

    public var type: MavEnumValue<MavBatteryType> = MavEnumValue.fromValue(0u)

    public var temperature: Short = 0

    public var voltages: List<UShort> = emptyList()

    public var currentBattery: Short = 0

    public var currentConsumed: Int = 0

    public var energyConsumed: Int = 0

    public var batteryRemaining: Byte = 0

    public var timeRemaining: Int = 0

    public var chargeState: MavEnumValue<MavBatteryChargeState> = MavEnumValue.fromValue(0u)

    public var voltagesExt: List<UShort> = emptyList()

    public var mode: MavEnumValue<MavBatteryMode> = MavEnumValue.fromValue(0u)

    public var faultBitmask: MavBitmaskValue<MavBatteryFault> = MavBitmaskValue.fromValue(0u)

    public fun build(): BatteryStatus = BatteryStatus(
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
}
