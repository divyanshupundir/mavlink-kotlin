package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags in the HIGHRES_IMU message indicate which fields have updated since the last message
 */
@GeneratedMavEnum(bitmask = true)
public enum class HighresImuUpdatedFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * None of the fields in HIGHRES_IMU have been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_NONE(0u),
  /**
   * The value in the xacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_XACC(1u),
  /**
   * The value in the yacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_YACC(2u),
  /**
   * The value in the zacc field has been updated since
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ZACC(4u),
  /**
   * The value in the xgyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_XGYRO(8u),
  /**
   * The value in the ygyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_YGYRO(16u),
  /**
   * The value in the zgyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ZGYRO(32u),
  /**
   * The value in the xmag field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_XMAG(64u),
  /**
   * The value in the ymag field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_YMAG(128u),
  /**
   * The value in the zmag field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ZMAG(256u),
  /**
   * The value in the abs_pressure field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ABS_PRESSURE(512u),
  /**
   * The value in the diff_pressure field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_DIFF_PRESSURE(1_024u),
  /**
   * The value in the pressure_alt field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_PRESSURE_ALT(2_048u),
  /**
   * The value in the temperature field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_TEMPERATURE(4_096u),
  /**
   * All fields in HIGHRES_IMU have been updated.
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ALL(65_535u),
  ;

  public companion object : MavBitmask.MavCompanion<HighresImuUpdatedFlags> {
    override fun getEntryFromValueOrNull(v: UInt): HighresImuUpdatedFlags? = when (v) {
      0u -> HIGHRES_IMU_UPDATED_NONE
      1u -> HIGHRES_IMU_UPDATED_XACC
      2u -> HIGHRES_IMU_UPDATED_YACC
      4u -> HIGHRES_IMU_UPDATED_ZACC
      8u -> HIGHRES_IMU_UPDATED_XGYRO
      16u -> HIGHRES_IMU_UPDATED_YGYRO
      32u -> HIGHRES_IMU_UPDATED_ZGYRO
      64u -> HIGHRES_IMU_UPDATED_XMAG
      128u -> HIGHRES_IMU_UPDATED_YMAG
      256u -> HIGHRES_IMU_UPDATED_ZMAG
      512u -> HIGHRES_IMU_UPDATED_ABS_PRESSURE
      1024u -> HIGHRES_IMU_UPDATED_DIFF_PRESSURE
      2048u -> HIGHRES_IMU_UPDATED_PRESSURE_ALT
      4096u -> HIGHRES_IMU_UPDATED_TEMPERATURE
      65535u -> HIGHRES_IMU_UPDATED_ALL
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<HighresImuUpdatedFlags> = buildList {
      if (v and 0u == 0u) add(HIGHRES_IMU_UPDATED_NONE)
      if (v and 1u == 1u) add(HIGHRES_IMU_UPDATED_XACC)
      if (v and 2u == 2u) add(HIGHRES_IMU_UPDATED_YACC)
      if (v and 4u == 4u) add(HIGHRES_IMU_UPDATED_ZACC)
      if (v and 8u == 8u) add(HIGHRES_IMU_UPDATED_XGYRO)
      if (v and 16u == 16u) add(HIGHRES_IMU_UPDATED_YGYRO)
      if (v and 32u == 32u) add(HIGHRES_IMU_UPDATED_ZGYRO)
      if (v and 64u == 64u) add(HIGHRES_IMU_UPDATED_XMAG)
      if (v and 128u == 128u) add(HIGHRES_IMU_UPDATED_YMAG)
      if (v and 256u == 256u) add(HIGHRES_IMU_UPDATED_ZMAG)
      if (v and 512u == 512u) add(HIGHRES_IMU_UPDATED_ABS_PRESSURE)
      if (v and 1024u == 1024u) add(HIGHRES_IMU_UPDATED_DIFF_PRESSURE)
      if (v and 2048u == 2048u) add(HIGHRES_IMU_UPDATED_PRESSURE_ALT)
      if (v and 4096u == 4096u) add(HIGHRES_IMU_UPDATED_TEMPERATURE)
      if (v and 65535u == 65535u) add(HIGHRES_IMU_UPDATED_ALL)
    }
  }
}
