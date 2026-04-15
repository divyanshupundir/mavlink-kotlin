package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * A change to the sequence number indicates that the set of AVAILABLE_MODES has changed, and that the receiver should re-request all available modes.
 *
 *         The message is optional, and is only needed when the set of modes can change dynamically after boot.
 *         It should be emitted whenever the set of modes change.
 *         It should be streamed at low rate (nominally 0.3 Hz).
 *         See https://mavlink.io/en/services/standard_modes.html
 *       
 *
 * @param seq Sequence number. The value iterates sequentially whenever AVAILABLE_MODES changes (e.g. support for a new mode is added/removed dynamically).
 */
@GeneratedMavMessage(
  id = 437u,
  crcExtra = 30,
)
public data class AvailableModesMonitor(
  /**
   * Sequence number. The value iterates sequentially whenever AVAILABLE_MODES changes (e.g. support for a new mode is added/removed dynamically).
   */
  @GeneratedMavField(type = "uint8_t")
  public val seq: UByte = 0u,
) : MavMessage<AvailableModesMonitor> {
  override val instanceCompanion: MavMessage.MavCompanion<AvailableModesMonitor> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(seq)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(seq)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvailableModesMonitor> {
    private const val SIZE_V1: Int = 1

    private const val SIZE_V2: Int = 1

    override val id: UInt = 437u

    override val crcExtra: Byte = 30

    override fun deserialize(bytes: ByteArray): AvailableModesMonitor {
      val decoder = MavDataDecoder(bytes)

      val seq = decoder.safeDecodeUInt8()

      return AvailableModesMonitor(
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AvailableModesMonitor = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seq: UByte = 0u

    public fun build(): AvailableModesMonitor = AvailableModesMonitor(
      seq = seq,
    )
  }
}
