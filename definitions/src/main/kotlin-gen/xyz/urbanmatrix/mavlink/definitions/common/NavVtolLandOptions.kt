package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class NavVtolLandOptions(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Default autopilot landing behaviour.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0L),
  /**
   * Descend in fixed wing mode, transitioning to multicopter mode for vertical landing when close
   * to the ground.
   *           The fixed wing descent pattern is at the discretion of the vehicle (e.g. transition
   * altitude, loiter direction, radius, and speed, etc.).
   *         
   */
  @GeneratedMavEnumEntry
  FW_DESCENT(1L),
  /**
   * Land in multicopter mode on reaching the landing co-ordinates (the whole landing is by "hover
   * descent").
   */
  @GeneratedMavEnumEntry
  HOVER_DESCENT(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): NavVtolLandOptions? = when (v) {
      0L -> DEFAULT
      1L -> FW_DESCENT
      2L -> HOVER_DESCENT
      else -> null
    }
  }
}
