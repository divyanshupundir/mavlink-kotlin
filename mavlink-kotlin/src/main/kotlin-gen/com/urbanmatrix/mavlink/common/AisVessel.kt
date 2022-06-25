package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeInt8
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * The location and information of an AIS vessel
 */
public data class AisVessel(
  /**
   * Mobile Marine Service Identifier, 9 decimal digits
   */
  public val mmsi: Long = 0L,
  /**
   * Latitude
   */
  public val lat: Int = 0,
  /**
   * Longitude
   */
  public val lon: Int = 0,
  /**
   * Course over ground
   */
  public val cog: Int = 0,
  /**
   * True heading
   */
  public val heading: Int = 0,
  /**
   * Speed over ground
   */
  public val velocity: Int = 0,
  /**
   * Turn rate
   */
  public val turnRate: Int = 0,
  /**
   * Navigational status
   */
  public val navigationalStatus: MavEnumValue<AisNavStatus> = MavEnumValue.fromValue(0),
  /**
   * Type of vessels
   */
  public val type: MavEnumValue<AisType> = MavEnumValue.fromValue(0),
  /**
   * Distance from lat/lon location to bow
   */
  public val dimensionBow: Int = 0,
  /**
   * Distance from lat/lon location to stern
   */
  public val dimensionStern: Int = 0,
  /**
   * Distance from lat/lon location to port side
   */
  public val dimensionPort: Int = 0,
  /**
   * Distance from lat/lon location to starboard side
   */
  public val dimensionStarboard: Int = 0,
  /**
   * The vessel callsign
   */
  public val callsign: String = "",
  /**
   * The vessel name
   */
  public val name: String = "",
  /**
   * Time since last communication in seconds
   */
  public val tslc: Int = 0,
  /**
   * Bitmask to indicate various statuses including valid data fields
   */
  public val flags: MavEnumValue<AisFlags> = MavEnumValue.fromValue(0),
) : MavMessage<AisVessel> {
  public override val instanceMetadata: MavMessage.Metadata<AisVessel> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(58).order(ByteOrder.LITTLE_ENDIAN)
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

  public companion object {
    private const val ID: Int = 301

    private const val CRC: Int = 95

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
  }
}
