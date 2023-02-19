package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidStatus(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The status of the (UA) Unmanned Aircraft is undefined.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0u),
  /**
   * The UA is on the ground.
   */
  @GeneratedMavEnumEntry
  GROUND(1u),
  /**
   * The UA is in the air.
   */
  @GeneratedMavEnumEntry
  AIRBORNE(2u),
  /**
   * The UA is having an emergency.
   */
  @GeneratedMavEnumEntry
  EMERGENCY(3u),
  /**
   * The remote ID system is failing or unreliable in some way.
   */
  @GeneratedMavEnumEntry
  REMOTE_ID_SYSTEM_FAILURE(4u),
  ;

  public companion object : MavEnum.Companion<MavOdidStatus> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidStatus? = when (v) {
      0u -> UNDECLARED
      1u -> GROUND
      2u -> AIRBORNE
      3u -> EMERGENCY
      4u -> REMOTE_ID_SYSTEM_FAILURE
      else -> null
    }
  }
}
