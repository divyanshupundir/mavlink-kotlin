package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Request that the vehicle report terrain height at the given location (expected response is a
 * TERRAIN_REPORT). Used by GCS to check if vehicle has all terrain data needed for a mission.
 */
@GeneratedMavMessage(
  id = 135u,
  crcExtra = -53,
)
public data class TerrainCheck(
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
) : MavMessage<TerrainCheck> {
  public override val instanceCompanion: MavMessage.MavCompanion<TerrainCheck> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(lat)
    output.encodeInt32(lon)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<TerrainCheck> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 135u

    public override val crcExtra: Byte = -53

    public override fun deserialize(source: BufferedSource): TerrainCheck {
      val lat = source.decodeInt32()
      val lon = source.decodeInt32()

      return TerrainCheck(
        lat = lat,
        lon = lon,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): TerrainCheck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var lat: Int = 0

    public var lon: Int = 0

    public fun build(): TerrainCheck = TerrainCheck(
      lat = lat,
      lon = lon,
    )
  }
}
