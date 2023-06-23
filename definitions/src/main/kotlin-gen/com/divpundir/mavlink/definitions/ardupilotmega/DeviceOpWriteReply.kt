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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeUInt8(result)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeUInt8(result)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<DeviceOpWriteReply> {
    private const val SIZE_V1: Int = 5

    private const val SIZE_V2: Int = 5

    public override val id: UInt = 11_003u

    public override val crcExtra: Byte = 64

    public override fun deserialize(source: BufferedSource): DeviceOpWriteReply {
      val requestId = source.decodeUInt32()
      val result = source.decodeUInt8()

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
