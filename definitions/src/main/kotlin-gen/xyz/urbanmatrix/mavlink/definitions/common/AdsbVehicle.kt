package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * The location and information of an ADSB vehicle
 */
@GeneratedMavMessage(
  id = 246,
  crc = 184,
)
public data class AdsbVehicle(
  /**
   * ICAO address
   */
  public val icaoAddress: Long = 0L,
  /**
   * Latitude
   */
  public val lat: Int = 0,
  /**
   * Longitude
   */
  public val lon: Int = 0,
  /**
   * ADSB altitude type.
   */
  public val altitudeType: MavEnumValue<AdsbAltitudeType> = MavEnumValue.fromValue(0),
  /**
   * Altitude(ASL)
   */
  public val altitude: Int = 0,
  /**
   * Course over ground
   */
  public val heading: Int = 0,
  /**
   * The horizontal velocity
   */
  public val horVelocity: Int = 0,
  /**
   * The vertical velocity. Positive is up
   */
  public val verVelocity: Int = 0,
  /**
   * The callsign, 8+null
   */
  public val callsign: String = "",
  /**
   * ADSB emitter type.
   */
  public val emitterType: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0),
  /**
   * Time since last communication in seconds
   */
  public val tslc: Int = 0,
  /**
   * Bitmap to indicate various statuses including valid data fields
   */
  public val flags: MavEnumValue<AdsbFlags> = MavEnumValue.fromValue(0),
  /**
   * Squawk code
   */
  public val squawk: Int = 0,
) : MavMessage<AdsbVehicle> {
  public override val instanceMetadata: MavMessage.Metadata<AdsbVehicle> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(icaoAddress)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeInt32(altitude)
    outputBuffer.encodeUint16(heading)
    outputBuffer.encodeUint16(horVelocity)
    outputBuffer.encodeInt16(verVelocity)
    outputBuffer.encodeEnumValue(flags.value, 2)
    outputBuffer.encodeUint16(squawk)
    outputBuffer.encodeEnumValue(altitudeType.value, 1)
    outputBuffer.encodeString(callsign, 9)
    outputBuffer.encodeEnumValue(emitterType.value, 1)
    outputBuffer.encodeUint8(tslc)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 246

    private const val CRC: Int = 184

    private const val SIZE: Int = 38

    private val DESERIALIZER: MavDeserializer<AdsbVehicle> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val icaoAddress = inputBuffer.decodeUint32()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val altitude = inputBuffer.decodeInt32()
      val heading = inputBuffer.decodeUint16()
      val horVelocity = inputBuffer.decodeUint16()
      val verVelocity = inputBuffer.decodeInt16()
      val flags = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = AdsbFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val squawk = inputBuffer.decodeUint16()
      val altitudeType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = AdsbAltitudeType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val callsign = inputBuffer.decodeString(9)
      val emitterType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = AdsbEmitterType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val tslc = inputBuffer.decodeUint8()

      AdsbVehicle(
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


    private val METADATA: MavMessage.Metadata<AdsbVehicle> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AdsbVehicle> = METADATA
  }
}
