package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16Array
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16Array
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Terrain data sent from GCS. The lat/lon and grid_spacing must be the same as a lat/lon from a
 * TERRAIN_REQUEST. See terrain protocol docs: https://mavlink.io/en/services/terrain.html
 *
 * @param lat Latitude of SW corner of first grid
 * units = degE7
 * @param lon Longitude of SW corner of first grid
 * units = degE7
 * @param gridSpacing Grid spacing
 * units = m
 * @param gridbit bit within the terrain request mask
 * @param data Terrain data MSL
 * units = m
 */
@GeneratedMavMessage(
  id = 134u,
  crcExtra = -27,
)
public data class TerrainData(
  /**
   * Latitude of SW corner of first grid
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of SW corner of first grid
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * Grid spacing
   * units = m
   */
  @GeneratedMavField(type = "uint16_t")
  public val gridSpacing: UShort = 0u,
  /**
   * bit within the terrain request mask
   */
  @GeneratedMavField(type = "uint8_t")
  public val gridbit: UByte = 0u,
  /**
   * Terrain data MSL
   * units = m
   */
  @GeneratedMavField(type = "int16_t[16]")
  public val `data`: List<Short> = emptyList(),
) : MavMessage<TerrainData> {
  override val instanceCompanion: MavMessage.MavCompanion<TerrainData> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeUInt16(gridSpacing)
    encoder.encodeInt16Array(data, 32)
    encoder.encodeUInt8(gridbit)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeUInt16(gridSpacing)
    encoder.encodeInt16Array(data, 32)
    encoder.encodeUInt8(gridbit)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainData> {
    private const val SIZE_V1: Int = 43

    private const val SIZE_V2: Int = 43

    override val id: UInt = 134u

    override val crcExtra: Byte = -27

    override fun deserialize(bytes: ByteArray): TerrainData {
      val decoder = MavDataDecoder(bytes)

      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val gridSpacing = decoder.safeDecodeUInt16()
      val data = decoder.safeDecodeInt16Array(32)
      val gridbit = decoder.safeDecodeUInt8()

      return TerrainData(
        lat = lat,
        lon = lon,
        gridSpacing = gridSpacing,
        gridbit = gridbit,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TerrainData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var lat: Int = 0

    public var lon: Int = 0

    public var gridSpacing: UShort = 0u

    public var gridbit: UByte = 0u

    public var `data`: List<Short> = emptyList()

    public fun build(): TerrainData = TerrainData(
      lat = lat,
      lon = lon,
      gridSpacing = gridSpacing,
      gridbit = gridbit,
      data = data,
    )
  }
}
