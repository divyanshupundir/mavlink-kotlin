package xyz.urbanmatrix.mavlink.definitions.avssuas

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class AvssM300OperationMode(
  public override val `value`: Long,
) : MavEnum {
  /**
   * In manual control mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_MANUAL_CTRL(0L),
  /**
   * In attitude mode 
   */
  @GeneratedMavEnumEntry
  MODE_M300_ATTITUDE(1L),
  /**
   * In GPS mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_P_GPS(6L),
  /**
   * In hotpoint mode 
   */
  @GeneratedMavEnumEntry
  MODE_M300_HOTPOINT_MODE(9L),
  /**
   * In assisted takeoff mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_ASSISTED_TAKEOFF(10L),
  /**
   * In auto takeoff mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_AUTO_TAKEOFF(11L),
  /**
   * In auto landing mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_AUTO_LANDING(12L),
  /**
   * In go home mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_NAVI_GO_HOME(15L),
  /**
   * In sdk control mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_NAVI_SDK_CTRL(17L),
  /**
   * In sport mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_S_SPORT(31L),
  /**
   * In force auto landing mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_FORCE_AUTO_LANDING(33L),
  /**
   * In tripod mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_T_TRIPOD(38L),
  /**
   * In search mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_SEARCH_MODE(40L),
  /**
   * In engine mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_ENGINE_START(41L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): AvssM300OperationMode? = when (v) {
      0L -> MODE_M300_MANUAL_CTRL
      1L -> MODE_M300_ATTITUDE
      6L -> MODE_M300_P_GPS
      9L -> MODE_M300_HOTPOINT_MODE
      10L -> MODE_M300_ASSISTED_TAKEOFF
      11L -> MODE_M300_AUTO_TAKEOFF
      12L -> MODE_M300_AUTO_LANDING
      15L -> MODE_M300_NAVI_GO_HOME
      17L -> MODE_M300_NAVI_SDK_CTRL
      31L -> MODE_M300_S_SPORT
      33L -> MODE_M300_FORCE_AUTO_LANDING
      38L -> MODE_M300_T_TRIPOD
      40L -> MODE_M300_SEARCH_MODE
      41L -> MODE_M300_ENGINE_START
      else -> null
    }
  }
}
