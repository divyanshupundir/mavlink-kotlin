package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavOdidAuthType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * No authentication type is specified.
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Signature for the UAS (Unmanned Aircraft System) ID.
   */
  @GeneratedMavEnumEntry
  UAS_ID_SIGNATURE(1u),
  /**
   * Signature for the Operator ID.
   */
  @GeneratedMavEnumEntry
  OPERATOR_ID_SIGNATURE(2u),
  /**
   * Signature for the entire message set.
   */
  @GeneratedMavEnumEntry
  MESSAGE_SET_SIGNATURE(3u),
  /**
   * Authentication is provided by Network Remote ID.
   */
  @GeneratedMavEnumEntry
  NETWORK_REMOTE_ID(4u),
  /**
   * The exact authentication type is indicated by the first byte of authentication_data and these
   * type values are managed by ICAO.
   */
  @GeneratedMavEnumEntry
  SPECIFIC_AUTHENTICATION(5u),
  ;

  public companion object : MavEnum.MavCompanion<MavOdidAuthType> {
    override fun getEntryFromValueOrNull(v: UInt): MavOdidAuthType? = when (v) {
      0u -> NONE
      1u -> UAS_ID_SIGNATURE
      2u -> OPERATOR_ID_SIGNATURE
      3u -> MESSAGE_SET_SIGNATURE
      4u -> NETWORK_REMOTE_ID
      5u -> SPECIFIC_AUTHENTICATION
      else -> null
    }
  }
}
