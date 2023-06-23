package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeInt16Array
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeInt8Array
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt32Array
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeInt16Array
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt32Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Hardware status sent by an onboard computer.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 390u,
  crcExtra = -100,
)
public data class OnboardComputerStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since system boot.
   */
  @GeneratedMavField(type = "uint32_t")
  public val uptime: UInt = 0u,
  /**
   * Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup 1, 2:
   * Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: UByte = 0u,
  /**
   * CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is
   * unused.
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val cpuCores: List<UByte> = emptyList(),
  /**
   * Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify
   * spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX
   * implies the field is unused.
   */
  @GeneratedMavField(type = "uint8_t[10]")
  public val cpuCombined: List<UByte> = emptyList(),
  /**
   * GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies the field is
   * unused.
   */
  @GeneratedMavField(type = "uint8_t[4]")
  public val gpuCores: List<UByte> = emptyList(),
  /**
   * Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows to identify
   * spikes in load that max out the system, but only for a short amount of time. A value of UINT8_MAX
   * implies the field is unused.
   */
  @GeneratedMavField(type = "uint8_t[10]")
  public val gpuCombined: List<UByte> = emptyList(),
  /**
   * Temperature of the board. A value of INT8_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureBoard: Byte = 0,
  /**
   * Temperature of the CPU core. A value of INT8_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "int8_t[8]")
  public val temperatureCore: List<Byte> = emptyList(),
  /**
   * Fan speeds. A value of INT16_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "int16_t[4]")
  public val fanSpeed: List<Short> = emptyList(),
  /**
   * Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t")
  public val ramUsage: UInt = 0u,
  /**
   * Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t")
  public val ramTotal: UInt = 0u,
  /**
   * Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card (removable). A
   * value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t[4]")
  public val storageType: List<UInt> = emptyList(),
  /**
   * Amount of used storage space on the component system. A value of UINT32_MAX implies the field
   * is unused.
   */
  @GeneratedMavField(type = "uint32_t[4]")
  public val storageUsage: List<UInt> = emptyList(),
  /**
   * Total amount of storage space on the component system. A value of UINT32_MAX implies the field
   * is unused.
   */
  @GeneratedMavField(type = "uint32_t[4]")
  public val storageTotal: List<UInt> = emptyList(),
  /**
   * Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point proprietary,
   * 40-49: Mesh proprietary
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkType: List<UInt> = emptyList(),
  /**
   * Network traffic from the component system. A value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkTxRate: List<UInt> = emptyList(),
  /**
   * Network traffic to the component system. A value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkRxRate: List<UInt> = emptyList(),
  /**
   * Network capacity from the component system. A value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkTxMax: List<UInt> = emptyList(),
  /**
   * Network capacity to the component system. A value of UINT32_MAX implies the field is unused.
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkRxMax: List<UInt> = emptyList(),
) : MavMessage<OnboardComputerStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<OnboardComputerStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(uptime)
    output.encodeUInt32(ramUsage)
    output.encodeUInt32(ramTotal)
    output.encodeUInt32Array(storageType, 16)
    output.encodeUInt32Array(storageUsage, 16)
    output.encodeUInt32Array(storageTotal, 16)
    output.encodeUInt32Array(linkType, 24)
    output.encodeUInt32Array(linkTxRate, 24)
    output.encodeUInt32Array(linkRxRate, 24)
    output.encodeUInt32Array(linkTxMax, 24)
    output.encodeUInt32Array(linkRxMax, 24)
    output.encodeInt16Array(fanSpeed, 8)
    output.encodeUInt8(type)
    output.encodeUInt8Array(cpuCores, 8)
    output.encodeUInt8Array(cpuCombined, 10)
    output.encodeUInt8Array(gpuCores, 4)
    output.encodeUInt8Array(gpuCombined, 10)
    output.encodeInt8(temperatureBoard)
    output.encodeInt8Array(temperatureCore, 8)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(uptime)
    output.encodeUInt32(ramUsage)
    output.encodeUInt32(ramTotal)
    output.encodeUInt32Array(storageType, 16)
    output.encodeUInt32Array(storageUsage, 16)
    output.encodeUInt32Array(storageTotal, 16)
    output.encodeUInt32Array(linkType, 24)
    output.encodeUInt32Array(linkTxRate, 24)
    output.encodeUInt32Array(linkRxRate, 24)
    output.encodeUInt32Array(linkTxMax, 24)
    output.encodeUInt32Array(linkRxMax, 24)
    output.encodeInt16Array(fanSpeed, 8)
    output.encodeUInt8(type)
    output.encodeUInt8Array(cpuCores, 8)
    output.encodeUInt8Array(cpuCombined, 10)
    output.encodeUInt8Array(gpuCores, 4)
    output.encodeUInt8Array(gpuCombined, 10)
    output.encodeInt8(temperatureBoard)
    output.encodeInt8Array(temperatureCore, 8)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OnboardComputerStatus> {
    private const val SIZE_V1: Int = 238

    private const val SIZE_V2: Int = 238

    public override val id: UInt = 390u

    public override val crcExtra: Byte = -100

    public override fun deserialize(source: BufferedSource): OnboardComputerStatus {
      val timeUsec = source.decodeUInt64()
      val uptime = source.decodeUInt32()
      val ramUsage = source.decodeUInt32()
      val ramTotal = source.decodeUInt32()
      val storageType = source.decodeUInt32Array(16)
      val storageUsage = source.decodeUInt32Array(16)
      val storageTotal = source.decodeUInt32Array(16)
      val linkType = source.decodeUInt32Array(24)
      val linkTxRate = source.decodeUInt32Array(24)
      val linkRxRate = source.decodeUInt32Array(24)
      val linkTxMax = source.decodeUInt32Array(24)
      val linkRxMax = source.decodeUInt32Array(24)
      val fanSpeed = source.decodeInt16Array(8)
      val type = source.decodeUInt8()
      val cpuCores = source.decodeUInt8Array(8)
      val cpuCombined = source.decodeUInt8Array(10)
      val gpuCores = source.decodeUInt8Array(4)
      val gpuCombined = source.decodeUInt8Array(10)
      val temperatureBoard = source.decodeInt8()
      val temperatureCore = source.decodeInt8Array(8)

      return OnboardComputerStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): OnboardComputerStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var uptime: UInt = 0u

    public var type: UByte = 0u

    public var cpuCores: List<UByte> = emptyList()

    public var cpuCombined: List<UByte> = emptyList()

    public var gpuCores: List<UByte> = emptyList()

    public var gpuCombined: List<UByte> = emptyList()

    public var temperatureBoard: Byte = 0

    public var temperatureCore: List<Byte> = emptyList()

    public var fanSpeed: List<Short> = emptyList()

    public var ramUsage: UInt = 0u

    public var ramTotal: UInt = 0u

    public var storageType: List<UInt> = emptyList()

    public var storageUsage: List<UInt> = emptyList()

    public var storageTotal: List<UInt> = emptyList()

    public var linkType: List<UInt> = emptyList()

    public var linkTxRate: List<UInt> = emptyList()

    public var linkRxRate: List<UInt> = emptyList()

    public var linkTxMax: List<UInt> = emptyList()

    public var linkRxMax: List<UInt> = emptyList()

    public fun build(): OnboardComputerStatus = OnboardComputerStatus(
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
}
