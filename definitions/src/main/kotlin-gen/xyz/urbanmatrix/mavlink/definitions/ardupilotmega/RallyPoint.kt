package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV ->
 * GCS.
 */
@GeneratedMavMessage(
  id = 175,
  crc = 138,
)
public data class RallyPoint(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * Point index (first point is 0).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: Int = 0,
  /**
   * Total number of points (for sanity checking).
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
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
  public val alt: Int = 0,
  /**
   * Break altitude relative to home.
   */
  @GeneratedMavField(type = "int16_t")
  public val breakAlt: Int = 0,
  /**
   * Heading to aim for when landing.
   */
  @GeneratedMavField(type = "uint16_t")
  public val landDir: Int = 0,
  /**
   * Configuration flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<RallyFlags> = MavBitmaskValue.fromValue(0),
) : MavMessage<RallyPoint> {
  public override val instanceMetadata: MavMessage.Metadata<RallyPoint> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeInt16(alt)
    outputBuffer.encodeInt16(breakAlt)
    outputBuffer.encodeUint16(landDir)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeInt16(alt)
    outputBuffer.encodeInt16(breakAlt)
    outputBuffer.encodeUint16(landDir)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 175

    private const val CRC: Int = 138

    private const val SIZE_V1: Int = 19

    private const val SIZE_V2: Int = 19

    private val DESERIALIZER: MavDeserializer<RallyPoint> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val alt = inputBuffer.decodeInt16()
      val breakAlt = inputBuffer.decodeInt16()
      val landDir = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val idx = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()
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


    private val METADATA: MavMessage.Metadata<RallyPoint> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RallyPoint> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var idx: Int = 0

    public var count: Int = 0

    public var lat: Int = 0

    public var lng: Int = 0

    public var alt: Int = 0

    public var breakAlt: Int = 0

    public var landDir: Int = 0

    public var flags: MavBitmaskValue<RallyFlags> = MavBitmaskValue.fromValue(0)

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
