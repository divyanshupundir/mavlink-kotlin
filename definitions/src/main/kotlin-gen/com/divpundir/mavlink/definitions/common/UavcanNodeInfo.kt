package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * General information describing a particular UAVCAN node. Please refer to the definition of the
 * UAVCAN service "uavcan.protocol.GetNodeInfo" for the background information. This message should be
 * emitted by the system whenever a new node appears online, or an existing node reboots. Additionally,
 * it can be emitted upon request from the other end of the MAVLink channel (see
 * MAV_CMD_UAVCAN_GET_NODE_INFO). It is also not prohibited to emit this message unconditionally at a
 * low frequency. The UAVCAN specification is available at http://uavcan.org.
 */
@GeneratedMavMessage(
  id = 311u,
  crcExtra = 95,
)
public data class UavcanNodeInfo(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since the start-up of the node.
   */
  @GeneratedMavField(type = "uint32_t")
  public val uptimeSec: UInt = 0u,
  /**
   * Node name string. For example, "sapog.px4.io".
   */
  @GeneratedMavField(type = "char[80]")
  public val name: String = "",
  /**
   * Hardware major version number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val hwVersionMajor: UByte = 0u,
  /**
   * Hardware minor version number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val hwVersionMinor: UByte = 0u,
  /**
   * Hardware unique 128-bit ID.
   */
  @GeneratedMavField(type = "uint8_t[16]")
  public val hwUniqueId: List<UByte> = emptyList(),
  /**
   * Software major version number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val swVersionMajor: UByte = 0u,
  /**
   * Software minor version number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val swVersionMinor: UByte = 0u,
  /**
   * Version control system (VCS) revision identifier (e.g. git short commit hash). 0 if unknown.
   */
  @GeneratedMavField(type = "uint32_t")
  public val swVcsCommit: UInt = 0u,
) : MavMessage<UavcanNodeInfo> {
  public override val instanceCompanion: MavMessage.MavCompanion<UavcanNodeInfo> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(uptimeSec)
    outputBuffer.encodeUInt32(swVcsCommit)
    outputBuffer.encodeString(name, 80)
    outputBuffer.encodeUInt8(hwVersionMajor)
    outputBuffer.encodeUInt8(hwVersionMinor)
    outputBuffer.encodeUInt8Array(hwUniqueId, 16)
    outputBuffer.encodeUInt8(swVersionMajor)
    outputBuffer.encodeUInt8(swVersionMinor)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(uptimeSec)
    outputBuffer.encodeUInt32(swVcsCommit)
    outputBuffer.encodeString(name, 80)
    outputBuffer.encodeUInt8(hwVersionMajor)
    outputBuffer.encodeUInt8(hwVersionMinor)
    outputBuffer.encodeUInt8Array(hwUniqueId, 16)
    outputBuffer.encodeUInt8(swVersionMajor)
    outputBuffer.encodeUInt8(swVersionMinor)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavcanNodeInfo> {
    private const val SIZE_V1: Int = 116

    private const val SIZE_V2: Int = 116

    public override val id: UInt = 311u

    public override val crcExtra: Byte = 95

    public override fun deserialize(bytes: ByteArray): UavcanNodeInfo {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val uptimeSec = inputBuffer.decodeUInt32()
      val swVcsCommit = inputBuffer.decodeUInt32()
      val name = inputBuffer.decodeString(80)
      val hwVersionMajor = inputBuffer.decodeUInt8()
      val hwVersionMinor = inputBuffer.decodeUInt8()
      val hwUniqueId = inputBuffer.decodeUInt8Array(16)
      val swVersionMajor = inputBuffer.decodeUInt8()
      val swVersionMinor = inputBuffer.decodeUInt8()

      return UavcanNodeInfo(
        timeUsec = timeUsec,
        uptimeSec = uptimeSec,
        name = name,
        hwVersionMajor = hwVersionMajor,
        hwVersionMinor = hwVersionMinor,
        hwUniqueId = hwUniqueId,
        swVersionMajor = swVersionMajor,
        swVersionMinor = swVersionMinor,
        swVcsCommit = swVcsCommit,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavcanNodeInfo =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var uptimeSec: UInt = 0u

    public var name: String = ""

    public var hwVersionMajor: UByte = 0u

    public var hwVersionMinor: UByte = 0u

    public var hwUniqueId: List<UByte> = emptyList()

    public var swVersionMajor: UByte = 0u

    public var swVersionMinor: UByte = 0u

    public var swVcsCommit: UInt = 0u

    public fun build(): UavcanNodeInfo = UavcanNodeInfo(
      timeUsec = timeUsec,
      uptimeSec = uptimeSec,
      name = name,
      hwVersionMajor = hwVersionMajor,
      hwVersionMinor = hwVersionMinor,
      hwUniqueId = hwUniqueId,
      swVersionMajor = swVersionMajor,
      swVersionMinor = swVersionMinor,
      swVcsCommit = swVcsCommit,
    )
  }
}
