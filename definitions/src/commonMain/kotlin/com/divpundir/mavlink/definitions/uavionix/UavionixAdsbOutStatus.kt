package com.divpundir.mavlink.definitions.uavionix

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Status message with information from UCP Heartbeat and Status messages.
 *
 * @param state ADS-B transponder status state flags
 * @param squawk Mode A code (typically 1200 [0x04B0] for VFR)
 * @param nicNacp Integrity and Accuracy of traffic reported as a 4-bit value for each field (NACp
 * 7:4, NIC 3:0) and encoded by Containment Radius (HPL) and Estimated Position Uncertainty (HFOM),
 * respectively
 * @param boardtemp Board temperature in C
 * @param fault ADS-B transponder fault flags
 * @param flightId Flight Identification: 8 ASCII characters, '0' through '9', 'A' through 'Z' or
 * space. Spaces (0x20) used as a trailing pad character, or when call sign is unavailable.
 */
@GeneratedMavMessage(
  id = 10_008u,
  crcExtra = -16,
)
public data class UavionixAdsbOutStatus(
  /**
   * ADS-B transponder status state flags
   */
  @GeneratedMavField(type = "uint8_t")
  public val state: MavEnumValue<UavionixAdsbOutStatusState> = MavEnumValue.fromValue(0u),
  /**
   * Mode A code (typically 1200 [0x04B0] for VFR)
   */
  @GeneratedMavField(type = "uint16_t")
  public val squawk: UShort = 0u,
  /**
   * Integrity and Accuracy of traffic reported as a 4-bit value for each field (NACp 7:4, NIC 3:0)
   * and encoded by Containment Radius (HPL) and Estimated Position Uncertainty (HFOM), respectively
   */
  @GeneratedMavField(type = "uint8_t")
  public val nicNacp: MavEnumValue<UavionixAdsbOutStatusNicNacp> = MavEnumValue.fromValue(0u),
  /**
   * Board temperature in C
   */
  @GeneratedMavField(type = "uint8_t")
  public val boardtemp: UByte = 0u,
  /**
   * ADS-B transponder fault flags
   */
  @GeneratedMavField(type = "uint8_t")
  public val fault: MavEnumValue<UavionixAdsbOutStatusFault> = MavEnumValue.fromValue(0u),
  /**
   * Flight Identification: 8 ASCII characters, '0' through '9', 'A' through 'Z' or space. Spaces
   * (0x20) used as a trailing pad character, or when call sign is unavailable.
   */
  @GeneratedMavField(type = "char[8]")
  public val flightId: String = "",
) : MavMessage<UavionixAdsbOutStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<UavionixAdsbOutStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(squawk)
    encoder.encodeEnumValue(state.value, 1)
    encoder.encodeEnumValue(nicNacp.value, 1)
    encoder.encodeUInt8(boardtemp)
    encoder.encodeEnumValue(fault.value, 1)
    encoder.encodeString(flightId, 8)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(squawk)
    encoder.encodeEnumValue(state.value, 1)
    encoder.encodeEnumValue(nicNacp.value, 1)
    encoder.encodeUInt8(boardtemp)
    encoder.encodeEnumValue(fault.value, 1)
    encoder.encodeString(flightId, 8)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavionixAdsbOutStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    override val id: UInt = 10_008u

    override val crcExtra: Byte = -16

    override fun deserialize(bytes: ByteArray): UavionixAdsbOutStatus {
      val decoder = MavDataDecoder(bytes)

      val squawk = decoder.safeDecodeUInt16()
      val state = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutStatusState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val nicNacp = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutStatusNicNacp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val boardtemp = decoder.safeDecodeUInt8()
      val fault = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UavionixAdsbOutStatusFault.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flightId = decoder.safeDecodeString(8)

      return UavionixAdsbOutStatus(
        state = state,
        squawk = squawk,
        nicNacp = nicNacp,
        boardtemp = boardtemp,
        fault = fault,
        flightId = flightId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavionixAdsbOutStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var state: MavEnumValue<UavionixAdsbOutStatusState> = MavEnumValue.fromValue(0u)

    public var squawk: UShort = 0u

    public var nicNacp: MavEnumValue<UavionixAdsbOutStatusNicNacp> = MavEnumValue.fromValue(0u)

    public var boardtemp: UByte = 0u

    public var fault: MavEnumValue<UavionixAdsbOutStatusFault> = MavEnumValue.fromValue(0u)

    public var flightId: String = ""

    public fun build(): UavionixAdsbOutStatus = UavionixAdsbOutStatus(
      state = state,
      squawk = squawk,
      nicNacp = nicNacp,
      boardtemp = boardtemp,
      fault = fault,
      flightId = flightId,
    )
  }
}
