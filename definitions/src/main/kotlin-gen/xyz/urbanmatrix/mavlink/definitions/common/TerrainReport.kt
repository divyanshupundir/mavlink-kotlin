package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16

/**
 * Streamed from drone to report progress of terrain map download (initiated by TERRAIN_REQUEST), or
 * sent as a response to a TERRAIN_CHECK request. See terrain protocol docs:
 * https://mavlink.io/en/services/terrain.html
 */
@GeneratedMavMessage(
  id = 136,
  crc = 1,
)
public data class TerrainReport(
  /**
   * Latitude
   */
  public val lat: Int = 0,
  /**
   * Longitude
   */
  public val lon: Int = 0,
  /**
   * grid spacing (zero if terrain at this location unavailable)
   */
  public val spacing: Int = 0,
  /**
   * Terrain height MSL
   */
  public val terrainHeight: Float = 0F,
  /**
   * Current vehicle height above lat/lon terrain height
   */
  public val currentHeight: Float = 0F,
  /**
   * Number of 4x4 terrain blocks waiting to be received or read from disk
   */
  public val pending: Int = 0,
  /**
   * Number of 4x4 terrain blocks in memory
   */
  public val loaded: Int = 0,
) : MavMessage<TerrainReport> {
  public override val instanceMetadata: MavMessage.Metadata<TerrainReport> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeFloat(terrainHeight)
    outputBuffer.encodeFloat(currentHeight)
    outputBuffer.encodeUint16(spacing)
    outputBuffer.encodeUint16(pending)
    outputBuffer.encodeUint16(loaded)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 136

    private const val CRC: Int = 1

    private const val SIZE: Int = 22

    private val DESERIALIZER: MavDeserializer<TerrainReport> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val terrainHeight = inputBuffer.decodeFloat()
      val currentHeight = inputBuffer.decodeFloat()
      val spacing = inputBuffer.decodeUint16()
      val pending = inputBuffer.decodeUint16()
      val loaded = inputBuffer.decodeUint16()

      TerrainReport(
        lat = lat,
        lon = lon,
        spacing = spacing,
        terrainHeight = terrainHeight,
        currentHeight = currentHeight,
        pending = pending,
        loaded = loaded,
      )
    }


    private val METADATA: MavMessage.Metadata<TerrainReport> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<TerrainReport> = METADATA
  }
}
