package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The system time is the time of the master clock, typically the computer clock of the main onboard
 * computer.
 */
@GeneratedMavMessage(
  id = 2,
  crc = 137,
)
public data class SystemTime(
  /**
   * Timestamp (UNIX epoch time).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUnixUsec: BigInteger = BigInteger.ZERO,
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
) : MavMessage<SystemTime> {
  public override val instanceMetadata: MavMessage.Metadata<SystemTime> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUnixUsec)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUnixUsec)
    outputBuffer.encodeUint32(timeBootMs)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 2

    private const val CRC: Int = 137

    private const val SIZE: Int = 12

    private val DESERIALIZER: MavDeserializer<SystemTime> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUnixUsec = inputBuffer.decodeUint64()
      val timeBootMs = inputBuffer.decodeUint32()

      SystemTime(
        timeUnixUsec = timeUnixUsec,
        timeBootMs = timeBootMs,
      )
    }


    private val METADATA: MavMessage.Metadata<SystemTime> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SystemTime> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUnixUsec: BigInteger = BigInteger.ZERO

    public var timeBootMs: Long = 0L

    public fun build(): SystemTime = SystemTime(
      timeUnixUsec = timeUnixUsec,
      timeBootMs = timeBootMs,
    )
  }
}
