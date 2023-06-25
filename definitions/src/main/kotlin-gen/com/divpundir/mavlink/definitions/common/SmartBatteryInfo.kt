package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Smart Battery information (static/infrequent update). Use for updates from: smart battery to
 * flight stack, flight stack to GCS. Use BATTERY_STATUS for smart battery frequent updates.
 */
@GeneratedMavMessage(
  id = 370u,
  crcExtra = 75,
)
public data class SmartBatteryInfo(
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
   * Capacity when full according to manufacturer, -1: field not provided.
   */
  @GeneratedMavField(type = "int32_t")
  public val capacityFullSpecification: Int = 0,
  /**
   * Capacity when full (accounting for battery degradation), -1: field not provided.
   */
  @GeneratedMavField(type = "int32_t")
  public val capacityFull: Int = 0,
  /**
   * Charge/discharge cycle count. UINT16_MAX: field not provided.
   */
  @GeneratedMavField(type = "uint16_t")
  public val cycleCount: UShort = 0u,
  /**
   * Serial number in ASCII characters, 0 terminated. All 0: field not provided.
   */
  @GeneratedMavField(type = "char[16]")
  public val serialNumber: String = "",
  /**
   * Static device name in ASCII characters, 0 terminated. All 0: field not provided. Encode as
   * manufacturer name then product name separated using an underscore.
   */
  @GeneratedMavField(type = "char[50]")
  public val deviceName: String = "",
  /**
   * Battery weight. 0: field not provided.
   */
  @GeneratedMavField(type = "uint16_t")
  public val weight: UShort = 0u,
  /**
   * Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val dischargeMinimumVoltage: UShort = 0u,
  /**
   * Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val chargingMinimumVoltage: UShort = 0u,
  /**
   * Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value.
   */
  @GeneratedMavField(type = "uint16_t")
  public val restingMinimumVoltage: UShort = 0u,
  /**
   * Maximum per-cell voltage when charged. 0: field not provided.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val chargingMaximumVoltage: UShort = 0u,
  /**
   * Number of battery cells in series. 0: field not provided.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val cellsInSeries: UByte = 0u,
  /**
   * Maximum pack discharge current. 0: field not provided.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val dischargeMaximumCurrent: UInt = 0u,
  /**
   * Maximum pack discharge burst current. 0: field not provided.
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val dischargeMaximumBurstCurrent: UInt = 0u,
  /**
   * Manufacture date (DD/MM/YYYY) in ASCII characters, 0 terminated. All 0: field not provided.
   */
  @GeneratedMavField(
    type = "char[11]",
    extension = true,
  )
  public val manufactureDate: String = "",
) : MavMessage<SmartBatteryInfo> {
  public override val instanceCompanion: MavMessage.MavCompanion<SmartBatteryInfo> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(capacityFullSpecification)
    buffer.encodeInt32(capacityFull)
    buffer.encodeUInt16(cycleCount)
    buffer.encodeUInt16(weight)
    buffer.encodeUInt16(dischargeMinimumVoltage)
    buffer.encodeUInt16(chargingMinimumVoltage)
    buffer.encodeUInt16(restingMinimumVoltage)
    buffer.encodeUInt8(id)
    buffer.encodeEnumValue(batteryFunction.value, 1)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeString(serialNumber, 16)
    buffer.encodeString(deviceName, 50)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(capacityFullSpecification)
    buffer.encodeInt32(capacityFull)
    buffer.encodeUInt16(cycleCount)
    buffer.encodeUInt16(weight)
    buffer.encodeUInt16(dischargeMinimumVoltage)
    buffer.encodeUInt16(chargingMinimumVoltage)
    buffer.encodeUInt16(restingMinimumVoltage)
    buffer.encodeUInt8(id)
    buffer.encodeEnumValue(batteryFunction.value, 1)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeString(serialNumber, 16)
    buffer.encodeString(deviceName, 50)
    buffer.encodeUInt16(chargingMaximumVoltage)
    buffer.encodeUInt8(cellsInSeries)
    buffer.encodeUInt32(dischargeMaximumCurrent)
    buffer.encodeUInt32(dischargeMaximumBurstCurrent)
    buffer.encodeString(manufactureDate, 11)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SmartBatteryInfo> {
    public override val id: UInt = 370u

    public override val crcExtra: Byte = 75

    public override fun deserialize(bytes: ByteArray): SmartBatteryInfo {
      val buffer = Buffer().write(bytes)

      val capacityFullSpecification = buffer.decodeInt32()
      val capacityFull = buffer.decodeInt32()
      val cycleCount = buffer.decodeUInt16()
      val weight = buffer.decodeUInt16()
      val dischargeMinimumVoltage = buffer.decodeUInt16()
      val chargingMinimumVoltage = buffer.decodeUInt16()
      val restingMinimumVoltage = buffer.decodeUInt16()
      val id = buffer.decodeUInt8()
      val batteryFunction = buffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryFunction.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = buffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val serialNumber = buffer.decodeString(16)
      val deviceName = buffer.decodeString(50)
      val chargingMaximumVoltage = buffer.decodeUInt16()
      val cellsInSeries = buffer.decodeUInt8()
      val dischargeMaximumCurrent = buffer.decodeUInt32()
      val dischargeMaximumBurstCurrent = buffer.decodeUInt32()
      val manufactureDate = buffer.decodeString(11)

      return SmartBatteryInfo(
        id = id,
        batteryFunction = batteryFunction,
        type = type,
        capacityFullSpecification = capacityFullSpecification,
        capacityFull = capacityFull,
        cycleCount = cycleCount,
        serialNumber = serialNumber,
        deviceName = deviceName,
        weight = weight,
        dischargeMinimumVoltage = dischargeMinimumVoltage,
        chargingMinimumVoltage = chargingMinimumVoltage,
        restingMinimumVoltage = restingMinimumVoltage,
        chargingMaximumVoltage = chargingMaximumVoltage,
        cellsInSeries = cellsInSeries,
        dischargeMaximumCurrent = dischargeMaximumCurrent,
        dischargeMaximumBurstCurrent = dischargeMaximumBurstCurrent,
        manufactureDate = manufactureDate,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SmartBatteryInfo =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var batteryFunction: MavEnumValue<MavBatteryFunction> = MavEnumValue.fromValue(0u)

    public var type: MavEnumValue<MavBatteryType> = MavEnumValue.fromValue(0u)

    public var capacityFullSpecification: Int = 0

    public var capacityFull: Int = 0

    public var cycleCount: UShort = 0u

    public var serialNumber: String = ""

    public var deviceName: String = ""

    public var weight: UShort = 0u

    public var dischargeMinimumVoltage: UShort = 0u

    public var chargingMinimumVoltage: UShort = 0u

    public var restingMinimumVoltage: UShort = 0u

    public var chargingMaximumVoltage: UShort = 0u

    public var cellsInSeries: UByte = 0u

    public var dischargeMaximumCurrent: UInt = 0u

    public var dischargeMaximumBurstCurrent: UInt = 0u

    public var manufactureDate: String = ""

    public fun build(): SmartBatteryInfo = SmartBatteryInfo(
      id = id,
      batteryFunction = batteryFunction,
      type = type,
      capacityFullSpecification = capacityFullSpecification,
      capacityFull = capacityFull,
      cycleCount = cycleCount,
      serialNumber = serialNumber,
      deviceName = deviceName,
      weight = weight,
      dischargeMinimumVoltage = dischargeMinimumVoltage,
      chargingMinimumVoltage = chargingMinimumVoltage,
      restingMinimumVoltage = restingMinimumVoltage,
      chargingMaximumVoltage = chargingMaximumVoltage,
      cellsInSeries = cellsInSeries,
      dischargeMaximumCurrent = dischargeMaximumCurrent,
      dischargeMaximumBurstCurrent = dischargeMaximumBurstCurrent,
      manufactureDate = manufactureDate,
    )
  }
}
