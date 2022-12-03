package xyz.urbanmatrix.mavlink.definitions.common

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
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Request to read the value of a parameter with either the param_id string id or param_index.
 * PARAM_EXT_VALUE should be emitted in response.
 */
@GeneratedMavMessage(
  id = 320,
  crc = 243,
)
public data class ParamExtRequestRead(
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
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1
   * bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be
   * ignored)
   */
  @GeneratedMavField(type = "int16_t")
  public val paramIndex: Int = 0,
) : MavMessage<ParamExtRequestRead> {
  public override val instanceMetadata: MavMessage.Metadata<ParamExtRequestRead> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(paramIndex)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(paramId, 16)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(paramIndex)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(paramId, 16)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 320

    private const val CRC: Int = 243

    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    private val DESERIALIZER: MavDeserializer<ParamExtRequestRead> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val paramIndex = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val paramId = inputBuffer.decodeString(16)

      ParamExtRequestRead(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramIndex = paramIndex,
      )
    }


    private val METADATA: MavMessage.Metadata<ParamExtRequestRead> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ParamExtRequestRead> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ParamExtRequestRead =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var paramId: String = ""

    public var paramIndex: Int = 0

    public fun build(): ParamExtRequestRead = ParamExtRequestRead(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      paramId = paramId,
      paramIndex = paramIndex,
    )
  }
}
