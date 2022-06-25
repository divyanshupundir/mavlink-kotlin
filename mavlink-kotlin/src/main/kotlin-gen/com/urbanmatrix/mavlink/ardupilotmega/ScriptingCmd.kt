package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class ScriptingCmd(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Start a REPL session.
   */
  SCRIPTING_CMD_REPL_START(0L),
  /**
   * End a REPL session.
   */
  SCRIPTING_CMD_REPL_STOP(1L),
  /**
   * Stop execution of scripts.
   */
  SCRIPTING_CMD_STOP(2L),
  /**
   * Stop execution of scripts and restart.
   */
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
