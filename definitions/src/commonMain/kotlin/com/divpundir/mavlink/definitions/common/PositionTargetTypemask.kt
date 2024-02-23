package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of
 * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions should be
 * ignored. If bit 9 is set the floats afx afy afz should be interpreted as force instead of
 * acceleration.
 */
@GeneratedMavEnum(bitmask = true)
public enum class PositionTargetTypemask(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Ignore position x
   */
  @GeneratedMavEnumEntry
  X_IGNORE(1u),
  /**
   * Ignore position y
   */
  @GeneratedMavEnumEntry
  Y_IGNORE(2u),
  /**
   * Ignore position z
   */
  @GeneratedMavEnumEntry
  Z_IGNORE(4u),
  /**
   * Ignore velocity x
   */
  @GeneratedMavEnumEntry
  VX_IGNORE(8u),
  /**
   * Ignore velocity y
   */
  @GeneratedMavEnumEntry
  VY_IGNORE(16u),
  /**
   * Ignore velocity z
   */
  @GeneratedMavEnumEntry
  VZ_IGNORE(32u),
  /**
   * Ignore acceleration x
   */
  @GeneratedMavEnumEntry
  AX_IGNORE(64u),
  /**
   * Ignore acceleration y
   */
  @GeneratedMavEnumEntry
  AY_IGNORE(128u),
  /**
   * Ignore acceleration z
   */
  @GeneratedMavEnumEntry
  AZ_IGNORE(256u),
  /**
   * Use force instead of acceleration
   */
  @GeneratedMavEnumEntry
  FORCE_SET(512u),
  /**
   * Ignore yaw
   */
  @GeneratedMavEnumEntry
  YAW_IGNORE(1_024u),
  /**
   * Ignore yaw rate
   */
  @GeneratedMavEnumEntry
  YAW_RATE_IGNORE(2_048u),
  ;

  public companion object : MavBitmask.MavCompanion<PositionTargetTypemask> {
    override fun getEntryFromValueOrNull(v: UInt): PositionTargetTypemask? = when (v) {
      1u -> X_IGNORE
      2u -> Y_IGNORE
      4u -> Z_IGNORE
      8u -> VX_IGNORE
      16u -> VY_IGNORE
      32u -> VZ_IGNORE
      64u -> AX_IGNORE
      128u -> AY_IGNORE
      256u -> AZ_IGNORE
      512u -> FORCE_SET
      1024u -> YAW_IGNORE
      2048u -> YAW_RATE_IGNORE
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<PositionTargetTypemask> = buildList {
      if (v and 1u == 1u) add(X_IGNORE)
      if (v and 2u == 2u) add(Y_IGNORE)
      if (v and 4u == 4u) add(Z_IGNORE)
      if (v and 8u == 8u) add(VX_IGNORE)
      if (v and 16u == 16u) add(VY_IGNORE)
      if (v and 32u == 32u) add(VZ_IGNORE)
      if (v and 64u == 64u) add(AX_IGNORE)
      if (v and 128u == 128u) add(AY_IGNORE)
      if (v and 256u == 256u) add(AZ_IGNORE)
      if (v and 512u == 512u) add(FORCE_SET)
      if (v and 1024u == 1024u) add(YAW_IGNORE)
      if (v and 2048u == 2048u) add(YAW_RATE_IGNORE)
    }
  }
}
