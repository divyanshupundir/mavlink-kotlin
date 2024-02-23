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
 * A forwarded CANFD frame as requested by MAV_CMD_CAN_FORWARD. These are separated from CAN_FRAME
 * as they need different handling (eg. TAO handling)
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param bus bus number
 * @param len Frame length
 * @param id Frame ID
 * @param data Frame data
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
  override val instanceCompanion: MavMessage.MavCompanion<CanfdFrame> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(id)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(bus)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 64)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(id)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(bus)
    encoder.encodeUInt8(len)
    encoder.encodeUInt8Array(data, 64)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CanfdFrame> {
    private const val SIZE_V1: Int = 72

    private const val SIZE_V2: Int = 72

    override val id: UInt = 387u

    override val crcExtra: Byte = 4

    override fun deserialize(bytes: ByteArray): CanfdFrame {
      val decoder = MavDataDecoder(bytes)

      val id = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val bus = decoder.safeDecodeUInt8()
      val len = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(64)

      return CanfdFrame(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        bus = bus,
        len = len,
        id = id,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CanfdFrame =
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
