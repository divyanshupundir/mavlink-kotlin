package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
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
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<CameraTrackingGeoStatus> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(hAcc)
    buffer.encodeFloat(vAcc)
    buffer.encodeFloat(velN)
    buffer.encodeFloat(velE)
    buffer.encodeFloat(velD)
    buffer.encodeFloat(velAcc)
    buffer.encodeFloat(dist)
    buffer.encodeFloat(hdg)
    buffer.encodeFloat(hdgAcc)
    buffer.encodeEnumValue(trackingStatus.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeFloat(alt)
    buffer.encodeFloat(hAcc)
    buffer.encodeFloat(vAcc)
    buffer.encodeFloat(velN)
    buffer.encodeFloat(velE)
    buffer.encodeFloat(velD)
    buffer.encodeFloat(velAcc)
    buffer.encodeFloat(dist)
    buffer.encodeFloat(hdg)
    buffer.encodeFloat(hdgAcc)
    buffer.encodeEnumValue(trackingStatus.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraTrackingGeoStatus> {
    public override val id: UInt = 276u

    public override val crcExtra: Byte = 18

    public override fun deserialize(bytes: ByteArray): CameraTrackingGeoStatus {
      val buffer = Buffer().write(bytes)

      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val alt = buffer.decodeFloat()
      val hAcc = buffer.decodeFloat()
      val vAcc = buffer.decodeFloat()
      val velN = buffer.decodeFloat()
      val velE = buffer.decodeFloat()
      val velD = buffer.decodeFloat()
      val velAcc = buffer.decodeFloat()
      val dist = buffer.decodeFloat()
      val hdg = buffer.decodeFloat()
      val hdgAcc = buffer.decodeFloat()
      val trackingStatus = buffer.decodeEnumValue(1).let { value ->
        val entry = CameraTrackingStatusFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return CameraTrackingGeoStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraTrackingGeoStatus =
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
