package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Battery pack monitoring data for Li-Ion batteries
 */
public data class SensBatmon(
  /**
   * Time since system start
   */
  public val batmonTimestamp: BigInteger = BigInteger.ZERO,
  /**
   * Battery pack temperature
   */
  public val temperature: Float = 0F,
  /**
   * Battery pack voltage
   */
  public val voltage: Int = 0,
  /**
   * Battery pack current
   */
  public val current: Int = 0,
  /**
   * Battery pack state-of-charge
   */
  public val soc: Int = 0,
  /**
   * Battery monitor status report bits in Hex
   */
  public val batterystatus: Int = 0,
  /**
   * Battery monitor serial number in Hex
   */
  public val serialnumber: Int = 0,
  /**
   * Battery monitor safetystatus report bits in Hex
   */
  public val safetystatus: Long = 0L,
  /**
   * Battery monitor operation status report bits in Hex
   */
  public val operationstatus: Long = 0L,
  /**
   * Battery pack cell 1 voltage
   */
  public val cellvoltage1: Int = 0,
  /**
   * Battery pack cell 2 voltage
   */
  public val cellvoltage2: Int = 0,
  /**
   * Battery pack cell 3 voltage
   */
  public val cellvoltage3: Int = 0,
  /**
   * Battery pack cell 4 voltage
   */
  public val cellvoltage4: Int = 0,
  /**
   * Battery pack cell 5 voltage
   */
  public val cellvoltage5: Int = 0,
  /**
   * Battery pack cell 6 voltage
   */
  public val cellvoltage6: Int = 0,
) : MavMessage<SensBatmon> {
  public override val instanceMetadata: MavMessage.Metadata<SensBatmon> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(batmonTimestamp)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeUint32(safetystatus)
    outputBuffer.encodeUint32(operationstatus)
    outputBuffer.encodeUint16(voltage)
    outputBuffer.encodeInt16(current)
    outputBuffer.encodeUint16(batterystatus)
    outputBuffer.encodeUint16(serialnumber)
    outputBuffer.encodeUint16(cellvoltage1)
    outputBuffer.encodeUint16(cellvoltage2)
    outputBuffer.encodeUint16(cellvoltage3)
    outputBuffer.encodeUint16(cellvoltage4)
    outputBuffer.encodeUint16(cellvoltage5)
    outputBuffer.encodeUint16(cellvoltage6)
    outputBuffer.encodeUint8(soc)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8010

    private const val CRC: Int = 155

    private const val SIZE: Int = 41

    private val DESERIALIZER: MavDeserializer<SensBatmon> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val batmonTimestamp = inputBuffer.decodeUint64()
      val temperature = inputBuffer.decodeFloat()
      val safetystatus = inputBuffer.decodeUint32()
      val operationstatus = inputBuffer.decodeUint32()
      val voltage = inputBuffer.decodeUint16()
      val current = inputBuffer.decodeInt16()
      val batterystatus = inputBuffer.decodeUint16()
      val serialnumber = inputBuffer.decodeUint16()
      val cellvoltage1 = inputBuffer.decodeUint16()
      val cellvoltage2 = inputBuffer.decodeUint16()
      val cellvoltage3 = inputBuffer.decodeUint16()
      val cellvoltage4 = inputBuffer.decodeUint16()
      val cellvoltage5 = inputBuffer.decodeUint16()
      val cellvoltage6 = inputBuffer.decodeUint16()
      val soc = inputBuffer.decodeUint8()

      SensBatmon(
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


    private val METADATA: MavMessage.Metadata<SensBatmon> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensBatmon> = METADATA
  }
}
