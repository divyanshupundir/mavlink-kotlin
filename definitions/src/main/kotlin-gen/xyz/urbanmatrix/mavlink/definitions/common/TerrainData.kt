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
import xyz.urbanmatrix.mavlink.serialization.decodeInt16Array
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16Array
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a
 * TERRAIN_REQUEST. See terrain protocol docs: https://mavlink.io/en/services/terrain.html
 */
@GeneratedMavMessage(
  id = 134,
  crc = 229,
)
public data class TerrainData(
  /**
   * Latitude of SW corner of first grid
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of SW corner of first grid
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Grid spacing
   */
  @GeneratedMavField(type = "uint16_t")
  public val gridSpacing: Int = 0,
  /**
   * bit within the terrain request mask
   */
  @GeneratedMavField(type = "uint8_t")
  public val gridbit: Int = 0,
  /**
   * Terrain data MSL
   */
  @GeneratedMavField(type = "int16_t[16]")
  public val `data`: List<Int> = emptyList(),
) : MavMessage<TerrainData> {
  public override val instanceMetadata: MavMessage.Metadata<TerrainData> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUint16(gridSpacing)
    outputBuffer.encodeInt16Array(data, 32)
    outputBuffer.encodeUint8(gridbit)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUint16(gridSpacing)
    outputBuffer.encodeInt16Array(data, 32)
    outputBuffer.encodeUint8(gridbit)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 134

    private const val CRC: Int = 229

    private const val SIZE: Int = 43

    private val DESERIALIZER: MavDeserializer<TerrainData> = MavDeserializer { bytes ->
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var lat: Int = 0

    public var lon: Int = 0

    public var gridSpacing: Int = 0

    public var gridbit: Int = 0

    public var `data`: List<Int> = emptyList()

    public fun build(): TerrainData = TerrainData(
      lat = lat,
      lon = lon,
      gridSpacing = gridSpacing,
      gridbit = gridbit,
      data = data,
    )
  }
}
