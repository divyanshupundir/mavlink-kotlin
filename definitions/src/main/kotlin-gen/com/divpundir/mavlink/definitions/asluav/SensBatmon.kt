package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
 */
@GeneratedMavMessage(
  id = 8_010u,
  crcExtra = -101,
)
public data class SensBatmon(
  /**
   * Time since system start
   */
  @GeneratedMavField(type = "uint64_t")
  public val batmonTimestamp: ULong = 0uL,
  /**
   * Battery pack temperature
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
  /**
   * Battery pack voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltage: UShort = 0u,
  /**
   * Battery pack current
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
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage1: UShort = 0u,
  /**
   * Battery pack cell 2 voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage2: UShort = 0u,
  /**
   * Battery pack cell 3 voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage3: UShort = 0u,
  /**
   * Battery pack cell 4 voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage4: UShort = 0u,
  /**
   * Battery pack cell 5 voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage5: UShort = 0u,
  /**
   * Battery pack cell 6 voltage
   */
  @GeneratedMavField(type = "uint16_t")
  public val cellvoltage6: UShort = 0u,
) : MavMessage<SensBatmon> {
  public override val instanceCompanion: MavMessage.MavCompanion<SensBatmon> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(batmonTimestamp)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeUInt32(safetystatus)
    outputBuffer.encodeUInt32(operationstatus)
    outputBuffer.encodeUInt16(voltage)
    outputBuffer.encodeInt16(current)
    outputBuffer.encodeUInt16(batterystatus)
    outputBuffer.encodeUInt16(serialnumber)
    outputBuffer.encodeUInt16(cellvoltage1)
    outputBuffer.encodeUInt16(cellvoltage2)
    outputBuffer.encodeUInt16(cellvoltage3)
    outputBuffer.encodeUInt16(cellvoltage4)
    outputBuffer.encodeUInt16(cellvoltage5)
    outputBuffer.encodeUInt16(cellvoltage6)
    outputBuffer.encodeUInt8(soc)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(batmonTimestamp)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeUInt32(safetystatus)
    outputBuffer.encodeUInt32(operationstatus)
    outputBuffer.encodeUInt16(voltage)
    outputBuffer.encodeInt16(current)
    outputBuffer.encodeUInt16(batterystatus)
    outputBuffer.encodeUInt16(serialnumber)
    outputBuffer.encodeUInt16(cellvoltage1)
    outputBuffer.encodeUInt16(cellvoltage2)
    outputBuffer.encodeUInt16(cellvoltage3)
    outputBuffer.encodeUInt16(cellvoltage4)
    outputBuffer.encodeUInt16(cellvoltage5)
    outputBuffer.encodeUInt16(cellvoltage6)
    outputBuffer.encodeUInt8(soc)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensBatmon> {
    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    public override val id: UInt = 8_010u

    public override val crcExtra: Byte = -101

    public override fun deserialize(bytes: ByteArray): SensBatmon {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val batmonTimestamp = inputBuffer.decodeUInt64()
      val temperature = inputBuffer.decodeFloat()
      val safetystatus = inputBuffer.decodeUInt32()
      val operationstatus = inputBuffer.decodeUInt32()
      val voltage = inputBuffer.decodeUInt16()
      val current = inputBuffer.decodeInt16()
      val batterystatus = inputBuffer.decodeUInt16()
      val serialnumber = inputBuffer.decodeUInt16()
      val cellvoltage1 = inputBuffer.decodeUInt16()
      val cellvoltage2 = inputBuffer.decodeUInt16()
      val cellvoltage3 = inputBuffer.decodeUInt16()
      val cellvoltage4 = inputBuffer.decodeUInt16()
      val cellvoltage5 = inputBuffer.decodeUInt16()
      val cellvoltage6 = inputBuffer.decodeUInt16()
      val soc = inputBuffer.decodeUInt8()

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
