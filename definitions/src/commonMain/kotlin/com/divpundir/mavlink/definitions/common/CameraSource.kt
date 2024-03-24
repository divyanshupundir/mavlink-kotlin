package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Camera sources for MAV_CMD_SET_CAMERA_SOURCE
 */
@GeneratedMavEnum
public enum class CameraSource(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Default camera source.
   */
  @GeneratedMavEnumEntry
  DEFAULT(0u),
  /**
   * RGB camera source.
   */
  @GeneratedMavEnumEntry
  RGB(1u),
  /**
   * IR camera source.
   */
  @GeneratedMavEnumEntry
  IR(2u),
  /**
   * NDVI camera source.
   */
  @GeneratedMavEnumEntry
  NDVI(3u),
  ;

  public companion object : MavEnum.MavCompanion<CameraSource> {
    override fun getEntryFromValueOrNull(v: UInt): CameraSource? = when (v) {
      0u -> DEFAULT
      1u -> RGB
      2u -> IR
      3u -> NDVI
      else -> null
    }
  }
}
