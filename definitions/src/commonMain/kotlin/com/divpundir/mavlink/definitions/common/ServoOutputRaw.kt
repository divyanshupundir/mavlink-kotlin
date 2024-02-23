package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param port Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk
 * should use: 0 = MAIN, 1 = AUX.
 * @param servo1Raw Servo output 1 value
 * units = us
 * @param servo2Raw Servo output 2 value
 * units = us
 * @param servo3Raw Servo output 3 value
 * units = us
 * @param servo4Raw Servo output 4 value
 * units = us
 * @param servo5Raw Servo output 5 value
 * units = us
 * @param servo6Raw Servo output 6 value
 * units = us
 * @param servo7Raw Servo output 7 value
 * units = us
 * @param servo8Raw Servo output 8 value
 * units = us
 * @param servo9Raw Servo output 9 value
 * units = us
 * @param servo10Raw Servo output 10 value
 * units = us
 * @param servo11Raw Servo output 11 value
 * units = us
 * @param servo12Raw Servo output 12 value
 * units = us
 * @param servo13Raw Servo output 13 value
 * units = us
 * @param servo14Raw Servo output 14 value
 * units = us
 * @param servo15Raw Servo output 15 value
 * units = us
 * @param servo16Raw Servo output 16 value
 * units = us
 */
@GeneratedMavMessage(
  id = 36u,
  crcExtra = -34,
)
public data class ServoOutputRaw(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo1Raw: UShort = 0u,
  /**
   * Servo output 2 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo2Raw: UShort = 0u,
  /**
   * Servo output 3 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo3Raw: UShort = 0u,
  /**
   * Servo output 4 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo4Raw: UShort = 0u,
  /**
   * Servo output 5 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo5Raw: UShort = 0u,
  /**
   * Servo output 6 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo6Raw: UShort = 0u,
  /**
   * Servo output 7 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo7Raw: UShort = 0u,
  /**
   * Servo output 8 value
   * units = us
   */
  @GeneratedMavField(type = "uint16_t")
  public val servo8Raw: UShort = 0u,
  /**
   * Servo output 9 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo9Raw: UShort = 0u,
  /**
   * Servo output 10 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo10Raw: UShort = 0u,
  /**
   * Servo output 11 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo11Raw: UShort = 0u,
  /**
   * Servo output 12 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo12Raw: UShort = 0u,
  /**
   * Servo output 13 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo13Raw: UShort = 0u,
  /**
   * Servo output 14 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo14Raw: UShort = 0u,
  /**
   * Servo output 15 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo15Raw: UShort = 0u,
  /**
   * Servo output 16 value
   * units = us
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val servo16Raw: UShort = 0u,
) : MavMessage<ServoOutputRaw> {
  override val instanceCompanion: MavMessage.MavCompanion<ServoOutputRaw> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeUsec)
    encoder.encodeUInt16(servo1Raw)
    encoder.encodeUInt16(servo2Raw)
    encoder.encodeUInt16(servo3Raw)
    encoder.encodeUInt16(servo4Raw)
    encoder.encodeUInt16(servo5Raw)
    encoder.encodeUInt16(servo6Raw)
    encoder.encodeUInt16(servo7Raw)
    encoder.encodeUInt16(servo8Raw)
    encoder.encodeUInt8(port)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeUsec)
    encoder.encodeUInt16(servo1Raw)
    encoder.encodeUInt16(servo2Raw)
    encoder.encodeUInt16(servo3Raw)
    encoder.encodeUInt16(servo4Raw)
    encoder.encodeUInt16(servo5Raw)
    encoder.encodeUInt16(servo6Raw)
    encoder.encodeUInt16(servo7Raw)
    encoder.encodeUInt16(servo8Raw)
    encoder.encodeUInt8(port)
    encoder.encodeUInt16(servo9Raw)
    encoder.encodeUInt16(servo10Raw)
    encoder.encodeUInt16(servo11Raw)
    encoder.encodeUInt16(servo12Raw)
    encoder.encodeUInt16(servo13Raw)
    encoder.encodeUInt16(servo14Raw)
    encoder.encodeUInt16(servo15Raw)
    encoder.encodeUInt16(servo16Raw)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ServoOutputRaw> {
    private const val SIZE_V1: Int = 21

    private const val SIZE_V2: Int = 37

    override val id: UInt = 36u

    override val crcExtra: Byte = -34

    override fun deserialize(bytes: ByteArray): ServoOutputRaw {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt32()
      val servo1Raw = decoder.safeDecodeUInt16()
      val servo2Raw = decoder.safeDecodeUInt16()
      val servo3Raw = decoder.safeDecodeUInt16()
      val servo4Raw = decoder.safeDecodeUInt16()
      val servo5Raw = decoder.safeDecodeUInt16()
      val servo6Raw = decoder.safeDecodeUInt16()
      val servo7Raw = decoder.safeDecodeUInt16()
      val servo8Raw = decoder.safeDecodeUInt16()
      val port = decoder.safeDecodeUInt8()
      val servo9Raw = decoder.safeDecodeUInt16()
      val servo10Raw = decoder.safeDecodeUInt16()
      val servo11Raw = decoder.safeDecodeUInt16()
      val servo12Raw = decoder.safeDecodeUInt16()
      val servo13Raw = decoder.safeDecodeUInt16()
      val servo14Raw = decoder.safeDecodeUInt16()
      val servo15Raw = decoder.safeDecodeUInt16()
      val servo16Raw = decoder.safeDecodeUInt16()

      return ServoOutputRaw(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): ServoOutputRaw =
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
