package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<RallyPoint> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeInt16(alt)
    outputBuffer.encodeInt16(breakAlt)
    outputBuffer.encodeUInt16(landDir)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(idx)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeInt16(alt)
    outputBuffer.encodeInt16(breakAlt)
    outputBuffer.encodeUInt16(landDir)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(idx)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 175u

    private const val CRC_EXTRA: Byte = -118

    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    private val DESERIALIZER: MavDeserializer<RallyPoint> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt16()
      val breakAlt = inputBuffer.decodeInt16()
      val landDir = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val idx = inputBuffer.decodeUInt8()
      val count = inputBuffer.decodeUInt8()
      val flags = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = RallyFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      RallyPoint(
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


    private val METADATA: MavMessage.Metadata<RallyPoint> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RallyPoint> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RallyPoint =
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
