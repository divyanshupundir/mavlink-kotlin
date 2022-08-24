package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
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
  FIRMWARE_VERSION_TYPE_DEV(0L),
  /**
   * alpha release
   */
  FIRMWARE_VERSION_TYPE_ALPHA(64L),
  /**
   * beta release
   */
  FIRMWARE_VERSION_TYPE_BETA(128L),
  /**
   * release candidate
   */
  FIRMWARE_VERSION_TYPE_RC(192L),
  /**
   * official stable release
   */
  FIRMWARE_VERSION_TYPE_OFFICIAL(255L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): FirmwareVersionType? = when (v) {
      0L -> FIRMWARE_VERSION_TYPE_DEV
      64L -> FIRMWARE_VERSION_TYPE_ALPHA
      128L -> FIRMWARE_VERSION_TYPE_BETA
      192L -> FIRMWARE_VERSION_TYPE_RC
      255L -> FIRMWARE_VERSION_TYPE_OFFICIAL
      else -> null
    }
  }
}
