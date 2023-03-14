package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidIdType(
  public override val `value`: UInt,
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

  public companion object : MavEnum.Companion<MavOdidIdType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidIdType? = when (v) {
      0u -> NONE
      1u -> SERIAL_NUMBER
      2u -> CAA_REGISTRATION_ID
      3u -> UTM_ASSIGNED_UUID
      4u -> SPECIFIC_SESSION_ID
      else -> null
    }
  }
}
