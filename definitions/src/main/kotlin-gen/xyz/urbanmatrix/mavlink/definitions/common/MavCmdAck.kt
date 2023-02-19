package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * ACK / NACK / ERROR values as a result of MAV_CMDs and for mission item transmission.
 */
@GeneratedMavEnum
public enum class MavCmdAck(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Command / mission item is ok.
   */
  @GeneratedMavEnumEntry
  OK(0u),
  /**
   * Generic error message if none of the other reasons fails or if no detailed error reporting is
   * implemented.
   */
  @GeneratedMavEnumEntry
  ERR_FAIL(1u),
  /**
   * The system is refusing to accept this command from this source / communication partner.
   */
  @GeneratedMavEnumEntry
  ERR_ACCESS_DENIED(2u),
  /**
   * Command or mission item is not supported, other commands would be accepted.
   */
  @GeneratedMavEnumEntry
  ERR_NOT_SUPPORTED(3u),
  /**
   * The coordinate frame of this command / mission item is not supported.
   */
  @GeneratedMavEnumEntry
  ERR_COORDINATE_FRAME_NOT_SUPPORTED(4u),
  /**
   * The coordinate frame of this command is ok, but he coordinate values exceed the safety limits
   * of this system. This is a generic error, please use the more specific error messages below if
   * possible.
   */
  @GeneratedMavEnumEntry
  ERR_COORDINATES_OUT_OF_RANGE(5u),
  /**
   * The X or latitude value is out of range.
   */
  @GeneratedMavEnumEntry
  ERR_X_LAT_OUT_OF_RANGE(6u),
  /**
   * The Y or longitude value is out of range.
   */
  @GeneratedMavEnumEntry
  ERR_Y_LON_OUT_OF_RANGE(7u),
  /**
   * The Z or altitude value is out of range.
   */
  @GeneratedMavEnumEntry
  ERR_Z_ALT_OUT_OF_RANGE(8u),
  ;

  public companion object : MavEnum.Companion<MavCmdAck> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCmdAck? = when (v) {
      0u -> OK
      1u -> ERR_FAIL
      2u -> ERR_ACCESS_DENIED
      3u -> ERR_NOT_SUPPORTED
      4u -> ERR_COORDINATE_FRAME_NOT_SUPPORTED
      5u -> ERR_COORDINATES_OUT_OF_RANGE
      6u -> ERR_X_LAT_OUT_OF_RANGE
      7u -> ERR_Y_LON_OUT_OF_RANGE
      8u -> ERR_Z_ALT_OUT_OF_RANGE
      else -> null
    }
  }
}
