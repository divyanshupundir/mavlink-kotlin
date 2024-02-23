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
 * Camera-IMU triggering and synchronisation message.
 *
 * @param timeUsec Timestamp for image frame (UNIX Epoch time or time since system boot). The
 * receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the
 * magnitude of the number.
 * units = us
 * @param seq Image frame sequence
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
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Image frame sequence
   */
  @GeneratedMavField(type = "uint32_t")
  public val seq: UInt = 0u,
) : MavMessage<CameraTrigger> {
  override val instanceCompanion: MavMessage.MavCompanion<CameraTrigger> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(seq)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(seq)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraTrigger> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    override val id: UInt = 112u

    override val crcExtra: Byte = -82

    override fun deserialize(bytes: ByteArray): CameraTrigger {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val seq = decoder.safeDecodeUInt32()

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
