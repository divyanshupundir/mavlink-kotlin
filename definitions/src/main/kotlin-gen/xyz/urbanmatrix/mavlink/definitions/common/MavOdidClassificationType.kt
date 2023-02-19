package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavOdidClassificationType(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * The classification type for the UA is undeclared.
   */
  @GeneratedMavEnumEntry
  UNDECLARED(0u),
  /**
   * The classification type for the UA follows EU (European Union) specifications.
   */
  @GeneratedMavEnumEntry
  EU(1u),
  ;

  public companion object : MavEnum.Companion<MavOdidClassificationType> {
    public override fun getEntryFromValueOrNull(v: UInt): MavOdidClassificationType? = when (v) {
      0u -> UNDECLARED
      1u -> EU
      else -> null
    }
  }
}
