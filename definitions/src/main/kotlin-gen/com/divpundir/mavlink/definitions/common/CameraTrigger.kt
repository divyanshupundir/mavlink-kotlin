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
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Camera-IMU triggering and synchronisation message.
 */
@GeneratedMavMessage(
  id = 112u,
  crcExtra = -82,
)
public data class CameraTrigger(
  /**
   * Timestamp for image frame (UNIX Epoch time or time since system boot). The receiving end can
   * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
   * number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Image frame sequence
   */
  @GeneratedMavField(type = "uint32_t")
  public val seq: UInt = 0u,
) : MavMessage<CameraTrigger> {
  public override val instanceCompanion: MavMessage.MavCompanion<CameraTrigger> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(seq)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(seq)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CameraTrigger> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 112u

    public override val crcExtra: Byte = -82

    public override fun deserialize(source: BufferedSource): CameraTrigger {
      val timeUsec = source.decodeUInt64()
      val seq = source.decodeUInt32()

      return CameraTrigger(
        timeUsec = timeUsec,
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraTrigger =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var seq: UInt = 0u

    public fun build(): CameraTrigger = CameraTrigger(
      timeUsec = timeUsec,
      seq = seq,
    )
  }
}
