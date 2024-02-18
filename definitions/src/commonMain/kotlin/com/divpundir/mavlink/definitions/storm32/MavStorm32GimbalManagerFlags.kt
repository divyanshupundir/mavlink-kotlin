package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags for gimbal manager operation. Used for setting and reporting, unless specified otherwise.
 * If a setting has been accepted by the gimbal manager is reported in the
 * STORM32_GIMBAL_MANAGER_STATUS message.
 *
 */
@GeneratedMavEnum(bitmask = true)
public enum class MavStorm32GimbalManagerFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * 0 = ignore.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Request to set RC input to active, or report RC input is active. Implies RC mixed. RC exclusive
   * is achieved by setting all clients to inactive.
   */
  @GeneratedMavEnumEntry
  RC_ACTIVE(1u),
  /**
   * Request to set onboard/companion computer client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_ONBOARD_ACTIVE(2u),
  /**
   * Request to set autopliot client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_AUTOPILOT_ACTIVE(4u),
  /**
   * Request to set GCS client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_GCS_ACTIVE(8u),
  /**
   * Request to set camera client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_CAMERA_ACTIVE(16u),
  /**
   * Request to set GCS2 client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_GCS2_ACTIVE(32u),
  /**
   * Request to set camera2 client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_CAMERA2_ACTIVE(64u),
  /**
   * Request to set custom client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_CUSTOM_ACTIVE(128u),
  /**
   * Request to set custom2 client to active, or report this client is active.
   */
  @GeneratedMavEnumEntry
  CLIENT_CUSTOM2_ACTIVE(256u),
  /**
   * Request supervision. This flag is only for setting, it is not reported.
   */
  @GeneratedMavEnumEntry
  SET_SUPERVISON(512u),
  /**
   * Release supervision. This flag is only for setting, it is not reported.
   */
  @GeneratedMavEnumEntry
  SET_RELEASE(1_024u),
  ;

  public companion object : MavBitmask.MavCompanion<MavStorm32GimbalManagerFlags> {
    override fun getEntryFromValueOrNull(v: UInt): MavStorm32GimbalManagerFlags? = when (v) {
      0u -> NONE
      1u -> RC_ACTIVE
      2u -> CLIENT_ONBOARD_ACTIVE
      4u -> CLIENT_AUTOPILOT_ACTIVE
      8u -> CLIENT_GCS_ACTIVE
      16u -> CLIENT_CAMERA_ACTIVE
      32u -> CLIENT_GCS2_ACTIVE
      64u -> CLIENT_CAMERA2_ACTIVE
      128u -> CLIENT_CUSTOM_ACTIVE
      256u -> CLIENT_CUSTOM2_ACTIVE
      512u -> SET_SUPERVISON
      1024u -> SET_RELEASE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<MavStorm32GimbalManagerFlags> = buildList {
      if (v and 0u == 0u) add(NONE)
      if (v and 1u == 1u) add(RC_ACTIVE)
      if (v and 2u == 2u) add(CLIENT_ONBOARD_ACTIVE)
      if (v and 4u == 4u) add(CLIENT_AUTOPILOT_ACTIVE)
      if (v and 8u == 8u) add(CLIENT_GCS_ACTIVE)
      if (v and 16u == 16u) add(CLIENT_CAMERA_ACTIVE)
      if (v and 32u == 32u) add(CLIENT_GCS2_ACTIVE)
      if (v and 64u == 64u) add(CLIENT_CAMERA2_ACTIVE)
      if (v and 128u == 128u) add(CLIENT_CUSTOM_ACTIVE)
      if (v and 256u == 256u) add(CLIENT_CUSTOM2_ACTIVE)
      if (v and 512u == 512u) add(SET_SUPERVISON)
      if (v and 1024u == 1024u) add(SET_RELEASE)
    }
  }
}
