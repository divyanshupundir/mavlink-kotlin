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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(mmsi)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUInt16(cog)
    outputBuffer.encodeUInt16(heading)
    outputBuffer.encodeUInt16(velocity)
    outputBuffer.encodeUInt16(dimensionBow)
    outputBuffer.encodeUInt16(dimensionStern)
    outputBuffer.encodeUInt16(tslc)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    outputBuffer.encodeInt8(turnRate)
    outputBuffer.encodeEnumValue(navigationalStatus.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(dimensionPort)
    outputBuffer.encodeUInt8(dimensionStarboard)
    outputBuffer.encodeString(callsign, 7)
    outputBuffer.encodeString(name, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(mmsi)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUInt16(cog)
    outputBuffer.encodeUInt16(heading)
    outputBuffer.encodeUInt16(velocity)
    outputBuffer.encodeUInt16(dimensionBow)
    outputBuffer.encodeUInt16(dimensionStern)
    outputBuffer.encodeUInt16(tslc)
    outputBuffer.encodeBitmaskValue(flags.value, 2)
    outputBuffer.encodeInt8(turnRate)
    outputBuffer.encodeEnumValue(navigationalStatus.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(dimensionPort)
    outputBuffer.encodeUInt8(dimensionStarboard)
    outputBuffer.encodeString(callsign, 7)
    outputBuffer.encodeString(name, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AisVessel> {
    private const val SIZE_V1: Int = 58

    private const val SIZE_V2: Int = 58

    public override val id: UInt = 301u

    public override val crcExtra: Byte = -13

    public override fun deserialize(bytes: ByteArray): AisVessel {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mmsi = inputBuffer.decodeUInt32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val cog = inputBuffer.decodeUInt16()
      val heading = inputBuffer.decodeUInt16()
      val velocity = inputBuffer.decodeUInt16()
      val dimensionBow = inputBuffer.decodeUInt16()
      val dimensionStern = inputBuffer.decodeUInt16()
      val tslc = inputBuffer.decodeUInt16()
      val flags = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = AisFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val turnRate = inputBuffer.decodeInt8()
      val navigationalStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = AisNavStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = AisType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dimensionPort = inputBuffer.decodeUInt8()
      val dimensionStarboard = inputBuffer.decodeUInt8()
      val callsign = inputBuffer.decodeString(7)
      val name = inputBuffer.decodeString(20)

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
