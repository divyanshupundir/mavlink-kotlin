package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16Array
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeInt16Array
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.collections.List

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a
 * TERRAIN_REQUEST. See terrain protocol docs: https://mavlink.io/en/services/terrain.html
 */
public data class TerrainData(
  /**
   * Latitude of SW corner of first grid
   */
  public val lat: Int = 0,
  /**
   * Longitude of SW corner of first grid
   */
  public val lon: Int = 0,
  /**
   * Grid spacing
   */
  public val gridSpacing: Int = 0,
  /**
   * bit within the terrain request mask
   */
  public val gridbit: Int = 0,
  /**
   * Terrain data MSL
   */
  public val `data`: List<Int> = emptyList(),
) : MavMessage<TerrainData> {
  public override val instanceMetadata: MavMessage.Metadata<TerrainData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUint16(gridSpacing)
    outputBuffer.encodeInt16Array(data, 32)
    outputBuffer.encodeUint8(gridbit)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 134

    private const val CRC: Int = 5

    private const val SIZE: Int = 43

    private val DESERIALIZER: MavDeserializer<TerrainData> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for TerrainData: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val gridSpacing = inputBuffer.decodeUint16()
      val data = inputBuffer.decodeInt16Array(32)
      val gridbit = inputBuffer.decodeUint8()

      TerrainData(
        lat = lat,
        lon = lon,
        gridSpacing = gridSpacing,
        gridbit = gridbit,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<TerrainData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<TerrainData> = METADATA
  }
}
