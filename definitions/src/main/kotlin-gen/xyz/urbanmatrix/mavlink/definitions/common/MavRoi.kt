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
   * No region of interest.
   */
  @GeneratedMavEnumEntry
  MAV_ROI_NONE(0L),
  /**
   * Point toward next waypoint, with optional pitch/roll/yaw offset.
   */
  @GeneratedMavEnumEntry
  MAV_ROI_WPNEXT(1L),
  /**
   * Point toward given waypoint.
   */
  @GeneratedMavEnumEntry
  MAV_ROI_WPINDEX(2L),
  /**
   * Point toward fixed location.
   */
  @GeneratedMavEnumEntry
  MAV_ROI_LOCATION(3L),
  /**
   * Point toward of given id.
   */
  @GeneratedMavEnumEntry
  MAV_ROI_TARGET(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavRoi? = when (v) {
      0L -> MAV_ROI_NONE
      1L -> MAV_ROI_WPNEXT
      2L -> MAV_ROI_WPINDEX
      3L -> MAV_ROI_LOCATION
      4L -> MAV_ROI_TARGET
      else -> null
    }
  }
}
