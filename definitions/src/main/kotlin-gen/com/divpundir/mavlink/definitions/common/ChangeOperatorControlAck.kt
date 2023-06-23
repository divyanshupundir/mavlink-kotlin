package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(gcsSystemId)
    output.encodeUInt8(controlRequest)
    output.encodeUInt8(ack)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(gcsSystemId)
    output.encodeUInt8(controlRequest)
    output.encodeUInt8(ack)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ChangeOperatorControlAck> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 6u

    public override val crcExtra: Byte = 104

    public override fun deserialize(source: BufferedSource): ChangeOperatorControlAck {
      val gcsSystemId = source.decodeUInt8()
      val controlRequest = source.decodeUInt8()
      val ack = source.decodeUInt8()

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
