package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Wind estimate from vehicle. Note that despite the name, this message does not actually contain
 * any covariances but instead variability and accuracy fields in terms of standard deviation (1-STD).
 */
@GeneratedMavMessage(
  id = 231,
  crc = 105,
)
public data class WindCov(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Wind in North (NED) direction (NAN if unknown)
   */
  public val windX: Float = 0F,
  /**
   * Wind in East (NED) direction (NAN if unknown)
   */
  public val windY: Float = 0F,
  /**
   * Wind in down (NED) direction (NAN if unknown)
   */
  public val windZ: Float = 0F,
  /**
   * Variability of wind in XY, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN if unknown)
   */
  public val varHoriz: Float = 0F,
  /**
   * Variability of wind in Z, 1-STD estimated from a 1 Hz lowpassed wind estimate (NAN if unknown)
   */
  public val varVert: Float = 0F,
  /**
   * Altitude (MSL) that this measurement was taken at (NAN if unknown)
   */
  public val windAlt: Float = 0F,
  /**
   * Horizontal speed 1-STD accuracy (0 if unknown)
   */
  public val horizAccuracy: Float = 0F,
  /**
   * Vertical speed 1-STD accuracy (0 if unknown)
   */
  public val vertAccuracy: Float = 0F,
) : MavMessage<WindCov> {
  public override val instanceMetadata: MavMessage.Metadata<WindCov> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(windX)
    outputBuffer.encodeFloat(windY)
    outputBuffer.encodeFloat(windZ)
    outputBuffer.encodeFloat(varHoriz)
    outputBuffer.encodeFloat(varVert)
    outputBuffer.encodeFloat(windAlt)
    outputBuffer.encodeFloat(horizAccuracy)
    outputBuffer.encodeFloat(vertAccuracy)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 231

    private const val CRC: Int = 105

    private const val SIZE: Int = 40

    private val DESERIALIZER: MavDeserializer<WindCov> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val windX = inputBuffer.decodeFloat()
      val windY = inputBuffer.decodeFloat()
      val windZ = inputBuffer.decodeFloat()
      val varHoriz = inputBuffer.decodeFloat()
      val varVert = inputBuffer.decodeFloat()
      val windAlt = inputBuffer.decodeFloat()
      val horizAccuracy = inputBuffer.decodeFloat()
      val vertAccuracy = inputBuffer.decodeFloat()

      WindCov(
        timeUsec = timeUsec,
        windX = windX,
        windY = windY,
        windZ = windZ,
        varHoriz = varHoriz,
        varVert = varVert,
        windAlt = windAlt,
        horizAccuracy = horizAccuracy,
        vertAccuracy = vertAccuracy,
      )
    }


    private val METADATA: MavMessage.Metadata<WindCov> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WindCov> = METADATA
  }
}
