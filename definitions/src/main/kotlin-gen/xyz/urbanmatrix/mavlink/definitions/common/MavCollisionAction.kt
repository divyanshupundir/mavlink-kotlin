package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

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
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Report potential collision
   */
  @GeneratedMavEnumEntry
  REPORT(1L),
  /**
   * Ascend or Descend to avoid threat
   */
  @GeneratedMavEnumEntry
  ASCEND_OR_DESCEND(2L),
  /**
   * Move horizontally to avoid threat
   */
  @GeneratedMavEnumEntry
  MOVE_HORIZONTALLY(3L),
  /**
   * Aircraft to move perpendicular to the collision's velocity vector
   */
  @GeneratedMavEnumEntry
  MOVE_PERPENDICULAR(4L),
  /**
   * Aircraft to fly directly back to its launch point
   */
  @GeneratedMavEnumEntry
  RTL(5L),
  /**
   * Aircraft to stop in place
   */
  @GeneratedMavEnumEntry
  HOVER(6L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavCollisionAction? = when (v) {
      0L -> NONE
      1L -> REPORT
      2L -> ASCEND_OR_DESCEND
      3L -> MOVE_HORIZONTALLY
      4L -> MOVE_PERPENDICULAR
      5L -> RTL
      6L -> HOVER
      else -> null
    }
  }
}
