package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class ScriptingCmd(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Start a REPL session.
   */
  @GeneratedMavEnumEntry
  REPL_START(0u),
  /**
   * End a REPL session.
   */
  @GeneratedMavEnumEntry
  REPL_STOP(1u),
  /**
   * Stop execution of scripts.
   */
  @GeneratedMavEnumEntry
  STOP(2u),
  /**
   * Stop execution of scripts and restart.
   */
  @GeneratedMavEnumEntry
  STOP_AND_RESTART(3u),
  ;

  public companion object : MavEnum.Companion<ScriptingCmd> {
    public override fun getEntryFromValueOrNull(v: UInt): ScriptingCmd? = when (v) {
      0u -> REPL_START
      1u -> REPL_STOP
      2u -> STOP
      3u -> STOP_AND_RESTART
      else -> null
    }
  }
}
