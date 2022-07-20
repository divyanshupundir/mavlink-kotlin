package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000
 * microseconds: 0%, 2000 microseconds: 100%.  A value of UINT16_MAX implies the channel is unused.
 * Individual receivers/transmitters might violate this specification.
 */
public data class RcChannels(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Total number of RC channels being received. This can be larger than 18, indicating that more
   * channels are available but not given in this message. This value should be 0 when no RC channels
   * are available.
   */
  public val chancount: Int = 0,
  /**
   * RC channel 1 value.
   */
  public val chan1Raw: Int = 0,
  /**
   * RC channel 2 value.
   */
  public val chan2Raw: Int = 0,
  /**
   * RC channel 3 value.
   */
  public val chan3Raw: Int = 0,
  /**
   * RC channel 4 value.
   */
  public val chan4Raw: Int = 0,
  /**
   * RC channel 5 value.
   */
  public val chan5Raw: Int = 0,
  /**
   * RC channel 6 value.
   */
  public val chan6Raw: Int = 0,
  /**
   * RC channel 7 value.
   */
  public val chan7Raw: Int = 0,
  /**
   * RC channel 8 value.
   */
  public val chan8Raw: Int = 0,
  /**
   * RC channel 9 value.
   */
  public val chan9Raw: Int = 0,
  /**
   * RC channel 10 value.
   */
  public val chan10Raw: Int = 0,
  /**
   * RC channel 11 value.
   */
  public val chan11Raw: Int = 0,
  /**
   * RC channel 12 value.
   */
  public val chan12Raw: Int = 0,
  /**
   * RC channel 13 value.
   */
  public val chan13Raw: Int = 0,
  /**
   * RC channel 14 value.
   */
  public val chan14Raw: Int = 0,
  /**
   * RC channel 15 value.
   */
  public val chan15Raw: Int = 0,
  /**
   * RC channel 16 value.
   */
  public val chan16Raw: Int = 0,
  /**
   * RC channel 17 value.
   */
  public val chan17Raw: Int = 0,
  /**
   * RC channel 18 value.
   */
  public val chan18Raw: Int = 0,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  public val rssi: Int = 0,
) : MavMessage<RcChannels> {
  public override val instanceMetadata: MavMessage.Metadata<RcChannels> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
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
    outputBuffer.encodeUint16(chan13Raw)
    outputBuffer.encodeUint16(chan14Raw)
    outputBuffer.encodeUint16(chan15Raw)
    outputBuffer.encodeUint16(chan16Raw)
    outputBuffer.encodeUint16(chan17Raw)
    outputBuffer.encodeUint16(chan18Raw)
    outputBuffer.encodeUint8(chancount)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 65

    private const val CRC: Int = 118

    private const val SIZE: Int = 42

    private val DESERIALIZER: MavDeserializer<RcChannels> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
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
      val chan13Raw = inputBuffer.decodeUint16()
      val chan14Raw = inputBuffer.decodeUint16()
      val chan15Raw = inputBuffer.decodeUint16()
      val chan16Raw = inputBuffer.decodeUint16()
      val chan17Raw = inputBuffer.decodeUint16()
      val chan18Raw = inputBuffer.decodeUint16()
      val chancount = inputBuffer.decodeUint8()
      val rssi = inputBuffer.decodeUint8()

      RcChannels(
        timeBootMs = timeBootMs,
        chancount = chancount,
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
        chan13Raw = chan13Raw,
        chan14Raw = chan14Raw,
        chan15Raw = chan15Raw,
        chan16Raw = chan16Raw,
        chan17Raw = chan17Raw,
        chan18Raw = chan18Raw,
        rssi = rssi,
      )
    }


    private val METADATA: MavMessage.Metadata<RcChannels> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RcChannels> = METADATA
  }
}
