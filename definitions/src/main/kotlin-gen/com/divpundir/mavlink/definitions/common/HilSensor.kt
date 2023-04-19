package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * The IMU readings in SI units in NED body frame
 */
@GeneratedMavMessage(
  id = 107u,
  crcExtra = 108,
)
public data class HilSensor(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * X acceleration
   */
  @GeneratedMavField(type = "float")
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   */
  @GeneratedMavField(type = "float")
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   */
  @GeneratedMavField(type = "float")
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis in body frame
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis in body frame
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis in body frame
   */
  @GeneratedMavField(type = "float")
  public val zgyro: Float = 0F,
  /**
   * X Magnetic field
   */
  @GeneratedMavField(type = "float")
  public val xmag: Float = 0F,
  /**
   * Y Magnetic field
   */
  @GeneratedMavField(type = "float")
  public val ymag: Float = 0F,
  /**
   * Z Magnetic field
   */
  @GeneratedMavField(type = "float")
  public val zmag: Float = 0F,
  /**
   * Absolute pressure
   */
  @GeneratedMavField(type = "float")
  public val absPressure: Float = 0F,
  /**
   * Differential pressure (airspeed)
   */
  @GeneratedMavField(type = "float")
  public val diffPressure: Float = 0F,
  /**
   * Altitude calculated from pressure
   */
  @GeneratedMavField(type = "float")
  public val pressureAlt: Float = 0F,
  /**
   * Temperature
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
  /**
   * Bitmap for fields that have updated since last message
   */
  @GeneratedMavField(type = "uint32_t")
  public val fieldsUpdated: MavBitmaskValue<HilSensorUpdatedFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Sensor ID (zero indexed). Used for multiple sensor inputs
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
) : MavMessage<HilSensor> {
  public override val instanceMetadata: MavMessage.Metadata<HilSensor> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    outputBuffer.encodeFloat(xmag)
    outputBuffer.encodeFloat(ymag)
    outputBuffer.encodeFloat(zmag)
    outputBuffer.encodeFloat(absPressure)
    outputBuffer.encodeFloat(diffPressure)
    outputBuffer.encodeFloat(pressureAlt)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeBitmaskValue(fieldsUpdated.value, 4)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(xacc)
    outputBuffer.encodeFloat(yacc)
    outputBuffer.encodeFloat(zacc)
    outputBuffer.encodeFloat(xgyro)
    outputBuffer.encodeFloat(ygyro)
    outputBuffer.encodeFloat(zgyro)
    outputBuffer.encodeFloat(xmag)
    outputBuffer.encodeFloat(ymag)
    outputBuffer.encodeFloat(zmag)
    outputBuffer.encodeFloat(absPressure)
    outputBuffer.encodeFloat(diffPressure)
    outputBuffer.encodeFloat(pressureAlt)
    outputBuffer.encodeFloat(temperature)
    outputBuffer.encodeBitmaskValue(fieldsUpdated.value, 4)
    outputBuffer.encodeUInt8(id)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 107u

    private const val CRC_EXTRA: Byte = 108

    private const val SIZE_V1: Int = 64

    private const val SIZE_V2: Int = 65

    private val DESERIALIZER: MavDeserializer<HilSensor> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val xacc = inputBuffer.decodeFloat()
      val yacc = inputBuffer.decodeFloat()
      val zacc = inputBuffer.decodeFloat()
      val xgyro = inputBuffer.decodeFloat()
      val ygyro = inputBuffer.decodeFloat()
      val zgyro = inputBuffer.decodeFloat()
      val xmag = inputBuffer.decodeFloat()
      val ymag = inputBuffer.decodeFloat()
      val zmag = inputBuffer.decodeFloat()
      val absPressure = inputBuffer.decodeFloat()
      val diffPressure = inputBuffer.decodeFloat()
      val pressureAlt = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeFloat()
      val fieldsUpdated = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = HilSensorUpdatedFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val id = inputBuffer.decodeUInt8()

      HilSensor(
        timeUsec = timeUsec,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        xmag = xmag,
        ymag = ymag,
        zmag = zmag,
        absPressure = absPressure,
        diffPressure = diffPressure,
        pressureAlt = pressureAlt,
        temperature = temperature,
        fieldsUpdated = fieldsUpdated,
        id = id,
      )
    }


    private val METADATA: MavMessage.Metadata<HilSensor> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HilSensor> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): HilSensor =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var xacc: Float = 0F

    public var yacc: Float = 0F

    public var zacc: Float = 0F

    public var xgyro: Float = 0F

    public var ygyro: Float = 0F

    public var zgyro: Float = 0F

    public var xmag: Float = 0F

    public var ymag: Float = 0F

    public var zmag: Float = 0F

    public var absPressure: Float = 0F

    public var diffPressure: Float = 0F

    public var pressureAlt: Float = 0F

    public var temperature: Float = 0F

    public var fieldsUpdated: MavBitmaskValue<HilSensorUpdatedFlags> = MavBitmaskValue.fromValue(0u)

    public var id: UByte = 0u

    public fun build(): HilSensor = HilSensor(
      timeUsec = timeUsec,
      xacc = xacc,
      yacc = yacc,
      zacc = zacc,
      xgyro = xgyro,
      ygyro = ygyro,
      zgyro = zgyro,
      xmag = xmag,
      ymag = ymag,
      zmag = zmag,
      absPressure = absPressure,
      diffPressure = diffPressure,
      pressureAlt = pressureAlt,
      temperature = temperature,
      fieldsUpdated = fieldsUpdated,
      id = id,
    )
  }
}
