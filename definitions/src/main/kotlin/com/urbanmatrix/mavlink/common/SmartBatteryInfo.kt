package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Smart Battery information (static/infrequent update). Use for updates from: smart battery to
 * flight stack, flight stack to GCS. Use BATTERY_STATUS for smart battery frequent updates.
 */
public data class SmartBatteryInfo(
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
   * Capacity when full according to manufacturer, -1: field not provided.
   */
  public val capacityFullSpecification: Int = 0,
  /**
   * Capacity when full (accounting for battery degradation), -1: field not provided.
   */
  public val capacityFull: Int = 0,
  /**
   * Charge/discharge cycle count. UINT16_MAX: field not provided.
   */
  public val cycleCount: Int = 0,
  /**
   * Serial number in ASCII characters, 0 terminated. All 0: field not provided.
   */
  public val serialNumber: String = "",
  /**
   * Static device name in ASCII characters, 0 terminated. All 0: field not provided. Encode as
   * manufacturer name then product name separated using an underscore.
   */
  public val deviceName: String = "",
  /**
   * Battery weight. 0: field not provided.
   */
  public val weight: Int = 0,
  /**
   * Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value.
   */
  public val dischargeMinimumVoltage: Int = 0,
  /**
   * Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value.
   */
  public val chargingMinimumVoltage: Int = 0,
  /**
   * Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value.
   */
  public val restingMinimumVoltage: Int = 0,
  /**
   * Maximum per-cell voltage when charged. 0: field not provided.
   */
  public val chargingMaximumVoltage: Int = 0,
  /**
   * Number of battery cells in series. 0: field not provided.
   */
  public val cellsInSeries: Int = 0,
  /**
   * Maximum pack discharge current. 0: field not provided.
   */
  public val dischargeMaximumCurrent: Long = 0L,
  /**
   * Maximum pack discharge burst current. 0: field not provided.
   */
  public val dischargeMaximumBurstCurrent: Long = 0L,
  /**
   * Manufacture date (DD/MM/YYYY) in ASCII characters, 0 terminated. All 0: field not provided.
   */
  public val manufactureDate: String = "",
) : MavMessage<SmartBatteryInfo> {
  public override val instanceMetadata: MavMessage.Metadata<SmartBatteryInfo> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(capacityFullSpecification)
    outputBuffer.encodeInt32(capacityFull)
    outputBuffer.encodeUint16(cycleCount)
    outputBuffer.encodeUint16(weight)
    outputBuffer.encodeUint16(dischargeMinimumVoltage)
    outputBuffer.encodeUint16(chargingMinimumVoltage)
    outputBuffer.encodeUint16(restingMinimumVoltage)
    outputBuffer.encodeUint8(id)
    outputBuffer.encodeEnumValue(batteryFunction.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeString(serialNumber, 16)
    outputBuffer.encodeString(deviceName, 50)
    outputBuffer.encodeUint16(chargingMaximumVoltage)
    outputBuffer.encodeUint8(cellsInSeries)
    outputBuffer.encodeUint32(dischargeMaximumCurrent)
    outputBuffer.encodeUint32(dischargeMaximumBurstCurrent)
    outputBuffer.encodeString(manufactureDate, 11)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 370

    private const val CRC: Int = 91

    private const val SIZE: Int = 109

    private val DESERIALIZER: MavDeserializer<SmartBatteryInfo> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for SmartBatteryInfo: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val capacityFullSpecification = inputBuffer.decodeInt32()
      val capacityFull = inputBuffer.decodeInt32()
      val cycleCount = inputBuffer.decodeUint16()
      val weight = inputBuffer.decodeUint16()
      val dischargeMinimumVoltage = inputBuffer.decodeUint16()
      val chargingMinimumVoltage = inputBuffer.decodeUint16()
      val restingMinimumVoltage = inputBuffer.decodeUint16()
      val id = inputBuffer.decodeUint8()
      val batteryFunction = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryFunction.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavBatteryType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val serialNumber = inputBuffer.decodeString(16)
      val deviceName = inputBuffer.decodeString(50)
      val chargingMaximumVoltage = inputBuffer.decodeUint16()
      val cellsInSeries = inputBuffer.decodeUint8()
      val dischargeMaximumCurrent = inputBuffer.decodeUint32()
      val dischargeMaximumBurstCurrent = inputBuffer.decodeUint32()
      val manufactureDate = inputBuffer.decodeString(11)

      SmartBatteryInfo(
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


    private val METADATA: MavMessage.Metadata<SmartBatteryInfo> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SmartBatteryInfo> = METADATA
  }
}
