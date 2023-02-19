package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Aircraft-rated danger from this threat.
 */
@GeneratedMavEnum
public enum class MavCollisionThreatLevel(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Not a threat
   */
  @GeneratedMavEnumEntry
  NONE(0u),
  /**
   * Craft is mildly concerned about this threat
   */
  @GeneratedMavEnumEntry
  LOW(1u),
  /**
   * Craft is panicking, and may take actions to avoid threat
   */
  @GeneratedMavEnumEntry
  HIGH(2u),
  ;

  public companion object : MavEnum.Companion<MavCollisionThreatLevel> {
    public override fun getEntryFromValueOrNull(v: UInt): MavCollisionThreatLevel? = when (v) {
      0u -> NONE
      1u -> LOW
      2u -> HIGH
      else -> null
    }
  }
}
