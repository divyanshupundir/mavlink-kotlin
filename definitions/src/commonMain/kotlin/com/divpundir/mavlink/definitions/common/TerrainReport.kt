package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Streamed from drone to report progress of terrain map download (initiated by TERRAIN_REQUEST), or
 * sent as a response to a TERRAIN_CHECK request. See terrain protocol docs:
 * https://mavlink.io/en/services/terrain.html
 *
 * @param lat Latitude
 * units = degE7
 * @param lon Longitude
 * units = degE7
 * @param spacing grid spacing (zero if terrain at this location unavailable)
 * @param terrainHeight Terrain height MSL
 * units = m
 * @param currentHeight Current vehicle height above lat/lon terrain height
 * units = m
 * @param pending Number of 4x4 terrain blocks waiting to be received or read from disk
 * @param loaded Number of 4x4 terrain blocks in memory
 */
@GeneratedMavMessage(
  id = 136u,
  crcExtra = 1,
)
public data class TerrainReport(
  /**
   * Latitude
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lon: Int = 0,
  /**
   * grid spacing (zero if terrain at this location unavailable)
   */
  @GeneratedMavField(type = "uint16_t")
  public val spacing: UShort = 0u,
  /**
   * Terrain height MSL
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val terrainHeight: Float = 0F,
  /**
   * Current vehicle height above lat/lon terrain height
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val currentHeight: Float = 0F,
  /**
   * Number of 4x4 terrain blocks waiting to be received or read from disk
   */
  @GeneratedMavField(type = "uint16_t")
  public val pending: UShort = 0u,
  /**
   * Number of 4x4 terrain blocks in memory
   */
  @GeneratedMavField(type = "uint16_t")
  public val loaded: UShort = 0u,
) : MavMessage<TerrainReport> {
  override val instanceCompanion: MavMessage.MavCompanion<TerrainReport> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(terrainHeight)
    encoder.encodeFloat(currentHeight)
    encoder.encodeUInt16(spacing)
    encoder.encodeUInt16(pending)
    encoder.encodeUInt16(loaded)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    encoder.encodeFloat(terrainHeight)
    encoder.encodeFloat(currentHeight)
    encoder.encodeUInt16(spacing)
    encoder.encodeUInt16(pending)
    encoder.encodeUInt16(loaded)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainReport> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    override val id: UInt = 136u

    override val crcExtra: Byte = 1

    override fun deserialize(bytes: ByteArray): TerrainReport {
      val decoder = MavDataDecoder(bytes)

      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()
      val terrainHeight = decoder.safeDecodeFloat()
      val currentHeight = decoder.safeDecodeFloat()
      val spacing = decoder.safeDecodeUInt16()
      val pending = decoder.safeDecodeUInt16()
      val loaded = decoder.safeDecodeUInt16()

      return TerrainReport(
        lat = lat,
        lon = lon,
        spacing = spacing,
        terrainHeight = terrainHeight,
        currentHeight = currentHeight,
        pending = pending,
        loaded = loaded,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TerrainReport =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var lat: Int = 0

    public var lon: Int = 0

    public var spacing: UShort = 0u

    public var terrainHeight: Float = 0F

    public var currentHeight: Float = 0F

    public var pending: UShort = 0u

    public var loaded: UShort = 0u

    public fun build(): TerrainReport = TerrainReport(
      lat = lat,
      lon = lon,
      spacing = spacing,
      terrainHeight = terrainHeight,
      currentHeight = currentHeight,
      pending = pending,
      loaded = loaded,
    )
  }
}
