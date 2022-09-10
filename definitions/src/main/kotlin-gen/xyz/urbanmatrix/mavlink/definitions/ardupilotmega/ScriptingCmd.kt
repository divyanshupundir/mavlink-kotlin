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
  SCRIPTING_CMD_REPL_START(0L),
  /**
   * End a REPL session.
   */
  @GeneratedMavEnumEntry
  SCRIPTING_CMD_REPL_STOP(1L),
  /**
   * Stop execution of scripts.
   */
  @GeneratedMavEnumEntry
  SCRIPTING_CMD_STOP(2L),
  /**
   * Stop execution of scripts and restart.
   */
  @GeneratedMavEnumEntry
  SCRIPTING_CMD_STOP_AND_RESTART(3L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): ScriptingCmd? = when (v) {
      0L -> SCRIPTING_CMD_REPL_START
      1L -> SCRIPTING_CMD_REPL_STOP
      2L -> SCRIPTING_CMD_STOP
      3L -> SCRIPTING_CMD_STOP_AND_RESTART
      else -> null
    }
  }
}
