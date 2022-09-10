package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Send a debug value. The index is used to discriminate between values. These values show up in the
 * plot of QGroundControl as DEBUG N.
 */
@GeneratedMavMessage(
  id = 254,
  crc = 46,
)
public data class Debug(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * index of debug variable
   */
  @GeneratedMavField(type = "uint8_t")
  public val ind: Int = 0,
  /**
   * DEBUG value
   */
  @GeneratedMavField(type = "float")
  public val `value`: Float = 0F,
) : MavMessage<Debug> {
  public override val instanceMetadata: MavMessage.Metadata<Debug> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(value)
    outputBuffer.encodeUint8(ind)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(value)
    outputBuffer.encodeUint8(ind)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 254

    private const val CRC: Int = 46

    private const val SIZE: Int = 9

    private val DESERIALIZER: MavDeserializer<Debug> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val value = inputBuffer.decodeFloat()
      val ind = inputBuffer.decodeUint8()

      Debug(
        timeBootMs = timeBootMs,
        ind = ind,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<Debug> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Debug> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var ind: Int = 0

    public var `value`: Float = 0F

    public fun build(): Debug = Debug(
      timeBootMs = timeBootMs,
      ind = ind,
      value = value,
    )
  }
}
