package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Write registers reply.
 */
@GeneratedMavMessage(
  id = 11_003u,
  crcExtra = 64,
)
public data class DeviceOpWriteReply(
  /**
   * Request ID - copied from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: UInt = 0u,
  /**
   * 0 for success, anything else is failure code.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: UByte = 0u,
) : MavMessage<DeviceOpWriteReply> {
  public override val instanceCompanion: MavMessage.MavCompanion<DeviceOpWriteReply> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(result)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(result)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DeviceOpWriteReply> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    public override val id: UInt = 11_003u

    public override val crcExtra: Byte = 64

    public override fun deserialize(bytes: ByteArray): DeviceOpWriteReply {
      val decoder = MavDataDecoder(bytes)

      val requestId = decoder.safeDecodeUInt32()
      val result = decoder.safeDecodeUInt8()

      return DeviceOpWriteReply(
        requestId = requestId,
        result = result,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DeviceOpWriteReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UInt = 0u

    public var result: UByte = 0u

    public fun build(): DeviceOpWriteReply = DeviceOpWriteReply(
      requestId = requestId,
      result = result,
    )
  }
}
