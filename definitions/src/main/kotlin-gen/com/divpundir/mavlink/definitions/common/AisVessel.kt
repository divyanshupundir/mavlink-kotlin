package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * The location and information of an AIS vessel
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
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Course over ground
   */
  @GeneratedMavField(type = "uint16_t")
  public val cog: UShort = 0u,
  /**
   * True heading
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: UShort = 0u,
  /**
   * Speed over ground
   */
  @GeneratedMavField(type = "uint16_t")
  public val velocity: UShort = 0u,
  /**
   * Turn rate
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
   */
  @GeneratedMavField(type = "uint16_t")
  public val dimensionBow: UShort = 0u,
  /**
   * Distance from lat/lon location to stern
   */
  @GeneratedMavField(type = "uint16_t")
  public val dimensionStern: UShort = 0u,
  /**
   * Distance from lat/lon location to port side
   */
  @GeneratedMavField(type = "uint8_t")
  public val dimensionPort: UByte = 0u,
  /**
   * Distance from lat/lon location to starboard side
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
   */
  @GeneratedMavField(type = "uint16_t")
  public val tslc: UShort = 0u,
  /**
   * Bitmask to indicate various statuses including valid data fields
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavBitmaskValue<AisFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<AisVessel> {
  public override val instanceCompanion: MavMessage.MavCompanion<AisVessel> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(mmsi)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeUInt16(cog)
    buffer.encodeUInt16(heading)
    buffer.encodeUInt16(velocity)
    buffer.encodeUInt16(dimensionBow)
    buffer.encodeUInt16(dimensionStern)
    buffer.encodeUInt16(tslc)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeInt8(turnRate)
    buffer.encodeEnumValue(navigationalStatus.value, 1)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeUInt8(dimensionPort)
    buffer.encodeUInt8(dimensionStarboard)
    buffer.encodeString(callsign, 7)
    buffer.encodeString(name, 20)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(mmsi)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeUInt16(cog)
    buffer.encodeUInt16(heading)
    buffer.encodeUInt16(velocity)
    buffer.encodeUInt16(dimensionBow)
    buffer.encodeUInt16(dimensionStern)
    buffer.encodeUInt16(tslc)
    buffer.encodeBitmaskValue(flags.value, 2)
    buffer.encodeInt8(turnRate)
    buffer.encodeEnumValue(navigationalStatus.value, 1)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeUInt8(dimensionPort)
    buffer.encodeUInt8(dimensionStarboard)
    buffer.encodeString(callsign, 7)
    buffer.encodeString(name, 20)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AisVessel> {
    public override val id: UInt = 301u

    public override val crcExtra: Byte = -13

    public override fun deserialize(bytes: ByteArray): AisVessel {
      val buffer = Buffer().write(bytes)

      val mmsi = buffer.decodeUInt32()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val cog = buffer.decodeUInt16()
      val heading = buffer.decodeUInt16()
      val velocity = buffer.decodeUInt16()
      val dimensionBow = buffer.decodeUInt16()
      val dimensionStern = buffer.decodeUInt16()
      val tslc = buffer.decodeUInt16()
      val flags = buffer.decodeBitmaskValue(2).let { value ->
        val flags = AisFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val turnRate = buffer.decodeInt8()
      val navigationalStatus = buffer.decodeEnumValue(1).let { value ->
        val entry = AisNavStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = buffer.decodeEnumValue(1).let { value ->
        val entry = AisType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dimensionPort = buffer.decodeUInt8()
      val dimensionStarboard = buffer.decodeUInt8()
      val callsign = buffer.decodeString(7)
      val name = buffer.decodeString(20)

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
