package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Request for terrain data and terrain status. See terrain protocol docs:
 * https://mavlink.io/en/services/terrain.html
 */
@GeneratedMavMessage(
  id = 133u,
  crcExtra = 6,
)
public data class TerrainRequest(
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
  public val gridSpacing: UShort = 0u,
  /**
   * Bitmask of requested 4x4 grids (row major 8x7 array of grids, 56 bits)
   */
  @GeneratedMavField(type = "uint64_t")
  public val mask: ULong = 0uL,
) : MavMessage<TerrainRequest> {
  public override val instanceCompanion: MavMessage.MavCompanion<TerrainRequest> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(mask)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeUInt16(gridSpacing)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(mask)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lon)
    buffer.encodeUInt16(gridSpacing)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainRequest> {
    public override val id: UInt = 133u

    public override val crcExtra: Byte = 6

    public override fun deserialize(bytes: ByteArray): TerrainRequest {
      val buffer = Buffer().write(bytes)

      val mask = buffer.decodeUInt64()
      val lat = buffer.decodeInt32()
      val lon = buffer.decodeInt32()
      val gridSpacing = buffer.decodeUInt16()

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
