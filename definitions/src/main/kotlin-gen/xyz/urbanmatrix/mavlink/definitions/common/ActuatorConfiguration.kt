package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Actuator configuration, used to change a setting on an actuator. Component information metadata
 * can be used to know which outputs support which commands.
 */
@GeneratedMavEnum
public enum class ActuatorConfiguration(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Do nothing.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Command the actuator to beep now.
   */
  @GeneratedMavEnumEntry
  BEEP(1u),
  /**
   * Permanently set the actuator (ESC) to 3D mode (reversible thrust).
   */
  @GeneratedMavEnumEntry
  _3D_MODE_ON(2u),
  /**
   * Permanently set the actuator (ESC) to non 3D mode (non-reversible thrust).
   */
  @GeneratedMavEnumEntry
  _3D_MODE_OFF(3u),
  /**
   * Permanently set the actuator (ESC) to spin direction 1 (which can be clockwise or
   * counter-clockwise).
   */
  @GeneratedMavEnumEntry
  SPIN_DIRECTION1(4u),
  /**
   * Permanently set the actuator (ESC) to spin direction 2 (opposite of direction 1).
   */
  @GeneratedMavEnumEntry
  SPIN_DIRECTION2(5u),
  ;

  public companion object : MavEnum.Companion<ActuatorConfiguration> {
    public override fun getEntryFromValueOrNull(v: UInt): ActuatorConfiguration? = when (v) {
      0u -> NONE
      1u -> BEEP
      2u -> _3D_MODE_ON
      3u -> _3D_MODE_OFF
      4u -> SPIN_DIRECTION1
      5u -> SPIN_DIRECTION2
      else -> null
    }
  }
}
