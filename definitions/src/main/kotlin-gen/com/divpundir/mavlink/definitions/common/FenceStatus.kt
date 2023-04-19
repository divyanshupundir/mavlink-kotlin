package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
  public override val instanceMetadata: MavMessage.Metadata<FenceStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(breachTime)
    outputBuffer.encodeUInt16(breachCount)
    outputBuffer.encodeUInt8(breachStatus)
    outputBuffer.encodeEnumValue(breachType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(breachTime)
    outputBuffer.encodeUInt16(breachCount)
    outputBuffer.encodeUInt8(breachStatus)
    outputBuffer.encodeEnumValue(breachType.value, 1)
    outputBuffer.encodeEnumValue(breachMitigation.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 162u

    private const val CRC_EXTRA: Byte = -67

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<FenceStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val breachTime = inputBuffer.decodeUInt32()
      val breachCount = inputBuffer.decodeUInt16()
      val breachStatus = inputBuffer.decodeUInt8()
      val breachType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = FenceBreach.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val breachMitigation = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = FenceMitigate.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      FenceStatus(
        breachStatus = breachStatus,
        breachCount = breachCount,
        breachType = breachType,
        breachTime = breachTime,
        breachMitigation = breachMitigation,
      )
    }


    private val METADATA: MavMessage.Metadata<FenceStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FenceStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FenceStatus =
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
