package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of third AHRS filter if available. This is for ANU research group (Ali and Sean).
 */
@GeneratedMavMessage(
  id = 182u,
  crcExtra = -27,
)
public data class Ahrs3(
  /**
   * Roll angle.
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle.
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle.
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Altitude (MSL).
   */
  @GeneratedMavField(type = "float")
  public val altitude: Float = 0F,
  /**
   * Latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
  /**
   * Test variable1.
   */
  @GeneratedMavField(type = "float")
  public val v1: Float = 0F,
  /**
   * Test variable2.
   */
  @GeneratedMavField(type = "float")
  public val v2: Float = 0F,
  /**
   * Test variable3.
   */
  @GeneratedMavField(type = "float")
  public val v3: Float = 0F,
  /**
   * Test variable4.
   */
  @GeneratedMavField(type = "float")
  public val v4: Float = 0F,
) : MavMessage<Ahrs3> {
  public override val instanceMetadata: MavMessage.Metadata<Ahrs3> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(v1)
    outputBuffer.encodeFloat(v2)
    outputBuffer.encodeFloat(v3)
    outputBuffer.encodeFloat(v4)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(altitude)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(v1)
    outputBuffer.encodeFloat(v2)
    outputBuffer.encodeFloat(v3)
    outputBuffer.encodeFloat(v4)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 182u

    private const val CRC_EXTRA: Byte = -27

    private const val SIZE_V1: Int = 40

    private const val SIZE_V2: Int = 40

    private val DESERIALIZER: MavDeserializer<Ahrs3> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val altitude = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val v1 = inputBuffer.decodeFloat()
      val v2 = inputBuffer.decodeFloat()
      val v3 = inputBuffer.decodeFloat()
      val v4 = inputBuffer.decodeFloat()

      Ahrs3(
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        altitude = altitude,
        lat = lat,
        lng = lng,
        v1 = v1,
        v2 = v2,
        v3 = v3,
        v4 = v4,
      )
    }


    private val METADATA: MavMessage.Metadata<Ahrs3> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Ahrs3> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Ahrs3 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var altitude: Float = 0F

    public var lat: Int = 0

    public var lng: Int = 0

    public var v1: Float = 0F

    public var v2: Float = 0F

    public var v3: Float = 0F

    public var v4: Float = 0F

    public fun build(): Ahrs3 = Ahrs3(
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      altitude = altitude,
      lat = lat,
      lng = lng,
      v1 = v1,
      v2 = v2,
      v3 = v3,
      v4 = v4,
    )
  }
}
