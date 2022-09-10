package xyz.urbanmatrix.mavlink.definitions.matrixpilot

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
 * Flexifunction type and parameters for component at function index from buffer
 */
@GeneratedMavMessage(
  id = 153,
  crc = 109,
)
public data class FlexifunctionBufferFunctionAck(
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
   * Function index
   */
  @GeneratedMavField(type = "uint16_t")
  public val funcIndex: Int = 0,
  /**
   * result of acknowledge, 0=fail, 1=good
   */
  @GeneratedMavField(type = "uint16_t")
  public val result: Int = 0,
) : MavMessage<FlexifunctionBufferFunctionAck> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionBufferFunctionAck> =
      METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(funcIndex)
    outputBuffer.encodeUint16(result)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(funcIndex)
    outputBuffer.encodeUint16(result)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 153

    private const val CRC: Int = 109

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<FlexifunctionBufferFunctionAck> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val funcIndex = inputBuffer.decodeUint16()
      val result = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      FlexifunctionBufferFunctionAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        funcIndex = funcIndex,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionBufferFunctionAck> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionBufferFunctionAck> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var funcIndex: Int = 0

    public var result: Int = 0

    public fun build(): FlexifunctionBufferFunctionAck = FlexifunctionBufferFunctionAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      funcIndex = funcIndex,
      result = result,
    )
  }
}
