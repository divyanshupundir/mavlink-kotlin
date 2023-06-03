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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(mcc)
    outputBuffer.encodeUInt16(mnc)
    outputBuffer.encodeUInt16(lac)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(failureReason.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(quality)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(mcc)
    outputBuffer.encodeUInt16(mnc)
    outputBuffer.encodeUInt16(lac)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeEnumValue(failureReason.value, 1)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUInt8(quality)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CellularStatus> {
    private const val SIZE_V1: Int = 10

    private const val SIZE_V2: Int = 10

    public override val id: UInt = 334u

    public override val crcExtra: Byte = 72

    public override fun deserialize(bytes: ByteArray): CellularStatus {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mcc = inputBuffer.decodeUInt16()
      val mnc = inputBuffer.decodeUInt16()
      val lac = inputBuffer.decodeUInt16()
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val failureReason = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularNetworkFailedReason.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularNetworkRadioType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val quality = inputBuffer.decodeUInt8()

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
