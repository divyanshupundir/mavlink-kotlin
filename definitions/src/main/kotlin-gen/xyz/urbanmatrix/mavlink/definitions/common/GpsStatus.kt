package xyz.urbanmatrix.mavlink.definitions.common

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
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * The positioning status, as reported by GPS. This message is intended to display status
 * information about each satellite visible to the receiver. See message GLOBAL_POSITION_INT for the
 * global position estimate. This message can contain information for up to 20 satellites.
 */
@GeneratedMavMessage(
  id = 25,
  crc = 23,
)
public data class GpsStatus(
  /**
   * Number of satellites visible
   */
  @GeneratedMavField(type = "uint8_t")
  public val satellitesVisible: Int = 0,
  /**
   * Global satellite ID
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satellitePrn: List<Int> = emptyList(),
  /**
   * 0: Satellite not used, 1: used for localization
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteUsed: List<Int> = emptyList(),
  /**
   * Elevation (0: right on top of receiver, 90: on the horizon) of satellite
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteElevation: List<Int> = emptyList(),
  /**
   * Direction of satellite, 0: 0 deg, 255: 360 deg.
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteAzimuth: List<Int> = emptyList(),
  /**
   * Signal to noise ratio of satellite
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val satelliteSnr: List<Int> = emptyList(),
) : MavMessage<GpsStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GpsStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeUint8Array(satellitePrn, 20)
    outputBuffer.encodeUint8Array(satelliteUsed, 20)
    outputBuffer.encodeUint8Array(satelliteElevation, 20)
    outputBuffer.encodeUint8Array(satelliteAzimuth, 20)
    outputBuffer.encodeUint8Array(satelliteSnr, 20)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeUint8Array(satellitePrn, 20)
    outputBuffer.encodeUint8Array(satelliteUsed, 20)
    outputBuffer.encodeUint8Array(satelliteElevation, 20)
    outputBuffer.encodeUint8Array(satelliteAzimuth, 20)
    outputBuffer.encodeUint8Array(satelliteSnr, 20)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 25

    private const val CRC: Int = 23

    private const val SIZE_V1: Int = 101

    private const val SIZE_V2: Int = 101

    private val DESERIALIZER: MavDeserializer<GpsStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val satellitesVisible = inputBuffer.decodeUint8()
      val satellitePrn = inputBuffer.decodeUint8Array(20)
      val satelliteUsed = inputBuffer.decodeUint8Array(20)
      val satelliteElevation = inputBuffer.decodeUint8Array(20)
      val satelliteAzimuth = inputBuffer.decodeUint8Array(20)
      val satelliteSnr = inputBuffer.decodeUint8Array(20)

      GpsStatus(
        satellitesVisible = satellitesVisible,
        satellitePrn = satellitePrn,
        satelliteUsed = satelliteUsed,
        satelliteElevation = satelliteElevation,
        satelliteAzimuth = satelliteAzimuth,
        satelliteSnr = satelliteSnr,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var satellitesVisible: Int = 0

    public var satellitePrn: List<Int> = emptyList()

    public var satelliteUsed: List<Int> = emptyList()

    public var satelliteElevation: List<Int> = emptyList()

    public var satelliteAzimuth: List<Int> = emptyList()

    public var satelliteSnr: List<Int> = emptyList()

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
