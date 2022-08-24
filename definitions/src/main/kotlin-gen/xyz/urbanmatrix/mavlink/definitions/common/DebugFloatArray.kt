package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * Large debug/prototyping array. The message uses the maximum available payload for data. The
 * array_id and name fields are used to discriminate between messages in code and in user interfaces
 * (respectively). Do not use in production code.
 */
@GeneratedMavMessage(
  id = 350,
  crc = 232,
)
public data class DebugFloatArray(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Name, for human-friendly display in a Ground Control Station
   */
  public val name: String = "",
  /**
   * Unique ID used to discriminate between arrays
   */
  public val arrayId: Int = 0,
  /**
   * data
   */
  public val `data`: List<Float> = emptyList(),
) : MavMessage<DebugFloatArray> {
  public override val instanceMetadata: MavMessage.Metadata<DebugFloatArray> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint16(arrayId)
    outputBuffer.encodeString(name, 10)
    outputBuffer.encodeFloatArray(data, 232)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 350

    private const val CRC: Int = 232

    private const val SIZE: Int = 252

    private val DESERIALIZER: MavDeserializer<DebugFloatArray> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val arrayId = inputBuffer.decodeUint16()
      val name = inputBuffer.decodeString(10)
      val data = inputBuffer.decodeFloatArray(232)

      DebugFloatArray(
        timeUsec = timeUsec,
        name = name,
        arrayId = arrayId,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<DebugFloatArray> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DebugFloatArray> = METADATA
  }
}
