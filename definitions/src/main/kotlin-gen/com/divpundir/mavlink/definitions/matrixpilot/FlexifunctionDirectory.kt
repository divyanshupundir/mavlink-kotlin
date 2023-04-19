package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
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
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionDirectory> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(directoryType)
    outputBuffer.encodeUInt8(startIndex)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeInt8Array(directoryData, 48)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(directoryType)
    outputBuffer.encodeUInt8(startIndex)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeInt8Array(directoryData, 48)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 155u

    private const val CRC_EXTRA: Byte = 12

    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    private val DESERIALIZER: MavDeserializer<FlexifunctionDirectory> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val directoryType = inputBuffer.decodeUInt8()
      val startIndex = inputBuffer.decodeUInt8()
      val count = inputBuffer.decodeUInt8()
      val directoryData = inputBuffer.decodeInt8Array(48)

      FlexifunctionDirectory(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        directoryType = directoryType,
        startIndex = startIndex,
        count = count,
        directoryData = directoryData,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionDirectory> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionDirectory> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FlexifunctionDirectory =
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
