package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * State of autopilot RAM.
 */
@GeneratedMavMessage(
  id = 152,
  crc = 208,
)
public data class Meminfo(
  /**
   * Heap top.
   */
  public val brkval: Int = 0,
  /**
   * Free memory.
   */
  public val freemem: Int = 0,
  /**
   * Free memory (32 bit).
   */
  public val freemem32: Long = 0L,
) : MavMessage<Meminfo> {
  public override val instanceMetadata: MavMessage.Metadata<Meminfo> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(brkval)
    outputBuffer.encodeUint16(freemem)
    outputBuffer.encodeUint32(freemem32)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 152

    private const val CRC: Int = 208

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<Meminfo> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val brkval = inputBuffer.decodeUint16()
      val freemem = inputBuffer.decodeUint16()
      val freemem32 = inputBuffer.decodeUint32()

      Meminfo(
        brkval = brkval,
        freemem = freemem,
        freemem32 = freemem32,
      )
    }


    private val METADATA: MavMessage.Metadata<Meminfo> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Meminfo> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var brkval: Int = 0

    public var freemem: Int = 0

    public var freemem32: Long = 0L

    public fun build(): Meminfo = Meminfo(
      brkval = brkval,
      freemem = freemem,
      freemem32 = freemem32,
    )
  }
}
