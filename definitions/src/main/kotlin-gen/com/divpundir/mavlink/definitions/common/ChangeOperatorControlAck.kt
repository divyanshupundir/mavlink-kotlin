package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<ChangeOperatorControlAck> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(gcsSystemId)
    buffer.encodeUInt8(controlRequest)
    buffer.encodeUInt8(ack)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(gcsSystemId)
    buffer.encodeUInt8(controlRequest)
    buffer.encodeUInt8(ack)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ChangeOperatorControlAck> {
    public override val id: UInt = 6u

    public override val crcExtra: Byte = 104

    public override fun deserialize(bytes: ByteArray): ChangeOperatorControlAck {
      val buffer = Buffer().write(bytes)

      val gcsSystemId = buffer.decodeUInt8()
      val controlRequest = buffer.decodeUInt8()
      val ack = buffer.decodeUInt8()

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
