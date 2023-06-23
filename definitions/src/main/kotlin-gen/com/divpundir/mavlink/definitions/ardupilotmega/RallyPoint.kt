package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV ->
 * GCS.
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
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude of point.
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
  /**
   * Transit / loiter altitude relative to home.
   */
  @GeneratedMavField(type = "int16_t")
  public val alt: Short = 0,
  /**
   * Break altitude relative to home.
   */
  @GeneratedMavField(type = "int16_t")
  public val breakAlt: Short = 0,
  /**
   * Heading to aim for when landing.
   */
  @GeneratedMavField(type = "uint16_t")
  public val landDir: UShort = 0u,
  /**
   * Configuration flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<RallyFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<RallyPoint> {
  public override val instanceCompanion: MavMessage.MavCompanion<RallyPoint> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(lat)
    output.encodeInt32(lng)
    output.encodeInt16(alt)
    output.encodeInt16(breakAlt)
    output.encodeUInt16(landDir)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(idx)
    output.encodeUInt8(count)
    output.encodeBitmaskValue(flags.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt32(lat)
    output.encodeInt32(lng)
    output.encodeInt16(alt)
    output.encodeInt16(breakAlt)
    output.encodeUInt16(landDir)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(idx)
    output.encodeUInt8(count)
    output.encodeBitmaskValue(flags.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<RallyPoint> {
    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    public override val id: UInt = 175u

    public override val crcExtra: Byte = -118

    public override fun deserialize(source: BufferedSource): RallyPoint {
      val lat = source.decodeInt32()
      val lng = source.decodeInt32()
      val alt = source.decodeInt16()
      val breakAlt = source.decodeInt16()
      val landDir = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val idx = source.decodeUInt8()
      val count = source.decodeUInt8()
      val flags = source.decodeBitmaskValue(1).let { value ->
        val flags = RallyFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
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

    public var flags: MavBitmaskValue<RallyFlags> = MavBitmaskValue.fromValue(0u)

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
