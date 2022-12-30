package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Deprecated
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * The ROI (region of interest) for the vehicle. This can be
 *                 be used by the vehicle for camera/vehicle attitude alignment (see
 *                 MAV_CMD_NAV_ROI).
 */
@Deprecated(message = "")
@GeneratedMavEnum
public enum class MavRoi(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Point toward of given id.
   */
  @GeneratedMavEnumEntry
  TARGET(4L),
  /**
   * Point toward fixed location.
   */
  @GeneratedMavEnumEntry
  LOCATION(3L),
  /**
   * Point toward given waypoint.
   */
  @GeneratedMavEnumEntry
  WPINDEX(2L),
  /**
   * Point toward next waypoint, with optional pitch/roll/yaw offset.
   */
  @GeneratedMavEnumEntry
  WPNEXT(1L),
  /**
   * No region of interest.
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavRoi? = when (v) {
      4L -> TARGET
      3L -> LOCATION
      2L -> WPINDEX
      1L -> WPNEXT
      0L -> NONE
      else -> null
    }
  }
}
