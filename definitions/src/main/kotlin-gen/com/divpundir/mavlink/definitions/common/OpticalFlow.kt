package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor)
 */
@GeneratedMavMessage(
  id = 100u,
  crcExtra = -81,
)
public data class OpticalFlow(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Sensor ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val sensorId: UByte = 0u,
  /**
   * Flow in x-sensor direction
   */
  @GeneratedMavField(type = "int16_t")
  public val flowX: Short = 0,
  /**
   * Flow in y-sensor direction
   */
  @GeneratedMavField(type = "int16_t")
  public val flowY: Short = 0,
  /**
   * Flow in x-sensor direction, angular-speed compensated
   */
  @GeneratedMavField(type = "float")
  public val flowCompMX: Float = 0F,
  /**
   * Flow in y-sensor direction, angular-speed compensated
   */
  @GeneratedMavField(type = "float")
  public val flowCompMY: Float = 0F,
  /**
   * Optical flow quality / confidence. 0: bad, 255: maximum quality
   */
  @GeneratedMavField(type = "uint8_t")
  public val quality: UByte = 0u,
  /**
   * Ground distance. Positive value: distance known. Negative value: Unknown distance
   */
  @GeneratedMavField(type = "float")
  public val groundDistance: Float = 0F,
  /**
   * Flow rate about X axis
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val flowRateX: Float = 0F,
  /**
   * Flow rate about Y axis
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val flowRateY: Float = 0F,
) : MavMessage<OpticalFlow> {
  public override val instanceCompanion: MavMessage.MavCompanion<OpticalFlow> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(flowCompMX)
    output.encodeFloat(flowCompMY)
    output.encodeFloat(groundDistance)
    output.encodeInt16(flowX)
    output.encodeInt16(flowY)
    output.encodeUInt8(sensorId)
    output.encodeUInt8(quality)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(flowCompMX)
    output.encodeFloat(flowCompMY)
    output.encodeFloat(groundDistance)
    output.encodeInt16(flowX)
    output.encodeInt16(flowY)
    output.encodeUInt8(sensorId)
    output.encodeUInt8(quality)
    output.encodeFloat(flowRateX)
    output.encodeFloat(flowRateY)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<OpticalFlow> {
    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 34

    public override val id: UInt = 100u

    public override val crcExtra: Byte = -81

    public override fun deserialize(source: BufferedSource): OpticalFlow {
      val timeUsec = source.decodeUInt64()
      val flowCompMX = source.decodeFloat()
      val flowCompMY = source.decodeFloat()
      val groundDistance = source.decodeFloat()
      val flowX = source.decodeInt16()
      val flowY = source.decodeInt16()
      val sensorId = source.decodeUInt8()
      val quality = source.decodeUInt8()
      val flowRateX = source.decodeFloat()
      val flowRateY = source.decodeFloat()

      return OpticalFlow(
        timeUsec = timeUsec,
        sensorId = sensorId,
        flowX = flowX,
        flowY = flowY,
        flowCompMX = flowCompMX,
        flowCompMY = flowCompMY,
        quality = quality,
        groundDistance = groundDistance,
        flowRateX = flowRateX,
        flowRateY = flowRateY,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OpticalFlow =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var sensorId: UByte = 0u

    public var flowX: Short = 0

    public var flowY: Short = 0

    public var flowCompMX: Float = 0F

    public var flowCompMY: Float = 0F

    public var quality: UByte = 0u

    public var groundDistance: Float = 0F

    public var flowRateX: Float = 0F

    public var flowRateY: Float = 0F

    public fun build(): OpticalFlow = OpticalFlow(
      timeUsec = timeUsec,
      sensorId = sensorId,
      flowX = flowX,
      flowY = flowY,
      flowCompMX = flowCompMX,
      flowCompMY = flowCompMY,
      quality = quality,
      groundDistance = groundDistance,
      flowRateX = flowRateX,
      flowRateY = flowRateY,
    )
  }
}
