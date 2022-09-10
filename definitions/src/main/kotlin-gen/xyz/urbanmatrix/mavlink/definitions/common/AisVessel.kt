package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The location and information of an AIS vessel
 */
@GeneratedMavMessage(
  id = 301,
  crc = 243,
)
public data class AisVessel(
  /**
   * Mobile Marine Service Identifier, 9 decimal digits
   */
  @GeneratedMavField(type = "uint32_t")
  public val mmsi: Long = 0L,
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
  public val cog: Int = 0,
  /**
   * True heading
   */
  @GeneratedMavField(type = "uint16_t")
  public val heading: Int = 0,
  /**
   * Speed over ground
   */
  @GeneratedMavField(type = "uint16_t")
  public val velocity: Int = 0,
  /**
   * Turn rate
   */
  @GeneratedMavField(type = "int8_t")
  public val turnRate: Int = 0,
  /**
   * Navigational status
   */
  @GeneratedMavField(type = "uint8_t")
  public val navigationalStatus: MavEnumValue<AisNavStatus> = MavEnumValue.fromValue(0),
  /**
   * Type of vessels
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<AisType> = MavEnumValue.fromValue(0),
  /**
   * Distance from lat/lon location to bow
   */
  @GeneratedMavField(type = "uint16_t")
  public val dimensionBow: Int = 0,
  /**
   * Distance from lat/lon location to stern
   */
  @GeneratedMavField(type = "uint16_t")
  public val dimensionStern: Int = 0,
  /**
   * Distance from lat/lon location to port side
   */
  @GeneratedMavField(type = "uint8_t")
  public val dimensionPort: Int = 0,
  /**
   * Distance from lat/lon location to starboard side
   */
  @GeneratedMavField(type = "uint8_t")
  public val dimensionStarboard: Int = 0,
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
  public val tslc: Int = 0,
  /**
   * Bitmask to indicate various statuses including valid data fields
   */
  @GeneratedMavField(type = "uint16_t")
  public val flags: MavEnumValue<AisFlags> = MavEnumValue.fromValue(0),
) : MavMessage<AisVessel> {
  public override val instanceMetadata: MavMessage.Metadata<AisVessel> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(mmsi)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUint16(cog)
    outputBuffer.encodeUint16(heading)
    outputBuffer.encodeUint16(velocity)
    outputBuffer.encodeUint16(dimensionBow)
    outputBuffer.encodeUint16(dimensionStern)
    outputBuffer.encodeUint16(tslc)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeInt8(turnRate)
    outputBuffer.encodeEnumValue(navigationalStatus.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(dimensionPort)
    outputBuffer.encodeUint8(dimensionStarboard)
    outputBuffer.encodeString(callsign, 7)
    outputBuffer.encodeString(name, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(mmsi)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUint16(cog)
    outputBuffer.encodeUint16(heading)
    outputBuffer.encodeUint16(velocity)
    outputBuffer.encodeUint16(dimensionBow)
    outputBuffer.encodeUint16(dimensionStern)
    outputBuffer.encodeUint16(tslc)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeInt8(turnRate)
    outputBuffer.encodeEnumValue(navigationalStatus.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(dimensionPort)
    outputBuffer.encodeUint8(dimensionStarboard)
    outputBuffer.encodeString(callsign, 7)
    outputBuffer.encodeString(name, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 301

    private const val CRC: Int = 243

    private const val SIZE: Int = 58

    private val DESERIALIZER: MavDeserializer<AisVessel> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mmsi = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val cog = inputBuffer.decodeUint16()
      val heading = inputBuffer.decodeUint16()
      val velocity = inputBuffer.decodeUint16()
      val dimensionBow = inputBuffer.decodeUint16()
      val dimensionStern = inputBuffer.decodeUint16()
      val tslc = inputBuffer.decodeUint16()
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = AisFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
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
      val dimensionPort = inputBuffer.decodeUint8()
      val dimensionStarboard = inputBuffer.decodeUint8()
      val callsign = inputBuffer.decodeString(7)
      val name = inputBuffer.decodeString(20)

      AisVessel(
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


    private val METADATA: MavMessage.Metadata<AisVessel> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AisVessel> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mmsi: Long = 0L

    public var lat: Int = 0

    public var lon: Int = 0

    public var cog: Int = 0

    public var heading: Int = 0

    public var velocity: Int = 0

    public var turnRate: Int = 0

    public var navigationalStatus: MavEnumValue<AisNavStatus> = MavEnumValue.fromValue(0)

    public var type: MavEnumValue<AisType> = MavEnumValue.fromValue(0)

    public var dimensionBow: Int = 0

    public var dimensionStern: Int = 0

    public var dimensionPort: Int = 0

    public var dimensionStarboard: Int = 0

    public var callsign: String = ""

    public var name: String = ""

    public var tslc: Int = 0

    public var flags: MavEnumValue<AisFlags> = MavEnumValue.fromValue(0)

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
