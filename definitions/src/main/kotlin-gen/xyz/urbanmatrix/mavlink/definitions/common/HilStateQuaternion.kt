package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Sent from simulation to autopilot, avoids in contrast to HIL_STATE singularities. This packet is
 * useful for high throughput applications such as hardware in the loop simulations.
 */
@GeneratedMavMessage(
  id = 115,
  crc = 4,
)
public data class HilStateQuaternion(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Vehicle attitude expressed as normalized quaternion in w, x, y, z order (with 1 0 0 0 being the
   * null-rotation)
   */
  @GeneratedMavField(type = "float[4]")
  public val attitudeQuaternion: List<Float> = emptyList(),
  /**
   * Body frame roll / phi angular speed
   */
  @GeneratedMavField(type = "float")
  public val rollspeed: Float = 0F,
  /**
   * Body frame pitch / theta angular speed
   */
  @GeneratedMavField(type = "float")
  public val pitchspeed: Float = 0F,
  /**
   * Body frame yaw / psi angular speed
   */
  @GeneratedMavField(type = "float")
  public val yawspeed: Float = 0F,
  /**
   * Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Altitude
   */
  @GeneratedMavField(type = "int32_t")
  public val alt: Int = 0,
  /**
   * Ground X Speed (Latitude)
   */
  @GeneratedMavField(type = "int16_t")
  public val vx: Int = 0,
  /**
   * Ground Y Speed (Longitude)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Int = 0,
  /**
   * Ground Z Speed (Altitude)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Int = 0,
  /**
   * Indicated airspeed
   */
  @GeneratedMavField(type = "uint16_t")
  public val indAirspeed: Int = 0,
  /**
   * True airspeed
   */
  @GeneratedMavField(type = "uint16_t")
  public val trueAirspeed: Int = 0,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Int = 0,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Int = 0,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Int = 0,
) : MavMessage<HilStateQuaternion> {
  public override val instanceMetadata: MavMessage.Metadata<HilStateQuaternion> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloatArray(attitudeQuaternion, 16)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeUint16(indAirspeed)
    outputBuffer.encodeUint16(trueAirspeed)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(zacc)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloatArray(attitudeQuaternion, 16)
    outputBuffer.encodeFloat(rollspeed)
    outputBuffer.encodeFloat(pitchspeed)
    outputBuffer.encodeFloat(yawspeed)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(alt)
    outputBuffer.encodeInt16(vx)
    outputBuffer.encodeInt16(vy)
    outputBuffer.encodeInt16(vz)
    outputBuffer.encodeUint16(indAirspeed)
    outputBuffer.encodeUint16(trueAirspeed)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(zacc)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 115

    private const val CRC: Int = 4

    private const val SIZE: Int = 64

    private val DESERIALIZER: MavDeserializer<HilStateQuaternion> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val attitudeQuaternion = inputBuffer.decodeFloatArray(16)
      val rollspeed = inputBuffer.decodeFloat()
      val pitchspeed = inputBuffer.decodeFloat()
      val yawspeed = inputBuffer.decodeFloat()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt32()
      val vx = inputBuffer.decodeInt16()
      val vy = inputBuffer.decodeInt16()
      val vz = inputBuffer.decodeInt16()
      val indAirspeed = inputBuffer.decodeUint16()
      val trueAirspeed = inputBuffer.decodeUint16()
      val xacc = inputBuffer.decodeInt16()
      val yacc = inputBuffer.decodeInt16()
      val zacc = inputBuffer.decodeInt16()

      HilStateQuaternion(
        timeUsec = timeUsec,
        attitudeQuaternion = attitudeQuaternion,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        lat = lat,
        lon = lon,
        alt = alt,
        vx = vx,
        vy = vy,
        vz = vz,
        indAirspeed = indAirspeed,
        trueAirspeed = trueAirspeed,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
      )
    }


    private val METADATA: MavMessage.Metadata<HilStateQuaternion> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilStateQuaternion> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var attitudeQuaternion: List<Float> = emptyList()

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var vx: Int = 0

    public var vy: Int = 0

    public var vz: Int = 0

    public var indAirspeed: Int = 0

    public var trueAirspeed: Int = 0

    public var xacc: Int = 0

    public var yacc: Int = 0

    public var zacc: Int = 0

    public fun build(): HilStateQuaternion = HilStateQuaternion(
      timeUsec = timeUsec,
      attitudeQuaternion = attitudeQuaternion,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      lat = lat,
      lon = lon,
      alt = alt,
      vx = vx,
      vy = vy,
      vz = vz,
      indAirspeed = indAirspeed,
      trueAirspeed = trueAirspeed,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
    )
  }
}
