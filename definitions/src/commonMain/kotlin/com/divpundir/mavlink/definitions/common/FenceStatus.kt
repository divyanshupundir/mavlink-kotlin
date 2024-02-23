package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Status of geo-fencing. Sent in extended status stream when fencing enabled.
 *
 * @param breachStatus Breach status (0 if currently inside fence, 1 if outside).
 * @param breachCount Number of fence breaches.
 * @param breachType Last breach type.
 * @param breachTime Time (since boot) of last breach.
 * units = ms
 * @param breachMitigation Active action to prevent fence breach
 */
@GeneratedMavMessage(
  id = 162u,
  crcExtra = -67,
)
public data class FenceStatus(
  /**
   * Breach status (0 if currently inside fence, 1 if outside).
   */
  @GeneratedMavField(type = "uint8_t")
  public val breachStatus: UByte = 0u,
  /**
   * Number of fence breaches.
   */
  @GeneratedMavField(type = "uint16_t")
  public val breachCount: UShort = 0u,
  /**
   * Last breach type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val breachType: MavEnumValue<FenceBreach> = MavEnumValue.fromValue(0u),
  /**
   * Time (since boot) of last breach.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val breachTime: UInt = 0u,
  /**
   * Active action to prevent fence breach
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val breachMitigation: MavEnumValue<FenceMitigate> = MavEnumValue.fromValue(0u),
) : MavMessage<FenceStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<FenceStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(breachTime)
    encoder.encodeUInt16(breachCount)
    encoder.encodeUInt8(breachStatus)
    encoder.encodeEnumValue(breachType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(breachTime)
    encoder.encodeUInt16(breachCount)
    encoder.encodeUInt8(breachStatus)
    encoder.encodeEnumValue(breachType.value, 1)
    encoder.encodeEnumValue(breachMitigation.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FenceStatus> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 9

    override val id: UInt = 162u

    override val crcExtra: Byte = -67

    override fun deserialize(bytes: ByteArray): FenceStatus {
      val decoder = MavDataDecoder(bytes)

      val breachTime = decoder.safeDecodeUInt32()
      val breachCount = decoder.safeDecodeUInt16()
      val breachStatus = decoder.safeDecodeUInt8()
      val breachType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = FenceBreach.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val breachMitigation = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = FenceMitigate.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return FenceStatus(
        breachStatus = breachStatus,
        breachCount = breachCount,
        breachType = breachType,
        breachTime = breachTime,
        breachMitigation = breachMitigation,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FenceStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var breachStatus: UByte = 0u

    public var breachCount: UShort = 0u

    public var breachType: MavEnumValue<FenceBreach> = MavEnumValue.fromValue(0u)

    public var breachTime: UInt = 0u

    public var breachMitigation: MavEnumValue<FenceMitigate> = MavEnumValue.fromValue(0u)

    public fun build(): FenceStatus = FenceStatus(
      breachStatus = breachStatus,
      breachCount = breachCount,
      breachType = breachType,
      breachTime = breachTime,
      breachMitigation = breachMitigation,
    )
  }
}
