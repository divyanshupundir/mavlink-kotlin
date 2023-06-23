package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Streamed from drone to report progress of terrain map download (initiated by TERRAIN_REQUEST), or
 * sent as a response to a TERRAIN_CHECK request. See terrain protocol docs:
 * https://mavlink.io/en/services/terrain.html
 */
@GeneratedMavMessage(
  id = 136u,
  crcExtra = 1,
)
public data class TerrainReport(
  /**
   * Latitude
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude
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
   */
  @GeneratedMavField(type = "float")
  public val terrainHeight: Float = 0F,
  /**
   * Current vehicle height above lat/lon terrain height
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
  public override val instanceCompanion: MavMessage.MavCompanion<TerrainReport> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeFloat(terrainHeight)
    output.encodeFloat(currentHeight)
    output.encodeUInt16(spacing)
    output.encodeUInt16(pending)
    output.encodeUInt16(loaded)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.encodeFloat(terrainHeight)
    output.encodeFloat(currentHeight)
    output.encodeUInt16(spacing)
    output.encodeUInt16(pending)
    output.encodeUInt16(loaded)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<TerrainReport> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    public override val id: UInt = 136u

    public override val crcExtra: Byte = 1

    public override fun deserialize(source: BufferedSource): TerrainReport {
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()
      val terrainHeight = source.decodeFloat()
      val currentHeight = source.decodeFloat()
      val spacing = source.decodeUInt16()
      val pending = source.decodeUInt16()
      val loaded = source.decodeUInt16()

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
