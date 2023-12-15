package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(altGps)
    encoder.encodeInt32(altImu)
    encoder.encodeInt32(altBarometric)
    encoder.encodeInt32(altOpticalFlow)
    encoder.encodeInt32(altRangeFinder)
    encoder.encodeInt32(altExtra)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeInt32(altGps)
    encoder.encodeInt32(altImu)
    encoder.encodeInt32(altBarometric)
    encoder.encodeInt32(altOpticalFlow)
    encoder.encodeInt32(altRangeFinder)
    encoder.encodeInt32(altExtra)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Altitudes> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    public override val id: UInt = 181u

    public override val crcExtra: Byte = 55

    public override fun deserialize(bytes: ByteArray): Altitudes {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val altGps = decoder.safeDecodeInt32()
      val altImu = decoder.safeDecodeInt32()
      val altBarometric = decoder.safeDecodeInt32()
      val altOpticalFlow = decoder.safeDecodeInt32()
      val altRangeFinder = decoder.safeDecodeInt32()
      val altExtra = decoder.safeDecodeInt32()

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
