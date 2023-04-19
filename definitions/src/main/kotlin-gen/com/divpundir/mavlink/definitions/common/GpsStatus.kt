package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
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
 * The positioning status, as reported by GPS. This message is intended to display status
 * information about each satellite visible to the receiver. See message GLOBAL_POSITION_INT for the
 * global position estimate. This message can contain information for up to 20 satellites.
 */
@GeneratedMavMessage(
  id = 25u,
  crcExtra = 23,
)
public data class GpsStatus(
  /**
   * Number of satellites visible
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: UByte = 0u,
  /**
   * Global satellite ID
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satellitePrn: List<UByte> = emptyList(),
  /**
   * 0: Satellite not used, 1: used for localization
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteUsed: List<UByte> = emptyList(),
  /**
   * Elevation (0: right on top of receiver, 90: on the horizon) of satellite
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteElevation: List<UByte> = emptyList(),
  /**
   * Direction of satellite, 0: 0 deg, 255: 360 deg.
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteAzimuth: List<UByte> = emptyList(),
  /**
   * Signal to noise ratio of satellite
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteSnr: List<UByte> = emptyList(),
) : MavMessage<GpsStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GpsStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(satellitesVisible)
    outputBuffer.encodeUInt8Array(satellitePrn, 20)
    outputBuffer.encodeUInt8Array(satelliteUsed, 20)
    outputBuffer.encodeUInt8Array(satelliteElevation, 20)
    outputBuffer.encodeUInt8Array(satelliteAzimuth, 20)
    outputBuffer.encodeUInt8Array(satelliteSnr, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(satellitesVisible)
    outputBuffer.encodeUInt8Array(satellitePrn, 20)
    outputBuffer.encodeUInt8Array(satelliteUsed, 20)
    outputBuffer.encodeUInt8Array(satelliteElevation, 20)
    outputBuffer.encodeUInt8Array(satelliteAzimuth, 20)
    outputBuffer.encodeUInt8Array(satelliteSnr, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 25u

    private const val CRC_EXTRA: Byte = 23

    private const val SIZE_V1: Int = 101

    private const val SIZE_V2: Int = 101

    private val DESERIALIZER: MavDeserializer<GpsStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val satellitesVisible = inputBuffer.decodeUInt8()
      val satellitePrn = inputBuffer.decodeUInt8Array(20)
      val satelliteUsed = inputBuffer.decodeUInt8Array(20)
      val satelliteElevation = inputBuffer.decodeUInt8Array(20)
      val satelliteAzimuth = inputBuffer.decodeUInt8Array(20)
      val satelliteSnr = inputBuffer.decodeUInt8Array(20)

      GpsStatus(
        satellitesVisible = satellitesVisible,
        satellitePrn = satellitePrn,
        satelliteUsed = satelliteUsed,
        satelliteElevation = satelliteElevation,
        satelliteAzimuth = satelliteAzimuth,
        satelliteSnr = satelliteSnr,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var satellitesVisible: UByte = 0u

    public var satellitePrn: List<UByte> = emptyList()

    public var satelliteUsed: List<UByte> = emptyList()

    public var satelliteElevation: List<UByte> = emptyList()

    public var satelliteAzimuth: List<UByte> = emptyList()

    public var satelliteSnr: List<UByte> = emptyList()

    public fun build(): GpsStatus = GpsStatus(
      satellitesVisible = satellitesVisible,
      satellitePrn = satellitePrn,
      satelliteUsed = satelliteUsed,
      satelliteElevation = satelliteElevation,
      satelliteAzimuth = satelliteAzimuth,
      satelliteSnr = satelliteSnr,
    )
  }
}
