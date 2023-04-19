package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
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
import kotlin.Unit

/**
 * Report button state change.
 */
@GeneratedMavMessage(
  id = 257u,
  crcExtra = -125,
)
public data class ButtonChange(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Time of last change of button state.
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastChangeMs: UInt = 0u,
  /**
   * Bitmap for state of buttons.
   */
  @GeneratedMavField(type = "uint8_t")
  public val state: UByte = 0u,
) : MavMessage<ButtonChange> {
  public override val instanceMetadata: MavMessage.Metadata<ButtonChange> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(lastChangeMs)
    outputBuffer.encodeUInt8(state)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt32(lastChangeMs)
    outputBuffer.encodeUInt8(state)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 257u

    private const val CRC_EXTRA: Byte = -125

    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<ButtonChange> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val lastChangeMs = inputBuffer.decodeUInt32()
      val state = inputBuffer.decodeUInt8()

      ButtonChange(
        timeBootMs = timeBootMs,
        lastChangeMs = lastChangeMs,
        state = state,
      )
    }


    private val METADATA: MavMessage.Metadata<ButtonChange> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ButtonChange> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ButtonChange =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var lastChangeMs: UInt = 0u

    public var state: UByte = 0u

    public fun build(): ButtonChange = ButtonChange(
      timeBootMs = timeBootMs,
      lastChangeMs = lastChangeMs,
      state = state,
    )
  }
}
