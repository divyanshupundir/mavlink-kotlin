package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Publishes the GPS coordinates of the vehicle local origin (0,0,0) position. Emitted whenever a
 * new GPS-Local position mapping is requested or set - e.g. following SET_GPS_GLOBAL_ORIGIN message.
 *
 * @param latitude Latitude (WGS84)
 * units = degE7
 * @param longitude Longitude (WGS84)
 * units = degE7
 * @param altitude Altitude (MSL). Positive for up.
 * units = mm
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 */
@GeneratedMavMessage(
  id = 49u,
  crcExtra = 39,
)
public data class GpsGlobalOrigin(
  /**
   * Latitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val latitude: Int = 0,
  /**
   * Longitude (WGS84)
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val longitude: Int = 0,
  /**
   * Altitude (MSL). Positive for up.
   * units = mm
   */
  @GeneratedMavField(type = "int32_t")
  public val altitude: Int = 0,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(
    type = "uint64_t",
    extension = true,
  )
  public val timeUsec: ULong = 0uL,
) : MavMessage<GpsGlobalOrigin> {
  override val instanceCompanion: MavMessage.MavCompanion<GpsGlobalOrigin> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt32(altitude)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt32(altitude)
    encoder.encodeUInt64(timeUsec)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GpsGlobalOrigin> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 20

    override val id: UInt = 49u

    override val crcExtra: Byte = 39

    override fun deserialize(bytes: ByteArray): GpsGlobalOrigin {
      val decoder = MavDataDecoder(bytes)

      val latitude = decoder.safeDecodeInt32()
      val longitude = decoder.safeDecodeInt32()
      val altitude = decoder.safeDecodeInt32()
      val timeUsec = decoder.safeDecodeUInt64()

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
