package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUnixUsec)
    encoder.encodeUInt32(timeBootMs)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUnixUsec)
    encoder.encodeUInt32(timeBootMs)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SystemTime> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 2u

    public override val crcExtra: Byte = -119

    public override fun deserialize(bytes: ByteArray): SystemTime {
      val decoder = MavDataDecoder(bytes)

      val timeUnixUsec = decoder.safeDecodeUInt64()
      val timeBootMs = decoder.safeDecodeUInt32()

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
