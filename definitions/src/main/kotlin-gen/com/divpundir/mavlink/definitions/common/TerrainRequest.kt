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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(mask)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUInt16(gridSpacing)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(mask)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lon)
    outputBuffer.encodeUInt16(gridSpacing)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<TerrainRequest> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    public override val id: UInt = 133u

    public override val crcExtra: Byte = 6

    public override fun deserialize(bytes: ByteArray): TerrainRequest {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mask = inputBuffer.decodeUInt64()
      val lat = inputBuffer.decodeInt32()
      val lon = inputBuffer.decodeInt32()
      val gridSpacing = inputBuffer.decodeUInt16()

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
