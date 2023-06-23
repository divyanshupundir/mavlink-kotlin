package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Sets the GPS co-ordinates of the vehicle local origin (0,0,0) position. Vehicle should emit
 * GPS_GLOBAL_ORIGIN irrespective of whether the origin is changed. This enables transform between the
 * local coordinate frame and the global (GPS) coordinate frame, which may be necessary when (for
 * example) indoor and outdoor settings are connected and the MAV should move from in- to outdoor.
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
) : MavMessage<SetGpsGlobalOrigin> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetGpsGlobalOrigin> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt32(altitude)
    output.encodeUInt8(targetSystem)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(latitude)
    output.encodeInt32(longitude)
    output.encodeInt32(altitude)
    output.encodeUInt8(targetSystem)
    output.encodeUInt64(timeUsec)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SetGpsGlobalOrigin> {
    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 21

    public override val id: UInt = 48u

    public override val crcExtra: Byte = 41

    public override fun deserialize(source: BufferedSource): SetGpsGlobalOrigin {
      val latitude = source.decodeInt32()
      val longitude = source.decodeInt32()
      val altitude = source.decodeInt32()
      val targetSystem = source.decodeUInt8()
      val timeUsec = source.decodeUInt64()

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
