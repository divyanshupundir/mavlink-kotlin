package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Response from a GOPRO_COMMAND get request.
 */
@GeneratedMavMessage(
  id = 217,
  crc = 202,
)
public data class GoproGetResponse(
  /**
   * Command ID.
   */
  public val cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0),
  /**
   * Status.
   */
  public val status: MavEnumValue<GoproRequestStatus> = MavEnumValue.fromValue(0),
  /**
   * Value.
   */
  public val `value`: List<Int> = emptyList(),
) : MavMessage<GoproGetResponse> {
  public override val instanceMetadata: MavMessage.Metadata<GoproGetResponse> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeEnumValue(status.value, 1)
    outputBuffer.encodeUint8Array(value, 4)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 217

    private const val CRC: Int = 202

    private const val SIZE: Int = 6

    private val DESERIALIZER: MavDeserializer<GoproGetResponse> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val cmdId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproRequestStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val value = inputBuffer.decodeUint8Array(4)

      GoproGetResponse(
        cmdId = cmdId,
        status = status,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproGetResponse> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproGetResponse> = METADATA
  }
}
