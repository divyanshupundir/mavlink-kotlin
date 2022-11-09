package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavBitmask

/**
 * Flags in the HIGHRES_IMU message indicate which fields have updated since the last message
 */
@GeneratedMavEnum(bitmask = true)
public enum class HighresImuUpdatedFlags(
  public override val `value`: Long,
) : MavBitmask {
  /**
   * None of the fields in HIGHRES_IMU have been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_NONE(0L),
  /**
   * The value in the xacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_XACC(1L),
  /**
   * The value in the yacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_YACC(2L),
  /**
   * The value in the zacc field has been updated since
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ZACC(4L),
  /**
   * The value in the xgyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_XGYRO(8L),
  /**
   * The value in the ygyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_YGYRO(16L),
  /**
   * The value in the zgyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ZGYRO(32L),
  /**
   * The value in the xmag field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_XMAG(64L),
  /**
   * The value in the ymag field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_YMAG(128L),
  /**
   * The value in the zmag field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ZMAG(256L),
  /**
   * The value in the abs_pressure field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ABS_PRESSURE(512L),
  /**
   * The value in the diff_pressure field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_DIFF_PRESSURE(1024L),
  /**
   * The value in the pressure_alt field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_PRESSURE_ALT(2048L),
  /**
   * The value in the temperature field has been updated
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_TEMPERATURE(4096L),
  /**
   * All fields in HIGHRES_IMU have been updated.
   */
  @GeneratedMavEnumEntry
  HIGHRES_IMU_UPDATED_ALL(65535L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): HighresImuUpdatedFlags? = when (v) {
      0L -> HIGHRES_IMU_UPDATED_NONE
      1L -> HIGHRES_IMU_UPDATED_XACC
      2L -> HIGHRES_IMU_UPDATED_YACC
      4L -> HIGHRES_IMU_UPDATED_ZACC
      8L -> HIGHRES_IMU_UPDATED_XGYRO
      16L -> HIGHRES_IMU_UPDATED_YGYRO
      32L -> HIGHRES_IMU_UPDATED_ZGYRO
      64L -> HIGHRES_IMU_UPDATED_XMAG
      128L -> HIGHRES_IMU_UPDATED_YMAG
      256L -> HIGHRES_IMU_UPDATED_ZMAG
      512L -> HIGHRES_IMU_UPDATED_ABS_PRESSURE
      1024L -> HIGHRES_IMU_UPDATED_DIFF_PRESSURE
      2048L -> HIGHRES_IMU_UPDATED_PRESSURE_ALT
      4096L -> HIGHRES_IMU_UPDATED_TEMPERATURE
      65535L -> HIGHRES_IMU_UPDATED_ALL
      else -> null
    }

    public fun getFlagsFromValue(v: Long): List<HighresImuUpdatedFlags> = buildList {
      if (v and 0L == 0L) add(HIGHRES_IMU_UPDATED_NONE)
      if (v and 1L == 1L) add(HIGHRES_IMU_UPDATED_XACC)
      if (v and 2L == 2L) add(HIGHRES_IMU_UPDATED_YACC)
      if (v and 4L == 4L) add(HIGHRES_IMU_UPDATED_ZACC)
      if (v and 8L == 8L) add(HIGHRES_IMU_UPDATED_XGYRO)
      if (v and 16L == 16L) add(HIGHRES_IMU_UPDATED_YGYRO)
      if (v and 32L == 32L) add(HIGHRES_IMU_UPDATED_ZGYRO)
      if (v and 64L == 64L) add(HIGHRES_IMU_UPDATED_XMAG)
      if (v and 128L == 128L) add(HIGHRES_IMU_UPDATED_YMAG)
      if (v and 256L == 256L) add(HIGHRES_IMU_UPDATED_ZMAG)
      if (v and 512L == 512L) add(HIGHRES_IMU_UPDATED_ABS_PRESSURE)
      if (v and 1024L == 1024L) add(HIGHRES_IMU_UPDATED_DIFF_PRESSURE)
      if (v and 2048L == 2048L) add(HIGHRES_IMU_UPDATED_PRESSURE_ALT)
      if (v and 4096L == 4096L) add(HIGHRES_IMU_UPDATED_TEMPERATURE)
      if (v and 65535L == 65535L) add(HIGHRES_IMU_UPDATED_ALL)
    }
  }
}
