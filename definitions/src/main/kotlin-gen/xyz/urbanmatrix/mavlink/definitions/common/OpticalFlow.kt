package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Optical flow from a flow sensor (e.g. optical mouse sensor)
 */
@GeneratedMavMessage(
  id = 100,
  crc = 175,
)
public data class OpticalFlow(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Sensor ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val sensorId: Int = 0,
  /**
   * Flow in x-sensor direction
   */
  @GeneratedMavField(type = "int16_t")
  public val flowX: Int = 0,
  /**
   * Flow in y-sensor direction
   */
  @GeneratedMavField(type = "int16_t")
  public val flowY: Int = 0,
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
  public val quality: Int = 0,
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
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(flowCompMX)
    outputBuffer.encodeFloat(flowCompMY)
    outputBuffer.encodeFloat(groundDistance)
    outputBuffer.encodeInt16(flowX)
    outputBuffer.encodeInt16(flowY)
    outputBuffer.encodeUint8(sensorId)
    outputBuffer.encodeUint8(quality)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 100

    private const val CRC: Int = 175

    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 34

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var sensorId: Int = 0

    public var flowX: Int = 0

    public var flowY: Int = 0

    public var flowCompMX: Float = 0F

    public var flowCompMY: Float = 0F

    public var quality: Int = 0

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
