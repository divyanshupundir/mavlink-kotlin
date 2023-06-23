package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled.
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
  public override val instanceCompanion: MavMessage.MavCompanion<FenceStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(breachTime)
    output.encodeUInt16(breachCount)
    output.encodeUInt8(breachStatus)
    output.encodeEnumValue(breachType.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(breachTime)
    output.encodeUInt16(breachCount)
    output.encodeUInt8(breachStatus)
    output.encodeEnumValue(breachType.value, 1)
    output.encodeEnumValue(breachMitigation.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FenceStatus> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 9

    public override val id: UInt = 162u

    public override val crcExtra: Byte = -67

    public override fun deserialize(source: BufferedSource): FenceStatus {
      val breachTime = source.decodeUInt32()
      val breachCount = source.decodeUInt16()
      val breachStatus = source.decodeUInt8()
      val breachType = source.decodeEnumValue(1).let { value ->
        val entry = FenceBreach.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val breachMitigation = source.decodeEnumValue(1).let { value ->
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
