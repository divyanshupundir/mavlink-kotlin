package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 *
 *         Battery information that is static, or requires infrequent update.
 *         This message should requested using MAV_CMD_REQUEST_MESSAGE and/or streamed at very low
 * rate.
 *         BATTERY_STATUS_V2 is used for higher-rate battery status information.
 *       
 *
 * @param id Battery ID
 * @param batteryFunction Function of the battery.
 * @param type Type (chemistry) of the battery.
 * @param stateOfHealth State of Health (SOH) estimate. Typically 100% at the time of manufacture
 * and will decrease over time and use. -1: field not provided.
 * units = %
 * @param cellsInSeries Number of battery cells in series. 0: field not provided.
 * @param cycleCount Lifetime count of the number of charge/discharge cycles
 * (https://en.wikipedia.org/wiki/Charge_cycle). UINT16_MAX: field not provided.
 * @param weight Battery weight. 0: field not provided.
 * units = g
 * @param dischargeMinimumVoltage Minimum per-cell voltage when discharging. 0: field not provided.
 * units = V
 * @param chargingMinimumVoltage Minimum per-cell voltage when charging. 0: field not provided.
 * units = V
 * @param restingMinimumVoltage Minimum per-cell voltage when resting. 0: field not provided.
 * units = V
 * @param chargingMaximumVoltage Maximum per-cell voltage when charged. 0: field not provided.
 * units = V
 * @param chargingMaximumCurrent Maximum pack continuous charge current. 0: field not provided.
 * units = A
 * @param nominalVoltage Battery nominal voltage. Used for conversion between Wh and Ah. 0: field
 * not provided.
 * units = V
 * @param dischargeMaximumCurrent Maximum pack discharge current. 0: field not provided.
 * units = A
 * @param dischargeMaximumBurstCurrent Maximum pack discharge burst current. 0: field not provided.
 * units = A
 * @param designCapacity Fully charged design capacity. 0: field not provided.
 * units = Ah
 * @param fullChargeCapacity Predicted battery capacity when fully charged (accounting for battery
 * degradation). NAN: field not provided.
 * units = Ah
 * @param manufactureDate Manufacture date (DDMMYYYY) in ASCII characters, 0 terminated. All 0:
 * field not provided.
 * @param serialNumber Serial number in ASCII characters, 0 terminated. All 0: field not provided.
 * @param name Battery device name. Formatted as manufacturer name then product name, separated with
 * an underscore (in ASCII characters), 0 terminated. All 0: field not provided.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 370u,
  crcExtra = 26,
)
public data class BatteryInfo(
  /**
   * Battery ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Function of the battery.
   */
  @GeneratedMavField(type = "uint8_t")
  public val batteryFunction: MavEnumValue<MavBatteryFunction> = MavEnumValue.fromValue(0u),
  /**
   * Type (chemistry) of the battery.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MavBatteryType> = MavEnumValue.fromValue(0u),
  /**
   * State of Health (SOH) estimate. Typically 100% at the time of manufacture and will decrease
   * over time and use. -1: field not provided.
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val stateOfHealth: UByte = 0u,
  /**
   * Number of battery cells in series. 0: field not provided.
   */
  @GeneratedMavField(type = "uint8_t")
  public val cellsInSeries: UByte = 0u,
  /**
   * Lifetime count of the number of charge/discharge cycles
   * (https://en.wikipedia.org/wiki/Charge_cycle). UINT16_MAX: field not provided.
   */
  @GeneratedMavField(type = "uint16_t")
  public val cycleCount: UShort = 0u,
  /**
   * Battery weight. 0: field not provided.
   * units = g
   */
  @GeneratedMavField(type = "uint16_t")
  public val weight: UShort = 0u,
  /**
   * Minimum per-cell voltage when discharging. 0: field not provided.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val dischargeMinimumVoltage: Float = 0F,
  /**
   * Minimum per-cell voltage when charging. 0: field not provided.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val chargingMinimumVoltage: Float = 0F,
  /**
   * Minimum per-cell voltage when resting. 0: field not provided.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val restingMinimumVoltage: Float = 0F,
  /**
   * Maximum per-cell voltage when charged. 0: field not provided.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val chargingMaximumVoltage: Float = 0F,
  /**
   * Maximum pack continuous charge current. 0: field not provided.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val chargingMaximumCurrent: Float = 0F,
  /**
   * Battery nominal voltage. Used for conversion between Wh and Ah. 0: field not provided.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val nominalVoltage: Float = 0F,
  /**
   * Maximum pack discharge current. 0: field not provided.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val dischargeMaximumCurrent: Float = 0F,
  /**
   * Maximum pack discharge burst current. 0: field not provided.
   * units = A
   */
  @GeneratedMavField(type = "float")
  public val dischargeMaximumBurstCurrent: Float = 0F,
  /**
   * Fully charged design capacity. 0: field not provided.
   * units = Ah
   */
  @GeneratedMavField(type = "float")
  public val designCapacity: Float = 0F,
  /**
   * Predicted battery capacity when fully charged (accounting for battery degradation). NAN: field
   * not provided.
   * units = Ah
   */
  @GeneratedMavField(type = "float")
  public val fullChargeCapacity: Float = 0F,
  /**
   * Manufacture date (DDMMYYYY) in ASCII characters, 0 terminated. All 0: field not provided.
   */
  @GeneratedMavField(type = "char[9]")
  public val manufactureDate: String = "",
  /**
   * Serial number in ASCII characters, 0 terminated. All 0: field not provided.
   */
  @GeneratedMavField(type = "char[32]")
  public val serialNumber: String = "",
  /**
   * Battery device name. Formatted as manufacturer name then product name, separated with an
   * underscore (in ASCII characters), 0 terminated. All 0: field not provided.
   */
  @GeneratedMavField(type = "char[50]")
  public val name: String = "",
) : MavMessage<BatteryInfo> {
  override val instanceCompanion: MavMessage.MavCompanion<BatteryInfo> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(dischargeMinimumVoltage)
    encoder.encodeFloat(chargingMinimumVoltage)
    encoder.encodeFloat(restingMinimumVoltage)
    encoder.encodeFloat(chargingMaximumVoltage)
    encoder.encodeFloat(chargingMaximumCurrent)
    encoder.encodeFloat(nominalVoltage)
    encoder.encodeFloat(dischargeMaximumCurrent)
    encoder.encodeFloat(dischargeMaximumBurstCurrent)
    encoder.encodeFloat(designCapacity)
    encoder.encodeFloat(fullChargeCapacity)
    encoder.encodeUInt16(cycleCount)
    encoder.encodeUInt16(weight)
    encoder.encodeUInt8(id)
    encoder.encodeEnumValue(batteryFunction.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(stateOfHealth)
    encoder.encodeUInt8(cellsInSeries)
    encoder.encodeString(manufactureDate, 9)
    encoder.encodeString(serialNumber, 32)
    encoder.encodeString(name, 50)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(dischargeMinimumVoltage)
    encoder.encodeFloat(chargingMinimumVoltage)
    encoder.encodeFloat(restingMinimumVoltage)
    encoder.encodeFloat(chargingMaximumVoltage)
    encoder.encodeFloat(chargingMaximumCurrent)
    encoder.encodeFloat(nominalVoltage)
    encoder.encodeFloat(dischargeMaximumCurrent)
    encoder.encodeFloat(dischargeMaximumBurstCurrent)
    encoder.encodeFloat(designCapacity)
    encoder.encodeFloat(fullChargeCapacity)
    encoder.encodeUInt16(cycleCount)
    encoder.encodeUInt16(weight)
    encoder.encodeUInt8(id)
    encoder.encodeEnumValue(batteryFunction.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(stateOfHealth)
    encoder.encodeUInt8(cellsInSeries)
    encoder.encodeString(manufactureDate, 9)
    encoder.encodeString(serialNumber, 32)
    encoder.encodeString(name, 50)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<BatteryInfo> {
    private const val SIZE_V1: Int = 140

    private const val SIZE_V2: Int = 140

    override val id: UInt = 370u

    override val crcExtra: Byte = 26

    override fun deserialize(bytes: ByteArray): BatteryInfo {
      val decoder = MavDataDecoder(bytes)

      val dischargeMinimumVoltage = decoder.safeDecodeFloat()
      val chargingMinimumVoltage = decoder.safeDecodeFloat()
      val restingMinimumVoltage = decoder.safeDecodeFloat()
      val chargingMaximumVoltage = decoder.safeDecodeFloat()
      val chargingMaximumCurrent = decoder.safeDecodeFloat()
      val nominalVoltage = decoder.safeDecodeFloat()
      val dischargeMaximumCurrent = decoder.safeDecodeFloat()
      val dischargeMaximumBurstCurrent = decoder.safeDecodeFloat()
      val designCapacity = decoder.safeDecodeFloat()
      val fullChargeCapacity = decoder.safeDecodeFloat()
      val cycleCount = decoder.safeDecodeUInt16()
      val weight = decoder.safeDecodeUInt16()
      val id = decoder.safeDecodeUInt8()
      val batteryFunction = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavBatteryFunction.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavBatteryType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val stateOfHealth = decoder.safeDecodeUInt8()
      val cellsInSeries = decoder.safeDecodeUInt8()
      val manufactureDate = decoder.safeDecodeString(9)
      val serialNumber = decoder.safeDecodeString(32)
      val name = decoder.safeDecodeString(50)

      return BatteryInfo(
        id = id,
        batteryFunction = batteryFunction,
        type = type,
        stateOfHealth = stateOfHealth,
        cellsInSeries = cellsInSeries,
        cycleCount = cycleCount,
        weight = weight,
        dischargeMinimumVoltage = dischargeMinimumVoltage,
        chargingMinimumVoltage = chargingMinimumVoltage,
        restingMinimumVoltage = restingMinimumVoltage,
        chargingMaximumVoltage = chargingMaximumVoltage,
        chargingMaximumCurrent = chargingMaximumCurrent,
        nominalVoltage = nominalVoltage,
        dischargeMaximumCurrent = dischargeMaximumCurrent,
        dischargeMaximumBurstCurrent = dischargeMaximumBurstCurrent,
        designCapacity = designCapacity,
        fullChargeCapacity = fullChargeCapacity,
        manufactureDate = manufactureDate,
        serialNumber = serialNumber,
        name = name,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): BatteryInfo =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var batteryFunction: MavEnumValue<MavBatteryFunction> = MavEnumValue.fromValue(0u)

    public var type: MavEnumValue<MavBatteryType> = MavEnumValue.fromValue(0u)

    public var stateOfHealth: UByte = 0u

    public var cellsInSeries: UByte = 0u

    public var cycleCount: UShort = 0u

    public var weight: UShort = 0u

    public var dischargeMinimumVoltage: Float = 0F

    public var chargingMinimumVoltage: Float = 0F

    public var restingMinimumVoltage: Float = 0F

    public var chargingMaximumVoltage: Float = 0F

    public var chargingMaximumCurrent: Float = 0F

    public var nominalVoltage: Float = 0F

    public var dischargeMaximumCurrent: Float = 0F

    public var dischargeMaximumBurstCurrent: Float = 0F

    public var designCapacity: Float = 0F

    public var fullChargeCapacity: Float = 0F

    public var manufactureDate: String = ""

    public var serialNumber: String = ""

    public var name: String = ""

    public fun build(): BatteryInfo = BatteryInfo(
      id = id,
      batteryFunction = batteryFunction,
      type = type,
      stateOfHealth = stateOfHealth,
      cellsInSeries = cellsInSeries,
      cycleCount = cycleCount,
      weight = weight,
      dischargeMinimumVoltage = dischargeMinimumVoltage,
      chargingMinimumVoltage = chargingMinimumVoltage,
      restingMinimumVoltage = restingMinimumVoltage,
      chargingMaximumVoltage = chargingMaximumVoltage,
      chargingMaximumCurrent = chargingMaximumCurrent,
      nominalVoltage = nominalVoltage,
      dischargeMaximumCurrent = dischargeMaximumCurrent,
      dischargeMaximumBurstCurrent = dischargeMaximumBurstCurrent,
      designCapacity = designCapacity,
      fullChargeCapacity = fullChargeCapacity,
      manufactureDate = manufactureDate,
      serialNumber = serialNumber,
      name = name,
    )
  }
}
