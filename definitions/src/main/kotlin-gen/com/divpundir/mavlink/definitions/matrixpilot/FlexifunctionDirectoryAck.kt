package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 156u,
  crcExtra = -38,
)
public data class FlexifunctionDirectoryAck(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * 0=inputs, 1=outputs
   */
  @GeneratedMavField(type = "uint8_t")
  public val directoryType: UByte = 0u,
  /**
   * index of first directory entry to write
   */
  @GeneratedMavField(type = "uint8_t")
  public val startIndex: UByte = 0u,
  /**
   * count of directory entries to write
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * result of acknowledge, 0=fail, 1=good
   */
  @GeneratedMavField(type = "uint16_t")
  public val result: UShort = 0u,
) : MavMessage<FlexifunctionDirectoryAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionDirectoryAck> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(result)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(directoryType)
    buffer.encodeUInt8(startIndex)
    buffer.encodeUInt8(count)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(result)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(directoryType)
    buffer.encodeUInt8(startIndex)
    buffer.encodeUInt8(count)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionDirectoryAck> {
    public override val id: UInt = 156u

    public override val crcExtra: Byte = -38

    public override fun deserialize(bytes: ByteArray): FlexifunctionDirectoryAck {
      val buffer = Buffer().write(bytes)

      val result = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val directoryType = buffer.decodeUInt8()
      val startIndex = buffer.decodeUInt8()
      val count = buffer.decodeUInt8()

      return FlexifunctionDirectoryAck(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        directoryType = directoryType,
        startIndex = startIndex,
        count = count,
        result = result,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionDirectoryAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var directoryType: UByte = 0u

    public var startIndex: UByte = 0u

    public var count: UByte = 0u

    public var result: UShort = 0u

    public fun build(): FlexifunctionDirectoryAck = FlexifunctionDirectoryAck(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      directoryType = directoryType,
      startIndex = startIndex,
      count = count,
      result = result,
    )
  }
}
