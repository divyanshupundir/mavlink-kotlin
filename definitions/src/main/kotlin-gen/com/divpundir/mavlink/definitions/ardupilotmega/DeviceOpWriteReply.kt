package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeUInt8(result)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeUInt8(result)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DeviceOpWriteReply> {
    public override val id: UInt = 11_003u

    public override val crcExtra: Byte = 64

    public override fun deserialize(bytes: ByteArray): DeviceOpWriteReply {
      val buffer = Buffer().write(bytes)

      val requestId = buffer.decodeUInt32()
      val result = buffer.decodeUInt8()

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
