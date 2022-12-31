package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidAuthType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No authentication type is specified.
   */
  @GeneratedMavEnumEntry
  NONE(0L),
  /**
   * Signature for the UAS (Unmanned Aircraft System) ID.
   */
  @GeneratedMavEnumEntry
  UAS_ID_SIGNATURE(1L),
  /**
   * Signature for the Operator ID.
   */
  @GeneratedMavEnumEntry
  OPERATOR_ID_SIGNATURE(2L),
  /**
   * Signature for the entire message set.
   */
  @GeneratedMavEnumEntry
  MESSAGE_SET_SIGNATURE(3L),
  /**
   * Authentication is provided by Network Remote ID.
   */
  @GeneratedMavEnumEntry
  NETWORK_REMOTE_ID(4L),
  /**
   * The exact authentication type is indicated by the first byte of authentication_data and these
   * type values are managed by ICAO.
   */
  @GeneratedMavEnumEntry
  SPECIFIC_AUTHENTICATION(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidAuthType? = when (v) {
      0L -> NONE
      1L -> UAS_ID_SIGNATURE
      2L -> OPERATOR_ID_SIGNATURE
      3L -> MESSAGE_SET_SIGNATURE
      4L -> NETWORK_REMOTE_ID
      5L -> SPECIFIC_AUTHENTICATION
      else -> null
    }
  }
}
