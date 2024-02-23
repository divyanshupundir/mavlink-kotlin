package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidIdType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No type defined.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Manufacturer Serial Number (ANSI/CTA-2063 format).
   */
  @GeneratedMavEnumEntry
  SERIAL_NUMBER(1u),
  /**
   * CAA (Civil Aviation Authority) registered ID. Format: [ICAO Country Code].[CAA Assigned ID].
   */
  @GeneratedMavEnumEntry
  CAA_REGISTRATION_ID(2u),
  /**
   * UTM (Unmanned Traffic Management) assigned UUID (RFC4122).
   */
  @GeneratedMavEnumEntry
  UTM_ASSIGNED_UUID(3u),
  /**
   * A 20 byte ID for a specific flight/session. The exact ID type is indicated by the first byte of
   * uas_id and these type values are managed by ICAO.
   */
  @GeneratedMavEnumEntry
  SPECIFIC_SESSION_ID(4u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidIdType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidIdType? = when (v) {
      0u -> NONE
      1u -> SERIAL_NUMBER
      2u -> CAA_REGISTRATION_ID
      3u -> UTM_ASSIGNED_UUID
      4u -> SPECIFIC_SESSION_ID
      else -> null
    }
  }
}
