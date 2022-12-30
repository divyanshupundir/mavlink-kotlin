package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The status of the (UA) Unmanned Aircraft is undefined.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0L),
  /**
   * The UA is on the ground.
   */
  @GeneratedMavEnumEntry
  GROUND(1L),
  /**
   * The UA is in the air.
   */
  @GeneratedMavEnumEntry
  AIRBORNE(2L),
  /**
   * The UA is having an emergency.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(3L),
  /**
   * The remote ID system is failing or unreliable in some way.
   */
  @GeneratedMavEnumEntry
  REMOTE_ID_SYSTEM_FAILURE(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidStatus? = when (v) {
      0L -> UNDECLARED
      1L -> GROUND
      2L -> AIRBORNE
      3L -> EMERGENCY
      4L -> REMOTE_ID_SYSTEM_FAILURE
      else -> null
    }
  }
}
