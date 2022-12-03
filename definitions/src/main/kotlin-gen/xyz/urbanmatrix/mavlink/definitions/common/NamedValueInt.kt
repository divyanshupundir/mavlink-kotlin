package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Send a key-value pair as integer. The use of this message is discouraged for normal packets, but
 * a quite efficient way for testing new messages and getting experimental debug output.
 */
@GeneratedMavMessage(
  id = 252,
  crc = 44,
)
public data class NamedValueInt(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * Name of the debug variable
   */
  @GeneratedMavField(type = "char[10]")
  public val name: String = "",
  /**
   * Signed integer value
   */
  @GeneratedMavField(type = "int32_t")
  public val `value`: Int = 0,
) : MavMessage<NamedValueInt> {
  public override val instanceMetadata: MavMessage.Metadata<NamedValueInt> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(value)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt32(value)
    outputBuffer.encodeString(name, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 252

    private const val CRC: Int = 44

    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    private val DESERIALIZER: MavDeserializer<NamedValueInt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val value = inputBuffer.decodeInt32()
      val name = inputBuffer.decodeString(10)

      NamedValueInt(
        timeBootMs = timeBootMs,
        name = name,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<NamedValueInt> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<NamedValueInt> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): NamedValueInt =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var name: String = ""

    public var `value`: Int = 0

    public fun build(): NamedValueInt = NamedValueInt(
      timeBootMs = timeBootMs,
      name = name,
      value = value,
    )
  }
}
