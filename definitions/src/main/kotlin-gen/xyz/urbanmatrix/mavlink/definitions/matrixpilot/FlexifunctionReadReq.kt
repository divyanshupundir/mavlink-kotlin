package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Reqest reading of flexifunction data
 */
@GeneratedMavMessage(
  id = 151u,
  crcExtra = 26,
)
public data class FlexifunctionReadReq(
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
   * Type of flexifunction data requested
   */
  @GeneratedMavField(type = "int16_t")
  public val readReqType: Short = 0,
  /**
   * index into data where needed
   */
  @GeneratedMavField(type = "int16_t")
  public val dataIndex: Short = 0,
) : MavMessage<FlexifunctionReadReq> {
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionReadReq> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(readReqType)
    outputBuffer.encodeInt16(dataIndex)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(readReqType)
    outputBuffer.encodeInt16(dataIndex)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 151u

    private const val CRC_EXTRA: Byte = 26

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    private val DESERIALIZER: MavDeserializer<FlexifunctionReadReq> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val readReqType = inputBuffer.decodeInt16()
      val dataIndex = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      FlexifunctionReadReq(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        readReqType = readReqType,
        dataIndex = dataIndex,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionReadReq> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionReadReq> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FlexifunctionReadReq =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var readReqType: Short = 0

    public var dataIndex: Short = 0

    public fun build(): FlexifunctionReadReq = FlexifunctionReadReq(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      readReqType = readReqType,
      dataIndex = dataIndex,
    )
  }
}
