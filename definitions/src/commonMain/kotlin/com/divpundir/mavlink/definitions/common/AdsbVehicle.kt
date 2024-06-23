package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
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

/**
 * The location and information of an ADSB vehicle
 *
 * @param icaoAddress ICAO address
 * @param lat Latitude
 * units = degE7
 * @param lon Longitude
 * units = degE7
 * @param altitudeType ADSB altitude type.
 * @param altitude Altitude(ASL)
 * units = mm
 * @param heading Course over ground
 * units = cdeg
 * @param horVelocity The horizontal velocity
 * units = cm/s
 * @param verVelocity The vertical velocity. Positive is up
 * units = cm/s
 * @param callsign The callsign, 8+null
 * @param emitterType ADSB emitter type.
 * @param tslc Time since last communication in seconds
 * units = s
 * @param flags Bitmap to indicate various statuses including valid data fields
 * @param squawk Squawk code. Note that the code is in decimal: e.g. 7700 (general emergency) is
 * encoded as binary 0b0001_1110_0001_0100, not(!) as 0b0000_111_111_000_000
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
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   * units = degE7
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
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val altitude: Int = 0,
  /**
   * Course over ground
   * units = cdeg
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: UShort = 0u,
  /**
   * The horizontal velocity
   * units = cm/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val horVelocity: UShort = 0u,
  /**
   * The vertical velocity. Positive is up
   * units = cm/s
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
   * units = s
   */
  @GeneratedMavField(type = "uint8_t")
  public val tslc: UByte = 0u,
  /**
   * Bitmap to indicate various statuses including valid data fields
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<AdsbFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Squawk code. Note that the code is in decimal: e.g. 7700 (general emergency) is encoded as
   * binary 0b0001_1110_0001_0100, not(!) as 0b0000_111_111_000_000
   */
  @GeneratedMavField(type = "uint16_t")
  public val squawk: UShort = 0u,
) : MavMessage<AdsbVehicle> {
  override val instanceCompanion: MavMessage.MavCompanion<AdsbVehicle> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(icaoAddress)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(altitude)
    encoder.encodeUInt16(heading)
    encoder.encodeUInt16(horVelocity)
    encoder.encodeInt16(verVelocity)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt16(squawk)
    encoder.encodeEnumValue(altitudeType.value, 1)
    encoder.encodeString(callsign, 9)
    encoder.encodeEnumValue(emitterType.value, 1)
    encoder.encodeUInt8(tslc)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(icaoAddress)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeInt32(altitude)
    encoder.encodeUInt16(heading)
    encoder.encodeUInt16(horVelocity)
    encoder.encodeInt16(verVelocity)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeUInt16(squawk)
    encoder.encodeEnumValue(altitudeType.value, 1)
    encoder.encodeString(callsign, 9)
    encoder.encodeEnumValue(emitterType.value, 1)
    encoder.encodeUInt8(tslc)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AdsbVehicle> {
    private const val SIZE_V1: Int = 38

    private const val SIZE_V2: Int = 38

    override val id: UInt = 246u

    override val crcExtra: Byte = -72

    override fun deserialize(bytes: ByteArray): AdsbVehicle {
      val decoder = MavDataDecoder(bytes)

      val icaoAddress = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val altitude = decoder.safeDecodeInt32()
      val heading = decoder.safeDecodeUInt16()
      val horVelocity = decoder.safeDecodeUInt16()
      val verVelocity = decoder.safeDecodeInt16()
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = AdsbFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val squawk = decoder.safeDecodeUInt16()
      val altitudeType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AdsbAltitudeType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val callsign = decoder.safeDecodeString(9)
      val emitterType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AdsbEmitterType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val tslc = decoder.safeDecodeUInt8()

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
