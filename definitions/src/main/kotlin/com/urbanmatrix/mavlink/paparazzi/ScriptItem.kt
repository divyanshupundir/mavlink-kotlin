package com.urbanmatrix.mavlink.paparazzi

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Message encoding a mission script item. This message is emitted upon a request for the next
 * script item.
 */
public data class ScriptItem(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Sequence
   */
  public val seq: Int = 0,
  /**
   * The name of the mission script, NULL terminated.
   */
  public val name: String = "",
) : MavMessage<ScriptItem> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptItem> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(name, 50)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 180

    private const val CRC: Int = 130

    private const val SIZE: Int = 54

    private val DESERIALIZER: MavDeserializer<ScriptItem> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for ScriptItem: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seq = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val name = inputBuffer.decodeString(50)

      ScriptItem(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
        name = name,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptItem> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptItem> = METADATA
  }
}
