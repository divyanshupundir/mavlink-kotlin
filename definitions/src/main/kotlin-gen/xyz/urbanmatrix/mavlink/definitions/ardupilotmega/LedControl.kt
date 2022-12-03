package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Control vehicle LEDs.
 */
@GeneratedMavMessage(
  id = 186,
  crc = 72,
)
public data class LedControl(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Instance (LED instance to control or 255 for all LEDs).
   */
  @GeneratedMavField(type = "uint8_t")
  public val instance: Int = 0,
  /**
   * Pattern (see LED_PATTERN_ENUM).
   */
  @GeneratedMavField(type = "uint8_t")
  public val pattern: Int = 0,
  /**
   * Custom Byte Length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val customLen: Int = 0,
  /**
   * Custom Bytes.
   */
  @GeneratedMavField(type = "uint8_t[24]")
  public val customBytes: List<Int> = emptyList(),
) : MavMessage<LedControl> {
  public override val instanceMetadata: MavMessage.Metadata<LedControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(instance)
    outputBuffer.encodeUint8(pattern)
    outputBuffer.encodeUint8(customLen)
    outputBuffer.encodeUint8Array(customBytes, 24)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(instance)
    outputBuffer.encodeUint8(pattern)
    outputBuffer.encodeUint8(customLen)
    outputBuffer.encodeUint8Array(customBytes, 24)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 186

    private const val CRC: Int = 72

    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    private val DESERIALIZER: MavDeserializer<LedControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val instance = inputBuffer.decodeUint8()
      val pattern = inputBuffer.decodeUint8()
      val customLen = inputBuffer.decodeUint8()
      val customBytes = inputBuffer.decodeUint8Array(24)

      LedControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        instance = instance,
        pattern = pattern,
        customLen = customLen,
        customBytes = customBytes,
      )
    }


    private val METADATA: MavMessage.Metadata<LedControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LedControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LedControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var instance: Int = 0

    public var pattern: Int = 0

    public var customLen: Int = 0

    public var customBytes: List<Int> = emptyList()

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
