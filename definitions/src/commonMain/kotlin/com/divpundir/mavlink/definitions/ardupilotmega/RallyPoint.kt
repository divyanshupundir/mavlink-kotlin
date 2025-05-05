package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV ->
 * GCS.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param idx Point index (first point is 0).
 * @param count Total number of points (for sanity checking).
 * @param lat Latitude of point.
 * units = degE7
 * @param lng Longitude of point.
 * units = degE7
 * @param alt Transit / loiter altitude relative to home.
 * units = m
 * @param breakAlt Break altitude relative to home.
 * units = m
 * @param landDir Heading to aim for when landing.
 * units = cdeg
 * @param flags Configuration flags.
 */
@GeneratedMavMessage(
  id = 175u,
  crcExtra = -118,
)
public data class RallyPoint(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Point index (first point is 0).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: UByte = 0u,
  /**
   * Total number of points (for sanity checking).
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Latitude of point.
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of point.
   * units = degE7
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
  /**
   * Transit / loiter altitude relative to home.
   * units = m
   */
  @GeneratedMavField(type = "int16_t")
  public val alt: Short = 0,
  /**
   * Break altitude relative to home.
   * units = m
   */
  @GeneratedMavField(type = "int16_t")
  public val breakAlt: Short = 0,
  /**
   * Heading to aim for when landing.
   * units = cdeg
   */
  @GeneratedMavField(type = "uint16_t")
  public val landDir: UShort = 0u,
  /**
   * Configuration flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavEnumValue<RallyFlags> = MavEnumValue.fromValue(0u),
) : MavMessage<RallyPoint> {
  override val instanceCompanion: MavMessage.MavCompanion<RallyPoint> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    encoder.encodeInt16(alt)
    encoder.encodeInt16(breakAlt)
    encoder.encodeUInt16(landDir)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(idx)
    encoder.encodeUInt8(count)
    encoder.encodeEnumValue(flags.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt32(lat)
    encoder.encodeInt32(lng)
    encoder.encodeInt16(alt)
    encoder.encodeInt16(breakAlt)
    encoder.encodeUInt16(landDir)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(idx)
    encoder.encodeUInt8(count)
    encoder.encodeEnumValue(flags.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RallyPoint> {
    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    override val id: UInt = 175u

    override val crcExtra: Byte = -118

    override fun deserialize(bytes: ByteArray): RallyPoint {
      val decoder = MavDataDecoder(bytes)

      val lat = decoder.safeDecodeInt32()
      val lng = decoder.safeDecodeInt32()
      val alt = decoder.safeDecodeInt16()
      val breakAlt = decoder.safeDecodeInt16()
      val landDir = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idx = decoder.safeDecodeUInt8()
      val count = decoder.safeDecodeUInt8()
      val flags = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = RallyFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return RallyPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
        count = count,
        lat = lat,
        lng = lng,
        alt = alt,
        breakAlt = breakAlt,
        landDir = landDir,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RallyPoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idx: UByte = 0u

    public var count: UByte = 0u

    public var lat: Int = 0

    public var lng: Int = 0

    public var alt: Short = 0

    public var breakAlt: Short = 0

    public var landDir: UShort = 0u

    public var flags: MavEnumValue<RallyFlags> = MavEnumValue.fromValue(0u)

    public fun build(): RallyPoint = RallyPoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
      count = count,
      lat = lat,
      lng = lng,
      alt = alt,
      breakAlt = breakAlt,
      landDir = landDir,
      flags = flags,
    )
  }
}
