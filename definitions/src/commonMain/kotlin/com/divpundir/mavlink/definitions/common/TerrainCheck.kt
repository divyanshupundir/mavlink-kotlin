package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lon)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainCheck> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 135u

    public override val crcExtra: Byte = -53

    public override fun deserialize(bytes: ByteArray): TerrainCheck {
      val decoder = MavDataDecoder(bytes)

      val lat = decoder.safeDecodeInt32()
      val lon = decoder.safeDecodeInt32()

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
