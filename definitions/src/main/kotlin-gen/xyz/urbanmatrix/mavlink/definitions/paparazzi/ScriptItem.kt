package xyz.urbanmatrix.mavlink.definitions.paparazzi

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Message encoding a mission script item. This message is emitted upon a request for the next
 * script item.
 */
@GeneratedMavMessage(
  id = 180,
  crc = 231,
)
public data class ScriptItem(
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
  /**
   * The name of the mission script, NULL terminated.
   */
  @GeneratedMavField(type = "char[50]")
  public val name: String = "",
) : MavMessage<ScriptItem> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptItem> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(name, 50)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(seq)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(name, 50)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 180

    private const val CRC: Int = 231

    private const val SIZE_V1: Int = 54

    private const val SIZE_V2: Int = 54

    private val DESERIALIZER: MavDeserializer<ScriptItem> = MavDeserializer { bytes ->
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

    public fun builder(builderAction: Builder.() -> Unit): ScriptItem =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var seq: Int = 0

    public var name: String = ""

    public fun build(): ScriptItem = ScriptItem(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
      name = name,
    )
  }
}
