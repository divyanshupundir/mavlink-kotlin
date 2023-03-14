package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class LimitsState(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Pre-initialization.
   */
  @GeneratedMavEnumEntry
  LIMITS_INIT(0u),
  /**
   * Disabled.
   */
  @GeneratedMavEnumEntry
  LIMITS_DISABLED(1u),
  /**
   * Checking limits.
   */
  @GeneratedMavEnumEntry
  LIMITS_ENABLED(2u),
  /**
   * A limit has been breached.
   */
  @GeneratedMavEnumEntry
  LIMITS_TRIGGERED(3u),
  /**
   * Taking action e.g. Return/RTL.
   */
  @GeneratedMavEnumEntry
  LIMITS_RECOVERING(4u),
  /**
   * We're no longer in breach of a limit.
   */
  @GeneratedMavEnumEntry
  LIMITS_RECOVERED(5u),
  ;

  public companion object : MavEnum.Companion<LimitsState> {
    public override fun getEntryFromValueOrNull(v: UInt): LimitsState? = when (v) {
      0u -> LIMITS_INIT
      1u -> LIMITS_DISABLED
      2u -> LIMITS_ENABLED
      3u -> LIMITS_TRIGGERED
      4u -> LIMITS_RECOVERING
      5u -> LIMITS_RECOVERED
      else -> null
    }
  }
}
