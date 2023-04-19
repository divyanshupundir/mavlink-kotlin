package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Dynamic data used to generate ADS-B out transponder data (send at 5Hz)
 */
@GeneratedMavMessage(
  id = 10002u,
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
  public override val instanceMetadata: MavMessage.Metadata<UavionixAdsbOutDynamic> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(utctime)
    outputBuffer.encodeInt32(gpslat)
    outputBuffer.encodeInt32(gpslon)
    outputBuffer.encodeInt32(gpsalt)
    outputBuffer.encodeInt32(baroaltmsl)
    outputBuffer.encodeUInt32(accuracyhor)
    outputBuffer.encodeUInt16(accuracyvert)
    outputBuffer.encodeUInt16(accuracyvel)
    outputBuffer.encodeInt16(velvert)
    outputBuffer.encodeInt16(velns)
    outputBuffer.encodeInt16(velew)
    outputBuffer.encodeBitmaskValue(state.value, 2)
    outputBuffer.encodeUInt16(squawk)
    outputBuffer.encodeEnumValue(gpsfix.value, 1)
    outputBuffer.encodeUInt8(numsats)
    outputBuffer.encodeEnumValue(emergencystatus.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(utctime)
    outputBuffer.encodeInt32(gpslat)
    outputBuffer.encodeInt32(gpslon)
    outputBuffer.encodeInt32(gpsalt)
    outputBuffer.encodeInt32(baroaltmsl)
    outputBuffer.encodeUInt32(accuracyhor)
    outputBuffer.encodeUInt16(accuracyvert)
    outputBuffer.encodeUInt16(accuracyvel)
    outputBuffer.encodeInt16(velvert)
    outputBuffer.encodeInt16(velns)
    outputBuffer.encodeInt16(velew)
    outputBuffer.encodeBitmaskValue(state.value, 2)
    outputBuffer.encodeUInt16(squawk)
    outputBuffer.encodeEnumValue(gpsfix.value, 1)
    outputBuffer.encodeUInt8(numsats)
    outputBuffer.encodeEnumValue(emergencystatus.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 10002u

    private const val CRC_EXTRA: Byte = -70

    private const val SIZE_V1: Int = 41

    private const val SIZE_V2: Int = 41

    private val DESERIALIZER: MavDeserializer<UavionixAdsbOutDynamic> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val utctime = inputBuffer.decodeUInt32()
      val gpslat = inputBuffer.decodeInt32()
      val gpslon = inputBuffer.decodeInt32()
      val gpsalt = inputBuffer.decodeInt32()
      val baroaltmsl = inputBuffer.decodeInt32()
      val accuracyhor = inputBuffer.decodeUInt32()
      val accuracyvert = inputBuffer.decodeUInt16()
      val accuracyvel = inputBuffer.decodeUInt16()
      val velvert = inputBuffer.decodeInt16()
      val velns = inputBuffer.decodeInt16()
      val velew = inputBuffer.decodeInt16()
      val state = inputBuffer.decodeBitmaskValue(2).let { value ->
        val flags = UavionixAdsbOutDynamicState.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val squawk = inputBuffer.decodeUInt16()
      val gpsfix = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutDynamicGpsFix.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val numsats = inputBuffer.decodeUInt8()
      val emergencystatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavionixAdsbEmergencyStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      UavionixAdsbOutDynamic(
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


    private val METADATA: MavMessage.Metadata<UavionixAdsbOutDynamic> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavionixAdsbOutDynamic> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): UavionixAdsbOutDynamic =
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
