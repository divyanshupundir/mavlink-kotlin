package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define
 * message interval.
 */
public data class CameraTrackingGeoStatus(
  /**
   * Current tracking status
   */
  public val trackingStatus: MavEnumValue<CameraTrackingStatusFlags> = MavEnumValue.fromValue(0),
  /**
   * Latitude of tracked object
   */
  public val lat: Int = 0,
  /**
   * Longitude of tracked object
   */
  public val lon: Int = 0,
  /**
   * Altitude of tracked object(AMSL, WGS84)
   */
  public val alt: Float = 0F,
  /**
   * Horizontal accuracy. NAN if unknown
   */
  public val hAcc: Float = 0F,
  /**
   * Vertical accuracy. NAN if unknown
   */
  public val vAcc: Float = 0F,
  /**
   * North velocity of tracked object. NAN if unknown
   */
  public val velN: Float = 0F,
  /**
   * East velocity of tracked object. NAN if unknown
   */
  public val velE: Float = 0F,
  /**
   * Down velocity of tracked object. NAN if unknown
   */
  public val velD: Float = 0F,
  /**
   * Velocity accuracy. NAN if unknown
   */
  public val velAcc: Float = 0F,
  /**
   * Distance between camera and tracked object. NAN if unknown
   */
  public val dist: Float = 0F,
  /**
   * Heading in radians, in NED. NAN if unknown
   */
  public val hdg: Float = 0F,
  /**
   * Accuracy of heading, in NED. NAN if unknown
   */
  public val hdgAcc: Float = 0F,
) : MavMessage<CameraTrackingGeoStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CameraTrackingGeoStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(alt)
    outputBuffer.encodeFloat(hAcc)
    outputBuffer.encodeFloat(vAcc)
    outputBuffer.encodeFloat(velN)
    outputBuffer.encodeFloat(velE)
    outputBuffer.encodeFloat(velD)
    outputBuffer.encodeFloat(velAcc)
    outputBuffer.encodeFloat(dist)
    outputBuffer.encodeFloat(hdg)
    outputBuffer.encodeFloat(hdgAcc)
    outputBuffer.encodeEnumValue(trackingStatus.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 276

    private const val CRC: Int = 18

    private const val SIZE: Int = 49

    private val DESERIALIZER: MavDeserializer<CameraTrackingGeoStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeFloat()
      val hAcc = inputBuffer.decodeFloat()
      val vAcc = inputBuffer.decodeFloat()
      val velN = inputBuffer.decodeFloat()
      val velE = inputBuffer.decodeFloat()
      val velD = inputBuffer.decodeFloat()
      val velAcc = inputBuffer.decodeFloat()
      val dist = inputBuffer.decodeFloat()
      val hdg = inputBuffer.decodeFloat()
      val hdgAcc = inputBuffer.decodeFloat()
      val trackingStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      CameraTrackingGeoStatus(
        trackingStatus = trackingStatus,
        lat = lat,
        lon = lon,
        alt = alt,
        hAcc = hAcc,
        vAcc = vAcc,
        velN = velN,
        velE = velE,
        velD = velD,
        velAcc = velAcc,
        dist = dist,
        hdg = hdg,
        hdgAcc = hdgAcc,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraTrackingGeoStatus> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraTrackingGeoStatus> = METADATA
  }
}
