package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Publishes the GPS co-ordinates of the vehicle local origin (0,0,0) position. Emitted whenever a
 * new GPS-Local position mapping is requested or set - e.g. following SET_GPS_GLOBAL_ORIGIN message.
 */
@GeneratedMavMessage(
  id = 49u,
  crcExtra = 39,
)
public data class GpsGlobalOrigin(
  /**
   * Latitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude (WGS84)
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   */
  @GeneratedMavField(type = "int32_t")
  public val altitude: Int = 0,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(
    type = "uint64_t",
    extension = true,
  )
  public val timeUsec: ULong = 0uL,
) : MavMessage<GpsGlobalOrigin> {
  public override val instanceCompanion: MavMessage.MavCompanion<GpsGlobalOrigin> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt32(altitude)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt32(altitude)
    output.encodeUInt64(timeUsec)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GpsGlobalOrigin> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 49u

    public override val crcExtra: Byte = 39

    public override fun deserialize(source: BufferedSource): GpsGlobalOrigin {
      val latitude = source.decodeInt32()
      val longitude = source.decodeInt32()
      val altitude = source.decodeInt32()
      val timeUsec = source.decodeUInt64()

      return GpsGlobalOrigin(
        latitude = latitude,
        longitude = longitude,
        altitude = altitude,
        timeUsec = timeUsec,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GpsGlobalOrigin =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitude: Int = 0

    public var timeUsec: ULong = 0uL

    public fun build(): GpsGlobalOrigin = GpsGlobalOrigin(
      latitude = latitude,
      longitude = longitude,
      altitude = altitude,
      timeUsec = timeUsec,
    )
  }
}
