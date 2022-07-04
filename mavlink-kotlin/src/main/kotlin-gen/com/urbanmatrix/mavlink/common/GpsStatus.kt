package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * The positioning status, as reported by GPS. This message is intended to display status
 * information about each satellite visible to the receiver. See message GLOBAL_POSITION_INT for the
 * global position estimate. This message can contain information for up to 20 satellites.
 */
public data class GpsStatus(
  /**
   * Number of satellites visible
   */
  public val satellitesVisible: Int = 0,
  /**
   * Global satellite ID
   */
  public val satellitePrn: List<Int> = emptyList(),
  /**
   * 0: Satellite not used, 1: used for localization
   */
  public val satelliteUsed: List<Int> = emptyList(),
  /**
   * Elevation (0: right on top of receiver, 90: on the horizon) of satellite
   */
  public val satelliteElevation: List<Int> = emptyList(),
  /**
   * Direction of satellite, 0: 0 deg, 255: 360 deg.
   */
  public val satelliteAzimuth: List<Int> = emptyList(),
  /**
   * Signal to noise ratio of satellite
   */
  public val satelliteSnr: List<Int> = emptyList(),
) : MavMessage<GpsStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GpsStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(satellitesVisible)
    outputBuffer.encodeUint8Array(satellitePrn, 20)
    outputBuffer.encodeUint8Array(satelliteUsed, 20)
    outputBuffer.encodeUint8Array(satelliteElevation, 20)
    outputBuffer.encodeUint8Array(satelliteAzimuth, 20)
    outputBuffer.encodeUint8Array(satelliteSnr, 20)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 25

    private const val CRC: Int = 193

    private const val SIZE: Int = 101

    private val DESERIALIZER: MavDeserializer<GpsStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for GpsStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

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
  }
}
