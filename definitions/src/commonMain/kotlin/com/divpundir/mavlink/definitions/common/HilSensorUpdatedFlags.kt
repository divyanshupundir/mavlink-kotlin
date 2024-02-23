package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Flags in the HIL_SENSOR message indicate which fields have updated since the last message
 */
@GeneratedMavEnum(bitmask = true)
public enum class HilSensorUpdatedFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * None of the fields in HIL_SENSOR have been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_NONE(0u),
  /**
   * The value in the xacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_XACC(1u),
  /**
   * The value in the yacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_YACC(2u),
  /**
   * The value in the zacc field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_ZACC(4u),
  /**
   * The value in the xgyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_XGYRO(8u),
  /**
   * The value in the ygyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_YGYRO(16u),
  /**
   * The value in the zgyro field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_ZGYRO(32u),
  /**
   * The value in the xmag field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_XMAG(64u),
  /**
   * The value in the ymag field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_YMAG(128u),
  /**
   * The value in the zmag field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_ZMAG(256u),
  /**
   * The value in the abs_pressure field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_ABS_PRESSURE(512u),
  /**
   * The value in the diff_pressure field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_DIFF_PRESSURE(1_024u),
  /**
   * The value in the pressure_alt field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_PRESSURE_ALT(2_048u),
  /**
   * The value in the temperature field has been updated
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_TEMPERATURE(4_096u),
  /**
   * Full reset of attitude/position/velocities/etc was performed in sim (Bit 31).
   */
  @GeneratedMavEnumEntry
  HIL_SENSOR_UPDATED_RESET(2_147_483_648u),
  ;

  public companion object : MavBitmask.MavCompanion<HilSensorUpdatedFlags> {
    override fun getEntryFromValueOrNull(v: UInt): HilSensorUpdatedFlags? = when (v) {
      0u -> HIL_SENSOR_UPDATED_NONE
      1u -> HIL_SENSOR_UPDATED_XACC
      2u -> HIL_SENSOR_UPDATED_YACC
      4u -> HIL_SENSOR_UPDATED_ZACC
      8u -> HIL_SENSOR_UPDATED_XGYRO
      16u -> HIL_SENSOR_UPDATED_YGYRO
      32u -> HIL_SENSOR_UPDATED_ZGYRO
      64u -> HIL_SENSOR_UPDATED_XMAG
      128u -> HIL_SENSOR_UPDATED_YMAG
      256u -> HIL_SENSOR_UPDATED_ZMAG
      512u -> HIL_SENSOR_UPDATED_ABS_PRESSURE
      1024u -> HIL_SENSOR_UPDATED_DIFF_PRESSURE
      2048u -> HIL_SENSOR_UPDATED_PRESSURE_ALT
      4096u -> HIL_SENSOR_UPDATED_TEMPERATURE
      2147483648u -> HIL_SENSOR_UPDATED_RESET
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<HilSensorUpdatedFlags> = buildList {
      if (v and 0u == 0u) add(HIL_SENSOR_UPDATED_NONE)
      if (v and 1u == 1u) add(HIL_SENSOR_UPDATED_XACC)
      if (v and 2u == 2u) add(HIL_SENSOR_UPDATED_YACC)
      if (v and 4u == 4u) add(HIL_SENSOR_UPDATED_ZACC)
      if (v and 8u == 8u) add(HIL_SENSOR_UPDATED_XGYRO)
      if (v and 16u == 16u) add(HIL_SENSOR_UPDATED_YGYRO)
      if (v and 32u == 32u) add(HIL_SENSOR_UPDATED_ZGYRO)
      if (v and 64u == 64u) add(HIL_SENSOR_UPDATED_XMAG)
      if (v and 128u == 128u) add(HIL_SENSOR_UPDATED_YMAG)
      if (v and 256u == 256u) add(HIL_SENSOR_UPDATED_ZMAG)
      if (v and 512u == 512u) add(HIL_SENSOR_UPDATED_ABS_PRESSURE)
      if (v and 1024u == 1024u) add(HIL_SENSOR_UPDATED_DIFF_PRESSURE)
      if (v and 2048u == 2048u) add(HIL_SENSOR_UPDATED_PRESSURE_ALT)
      if (v and 4096u == 4096u) add(HIL_SENSOR_UPDATED_TEMPERATURE)
      if (v and 2147483648u == 2147483648u) add(HIL_SENSOR_UPDATED_RESET)
    }
  }
}
