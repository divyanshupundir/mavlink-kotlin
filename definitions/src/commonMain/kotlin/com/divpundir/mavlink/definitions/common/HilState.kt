package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Sent from simulation to autopilot. This packet is useful for high throughput applications such as
 * hardware in the loop simulations.
 *
 */
@Deprecated(message = "Suffers from missing airspeed fields and singularities due to Euler angles")
@GeneratedMavMessage(
  id = 90u,
  crcExtra = -73,
)
public data class HilState(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Roll angle
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
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
  public val vx: Short = 0,
  /**
   * Ground Y Speed (Longitude)
   */
  @GeneratedMavField(type = "int16_t")
  public val vy: Short = 0,
  /**
   * Ground Z Speed (Altitude)
   */
  @GeneratedMavField(type = "int16_t")
  public val vz: Short = 0,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val xacc: Short = 0,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val yacc: Short = 0,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "int16_t")
  public val zacc: Short = 0,
) : MavMessage<HilState> {
  override val instanceCompanion: MavMessage.MavCompanion<HilState> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt16(vx)
    encoder.encodeInt16(vy)
    encoder.encodeInt16(vz)
    encoder.encodeInt16(xacc)
    encoder.encodeInt16(yacc)
    encoder.encodeInt16(zacc)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(rollspeed)
    encoder.encodeFloat(pitchspeed)
    encoder.encodeFloat(yawspeed)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(alt)
    encoder.encodeInt16(vx)
    encoder.encodeInt16(vy)
    encoder.encodeInt16(vz)
    encoder.encodeInt16(xacc)
    encoder.encodeInt16(yacc)
    encoder.encodeInt16(zacc)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilState> {
    private const val SIZE_V1: Int = 56

    private const val SIZE_V2: Int = 56

    override val id: UInt = 90u

    override val crcExtra: Byte = -73

    override fun deserialize(bytes: ByteArray): HilState {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val rollspeed = decoder.safeDecodeFloat()
      val pitchspeed = decoder.safeDecodeFloat()
      val yawspeed = decoder.safeDecodeFloat()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt32()
      val vx = decoder.safeDecodeInt16()
      val vy = decoder.safeDecodeInt16()
      val vz = decoder.safeDecodeInt16()
      val xacc = decoder.safeDecodeInt16()
      val yacc = decoder.safeDecodeInt16()
      val zacc = decoder.safeDecodeInt16()

      return HilState(
        timeUsec = timeUsec,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
        lat = lat,
        lon = lon,
        alt = alt,
        vx = vx,
        vy = vy,
        vz = vz,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): HilState =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var vx: Short = 0

    public var vy: Short = 0

    public var vz: Short = 0

    public var xacc: Short = 0

    public var yacc: Short = 0

    public var zacc: Short = 0

    public fun build(): HilState = HilState(
      timeUsec = timeUsec,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
      lat = lat,
      lon = lon,
      alt = alt,
      vx = vx,
      vy = vy,
      vz = vz,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
    )
  }
}
