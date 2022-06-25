package com.urbanmatrix.mavlink.icarous

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * ICAROUS heartbeat
 */
public data class IcarousHeartbeat(
  /**
   * See the FMS_STATE enum.
   */
  public val status: MavEnumValue<IcarousFmsState> = MavEnumValue.fromValue(0),
) : MavMessage<IcarousHeartbeat> {
  public override val instanceMetadata: MavMessage.Metadata<IcarousHeartbeat> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(status.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 42000

    private const val CRC: Int = 227

    private val DESERIALIZER: MavDeserializer<IcarousHeartbeat> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = IcarousFmsState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      IcarousHeartbeat(
        status = status,
      )
    }


    private val METADATA: MavMessage.Metadata<IcarousHeartbeat> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<IcarousHeartbeat> = METADATA
  }
}
