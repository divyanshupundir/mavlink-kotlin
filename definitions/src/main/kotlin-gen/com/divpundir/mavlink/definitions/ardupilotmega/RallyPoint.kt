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
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeInt16(alt)
    buffer.encodeInt16(breakAlt)
    buffer.encodeUInt16(landDir)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(idx)
    buffer.encodeUInt8(count)
    buffer.encodeBitmaskValue(flags.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeInt16(alt)
    buffer.encodeInt16(breakAlt)
    buffer.encodeUInt16(landDir)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(idx)
    buffer.encodeUInt8(count)
    buffer.encodeBitmaskValue(flags.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RallyPoint> {
    public override val id: UInt = 175u

    public override val crcExtra: Byte = -118

    public override fun deserialize(bytes: ByteArray): RallyPoint {
      val buffer = Buffer().write(bytes)

      val lat = buffer.decodeInt32()
      val lng = buffer.decodeInt32()
      val alt = buffer.decodeInt16()
      val breakAlt = buffer.decodeInt16()
      val landDir = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val idx = buffer.decodeUInt8()
      val count = buffer.decodeUInt8()
      val flags = buffer.decodeBitmaskValue(1).let { value ->
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
