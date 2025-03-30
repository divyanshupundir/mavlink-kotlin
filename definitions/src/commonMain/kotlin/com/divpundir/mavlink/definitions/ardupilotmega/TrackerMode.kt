package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * A mapping of antenna tracker flight modes for custom_mode field of heartbeat.
 */
@GeneratedMavEnum
public enum class TrackerMode(
  override val `value`: UInt,
) : MavEnum {
  /**
   * MANUAL
   */
  @GeneratedMavEnumEntry
  MANUAL(0u),
  /**
   * STOP
   */
  @GeneratedMavEnumEntry
  STOP(1u),
  /**
   * SCAN
   */
  @GeneratedMavEnumEntry
  SCAN(2u),
  /**
   * SERVO TEST
   */
  @GeneratedMavEnumEntry
  SERVO_TEST(3u),
  /**
   * GUIDED
   */
  @GeneratedMavEnumEntry
  GUIDED(4u),
  /**
   * AUTO
   */
  @GeneratedMavEnumEntry
  AUTO(10u),
  /**
   * INITIALISING
   */
  @GeneratedMavEnumEntry
  INITIALIZING(16u),
  ;

  public companion object : MavEnum.MavCompanion<TrackerMode> {
    override fun getEntryFromValueOrNull(v: UInt): TrackerMode? = when (v) {
      0u -> MANUAL
      1u -> STOP
      2u -> SCAN
      3u -> SERVO_TEST
      4u -> GUIDED
      10u -> AUTO
      16u -> INITIALIZING
      else -> null
    }
  }
}
