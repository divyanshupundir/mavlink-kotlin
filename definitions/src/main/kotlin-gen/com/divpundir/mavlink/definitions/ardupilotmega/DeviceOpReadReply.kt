package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

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
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpReadReply> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeUInt8(result)
    outputBuffer.encodeUInt8(regstart)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8Array(data, 128)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeUInt8(result)
    outputBuffer.encodeUInt8(regstart)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8Array(data, 128)
    outputBuffer.encodeUInt8(bank)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11_001u

    private const val CRC_EXTRA: Byte = 15

    private const val SIZE_V1: Int = 135

    private const val SIZE_V2: Int = 136

    private val DESERIALIZER: MavDeserializer<DeviceOpReadReply> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUInt32()
      val result = inputBuffer.decodeUInt8()
      val regstart = inputBuffer.decodeUInt8()
      val count = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(128)
      val bank = inputBuffer.decodeUInt8()

      DeviceOpReadReply(
        requestId = requestId,
        result = result,
        regstart = regstart,
        count = count,
        data = data,
        bank = bank,
      )
    }


    private val METADATA: MavMessage.Metadata<DeviceOpReadReply> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DeviceOpReadReply> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DeviceOpReadReply =
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
