package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
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
 * Optical flow from an angular rate flow sensor (e.g. PX4FLOW or mouse sensor)
 */
@GeneratedMavMessage(
  id = 106u,
  crcExtra = -118,
)
public data class OpticalFlowRad(
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
   * Flow around X axis (Sensor RH rotation about the X axis induces a positive flow. Sensor linear
   * motion along the positive Y axis induces a negative flow.)
   */
  @GeneratedMavField(type = "float")
  public val integratedX: Float = 0F,
  /**
   * Flow around Y axis (Sensor RH rotation about the Y axis induces a positive flow. Sensor linear
   * motion along the positive X axis induces a positive flow.)
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
) : MavMessage<OpticalFlowRad> {
  public override val instanceCompanion: MavMessage.MavCompanion<OpticalFlowRad> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt32(integrationTimeUs)
    buffer.encodeFloat(integratedX)
    buffer.encodeFloat(integratedY)
    buffer.encodeFloat(integratedXgyro)
    buffer.encodeFloat(integratedYgyro)
    buffer.encodeFloat(integratedZgyro)
    buffer.encodeUInt32(timeDeltaDistanceUs)
    buffer.encodeFloat(distance)
    buffer.encodeInt16(temperature)
    buffer.encodeUInt8(sensorId)
    buffer.encodeUInt8(quality)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeUInt32(integrationTimeUs)
    buffer.encodeFloat(integratedX)
    buffer.encodeFloat(integratedY)
    buffer.encodeFloat(integratedXgyro)
    buffer.encodeFloat(integratedYgyro)
    buffer.encodeFloat(integratedZgyro)
    buffer.encodeUInt32(timeDeltaDistanceUs)
    buffer.encodeFloat(distance)
    buffer.encodeInt16(temperature)
    buffer.encodeUInt8(sensorId)
    buffer.encodeUInt8(quality)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OpticalFlowRad> {
    public override val id: UInt = 106u

    public override val crcExtra: Byte = -118

    public override fun deserialize(bytes: ByteArray): OpticalFlowRad {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val integrationTimeUs = buffer.decodeUInt32()
      val integratedX = buffer.decodeFloat()
      val integratedY = buffer.decodeFloat()
      val integratedXgyro = buffer.decodeFloat()
      val integratedYgyro = buffer.decodeFloat()
      val integratedZgyro = buffer.decodeFloat()
      val timeDeltaDistanceUs = buffer.decodeUInt32()
      val distance = buffer.decodeFloat()
      val temperature = buffer.decodeInt16()
      val sensorId = buffer.decodeUInt8()
      val quality = buffer.decodeUInt8()

      return OpticalFlowRad(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): OpticalFlowRad =
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

    public fun build(): OpticalFlowRad = OpticalFlowRad(
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
