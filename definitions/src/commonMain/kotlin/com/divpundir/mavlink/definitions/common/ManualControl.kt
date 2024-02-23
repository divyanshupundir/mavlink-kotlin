package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * This message provides an API for manually controlling the vehicle using standard joystick axes
 * nomenclature, along with a joystick-like input device. Unused axes can be disabled and buttons
 * states are transmitted as individual on/off bits of a bitmask
 *
 * @param target The system to be controlled.
 * @param x X-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this
 * axis is invalid. Generally corresponds to forward(1000)-backward(-1000) movement on a joystick and
 * the pitch of a vehicle.
 * @param y Y-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this
 * axis is invalid. Generally corresponds to left(-1000)-right(1000) movement on a joystick and the
 * roll of a vehicle.
 * @param z Z-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this
 * axis is invalid. Generally corresponds to a separate slider movement with maximum being 1000 and
 * minimum being -1000 on a joystick and the thrust of a vehicle. Positive values are positive thrust,
 * negative values are negative thrust.
 * @param r R-axis, normalized to the range [-1000,1000]. A value of INT16_MAX indicates that this
 * axis is invalid. Generally corresponds to a twisting of the joystick, with counter-clockwise being
 * 1000 and clockwise being -1000, and the yaw of a vehicle.
 * @param buttons A bitfield corresponding to the joystick buttons' 0-15 current state, 1 for
 * pressed, 0 for released. The lowest bit corresponds to Button 1.
 * @param buttons2 A bitfield corresponding to the joystick buttons' 16-31 current state, 1 for
 * pressed, 0 for released. The lowest bit corresponds to Button 16.
 * @param enabledExtensions Set bits to 1 to indicate which of the following extension fields
 * contain valid data: bit 0: pitch, bit 1: roll, bit 2: aux1, bit 3: aux2, bit 4: aux3, bit 5: aux4,
 * bit 6: aux5, bit 7: aux6
 * @param s Pitch-only-axis, normalized to the range [-1000,1000]. Generally corresponds to pitch on
 * vehicles with additional degrees of freedom. Valid if bit 0 of enabled_extensions field is set. Set
 * to 0 if invalid.
 * @param t Roll-only-axis, normalized to the range [-1000,1000]. Generally corresponds to roll on
 * vehicles with additional degrees of freedom. Valid if bit 1 of enabled_extensions field is set. Set
 * to 0 if invalid.
 * @param aux1 Aux continuous input field 1. Normalized in the range [-1000,1000]. Purpose defined
 * by recipient. Valid data if bit 2 of enabled_extensions field is set. 0 if bit 2 is unset.
 * @param aux2 Aux continuous input field 2. Normalized in the range [-1000,1000]. Purpose defined
 * by recipient. Valid data if bit 3 of enabled_extensions field is set. 0 if bit 3 is unset.
 * @param aux3 Aux continuous input field 3. Normalized in the range [-1000,1000]. Purpose defined
 * by recipient. Valid data if bit 4 of enabled_extensions field is set. 0 if bit 4 is unset.
 * @param aux4 Aux continuous input field 4. Normalized in the range [-1000,1000]. Purpose defined
 * by recipient. Valid data if bit 5 of enabled_extensions field is set. 0 if bit 5 is unset.
 * @param aux5 Aux continuous input field 5. Normalized in the range [-1000,1000]. Purpose defined
 * by recipient. Valid data if bit 6 of enabled_extensions field is set. 0 if bit 6 is unset.
 * @param aux6 Aux continuous input field 6. Normalized in the range [-1000,1000]. Purpose defined
 * by recipient. Valid data if bit 7 of enabled_extensions field is set. 0 if bit 7 is unset.
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
   * pitch, bit 1: roll, bit 2: aux1, bit 3: aux2, bit 4: aux3, bit 5: aux4, bit 6: aux5, bit 7: aux6
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
  /**
   * Aux continuous input field 1. Normalized in the range [-1000,1000]. Purpose defined by
   * recipient. Valid data if bit 2 of enabled_extensions field is set. 0 if bit 2 is unset.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val aux1: Short = 0,
  /**
   * Aux continuous input field 2. Normalized in the range [-1000,1000]. Purpose defined by
   * recipient. Valid data if bit 3 of enabled_extensions field is set. 0 if bit 3 is unset.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val aux2: Short = 0,
  /**
   * Aux continuous input field 3. Normalized in the range [-1000,1000]. Purpose defined by
   * recipient. Valid data if bit 4 of enabled_extensions field is set. 0 if bit 4 is unset.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val aux3: Short = 0,
  /**
   * Aux continuous input field 4. Normalized in the range [-1000,1000]. Purpose defined by
   * recipient. Valid data if bit 5 of enabled_extensions field is set. 0 if bit 5 is unset.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val aux4: Short = 0,
  /**
   * Aux continuous input field 5. Normalized in the range [-1000,1000]. Purpose defined by
   * recipient. Valid data if bit 6 of enabled_extensions field is set. 0 if bit 6 is unset.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val aux5: Short = 0,
  /**
   * Aux continuous input field 6. Normalized in the range [-1000,1000]. Purpose defined by
   * recipient. Valid data if bit 7 of enabled_extensions field is set. 0 if bit 7 is unset.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val aux6: Short = 0,
) : MavMessage<ManualControl> {
  override val instanceCompanion: MavMessage.MavCompanion<ManualControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(x)
    encoder.encodeInt16(y)
    encoder.encodeInt16(z)
    encoder.encodeInt16(r)
    encoder.encodeUInt16(buttons)
    encoder.encodeUInt8(target)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(x)
    encoder.encodeInt16(y)
    encoder.encodeInt16(z)
    encoder.encodeInt16(r)
    encoder.encodeUInt16(buttons)
    encoder.encodeUInt8(target)
    encoder.encodeUInt16(buttons2)
    encoder.encodeUInt8(enabledExtensions)
    encoder.encodeInt16(s)
    encoder.encodeInt16(t)
    encoder.encodeInt16(aux1)
    encoder.encodeInt16(aux2)
    encoder.encodeInt16(aux3)
    encoder.encodeInt16(aux4)
    encoder.encodeInt16(aux5)
    encoder.encodeInt16(aux6)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ManualControl> {
    private const val SIZE_V1: Int = 11

    private const val SIZE_V2: Int = 30

    override val id: UInt = 69u

    override val crcExtra: Byte = -13

    override fun deserialize(bytes: ByteArray): ManualControl {
      val decoder = MavDataDecoder(bytes)

      val x = decoder.safeDecodeInt16()
      val y = decoder.safeDecodeInt16()
      val z = decoder.safeDecodeInt16()
      val r = decoder.safeDecodeInt16()
      val buttons = decoder.safeDecodeUInt16()
      val target = decoder.safeDecodeUInt8()
      val buttons2 = decoder.safeDecodeUInt16()
      val enabledExtensions = decoder.safeDecodeUInt8()
      val s = decoder.safeDecodeInt16()
      val t = decoder.safeDecodeInt16()
      val aux1 = decoder.safeDecodeInt16()
      val aux2 = decoder.safeDecodeInt16()
      val aux3 = decoder.safeDecodeInt16()
      val aux4 = decoder.safeDecodeInt16()
      val aux5 = decoder.safeDecodeInt16()
      val aux6 = decoder.safeDecodeInt16()

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
        aux1 = aux1,
        aux2 = aux2,
        aux3 = aux3,
        aux4 = aux4,
        aux5 = aux5,
        aux6 = aux6,
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

    public var aux1: Short = 0

    public var aux2: Short = 0

    public var aux3: Short = 0

    public var aux4: Short = 0

    public var aux5: Short = 0

    public var aux6: Short = 0

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
      aux1 = aux1,
      aux2 = aux2,
      aux3 = aux3,
      aux4 = aux4,
      aux5 = aux5,
      aux6 = aux6,
    )
  }
}
