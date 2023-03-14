package xyz.urbanmatrix.mavlink.definitions.asluav

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Monitoring of sensorpod status
 */
@GeneratedMavMessage(
  id = 8012u,
  crcExtra = 54,
)
public data class SensorpodStatus(
  /**
   * Timestamp in linuxtime (since 1.1.1970)
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Rate of ROS topic 1
   */
  @GeneratedMavField(type = "uint8_t")
  public val visensorRate1: UByte = 0u,
  /**
   * Rate of ROS topic 2
   */
  @GeneratedMavField(type = "uint8_t")
  public val visensorRate2: UByte = 0u,
  /**
   * Rate of ROS topic 3
   */
  @GeneratedMavField(type = "uint8_t")
  public val visensorRate3: UByte = 0u,
  /**
   * Rate of ROS topic 4
   */
  @GeneratedMavField(type = "uint8_t")
  public val visensorRate4: UByte = 0u,
  /**
   * Number of recording nodes
   */
  @GeneratedMavField(type = "uint8_t")
  public val recordingNodesCount: UByte = 0u,
  /**
   * Temperature of sensorpod CPU in
   */
  @GeneratedMavField(type = "uint8_t")
  public val cpuTemp: UByte = 0u,
  /**
   * Free space available in recordings directory in [Gb] * 1e2
   */
  @GeneratedMavField(type = "uint16_t")
  public val freeSpace: UShort = 0u,
) : MavMessage<SensorpodStatus> {
  public override val instanceMetadata: MavMessage.Metadata<SensorpodStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt16(freeSpace)
    outputBuffer.encodeUInt8(visensorRate1)
    outputBuffer.encodeUInt8(visensorRate2)
    outputBuffer.encodeUInt8(visensorRate3)
    outputBuffer.encodeUInt8(visensorRate4)
    outputBuffer.encodeUInt8(recordingNodesCount)
    outputBuffer.encodeUInt8(cpuTemp)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeUInt16(freeSpace)
    outputBuffer.encodeUInt8(visensorRate1)
    outputBuffer.encodeUInt8(visensorRate2)
    outputBuffer.encodeUInt8(visensorRate3)
    outputBuffer.encodeUInt8(visensorRate4)
    outputBuffer.encodeUInt8(recordingNodesCount)
    outputBuffer.encodeUInt8(cpuTemp)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8012u

    private const val CRC_EXTRA: Byte = 54

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<SensorpodStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val freeSpace = inputBuffer.decodeUInt16()
      val visensorRate1 = inputBuffer.decodeUInt8()
      val visensorRate2 = inputBuffer.decodeUInt8()
      val visensorRate3 = inputBuffer.decodeUInt8()
      val visensorRate4 = inputBuffer.decodeUInt8()
      val recordingNodesCount = inputBuffer.decodeUInt8()
      val cpuTemp = inputBuffer.decodeUInt8()

      SensorpodStatus(
        timestamp = timestamp,
        visensorRate1 = visensorRate1,
        visensorRate2 = visensorRate2,
        visensorRate3 = visensorRate3,
        visensorRate4 = visensorRate4,
        recordingNodesCount = recordingNodesCount,
        cpuTemp = cpuTemp,
        freeSpace = freeSpace,
      )
    }


    private val METADATA: MavMessage.Metadata<SensorpodStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorpodStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensorpodStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var visensorRate1: UByte = 0u

    public var visensorRate2: UByte = 0u

    public var visensorRate3: UByte = 0u

    public var visensorRate4: UByte = 0u

    public var recordingNodesCount: UByte = 0u

    public var cpuTemp: UByte = 0u

    public var freeSpace: UShort = 0u

    public fun build(): SensorpodStatus = SensorpodStatus(
      timestamp = timestamp,
      visensorRate1 = visensorRate1,
      visensorRate2 = visensorRate2,
      visensorRate3 = visensorRate3,
      visensorRate4 = visensorRate4,
      recordingNodesCount = recordingNodesCount,
      cpuTemp = cpuTemp,
      freeSpace = freeSpace,
    )
  }
}
