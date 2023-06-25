package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Dynamic data used to generate ADS-B out transponder data (send at 5Hz)
 */
@GeneratedMavMessage(
  id = 10_002u,
  crcExtra = -70,
)
public data class UavionixAdsbOutDynamic(
  /**
   * UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX
   */
  @GeneratedMavField(type = "uint32_t")
  public val utctime: UInt = 0u,
  /**
   * Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX
   */
  @GeneratedMavField(type = "int32_t")
  public val gpslat: Int = 0,
  /**
   * Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX
   */
  @GeneratedMavField(type = "int32_t")
  public val gpslon: Int = 0,
  /**
   * Altitude (WGS84). UP +ve. If unknown set to INT32_MAX
   */
  @GeneratedMavField(type = "int32_t")
  public val gpsalt: Int = 0,
  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK
   */
  @GeneratedMavField(type = "uint8_t")
  public val gpsfix: MavEnumValue<UavionixAdsbOutDynamicGpsFix> = MavEnumValue.fromValue(0u),
  /**
   * Number of satellites visible. If unknown set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val numsats: UByte = 0u,
  /**
   * Barometric pressure altitude (MSL) relative to a standard atmosphere of 1013.2 mBar and NOT bar
   * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX
   */
  @GeneratedMavField(type = "int32_t")
  public val baroaltmsl: Int = 0,
  /**
   * Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX
   */
  @GeneratedMavField(type = "uint32_t")
  public val accuracyhor: UInt = 0u,
  /**
   * Vertical accuracy in cm. If unknown set to UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val accuracyvert: UShort = 0u,
  /**
   * Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val accuracyvel: UShort = 0u,
  /**
   * GPS vertical speed in cm/s. If unknown set to INT16_MAX
   */
  @GeneratedMavField(type = "int16_t")
  public val velvert: Short = 0,
  /**
   * North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX
   */
  @GeneratedMavField(type = "int16_t")
  public val velns: Short = 0,
  /**
   * East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX
   */
  @GeneratedMavField(type = "int16_t")
  public val velew: Short = 0,
  /**
   * Emergency status
   */
  @GeneratedMavField(type = "uint8_t")
  public val emergencystatus: MavEnumValue<UavionixAdsbEmergencyStatus> =
      MavEnumValue.fromValue(0u),
  /**
   * ADS-B transponder dynamic input state flags
   */
  @GeneratedMavField(type = "uint16_t")
  public val state: MavBitmaskValue<UavionixAdsbOutDynamicState> = MavBitmaskValue.fromValue(0u),
  /**
   * Mode A code (typically 1200 [0x04B0] for VFR)
   */
  @GeneratedMavField(type = "uint16_t")
  public val squawk: UShort = 0u,
) : MavMessage<UavionixAdsbOutDynamic> {
  public override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbOutDynamic> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(utctime)
    buffer.encodeInt32(gpslat)
    buffer.encodeInt32(gpslon)
    buffer.encodeInt32(gpsalt)
    buffer.encodeInt32(baroaltmsl)
    buffer.encodeUInt32(accuracyhor)
    buffer.encodeUInt16(accuracyvert)
    buffer.encodeUInt16(accuracyvel)
    buffer.encodeInt16(velvert)
    buffer.encodeInt16(velns)
    buffer.encodeInt16(velew)
    buffer.encodeBitmaskValue(state.value, 2)
    buffer.encodeUInt16(squawk)
    buffer.encodeEnumValue(gpsfix.value, 1)
    buffer.encodeUInt8(numsats)
    buffer.encodeEnumValue(emergencystatus.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(utctime)
    buffer.encodeInt32(gpslat)
    buffer.encodeInt32(gpslon)
    buffer.encodeInt32(gpsalt)
    buffer.encodeInt32(baroaltmsl)
    buffer.encodeUInt32(accuracyhor)
    buffer.encodeUInt16(accuracyvert)
    buffer.encodeUInt16(accuracyvel)
    buffer.encodeInt16(velvert)
    buffer.encodeInt16(velns)
    buffer.encodeInt16(velew)
    buffer.encodeBitmaskValue(state.value, 2)
    buffer.encodeUInt16(squawk)
    buffer.encodeEnumValue(gpsfix.value, 1)
    buffer.encodeUInt8(numsats)
    buffer.encodeEnumValue(emergencystatus.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbOutDynamic> {
    public override val id: UInt = 10_002u

    public override val crcExtra: Byte = -70

    public override fun deserialize(bytes: ByteArray): UavionixAdsbOutDynamic {
      val buffer = Buffer().write(bytes)

      val utctime = buffer.decodeUInt32()
      val gpslat = buffer.decodeInt32()
      val gpslon = buffer.decodeInt32()
      val gpsalt = buffer.decodeInt32()
      val baroaltmsl = buffer.decodeInt32()
      val accuracyhor = buffer.decodeUInt32()
      val accuracyvert = buffer.decodeUInt16()
      val accuracyvel = buffer.decodeUInt16()
      val velvert = buffer.decodeInt16()
      val velns = buffer.decodeInt16()
      val velew = buffer.decodeInt16()
      val state = buffer.decodeBitmaskValue(2).let { value ->
        val flags = UavionixAdsbOutDynamicState.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val squawk = buffer.decodeUInt16()
      val gpsfix = buffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutDynamicGpsFix.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val numsats = buffer.decodeUInt8()
      val emergencystatus = buffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbEmergencyStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return UavionixAdsbOutDynamic(
        utctime = utctime,
        gpslat = gpslat,
        gpslon = gpslon,
        gpsalt = gpsalt,
        gpsfix = gpsfix,
        numsats = numsats,
        baroaltmsl = baroaltmsl,
        accuracyhor = accuracyhor,
        accuracyvert = accuracyvert,
        accuracyvel = accuracyvel,
        velvert = velvert,
        velns = velns,
        velew = velew,
        emergencystatus = emergencystatus,
        state = state,
        squawk = squawk,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbOutDynamic =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var utctime: UInt = 0u

    public var gpslat: Int = 0

    public var gpslon: Int = 0

    public var gpsalt: Int = 0

    public var gpsfix: MavEnumValue<UavionixAdsbOutDynamicGpsFix> = MavEnumValue.fromValue(0u)

    public var numsats: UByte = 0u

    public var baroaltmsl: Int = 0

    public var accuracyhor: UInt = 0u

    public var accuracyvert: UShort = 0u

    public var accuracyvel: UShort = 0u

    public var velvert: Short = 0

    public var velns: Short = 0

    public var velew: Short = 0

    public var emergencystatus: MavEnumValue<UavionixAdsbEmergencyStatus> =
        MavEnumValue.fromValue(0u)

    public var state: MavBitmaskValue<UavionixAdsbOutDynamicState> = MavBitmaskValue.fromValue(0u)

    public var squawk: UShort = 0u

    public fun build(): UavionixAdsbOutDynamic = UavionixAdsbOutDynamic(
      utctime = utctime,
      gpslat = gpslat,
      gpslon = gpslon,
      gpsalt = gpsalt,
      gpsfix = gpsfix,
      numsats = numsats,
      baroaltmsl = baroaltmsl,
      accuracyhor = accuracyhor,
      accuracyvert = accuracyvert,
      accuracyvel = accuracyvel,
      velvert = velvert,
      velns = velns,
      velew = velew,
      emergencystatus = emergencystatus,
      state = state,
      squawk = squawk,
    )
  }
}
