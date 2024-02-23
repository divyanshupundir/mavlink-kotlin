package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 *
 * 	Contains the home position.
 * 	The home position is the default position that the system will return to and land on.
 * 	The position must be set automatically by the system during the takeoff, and may also be
 * explicitly set using MAV_CMD_DO_SET_HOME.
 * 	The global and local positions encode the position in the respective coordinate frames, while
 * the q parameter encodes the orientation of the surface.
 * 	Under normal conditions it describes the heading and terrain slope, which can be used by the
 * aircraft to adjust the approach.
 * 	The approach 3D vector describes the point to which the system should fly in normal flight mode
 * and then perform a landing sequence along the vector.
 *         Note: this message can be requested by sending the MAV_CMD_REQUEST_MESSAGE with
 * param1=242 (or the deprecated MAV_CMD_GET_HOME_POSITION command).
 *       
 *
 * @param latitude Latitude (WGS84)
 * units = degE7
 * @param longitude Longitude (WGS84)
 * units = degE7
 * @param altitude Altitude (MSL). Positive for up.
 * units = mm
 * @param x Local X position of this position in the local coordinate frame (NED)
 * units = m
 * @param y Local Y position of this position in the local coordinate frame (NED)
 * units = m
 * @param z Local Z position of this position in the local coordinate frame (NED: positive "down")
 * units = m
 * @param q 
 *         Quaternion indicating world-to-surface-normal and heading transformation of the takeoff
 * position.
 *         Used to indicate the heading and slope of the ground.
 *         All fields should be set to NaN if an accurate quaternion for both heading and surface
 * slope cannot be supplied.
 *       
 * @param approachX Local X position of the end of the approach vector. Multicopters should set this
 * position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way
 * as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
 * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
 * units = m
 * @param approachY Local Y position of the end of the approach vector. Multicopters should set this
 * position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way
 * as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
 * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
 * units = m
 * @param approachZ Local Z position of the end of the approach vector. Multicopters should set this
 * position based on their takeoff path. Grass-landing fixed wing aircraft should set it the same way
 * as multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
 * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
 * units = m
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 */
@GeneratedMavMessage(
  id = 242u,
  crcExtra = 104,
)
public data class HomePosition(
  /**
   * Latitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val altitude: Int = 0,
  /**
   * Local X position of this position in the local coordinate frame (NED)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Local Y position of this position in the local coordinate frame (NED)
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Local Z position of this position in the local coordinate frame (NED: positive "down")
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   *
   *         Quaternion indicating world-to-surface-normal and heading transformation of the takeoff
   * position.
   *         Used to indicate the heading and slope of the ground.
   *         All fields should be set to NaN if an accurate quaternion for both heading and surface
   * slope cannot be supplied.
   *       
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Local X position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val approachX: Float = 0F,
  /**
   * Local Y position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val approachY: Float = 0F,
  /**
   * Local Z position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val approachZ: Float = 0F,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(
    type = "uint64_t",
    extension = true,
  )
  public val timeUsec: ULong = 0uL,
) : MavMessage<HomePosition> {
  override val instanceCompanion: MavMessage.MavCompanion<HomePosition> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt32(altitude)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(approachX)
    encoder.encodeFloat(approachY)
    encoder.encodeFloat(approachZ)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt32(altitude)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeFloat(approachX)
    encoder.encodeFloat(approachY)
    encoder.encodeFloat(approachZ)
    encoder.encodeUInt64(timeUsec)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HomePosition> {
    private const val SIZE_V1: Int = 52

    private const val SIZE_V2: Int = 60

    override val id: UInt = 242u

    override val crcExtra: Byte = 104

    override fun deserialize(bytes: ByteArray): HomePosition {
      val decoder = MavDataDecoder(bytes)

      val latitude = decoder.safeDecodeInt32()
      val longitude = decoder.safeDecodeInt32()
      val altitude = decoder.safeDecodeInt32()
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val q = decoder.safeDecodeFloatArray(16)
      val approachX = decoder.safeDecodeFloat()
      val approachY = decoder.safeDecodeFloat()
      val approachZ = decoder.safeDecodeFloat()
      val timeUsec = decoder.safeDecodeUInt64()

      return HomePosition(
        latitude = latitude,
        longitude = longitude,
        altitude = altitude,
        x = x,
        y = y,
        z = z,
        q = q,
        approachX = approachX,
        approachY = approachY,
        approachZ = approachZ,
        timeUsec = timeUsec,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HomePosition =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitude: Int = 0

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var q: List<Float> = emptyList()

    public var approachX: Float = 0F

    public var approachY: Float = 0F

    public var approachZ: Float = 0F

    public var timeUsec: ULong = 0uL

    public fun build(): HomePosition = HomePosition(
      latitude = latitude,
      longitude = longitude,
      altitude = altitude,
      x = x,
      y = y,
      z = z,
      q = q,
      approachX = approachX,
      approachY = approachY,
      approachZ = approachZ,
      timeUsec = timeUsec,
    )
  }
}
