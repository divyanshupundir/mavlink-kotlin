package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
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
import okio.Buffer

/**
 * Sent from simulation to autopilot. This packet is useful for high throughput applications such as
 * hardware in the loop simulations.
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
  public override val instanceCompanion: MavMessage.MavCompanion<HilState> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(rollspeed)
    buffer.encodeFloat(pitchspeed)
    buffer.encodeFloat(yawspeed)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeInt16(vx)
    buffer.encodeInt16(vy)
    buffer.encodeInt16(vz)
    buffer.encodeInt16(xacc)
    buffer.encodeInt16(yacc)
    buffer.encodeInt16(zacc)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(rollspeed)
    buffer.encodeFloat(pitchspeed)
    buffer.encodeFloat(yawspeed)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(alt)
    buffer.encodeInt16(vx)
    buffer.encodeInt16(vy)
    buffer.encodeInt16(vz)
    buffer.encodeInt16(xacc)
    buffer.encodeInt16(yacc)
    buffer.encodeInt16(zacc)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilState> {
    public override val id: UInt = 90u

    public override val crcExtra: Byte = -73

    public override fun deserialize(bytes: ByteArray): HilState {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val rollspeed = buffer.decodeFloat()
      val pitchspeed = buffer.decodeFloat()
      val yawspeed = buffer.decodeFloat()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val alt = buffer.decodeInt32()
      val vx = buffer.decodeInt16()
      val vy = buffer.decodeInt16()
      val vz = buffer.decodeInt16()
      val xacc = buffer.decodeInt16()
      val yacc = buffer.decodeInt16()
      val zacc = buffer.decodeInt16()

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
