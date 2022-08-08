package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavEnum
import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Flags in the HIGHRES_IMU message indicate which fields have updated since the last message
 */
@GeneratedMavEnum
public enum class HighresImuUpdatedFlags(
  public override val `value`: Long,
) : MavEnum {
  /**
   * None of the fields in HIGHRES_IMU have been updated
   */
  HIGHRES_IMU_UPDATED_NONE(0L),
  /**
   * The value in the xacc field has been updated
   */
  HIGHRES_IMU_UPDATED_XACC(1L),
  /**
   * The value in the yacc field has been updated
   */
  HIGHRES_IMU_UPDATED_YACC(2L),
  /**
   * The value in the zacc field has been updated since
   */
  HIGHRES_IMU_UPDATED_ZACC(4L),
  /**
   * The value in the xgyro field has been updated
   */
  HIGHRES_IMU_UPDATED_XGYRO(8L),
  /**
   * The value in the ygyro field has been updated
   */
  HIGHRES_IMU_UPDATED_YGYRO(16L),
  /**
   * The value in the zgyro field has been updated
   */
  HIGHRES_IMU_UPDATED_ZGYRO(32L),
  /**
   * The value in the xmag field has been updated
   */
  HIGHRES_IMU_UPDATED_XMAG(64L),
  /**
   * The value in the ymag field has been updated
   */
  HIGHRES_IMU_UPDATED_YMAG(128L),
  /**
   * The value in the zmag field has been updated
   */
  HIGHRES_IMU_UPDATED_ZMAG(256L),
  /**
   * The value in the abs_pressure field has been updated
   */
  HIGHRES_IMU_UPDATED_ABS_PRESSURE(512L),
  /**
   * The value in the diff_pressure field has been updated
   */
  HIGHRES_IMU_UPDATED_DIFF_PRESSURE(1024L),
  /**
   * The value in the pressure_alt field has been updated
   */
  HIGHRES_IMU_UPDATED_PRESSURE_ALT(2048L),
  /**
   * The value in the temperature field has been updated
   */
  HIGHRES_IMU_UPDATED_TEMPERATURE(4096L),
  /**
   * All fields in HIGHRES_IMU have been updated.
   */
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
  }
}
