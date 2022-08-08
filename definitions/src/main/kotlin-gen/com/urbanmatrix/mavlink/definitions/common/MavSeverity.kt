package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Indicates the severity level, generally used for status messages to indicate their relative
 * urgency. Based on RFC-5424 using expanded definitions at:
 * http://www.kiwisyslog.com/kb/info:-syslog-message-levels/.
 */
@GeneratedMavEnum
public enum class MavSeverity(
  public override val `value`: Long,
) : MavEnum {
  /**
   * System is unusable. This is a "panic" condition.
   */
  MAV_SEVERITY_EMERGENCY(0L),
  /**
   * Action should be taken immediately. Indicates error in non-critical systems.
   */
  MAV_SEVERITY_ALERT(1L),
  /**
   * Action must be taken immediately. Indicates failure in a primary system.
   */
  MAV_SEVERITY_CRITICAL(2L),
  /**
   * Indicates an error in secondary/redundant systems.
   */
  MAV_SEVERITY_ERROR(3L),
  /**
   * Indicates about a possible future error if this is not resolved within a given timeframe.
   * Example would be a low battery warning.
   */
  MAV_SEVERITY_WARNING(4L),
  /**
   * An unusual event has occurred, though not an error condition. This should be investigated for
   * the root cause.
   */
  MAV_SEVERITY_NOTICE(5L),
  /**
   * Normal operational messages. Useful for logging. No action is required for these messages.
   */
  MAV_SEVERITY_INFO(6L),
  /**
   * Useful non-operational messages that can assist in debugging. These should not occur during
   * normal operation.
   */
  MAV_SEVERITY_DEBUG(7L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavSeverity? = when (v) {
      0L -> MAV_SEVERITY_EMERGENCY
      1L -> MAV_SEVERITY_ALERT
      2L -> MAV_SEVERITY_CRITICAL
      3L -> MAV_SEVERITY_ERROR
      4L -> MAV_SEVERITY_WARNING
      5L -> MAV_SEVERITY_NOTICE
      6L -> MAV_SEVERITY_INFO
      7L -> MAV_SEVERITY_DEBUG
      else -> null
    }
  }
}
