package com.divpundir.mavlink.definitions.common

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
 * A forwarded CANFD frame as requested by MAV_CMD_CAN_FORWARD. These are separated from CAN_FRAME
 * as they need different handling (eg. TAO handling)
 */
@GeneratedMavMessage(
  id = 387u,
  crcExtra = 4,
)
public data class CanfdFrame(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * bus number
   */
  @GeneratedMavField(type = "uint8_t")
  public val bus: UByte = 0u,
  /**
   * Frame length
   */
  @GeneratedMavField(type = "uint8_t")
  public val len: UByte = 0u,
  /**
   * Frame ID
   */
  @GeneratedMavField(type = "uint32_t")
  public val id: UInt = 0u,
  /**
   * Frame data
   */
  @GeneratedMavField(type = "uint8_t[64]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<CanfdFrame> {
  public override val instanceMetadata: MavMessage.Metadata<CanfdFrame> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(id)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(bus)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 64)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(id)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(bus)
    outputBuffer.encodeUInt8(len)
    outputBuffer.encodeUInt8Array(data, 64)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 387u

    private const val CRC_EXTRA: Byte = 4

    private const val SIZE_V1: Int = 72

    private const val SIZE_V2: Int = 72

    private val DESERIALIZER: MavDeserializer<CanfdFrame> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val id = inputBuffer.decodeUInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val bus = inputBuffer.decodeUInt8()
      val len = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(64)

      CanfdFrame(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        len = len,
        id = id,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<CanfdFrame> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CanfdFrame> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CanfdFrame =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var bus: UByte = 0u

    public var len: UByte = 0u

    public var id: UInt = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): CanfdFrame = CanfdFrame(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      bus = bus,
      len = len,
      id = id,
      data = data,
    )
  }
}
