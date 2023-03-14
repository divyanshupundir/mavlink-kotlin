package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.UInt
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Tune formats (used for vehicle buzzer/tone generation).
 */
@GeneratedMavEnum
public enum class TuneFormat(
  public override val `value`: UInt,
) : MavEnum {
  /**
   * Format is QBasic 1.1 Play: https://www.qbasic.net/en/reference/qb11/Statement/PLAY-006.htm.
   */
  @GeneratedMavEnumEntry
  QBASIC1_1(1u),
  /**
   * Format is Modern Music Markup Language (MML):
   * https://en.wikipedia.org/wiki/Music_Macro_Language#Modern_MML.
   */
  @GeneratedMavEnumEntry
  MML_MODERN(2u),
  ;

  public companion object : MavEnum.Companion<TuneFormat> {
    public override fun getEntryFromValueOrNull(v: UInt): TuneFormat? = when (v) {
      1u -> QBASIC1_1
      2u -> MML_MODERN
      else -> null
    }
  }
}
