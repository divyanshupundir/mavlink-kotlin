package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Monitoring of sensorpod status
 */
@GeneratedMavMessage(
  id = 8_012u,
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
  public override val instanceCompanion: MavMessage.MavCompanion<SensorpodStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeUInt16(freeSpace)
    buffer.encodeUInt8(visensorRate1)
    buffer.encodeUInt8(visensorRate2)
    buffer.encodeUInt8(visensorRate3)
    buffer.encodeUInt8(visensorRate4)
    buffer.encodeUInt8(recordingNodesCount)
    buffer.encodeUInt8(cpuTemp)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeUInt16(freeSpace)
    buffer.encodeUInt8(visensorRate1)
    buffer.encodeUInt8(visensorRate2)
    buffer.encodeUInt8(visensorRate3)
    buffer.encodeUInt8(visensorRate4)
    buffer.encodeUInt8(recordingNodesCount)
    buffer.encodeUInt8(cpuTemp)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensorpodStatus> {
    public override val id: UInt = 8_012u

    public override val crcExtra: Byte = 54

    public override fun deserialize(bytes: ByteArray): SensorpodStatus {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt64()
      val freeSpace = buffer.decodeUInt16()
      val visensorRate1 = buffer.decodeUInt8()
      val visensorRate2 = buffer.decodeUInt8()
      val visensorRate3 = buffer.decodeUInt8()
      val visensorRate4 = buffer.decodeUInt8()
      val recordingNodesCount = buffer.decodeUInt8()
      val cpuTemp = buffer.decodeUInt8()

      return SensorpodStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SensorpodStatus =
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
