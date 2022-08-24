package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

/**
 * Request for terrain data and terrain status. See terrain protocol docs:
 * https://mavlink.io/en/services/terrain.html
 */
@GeneratedMavMessage(
  id = 133,
  crc = 6,
)
public data class TerrainRequest(
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
   * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)
   */
  public val mask: BigInteger = BigInteger.ZERO,
) : MavMessage<TerrainRequest> {
  public override val instanceMetadata: MavMessage.Metadata<TerrainRequest> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(mask)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUint16(gridSpacing)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 133

    private const val CRC: Int = 6

    private const val SIZE: Int = 18

    private val DESERIALIZER: MavDeserializer<TerrainRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mask = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val gridSpacing = inputBuffer.decodeUint16()

      TerrainRequest(
        lat = lat,
        lon = lon,
        gridSpacing = gridSpacing,
        mask = mask,
      )
    }


    private val METADATA: MavMessage.Metadata<TerrainRequest> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<TerrainRequest> = METADATA
  }
}
