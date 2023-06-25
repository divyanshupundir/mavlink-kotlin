package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
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
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<HilSensor> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(xacc)
    buffer.encodeFloat(yacc)
    buffer.encodeFloat(zacc)
    buffer.encodeFloat(xgyro)
    buffer.encodeFloat(ygyro)
    buffer.encodeFloat(zgyro)
    buffer.encodeFloat(xmag)
    buffer.encodeFloat(ymag)
    buffer.encodeFloat(zmag)
    buffer.encodeFloat(absPressure)
    buffer.encodeFloat(diffPressure)
    buffer.encodeFloat(pressureAlt)
    buffer.encodeFloat(temperature)
    buffer.encodeBitmaskValue(fieldsUpdated.value, 4)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(xacc)
    buffer.encodeFloat(yacc)
    buffer.encodeFloat(zacc)
    buffer.encodeFloat(xgyro)
    buffer.encodeFloat(ygyro)
    buffer.encodeFloat(zgyro)
    buffer.encodeFloat(xmag)
    buffer.encodeFloat(ymag)
    buffer.encodeFloat(zmag)
    buffer.encodeFloat(absPressure)
    buffer.encodeFloat(diffPressure)
    buffer.encodeFloat(pressureAlt)
    buffer.encodeFloat(temperature)
    buffer.encodeBitmaskValue(fieldsUpdated.value, 4)
    buffer.encodeUInt8(id)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<HilSensor> {
    public override val id: UInt = 107u

    public override val crcExtra: Byte = 108

    public override fun deserialize(bytes: ByteArray): HilSensor {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val xacc = buffer.decodeFloat()
      val yacc = buffer.decodeFloat()
      val zacc = buffer.decodeFloat()
      val xgyro = buffer.decodeFloat()
      val ygyro = buffer.decodeFloat()
      val zgyro = buffer.decodeFloat()
      val xmag = buffer.decodeFloat()
      val ymag = buffer.decodeFloat()
      val zmag = buffer.decodeFloat()
      val absPressure = buffer.decodeFloat()
      val diffPressure = buffer.decodeFloat()
      val pressureAlt = buffer.decodeFloat()
      val temperature = buffer.decodeFloat()
      val fieldsUpdated = buffer.decodeBitmaskValue(4).let { value ->
        val flags = HilSensorUpdatedFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val id = buffer.decodeUInt8()

      return HilSensor(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): HilSensor =
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
