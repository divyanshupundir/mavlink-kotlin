package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These values define the type of firmware release.  These values indicate the first version or
 * release of this type.  For example the first alpha release would be 64, the second would be 65.
 */
@GeneratedMavEnum
public enum class FirmwareVersionType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * development release
   */
  @GeneratedMavEnumEntry
  DEV(0L),
  /**
   * alpha release
   */
  @GeneratedMavEnumEntry
  ALPHA(64L),
  /**
   * beta release
   */
  @GeneratedMavEnumEntry
  BETA(128L),
  /**
   * release candidate
   */
  @GeneratedMavEnumEntry
  RC(192L),
  /**
   * official stable release
   */
  @GeneratedMavEnumEntry
  OFFICIAL(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FirmwareVersionType? = when (v) {
      0L -> DEV
      64L -> ALPHA
      128L -> BETA
      192L -> RC
      255L -> OFFICIAL
      else -> null
    }
  }
}
