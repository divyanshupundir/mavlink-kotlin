package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor)
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param sensorId Sensor ID
 * @param flowX Flow in x-sensor direction
 * units = dpix
 * @param flowY Flow in y-sensor direction
 * units = dpix
 * @param flowCompMX Flow in x-sensor direction, angular-speed compensated
 * units = m/s
 * @param flowCompMY Flow in y-sensor direction, angular-speed compensated
 * units = m/s
 * @param quality Optical flow quality / confidence. 0: bad, 255: maximum quality
 * @param groundDistance Ground distance. Positive value: distance known. Negative value: Unknown
 * distance
 * units = m
 * @param flowRateX Flow rate about X axis
 * units = rad/s
 * @param flowRateY Flow rate about Y axis
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 100u,
  crcExtra = -81,
)
public data class OpticalFlow(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
   * units = dpix
   */
  @GeneratedMavField(type = "int16_t")
  public val flowX: Short = 0,
  /**
   * Flow in y-sensor direction
   * units = dpix
   */
  @GeneratedMavField(type = "int16_t")
  public val flowY: Short = 0,
  /**
   * Flow in x-sensor direction, angular-speed compensated
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val flowCompMX: Float = 0F,
  /**
   * Flow in y-sensor direction, angular-speed compensated
   * units = m/s
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
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val groundDistance: Float = 0F,
  /**
   * Flow rate about X axis
   * units = rad/s
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val flowRateX: Float = 0F,
  /**
   * Flow rate about Y axis
   * units = rad/s
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val flowRateY: Float = 0F,
) : MavMessage<OpticalFlow> {
  override val instanceCompanion: MavMessage.MavCompanion<OpticalFlow> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(flowCompMX)
    encoder.encodeFloat(flowCompMY)
    encoder.encodeFloat(groundDistance)
    encoder.encodeInt16(flowX)
    encoder.encodeInt16(flowY)
    encoder.encodeUInt8(sensorId)
    encoder.encodeUInt8(quality)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(flowCompMX)
    encoder.encodeFloat(flowCompMY)
    encoder.encodeFloat(groundDistance)
    encoder.encodeInt16(flowX)
    encoder.encodeInt16(flowY)
    encoder.encodeUInt8(sensorId)
    encoder.encodeUInt8(quality)
    encoder.encodeFloat(flowRateX)
    encoder.encodeFloat(flowRateY)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpticalFlow> {
    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 34

    override val id: UInt = 100u

    override val crcExtra: Byte = -81

    override fun deserialize(bytes: ByteArray): OpticalFlow {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val flowCompMX = decoder.safeDecodeFloat()
      val flowCompMY = decoder.safeDecodeFloat()
      val groundDistance = decoder.safeDecodeFloat()
      val flowX = decoder.safeDecodeInt16()
      val flowY = decoder.safeDecodeInt16()
      val sensorId = decoder.safeDecodeUInt8()
      val quality = decoder.safeDecodeUInt8()
      val flowRateX = decoder.safeDecodeFloat()
      val flowRateY = decoder.safeDecodeFloat()

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
