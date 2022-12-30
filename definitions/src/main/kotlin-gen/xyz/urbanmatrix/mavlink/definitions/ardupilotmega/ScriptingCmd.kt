package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class ScriptingCmd(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Start a REPL session.
   */
  @GeneratedMavEnumEntry
  REPL_START(0L),
  /**
   * End a REPL session.
   */
  @GeneratedMavEnumEntry
  REPL_STOP(1L),
  /**
   * Stop execution of scripts.
   */
  @GeneratedMavEnumEntry
  STOP(2L),
  /**
   * Stop execution of scripts and restart.
   */
  @GeneratedMavEnumEntry
  STOP_AND_RESTART(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): ScriptingCmd? = when (v) {
      0L -> REPL_START
      1L -> REPL_STOP
      2L -> STOP
      3L -> STOP_AND_RESTART
      else -> null
    }
  }
}
