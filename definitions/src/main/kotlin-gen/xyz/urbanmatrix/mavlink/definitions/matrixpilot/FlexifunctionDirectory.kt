package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt8Array
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Acknowldge sucess or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 155,
  crc = 12,
)
public data class FlexifunctionDirectory(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * 0=inputs, 1=outputs
   */
  @GeneratedMavField(type = "uint8_t")
  public val directoryType: Int = 0,
  /**
   * index of first directory entry to write
   */
  @GeneratedMavField(type = "uint8_t")
  public val startIndex: Int = 0,
  /**
   * count of directory entries to write
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
  /**
   * Settings data
   */
  @GeneratedMavField(type = "int8_t[48]")
  public val directoryData: List<Int> = emptyList(),
) : MavMessage<FlexifunctionDirectory> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionDirectory> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(directoryType)
    outputBuffer.encodeUint8(startIndex)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeInt8Array(directoryData, 48)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(directoryType)
    outputBuffer.encodeUint8(startIndex)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeInt8Array(directoryData, 48)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 155

    private const val CRC: Int = 12

    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 53

    private val DESERIALIZER: MavDeserializer<FlexifunctionDirectory> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val directoryType = inputBuffer.decodeUint8()
      val startIndex = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()
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


    private val METADATA: MavMessage.Metadata<FlexifunctionDirectory> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionDirectory> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FlexifunctionDirectory =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var directoryType: Int = 0

    public var startIndex: Int = 0

    public var count: Int = 0

    public var directoryData: List<Int> = emptyList()

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
