package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
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
 * Data packet, size 96.
 */
@GeneratedMavMessage(
  id = 172u,
  crcExtra = 22,
)
public data class Data96(
  /**
   * Data type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: UByte = 0u,
  /**
   * Data length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * Raw data.
   */
  @GeneratedMavField(type = "uint8_t[96]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<Data96> {
  public override val instanceMetadata: MavMessage.Metadata<Data96> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(type)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 96)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(type)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 96)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 172u

    private const val CRC_EXTRA: Byte = 22

    private const val SIZE_V1: Int = 98

    private const val SIZE_V2: Int = 98

    private val DESERIALIZER: MavDeserializer<Data96> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val type = inputBuffer.decodeUInt8()
      val len = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(96)

      Data96(
        type = type,
        len = len,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<Data96> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Data96> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Data96 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var type: UByte = 0u

    public var len: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): Data96 = Data96(
      type = type,
      len = len,
      data = data,
    )
  }
}
