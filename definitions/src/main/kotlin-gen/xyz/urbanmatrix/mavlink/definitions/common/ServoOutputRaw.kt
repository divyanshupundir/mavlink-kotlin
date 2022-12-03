package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Superseded by ACTUATOR_OUTPUT_STATUS. The RAW values of the servo outputs (for RC input from the
 * remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds:
 * 0%, 2000 microseconds: 100%.
 */
@GeneratedMavMessage(
  id = 36,
  crc = 222,
)
public data class ServoOutputRaw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeUsec: Long = 0L,
  /**
   * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 =
   * MAIN, 1 = AUX.
   */
  @GeneratedMavField(type = "uint8_t")
  public val port: Int = 0,
  /**
   * Servo output 1 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo1Raw: Int = 0,
  /**
   * Servo output 2 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo2Raw: Int = 0,
  /**
   * Servo output 3 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo3Raw: Int = 0,
  /**
   * Servo output 4 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo4Raw: Int = 0,
  /**
   * Servo output 5 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo5Raw: Int = 0,
  /**
   * Servo output 6 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo6Raw: Int = 0,
  /**
   * Servo output 7 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo7Raw: Int = 0,
  /**
   * Servo output 8 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo8Raw: Int = 0,
  /**
   * Servo output 9 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo9Raw: Int = 0,
  /**
   * Servo output 10 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo10Raw: Int = 0,
  /**
   * Servo output 11 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo11Raw: Int = 0,
  /**
   * Servo output 12 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo12Raw: Int = 0,
  /**
   * Servo output 13 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo13Raw: Int = 0,
  /**
   * Servo output 14 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo14Raw: Int = 0,
  /**
   * Servo output 15 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo15Raw: Int = 0,
  /**
   * Servo output 16 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo16Raw: Int = 0,
) : MavMessage<ServoOutputRaw> {
  public override val instanceMetadata: MavMessage.Metadata<ServoOutputRaw> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 36

    private const val CRC: Int = 222

    private const val SIZE_V1: Int = 21

    private const val SIZE_V2: Int = 37

    private val DESERIALIZER: MavDeserializer<ServoOutputRaw> = MavDeserializer { bytes ->
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

    public fun builder(builderAction: Builder.() -> Unit): ServoOutputRaw =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: Long = 0L

    public var port: Int = 0

    public var servo1Raw: Int = 0

    public var servo2Raw: Int = 0

    public var servo3Raw: Int = 0

    public var servo4Raw: Int = 0

    public var servo5Raw: Int = 0

    public var servo6Raw: Int = 0

    public var servo7Raw: Int = 0

    public var servo8Raw: Int = 0

    public var servo9Raw: Int = 0

    public var servo10Raw: Int = 0

    public var servo11Raw: Int = 0

    public var servo12Raw: Int = 0

    public var servo13Raw: Int = 0

    public var servo14Raw: Int = 0

    public var servo15Raw: Int = 0

    public var servo16Raw: Int = 0

    public fun build(): ServoOutputRaw = ServoOutputRaw(
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
}
