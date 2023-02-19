package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt64
import xyz.urbanmatrix.mavlink.serialization.encodeInt64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<Timesync> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt64(tc1)
    outputBuffer.encodeInt64(ts1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt64(tc1)
    outputBuffer.encodeInt64(ts1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 111u

    private const val CRC_EXTRA: Byte = 34

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<Timesync> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val tc1 = inputBuffer.decodeInt64()
      val ts1 = inputBuffer.decodeInt64()

      Timesync(
        tc1 = tc1,
        ts1 = ts1,
      )
    }


    private val METADATA: MavMessage.Metadata<Timesync> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Timesync> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Timesync =
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
