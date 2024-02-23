package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Accept / deny control of this MAV
 *
 * @param gcsSystemId ID of the GCS this message 
 * @param controlRequest 0: request control of this MAV, 1: Release control of this MAV
 * @param ack 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3:
 * NACK: Already under control
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
  override val instanceCompanion: MavMessage.MavCompanion<ChangeOperatorControlAck> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(gcsSystemId)
    encoder.encodeUInt8(controlRequest)
    encoder.encodeUInt8(ack)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(gcsSystemId)
    encoder.encodeUInt8(controlRequest)
    encoder.encodeUInt8(ack)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ChangeOperatorControlAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    override val id: UInt = 6u

    override val crcExtra: Byte = 104

    override fun deserialize(bytes: ByteArray): ChangeOperatorControlAck {
      val decoder = MavDataDecoder(bytes)

      val gcsSystemId = decoder.safeDecodeUInt8()
      val controlRequest = decoder.safeDecodeUInt8()
      val ack = decoder.safeDecodeUInt8()

      return ChangeOperatorControlAck(
        gcsSystemId = gcsSystemId,
        controlRequest = controlRequest,
        ack = ack,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ChangeOperatorControlAck =
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
