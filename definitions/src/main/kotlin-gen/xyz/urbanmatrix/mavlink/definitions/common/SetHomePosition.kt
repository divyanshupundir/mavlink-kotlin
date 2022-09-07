package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

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
  id = 243,
  crc = 108,
)
public data class SetHomePosition(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Latitude (WGS84)
   */
  public val latitude: Int = 0,
  /**
   * Longitude (WGS84)
   */
  public val longitude: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  public val altitude: Int = 0,
  /**
   * Local X position of this position in the local coordinate frame
   */
  public val x: Float = 0F,
  /**
   * Local Y position of this position in the local coordinate frame
   */
  public val y: Float = 0F,
  /**
   * Local Z position of this position in the local coordinate frame
   */
  public val z: Float = 0F,
  /**
   * World to surface normal and heading transformation of the takeoff position. Used to indicate
   * the heading and slope of the ground
   */
  public val q: List<Float> = emptyList(),
  /**
   * Local X position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   */
  public val approachX: Float = 0F,
  /**
   * Local Y position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   */
  public val approachY: Float = 0F,
  /**
   * Local Z position of the end of the approach vector. Multicopters should set this position based
   * on their takeoff path. Grass-landing fixed wing aircraft should set it the same way as
   * multicopters. Runway-landing fixed wing aircraft should set it to the opposite direction of the
   * takeoff, assuming the takeoff happened from the threshold / touchdown zone.
   */
  public val approachZ: Float = 0F,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
) : MavMessage<SetHomePosition> {
  public override val instanceMetadata: MavMessage.Metadata<SetHomePosition> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt32(altitude)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeFloat(approachX)
    outputBuffer.encodeFloat(approachY)
    outputBuffer.encodeFloat(approachZ)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 243

    private const val CRC: Int = 108

    private const val SIZE: Int = 61

    private val DESERIALIZER: MavDeserializer<SetHomePosition> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val targetSystem = inputBuffer.decodeUint8()
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val altitude = inputBuffer.decodeInt32()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val q = inputBuffer.decodeFloatArray(16)
      val approachX = inputBuffer.decodeFloat()
      val approachY = inputBuffer.decodeFloat()
      val approachZ = inputBuffer.decodeFloat()

      SetHomePosition(
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


    private val METADATA: MavMessage.Metadata<SetHomePosition> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SetHomePosition> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

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

    public var timeUsec: BigInteger = BigInteger.ZERO

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
