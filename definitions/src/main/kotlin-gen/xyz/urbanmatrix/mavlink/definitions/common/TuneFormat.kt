package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

/**
 * Tune formats (used for vehicle buzzer/tone generation).
 */
@GeneratedMavEnum
public enum class TuneFormat(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Format is QBasic 1.1 Play: https://www.qbasic.net/en/reference/qb11/Statement/PLAY-006.htm.
   */
  @GeneratedMavEnumEntry
  TUNE_FORMAT_QBASIC1_1(1L),
  /**
   * Format is Modern Music Markup Language (MML):
   * https://en.wikipedia.org/wiki/Music_Macro_Language#Modern_MML.
   */
  @GeneratedMavEnumEntry
  TUNE_FORMAT_MML_MODERN(2L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): TuneFormat? = when (v) {
      1L -> TUNE_FORMAT_QBASIC1_1
      2L -> TUNE_FORMAT_MML_MODERN
      else -> null
    }
  }
}
