package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Large debug/prototyping array. The message uses the maximum available payload for data. The
 * array_id and name fields are used to discriminate between messages in code and in user interfaces
 * (respectively). Do not use in production code.
 */
@GeneratedMavMessage(
  id = 350u,
  crcExtra = -24,
)
public data class DebugFloatArray(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Name, for human-friendly display in a Ground Control Station
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Unique ID used to discriminate between arrays
   */
  @GeneratedMavField(type = "uint16_t")
  public val arrayId: UShort = 0u,
  /**
   * data
   */
  @GeneratedMavField(
    type = "float[58]",
    extension = true,
  )
  public val `data`: List<Float> = emptyList(),
) : MavMessage<DebugFloatArray> {
  public override val instanceMetadata: MavMessage.Metadata<DebugFloatArray> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt16(arrayId)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt16(arrayId)
    outputBuffer.encodeString(name, 10)
    outputBuffer.encodeFloatArray(data, 232)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 350u

    private const val CRC_EXTRA: Byte = -24

    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 252

    private val DESERIALIZER: MavDeserializer<DebugFloatArray> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val arrayId = inputBuffer.decodeUInt16()
      val name = inputBuffer.decodeString(10)
      val data = inputBuffer.decodeFloatArray(232)

      DebugFloatArray(
        timeUsec = timeUsec,
        name = name,
        arrayId = arrayId,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<DebugFloatArray> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DebugFloatArray> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DebugFloatArray =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var name: String = ""

    public var arrayId: UShort = 0u

    public var `data`: List<Float> = emptyList()

    public fun build(): DebugFloatArray = DebugFloatArray(
      timeUsec = timeUsec,
      name = name,
      arrayId = arrayId,
      data = data,
    )
  }
}
