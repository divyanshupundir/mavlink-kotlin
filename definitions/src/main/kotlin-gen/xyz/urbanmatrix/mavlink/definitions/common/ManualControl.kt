package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * This message provides an API for manually controlling the vehicle using standard joystick axes
 * nomenclature, along with a joystick-like input device. Unused axes can be disabled and buttons
 * states are transmitted as individual on/off bits of a bitmask
 */
@GeneratedMavMessage(
  id = 69,
  crc = 243,
)
public data class ManualControl(
  /**
   * The system to be controlled.
   */
  @GeneratedMavField(type = "uint8_t")
  public val target: Int = 0,
  /**
   * X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and the
   * pitch of a vehicle.
   */
  @GeneratedMavField(type = "int16_t")
  public val x: Int = 0,
  /**
   * Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the roll of a
   * vehicle.
   */
  @GeneratedMavField(type = "int16_t")
  public val y: Int = 0,
  /**
   * Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to a separate slider movement with maximum being 1000 and minimum
   * being -1000 on a joystick and the thrust of a vehicle. Positive values are positive thrust,
   * negative values are negative thrust.
   */
  @GeneratedMavField(type = "int16_t")
  public val z: Int = 0,
  /**
   * R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 1000
   * and clockwise being -1000, and the yaw of a vehicle.
   */
  @GeneratedMavField(type = "int16_t")
  public val r: Int = 0,
  /**
   * A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for pressed, 0 for
   * released. The lowest bit corresponds to Button 1.
   */
  @GeneratedMavField(type = "uint16_t")
  public val buttons: Int = 0,
  /**
   * A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for pressed, 0 for
   * released. The lowest bit corresponds to Button 16.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val buttons2: Int = 0,
  /**
   * Set bits to 1 to indicate which of the following extension fields contain valid data: bit 0:
   * pitch, bit 1: roll.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val enabledExtensions: Int = 0,
  /**
   * Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on
   * vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is set.
   * Set to 0 if invalid.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val s: Int = 0,
  /**
   * Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on vehicles
   * with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is set. Set to 0 if
   * invalid.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val t: Int = 0,
) : MavMessage<ManualControl> {
  public override val instanceMetadata: MavMessage.Metadata<ManualControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(x)
    outputBuffer.encodeInt16(y)
    outputBuffer.encodeInt16(z)
    outputBuffer.encodeInt16(r)
    outputBuffer.encodeUint16(buttons)
    outputBuffer.encodeUint8(target)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeInt16(x)
    outputBuffer.encodeInt16(y)
    outputBuffer.encodeInt16(z)
    outputBuffer.encodeInt16(r)
    outputBuffer.encodeUint16(buttons)
    outputBuffer.encodeUint8(target)
    outputBuffer.encodeUint16(buttons2)
    outputBuffer.encodeUint8(enabledExtensions)
    outputBuffer.encodeInt16(s)
    outputBuffer.encodeInt16(t)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 69

    private const val CRC: Int = 243

    private const val SIZE: Int = 18

    private val DESERIALIZER: MavDeserializer<ManualControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val x = inputBuffer.decodeInt16()
      val y = inputBuffer.decodeInt16()
      val z = inputBuffer.decodeInt16()
      val r = inputBuffer.decodeInt16()
      val buttons = inputBuffer.decodeUint16()
      val target = inputBuffer.decodeUint8()
      val buttons2 = inputBuffer.decodeUint16()
      val enabledExtensions = inputBuffer.decodeUint8()
      val s = inputBuffer.decodeInt16()
      val t = inputBuffer.decodeInt16()

      ManualControl(
        target = target,
        x = x,
        y = y,
        z = z,
        r = r,
        buttons = buttons,
        buttons2 = buttons2,
        enabledExtensions = enabledExtensions,
        s = s,
        t = t,
      )
    }


    private val METADATA: MavMessage.Metadata<ManualControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ManualControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var target: Int = 0

    public var x: Int = 0

    public var y: Int = 0

    public var z: Int = 0

    public var r: Int = 0

    public var buttons: Int = 0

    public var buttons2: Int = 0

    public var enabledExtensions: Int = 0

    public var s: Int = 0

    public var t: Int = 0

    public fun build(): ManualControl = ManualControl(
      target = target,
      x = x,
      y = y,
      z = z,
      r = r,
      buttons = buttons,
      buttons2 = buttons2,
      enabledExtensions = enabledExtensions,
      s = s,
      t = t,
    )
  }
}
