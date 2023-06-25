package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Report current used cellular network status
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
   * Failure reason when status in in CELLUAR_STATUS_FAILED
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
  public override val instanceCompanion: MavMessage.MavCompanion<CellularStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(mcc)
    buffer.encodeUInt16(mnc)
    buffer.encodeUInt16(lac)
    buffer.encodeEnumValue(status.value, 1)
    buffer.encodeEnumValue(failureReason.value, 1)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeUInt8(quality)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(mcc)
    buffer.encodeUInt16(mnc)
    buffer.encodeUInt16(lac)
    buffer.encodeEnumValue(status.value, 1)
    buffer.encodeEnumValue(failureReason.value, 1)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeUInt8(quality)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CellularStatus> {
    public override val id: UInt = 334u

    public override val crcExtra: Byte = 72

    public override fun deserialize(bytes: ByteArray): CellularStatus {
      val buffer = Buffer().write(bytes)

      val mcc = buffer.decodeUInt16()
      val mnc = buffer.decodeUInt16()
      val lac = buffer.decodeUInt16()
      val status = buffer.decodeEnumValue(1).let { value ->
        val entry = CellularStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val failureReason = buffer.decodeEnumValue(1).let { value ->
        val entry = CellularNetworkFailedReason.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = buffer.decodeEnumValue(1).let { value ->
        val entry = CellularNetworkRadioType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val quality = buffer.decodeUInt8()

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
