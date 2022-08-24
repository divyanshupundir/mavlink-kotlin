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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request a GOPRO_COMMAND response from the GoPro.
 */
@GeneratedMavMessage(
  id = 216,
  crc = 50,
)
public data class GoproGetRequest(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Command ID.
   */
  public val cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0),
) : MavMessage<GoproGetRequest> {
  public override val instanceMetadata: MavMessage.Metadata<GoproGetRequest> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 216

    private const val CRC: Int = 50

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<GoproGetRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val cmdId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      GoproGetRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        cmdId = cmdId,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproGetRequest> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproGetRequest> = METADATA
  }
}
