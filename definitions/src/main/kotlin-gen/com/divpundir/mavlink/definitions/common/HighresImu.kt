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
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * The IMU readings in SI units in NED body frame
 */
@GeneratedMavMessage(
  id = 105u,
  crcExtra = 93,
)
public data class HighresImu(
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
   * Angular speed around X axis
   */
  @GeneratedMavField(type = "float")
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   */
  @GeneratedMavField(type = "float")
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
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
   * Differential pressure
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
  @GeneratedMavField(type = "uint16_t")
  public val fieldsUpdated: MavBitmaskValue<HighresImuUpdatedFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with
   * id=0)
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val id: UByte = 0u,
) : MavMessage<HighresImu> {
  public override val instanceCompanion: MavMessage.MavCompanion<HighresImu> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(xacc)
    output.encodeFloat(yacc)
    output.encodeFloat(zacc)
    output.encodeFloat(xgyro)
    output.encodeFloat(ygyro)
    output.encodeFloat(zgyro)
    output.encodeFloat(xmag)
    output.encodeFloat(ymag)
    output.encodeFloat(zmag)
    output.encodeFloat(absPressure)
    output.encodeFloat(diffPressure)
    output.encodeFloat(pressureAlt)
    output.encodeFloat(temperature)
    output.encodeBitmaskValue(fieldsUpdated.value, 2)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(xacc)
    output.encodeFloat(yacc)
    output.encodeFloat(zacc)
    output.encodeFloat(xgyro)
    output.encodeFloat(ygyro)
    output.encodeFloat(zgyro)
    output.encodeFloat(xmag)
    output.encodeFloat(ymag)
    output.encodeFloat(zmag)
    output.encodeFloat(absPressure)
    output.encodeFloat(diffPressure)
    output.encodeFloat(pressureAlt)
    output.encodeFloat(temperature)
    output.encodeBitmaskValue(fieldsUpdated.value, 2)
    output.encodeUInt8(id)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<HighresImu> {
    private const val SIZE_V1: Int = 62

    private const val SIZE_V2: Int = 63

    public override val id: UInt = 105u

    public override val crcExtra: Byte = 93

    public override fun deserialize(source: BufferedSource): HighresImu {
      val timeUsec = source.decodeUInt64()
      val xacc = source.decodeFloat()
      val yacc = source.decodeFloat()
      val zacc = source.decodeFloat()
      val xgyro = source.decodeFloat()
      val ygyro = source.decodeFloat()
      val zgyro = source.decodeFloat()
      val xmag = source.decodeFloat()
      val ymag = source.decodeFloat()
      val zmag = source.decodeFloat()
      val absPressure = source.decodeFloat()
      val diffPressure = source.decodeFloat()
      val pressureAlt = source.decodeFloat()
      val temperature = source.decodeFloat()
      val fieldsUpdated = source.decodeBitmaskValue(2).let { value ->
        val flags = HighresImuUpdatedFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val id = source.decodeUInt8()

      return HighresImu(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): HighresImu =
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

    public var fieldsUpdated: MavBitmaskValue<HighresImuUpdatedFlags> =
        MavBitmaskValue.fromValue(0u)

    public var id: UByte = 0u

    public fun build(): HighresImu = HighresImu(
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
