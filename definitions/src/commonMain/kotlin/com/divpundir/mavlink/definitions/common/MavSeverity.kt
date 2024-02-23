package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Indicates the severity level, generally used for status messages to indicate their relative
 * urgency. Based on RFC-5424 using expanded definitions at:
 * http://www.kiwisyslog.com/kb/info:-syslog-message-levels/.
 */
@GeneratedMavEnum
public enum class MavSeverity(
  override val `value`: UInt,
) : MavEnum {
  /**
   * System is unusable. This is a "panic" condition.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(0u),
  /**
   * Action should be taken immediately. Indicates error in non-critical systems.
   */
  @GeneratedMavEnumEntry
  ALERT(1u),
  /**
   * Action must be taken immediately. Indicates failure in a primary system.
   */
  @GeneratedMavEnumEntry
  CRITICAL(2u),
  /**
   * Indicates an error in secondary/redundant systems.
   */
  @GeneratedMavEnumEntry
  ERROR(3u),
  /**
   * Indicates about a possible future error if this is not resolved within a given timeframe.
   * Example would be a low battery warning.
   */
  @GeneratedMavEnumEntry
  WARNING(4u),
  /**
   * An unusual event has occurred, though not an error condition. This should be investigated for
   * the root cause.
   */
  @GeneratedMavEnumEntry
  NOTICE(5u),
  /**
   * Normal operational messages. Useful for logging. No action is required for these messages.
   */
  @GeneratedMavEnumEntry
  INFO(6u),
  /**
   * Useful non-operational messages that can assist in debugging. These should not occur during
   * normal operation.
   */
  @GeneratedMavEnumEntry
  DEBUG(7u),
  ;

  public companion object : MavEnum.MavCompanion<MavSeverity> {
    override fun getEntryFromValueOrNull(v: UInt): MavSeverity? = when (v) {
      0u -> EMERGENCY
      1u -> ALERT
      2u -> CRITICAL
      3u -> ERROR
      4u -> WARNING
      5u -> NOTICE
      6u -> INFO
      7u -> DEBUG
      else -> null
    }
  }
}
