package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Possible actions an aircraft can take to avoid a collision.
 */
@GeneratedMavEnum
public enum class MavCollisionAction(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Ignore any potential collisions
   */
  MAV_COLLISION_ACTION_NONE(0L),
  /**
   * Report potential collision
   */
  MAV_COLLISION_ACTION_REPORT(1L),
  /**
   * Ascend or Descend to avoid threat
   */
  MAV_COLLISION_ACTION_ASCEND_OR_DESCEND(2L),
  /**
   * Move horizontally to avoid threat
   */
  MAV_COLLISION_ACTION_MOVE_HORIZONTALLY(3L),
  /**
   * Aircraft to move perpendicular to the collision's velocity vector
   */
  MAV_COLLISION_ACTION_MOVE_PERPENDICULAR(4L),
  /**
   * Aircraft to fly directly back to its launch point
   */
  MAV_COLLISION_ACTION_RTL(5L),
  /**
   * Aircraft to stop in place
   */
  MAV_COLLISION_ACTION_HOVER(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCollisionAction? = when (v) {
      0L -> MAV_COLLISION_ACTION_NONE
      1L -> MAV_COLLISION_ACTION_REPORT
      2L -> MAV_COLLISION_ACTION_ASCEND_OR_DESCEND
      3L -> MAV_COLLISION_ACTION_MOVE_HORIZONTALLY
      4L -> MAV_COLLISION_ACTION_MOVE_PERPENDICULAR
      5L -> MAV_COLLISION_ACTION_RTL
      6L -> MAV_COLLISION_ACTION_HOVER
      else -> null
    }
  }
}
