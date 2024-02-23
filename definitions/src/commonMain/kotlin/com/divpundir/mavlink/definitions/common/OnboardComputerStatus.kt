package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16Array
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeInt8Array
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt32Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeInt16Array
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32Array
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Hardware status sent by an onboard computer.
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param uptime Time since system boot.
 * units = ms
 * @param type Type of the onboard computer: 0: Mission computer primary, 1: Mission computer backup
 * 1, 2: Mission computer backup 2, 3: Compute node, 4-5: Compute spares, 6-9: Payload computers.
 * @param cpuCores CPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies
 * the field is unused.
 * @param cpuCombined Combined CPU usage as the last 10 slices of 100 MS (a histogram). This allows
 * to identify spikes in load that max out the system, but only for a short amount of time. A value of
 * UINT8_MAX implies the field is unused.
 * @param gpuCores GPU usage on the component in percent (100 - idle). A value of UINT8_MAX implies
 * the field is unused.
 * @param gpuCombined Combined GPU usage as the last 10 slices of 100 MS (a histogram). This allows
 * to identify spikes in load that max out the system, but only for a short amount of time. A value of
 * UINT8_MAX implies the field is unused.
 * @param temperatureBoard Temperature of the board. A value of INT8_MAX implies the field is
 * unused.
 * units = degC
 * @param temperatureCore Temperature of the CPU core. A value of INT8_MAX implies the field is
 * unused.
 * units = degC
 * @param fanSpeed Fan speeds. A value of INT16_MAX implies the field is unused.
 * units = rpm
 * @param ramUsage Amount of used RAM on the component system. A value of UINT32_MAX implies the
 * field is unused.
 * units = MiB
 * @param ramTotal Total amount of RAM on the component system. A value of UINT32_MAX implies the
 * field is unused.
 * units = MiB
 * @param storageType Storage type: 0: HDD, 1: SSD, 2: EMMC, 3: SD card (non-removable), 4: SD card
 * (removable). A value of UINT32_MAX implies the field is unused.
 * @param storageUsage Amount of used storage space on the component system. A value of UINT32_MAX
 * implies the field is unused.
 * units = MiB
 * @param storageTotal Total amount of storage space on the component system. A value of UINT32_MAX
 * implies the field is unused.
 * units = MiB
 * @param linkType Link type: 0-9: UART, 10-19: Wired network, 20-29: Wifi, 30-39: Point-to-point
 * proprietary, 40-49: Mesh proprietary
 * @param linkTxRate Network traffic from the component system. A value of UINT32_MAX implies the
 * field is unused.
 * units = KiB/s
 * @param linkRxRate Network traffic to the component system. A value of UINT32_MAX implies the
 * field is unused.
 * units = KiB/s
 * @param linkTxMax Network capacity from the component system. A value of UINT32_MAX implies the
 * field is unused.
 * units = KiB/s
 * @param linkRxMax Network capacity to the component system. A value of UINT32_MAX implies the
 * field is unused.
 * units = KiB/s
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
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since system boot.
   * units = ms
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
   * units = degC
   */
  @GeneratedMavField(type = "int8_t")
  public val temperatureBoard: Byte = 0,
  /**
   * Temperature of the CPU core. A value of INT8_MAX implies the field is unused.
   * units = degC
   */
  @GeneratedMavField(type = "int8_t[8]")
  public val temperatureCore: List<Byte> = emptyList(),
  /**
   * Fan speeds. A value of INT16_MAX implies the field is unused.
   * units = rpm
   */
  @GeneratedMavField(type = "int16_t[4]")
  public val fanSpeed: List<Short> = emptyList(),
  /**
   * Amount of used RAM on the component system. A value of UINT32_MAX implies the field is unused.
   * units = MiB
   */
  @GeneratedMavField(type = "uint32_t")
  public val ramUsage: UInt = 0u,
  /**
   * Total amount of RAM on the component system. A value of UINT32_MAX implies the field is unused.
   * units = MiB
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
   * units = MiB
   */
  @GeneratedMavField(type = "uint32_t[4]")
  public val storageUsage: List<UInt> = emptyList(),
  /**
   * Total amount of storage space on the component system. A value of UINT32_MAX implies the field
   * is unused.
   * units = MiB
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
   * units = KiB/s
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkTxRate: List<UInt> = emptyList(),
  /**
   * Network traffic to the component system. A value of UINT32_MAX implies the field is unused.
   * units = KiB/s
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkRxRate: List<UInt> = emptyList(),
  /**
   * Network capacity from the component system. A value of UINT32_MAX implies the field is unused.
   * units = KiB/s
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkTxMax: List<UInt> = emptyList(),
  /**
   * Network capacity to the component system. A value of UINT32_MAX implies the field is unused.
   * units = KiB/s
   */
  @GeneratedMavField(type = "uint32_t[6]")
  public val linkRxMax: List<UInt> = emptyList(),
) : MavMessage<OnboardComputerStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<OnboardComputerStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(uptime)
    encoder.encodeUInt32(ramUsage)
    encoder.encodeUInt32(ramTotal)
    encoder.encodeUInt32Array(storageType, 16)
    encoder.encodeUInt32Array(storageUsage, 16)
    encoder.encodeUInt32Array(storageTotal, 16)
    encoder.encodeUInt32Array(linkType, 24)
    encoder.encodeUInt32Array(linkTxRate, 24)
    encoder.encodeUInt32Array(linkRxRate, 24)
    encoder.encodeUInt32Array(linkTxMax, 24)
    encoder.encodeUInt32Array(linkRxMax, 24)
    encoder.encodeInt16Array(fanSpeed, 8)
    encoder.encodeUInt8(type)
    encoder.encodeUInt8Array(cpuCores, 8)
    encoder.encodeUInt8Array(cpuCombined, 10)
    encoder.encodeUInt8Array(gpuCores, 4)
    encoder.encodeUInt8Array(gpuCombined, 10)
    encoder.encodeInt8(temperatureBoard)
    encoder.encodeInt8Array(temperatureCore, 8)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(uptime)
    encoder.encodeUInt32(ramUsage)
    encoder.encodeUInt32(ramTotal)
    encoder.encodeUInt32Array(storageType, 16)
    encoder.encodeUInt32Array(storageUsage, 16)
    encoder.encodeUInt32Array(storageTotal, 16)
    encoder.encodeUInt32Array(linkType, 24)
    encoder.encodeUInt32Array(linkTxRate, 24)
    encoder.encodeUInt32Array(linkRxRate, 24)
    encoder.encodeUInt32Array(linkTxMax, 24)
    encoder.encodeUInt32Array(linkRxMax, 24)
    encoder.encodeInt16Array(fanSpeed, 8)
    encoder.encodeUInt8(type)
    encoder.encodeUInt8Array(cpuCores, 8)
    encoder.encodeUInt8Array(cpuCombined, 10)
    encoder.encodeUInt8Array(gpuCores, 4)
    encoder.encodeUInt8Array(gpuCombined, 10)
    encoder.encodeInt8(temperatureBoard)
    encoder.encodeInt8Array(temperatureCore, 8)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OnboardComputerStatus> {
    private const val SIZE_V1: Int = 238

    private const val SIZE_V2: Int = 238

    override val id: UInt = 390u

    override val crcExtra: Byte = -100

    override fun deserialize(bytes: ByteArray): OnboardComputerStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val uptime = decoder.safeDecodeUInt32()
      val ramUsage = decoder.safeDecodeUInt32()
      val ramTotal = decoder.safeDecodeUInt32()
      val storageType = decoder.safeDecodeUInt32Array(16)
      val storageUsage = decoder.safeDecodeUInt32Array(16)
      val storageTotal = decoder.safeDecodeUInt32Array(16)
      val linkType = decoder.safeDecodeUInt32Array(24)
      val linkTxRate = decoder.safeDecodeUInt32Array(24)
      val linkRxRate = decoder.safeDecodeUInt32Array(24)
      val linkTxMax = decoder.safeDecodeUInt32Array(24)
      val linkRxMax = decoder.safeDecodeUInt32Array(24)
      val fanSpeed = decoder.safeDecodeInt16Array(8)
      val type = decoder.safeDecodeUInt8()
      val cpuCores = decoder.safeDecodeUInt8Array(8)
      val cpuCombined = decoder.safeDecodeUInt8Array(10)
      val gpuCores = decoder.safeDecodeUInt8Array(4)
      val gpuCombined = decoder.safeDecodeUInt8Array(10)
      val temperatureBoard = decoder.safeDecodeInt8()
      val temperatureCore = decoder.safeDecodeInt8Array(8)

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
