package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Sets the GPS coordinates of the vehicle local origin (0,0,0) position. Vehicle should emit
 * GPS_GLOBAL_ORIGIN irrespective of whether the origin is changed. This enables transform between the
 * local coordinate frame and the global (GPS) coordinate frame, which may be necessary when (for
 * example) indoor and outdoor settings are connected and the MAV should move from in- to outdoor.
 *
 * @param targetSystem System ID
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
  id = 48u,
  crcExtra = 41,
)
public data class SetGpsGlobalOrigin(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
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
) : MavMessage<SetGpsGlobalOrigin> {
  override val instanceCompanion: MavMessage.MavCompanion<SetGpsGlobalOrigin> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt32(altitude)
    encoder.encodeUInt8(targetSystem)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(latitude)
    encoder.encodeInt32(longitude)
    encoder.encodeInt32(altitude)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt64(timeUsec)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SetGpsGlobalOrigin> {
    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 21

    override val id: UInt = 48u

    override val crcExtra: Byte = 41

    override fun deserialize(bytes: ByteArray): SetGpsGlobalOrigin {
      val decoder = MavDataDecoder(bytes)

      val latitude = decoder.safeDecodeInt32()
      val longitude = decoder.safeDecodeInt32()
      val altitude = decoder.safeDecodeInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val timeUsec = decoder.safeDecodeUInt64()

      return SetGpsGlobalOrigin(
        targetSystem = targetSystem,
        latitude = latitude,
        longitude = longitude,
        altitude = altitude,
        timeUsec = timeUsec,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetGpsGlobalOrigin =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var latitude: Int = 0

    public var longitude: Int = 0

    public var altitude: Int = 0

    public var timeUsec: ULong = 0uL

    public fun build(): SetGpsGlobalOrigin = SetGpsGlobalOrigin(
      targetSystem = targetSystem,
      latitude = latitude,
      longitude = longitude,
      altitude = altitude,
      timeUsec = timeUsec,
    )
  }
}
