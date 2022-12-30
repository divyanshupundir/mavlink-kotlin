package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavState(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Uninitialized system, state is unknown.
   */
  @GeneratedMavEnumEntry
  UNINIT(0L),
  /**
   * System is booting up.
   */
  @GeneratedMavEnumEntry
  BOOT(1L),
  /**
   * System is calibrating and not flight-ready.
   */
  @GeneratedMavEnumEntry
  CALIBRATING(2L),
  /**
   * System is grounded and on standby. It can be launched any time.
   */
  @GeneratedMavEnumEntry
  STANDBY(3L),
  /**
   * System is active and might be already airborne. Motors are engaged.
   */
  @GeneratedMavEnumEntry
  ACTIVE(4L),
  /**
   * System is in a non-normal flight mode. It can however still navigate.
   */
  @GeneratedMavEnumEntry
  CRITICAL(5L),
  /**
   * System is in a non-normal flight mode. It lost control over parts or over the whole airframe.
   * It is in mayday and going down.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(6L),
  /**
   * System just initialized its power-down sequence, will shut down now.
   */
  @GeneratedMavEnumEntry
  POWEROFF(7L),
  /**
   * System is terminating itself.
   */
  @GeneratedMavEnumEntry
  FLIGHT_TERMINATION(8L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavState? = when (v) {
      0L -> UNINIT
      1L -> BOOT
      2L -> CALIBRATING
      3L -> STANDBY
      4L -> ACTIVE
      5L -> CRITICAL
      6L -> EMERGENCY
      7L -> POWEROFF
      8L -> FLIGHT_TERMINATION
      else -> null
    }
  }
}
