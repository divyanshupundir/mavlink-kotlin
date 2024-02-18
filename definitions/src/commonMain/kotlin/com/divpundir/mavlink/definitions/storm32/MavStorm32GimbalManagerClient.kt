package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Gimbal manager client ID. In a prioritizing profile, the priorities are determined by the
 * implementation; they could e.g. be custom1 > onboard > GCS > autopilot/camera > GCS2 > custom2.
 *
 */
@GeneratedMavEnum
public enum class MavStorm32GimbalManagerClient(
  override val `value`: UInt,
) : MavEnum {
  /**
   * For convenience.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * This is the onboard/companion computer client.
   */
  @GeneratedMavEnumEntry
  ONBOARD(1u),
  /**
   * This is the autopilot client.
   */
  @GeneratedMavEnumEntry
  AUTOPILOT(2u),
  /**
   * This is the GCS client.
   */
  @GeneratedMavEnumEntry
  GCS(3u),
  /**
   * This is the camera client.
   */
  @GeneratedMavEnumEntry
  CAMERA(4u),
  /**
   * This is the GCS2 client.
   */
  @GeneratedMavEnumEntry
  GCS2(5u),
  /**
   * This is the camera2 client.
   */
  @GeneratedMavEnumEntry
  CAMERA2(6u),
  /**
   * This is the custom client.
   */
  @GeneratedMavEnumEntry
  CUSTOM(7u),
  /**
   * This is the custom2 client.
   */
  @GeneratedMavEnumEntry
  CUSTOM2(8u),
  ;

  public companion object : MavEnum.MavCompanion<MavStorm32GimbalManagerClient> {
    override fun getEntryFromValueOrNull(v: UInt): MavStorm32GimbalManagerClient? = when (v) {
      0u -> NONE
      1u -> ONBOARD
      2u -> AUTOPILOT
      3u -> GCS
      4u -> CAMERA
      5u -> GCS2
      6u -> CAMERA2
      7u -> CUSTOM
      8u -> CUSTOM2
      else -> null
    }
  }
}
