package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

/**
 * The system time is the time of the master clock, typically the computer clock of the main onboard
 * computer.
 */
@GeneratedMavMessage(
  id = 2u,
  crcExtra = -119,
)
public data class SystemTime(
  /**
   * Timestamp (UNIX epoch time).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUnixUsec: ULong = 0uL,
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
) : MavMessage<SystemTime> {
  public override val instanceCompanion: MavMessage.MavCompanion<SystemTime> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUnixUsec)
    buffer.encodeUInt32(timeBootMs)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUnixUsec)
    buffer.encodeUInt32(timeBootMs)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SystemTime> {
    public override val id: UInt = 2u

    public override val crcExtra: Byte = -119

    public override fun deserialize(bytes: ByteArray): SystemTime {
      val buffer = Buffer().write(bytes)

      val timeUnixUsec = buffer.decodeUInt64()
      val timeBootMs = buffer.decodeUInt32()

      return SystemTime(
        timeUnixUsec = timeUnixUsec,
        timeBootMs = timeBootMs,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SystemTime =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUnixUsec: ULong = 0uL

    public var timeBootMs: UInt = 0u

    public fun build(): SystemTime = SystemTime(
      timeUnixUsec = timeUnixUsec,
      timeBootMs = timeBootMs,
    )
  }
}
