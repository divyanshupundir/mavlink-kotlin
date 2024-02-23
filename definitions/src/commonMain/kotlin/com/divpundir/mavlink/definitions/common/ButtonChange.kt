package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Report button state change.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param lastChangeMs Time of last change of button state.
 * units = ms
 * @param state Bitmap for state of buttons.
 */
@GeneratedMavMessage(
  id = 257u,
  crcExtra = -125,
)
public data class ButtonChange(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Time of last change of button state.
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val lastChangeMs: UInt = 0u,
  /**
   * Bitmap for state of buttons.
   */
  @GeneratedMavField(type = "uint8_t")
  public val state: UByte = 0u,
) : MavMessage<ButtonChange> {
  override val instanceCompanion: MavMessage.MavCompanion<ButtonChange> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(lastChangeMs)
    encoder.encodeUInt8(state)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(lastChangeMs)
    encoder.encodeUInt8(state)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ButtonChange> {
    private const val SIZE_V1: Int = 9

    private const val SIZE_V2: Int = 9

    override val id: UInt = 257u

    override val crcExtra: Byte = -125

    override fun deserialize(bytes: ByteArray): ButtonChange {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val lastChangeMs = decoder.safeDecodeUInt32()
      val state = decoder.safeDecodeUInt8()

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
