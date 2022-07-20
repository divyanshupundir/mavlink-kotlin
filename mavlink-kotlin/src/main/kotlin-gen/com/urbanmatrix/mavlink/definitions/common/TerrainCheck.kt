package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.encodeInt32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Request that the vehicle report terrain height at the given location (expected response is a
 * TERRAIN_REPORT). Used by GCS to check if vehicle has all terrain data needed for a mission.
 */
public data class TerrainCheck(
  /**
   * Latitude
   */
  public val lat: Int = 0,
  /**
   * Longitude
   */
  public val lon: Int = 0,
) : MavMessage<TerrainCheck> {
  public override val instanceMetadata: MavMessage.Metadata<TerrainCheck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 135

    private const val CRC: Int = 203

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<TerrainCheck> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()

      TerrainCheck(
        lat = lat,
        lon = lon,
      )
    }


    private val METADATA: MavMessage.Metadata<TerrainCheck> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<TerrainCheck> = METADATA
  }
}
