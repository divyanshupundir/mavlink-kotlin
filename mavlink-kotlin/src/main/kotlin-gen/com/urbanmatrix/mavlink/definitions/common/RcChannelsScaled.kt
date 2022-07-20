package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The scaled values of the RC channels received: (-100%) -10000, (0%) 0, (100%) 10000. Channels
 * that are inactive should be set to UINT16_MAX.
 */
public data class RcChannelsScaled(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 =
   * MAIN, 1 = AUX.
   */
  public val port: Int = 0,
  /**
   * RC channel 1 value scaled.
   */
  public val chan1Scaled: Int = 0,
  /**
   * RC channel 2 value scaled.
   */
  public val chan2Scaled: Int = 0,
  /**
   * RC channel 3 value scaled.
   */
  public val chan3Scaled: Int = 0,
  /**
   * RC channel 4 value scaled.
   */
  public val chan4Scaled: Int = 0,
  /**
   * RC channel 5 value scaled.
   */
  public val chan5Scaled: Int = 0,
  /**
   * RC channel 6 value scaled.
   */
  public val chan6Scaled: Int = 0,
  /**
   * RC channel 7 value scaled.
   */
  public val chan7Scaled: Int = 0,
  /**
   * RC channel 8 value scaled.
   */
  public val chan8Scaled: Int = 0,
  /**
   * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX:
   * invalid/unknown.
   */
  public val rssi: Int = 0,
) : MavMessage<RcChannelsScaled> {
  public override val instanceMetadata: MavMessage.Metadata<RcChannelsScaled> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(chan1Scaled)
    outputBuffer.encodeInt16(chan2Scaled)
    outputBuffer.encodeInt16(chan3Scaled)
    outputBuffer.encodeInt16(chan4Scaled)
    outputBuffer.encodeInt16(chan5Scaled)
    outputBuffer.encodeInt16(chan6Scaled)
    outputBuffer.encodeInt16(chan7Scaled)
    outputBuffer.encodeInt16(chan8Scaled)
    outputBuffer.encodeUint8(port)
    outputBuffer.encodeUint8(rssi)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 34

    private const val CRC: Int = 237

    private const val SIZE: Int = 22

    private val DESERIALIZER: MavDeserializer<RcChannelsScaled> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val chan1Scaled = inputBuffer.decodeInt16()
      val chan2Scaled = inputBuffer.decodeInt16()
      val chan3Scaled = inputBuffer.decodeInt16()
      val chan4Scaled = inputBuffer.decodeInt16()
      val chan5Scaled = inputBuffer.decodeInt16()
      val chan6Scaled = inputBuffer.decodeInt16()
      val chan7Scaled = inputBuffer.decodeInt16()
      val chan8Scaled = inputBuffer.decodeInt16()
      val port = inputBuffer.decodeUint8()
      val rssi = inputBuffer.decodeUint8()

      RcChannelsScaled(
        timeBootMs = timeBootMs,
        port = port,
        chan1Scaled = chan1Scaled,
        chan2Scaled = chan2Scaled,
        chan3Scaled = chan3Scaled,
        chan4Scaled = chan4Scaled,
        chan5Scaled = chan5Scaled,
        chan6Scaled = chan6Scaled,
        chan7Scaled = chan7Scaled,
        chan8Scaled = chan8Scaled,
        rssi = rssi,
      )
    }


    private val METADATA: MavMessage.Metadata<RcChannelsScaled> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RcChannelsScaled> = METADATA
  }
}
