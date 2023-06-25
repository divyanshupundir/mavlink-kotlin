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
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(latitude)
    buffer.encodeInt32(longitude)
    buffer.encodeInt32(altitude)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(latitude)
    buffer.encodeInt32(longitude)
    buffer.encodeInt32(altitude)
    buffer.encodeUInt64(timeUsec)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsGlobalOrigin> {
    public override val id: UInt = 49u

    public override val crcExtra: Byte = 39

    public override fun deserialize(bytes: ByteArray): GpsGlobalOrigin {
      val buffer = Buffer().write(bytes)

      val latitude = buffer.decodeInt32()
      val longitude = buffer.decodeInt32()
      val altitude = buffer.decodeInt32()
      val timeUsec = buffer.decodeUInt64()

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
