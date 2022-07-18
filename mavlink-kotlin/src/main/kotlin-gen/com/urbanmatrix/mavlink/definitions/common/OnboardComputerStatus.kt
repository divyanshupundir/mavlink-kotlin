package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16Array
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.decodeInt8Array
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint32Array
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeInt16Array
import com.urbanmatrix.mavlink.serialization.encodeInt8
import com.urbanmatrix.mavlink.serialization.encodeInt8Array
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint32Array
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * Hardware status sent by an onboard computer.
 */
public data class OnboardComputerStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Time since system boot.
   */
  public val uptime: Long = 0L,
  /**
   * Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2:
   * Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers.
   */
  public val type: Int = 0,
  /**
   * CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is
   * unused.
   */
  public val cpuCores: List<Int> = emptyList(),
  /**
   * Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify
   * spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX
   * implies the field is unused.
   */
  public val cpuCombined: List<Int> = emptyList(),
  /**
   * GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is
   * unused.
   */
  public val gpuCores: List<Int> = emptyList(),
  /**
   * Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify
   * spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX
   * implies the field is unused.
   */
  public val gpuCombined: List<Int> = emptyList(),
  /**
   * Temperature of the board. A value of INT8_MAX implies the field is unused.
   */
  public val temperatureBoard: Int = 0,
  /**
   * Temperature of the CPU core. A value of INT8_MAX implies the field is unused.
   */
  public val temperatureCore: List<Int> = emptyList(),
  /**
   * Fan speeds. A value of INT16_MAX implies the field is unused.
   */
  public val fanSpeed: List<Int> = emptyList(),
  /**
   * Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused.
   */
  public val ramUsage: Long = 0L,
  /**
   * Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused.
   */
  public val ramTotal: Long = 0L,
  /**
   * Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A
   * value of UINT32_MAX implies the field is unused.
   */
  public val storageType: List<Long> = emptyList(),
  /**
   * Amount of used storage space on the component system. A value of UINT32_MAX implies the field
   * is unused.
   */
  public val storageUsage: List<Long> = emptyList(),
  /**
   * Total amount of storage space on the component system. A value of UINT32_MAX implies the field
   * is unused.
   */
  public val storageTotal: List<Long> = emptyList(),
  /**
   * Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary,
   * 40-49: Mesh proprietary
   */
  public val linkType: List<Long> = emptyList(),
  /**
   * Network traffic from the component system. A value of UINT32_MAX implies the field is unused.
   */
  public val linkTxRate: List<Long> = emptyList(),
  /**
   * Network traffic to the component system. A value of UINT32_MAX implies the field is unused.
   */
  public val linkRxRate: List<Long> = emptyList(),
  /**
   * Network capacity from the component system. A value of UINT32_MAX implies the field is unused.
   */
  public val linkTxMax: List<Long> = emptyList(),
  /**
   * Network capacity to the component system. A value of UINT32_MAX implies the field is unused.
   */
  public val linkRxMax: List<Long> = emptyList(),
) : MavMessage<OnboardComputerStatus> {
  public override val instanceMetadata: MavMessage.Metadata<OnboardComputerStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint32(uptime)
    outputBuffer.encodeUint32(ramUsage)
    outputBuffer.encodeUint32(ramTotal)
    outputBuffer.encodeUint32Array(storageType, 16)
    outputBuffer.encodeUint32Array(storageUsage, 16)
    outputBuffer.encodeUint32Array(storageTotal, 16)
    outputBuffer.encodeUint32Array(linkType, 24)
    outputBuffer.encodeUint32Array(linkTxRate, 24)
    outputBuffer.encodeUint32Array(linkRxRate, 24)
    outputBuffer.encodeUint32Array(linkTxMax, 24)
    outputBuffer.encodeUint32Array(linkRxMax, 24)
    outputBuffer.encodeInt16Array(fanSpeed, 8)
    outputBuffer.encodeUint8(type)
    outputBuffer.encodeUint8Array(cpuCores, 8)
    outputBuffer.encodeUint8Array(cpuCombined, 10)
    outputBuffer.encodeUint8Array(gpuCores, 4)
    outputBuffer.encodeUint8Array(gpuCombined, 10)
    outputBuffer.encodeInt8(temperatureBoard)
    outputBuffer.encodeInt8Array(temperatureCore, 8)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 390

    private const val CRC: Int = 234

    private const val SIZE: Int = 238

    private val DESERIALIZER: MavDeserializer<OnboardComputerStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val uptime = inputBuffer.decodeUint32()
      val ramUsage = inputBuffer.decodeUint32()
      val ramTotal = inputBuffer.decodeUint32()
      val storageType = inputBuffer.decodeUint32Array(16)
      val storageUsage = inputBuffer.decodeUint32Array(16)
      val storageTotal = inputBuffer.decodeUint32Array(16)
      val linkType = inputBuffer.decodeUint32Array(24)
      val linkTxRate = inputBuffer.decodeUint32Array(24)
      val linkRxRate = inputBuffer.decodeUint32Array(24)
      val linkTxMax = inputBuffer.decodeUint32Array(24)
      val linkRxMax = inputBuffer.decodeUint32Array(24)
      val fanSpeed = inputBuffer.decodeInt16Array(8)
      val type = inputBuffer.decodeUint8()
      val cpuCores = inputBuffer.decodeUint8Array(8)
      val cpuCombined = inputBuffer.decodeUint8Array(10)
      val gpuCores = inputBuffer.decodeUint8Array(4)
      val gpuCombined = inputBuffer.decodeUint8Array(10)
      val temperatureBoard = inputBuffer.decodeInt8()
      val temperatureCore = inputBuffer.decodeInt8Array(8)

      OnboardComputerStatus(
        timeUsec = timeUsec,
        uptime = uptime,
        type = type,
        cpuCores = cpuCores,
        cpuCombined = cpuCombined,
        gpuCores = gpuCores,
        gpuCombined = gpuCombined,
        temperatureBoard = temperatureBoard,
        temperatureCore = temperatureCore,
        fanSpeed = fanSpeed,
        ramUsage = ramUsage,
        ramTotal = ramTotal,
        storageType = storageType,
        storageUsage = storageUsage,
        storageTotal = storageTotal,
        linkType = linkType,
        linkTxRate = linkTxRate,
        linkRxRate = linkRxRate,
        linkTxMax = linkTxMax,
        linkRxMax = linkRxMax,
      )
    }


    private val METADATA: MavMessage.Metadata<OnboardComputerStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OnboardComputerStatus> = METADATA
  }
}
