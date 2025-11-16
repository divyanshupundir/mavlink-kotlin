package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavBitmask
import kotlin.UInt
import kotlin.collections.List

/**
 * Airspeed sensor flags
 */
@GeneratedMavEnum(bitmask = true)
public enum class AirspeedSensorFlags(
  override val `value`: UInt,
) : MavBitmask {
  /**
   * Airspeed sensor is unhealthy
   */
  @GeneratedMavEnumEntry
  AIRSPEED_SENSOR_UNHEALTHY(1u),
  /**
   * True if the data from this sensor is being actively used by the flight controller for guidance,
   * navigation or control.
   */
  @GeneratedMavEnumEntry
  AIRSPEED_SENSOR_USING(2u),
  ;

  public companion object : MavBitmask.MavCompanion<AirspeedSensorFlags> {
    override fun getEntryFromValueOrNull(v: UInt): AirspeedSensorFlags? = when (v) {
      1u -> AIRSPEED_SENSOR_UNHEALTHY
      2u -> AIRSPEED_SENSOR_USING
      else -> null
    }

    override fun getFlagsFromValue(v: UInt): List<AirspeedSensorFlags> = buildList {
      if (v and 1u == 1u) add(AIRSPEED_SENSOR_UNHEALTHY)
      if (v and 2u == 2u) add(AIRSPEED_SENSOR_USING)
    }
  }
}
