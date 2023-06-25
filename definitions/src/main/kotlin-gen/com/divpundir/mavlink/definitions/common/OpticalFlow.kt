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
import kotlin.ByteArray
import kotlin.Float
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(flowCompMX)
    buffer.encodeFloat(flowCompMY)
    buffer.encodeFloat(groundDistance)
    buffer.encodeInt16(flowX)
    buffer.encodeInt16(flowY)
    buffer.encodeUInt8(sensorId)
    buffer.encodeUInt8(quality)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(flowCompMX)
    buffer.encodeFloat(flowCompMY)
    buffer.encodeFloat(groundDistance)
    buffer.encodeInt16(flowX)
    buffer.encodeInt16(flowY)
    buffer.encodeUInt8(sensorId)
    buffer.encodeUInt8(quality)
    buffer.encodeFloat(flowRateX)
    buffer.encodeFloat(flowRateY)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpticalFlow> {
    public override val id: UInt = 100u

    public override val crcExtra: Byte = -81

    public override fun deserialize(bytes: ByteArray): OpticalFlow {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val flowCompMX = buffer.decodeFloat()
      val flowCompMY = buffer.decodeFloat()
      val groundDistance = buffer.decodeFloat()
      val flowX = buffer.decodeInt16()
      val flowY = buffer.decodeInt16()
      val sensorId = buffer.decodeUInt8()
      val quality = buffer.decodeUInt8()
      val flowRateX = buffer.decodeFloat()
      val flowRateY = buffer.decodeFloat()

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
