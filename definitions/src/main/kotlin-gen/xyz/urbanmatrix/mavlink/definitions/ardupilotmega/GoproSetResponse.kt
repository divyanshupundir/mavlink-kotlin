package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue

/**
 * Response from a GOPRO_COMMAND set request.
 */
@GeneratedMavMessage(
  id = 219,
  crc = 162,
)
public data class GoproSetResponse(
  /**
   * Command ID.
   */
  public val cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0),
  /**
   * Status.
   */
  public val status: MavEnumValue<GoproRequestStatus> = MavEnumValue.fromValue(0),
) : MavMessage<GoproSetResponse> {
  public override val instanceMetadata: MavMessage.Metadata<GoproSetResponse> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeEnumValue(status.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 219

    private const val CRC: Int = 162

    private const val SIZE: Int = 2

    private val DESERIALIZER: MavDeserializer<GoproSetResponse> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val cmdId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproRequestStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      GoproSetResponse(
        cmdId = cmdId,
        status = status,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproSetResponse> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproSetResponse> = METADATA
  }
}
