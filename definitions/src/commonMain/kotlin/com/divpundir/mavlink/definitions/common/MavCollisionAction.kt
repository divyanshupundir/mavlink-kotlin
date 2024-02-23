package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Possible actions an aircraft can take to avoid a collision.
 */
@GeneratedMavEnum
public enum class MavCollisionAction(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Ignore any potential collisions
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Report potential collision
   */
  @GeneratedMavEnumEntry
  REPORT(1u),
  /**
   * Ascend or Descend to avoid threat
   */
  @GeneratedMavEnumEntry
  ASCEND_OR_DESCEND(2u),
  /**
   * Move horizontally to avoid threat
   */
  @GeneratedMavEnumEntry
  MOVE_HORIZONTALLY(3u),
  /**
   * Aircraft to move perpendicular to the collision's velocity vector
   */
  @GeneratedMavEnumEntry
  MOVE_PERPENDICULAR(4u),
  /**
   * Aircraft to fly directly back to its launch point
   */
  @GeneratedMavEnumEntry
  RTL(5u),
  /**
   * Aircraft to stop in place
   */
  @GeneratedMavEnumEntry
  HOVER(6u),
  ;

  public companion object : MavEnum.MavCompanion<MavCollisionAction> {
    override fun getEntryFromValueOrNull(v: UInt): MavCollisionAction? = when (v) {
      0u -> NONE
      1u -> REPORT
      2u -> ASCEND_OR_DESCEND
      3u -> MOVE_HORIZONTALLY
      4u -> MOVE_PERPENDICULAR
      5u -> RTL
      6u -> HOVER
      else -> null
    }
  }
}
