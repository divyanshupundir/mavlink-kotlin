package com.divpundir.mavlink.definitions.common

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
 * A forwarded CAN frame as requested by MAV_CMD_CAN_FORWARD.
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
  public override val instanceCompanion: MavMessage.MavCompanion<CanFrame> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(id)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(bus)
    output.encodeUInt8(len)
    output.encodeUInt8Array(data, 8)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(id)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(bus)
    output.encodeUInt8(len)
    output.encodeUInt8Array(data, 8)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CanFrame> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 386u

    public override val crcExtra: Byte = -124

    public override fun deserialize(source: BufferedSource): CanFrame {
      val id = source.decodeUInt32()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val bus = source.decodeUInt8()
      val len = source.decodeUInt8()
      val data = source.decodeUInt8Array(8)

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
