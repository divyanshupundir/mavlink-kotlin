package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Control vehicle LEDs.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param instance Instance (LED instance to control or 255 for all LEDs).
 * @param pattern Pattern (see LED_PATTERN_ENUM).
 * @param customLen Custom Byte Length.
 * @param customBytes Custom Bytes.
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
  override val instanceCompanion: MavMessage.MavCompanion<LedControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(instance)
    encoder.encodeUInt8(pattern)
    encoder.encodeUInt8(customLen)
    encoder.encodeUInt8Array(customBytes, 24)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(instance)
    encoder.encodeUInt8(pattern)
    encoder.encodeUInt8(customLen)
    encoder.encodeUInt8Array(customBytes, 24)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LedControl> {
    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    override val id: UInt = 186u

    override val crcExtra: Byte = 72

    override fun deserialize(bytes: ByteArray): LedControl {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val instance = decoder.safeDecodeUInt8()
      val pattern = decoder.safeDecodeUInt8()
      val customLen = decoder.safeDecodeUInt8()
      val customBytes = decoder.safeDecodeUInt8Array(24)

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
