package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt64
import com.divpundir.mavlink.serialization.encodeInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Long
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeInt64(tc1)
    buffer.encodeInt64(ts1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt64(tc1)
    buffer.encodeInt64(ts1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Timesync> {
    public override val id: UInt = 111u

    public override val crcExtra: Byte = 34

    public override fun deserialize(bytes: ByteArray): Timesync {
      val buffer = Buffer().write(bytes)

      val tc1 = buffer.decodeInt64()
      val ts1 = buffer.decodeInt64()

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
