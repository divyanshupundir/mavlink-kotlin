package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Read registers reply.
 */
@GeneratedMavMessage(
  id = 11_001u,
  crcExtra = 15,
)
public data class DeviceOpReadReply(
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
  /**
   * Starting register.
   */
  @GeneratedMavField(type = "uint8_t")
  public val regstart: UByte = 0u,
  /**
   * Count of bytes read.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Reply data.
   */
  @GeneratedMavField(type = "uint8_t[128]")
  public val `data`: List<UByte> = emptyList(),
  /**
   * Bank number.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val bank: UByte = 0u,
) : MavMessage<DeviceOpReadReply> {
  public override val instanceCompanion: MavMessage.MavCompanion<DeviceOpReadReply> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeUInt8(result)
    output.encodeUInt8(regstart)
    output.encodeUInt8(count)
    output.encodeUInt8Array(data, 128)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeUInt8(result)
    output.encodeUInt8(regstart)
    output.encodeUInt8(count)
    output.encodeUInt8Array(data, 128)
    output.encodeUInt8(bank)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<DeviceOpReadReply> {
    private const val SIZE_V1: Int = 135

    private const val SIZE_V2: Int = 136

    public override val id: UInt = 11_001u

    public override val crcExtra: Byte = 15

    public override fun deserialize(source: BufferedSource): DeviceOpReadReply {
      val requestId = source.decodeUInt32()
      val result = source.decodeUInt8()
      val regstart = source.decodeUInt8()
      val count = source.decodeUInt8()
      val data = source.decodeUInt8Array(128)
      val bank = source.decodeUInt8()

      return DeviceOpReadReply(
        requestId = requestId,
        result = result,
        regstart = regstart,
        count = count,
        data = data,
        bank = bank,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DeviceOpReadReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UInt = 0u

    public var result: UByte = 0u

    public var regstart: UByte = 0u

    public var count: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public var bank: UByte = 0u

    public fun build(): DeviceOpReadReply = DeviceOpReadReply(
      requestId = requestId,
      result = result,
      regstart = regstart,
      count = count,
      data = data,
      bank = bank,
    )
  }
}
