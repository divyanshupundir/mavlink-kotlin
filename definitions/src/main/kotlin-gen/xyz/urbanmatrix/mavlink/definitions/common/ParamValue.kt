package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Emit the value of a onboard parameter. The inclusion of param_count and param_index in the
 * message allows the recipient to keep track of received parameters and allows him to re-request
 * missing parameters after a loss or timeout. The parameter microservice is documented at
 * https://mavlink.io/en/services/parameter.html
 */
@GeneratedMavMessage(
  id = 22,
  crc = 220,
)
public data class ParamValue(
  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to
   * provide 16+1 bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Onboard parameter value
   */
  @GeneratedMavField(type = "float")
  public val paramValue: Float = 0F,
  /**
   * Onboard parameter type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val paramType: MavEnumValue<MavParamType> = MavEnumValue.fromValue(0),
  /**
   * Total number of onboard parameters
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramCount: Int = 0,
  /**
   * Index of this onboard parameter
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramIndex: Int = 0,
) : MavMessage<ParamValue> {
  public override val instanceMetadata: MavMessage.Metadata<ParamValue> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(paramValue)
    outputBuffer.encodeUint16(paramCount)
    outputBuffer.encodeUint16(paramIndex)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeEnumValue(paramType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(paramValue)
    outputBuffer.encodeUint16(paramCount)
    outputBuffer.encodeUint16(paramIndex)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeEnumValue(paramType.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 22

    private const val CRC: Int = 220

    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    private val DESERIALIZER: MavDeserializer<ParamValue> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val paramValue = inputBuffer.decodeFloat()
      val paramCount = inputBuffer.decodeUint16()
      val paramIndex = inputBuffer.decodeUint16()
      val paramId = inputBuffer.decodeString(16)
      val paramType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavParamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      ParamValue(
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
        paramCount = paramCount,
        paramIndex = paramIndex,
      )
    }


    private val METADATA: MavMessage.Metadata<ParamValue> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ParamValue> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ParamValue =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var paramId: String = ""

    public var paramValue: Float = 0F

    public var paramType: MavEnumValue<MavParamType> = MavEnumValue.fromValue(0)

    public var paramCount: Int = 0

    public var paramIndex: Int = 0

    public fun build(): ParamValue = ParamValue(
      paramId = paramId,
      paramValue = paramValue,
      paramType = paramType,
      paramCount = paramCount,
      paramIndex = paramIndex,
    )
  }
}
