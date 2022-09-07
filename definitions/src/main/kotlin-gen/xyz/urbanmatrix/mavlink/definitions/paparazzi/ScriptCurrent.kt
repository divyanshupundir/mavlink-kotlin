package xyz.urbanmatrix.mavlink.definitions.paparazzi

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16

/**
 * This message informs about the currently active SCRIPT.
 */
@GeneratedMavMessage(
  id = 184,
  crc = 40,
)
public data class ScriptCurrent(
  /**
   * Active Sequence
   */
  public val seq: Int = 0,
) : MavMessage<ScriptCurrent> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptCurrent> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 184

    private const val CRC: Int = 40

    private const val SIZE: Int = 2

    private val DESERIALIZER: MavDeserializer<ScriptCurrent> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seq = inputBuffer.decodeUint16()

      ScriptCurrent(
        seq = seq,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptCurrent> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptCurrent> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var seq: Int = 0

    public fun build(): ScriptCurrent = ScriptCurrent(
      seq = seq,
    )
  }
}
