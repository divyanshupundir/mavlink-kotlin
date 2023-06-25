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
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(breachTime)
    buffer.encodeUInt16(breachCount)
    buffer.encodeUInt8(breachStatus)
    buffer.encodeEnumValue(breachType.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(breachTime)
    buffer.encodeUInt16(breachCount)
    buffer.encodeUInt8(breachStatus)
    buffer.encodeEnumValue(breachType.value, 1)
    buffer.encodeEnumValue(breachMitigation.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FenceStatus> {
    public override val id: UInt = 162u

    public override val crcExtra: Byte = -67

    public override fun deserialize(bytes: ByteArray): FenceStatus {
      val buffer = Buffer().write(bytes)

      val breachTime = buffer.decodeUInt32()
      val breachCount = buffer.decodeUInt16()
      val breachStatus = buffer.decodeUInt8()
      val breachType = buffer.decodeEnumValue(1).let { value ->
        val entry = FenceBreach.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val breachMitigation = buffer.decodeEnumValue(1).let { value ->
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
