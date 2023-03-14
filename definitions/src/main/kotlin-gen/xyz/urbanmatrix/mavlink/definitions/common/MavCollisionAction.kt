package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Possible actions an aircraft can take to avoid a collision.
 */
@GeneratedMavEnum
public enum class MavCollisionAction(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<MavCollisionAction> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCollisionAction? = when (v) {
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
