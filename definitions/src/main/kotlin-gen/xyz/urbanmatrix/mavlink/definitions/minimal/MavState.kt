package xyz.urbanmatrix.mavlink.definitions.minimal

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavState(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Uninitialized system, state is unknown.
   */
  @GeneratedMavEnumEntry
  UNINIT(0u),
  /**
   * System is booting up.
   */
  @GeneratedMavEnumEntry
  BOOT(1u),
  /**
   * System is calibrating and not flight-ready.
   */
  @GeneratedMavEnumEntry
  CALIBRATING(2u),
  /**
   * System is grounded and on standby. It can be launched any time.
   */
  @GeneratedMavEnumEntry
  STANDBY(3u),
  /**
   * System is active and might be already airborne. Motors are engaged.
   */
  @GeneratedMavEnumEntry
  ACTIVE(4u),
  /**
   * System is in a non-normal flight mode. It can however still navigate.
   */
  @GeneratedMavEnumEntry
  CRITICAL(5u),
  /**
   * System is in a non-normal flight mode. It lost control over parts or over the whole airframe.
   * It is in mayday and going down.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(6u),
  /**
   * System just initialized its power-down sequence, will shut down now.
   */
  @GeneratedMavEnumEntry
  POWEROFF(7u),
  /**
   * System is terminating itself.
   */
  @GeneratedMavEnumEntry
  FLIGHT_TERMINATION(8u),
  ;

  public companion object : MavEnum.Companion<MavState> {
    public override fun getEntryFromValueOrNull(v: UInt): MavState? = when (v) {
      0u -> UNINIT
      1u -> BOOT
      2u -> CALIBRATING
      3u -> STANDBY
      4u -> ACTIVE
      5u -> CRITICAL
      6u -> EMERGENCY
      7u -> POWEROFF
      8u -> FLIGHT_TERMINATION
      else -> null
    }
  }
}
