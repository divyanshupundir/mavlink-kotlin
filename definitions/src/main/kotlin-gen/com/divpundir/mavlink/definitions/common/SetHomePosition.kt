package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 *
 *         Sets the home position.
 * 	The home position is the default position that the system will return to and land on.
 *         The position is set automatically by the system during the takeoff (and may also be set
 * using this message).
 *         The global and local positions encode the position in the respective coordinate frames,
 * while the q parameter encodes the orientation of the surface.
 *         Under normal conditions it describes the heading and terrain slope, which can be used by
 * the aircraft to adjust the approach.
 *         The approach 3D vector describes the point to which the system should fly in normal
 * flight mode and then perform a landing sequence along the vector.
 *         Note: the current home position may be emitted in a HOME_POSITION message on request
 * (using MAV_CMD_REQUEST_MESSAGE with param1=242).
 *       
 */
@Deprecated(message =
    "The command protocol version (MAV_CMD_DO_SET_HOME) allows a GCS to detect when setting the home position has failed.")
@GeneratedMavMessage(
  id = 243u,
  crcExtra = 85,
)
public data class SetHomePosition(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  @GeneratedMavField(type = "int32_t")
  public val altitude: Int = 0,
  /**
   * Local X position of this position in the local coordinate frame
   */
  @GeneratedMavField(type = "float")
  public val x: Float = 0F,
  /**
   * Local Y position of this position in the local coordinate frame
   */
  @GeneratedMavField(type = "float")
  public val y: Float = 0F,
  /**
   * Local Z position of this position in the local coordinate frame
   */
  @GeneratedMavField(type = "float")
  public val z: Float = 0F,
  /**
   * World to surface normal and heading transformation of the takeoff position. Used to indicate
   * the heading and slope of the ground
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Local X position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   */
  @GeneratedMavField(type = "float")
  public val approachX: Float = 0F,
  /**
   * Local Y position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   */
  @GeneratedMavField(type = "float")
  public val approachY: Float = 0F,
  /**
   * Local Z position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   */
  @GeneratedMavField(type = "float")
  public val approachZ: Float = 0F,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(
    type = "uint64_t",
    extension = true,
  )
  public val timeUsec: ULong = 0uL,
) : MavMessage<SetHomePosition> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetHomePosition> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt32(altitude)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeFloatArray(q, 16)
    output.encodeFloat(approachX)
    output.encodeFloat(approachY)
    output.encodeFloat(approachZ)
    output.encodeUInt8(targetSystem)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt32(altitude)
    output.encodeFloat(x)
    output.encodeFloat(y)
    output.encodeFloat(z)
    output.encodeFloatArray(q, 16)
    output.encodeFloat(approachX)
    output.encodeFloat(approachY)
    output.encodeFloat(approachZ)
    output.encodeUInt8(targetSystem)
    output.encodeUInt64(timeUsec)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SetHomePosition> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 61

    public override val id: UInt = 243u

    public override val crcExtra: Byte = 85

    public override fun deserialize(source: BufferedSource): SetHomePosition {
      val latitude = source.decodeInt32()
      val longitude = source.decodeInt32()
      val altitude = source.decodeInt32()
      val x = source.decodeFloat()
      val y = source.decodeFloat()
      val z = source.decodeFloat()
      val q = source.decodeFloatArray(16)
      val approachX = source.decodeFloat()
      val approachY = source.decodeFloat()
      val approachZ = source.decodeFloat()
      val targetSystem = source.decodeUInt8()
      val timeUsec = source.decodeUInt64()

      return SetHomePosition(
        targetSystem = targetSystem,
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SetHomePosition =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

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

    public fun build(): SetHomePosition = SetHomePosition(
      targetSystem = targetSystem,
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
