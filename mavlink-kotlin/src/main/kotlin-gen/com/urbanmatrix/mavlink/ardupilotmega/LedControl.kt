package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Control vehicle LEDs.
 */
public data class LedControl(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Instance (LED instance to control or 255 for all LEDs).
   */
  public val instance: Int = 0,
  /**
   * Pattern (see LED_PATTERN_ENUM).
   */
  public val pattern: Int = 0,
  /**
   * Custom Byte Length.
   */
  public val customLen: Int = 0,
  /**
   * Custom Bytes.
   */
  public val customBytes: List<Int> = emptyList(),
) : MavMessage<LedControl> {
  public override val instanceMetadata: MavMessage.Metadata<LedControl> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(29).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(instance)
    outputBuffer.encodeUint8(pattern)
    outputBuffer.encodeUint8(customLen)
    outputBuffer.encodeUint8Array(customBytes, 24)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 186

    private const val CRC: Int = 141

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
  }
}
