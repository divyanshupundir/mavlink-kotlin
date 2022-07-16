package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class MavOdidAuthType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * No authentication type is specified.
   */
  MAV_ODID_AUTH_TYPE_NONE(0L),
  /**
   * Signature for the UAS (Unmanned Aircraft System) ID.
   */
  MAV_ODID_AUTH_TYPE_UAS_ID_SIGNATURE(1L),
  /**
   * Signature for the Operator ID.
   */
  MAV_ODID_AUTH_TYPE_OPERATOR_ID_SIGNATURE(2L),
  /**
   * Signature for the entire message set.
   */
  MAV_ODID_AUTH_TYPE_MESSAGE_SET_SIGNATURE(3L),
  /**
   * Authentication is provided by Network Remote ID.
   */
  MAV_ODID_AUTH_TYPE_NETWORK_REMOTE_ID(4L),
  /**
   * The exact authentication type is indicated by the first byte of authentication_data and these
   * type values are managed by ICAO.
   */
  MAV_ODID_AUTH_TYPE_SPECIFIC_AUTHENTICATION(5L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavOdidAuthType? = when (v) {
      0L -> MAV_ODID_AUTH_TYPE_NONE
      1L -> MAV_ODID_AUTH_TYPE_UAS_ID_SIGNATURE
      2L -> MAV_ODID_AUTH_TYPE_OPERATOR_ID_SIGNATURE
      3L -> MAV_ODID_AUTH_TYPE_MESSAGE_SET_SIGNATURE
      4L -> MAV_ODID_AUTH_TYPE_NETWORK_REMOTE_ID
      5L -> MAV_ODID_AUTH_TYPE_SPECIFIC_AUTHENTICATION
      else -> null
    }
  }
}
