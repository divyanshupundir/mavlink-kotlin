package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class GimbalAxis(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Gimbal yaw axis.
   */
  @GeneratedMavEnumEntry
  YAW(0u),
  /**
   * Gimbal pitch axis.
   */
  @GeneratedMavEnumEntry
  PITCH(1u),
  /**
   * Gimbal roll axis.
   */
  @GeneratedMavEnumEntry
  ROLL(2u),
  ;

  public companion object : MavEnum.MavCompanion<GimbalAxis> {
    override fun getEntryFromValueOrNull(v: UInt): GimbalAxis? = when (v) {
      0u -> YAW
      1u -> PITCH
      2u -> ROLL
      else -> null
    }
  }
}
