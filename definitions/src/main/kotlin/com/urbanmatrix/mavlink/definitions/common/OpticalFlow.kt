package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor)
 */
public data class OpticalFlow(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Sensor ID
   */
  public val sensorId: Int = 0,
  /**
   * Flow in x-sensor direction
   */
  public val flowX: Int = 0,
  /**
   * Flow in y-sensor direction
   */
  public val flowY: Int = 0,
  /**
   * Flow in x-sensor direction, angular-speed compensated
   */
  public val flowCompMX: Float = 0F,
  /**
   * Flow in y-sensor direction, angular-speed compensated
   */
  public val flowCompMY: Float = 0F,
  /**
   * Optical flow quality / confidence. 0: bad, 255: maximum quality
   */
  public val quality: Int = 0,
  /**
   * Ground distance. Positive value: distance known. Negative value: Unknown distance
   */
  public val groundDistance: Float = 0F,
  /**
   * Flow rate about X axis
   */
  public val flowRateX: Float = 0F,
  /**
   * Flow rate about Y axis
   */
  public val flowRateY: Float = 0F,
) : MavMessage<OpticalFlow> {
  public override val instanceMetadata: MavMessage.Metadata<OpticalFlow> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(flowCompMX)
    outputBuffer.encodeFloat(flowCompMY)
    outputBuffer.encodeFloat(groundDistance)
    outputBuffer.encodeInt16(flowX)
    outputBuffer.encodeInt16(flowY)
    outputBuffer.encodeUint8(sensorId)
    outputBuffer.encodeUint8(quality)
    outputBuffer.encodeFloat(flowRateX)
    outputBuffer.encodeFloat(flowRateY)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 100

    private const val CRC: Int = 175

    private const val SIZE: Int = 34

    private val DESERIALIZER: MavDeserializer<OpticalFlow> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val flowCompMX = inputBuffer.decodeFloat()
      val flowCompMY = inputBuffer.decodeFloat()
      val groundDistance = inputBuffer.decodeFloat()
      val flowX = inputBuffer.decodeInt16()
      val flowY = inputBuffer.decodeInt16()
      val sensorId = inputBuffer.decodeUint8()
      val quality = inputBuffer.decodeUint8()
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


    private val METADATA: MavMessage.Metadata<OpticalFlow> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OpticalFlow> = METADATA
  }
}
