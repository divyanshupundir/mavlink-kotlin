package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Report current used cellular network status
 *
 * @param status Cellular modem status
 * @param failureReason Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED
 * @param type Cellular network radio type: gsm, cdma, lte...
 * @param quality Signal quality in percent. If unknown, set to UINT8_MAX
 * @param mcc Mobile country code. If unknown, set to UINT16_MAX
 * @param mnc Mobile network code. If unknown, set to UINT16_MAX
 * @param lac Location area code. If unknown, set to 0
 */
@GeneratedMavMessage(
  id = 334u,
  crcExtra = 72,
)
public data class CellularStatus(
  /**
   * Cellular modem status
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<CellularStatusFlag> = MavEnumValue.fromValue(0u),
  /**
   * Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED
   */
  @GeneratedMavField(type = "uint8_t")
  public val failureReason: MavEnumValue<CellularNetworkFailedReason> = MavEnumValue.fromValue(0u),
  /**
   * Cellular network radio type: gsm, cdma, lte...
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<CellularNetworkRadioType> = MavEnumValue.fromValue(0u),
  /**
   * Signal quality in percent. If unknown, set to UINT8_MAX
   */
  @GeneratedMavField(type = "uint8_t")
  public val quality: UByte = 0u,
  /**
   * Mobile country code. If unknown, set to UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val mcc: UShort = 0u,
  /**
   * Mobile network code. If unknown, set to UINT16_MAX
   */
  @GeneratedMavField(type = "uint16_t")
  public val mnc: UShort = 0u,
  /**
   * Location area code. If unknown, set to 0
   */
  @GeneratedMavField(type = "uint16_t")
  public val lac: UShort = 0u,
) : MavMessage<CellularStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<CellularStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(mcc)
    encoder.encodeUInt16(mnc)
    encoder.encodeUInt16(lac)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeEnumValue(failureReason.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(quality)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(mcc)
    encoder.encodeUInt16(mnc)
    encoder.encodeUInt16(lac)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeEnumValue(failureReason.value, 1)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(quality)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CellularStatus> {
    private const val SIZE_V1: Int = 10

    private const val SIZE_V2: Int = 10

    override val id: UInt = 334u

    override val crcExtra: Byte = 72

    override fun deserialize(bytes: ByteArray): CellularStatus {
      val decoder = MavDataDecoder(bytes)

      val mcc = decoder.safeDecodeUInt16()
      val mnc = decoder.safeDecodeUInt16()
      val lac = decoder.safeDecodeUInt16()
      val status = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CellularStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val failureReason = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CellularNetworkFailedReason.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = CellularNetworkRadioType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val quality = decoder.safeDecodeUInt8()

      return CellularStatus(
        status = status,
        failureReason = failureReason,
        type = type,
        quality = quality,
        mcc = mcc,
        mnc = mnc,
        lac = lac,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CellularStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavEnumValue<CellularStatusFlag> = MavEnumValue.fromValue(0u)

    public var failureReason: MavEnumValue<CellularNetworkFailedReason> = MavEnumValue.fromValue(0u)

    public var type: MavEnumValue<CellularNetworkRadioType> = MavEnumValue.fromValue(0u)

    public var quality: UByte = 0u

    public var mcc: UShort = 0u

    public var mnc: UShort = 0u

    public var lac: UShort = 0u

    public fun build(): CellularStatus = CellularStatus(
      status = status,
      failureReason = failureReason,
      type = type,
      quality = quality,
      mcc = mcc,
      mnc = mnc,
      lac = lac,
    )
  }
}
