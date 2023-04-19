package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Superseded by ACTUATOR_OUTPUT_STATUS. The RAW values of the servo outputs (for RC input from the
 * remote, use the RC_CHANNELS messages). The standard PPM modulation is as follows: 1000 microseconds:
 * 0%, 2000 microseconds: 100%.
 */
@GeneratedMavMessage(
  id = 36u,
  crcExtra = -34,
)
public data class ServoOutputRaw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeUsec: UInt = 0u,
  /**
   * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 =
   * MAIN, 1 = AUX.
   */
  @GeneratedMavField(type = "uint8_t")
  public val port: UByte = 0u,
  /**
   * Servo output 1 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo1Raw: UShort = 0u,
  /**
   * Servo output 2 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo2Raw: UShort = 0u,
  /**
   * Servo output 3 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo3Raw: UShort = 0u,
  /**
   * Servo output 4 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo4Raw: UShort = 0u,
  /**
   * Servo output 5 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo5Raw: UShort = 0u,
  /**
   * Servo output 6 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo6Raw: UShort = 0u,
  /**
   * Servo output 7 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo7Raw: UShort = 0u,
  /**
   * Servo output 8 value
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo8Raw: UShort = 0u,
  /**
   * Servo output 9 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo9Raw: UShort = 0u,
  /**
   * Servo output 10 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo10Raw: UShort = 0u,
  /**
   * Servo output 11 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo11Raw: UShort = 0u,
  /**
   * Servo output 12 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo12Raw: UShort = 0u,
  /**
   * Servo output 13 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo13Raw: UShort = 0u,
  /**
   * Servo output 14 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo14Raw: UShort = 0u,
  /**
   * Servo output 15 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo15Raw: UShort = 0u,
  /**
   * Servo output 16 value
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo16Raw: UShort = 0u,
) : MavMessage<ServoOutputRaw> {
  public override val instanceMetadata: MavMessage.Metadata<ServoOutputRaw> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeUsec)
    outputBuffer.encodeUInt16(servo1Raw)
    outputBuffer.encodeUInt16(servo2Raw)
    outputBuffer.encodeUInt16(servo3Raw)
    outputBuffer.encodeUInt16(servo4Raw)
    outputBuffer.encodeUInt16(servo5Raw)
    outputBuffer.encodeUInt16(servo6Raw)
    outputBuffer.encodeUInt16(servo7Raw)
    outputBuffer.encodeUInt16(servo8Raw)
    outputBuffer.encodeUInt8(port)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeUsec)
    outputBuffer.encodeUInt16(servo1Raw)
    outputBuffer.encodeUInt16(servo2Raw)
    outputBuffer.encodeUInt16(servo3Raw)
    outputBuffer.encodeUInt16(servo4Raw)
    outputBuffer.encodeUInt16(servo5Raw)
    outputBuffer.encodeUInt16(servo6Raw)
    outputBuffer.encodeUInt16(servo7Raw)
    outputBuffer.encodeUInt16(servo8Raw)
    outputBuffer.encodeUInt8(port)
    outputBuffer.encodeUInt16(servo9Raw)
    outputBuffer.encodeUInt16(servo10Raw)
    outputBuffer.encodeUInt16(servo11Raw)
    outputBuffer.encodeUInt16(servo12Raw)
    outputBuffer.encodeUInt16(servo13Raw)
    outputBuffer.encodeUInt16(servo14Raw)
    outputBuffer.encodeUInt16(servo15Raw)
    outputBuffer.encodeUInt16(servo16Raw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 36u

    private const val CRC_EXTRA: Byte = -34

    private const val SIZE_V1: Int = 21

    private const val SIZE_V2: Int = 37

    private val DESERIALIZER: MavDeserializer<ServoOutputRaw> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt32()
      val servo1Raw = inputBuffer.decodeUInt16()
      val servo2Raw = inputBuffer.decodeUInt16()
      val servo3Raw = inputBuffer.decodeUInt16()
      val servo4Raw = inputBuffer.decodeUInt16()
      val servo5Raw = inputBuffer.decodeUInt16()
      val servo6Raw = inputBuffer.decodeUInt16()
      val servo7Raw = inputBuffer.decodeUInt16()
      val servo8Raw = inputBuffer.decodeUInt16()
      val port = inputBuffer.decodeUInt8()
      val servo9Raw = inputBuffer.decodeUInt16()
      val servo10Raw = inputBuffer.decodeUInt16()
      val servo11Raw = inputBuffer.decodeUInt16()
      val servo12Raw = inputBuffer.decodeUInt16()
      val servo13Raw = inputBuffer.decodeUInt16()
      val servo14Raw = inputBuffer.decodeUInt16()
      val servo15Raw = inputBuffer.decodeUInt16()
      val servo16Raw = inputBuffer.decodeUInt16()

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


    private val METADATA: MavMessage.Metadata<ServoOutputRaw> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ServoOutputRaw> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ServoOutputRaw =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: UInt = 0u

    public var port: UByte = 0u

    public var servo1Raw: UShort = 0u

    public var servo2Raw: UShort = 0u

    public var servo3Raw: UShort = 0u

    public var servo4Raw: UShort = 0u

    public var servo5Raw: UShort = 0u

    public var servo6Raw: UShort = 0u

    public var servo7Raw: UShort = 0u

    public var servo8Raw: UShort = 0u

    public var servo9Raw: UShort = 0u

    public var servo10Raw: UShort = 0u

    public var servo11Raw: UShort = 0u

    public var servo12Raw: UShort = 0u

    public var servo13Raw: UShort = 0u

    public var servo14Raw: UShort = 0u

    public var servo15Raw: UShort = 0u

    public var servo16Raw: UShort = 0u

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
