package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * A forwarded CAN frame as requested by MAV_CMD_CAN_FORWARD.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param bus Bus number
 * @param len Frame length
 * @param id Frame ID
 * @param data Frame data
 */
@GeneratedMavMessage(
  id = 386u,
  crcExtra = -124,
)
public data class CanFrame(
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
   * Bus number
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
  @GeneratedMavField(type = "uint8_t[8]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<CanFrame> {
  override val instanceCompanion: MavMessage.MavCompanion<CanFrame> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(id)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(bus)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 8)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(id)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(bus)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 8)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CanFrame> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    override val id: UInt = 386u

    override val crcExtra: Byte = -124

    override fun deserialize(bytes: ByteArray): CanFrame {
      val decoder = MavDataDecoder(bytes)

      val id = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val bus = decoder.safeDecodeUInt8()
      val len = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(8)

      return CanFrame(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        len = len,
        id = id,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CanFrame =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var bus: UByte = 0u

    public var len: UByte = 0u

    public var id: UInt = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): CanFrame = CanFrame(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      bus = bus,
      len = len,
      id = id,
      data = data,
    )
  }
}
