package xyz.urbanmatrix.mavlink.definitions.ualberta

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Mode currently commanded by pilot
 */
@GeneratedMavEnum
public enum class UalbertaPilotMode(
  public override val `value`: UInt,
) : MavEnum {
  /**
   *  sdf
   */
  @GeneratedMavEnumEntry
  PILOT_MANUAL(1u),
  /**
   *  dfs
   */
  @GeneratedMavEnumEntry
  PILOT_AUTO(2u),
  /**
   *  Rotomotion mode 
   */
  @GeneratedMavEnumEntry
  PILOT_ROTO(3u),
  ;

  public companion object : MavEnum.Companion<UalbertaPilotMode> {
    public override fun getEntryFromValueOrNull(v: UInt): UalbertaPilotMode? = when (v) {
      1u -> PILOT_MANUAL
      2u -> PILOT_AUTO
      3u -> PILOT_ROTO
      else -> null
    }
  }
}
