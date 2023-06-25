package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * The location and information of an ADSB vehicle
 */
@GeneratedMavMessage(
  id = 246u,
  crcExtra = -72,
)
public data class AdsbVehicle(
  /**
   * ICAO address
   */
  @GeneratedMavField(type = "uint32_t")
  public val icaoAddress: UInt = 0u,
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
   * ADSB altitude type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val altitudeType: MavEnumValue<AdsbAltitudeType> = MavEnumValue.fromValue(0u),
  /**
   * Altitude(ASL)
   */
  @GeneratedMavField(type = "int32_t")
  public val altitude: Int = 0,
  /**
   * Course over ground
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: UShort = 0u,
  /**
   * The horizontal velocity
   */
  @GeneratedMavField(type = "uint16_t")
  public val horVelocity: UShort = 0u,
  /**
   * The vertical velocity. Positive is up
   */
  @GeneratedMavField(type = "int16_t")
  public val verVelocity: Short = 0,
  /**
   * The callsign, 8+null
   */
  @GeneratedMavField(type = "char[9]")
  public val callsign: String = "",
  /**
   * ADSB emitter type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val emitterType: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0u),
  /**
   * Time since last communication in seconds
   */
  @GeneratedMavField(type = "uint8_t")
  public val tslc: UByte = 0u,
  /**
   * Bitmap to indicate various statuses including valid data fields
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<AdsbFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Squawk code
   */
  @GeneratedMavField(type = "uint16_t")
  public val squawk: UShort = 0u,
) : MavMessage<AdsbVehicle> {
  public override val instanceCompanion: MavMessage.MavCompanion<AdsbVehicle> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(icaoAddress)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(altitude)
    buffer.encodeUInt16(heading)
    buffer.encodeUInt16(horVelocity)
    buffer.encodeInt16(verVelocity)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeUInt16(squawk)
    buffer.encodeEnumValue(altitudeType.value, 1)
    buffer.encodeString(callsign, 9)
    buffer.encodeEnumValue(emitterType.value, 1)
    buffer.encodeUInt8(tslc)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(icaoAddress)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeInt32(altitude)
    buffer.encodeUInt16(heading)
    buffer.encodeUInt16(horVelocity)
    buffer.encodeInt16(verVelocity)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeUInt16(squawk)
    buffer.encodeEnumValue(altitudeType.value, 1)
    buffer.encodeString(callsign, 9)
    buffer.encodeEnumValue(emitterType.value, 1)
    buffer.encodeUInt8(tslc)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AdsbVehicle> {
    public override val id: UInt = 246u

    public override val crcExtra: Byte = -72

    public override fun deserialize(bytes: ByteArray): AdsbVehicle {
      val buffer = Buffer().write(bytes)

      val icaoAddress = buffer.decodeUInt32()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val altitude = buffer.decodeInt32()
      val heading = buffer.decodeUInt16()
      val horVelocity = buffer.decodeUInt16()
      val verVelocity = buffer.decodeInt16()
      val flags = buffer.decodeBitmaskValue(2).let { value ->
        val flags = AdsbFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val squawk = buffer.decodeUInt16()
      val altitudeType = buffer.decodeEnumValue(1).let { value ->
        val entry = AdsbAltitudeType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val callsign = buffer.decodeString(9)
      val emitterType = buffer.decodeEnumValue(1).let { value ->
        val entry = AdsbEmitterType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val tslc = buffer.decodeUInt8()

      return AdsbVehicle(
        icaoAddress = icaoAddress,
        lat = lat,
        lon = lon,
        altitudeType = altitudeType,
        altitude = altitude,
        heading = heading,
        horVelocity = horVelocity,
        verVelocity = verVelocity,
        callsign = callsign,
        emitterType = emitterType,
        tslc = tslc,
        flags = flags,
        squawk = squawk,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AdsbVehicle =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var icaoAddress: UInt = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var altitudeType: MavEnumValue<AdsbAltitudeType> = MavEnumValue.fromValue(0u)

    public var altitude: Int = 0

    public var heading: UShort = 0u

    public var horVelocity: UShort = 0u

    public var verVelocity: Short = 0

    public var callsign: String = ""

    public var emitterType: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0u)

    public var tslc: UByte = 0u

    public var flags: MavBitmaskValue<AdsbFlags> = MavBitmaskValue.fromValue(0u)

    public var squawk: UShort = 0u

    public fun build(): AdsbVehicle = AdsbVehicle(
      icaoAddress = icaoAddress,
      lat = lat,
      lon = lon,
      altitudeType = altitudeType,
      altitude = altitude,
      heading = heading,
      horVelocity = horVelocity,
      verVelocity = verVelocity,
      callsign = callsign,
      emitterType = emitterType,
      tslc = tslc,
      flags = flags,
      squawk = squawk,
    )
  }
}
