package xyz.urbanmatrix.mavlink.definitions.common

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
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor)
 */
@GeneratedMavMessage(
  id = 114u,
  crcExtra = -19,
)
public data class HilOpticalFlow(
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
   * Integration time. Divide integrated_x and integrated_y by the integration time to obtain
   * average flow. The integration time also indicates the.
   */
  @GeneratedMavField(type = "uint32_t")
  public val integrationTimeUs: UInt = 0u,
  /**
   * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow.
   * Sensor linear motion along the positive Y axis induces a negative flow.)
   */
  @GeneratedMavField(type = "float")
  public val integratedX: Float = 0F,
  /**
   * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow.
   * Sensor linear motion along the positive X axis induces a positive flow.)
   */
  @GeneratedMavField(type = "float")
  public val integratedY: Float = 0F,
  /**
   * RH rotation around X axis
   */
  @GeneratedMavField(type = "float")
  public val integratedXgyro: Float = 0F,
  /**
   * RH rotation around Y axis
   */
  @GeneratedMavField(type = "float")
  public val integratedYgyro: Float = 0F,
  /**
   * RH rotation around Z axis
   */
  @GeneratedMavField(type = "float")
  public val integratedZgyro: Float = 0F,
  /**
   * Temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Optical flow quality / confidence. 0: no valid flow, 255: maximum quality
   */
  @GeneratedMavField(type = "uint8_t")
  public val quality: UByte = 0u,
  /**
   * Time since the distance was sampled.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeDeltaDistanceUs: UInt = 0u,
  /**
   * Distance to the center of the flow field. Positive value (including zero): distance known.
   * Negative value: Unknown distance.
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
) : MavMessage<HilOpticalFlow> {
  public override val instanceMetadata: MavMessage.Metadata<HilOpticalFlow> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(integrationTimeUs)
    outputBuffer.encodeFloat(integratedX)
    outputBuffer.encodeFloat(integratedY)
    outputBuffer.encodeFloat(integratedXgyro)
    outputBuffer.encodeFloat(integratedYgyro)
    outputBuffer.encodeFloat(integratedZgyro)
    outputBuffer.encodeUInt32(timeDeltaDistanceUs)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUInt8(sensorId)
    outputBuffer.encodeUInt8(quality)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(integrationTimeUs)
    outputBuffer.encodeFloat(integratedX)
    outputBuffer.encodeFloat(integratedY)
    outputBuffer.encodeFloat(integratedXgyro)
    outputBuffer.encodeFloat(integratedYgyro)
    outputBuffer.encodeFloat(integratedZgyro)
    outputBuffer.encodeUInt32(timeDeltaDistanceUs)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeUInt8(sensorId)
    outputBuffer.encodeUInt8(quality)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 114u

    private const val CRC_EXTRA: Byte = -19

    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    private val DESERIALIZER: MavDeserializer<HilOpticalFlow> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val integrationTimeUs = inputBuffer.decodeUInt32()
      val integratedX = inputBuffer.decodeFloat()
      val integratedY = inputBuffer.decodeFloat()
      val integratedXgyro = inputBuffer.decodeFloat()
      val integratedYgyro = inputBuffer.decodeFloat()
      val integratedZgyro = inputBuffer.decodeFloat()
      val timeDeltaDistanceUs = inputBuffer.decodeUInt32()
      val distance = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeInt16()
      val sensorId = inputBuffer.decodeUInt8()
      val quality = inputBuffer.decodeUInt8()

      HilOpticalFlow(
        timeUsec = timeUsec,
        sensorId = sensorId,
        integrationTimeUs = integrationTimeUs,
        integratedX = integratedX,
        integratedY = integratedY,
        integratedXgyro = integratedXgyro,
        integratedYgyro = integratedYgyro,
        integratedZgyro = integratedZgyro,
        temperature = temperature,
        quality = quality,
        timeDeltaDistanceUs = timeDeltaDistanceUs,
        distance = distance,
      )
    }


    private val METADATA: MavMessage.Metadata<HilOpticalFlow> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilOpticalFlow> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HilOpticalFlow =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var sensorId: UByte = 0u

    public var integrationTimeUs: UInt = 0u

    public var integratedX: Float = 0F

    public var integratedY: Float = 0F

    public var integratedXgyro: Float = 0F

    public var integratedYgyro: Float = 0F

    public var integratedZgyro: Float = 0F

    public var temperature: Short = 0

    public var quality: UByte = 0u

    public var timeDeltaDistanceUs: UInt = 0u

    public var distance: Float = 0F

    public fun build(): HilOpticalFlow = HilOpticalFlow(
      timeUsec = timeUsec,
      sensorId = sensorId,
      integrationTimeUs = integrationTimeUs,
      integratedX = integratedX,
      integratedY = integratedY,
      integratedXgyro = integratedXgyro,
      integratedYgyro = integratedYgyro,
      integratedZgyro = integratedZgyro,
      temperature = temperature,
      quality = quality,
      timeDeltaDistanceUs = timeDeltaDistanceUs,
      distance = distance,
    )
  }
}
