package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 155u,
  crcExtra = 12,
)
public data class FlexifunctionDirectory(
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
   * Settings data
   */
  @GeneratedMavField(type = "int8_t[48]")
  public val directoryData: List<Byte> = emptyList(),
) : MavMessage<FlexifunctionDirectory> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionDirectory> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(directoryType)
    buffer.encodeUInt8(startIndex)
    buffer.encodeUInt8(count)
    buffer.encodeInt8Array(directoryData, 48)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(directoryType)
    buffer.encodeUInt8(startIndex)
    buffer.encodeUInt8(count)
    buffer.encodeInt8Array(directoryData, 48)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionDirectory> {
    public override val id: UInt = 155u

    public override val crcExtra: Byte = 12

    public override fun deserialize(bytes: ByteArray): FlexifunctionDirectory {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val directoryType = buffer.decodeUInt8()
      val startIndex = buffer.decodeUInt8()
      val count = buffer.decodeUInt8()
      val directoryData = buffer.decodeInt8Array(48)

      return FlexifunctionDirectory(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        directoryType = directoryType,
        startIndex = startIndex,
        count = count,
        directoryData = directoryData,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionDirectory =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var directoryType: UByte = 0u

    public var startIndex: UByte = 0u

    public var count: UByte = 0u

    public var directoryData: List<Byte> = emptyList()

    public fun build(): FlexifunctionDirectory = FlexifunctionDirectory(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      directoryType = directoryType,
      startIndex = startIndex,
      count = count,
      directoryData = directoryData,
    )
  }
}
