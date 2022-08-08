package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The altitude measured by sensors and IMU
 */
@GeneratedMavMessage(
  id = 181,
  crc = 55,
)
public data class Altitudes(
  /**
   * Timestamp (milliseconds since system boot)
   */
  public val timeBootMs: Long = 0L,
  /**
   * GPS altitude (MSL) in meters, expressed as * 1000 (millimeters)
   */
  public val altGps: Int = 0,
  /**
   * IMU altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  public val altImu: Int = 0,
  /**
   * barometeric altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  public val altBarometric: Int = 0,
  /**
   * Optical flow altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  public val altOpticalFlow: Int = 0,
  /**
   * Rangefinder Altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  public val altRangeFinder: Int = 0,
  /**
   * Extra altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  public val altExtra: Int = 0,
) : MavMessage<Altitudes> {
  public override val instanceMetadata: MavMessage.Metadata<Altitudes> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(altGps)
    outputBuffer.encodeInt32(altImu)
    outputBuffer.encodeInt32(altBarometric)
    outputBuffer.encodeInt32(altOpticalFlow)
    outputBuffer.encodeInt32(altRangeFinder)
    outputBuffer.encodeInt32(altExtra)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 181

    private const val CRC: Int = 55

    private const val SIZE: Int = 28

    private val DESERIALIZER: MavDeserializer<Altitudes> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val altGps = inputBuffer.decodeInt32()
      val altImu = inputBuffer.decodeInt32()
      val altBarometric = inputBuffer.decodeInt32()
      val altOpticalFlow = inputBuffer.decodeInt32()
      val altRangeFinder = inputBuffer.decodeInt32()
      val altExtra = inputBuffer.decodeInt32()

      Altitudes(
        timeBootMs = timeBootMs,
        altGps = altGps,
        altImu = altImu,
        altBarometric = altBarometric,
        altOpticalFlow = altOpticalFlow,
        altRangeFinder = altRangeFinder,
        altExtra = altExtra,
      )
    }


    private val METADATA: MavMessage.Metadata<Altitudes> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Altitudes> = METADATA
  }
}
