package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM
 * modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual
 * receivers/transmitters might violate this specification.
 */
@GeneratedMavMessage(
  id = 92,
  crc = 54,
)
public data class HilRcInputsRaw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * RC channel 1 value
   */
  public val chan1Raw: Int = 0,
  /**
   * RC channel 2 value
   */
  public val chan2Raw: Int = 0,
  /**
   * RC channel 3 value
   */
  public val chan3Raw: Int = 0,
  /**
   * RC channel 4 value
   */
  public val chan4Raw: Int = 0,
  /**
   * RC channel 5 value
   */
  public val chan5Raw: Int = 0,
  /**
   * RC channel 6 value
   */
  public val chan6Raw: Int = 0,
  /**
   * RC channel 7 value
   */
  public val chan7Raw: Int = 0,
  /**
   * RC channel 8 value
   */
  public val chan8Raw: Int = 0,
  /**
   * RC channel 9 value
   */
  public val chan9Raw: Int = 0,
  /**
   * RC channel 10 value
   */
  public val chan10Raw: Int = 0,
  /**
   * RC channel 11 value
   */
  public val chan11Raw: Int = 0,
  /**
   * RC channel 12 value
   */
  public val chan12Raw: Int = 0,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  public val rssi: Int = 0,
) : MavMessage<HilRcInputsRaw> {
  public override val instanceMetadata: MavMessage.Metadata<HilRcInputsRaw> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint16(chan1Raw)
    outputBuffer.encodeUint16(chan2Raw)
    outputBuffer.encodeUint16(chan3Raw)
    outputBuffer.encodeUint16(chan4Raw)
    outputBuffer.encodeUint16(chan5Raw)
    outputBuffer.encodeUint16(chan6Raw)
    outputBuffer.encodeUint16(chan7Raw)
    outputBuffer.encodeUint16(chan8Raw)
    outputBuffer.encodeUint16(chan9Raw)
    outputBuffer.encodeUint16(chan10Raw)
    outputBuffer.encodeUint16(chan11Raw)
    outputBuffer.encodeUint16(chan12Raw)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 92

    private const val CRC: Int = 54

    private const val SIZE: Int = 33

    private val DESERIALIZER: MavDeserializer<HilRcInputsRaw> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val chan1Raw = inputBuffer.decodeUint16()
      val chan2Raw = inputBuffer.decodeUint16()
      val chan3Raw = inputBuffer.decodeUint16()
      val chan4Raw = inputBuffer.decodeUint16()
      val chan5Raw = inputBuffer.decodeUint16()
      val chan6Raw = inputBuffer.decodeUint16()
      val chan7Raw = inputBuffer.decodeUint16()
      val chan8Raw = inputBuffer.decodeUint16()
      val chan9Raw = inputBuffer.decodeUint16()
      val chan10Raw = inputBuffer.decodeUint16()
      val chan11Raw = inputBuffer.decodeUint16()
      val chan12Raw = inputBuffer.decodeUint16()
      val rssi = inputBuffer.decodeUint8()

      HilRcInputsRaw(
        timeUsec = timeUsec,
        chan1Raw = chan1Raw,
        chan2Raw = chan2Raw,
        chan3Raw = chan3Raw,
        chan4Raw = chan4Raw,
        chan5Raw = chan5Raw,
        chan6Raw = chan6Raw,
        chan7Raw = chan7Raw,
        chan8Raw = chan8Raw,
        chan9Raw = chan9Raw,
        chan10Raw = chan10Raw,
        chan11Raw = chan11Raw,
        chan12Raw = chan12Raw,
        rssi = rssi,
      )
    }


    private val METADATA: MavMessage.Metadata<HilRcInputsRaw> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilRcInputsRaw> = METADATA
  }
}
