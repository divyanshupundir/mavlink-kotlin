package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<ButtonChange> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeUInt32(lastChangeMs)
    buffer.encodeUInt8(state)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeUInt32(lastChangeMs)
    buffer.encodeUInt8(state)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ButtonChange> {
    public override val id: UInt = 257u

    public override val crcExtra: Byte = -125

    public override fun deserialize(bytes: ByteArray): ButtonChange {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val lastChangeMs = buffer.decodeUInt32()
      val state = buffer.decodeUInt8()

      return ButtonChange(
        timeBootMs = timeBootMs,
        lastChangeMs = lastChangeMs,
        state = state,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ButtonChange =
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
