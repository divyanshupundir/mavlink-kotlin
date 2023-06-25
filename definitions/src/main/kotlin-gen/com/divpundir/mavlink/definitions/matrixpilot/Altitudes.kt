package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * The altitude measured by sensors and IMU
 */
@GeneratedMavMessage(
  id = 181u,
  crcExtra = 55,
)
public data class Altitudes(
  /**
   * Timestamp (milliseconds since system boot)
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * GPS altitude (MSL) in meters, expressed as * 1000 (millimeters)
   */
  @GeneratedMavField(type = "int32_t")
  public val altGps: Int = 0,
  /**
   * IMU altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  @GeneratedMavField(type = "int32_t")
  public val altImu: Int = 0,
  /**
   * barometeric altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  @GeneratedMavField(type = "int32_t")
  public val altBarometric: Int = 0,
  /**
   * Optical flow altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  @GeneratedMavField(type = "int32_t")
  public val altOpticalFlow: Int = 0,
  /**
   * Rangefinder Altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  @GeneratedMavField(type = "int32_t")
  public val altRangeFinder: Int = 0,
  /**
   * Extra altitude above ground in meters, expressed as * 1000 (millimeters)
   */
  @GeneratedMavField(type = "int32_t")
  public val altExtra: Int = 0,
) : MavMessage<Altitudes> {
  public override val instanceCompanion: MavMessage.MavCompanion<Altitudes> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(altGps)
    buffer.encodeInt32(altImu)
    buffer.encodeInt32(altBarometric)
    buffer.encodeInt32(altOpticalFlow)
    buffer.encodeInt32(altRangeFinder)
    buffer.encodeInt32(altExtra)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeInt32(altGps)
    buffer.encodeInt32(altImu)
    buffer.encodeInt32(altBarometric)
    buffer.encodeInt32(altOpticalFlow)
    buffer.encodeInt32(altRangeFinder)
    buffer.encodeInt32(altExtra)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Altitudes> {
    public override val id: UInt = 181u

    public override val crcExtra: Byte = 55

    public override fun deserialize(bytes: ByteArray): Altitudes {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val altGps = buffer.decodeInt32()
      val altImu = buffer.decodeInt32()
      val altBarometric = buffer.decodeInt32()
      val altOpticalFlow = buffer.decodeInt32()
      val altRangeFinder = buffer.decodeInt32()
      val altExtra = buffer.decodeInt32()

      return Altitudes(
        timeBootMs = timeBootMs,
        altGps = altGps,
        altImu = altImu,
        altBarometric = altBarometric,
        altOpticalFlow = altOpticalFlow,
        altRangeFinder = altRangeFinder,
        altExtra = altExtra,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Altitudes =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var altGps: Int = 0

    public var altImu: Int = 0

    public var altBarometric: Int = 0

    public var altOpticalFlow: Int = 0

    public var altRangeFinder: Int = 0

    public var altExtra: Int = 0

    public fun build(): Altitudes = Altitudes(
      timeBootMs = timeBootMs,
      altGps = altGps,
      altImu = altImu,
      altBarometric = altBarometric,
      altOpticalFlow = altOpticalFlow,
      altRangeFinder = altRangeFinder,
      altExtra = altExtra,
    )
  }
}
