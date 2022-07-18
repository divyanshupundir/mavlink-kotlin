package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * General information describing a particular UAVCAN node. Please refer to the definition of the
 * UAVCAN service "uavcan.protocol.GetNodeInfo" for the background information. This message should be
 * emitted by the system whenever a new node appears online, or an existing node reboots. Additionally,
 * it can be emitted upon request from the other end of the MAVLink channel (see
 * MAV_CMD_UAVCAN_GET_NODE_INFO). It is also not prohibited to emit this message unconditionally at a
 * low frequency. The UAVCAN specification is available at http://uavcan.org.
 */
public data class UavcanNodeInfo(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Time since the start-up of the node.
   */
  public val uptimeSec: Long = 0L,
  /**
   * Node name string. For example, "sapog.px4.io".
   */
  public val name: String = "",
  /**
   * Hardware major version number.
   */
  public val hwVersionMajor: Int = 0,
  /**
   * Hardware minor version number.
   */
  public val hwVersionMinor: Int = 0,
  /**
   * Hardware unique 128-bit ID.
   */
  public val hwUniqueId: List<Int> = emptyList(),
  /**
   * Software major version number.
   */
  public val swVersionMajor: Int = 0,
  /**
   * Software minor version number.
   */
  public val swVersionMinor: Int = 0,
  /**
   * Version control system (VCS) revision identifier (e.g. git short commit hash). 0 if unknown.
   */
  public val swVcsCommit: Long = 0L,
) : MavMessage<UavcanNodeInfo> {
  public override val instanceMetadata: MavMessage.Metadata<UavcanNodeInfo> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(uptimeSec)
    outputBuffer.encodeUint32(swVcsCommit)
    outputBuffer.encodeString(name, 80)
    outputBuffer.encodeUint8(hwVersionMajor)
    outputBuffer.encodeUint8(hwVersionMinor)
    outputBuffer.encodeUint8Array(hwUniqueId, 16)
    outputBuffer.encodeUint8(swVersionMajor)
    outputBuffer.encodeUint8(swVersionMinor)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 311

    private const val CRC: Int = 95

    private const val SIZE: Int = 116

    private val DESERIALIZER: MavDeserializer<UavcanNodeInfo> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val uptimeSec = inputBuffer.decodeUint32()
      val swVcsCommit = inputBuffer.decodeUint32()
      val name = inputBuffer.decodeString(80)
      val hwVersionMajor = inputBuffer.decodeUint8()
      val hwVersionMinor = inputBuffer.decodeUint8()
      val hwUniqueId = inputBuffer.decodeUint8Array(16)
      val swVersionMajor = inputBuffer.decodeUint8()
      val swVersionMinor = inputBuffer.decodeUint8()

      UavcanNodeInfo(
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


    private val METADATA: MavMessage.Metadata<UavcanNodeInfo> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavcanNodeInfo> = METADATA
  }
}
