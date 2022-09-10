package xyz.urbanmatrix.mavlink.definitions.uavionix

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
import xyz.urbanmatrix.mavlink.definitions.common.AdsbEmitterType
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec
 * thereafter)
 */
@GeneratedMavMessage(
  id = 10001,
  crc = 209,
)
public data class UavionixAdsbOutCfg(
  /**
   * Vehicle address (24 bit)
   */
  @GeneratedMavField(type = "uint32_t")
  public val icao: Long = 0L,
  /**
   * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only)
   */
  @GeneratedMavField(type = "char[9]")
  public val callsign: String = "",
  /**
   * Transmitting vehicle type. See ADSB_EMITTER_TYPE enum
   */
  @GeneratedMavField(type = "uint8_t")
  public val emittertype: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0),
  /**
   * Aircraft length and width encoding (table 2-35 of DO-282B)
   */
  @GeneratedMavField(type = "uint8_t")
  public val aircraftsize: MavEnumValue<UavionixAdsbOutCfgAircraftSize> = MavEnumValue.fromValue(0),
  /**
   * GPS antenna lateral offset (table 2-36 of DO-282B)
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsoffsetlat: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLat> = MavEnumValue.fromValue(0),
  /**
   * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2
   * and add one] (table 2-37 DO-282B)
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsoffsetlon: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLon> = MavEnumValue.fromValue(0),
  /**
   * Aircraft stall speed in cm/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val stallspeed: Int = 0,
  /**
   * ADS-B transponder reciever and transmit enable flags
   */
  @GeneratedMavField(type = "uint8_t")
  public val rfselect: MavEnumValue<UavionixAdsbOutRfSelect> = MavEnumValue.fromValue(0),
) : MavMessage<UavionixAdsbOutCfg> {
  public override val instanceMetadata: MavMessage.Metadata<UavionixAdsbOutCfg> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(icao)
    outputBuffer.encodeUint16(stallspeed)
    outputBuffer.encodeString(callsign, 9)
    outputBuffer.encodeEnumValue(emittertype.value, 1)
    outputBuffer.encodeEnumValue(aircraftsize.value, 1)
    outputBuffer.encodeEnumValue(gpsoffsetlat.value, 1)
    outputBuffer.encodeEnumValue(gpsoffsetlon.value, 1)
    outputBuffer.encodeEnumValue(rfselect.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(icao)
    outputBuffer.encodeUint16(stallspeed)
    outputBuffer.encodeString(callsign, 9)
    outputBuffer.encodeEnumValue(emittertype.value, 1)
    outputBuffer.encodeEnumValue(aircraftsize.value, 1)
    outputBuffer.encodeEnumValue(gpsoffsetlat.value, 1)
    outputBuffer.encodeEnumValue(gpsoffsetlon.value, 1)
    outputBuffer.encodeEnumValue(rfselect.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 10001

    private const val CRC: Int = 209

    private const val SIZE: Int = 20

    private val DESERIALIZER: MavDeserializer<UavionixAdsbOutCfg> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val icao = inputBuffer.decodeUint32()
      val stallspeed = inputBuffer.decodeUint16()
      val callsign = inputBuffer.decodeString(9)
      val emittertype = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = AdsbEmitterType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val aircraftsize = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutCfgAircraftSize.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gpsoffsetlat = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutCfgGpsOffsetLat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gpsoffsetlon = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutCfgGpsOffsetLon.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rfselect = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutRfSelect.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      UavionixAdsbOutCfg(
        icao = icao,
        callsign = callsign,
        emittertype = emittertype,
        aircraftsize = aircraftsize,
        gpsoffsetlat = gpsoffsetlat,
        gpsoffsetlon = gpsoffsetlon,
        stallspeed = stallspeed,
        rfselect = rfselect,
      )
    }


    private val METADATA: MavMessage.Metadata<UavionixAdsbOutCfg> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavionixAdsbOutCfg> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var icao: Long = 0L

    public var callsign: String = ""

    public var emittertype: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0)

    public var aircraftsize: MavEnumValue<UavionixAdsbOutCfgAircraftSize> =
        MavEnumValue.fromValue(0)

    public var gpsoffsetlat: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLat> =
        MavEnumValue.fromValue(0)

    public var gpsoffsetlon: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLon> =
        MavEnumValue.fromValue(0)

    public var stallspeed: Int = 0

    public var rfselect: MavEnumValue<UavionixAdsbOutRfSelect> = MavEnumValue.fromValue(0)

    public fun build(): UavionixAdsbOutCfg = UavionixAdsbOutCfg(
      icao = icao,
      callsign = callsign,
      emittertype = emittertype,
      aircraftsize = aircraftsize,
      gpsoffsetlat = gpsoffsetlat,
      gpsoffsetlon = gpsoffsetlon,
      stallspeed = stallspeed,
      rfselect = rfselect,
    )
  }
}
