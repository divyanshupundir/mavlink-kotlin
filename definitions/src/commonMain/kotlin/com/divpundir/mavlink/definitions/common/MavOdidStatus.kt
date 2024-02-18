package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidStatus(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<MavOdidStatus> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidStatus? = when (v) {
      0u -> UNDECLARED
      1u -> GROUND
      2u -> AIRBORNE
      3u -> EMERGENCY
      4u -> REMOTE_ID_SYSTEM_FAILURE
      else -> null
    }
  }
}
