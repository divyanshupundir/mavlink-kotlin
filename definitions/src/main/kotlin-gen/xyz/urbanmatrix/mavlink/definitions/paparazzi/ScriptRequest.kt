package xyz.urbanmatrix.mavlink.definitions.paparazzi

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request script item with the sequence number seq. The response of the system to this message
 * should be a SCRIPT_ITEM message.
 */
@GeneratedMavMessage(
  id = 181,
  crc = 129,
)
public data class ScriptRequest(
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
) : MavMessage<ScriptRequest> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptRequest> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 181

    private const val CRC: Int = 129

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<ScriptRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seq = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      ScriptRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptRequest> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptRequest> = METADATA
  }
}
