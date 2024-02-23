package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Battery pack monitoring data for Li-Ion batteries
 *
 * @param batmonTimestamp Time since system start
 * units = us
 * @param temperature Battery pack temperature
 * units = degC
 * @param voltage Battery pack voltage
 * units = mV
 * @param current Battery pack current
 * units = mA
 * @param soc Battery pack state-of-charge
 * @param batterystatus Battery monitor status report bits in Hex
 * @param serialnumber Battery monitor serial number in Hex
 * @param safetystatus Battery monitor safetystatus report bits in Hex
 * @param operationstatus Battery monitor operation status report bits in Hex
 * @param cellvoltage1 Battery pack cell 1 voltage
 * units = mV
 * @param cellvoltage2 Battery pack cell 2 voltage
 * units = mV
 * @param cellvoltage3 Battery pack cell 3 voltage
 * units = mV
 * @param cellvoltage4 Battery pack cell 4 voltage
 * units = mV
 * @param cellvoltage5 Battery pack cell 5 voltage
 * units = mV
 * @param cellvoltage6 Battery pack cell 6 voltage
 * units = mV
 */
@GeneratedMavMessage(
  id = 8_010u,
  crcExtra = -101,
)
public data class SensBatmon(
  /**
   * Time since system start
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val batmonTimestamp: ULong = 0uL,
  /**
   * Battery pack temperature
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
  /**
   * Battery pack voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltage: UShort = 0u,
  /**
   * Battery pack current
   * units = mA
   */
  @GeneratedMavField(type = "int16_t")
  public val current: Short = 0,
  /**
   * Battery pack state-of-charge
   */
  @GeneratedMavField(type = "uint8_t")
  public val soc: UByte = 0u,
  /**
   * Battery monitor status report bits in Hex
   */
  @GeneratedMavField(type = "uint16_t")
  public val batterystatus: UShort = 0u,
  /**
   * Battery monitor serial number in Hex
   */
  @GeneratedMavField(type = "uint16_t")
  public val serialnumber: UShort = 0u,
  /**
   * Battery monitor safetystatus report bits in Hex
   */
  @GeneratedMavField(type = "uint32_t")
  public val safetystatus: UInt = 0u,
  /**
   * Battery monitor operation status report bits in Hex
   */
  @GeneratedMavField(type = "uint32_t")
  public val operationstatus: UInt = 0u,
  /**
   * Battery pack cell 1 voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage1: UShort = 0u,
  /**
   * Battery pack cell 2 voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage2: UShort = 0u,
  /**
   * Battery pack cell 3 voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage3: UShort = 0u,
  /**
   * Battery pack cell 4 voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage4: UShort = 0u,
  /**
   * Battery pack cell 5 voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage5: UShort = 0u,
  /**
   * Battery pack cell 6 voltage
   * units = mV
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage6: UShort = 0u,
) : MavMessage<SensBatmon> {
  override val instanceCompanion: MavMessage.MavCompanion<SensBatmon> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(batmonTimestamp)
    encoder.encodeFloat(temperature)
    encoder.encodeUInt32(safetystatus)
    encoder.encodeUInt32(operationstatus)
    encoder.encodeUInt16(voltage)
    encoder.encodeInt16(current)
    encoder.encodeUInt16(batterystatus)
    encoder.encodeUInt16(serialnumber)
    encoder.encodeUInt16(cellvoltage1)
    encoder.encodeUInt16(cellvoltage2)
    encoder.encodeUInt16(cellvoltage3)
    encoder.encodeUInt16(cellvoltage4)
    encoder.encodeUInt16(cellvoltage5)
    encoder.encodeUInt16(cellvoltage6)
    encoder.encodeUInt8(soc)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(batmonTimestamp)
    encoder.encodeFloat(temperature)
    encoder.encodeUInt32(safetystatus)
    encoder.encodeUInt32(operationstatus)
    encoder.encodeUInt16(voltage)
    encoder.encodeInt16(current)
    encoder.encodeUInt16(batterystatus)
    encoder.encodeUInt16(serialnumber)
    encoder.encodeUInt16(cellvoltage1)
    encoder.encodeUInt16(cellvoltage2)
    encoder.encodeUInt16(cellvoltage3)
    encoder.encodeUInt16(cellvoltage4)
    encoder.encodeUInt16(cellvoltage5)
    encoder.encodeUInt16(cellvoltage6)
    encoder.encodeUInt8(soc)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensBatmon> {
    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    override val id: UInt = 8_010u

    override val crcExtra: Byte = -101

    override fun deserialize(bytes: ByteArray): SensBatmon {
      val decoder = MavDataDecoder(bytes)

      val batmonTimestamp = decoder.safeDecodeUInt64()
      val temperature = decoder.safeDecodeFloat()
      val safetystatus = decoder.safeDecodeUInt32()
      val operationstatus = decoder.safeDecodeUInt32()
      val voltage = decoder.safeDecodeUInt16()
      val current = decoder.safeDecodeInt16()
      val batterystatus = decoder.safeDecodeUInt16()
      val serialnumber = decoder.safeDecodeUInt16()
      val cellvoltage1 = decoder.safeDecodeUInt16()
      val cellvoltage2 = decoder.safeDecodeUInt16()
      val cellvoltage3 = decoder.safeDecodeUInt16()
      val cellvoltage4 = decoder.safeDecodeUInt16()
      val cellvoltage5 = decoder.safeDecodeUInt16()
      val cellvoltage6 = decoder.safeDecodeUInt16()
      val soc = decoder.safeDecodeUInt8()

      return SensBatmon(
        batmonTimestamp = batmonTimestamp,
        temperature = temperature,
        voltage = voltage,
        current = current,
        soc = soc,
        batterystatus = batterystatus,
        serialnumber = serialnumber,
        safetystatus = safetystatus,
        operationstatus = operationstatus,
        cellvoltage1 = cellvoltage1,
        cellvoltage2 = cellvoltage2,
        cellvoltage3 = cellvoltage3,
        cellvoltage4 = cellvoltage4,
        cellvoltage5 = cellvoltage5,
        cellvoltage6 = cellvoltage6,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SensBatmon =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var batmonTimestamp: ULong = 0uL

    public var temperature: Float = 0F

    public var voltage: UShort = 0u

    public var current: Short = 0

    public var soc: UByte = 0u

    public var batterystatus: UShort = 0u

    public var serialnumber: UShort = 0u

    public var safetystatus: UInt = 0u

    public var operationstatus: UInt = 0u

    public var cellvoltage1: UShort = 0u

    public var cellvoltage2: UShort = 0u

    public var cellvoltage3: UShort = 0u

    public var cellvoltage4: UShort = 0u

    public var cellvoltage5: UShort = 0u

    public var cellvoltage6: UShort = 0u

    public fun build(): SensBatmon = SensBatmon(
      batmonTimestamp = batmonTimestamp,
      temperature = temperature,
      voltage = voltage,
      current = current,
      soc = soc,
      batterystatus = batterystatus,
      serialnumber = serialnumber,
      safetystatus = safetystatus,
      operationstatus = operationstatus,
      cellvoltage1 = cellvoltage1,
      cellvoltage2 = cellvoltage2,
      cellvoltage3 = cellvoltage3,
      cellvoltage4 = cellvoltage4,
      cellvoltage5 = cellvoltage5,
      cellvoltage6 = cellvoltage6,
    )
  }
}
