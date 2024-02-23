package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Update the data in the OPEN_DRONE_ID_SYSTEM message with new location information. This can be
 * sent to update the location information for the operator when no other information in the SYSTEM
 * message has changed. This message allows for efficient operation on radio links which have limited
 * uplink bandwidth while meeting requirements for update frequency of the operator location.
 *
 * @param targetSystem System ID (0 for broadcast).
 * @param targetComponent Component ID (0 for broadcast).
 * @param operatorLatitude Latitude of the operator. If unknown: 0 (both Lat/Lon).
 * units = degE7
 * @param operatorLongitude Longitude of the operator. If unknown: 0 (both Lat/Lon).
 * units = degE7
 * @param operatorAltitudeGeo Geodetic altitude of the operator relative to WGS84. If unknown: -1000
 * m.
 * units = m
 * @param timestamp 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
 * units = s
 */
@GeneratedMavMessage(
  id = 12_919u,
  crcExtra = 7,
)
public data class OpenDroneIdSystemUpdate(
  /**
   * System ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Latitude of the operator. If unknown: 0 (both Lat/Lon).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val operatorLatitude: Int = 0,
  /**
   * Longitude of the operator. If unknown: 0 (both Lat/Lon).
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val operatorLongitude: Int = 0,
  /**
   * Geodetic altitude of the operator relative to WGS84. If unknown: -1000 m.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val operatorAltitudeGeo: Float = 0F,
  /**
   * 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019.
   * units = s
   */
  @GeneratedMavField(type = "uint32_t")
  public val timestamp: UInt = 0u,
) : MavMessage<OpenDroneIdSystemUpdate> {
  override val instanceCompanion: MavMessage.MavCompanion<OpenDroneIdSystemUpdate> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(operatorLatitude)
    encoder.encodeInt32(operatorLongitude)
    encoder.encodeFloat(operatorAltitudeGeo)
    encoder.encodeUInt32(timestamp)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(operatorLatitude)
    encoder.encodeInt32(operatorLongitude)
    encoder.encodeFloat(operatorAltitudeGeo)
    encoder.encodeUInt32(timestamp)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpenDroneIdSystemUpdate> {
    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    override val id: UInt = 12_919u

    override val crcExtra: Byte = 7

    override fun deserialize(bytes: ByteArray): OpenDroneIdSystemUpdate {
      val decoder = MavDataDecoder(bytes)

      val operatorLatitude = decoder.safeDecodeInt32()
      val operatorLongitude = decoder.safeDecodeInt32()
      val operatorAltitudeGeo = decoder.safeDecodeFloat()
      val timestamp = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return OpenDroneIdSystemUpdate(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        operatorLatitude = operatorLatitude,
        operatorLongitude = operatorLongitude,
        operatorAltitudeGeo = operatorAltitudeGeo,
        timestamp = timestamp,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpenDroneIdSystemUpdate =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var operatorLatitude: Int = 0

    public var operatorLongitude: Int = 0

    public var operatorAltitudeGeo: Float = 0F

    public var timestamp: UInt = 0u

    public fun build(): OpenDroneIdSystemUpdate = OpenDroneIdSystemUpdate(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      operatorLatitude = operatorLatitude,
      operatorLongitude = operatorLongitude,
      operatorAltitudeGeo = operatorAltitudeGeo,
      timestamp = timestamp,
    )
  }
}
