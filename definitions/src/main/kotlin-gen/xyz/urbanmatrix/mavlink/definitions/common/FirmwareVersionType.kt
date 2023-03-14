package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * These values define the type of firmware release.  These values indicate the first version or
 * release of this type.  For example the first alpha release would be 64, the second would be 65.
 */
@GeneratedMavEnum
public enum class FirmwareVersionType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * development release
   */
  @GeneratedMavEnumEntry
  DEV(0u),
  /**
   * alpha release
   */
  @GeneratedMavEnumEntry
  ALPHA(64u),
  /**
   * beta release
   */
  @GeneratedMavEnumEntry
  BETA(128u),
  /**
   * release candidate
   */
  @GeneratedMavEnumEntry
  RC(192u),
  /**
   * official stable release
   */
  @GeneratedMavEnumEntry
  OFFICIAL(255u),
  ;

  public companion object : MavEnum.Companion<FirmwareVersionType> {
    public override fun getEntryFromValueOrNull(v: UInt): FirmwareVersionType? = when (v) {
      0u -> DEV
      64u -> ALPHA
      128u -> BETA
      192u -> RC
      255u -> OFFICIAL
      else -> null
    }
  }
}
