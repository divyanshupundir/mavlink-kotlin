package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<SystemTime> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUnixUsec)
    outputBuffer.encodeUInt32(timeBootMs)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUnixUsec)
    outputBuffer.encodeUInt32(timeBootMs)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 2u

    private const val CRC_EXTRA: Byte = -119

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<SystemTime> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUnixUsec = inputBuffer.decodeUInt64()
      val timeBootMs = inputBuffer.decodeUInt32()

      SystemTime(
        timeUnixUsec = timeUnixUsec,
        timeBootMs = timeBootMs,
      )
    }


    private val METADATA: MavMessage.Metadata<SystemTime> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SystemTime> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SystemTime =
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
