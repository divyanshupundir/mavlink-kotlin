package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define
 * message interval.
 *
 * @param trackingStatus Current tracking status
 * @param lat Latitude of tracked object
 * units = degE7
 * @param lon Longitude of tracked object
 * units = degE7
 * @param alt Altitude of tracked object(AMSL, WGS84)
 * units = m
 * @param hAcc Horizontal accuracy. NAN if unknown
 * units = m
 * @param vAcc Vertical accuracy. NAN if unknown
 * units = m
 * @param velN North velocity of tracked object. NAN if unknown
 * units = m/s
 * @param velE East velocity of tracked object. NAN if unknown
 * units = m/s
 * @param velD Down velocity of tracked object. NAN if unknown
 * units = m/s
 * @param velAcc Velocity accuracy. NAN if unknown
 * units = m/s
 * @param dist Distance between camera and tracked object. NAN if unknown
 * units = m
 * @param hdg Heading in radians, in NED. NAN if unknown
 * units = rad
 * @param hdgAcc Accuracy of heading, in NED. NAN if unknown
 * units = rad
 */
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
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of tracked object
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude of tracked object(AMSL, WGS84)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val alt: Float = 0F,
  /**
   * Horizontal accuracy. NAN if unknown
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val hAcc: Float = 0F,
  /**
   * Vertical accuracy. NAN if unknown
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val vAcc: Float = 0F,
  /**
   * North velocity of tracked object. NAN if unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val velN: Float = 0F,
  /**
   * East velocity of tracked object. NAN if unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val velE: Float = 0F,
  /**
   * Down velocity of tracked object. NAN if unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val velD: Float = 0F,
  /**
   * Velocity accuracy. NAN if unknown
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val velAcc: Float = 0F,
  /**
   * Distance between camera and tracked object. NAN if unknown
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val dist: Float = 0F,
  /**
   * Heading in radians, in NED. NAN if unknown
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val hdg: Float = 0F,
  /**
   * Accuracy of heading, in NED. NAN if unknown
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val hdgAcc: Float = 0F,
) : MavMessage<CameraTrackingGeoStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraTrackingGeoStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(hAcc)
    encoder.encodeFloat(vAcc)
    encoder.encodeFloat(velN)
    encoder.encodeFloat(velE)
    encoder.encodeFloat(velD)
    encoder.encodeFloat(velAcc)
    encoder.encodeFloat(dist)
    encoder.encodeFloat(hdg)
    encoder.encodeFloat(hdgAcc)
    encoder.encodeEnumValue(trackingStatus.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(alt)
    encoder.encodeFloat(hAcc)
    encoder.encodeFloat(vAcc)
    encoder.encodeFloat(velN)
    encoder.encodeFloat(velE)
    encoder.encodeFloat(velD)
    encoder.encodeFloat(velAcc)
    encoder.encodeFloat(dist)
    encoder.encodeFloat(hdg)
    encoder.encodeFloat(hdgAcc)
    encoder.encodeEnumValue(trackingStatus.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraTrackingGeoStatus> {
    private const val SIZE_V1: Int = 49

    private const val SIZE_V2: Int = 49

    override val id: UInt = 276u

    override val crcExtra: Byte = 18

    override fun deserialize(bytes: ByteArray): CameraTrackingGeoStatus {
      val decoder = MavDataDecoder(bytes)

      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeFloat()
      val hAcc = decoder.safeDecodeFloat()
      val vAcc = decoder.safeDecodeFloat()
      val velN = decoder.safeDecodeFloat()
      val velE = decoder.safeDecodeFloat()
      val velD = decoder.safeDecodeFloat()
      val velAcc = decoder.safeDecodeFloat()
      val dist = decoder.safeDecodeFloat()
      val hdg = decoder.safeDecodeFloat()
      val hdgAcc = decoder.safeDecodeFloat()
      val trackingStatus = decoder.safeDecodeEnumValue(1).let { value ->
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
