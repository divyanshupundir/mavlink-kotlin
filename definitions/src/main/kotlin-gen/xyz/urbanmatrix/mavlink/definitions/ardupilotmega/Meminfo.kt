package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * State of autopilot RAM.
 */
@GeneratedMavMessage(
  id = 152u,
  crcExtra = -48,
)
public data class Meminfo(
  /**
   * Heap top.
   */
  @GeneratedMavField(type = "uint16_t")
  public val brkval: UShort = 0u,
  /**
   * Free memory.
   */
  @GeneratedMavField(type = "uint16_t")
  public val freemem: UShort = 0u,
  /**
   * Free memory (32 bit).
   */
  @GeneratedMavField(
    type = "uint32_t",
    extension = true,
  )
  public val freemem32: UInt = 0u,
) : MavMessage<Meminfo> {
  public override val instanceMetadata: MavMessage.Metadata<Meminfo> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(brkval)
    outputBuffer.encodeUInt16(freemem)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(brkval)
    outputBuffer.encodeUInt16(freemem)
    outputBuffer.encodeUInt32(freemem32)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 152u

    private const val CRC_EXTRA: Byte = -48

    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 8

    private val DESERIALIZER: MavDeserializer<Meminfo> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val brkval = inputBuffer.decodeUInt16()
      val freemem = inputBuffer.decodeUInt16()
      val freemem32 = inputBuffer.decodeUInt32()

      Meminfo(
        brkval = brkval,
        freemem = freemem,
        freemem32 = freemem32,
      )
    }


    private val METADATA: MavMessage.Metadata<Meminfo> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Meminfo> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Meminfo =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var brkval: UShort = 0u

    public var freemem: UShort = 0u

    public var freemem32: UInt = 0u

    public fun build(): Meminfo = Meminfo(
      brkval = brkval,
      freemem = freemem,
      freemem32 = freemem32,
    )
  }
}
