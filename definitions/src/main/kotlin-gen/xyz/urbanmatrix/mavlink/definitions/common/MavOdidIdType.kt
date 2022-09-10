package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidIdType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No type defined.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_ID_TYPE_NONE(0L),
  /**
   * Manufacturer Serial Number (ANSI/CTA-2063 format).
   */
  @GeneratedMavEnumEntry
  MAV_ODID_ID_TYPE_SERIAL_NUMBER(1L),
  /**
   * CAA (Civil Aviation Authority) registered ID. Format: [ICAO Country Code].[CAA Assigned ID].
   */
  @GeneratedMavEnumEntry
  MAV_ODID_ID_TYPE_CAA_REGISTRATION_ID(2L),
  /**
   * UTM (Unmanned Traffic Management) assigned UUID (RFC4122).
   */
  @GeneratedMavEnumEntry
  MAV_ODID_ID_TYPE_UTM_ASSIGNED_UUID(3L),
  /**
   * A 20 byte ID for a specific flight/session. The exact ID type is indicated by the first byte of
   * uas_id and these type values are managed by ICAO.
   */
  @GeneratedMavEnumEntry
  MAV_ODID_ID_TYPE_SPECIFIC_SESSION_ID(4L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidIdType? = when (v) {
      0L -> MAV_ODID_ID_TYPE_NONE
      1L -> MAV_ODID_ID_TYPE_SERIAL_NUMBER
      2L -> MAV_ODID_ID_TYPE_CAA_REGISTRATION_ID
      3L -> MAV_ODID_ID_TYPE_UTM_ASSIGNED_UUID
      4L -> MAV_ODID_ID_TYPE_SPECIFIC_SESSION_ID
      else -> null
    }
  }
}
