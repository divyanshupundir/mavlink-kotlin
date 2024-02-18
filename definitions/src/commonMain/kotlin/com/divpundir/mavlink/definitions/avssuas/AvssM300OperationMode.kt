package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AvssM300OperationMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * In manual control mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_MANUAL_CTRL(0u),
  /**
   * In attitude mode 
   */
  @GeneratedMavEnumEntry
  MODE_M300_ATTITUDE(1u),
  /**
   * In GPS mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_P_GPS(6u),
  /**
   * In hotpoint mode 
   */
  @GeneratedMavEnumEntry
  MODE_M300_HOTPOINT_MODE(9u),
  /**
   * In assisted takeoff mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_ASSISTED_TAKEOFF(10u),
  /**
   * In auto takeoff mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_AUTO_TAKEOFF(11u),
  /**
   * In auto landing mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_AUTO_LANDING(12u),
  /**
   * In go home mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_NAVI_GO_HOME(15u),
  /**
   * In sdk control mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_NAVI_SDK_CTRL(17u),
  /**
   * In sport mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_S_SPORT(31u),
  /**
   * In force auto landing mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_FORCE_AUTO_LANDING(33u),
  /**
   * In tripod mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_T_TRIPOD(38u),
  /**
   * In search mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_SEARCH_MODE(40u),
  /**
   * In engine mode
   */
  @GeneratedMavEnumEntry
  MODE_M300_ENGINE_START(41u),
  ;

  public companion object : MavEnum.MavCompanion<AvssM300OperationMode> {
    override fun getEntryFromValueOrNull(v: UInt): AvssM300OperationMode? = when (v) {
      0u -> MODE_M300_MANUAL_CTRL
      1u -> MODE_M300_ATTITUDE
      6u -> MODE_M300_P_GPS
      9u -> MODE_M300_HOTPOINT_MODE
      10u -> MODE_M300_ASSISTED_TAKEOFF
      11u -> MODE_M300_AUTO_TAKEOFF
      12u -> MODE_M300_AUTO_LANDING
      15u -> MODE_M300_NAVI_GO_HOME
      17u -> MODE_M300_NAVI_SDK_CTRL
      31u -> MODE_M300_S_SPORT
      33u -> MODE_M300_FORCE_AUTO_LANDING
      38u -> MODE_M300_T_TRIPOD
      40u -> MODE_M300_SEARCH_MODE
      41u -> MODE_M300_ENGINE_START
      else -> null
    }
  }
}
