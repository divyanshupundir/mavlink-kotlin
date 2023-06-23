package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * This message provides an API for manually controlling the vehicle using standard joystick axes
 * nomenclature, along with a joystick-like input device. Unused axes can be disabled and buttons
 * states are transmitted as individual on/off bits of a bitmask
 */
@GeneratedMavMessage(
  id = 69u,
  crcExtra = -13,
)
public data class ManualControl(
  /**
   * The system to be controlled.
   */
  @GeneratedMavField(type = "uint8_t")
  public val target: UByte = 0u,
  /**
   * X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and the
   * pitch of a vehicle.
   */
  @GeneratedMavField(type = "int16_t")
  public val x: Short = 0,
  /**
   * Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the roll of a
   * vehicle.
   */
  @GeneratedMavField(type = "int16_t")
  public val y: Short = 0,
  /**
   * Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to a separate slider movement with maximum being 1000 and minimum
   * being -1000 on a joystick and the thrust of a vehicle. Positive values are positive thrust,
   * negative values are negative thrust.
   */
  @GeneratedMavField(type = "int16_t")
  public val z: Short = 0,
  /**
   * R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this axis is
   * invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being 1000
   * and clockwise being -1000, and the yaw of a vehicle.
   */
  @GeneratedMavField(type = "int16_t")
  public val r: Short = 0,
  /**
   * A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for pressed, 0 for
   * released. The lowest bit corresponds to Button 1.
   */
  @GeneratedMavField(type = "uint16_t")
  public val buttons: UShort = 0u,
  /**
   * A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for pressed, 0 for
   * released. The lowest bit corresponds to Button 16.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val buttons2: UShort = 0u,
  /**
   * Set bits to 1 to indicate which of the following extension fields contain valid data: bit 0:
   * pitch, bit 1: roll.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val enabledExtensions: UByte = 0u,
  /**
   * Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on
   * vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is set.
   * Set to 0 if invalid.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val s: Short = 0,
  /**
   * Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on vehicles
   * with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is set. Set to 0 if
   * invalid.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val t: Short = 0,
) : MavMessage<ManualControl> {
  public override val instanceCompanion: MavMessage.MavCompanion<ManualControl> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(x)
    output.encodeInt16(y)
    output.encodeInt16(z)
    output.encodeInt16(r)
    output.encodeUInt16(buttons)
    output.encodeUInt8(target)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(x)
    output.encodeInt16(y)
    output.encodeInt16(z)
    output.encodeInt16(r)
    output.encodeUInt16(buttons)
    output.encodeUInt8(target)
    output.encodeUInt16(buttons2)
    output.encodeUInt8(enabledExtensions)
    output.encodeInt16(s)
    output.encodeInt16(t)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ManualControl> {
    private const val SIZE_V1: Int = 11

    private const val SIZE_V2: Int = 18

    public override val id: UInt = 69u

    public override val crcExtra: Byte = -13

    public override fun deserialize(source: BufferedSource): ManualControl {
      val x = source.decodeInt16()
      val y = source.decodeInt16()
      val z = source.decodeInt16()
      val r = source.decodeInt16()
      val buttons = source.decodeUInt16()
      val target = source.decodeUInt8()
      val buttons2 = source.decodeUInt16()
      val enabledExtensions = source.decodeUInt8()
      val s = source.decodeInt16()
      val t = source.decodeInt16()

      return ManualControl(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): ManualControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var target: UByte = 0u

    public var x: Short = 0

    public var y: Short = 0

    public var z: Short = 0

    public var r: Short = 0

    public var buttons: UShort = 0u

    public var buttons2: UShort = 0u

    public var enabledExtensions: UByte = 0u

    public var s: Short = 0

    public var t: Short = 0

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
