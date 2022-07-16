package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Accept / deny control of this MAV
 */
public data class ChangeOperatorControlAck(
  /**
   * ID of the GCS this message 
   */
  public val gcsSystemId: Int = 0,
  /**
   * 0: request control of this MAV, 1: Release control of this MAV
   */
  public val controlRequest: Int = 0,
  /**
   * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK:
   * Already under control
   */
  public val ack: Int = 0,
) : MavMessage<ChangeOperatorControlAck> {
  public override val instanceMetadata: MavMessage.Metadata<ChangeOperatorControlAck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(gcsSystemId)
    outputBuffer.encodeUint8(controlRequest)
    outputBuffer.encodeUint8(ack)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 6

    private const val CRC: Int = 104

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<ChangeOperatorControlAck> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for ChangeOperatorControlAck: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val gcsSystemId = inputBuffer.decodeUint8()
      val controlRequest = inputBuffer.decodeUint8()
      val ack = inputBuffer.decodeUint8()

      ChangeOperatorControlAck(
        gcsSystemId = gcsSystemId,
        controlRequest = controlRequest,
        ack = ack,
      )
    }


    private val METADATA: MavMessage.Metadata<ChangeOperatorControlAck> = MavMessage.Metadata(ID,
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ChangeOperatorControlAck> = METADATA
  }
}
