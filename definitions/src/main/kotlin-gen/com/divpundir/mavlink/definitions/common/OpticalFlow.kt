package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<OpticalFlow> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(flowCompMX)
    outputBuffer.encodeFloat(flowCompMY)
    outputBuffer.encodeFloat(groundDistance)
    outputBuffer.encodeInt16(flowX)
    outputBuffer.encodeInt16(flowY)
    outputBuffer.encodeUInt8(sensorId)
    outputBuffer.encodeUInt8(quality)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(flowCompMX)
    outputBuffer.encodeFloat(flowCompMY)
    outputBuffer.encodeFloat(groundDistance)
    outputBuffer.encodeInt16(flowX)
    outputBuffer.encodeInt16(flowY)
    outputBuffer.encodeUInt8(sensorId)
    outputBuffer.encodeUInt8(quality)
    outputBuffer.encodeFloat(flowRateX)
    outputBuffer.encodeFloat(flowRateY)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 100u

    private const val CRC_EXTRA: Byte = -81

    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 34

    private val DESERIALIZER: MavDeserializer<OpticalFlow> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val flowCompMX = inputBuffer.decodeFloat()
      val flowCompMY = inputBuffer.decodeFloat()
      val groundDistance = inputBuffer.decodeFloat()
      val flowX = inputBuffer.decodeInt16()
      val flowY = inputBuffer.decodeInt16()
      val sensorId = inputBuffer.decodeUInt8()
      val quality = inputBuffer.decodeUInt8()
      val flowRateX = inputBuffer.decodeFloat()
      val flowRateY = inputBuffer.decodeFloat()

      OpticalFlow(
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


    private val METADATA: MavMessage.Metadata<OpticalFlow> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpticalFlow> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OpticalFlow =
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
