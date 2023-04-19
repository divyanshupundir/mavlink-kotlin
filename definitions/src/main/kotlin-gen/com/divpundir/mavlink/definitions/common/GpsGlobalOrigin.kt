package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<GpsGlobalOrigin> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt32(altitude)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(latitude)
    outputBuffer.encodeInt32(longitude)
    outputBuffer.encodeInt32(altitude)
    outputBuffer.encodeUInt64(timeUsec)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 49u

    private const val CRC_EXTRA: Byte = 39

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 20

    private val DESERIALIZER: MavDeserializer<GpsGlobalOrigin> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val latitude = inputBuffer.decodeInt32()
      val longitude = inputBuffer.decodeInt32()
      val altitude = inputBuffer.decodeInt32()
      val timeUsec = inputBuffer.decodeUInt64()

      GpsGlobalOrigin(
        latitude = latitude,
        longitude = longitude,
        altitude = altitude,
        timeUsec = timeUsec,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsGlobalOrigin> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsGlobalOrigin> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GpsGlobalOrigin =
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
