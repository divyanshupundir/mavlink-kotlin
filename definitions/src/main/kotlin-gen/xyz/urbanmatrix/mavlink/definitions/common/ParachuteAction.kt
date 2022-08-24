package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Parachute actions. Trigger release and enable/disable auto-release.
 */
@GeneratedMavEnum
public enum class ParachuteAction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Disable auto-release of parachute (i.e. release triggered by crash detectors).
   */
  PARACHUTE_DISABLE(0L),
  /**
   * Enable auto-release of parachute.
   */
  PARACHUTE_ENABLE(1L),
  /**
   * Release parachute and kill motors.
   */
  PARACHUTE_RELEASE(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): ParachuteAction? = when (v) {
      0L -> PARACHUTE_DISABLE
      1L -> PARACHUTE_ENABLE
      2L -> PARACHUTE_RELEASE
      else -> null
    }
  }
}
