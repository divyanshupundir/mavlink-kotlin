package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MagCalStatus(
  override val `value`: UInt,
) : MavEnum {
  @GeneratedMavEnumEntry
  MAG_CAL_NOT_STARTED(0u),
  @GeneratedMavEnumEntry
  MAG_CAL_WAITING_TO_START(1u),
  @GeneratedMavEnumEntry
  MAG_CAL_RUNNING_STEP_ONE(2u),
  @GeneratedMavEnumEntry
  MAG_CAL_RUNNING_STEP_TWO(3u),
  @GeneratedMavEnumEntry
  MAG_CAL_SUCCESS(4u),
  @GeneratedMavEnumEntry
  MAG_CAL_FAILED(5u),
  @GeneratedMavEnumEntry
  MAG_CAL_BAD_ORIENTATION(6u),
  @GeneratedMavEnumEntry
  MAG_CAL_BAD_RADIUS(7u),
  ;

  public companion object : MavEnum.MavCompanion<MagCalStatus> {
    override fun getEntryFromValueOrNull(v: UInt): MagCalStatus? = when (v) {
      0u -> MAG_CAL_NOT_STARTED
      1u -> MAG_CAL_WAITING_TO_START
      2u -> MAG_CAL_RUNNING_STEP_ONE
      3u -> MAG_CAL_RUNNING_STEP_TWO
      4u -> MAG_CAL_SUCCESS
      5u -> MAG_CAL_FAILED
      6u -> MAG_CAL_BAD_ORIENTATION
      7u -> MAG_CAL_BAD_RADIUS
      else -> null
    }
  }
}
