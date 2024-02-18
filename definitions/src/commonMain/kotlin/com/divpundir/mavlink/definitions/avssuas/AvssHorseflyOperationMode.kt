package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class AvssHorseflyOperationMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * In manual control mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_MANUAL_CTRL(0u),
  /**
   * In auto takeoff mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_AUTO_TAKEOFF(1u),
  /**
   * In auto landing mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_AUTO_LANDING(2u),
  /**
   * In go home mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_NAVI_GO_HOME(3u),
  /**
   * In drop mode
   */
  @GeneratedMavEnumEntry
  MODE_HORSEFLY_DROP(4u),
  ;

  public companion object : MavEnum.MavCompanion<AvssHorseflyOperationMode> {
    override fun getEntryFromValueOrNull(v: UInt): AvssHorseflyOperationMode? = when (v) {
      0u -> MODE_HORSEFLY_MANUAL_CTRL
      1u -> MODE_HORSEFLY_AUTO_TAKEOFF
      2u -> MODE_HORSEFLY_AUTO_LANDING
      3u -> MODE_HORSEFLY_NAVI_GO_HOME
      4u -> MODE_HORSEFLY_DROP
      else -> null
    }
  }
}
