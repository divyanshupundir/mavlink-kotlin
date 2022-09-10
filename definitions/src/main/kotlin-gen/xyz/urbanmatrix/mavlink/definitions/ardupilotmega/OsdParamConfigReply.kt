package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Configure OSD parameter reply.
 */
@GeneratedMavMessage(
  id = 11034,
  crc = 79,
)
public data class OsdParamConfigReply(
  /**
   * Request ID - copied from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: Long = 0L,
  /**
   * Config error type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0),
) : MavMessage<OsdParamConfigReply> {
  public override val instanceMetadata: MavMessage.Metadata<OsdParamConfigReply> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeEnumValue(result.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeEnumValue(result.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 11034

    private const val CRC: Int = 79

    private const val SIZE: Int = 5

    private val DESERIALIZER: MavDeserializer<OsdParamConfigReply> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
      val result = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = OsdParamConfigError.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      OsdParamConfigReply(
        requestId = requestId,
        result = result,
      )
    }


    private val METADATA: MavMessage.Metadata<OsdParamConfigReply> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OsdParamConfigReply> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: Long = 0L

    public var result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0)

    public fun build(): OsdParamConfigReply = OsdParamConfigReply(
      requestId = requestId,
      result = result,
    )
  }
}
