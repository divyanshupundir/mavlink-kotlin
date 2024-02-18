package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Acknowldge success or failure of a flexifunction command
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionDirectory> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(directoryType)
    encoder.encodeUInt8(startIndex)
    encoder.encodeUInt8(count)
    encoder.encodeInt8Array(directoryData, 48)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(directoryType)
    encoder.encodeUInt8(startIndex)
    encoder.encodeUInt8(count)
    encoder.encodeInt8Array(directoryData, 48)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionDirectory> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    override val id: UInt = 155u

    override val crcExtra: Byte = 12

    override fun deserialize(bytes: ByteArray): FlexifunctionDirectory {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val directoryType = decoder.safeDecodeUInt8()
      val startIndex = decoder.safeDecodeUInt8()
      val count = decoder.safeDecodeUInt8()
      val directoryData = decoder.safeDecodeInt8Array(48)

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
