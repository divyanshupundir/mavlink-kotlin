package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Request for terrain data and terrain status. See terrain protocol docs:
 * https://mavlink.io/en/services/terrain.html
 *
 * @param lat Latitude of SW corner of first grid
 * units = degE7
 * @param lon Longitude of SW corner of first grid
 * units = degE7
 * @param gridSpacing Grid spacing
 * units = m
 * @param mask Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)
 */
@GeneratedMavMessage(
  id = 133u,
  crcExtra = 6,
)
public data class TerrainRequest(
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
   * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)
   */
  @GeneratedMavField(type = "uint64_t")
  public val mask: ULong = 0uL,
) : MavMessage<TerrainRequest> {
  override val instanceCompanion: MavMessage.MavCompanion<TerrainRequest> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(mask)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeUInt16(gridSpacing)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(mask)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeUInt16(gridSpacing)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainRequest> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    override val id: UInt = 133u

    override val crcExtra: Byte = 6

    override fun deserialize(bytes: ByteArray): TerrainRequest {
      val decoder = MavDataDecoder(bytes)

      val mask = decoder.safeDecodeUInt64()
      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val gridSpacing = decoder.safeDecodeUInt16()

      return TerrainRequest(
        lat = lat,
        lon = lon,
        gridSpacing = gridSpacing,
        mask = mask,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TerrainRequest =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var lat: Int = 0

    public var lon: Int = 0

    public var gridSpacing: UShort = 0u

    public var mask: ULong = 0uL

    public fun build(): TerrainRequest = TerrainRequest(
      lat = lat,
      lon = lon,
      gridSpacing = gridSpacing,
      mask = mask,
    )
  }
}
