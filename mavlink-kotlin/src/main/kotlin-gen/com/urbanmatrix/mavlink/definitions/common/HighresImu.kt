package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * The IMU readings in SI units in NED body frame
 */
public data class HighresImu(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * X acceleration
   */
  public val xacc: Float = 0F,
  /**
   * Y acceleration
   */
  public val yacc: Float = 0F,
  /**
   * Z acceleration
   */
  public val zacc: Float = 0F,
  /**
   * Angular speed around X axis
   */
  public val xgyro: Float = 0F,
  /**
   * Angular speed around Y axis
   */
  public val ygyro: Float = 0F,
  /**
   * Angular speed around Z axis
   */
  public val zgyro: Float = 0F,
  /**
   * X Magnetic field
   */
  public val xmag: Float = 0F,
  /**
   * Y Magnetic field
   */
  public val ymag: Float = 0F,
  /**
   * Z Magnetic field
   */
  public val zmag: Float = 0F,
  /**
   * Absolute pressure
   */
  public val absPressure: Float = 0F,
  /**
   * Differential pressure
   */
  public val diffPressure: Float = 0F,
  /**
   * Altitude calculated from pressure
   */
  public val pressureAlt: Float = 0F,
  /**
   * Temperature
   */
  public val temperature: Float = 0F,
  /**
   * Bitmap for fields that have updated since last message
   */
  public val fieldsUpdated: MavEnumValue<HighresImuUpdatedFlags> = MavEnumValue.fromValue(0),
  /**
   * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with
   * id=0)
   */
  public val id: Int = 0,
) : MavMessage<HighresImu> {
  public override val instanceMetadata: MavMessage.Metadata<HighresImu> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
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
    outputBuffer.encodeEnumValue(fieldsUpdated.value, 2)
    outputBuffer.encodeUint8(id)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 105

    private const val CRC: Int = 93

    private const val SIZE: Int = 63

    private val DESERIALIZER: MavDeserializer<HighresImu> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
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
      val fieldsUpdated = inputBuffer.decodeEnumValue(2).let { value ->
        val entry = HighresImuUpdatedFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val id = inputBuffer.decodeUint8()

      HighresImu(
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


    private val METADATA: MavMessage.Metadata<HighresImu> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<HighresImu> = METADATA
  }
}
