package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt64
import com.divpundir.mavlink.serialization.safeDecodeInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.UInt
import kotlin.Unit

/**
 * Time synchronization message.
 */
@GeneratedMavMessage(
  id = 111u,
  crcExtra = 34,
)
public data class Timesync(
  /**
   * Time sync timestamp 1
   */
  @GeneratedMavField(type = "int64_t")
  public val tc1: Long = 0L,
  /**
   * Time sync timestamp 2
   */
  @GeneratedMavField(type = "int64_t")
  public val ts1: Long = 0L,
) : MavMessage<Timesync> {
  public override val instanceCompanion: MavMessage.MavCompanion<Timesync> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeInt64(tc1)
    encoder.encodeInt64(ts1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeInt64(tc1)
    encoder.encodeInt64(ts1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Timesync> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 111u

    public override val crcExtra: Byte = 34

    public override fun deserialize(bytes: ByteArray): Timesync {
      val decoder = MavDataDecoder.wrap(bytes)

      val tc1 = decoder.safeDecodeInt64()
      val ts1 = decoder.safeDecodeInt64()

      return Timesync(
        tc1 = tc1,
        ts1 = ts1,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Timesync =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var tc1: Long = 0L

    public var ts1: Long = 0L

    public fun build(): Timesync = Timesync(
      tc1 = tc1,
      ts1 = ts1,
    )
  }
}
