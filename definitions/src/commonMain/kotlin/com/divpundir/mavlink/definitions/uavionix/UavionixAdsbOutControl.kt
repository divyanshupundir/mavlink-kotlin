package com.divpundir.mavlink.definitions.uavionix

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
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Control message with all data sent in UCP control message.
 *
 * @param state ADS-B transponder control state flags
 * @param baroaltmsl Barometric pressure altitude (MSL) relative to a standard atmosphere of 1013.2
 * mBar and NOT bar corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX
 * units = mbar
 * @param squawk Mode A code (typically 1200 [0x04B0] for VFR)
 * @param emergencystatus Emergency status
 * @param flightId Flight Identification: 8 ASCII characters, '0' through '9', 'A' through 'Z' or
 * space. Spaces (0x20) used as a trailing pad character, or when call sign is unavailable.
 * @param xBit X-Bit enable (military transponders only)
 */
@GeneratedMavMessage(
  id = 10_007u,
  crcExtra = 71,
)
public data class UavionixAdsbOutControl(
  /**
   * ADS-B transponder control state flags
   */
  @GeneratedMavField(type = "uint8_t")
  public val state: MavBitmaskValue<UavionixAdsbOutControlState> = MavBitmaskValue.fromValue(0u),
  /**
   * Barometric pressure altitude (MSL) relative to a standard atmosphere of 1013.2 mBar and NOT bar
   * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX
   * units = mbar
   */
  @GeneratedMavField(type = "int32_t")
  public val baroaltmsl: Int = 0,
  /**
   * Mode A code (typically 1200 [0x04B0] for VFR)
   */
  @GeneratedMavField(type = "uint16_t")
  public val squawk: UShort = 0u,
  /**
   * Emergency status
   */
  @GeneratedMavField(type = "uint8_t")
  public val emergencystatus: MavEnumValue<UavionixAdsbEmergencyStatus> =
      MavEnumValue.fromValue(0u),
  /**
   * Flight Identification: 8 ASCII characters, '0' through '9', 'A' through 'Z' or space. Spaces
   * (0x20) used as a trailing pad character, or when call sign is unavailable.
   */
  @GeneratedMavField(type = "char[8]")
  public val flightId: String = "",
  /**
   * X-Bit enable (military transponders only)
   */
  @GeneratedMavField(type = "uint8_t")
  public val xBit: MavBitmaskValue<UavionixAdsbXbit> = MavBitmaskValue.fromValue(0u),
) : MavMessage<UavionixAdsbOutControl> {
  override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbOutControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(baroaltmsl)
    encoder.encodeUInt16(squawk)
    encoder.encodeBitmaskValue(state.value, 1)
    encoder.encodeEnumValue(emergencystatus.value, 1)
    encoder.encodeString(flightId, 8)
    encoder.encodeBitmaskValue(xBit.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(baroaltmsl)
    encoder.encodeUInt16(squawk)
    encoder.encodeBitmaskValue(state.value, 1)
    encoder.encodeEnumValue(emergencystatus.value, 1)
    encoder.encodeString(flightId, 8)
    encoder.encodeBitmaskValue(xBit.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbOutControl> {
    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    override val id: UInt = 10_007u

    override val crcExtra: Byte = 71

    override fun deserialize(bytes: ByteArray): UavionixAdsbOutControl {
      val decoder = MavDataDecoder(bytes)

      val baroaltmsl = decoder.safeDecodeInt32()
      val squawk = decoder.safeDecodeUInt16()
      val state = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = UavionixAdsbOutControlState.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val emergencystatus = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UavionixAdsbEmergencyStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flightId = decoder.safeDecodeString(8)
      val xBit = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = UavionixAdsbXbit.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return UavionixAdsbOutControl(
        state = state,
        baroaltmsl = baroaltmsl,
        squawk = squawk,
        emergencystatus = emergencystatus,
        flightId = flightId,
        xBit = xBit,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbOutControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var state: MavBitmaskValue<UavionixAdsbOutControlState> = MavBitmaskValue.fromValue(0u)

    public var baroaltmsl: Int = 0

    public var squawk: UShort = 0u

    public var emergencystatus: MavEnumValue<UavionixAdsbEmergencyStatus> =
        MavEnumValue.fromValue(0u)

    public var flightId: String = ""

    public var xBit: MavBitmaskValue<UavionixAdsbXbit> = MavBitmaskValue.fromValue(0u)

    public fun build(): UavionixAdsbOutControl = UavionixAdsbOutControl(
      state = state,
      baroaltmsl = baroaltmsl,
      squawk = squawk,
      emergencystatus = emergencystatus,
      flightId = flightId,
      xBit = xBit,
    )
  }
}
