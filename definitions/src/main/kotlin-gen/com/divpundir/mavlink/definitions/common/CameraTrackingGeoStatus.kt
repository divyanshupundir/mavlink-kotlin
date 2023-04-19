package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define
 * message interval.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 276u,
  crcExtra = 18,
)
public data class CameraTrackingGeoStatus(
  /**
   * Current tracking status
   */
  @GeneratedMavField(type = "uint8_t")
  public val trackingStatus: MavEnumValue<CameraTrackingStatusFlags> = MavEnumValue.fromValue(0u),
  /**
   * Latitude of tracked object
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of tracked object
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude of tracked object(AMSL, WGS84)
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * Horizontal accuracy. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val hAcc: Float = 0F,
  /**
   * Vertical accuracy. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val vAcc: Float = 0F,
  /**
   * North velocity of tracked object. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val velN: Float = 0F,
  /**
   * East velocity of tracked object. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val velE: Float = 0F,
  /**
   * Down velocity of tracked object. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val velD: Float = 0F,
  /**
   * Velocity accuracy. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val velAcc: Float = 0F,
  /**
   * Distance between camera and tracked object. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val dist: Float = 0F,
  /**
   * Heading in radians, in NED. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val hdg: Float = 0F,
  /**
   * Accuracy of heading, in NED. NAN if unknown
   */
  @GeneratedMavField(type = "float")
  public val hdgAcc: Float = 0F,
) : MavMessage<CameraTrackingGeoStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CameraTrackingGeoStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 276u

    private const val CRC_EXTRA: Byte = 18

    private const val SIZE_V1: Int = 49

    private const val SIZE_V2: Int = 49

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
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraTrackingGeoStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraTrackingGeoStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var trackingStatus: MavEnumValue<CameraTrackingStatusFlags> = MavEnumValue.fromValue(0u)

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Float = 0F

    public var hAcc: Float = 0F

    public var vAcc: Float = 0F

    public var velN: Float = 0F

    public var velE: Float = 0F

    public var velD: Float = 0F

    public var velAcc: Float = 0F

    public var dist: Float = 0F

    public var hdg: Float = 0F

    public var hdgAcc: Float = 0F

    public fun build(): CameraTrackingGeoStatus = CameraTrackingGeoStatus(
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
}