package xyz.urbanmatrix.mavlink.definitions.paparazzi

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Request the overall list of mission items from the system/component.
 */
@GeneratedMavMessage(
  id = 182,
  crc = 115,
)
public data class ScriptRequestList(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
) : MavMessage<ScriptRequestList> {
  public override val instanceMetadata: MavMessage.Metadata<ScriptRequestList> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 182

    private const val CRC: Int = 115

    private const val SIZE: Int = 2

    private val DESERIALIZER: MavDeserializer<ScriptRequestList> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      ScriptRequestList(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }


    private val METADATA: MavMessage.Metadata<ScriptRequestList> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScriptRequestList> = METADATA
  }
}
