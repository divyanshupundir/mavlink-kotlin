package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * A rally point. Used to set a point when from GCS -> MAV. Also used to return a point from MAV ->
 * GCS.
 */
public data class RallyPoint(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Point index (first point is 0).
   */
  public val idx: Int = 0,
  /**
   * Total number of points (for sanity checking).
   */
  public val count: Int = 0,
  /**
   * Latitude of point.
   */
  public val lat: Int = 0,
  /**
   * Longitude of point.
   */
  public val lng: Int = 0,
  /**
   * Transit / loiter altitude relative to home.
   */
  public val alt: Int = 0,
  /**
   * Break altitude relative to home.
   */
  public val breakAlt: Int = 0,
  /**
   * Heading to aim for when landing.
   */
  public val landDir: Int = 0,
  /**
   * Configuration flags.
   */
  public val flags: MavEnumValue<RallyFlags> = MavEnumValue.fromValue(0),
) : MavMessage<RallyPoint> {
  public override val instanceMetadata: MavMessage.Metadata<RallyPoint> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(19).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeInt16(alt)
    outputBuffer.encodeInt16(breakAlt)
    outputBuffer.encodeUint16(landDir)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(idx)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeEnumValue(flags.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 175

    private const val CRC: Int = 138

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
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = RallyFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
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
  }
}
