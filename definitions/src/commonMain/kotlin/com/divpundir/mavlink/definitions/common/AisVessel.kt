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
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * The location and information of an AIS vessel
 *
 * @param mmsi Mobile Marine Service Identifier, 9 decimal digits
 * @param lat Latitude
 * units = degE7
 * @param lon Longitude
 * units = degE7
 * @param cog Course over ground
 * units = cdeg
 * @param heading True heading
 * units = cdeg
 * @param velocity Speed over ground
 * units = cm/s
 * @param turnRate Turn rate
 * units = cdeg/s
 * @param navigationalStatus Navigational status
 * @param type Type of vessels
 * @param dimensionBow Distance from lat/lon location to bow
 * units = m
 * @param dimensionStern Distance from lat/lon location to stern
 * units = m
 * @param dimensionPort Distance from lat/lon location to port side
 * units = m
 * @param dimensionStarboard Distance from lat/lon location to starboard side
 * units = m
 * @param callsign The vessel callsign
 * @param name The vessel name
 * @param tslc Time since last communication in seconds
 * units = s
 * @param flags Bitmask to indicate various statuses including valid data fields
 */
@GeneratedMavMessage(
  id = 301u,
  crcExtra = -13,
)
public data class AisVessel(
  /**
   * Mobile Marine Service Identifier, 9 decimal digits
   */
  @GeneratedMavField(type = "uint32_t")
  public val mmsi: UInt = 0u,
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
   * Course over ground
   * units = cdeg
   */
  @GeneratedMavField(type = "uint16_t")
  public val cog: UShort = 0u,
  /**
   * True heading
   * units = cdeg
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: UShort = 0u,
  /**
   * Speed over ground
   * units = cm/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val velocity: UShort = 0u,
  /**
   * Turn rate
   * units = cdeg/s
   */
  @GeneratedMavField(type = "int8_t")
  public val turnRate: Byte = 0,
  /**
   * Navigational status
   */
  @GeneratedMavField(type = "uint8_t")
  public val navigationalStatus: MavEnumValue<AisNavStatus> = MavEnumValue.fromValue(0u),
  /**
   * Type of vessels
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<AisType> = MavEnumValue.fromValue(0u),
  /**
   * Distance from lat/lon location to bow
   * units = m
   */
  @GeneratedMavField(type = "uint16_t")
  public val dimensionBow: UShort = 0u,
  /**
   * Distance from lat/lon location to stern
   * units = m
   */
  @GeneratedMavField(type = "uint16_t")
  public val dimensionStern: UShort = 0u,
  /**
   * Distance from lat/lon location to port side
   * units = m
   */
  @GeneratedMavField(type = "uint8_t")
  public val dimensionPort: UByte = 0u,
  /**
   * Distance from lat/lon location to starboard side
   * units = m
   */
  @GeneratedMavField(type = "uint8_t")
  public val dimensionStarboard: UByte = 0u,
  /**
   * The vessel callsign
   */
  @GeneratedMavField(type = "char[7]")
  public val callsign: String = "",
  /**
   * The vessel name
   */
  @GeneratedMavField(type = "char[20]")
  public val name: String = "",
  /**
   * Time since last communication in seconds
   * units = s
   */
  @GeneratedMavField(type = "uint16_t")
  public val tslc: UShort = 0u,
  /**
   * Bitmask to indicate various statuses including valid data fields
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<AisFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<AisVessel> {
  override val instanceCompanion: MavMessage.MavCompanion<AisVessel> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(mmsi)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeUInt16(cog)
    encoder.encodeUInt16(heading)
    encoder.encodeUInt16(velocity)
    encoder.encodeUInt16(dimensionBow)
    encoder.encodeUInt16(dimensionStern)
    encoder.encodeUInt16(tslc)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeInt8(turnRate)
    encoder.encodeEnumValue(navigationalStatus.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(dimensionPort)
    encoder.encodeUInt8(dimensionStarboard)
    encoder.encodeString(callsign, 7)
    encoder.encodeString(name, 20)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(mmsi)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeUInt16(cog)
    encoder.encodeUInt16(heading)
    encoder.encodeUInt16(velocity)
    encoder.encodeUInt16(dimensionBow)
    encoder.encodeUInt16(dimensionStern)
    encoder.encodeUInt16(tslc)
    encoder.encodeBitmaskValue(flags.value, 2)
    encoder.encodeInt8(turnRate)
    encoder.encodeEnumValue(navigationalStatus.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(dimensionPort)
    encoder.encodeUInt8(dimensionStarboard)
    encoder.encodeString(callsign, 7)
    encoder.encodeString(name, 20)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AisVessel> {
    private const val SIZE_V1: Int = 58

    private const val SIZE_V2: Int = 58

    override val id: UInt = 301u

    override val crcExtra: Byte = -13

    override fun deserialize(bytes: ByteArray): AisVessel {
      val decoder = MavDataDecoder(bytes)

      val mmsi = decoder.safeDecodeUInt32()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val cog = decoder.safeDecodeUInt16()
      val heading = decoder.safeDecodeUInt16()
      val velocity = decoder.safeDecodeUInt16()
      val dimensionBow = decoder.safeDecodeUInt16()
      val dimensionStern = decoder.safeDecodeUInt16()
      val tslc = decoder.safeDecodeUInt16()
      val flags = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = AisFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val turnRate = decoder.safeDecodeInt8()
      val navigationalStatus = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AisNavStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AisType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dimensionPort = decoder.safeDecodeUInt8()
      val dimensionStarboard = decoder.safeDecodeUInt8()
      val callsign = decoder.safeDecodeString(7)
      val name = decoder.safeDecodeString(20)

      return AisVessel(
        mmsi = mmsi,
        lat = lat,
        lon = lon,
        cog = cog,
        heading = heading,
        velocity = velocity,
        turnRate = turnRate,
        navigationalStatus = navigationalStatus,
        type = type,
        dimensionBow = dimensionBow,
        dimensionStern = dimensionStern,
        dimensionPort = dimensionPort,
        dimensionStarboard = dimensionStarboard,
        callsign = callsign,
        name = name,
        tslc = tslc,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AisVessel =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mmsi: UInt = 0u

    public var lat: Int = 0

    public var lon: Int = 0

    public var cog: UShort = 0u

    public var heading: UShort = 0u

    public var velocity: UShort = 0u

    public var turnRate: Byte = 0

    public var navigationalStatus: MavEnumValue<AisNavStatus> = MavEnumValue.fromValue(0u)

    public var type: MavEnumValue<AisType> = MavEnumValue.fromValue(0u)

    public var dimensionBow: UShort = 0u

    public var dimensionStern: UShort = 0u

    public var dimensionPort: UByte = 0u

    public var dimensionStarboard: UByte = 0u

    public var callsign: String = ""

    public var name: String = ""

    public var tslc: UShort = 0u

    public var flags: MavBitmaskValue<AisFlags> = MavBitmaskValue.fromValue(0u)

    public fun build(): AisVessel = AisVessel(
      mmsi = mmsi,
      lat = lat,
      lon = lon,
      cog = cog,
      heading = heading,
      velocity = velocity,
      turnRate = turnRate,
      navigationalStatus = navigationalStatus,
      type = type,
      dimensionBow = dimensionBow,
      dimensionStern = dimensionStern,
      dimensionPort = dimensionPort,
      dimensionStarboard = dimensionStarboard,
      callsign = callsign,
      name = name,
      tslc = tslc,
      flags = flags,
    )
  }
}
