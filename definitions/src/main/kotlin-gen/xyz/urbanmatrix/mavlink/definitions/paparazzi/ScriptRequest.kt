package xyz.urbanmatrix.mavlink.definitions.paparazzi

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: Int = 0,
) : MavMessage<ScriptRequest> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptRequest> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var seq: Int = 0

    public fun build(): ScriptRequest = ScriptRequest(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
    )
  }
}
