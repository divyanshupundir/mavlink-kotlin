package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Accept / deny control of this MAV
 */
@GeneratedMavMessage(
  id = 6,
  crc = 104,
)
public data class ChangeOperatorControlAck(
  /**
   * ID of the GCS this message 
   */
  @GeneratedMavField(type = "uint8_t")
  public val gcsSystemId: Int = 0,
  /**
   * 0: request control of this MAV, 1: Release control of this MAV
   */
  @GeneratedMavField(type = "uint8_t")
  public val controlRequest: Int = 0,
  /**
   * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK:
   * Already under control
   */
  @GeneratedMavField(type = "uint8_t")
  public val ack: Int = 0,
) : MavMessage<ChangeOperatorControlAck> {
  public override val instanceMetadata: MavMessage.Metadata<ChangeOperatorControlAck> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(gcsSystemId)
    outputBuffer.encodeUint8(controlRequest)
    outputBuffer.encodeUint8(ack)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(gcsSystemId)
    outputBuffer.encodeUint8(controlRequest)
    outputBuffer.encodeUint8(ack)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 6

    private const val CRC: Int = 104

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<ChangeOperatorControlAck> = MavDeserializer { bytes ->
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var gcsSystemId: Int = 0

    public var controlRequest: Int = 0

    public var ack: Int = 0

    public fun build(): ChangeOperatorControlAck = ChangeOperatorControlAck(
      gcsSystemId = gcsSystemId,
      controlRequest = controlRequest,
      ack = ack,
    )
  }
}
