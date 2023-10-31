package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Frsky SPort passthrough multi packet container.
 */
@GeneratedMavMessage(
  id = 60_040u,
  crcExtra = -100,
)
public data class FrskyPassthroughArray(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Number of passthrough packets in this message.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Passthrough packet buffer. A packet has 6 bytes: uint16_t id + uint32_t data. The array has
   * space for 40 packets.
   */
  @GeneratedMavField(type = "uint8_t[240]")
  public val packetBuf: List<UByte> = emptyList(),
) : MavMessage<FrskyPassthroughArray> {
  public override val instanceCompanion: MavMessage.MavCompanion<FrskyPassthroughArray> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(packetBuf, 240)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(packetBuf, 240)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FrskyPassthroughArray> {
    private const val SIZE_V1: Int = 245

    private const val SIZE_V2: Int = 245

    public override val id: UInt = 60_040u

    public override val crcExtra: Byte = -100

    public override fun deserialize(bytes: ByteArray): FrskyPassthroughArray {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val count = decoder.safeDecodeUInt8()
      val packetBuf = decoder.safeDecodeUInt8Array(240)

      return FrskyPassthroughArray(
        timeBootMs = timeBootMs,
        count = count,
        packetBuf = packetBuf,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FrskyPassthroughArray =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var count: UByte = 0u

    public var packetBuf: List<UByte> = emptyList()

    public fun build(): FrskyPassthroughArray = FrskyPassthroughArray(
      timeBootMs = timeBootMs,
      count = count,
      packetBuf = packetBuf,
    )
  }
}
