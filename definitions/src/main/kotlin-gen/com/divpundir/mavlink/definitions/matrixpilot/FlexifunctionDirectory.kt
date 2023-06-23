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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(directoryType)
    output.encodeUInt8(startIndex)
    output.encodeUInt8(count)
    output.encodeInt8Array(directoryData, 48)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(directoryType)
    output.encodeUInt8(startIndex)
    output.encodeUInt8(count)
    output.encodeInt8Array(directoryData, 48)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionDirectory> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    public override val id: UInt = 155u

    public override val crcExtra: Byte = 12

    public override fun deserialize(source: BufferedSource): FlexifunctionDirectory {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val directoryType = source.decodeUInt8()
      val startIndex = source.decodeUInt8()
      val count = source.decodeUInt8()
      val directoryData = source.decodeInt8Array(48)

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
