package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Sent from simulation to autopilot, avoids in contrast to HIL_STATE singularities. This packet is
 * useful for high throughput applications such as hardware in the loop simulations.
 */
@GeneratedMavMessage(
  id = 115u,
  crcExtra = 4,
)
public data class HilStateQuaternion(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
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
   * Indicated airspeed
   */
  @GeneratedMavField(type = "uint16_t")
  public val indAirspeed: UShort = 0u,
  /**
   * True airspeed
   */
  @GeneratedMavField(type = "uint16_t")
  public val trueAirspeed: UShort = 0u,
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
) : MavMessage<HilStateQuaternion> {
  public override val instanceCompanion: MavMessage.MavCompanion<HilStateQuaternion> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloatArray(attitudeQuaternion, 16)
    output.encodeFloat(rollspeed)
    output.encodeFloat(pitchspeed)
    output.encodeFloat(yawspeed)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt16(vx)
    output.encodeInt16(vy)
    output.encodeInt16(vz)
    output.encodeUInt16(indAirspeed)
    output.encodeUInt16(trueAirspeed)
    output.encodeInt16(xacc)
    output.encodeInt16(yacc)
    output.encodeInt16(zacc)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloatArray(attitudeQuaternion, 16)
    output.encodeFloat(rollspeed)
    output.encodeFloat(pitchspeed)
    output.encodeFloat(yawspeed)
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeInt32(alt)
    output.encodeInt16(vx)
    output.encodeInt16(vy)
    output.encodeInt16(vz)
    output.encodeUInt16(indAirspeed)
    output.encodeUInt16(trueAirspeed)
    output.encodeInt16(xacc)
    output.encodeInt16(yacc)
    output.encodeInt16(zacc)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<HilStateQuaternion> {
    private const val SIZE_V1: Int = 64

    private const val SIZE_V2: Int = 64

    public override val id: UInt = 115u

    public override val crcExtra: Byte = 4

    public override fun deserialize(source: BufferedSource): HilStateQuaternion {
      val timeUsec = source.decodeUInt64()
      val attitudeQuaternion = source.decodeFloatArray(16)
      val rollspeed = source.decodeFloat()
      val pitchspeed = source.decodeFloat()
      val yawspeed = source.decodeFloat()
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val alt = source.decodeInt32()
      val vx = source.decodeInt16()
      val vy = source.decodeInt16()
      val vz = source.decodeInt16()
      val indAirspeed = source.decodeUInt16()
      val trueAirspeed = source.decodeUInt16()
      val xacc = source.decodeInt16()
      val yacc = source.decodeInt16()
      val zacc = source.decodeInt16()

      return HilStateQuaternion(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): HilStateQuaternion =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var attitudeQuaternion: List<Float> = emptyList()

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public var lat: Int = 0

    public var lon: Int = 0

    public var alt: Int = 0

    public var vx: Short = 0

    public var vy: Short = 0

    public var vz: Short = 0

    public var indAirspeed: UShort = 0u

    public var trueAirspeed: UShort = 0u

    public var xacc: Short = 0

    public var yacc: Short = 0

    public var zacc: Short = 0

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
