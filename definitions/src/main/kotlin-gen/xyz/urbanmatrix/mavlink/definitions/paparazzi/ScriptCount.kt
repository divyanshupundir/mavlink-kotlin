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
 * This message is emitted as response to SCRIPT_REQUEST_LIST by the MAV to get the number of
 * mission scripts.
 */
@GeneratedMavMessage(
  id = 183,
  crc = 186,
)
public data class ScriptCount(
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
   * Number of script items in the sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val count: Int = 0,
) : MavMessage<ScriptCount> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptCount> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(count)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(count)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 183

    private const val CRC: Int = 186

    private const val SIZE: Int = 4

    private val DESERIALIZER: MavDeserializer<ScriptCount> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val count = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      ScriptCount(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        count = count,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptCount> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptCount> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var count: Int = 0

    public fun build(): ScriptCount = ScriptCount(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      count = count,
    )
  }
}
