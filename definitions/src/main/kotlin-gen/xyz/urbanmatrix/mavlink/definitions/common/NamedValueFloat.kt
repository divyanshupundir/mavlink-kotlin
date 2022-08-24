package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * Send a key-value pair as float. The use of this message is discouraged for normal packets, but a
 * quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 251,
  crc = 170,
)
public data class NamedValueFloat(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Name of the debug variable
   */
  public val name: String = "",
  /**
   * Floating point value
   */
  public val `value`: Float = 0F,
) : MavMessage<NamedValueFloat> {
  public override val instanceMetadata: MavMessage.Metadata<NamedValueFloat> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(value)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 251

    private const val CRC: Int = 170

    private const val SIZE: Int = 18

    private val DESERIALIZER: MavDeserializer<NamedValueFloat> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val value = inputBuffer.decodeFloat()
      val name = inputBuffer.decodeString(10)

      NamedValueFloat(
        timeBootMs = timeBootMs,
        name = name,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<NamedValueFloat> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<NamedValueFloat> = METADATA
  }
}
