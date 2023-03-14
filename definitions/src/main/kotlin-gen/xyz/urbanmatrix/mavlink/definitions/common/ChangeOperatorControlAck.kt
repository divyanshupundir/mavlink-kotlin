package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Accept / deny control of this MAV
 */
@GeneratedMavMessage(
  id = 6u,
  crcExtra = 104,
)
public data class ChangeOperatorControlAck(
  /**
   * ID of the GCS this message 
   */
  @GeneratedMavField(type = "uint8_t")
  public val gcsSystemId: UByte = 0u,
  /**
   * 0: request control of this MAV, 1: Release control of this MAV
   */
  @GeneratedMavField(type = "uint8_t")
  public val controlRequest: UByte = 0u,
  /**
   * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK:
   * Already under control
   */
  @GeneratedMavField(type = "uint8_t")
  public val ack: UByte = 0u,
) : MavMessage<ChangeOperatorControlAck> {
  public override val instanceMetadata: MavMessage.Metadata<ChangeOperatorControlAck> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(gcsSystemId)
    outputBuffer.encodeUInt8(controlRequest)
    outputBuffer.encodeUInt8(ack)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(gcsSystemId)
    outputBuffer.encodeUInt8(controlRequest)
    outputBuffer.encodeUInt8(ack)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 6u

    private const val CRC_EXTRA: Byte = 104

    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    private val DESERIALIZER: MavDeserializer<ChangeOperatorControlAck> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val gcsSystemId = inputBuffer.decodeUInt8()
      val controlRequest = inputBuffer.decodeUInt8()
      val ack = inputBuffer.decodeUInt8()

      ChangeOperatorControlAck(
        gcsSystemId = gcsSystemId,
        controlRequest = controlRequest,
        ack = ack,
      )
    }


    private val METADATA: MavMessage.Metadata<ChangeOperatorControlAck> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ChangeOperatorControlAck> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ChangeOperatorControlAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var gcsSystemId: UByte = 0u

    public var controlRequest: UByte = 0u

    public var ack: UByte = 0u

    public fun build(): ChangeOperatorControlAck = ChangeOperatorControlAck(
      gcsSystemId = gcsSystemId,
      controlRequest = controlRequest,
      ack = ack,
    )
  }
}
