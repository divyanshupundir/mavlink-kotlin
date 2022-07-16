package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long

/**
 * Superseded by ACTUATOR_OUTPUT_STATUS. The RAW values of the servo outputs (for RC input from the
 * remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds:
 * 0%, 2000 microseconds: 100%.
 */
public data class ServoOutputRaw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: Long = 0L,
  /**
   * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 =
   * MAIN, 1 = AUX.
   */
  public val port: Int = 0,
  /**
   * Servo output 1 value
   */
  public val servo1Raw: Int = 0,
  /**
   * Servo output 2 value
   */
  public val servo2Raw: Int = 0,
  /**
   * Servo output 3 value
   */
  public val servo3Raw: Int = 0,
  /**
   * Servo output 4 value
   */
  public val servo4Raw: Int = 0,
  /**
   * Servo output 5 value
   */
  public val servo5Raw: Int = 0,
  /**
   * Servo output 6 value
   */
  public val servo6Raw: Int = 0,
  /**
   * Servo output 7 value
   */
  public val servo7Raw: Int = 0,
  /**
   * Servo output 8 value
   */
  public val servo8Raw: Int = 0,
  /**
   * Servo output 9 value
   */
  public val servo9Raw: Int = 0,
  /**
   * Servo output 10 value
   */
  public val servo10Raw: Int = 0,
  /**
   * Servo output 11 value
   */
  public val servo11Raw: Int = 0,
  /**
   * Servo output 12 value
   */
  public val servo12Raw: Int = 0,
  /**
   * Servo output 13 value
   */
  public val servo13Raw: Int = 0,
  /**
   * Servo output 14 value
   */
  public val servo14Raw: Int = 0,
  /**
   * Servo output 15 value
   */
  public val servo15Raw: Int = 0,
  /**
   * Servo output 16 value
   */
  public val servo16Raw: Int = 0,
) : MavMessage<ServoOutputRaw> {
  public override val instanceMetadata: MavMessage.Metadata<ServoOutputRaw> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeUsec)
    outputBuffer.encodeUint16(servo1Raw)
    outputBuffer.encodeUint16(servo2Raw)
    outputBuffer.encodeUint16(servo3Raw)
    outputBuffer.encodeUint16(servo4Raw)
    outputBuffer.encodeUint16(servo5Raw)
    outputBuffer.encodeUint16(servo6Raw)
    outputBuffer.encodeUint16(servo7Raw)
    outputBuffer.encodeUint16(servo8Raw)
    outputBuffer.encodeUint8(port)
    outputBuffer.encodeUint16(servo9Raw)
    outputBuffer.encodeUint16(servo10Raw)
    outputBuffer.encodeUint16(servo11Raw)
    outputBuffer.encodeUint16(servo12Raw)
    outputBuffer.encodeUint16(servo13Raw)
    outputBuffer.encodeUint16(servo14Raw)
    outputBuffer.encodeUint16(servo15Raw)
    outputBuffer.encodeUint16(servo16Raw)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 36

    private const val CRC: Int = 222

    private const val SIZE: Int = 37

    private val DESERIALIZER: MavDeserializer<ServoOutputRaw> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for ServoOutputRaw: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint32()
      val servo1Raw = inputBuffer.decodeUint16()
      val servo2Raw = inputBuffer.decodeUint16()
      val servo3Raw = inputBuffer.decodeUint16()
      val servo4Raw = inputBuffer.decodeUint16()
      val servo5Raw = inputBuffer.decodeUint16()
      val servo6Raw = inputBuffer.decodeUint16()
      val servo7Raw = inputBuffer.decodeUint16()
      val servo8Raw = inputBuffer.decodeUint16()
      val port = inputBuffer.decodeUint8()
      val servo9Raw = inputBuffer.decodeUint16()
      val servo10Raw = inputBuffer.decodeUint16()
      val servo11Raw = inputBuffer.decodeUint16()
      val servo12Raw = inputBuffer.decodeUint16()
      val servo13Raw = inputBuffer.decodeUint16()
      val servo14Raw = inputBuffer.decodeUint16()
      val servo15Raw = inputBuffer.decodeUint16()
      val servo16Raw = inputBuffer.decodeUint16()

      ServoOutputRaw(
        timeUsec = timeUsec,
        port = port,
        servo1Raw = servo1Raw,
        servo2Raw = servo2Raw,
        servo3Raw = servo3Raw,
        servo4Raw = servo4Raw,
        servo5Raw = servo5Raw,
        servo6Raw = servo6Raw,
        servo7Raw = servo7Raw,
        servo8Raw = servo8Raw,
        servo9Raw = servo9Raw,
        servo10Raw = servo10Raw,
        servo11Raw = servo11Raw,
        servo12Raw = servo12Raw,
        servo13Raw = servo13Raw,
        servo14Raw = servo14Raw,
        servo15Raw = servo15Raw,
        servo16Raw = servo16Raw,
      )
    }


    private val METADATA: MavMessage.Metadata<ServoOutputRaw> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ServoOutputRaw> = METADATA
  }
}
