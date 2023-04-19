package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<Altitudes> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(altGps)
    outputBuffer.encodeInt32(altImu)
    outputBuffer.encodeInt32(altBarometric)
    outputBuffer.encodeInt32(altOpticalFlow)
    outputBuffer.encodeInt32(altRangeFinder)
    outputBuffer.encodeInt32(altExtra)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeInt32(altGps)
    outputBuffer.encodeInt32(altImu)
    outputBuffer.encodeInt32(altBarometric)
    outputBuffer.encodeInt32(altOpticalFlow)
    outputBuffer.encodeInt32(altRangeFinder)
    outputBuffer.encodeInt32(altExtra)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 181u

    private const val CRC_EXTRA: Byte = 55

    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    private val DESERIALIZER: MavDeserializer<Altitudes> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val altGps = inputBuffer.decodeInt32()
      val altImu = inputBuffer.decodeInt32()
      val altBarometric = inputBuffer.decodeInt32()
      val altOpticalFlow = inputBuffer.decodeInt32()
      val altRangeFinder = inputBuffer.decodeInt32()
      val altExtra = inputBuffer.decodeInt32()

      Altitudes(
        timeBootMs = timeBootMs,
        altGps = altGps,
        altImu = altImu,
        altBarometric = altBarometric,
        altOpticalFlow = altOpticalFlow,
        altRangeFinder = altRangeFinder,
        altExtra = altExtra,
      )
    }


    private val METADATA: MavMessage.Metadata<Altitudes> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Altitudes> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Altitudes =
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
