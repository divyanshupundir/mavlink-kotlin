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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array

/**
 * Send a block of log data to remote location.
 */
@GeneratedMavMessage(
  id = 184,
  crc = 159,
)
public data class RemoteLogDataBlock(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Log data block sequence number.
   */
  public val seqno: MavEnumValue<MavRemoteLogDataBlockCommands> = MavEnumValue.fromValue(0),
  /**
   * Log data block.
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<RemoteLogDataBlock> {
  public override val instanceMetadata: MavMessage.Metadata<RemoteLogDataBlock> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(seqno.value, 4)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8Array(data, 200)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 184

    private const val CRC: Int = 159

    private const val SIZE: Int = 206

    private val DESERIALIZER: MavDeserializer<RemoteLogDataBlock> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seqno = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavRemoteLogDataBlockCommands.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(200)

      RemoteLogDataBlock(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seqno = seqno,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<RemoteLogDataBlock> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RemoteLogDataBlock> = METADATA
  }
}
