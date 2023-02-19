package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class NavVtolLandOptions(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Default autopilot landing behaviour.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0u),
  /**
   * Descend in fixed wing mode, transitioning to multicopter mode for vertical landing when close
   * to the ground.
   *           The fixed wing descent pattern is at the discretion of the vehicle (e.g. transition
   * altitude, loiter direction, radius, and speed, etc.).
   *         
   */
  @GeneratedMavEnumEntry
  FW_DESCENT(1u),
  /**
   * Land in multicopter mode on reaching the landing co-ordinates (the whole landing is by "hover
   * descent").
   */
  @GeneratedMavEnumEntry
  HOVER_DESCENT(2u),
  ;

  public companion object : MavEnum.Companion<NavVtolLandOptions> {
    public override fun getEntryFromValueOrNull(v: UInt): NavVtolLandOptions? = when (v) {
      0u -> DEFAULT
      1u -> FW_DESCENT
      2u -> HOVER_DESCENT
      else -> null
    }
  }
}
