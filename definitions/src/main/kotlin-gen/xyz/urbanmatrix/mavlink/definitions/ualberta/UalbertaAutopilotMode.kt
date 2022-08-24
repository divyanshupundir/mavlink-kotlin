package xyz.urbanmatrix.mavlink.definitions.ualberta

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Available autopilot modes for ualberta uav
 */
@GeneratedMavEnum
public enum class UalbertaAutopilotMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Raw input pulse widts sent to output
   */
  MODE_MANUAL_DIRECT(1L),
  /**
   * Inputs are normalized using calibration, the converted back to raw pulse widths for output
   */
  MODE_MANUAL_SCALED(2L),
  /**
   *  dfsdfs
   */
  MODE_AUTO_PID_ATT(3L),
  /**
   *  dfsfds
   */
  MODE_AUTO_PID_VEL(4L),
  /**
   *  dfsdfsdfs
   */
  MODE_AUTO_PID_POS(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): UalbertaAutopilotMode? = when (v) {
      1L -> MODE_MANUAL_DIRECT
      2L -> MODE_MANUAL_SCALED
      3L -> MODE_AUTO_PID_ATT
      4L -> MODE_AUTO_PID_VEL
      5L -> MODE_AUTO_PID_POS
      else -> null
    }
  }
}
