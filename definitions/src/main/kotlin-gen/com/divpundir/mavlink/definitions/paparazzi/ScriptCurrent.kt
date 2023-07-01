package com.divpundir.mavlink.definitions.paparazzi

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * This message informs about the currently active SCRIPT.
 */
@GeneratedMavMessage(
  id = 184u,
  crcExtra = 40,
)
public data class ScriptCurrent(
  /**
   * Active Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
) : MavMessage<ScriptCurrent> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScriptCurrent> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt16(seq)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt16(seq)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScriptCurrent> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    public override val id: UInt = 184u

    public override val crcExtra: Byte = 40

    public override fun deserialize(bytes: ByteArray): ScriptCurrent {
      val decoder = MavDataDecoder.wrap(bytes)

      val seq = decoder.safeDecodeUInt16()

      return ScriptCurrent(
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScriptCurrent =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seq: UShort = 0u

    public fun build(): ScriptCurrent = ScriptCurrent(
      seq = seq,
    )
  }
}
