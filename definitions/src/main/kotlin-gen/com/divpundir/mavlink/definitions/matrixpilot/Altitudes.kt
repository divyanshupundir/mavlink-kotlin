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
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(altGps)
    output.encodeInt32(altImu)
    output.encodeInt32(altBarometric)
    output.encodeInt32(altOpticalFlow)
    output.encodeInt32(altRangeFinder)
    output.encodeInt32(altExtra)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeInt32(altGps)
    output.encodeInt32(altImu)
    output.encodeInt32(altBarometric)
    output.encodeInt32(altOpticalFlow)
    output.encodeInt32(altRangeFinder)
    output.encodeInt32(altExtra)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Altitudes> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 181u

    public override val crcExtra: Byte = 55

    public override fun deserialize(source: BufferedSource): Altitudes {
      val timeBootMs = source.decodeUInt32()
      val altGps = source.decodeInt32()
      val altImu = source.decodeInt32()
      val altBarometric = source.decodeInt32()
      val altOpticalFlow = source.decodeInt32()
      val altRangeFinder = source.decodeInt32()
      val altExtra = source.decodeInt32()

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
