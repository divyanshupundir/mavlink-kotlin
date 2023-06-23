package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Control vehicle LEDs.
 */
@GeneratedMavMessage(
  id = 186u,
  crcExtra = 72,
)
public data class LedControl(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Instance (LED instance to control or 255 for all LEDs).
   */
  @GeneratedMavField(type = "uint8_t")
  public val instance: UByte = 0u,
  /**
   * Pattern (see LED_PATTERN_ENUM).
   */
  @GeneratedMavField(type = "uint8_t")
  public val pattern: UByte = 0u,
  /**
   * Custom Byte Length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val customLen: UByte = 0u,
  /**
   * Custom Bytes.
   */
  @GeneratedMavField(type = "uint8_t[24]")
  public val customBytes: List<UByte> = emptyList(),
) : MavMessage<LedControl> {
  public override val instanceCompanion: MavMessage.MavCompanion<LedControl> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(instance)
    output.encodeUInt8(pattern)
    output.encodeUInt8(customLen)
    output.encodeUInt8Array(customBytes, 24)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(instance)
    output.encodeUInt8(pattern)
    output.encodeUInt8(customLen)
    output.encodeUInt8Array(customBytes, 24)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LedControl> {
    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    public override val id: UInt = 186u

    public override val crcExtra: Byte = 72

    public override fun deserialize(source: BufferedSource): LedControl {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val instance = source.decodeUInt8()
      val pattern = source.decodeUInt8()
      val customLen = source.decodeUInt8()
      val customBytes = source.decodeUInt8Array(24)

      return LedControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        instance = instance,
        pattern = pattern,
        customLen = customLen,
        customBytes = customBytes,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LedControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var instance: UByte = 0u

    public var pattern: UByte = 0u

    public var customLen: UByte = 0u

    public var customBytes: List<UByte> = emptyList()

    public fun build(): LedControl = LedControl(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      instance = instance,
      pattern = pattern,
      customLen = customLen,
      customBytes = customBytes,
    )
  }
}
