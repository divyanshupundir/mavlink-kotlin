package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.AdsbEmitterType
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec
 * thereafter)
 */
@GeneratedMavMessage(
  id = 10_001u,
  crcExtra = -47,
)
public data class UavionixAdsbOutCfg(
  /**
   * Vehicle address (24 bit)
   */
  @GeneratedMavField(type = "uint32_t")
  public val icao: UInt = 0u,
  /**
   * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only)
   */
  @GeneratedMavField(type = "char[9]")
  public val callsign: String = "",
  /**
   * Transmitting vehicle type. See ADSB_EMITTER_TYPE enum
   */
  @GeneratedMavField(type = "uint8_t")
  public val emittertype: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0u),
  /**
   * Aircraft length and width encoding (table 2-35 of DO-282B)
   */
  @GeneratedMavField(type = "uint8_t")
  public val aircraftsize: MavEnumValue<UavionixAdsbOutCfgAircraftSize> =
      MavEnumValue.fromValue(0u),
  /**
   * GPS antenna lateral offset (table 2-36 of DO-282B)
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsoffsetlat: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLat> =
      MavEnumValue.fromValue(0u),
  /**
   * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2
   * and add one] (table 2-37 DO-282B)
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsoffsetlon: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLon> =
      MavEnumValue.fromValue(0u),
  /**
   * Aircraft stall speed in cm/s
   */
  @GeneratedMavField(type = "uint16_t")
  public val stallspeed: UShort = 0u,
  /**
   * ADS-B transponder reciever and transmit enable flags
   */
  @GeneratedMavField(type = "uint8_t")
  public val rfselect: MavBitmaskValue<UavionixAdsbOutRfSelect> = MavBitmaskValue.fromValue(0u),
) : MavMessage<UavionixAdsbOutCfg> {
  public override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbOutCfg> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(icao)
    output.encodeUInt16(stallspeed)
    output.encodeString(callsign, 9)
    output.encodeEnumValue(emittertype.value, 1)
    output.encodeEnumValue(aircraftsize.value, 1)
    output.encodeEnumValue(gpsoffsetlat.value, 1)
    output.encodeEnumValue(gpsoffsetlon.value, 1)
    output.encodeBitmaskValue(rfselect.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(icao)
    output.encodeUInt16(stallspeed)
    output.encodeString(callsign, 9)
    output.encodeEnumValue(emittertype.value, 1)
    output.encodeEnumValue(aircraftsize.value, 1)
    output.encodeEnumValue(gpsoffsetlat.value, 1)
    output.encodeEnumValue(gpsoffsetlon.value, 1)
    output.encodeBitmaskValue(rfselect.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbOutCfg> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 10_001u

    public override val crcExtra: Byte = -47

    public override fun deserialize(source: BufferedSource): UavionixAdsbOutCfg {
      val icao = source.decodeUInt32()
      val stallspeed = source.decodeUInt16()
      val callsign = source.decodeString(9)
      val emittertype = source.decodeEnumValue(1).let { value ->
        val entry = AdsbEmitterType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val aircraftsize = source.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutCfgAircraftSize.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gpsoffsetlat = source.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutCfgGpsOffsetLat.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gpsoffsetlon = source.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutCfgGpsOffsetLon.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val rfselect = source.decodeBitmaskValue(1).let { value ->
        val flags = UavionixAdsbOutRfSelect.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return UavionixAdsbOutCfg(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbOutCfg =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var icao: UInt = 0u

    public var callsign: String = ""

    public var emittertype: MavEnumValue<AdsbEmitterType> = MavEnumValue.fromValue(0u)

    public var aircraftsize: MavEnumValue<UavionixAdsbOutCfgAircraftSize> =
        MavEnumValue.fromValue(0u)

    public var gpsoffsetlat: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLat> =
        MavEnumValue.fromValue(0u)

    public var gpsoffsetlon: MavEnumValue<UavionixAdsbOutCfgGpsOffsetLon> =
        MavEnumValue.fromValue(0u)

    public var stallspeed: UShort = 0u

    public var rfselect: MavBitmaskValue<UavionixAdsbOutRfSelect> = MavBitmaskValue.fromValue(0u)

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
