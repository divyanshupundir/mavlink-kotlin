package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * State of autopilot RAM.
 */
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
  }
}
