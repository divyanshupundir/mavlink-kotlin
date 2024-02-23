package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Simulated optical flow from a flow sensor (e.g. PX4FLOW or optical mouse sensor)
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param sensorId Sensor ID
 * @param integrationTimeUs Integration time. Divide integrated_x and integrated_y by the
 * integration time to obtain average flow. The integration time also indicates the.
 * units = us
 * @param integratedX Flow in radians around X axis (Sensor RH rotation about the X axis induces a
 * positive flow. Sensor linear motion along the positive Y axis induces a negative flow.)
 * units = rad
 * @param integratedY Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a
 * positive flow. Sensor linear motion along the positive X axis induces a positive flow.)
 * units = rad
 * @param integratedXgyro RH rotation around X axis
 * units = rad
 * @param integratedYgyro RH rotation around Y axis
 * units = rad
 * @param integratedZgyro RH rotation around Z axis
 * units = rad
 * @param temperature Temperature
 * units = cdegC
 * @param quality Optical flow quality / confidence. 0: no valid flow, 255: maximum quality
 * @param timeDeltaDistanceUs Time since the distance was sampled.
 * units = us
 * @param distance Distance to the center of the flow field. Positive value (including zero):
 * distance known. Negative value: Unknown distance.
 * units = m
 */
@GeneratedMavMessage(
  id = 114u,
  crcExtra = -19,
)
public data class HilOpticalFlow(
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
   * Integration time. Divide integrated_x and integrated_y by the integration time to obtain
   * average flow. The integration time also indicates the.
   * units = us
   */
  @GeneratedMavField(type = "uint32_t")
  public val integrationTimeUs: UInt = 0u,
  /**
   * Flow in radians around X axis (Sensor RH rotation about the X axis induces a positive flow.
   * Sensor linear motion along the positive Y axis induces a negative flow.)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val integratedX: Float = 0F,
  /**
   * Flow in radians around Y axis (Sensor RH rotation about the Y axis induces a positive flow.
   * Sensor linear motion along the positive X axis induces a positive flow.)
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val integratedY: Float = 0F,
  /**
   * RH rotation around X axis
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val integratedXgyro: Float = 0F,
  /**
   * RH rotation around Y axis
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val integratedYgyro: Float = 0F,
  /**
   * RH rotation around Z axis
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val integratedZgyro: Float = 0F,
  /**
   * Temperature
   * units = cdegC
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
   * units = us
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeDeltaDistanceUs: UInt = 0u,
  /**
   * Distance to the center of the flow field. Positive value (including zero): distance known.
   * Negative value: Unknown distance.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
) : MavMessage<HilOpticalFlow> {
  override val instanceCompanion: MavMessage.MavCompanion<HilOpticalFlow> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(integrationTimeUs)
    encoder.encodeFloat(integratedX)
    encoder.encodeFloat(integratedY)
    encoder.encodeFloat(integratedXgyro)
    encoder.encodeFloat(integratedYgyro)
    encoder.encodeFloat(integratedZgyro)
    encoder.encodeUInt32(timeDeltaDistanceUs)
    encoder.encodeFloat(distance)
    encoder.encodeInt16(temperature)
    encoder.encodeUInt8(sensorId)
    encoder.encodeUInt8(quality)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(integrationTimeUs)
    encoder.encodeFloat(integratedX)
    encoder.encodeFloat(integratedY)
    encoder.encodeFloat(integratedXgyro)
    encoder.encodeFloat(integratedYgyro)
    encoder.encodeFloat(integratedZgyro)
    encoder.encodeUInt32(timeDeltaDistanceUs)
    encoder.encodeFloat(distance)
    encoder.encodeInt16(temperature)
    encoder.encodeUInt8(sensorId)
    encoder.encodeUInt8(quality)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilOpticalFlow> {
    private const val SIZE_V1: Int = 44

    private const val SIZE_V2: Int = 44

    override val id: UInt = 114u

    override val crcExtra: Byte = -19

    override fun deserialize(bytes: ByteArray): HilOpticalFlow {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val integrationTimeUs = decoder.safeDecodeUInt32()
      val integratedX = decoder.safeDecodeFloat()
      val integratedY = decoder.safeDecodeFloat()
      val integratedXgyro = decoder.safeDecodeFloat()
      val integratedYgyro = decoder.safeDecodeFloat()
      val integratedZgyro = decoder.safeDecodeFloat()
      val timeDeltaDistanceUs = decoder.safeDecodeUInt32()
      val distance = decoder.safeDecodeFloat()
      val temperature = decoder.safeDecodeInt16()
      val sensorId = decoder.safeDecodeUInt8()
      val quality = decoder.safeDecodeUInt8()

      return HilOpticalFlow(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): HilOpticalFlow =
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
