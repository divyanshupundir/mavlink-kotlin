package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * The RAW IMU readings for secondary 9DOF sensor setup. This message should contain the scaled
 * values to the described units
 */
@GeneratedMavMessage(
  id = 116,
  crc = 76,
)
public data class ScaledImu2(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * X acceleration
   */
  public val xacc: Int = 0,
  /**
   * Y acceleration
   */
  public val yacc: Int = 0,
  /**
   * Z acceleration
   */
  public val zacc: Int = 0,
  /**
   * Angular speed around X axis
   */
  public val xgyro: Int = 0,
  /**
   * Angular speed around Y axis
   */
  public val ygyro: Int = 0,
  /**
   * Angular speed around Z axis
   */
  public val zgyro: Int = 0,
  /**
   * X Magnetic field
   */
  public val xmag: Int = 0,
  /**
   * Y Magnetic field
   */
  public val ymag: Int = 0,
  /**
   * Z Magnetic field
   */
  public val zmag: Int = 0,
  /**
   * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1
   * (0.01C).
   */
  public val temperature: Int = 0,
) : MavMessage<ScaledImu2> {
  public override val instanceMetadata: MavMessage.Metadata<ScaledImu2> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeInt16(xacc)
    outputBuffer.encodeInt16(yacc)
    outputBuffer.encodeInt16(zacc)
    outputBuffer.encodeInt16(xgyro)
    outputBuffer.encodeInt16(ygyro)
    outputBuffer.encodeInt16(zgyro)
    outputBuffer.encodeInt16(xmag)
    outputBuffer.encodeInt16(ymag)
    outputBuffer.encodeInt16(zmag)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 116

    private const val CRC: Int = 76

    private const val SIZE: Int = 24

    private val DESERIALIZER: MavDeserializer<ScaledImu2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val xacc = inputBuffer.decodeInt16()
      val yacc = inputBuffer.decodeInt16()
      val zacc = inputBuffer.decodeInt16()
      val xgyro = inputBuffer.decodeInt16()
      val ygyro = inputBuffer.decodeInt16()
      val zgyro = inputBuffer.decodeInt16()
      val xmag = inputBuffer.decodeInt16()
      val ymag = inputBuffer.decodeInt16()
      val zmag = inputBuffer.decodeInt16()
      val temperature = inputBuffer.decodeInt16()

      ScaledImu2(
        timeBootMs = timeBootMs,
        xacc = xacc,
        yacc = yacc,
        zacc = zacc,
        xgyro = xgyro,
        ygyro = ygyro,
        zgyro = zgyro,
        xmag = xmag,
        ymag = ymag,
        zmag = zmag,
        temperature = temperature,
      )
    }


    private val METADATA: MavMessage.Metadata<ScaledImu2> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScaledImu2> = METADATA
  }
}
