package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeInt32

/**
 * Request that the vehicle report terrain height at the given location (expected response is a
 * TERRAIN_REPORT). Used by GCS to check if vehicle has all terrain data needed for a mission.
 */
@GeneratedMavMessage(
  id = 135,
  crc = 203,
)
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
