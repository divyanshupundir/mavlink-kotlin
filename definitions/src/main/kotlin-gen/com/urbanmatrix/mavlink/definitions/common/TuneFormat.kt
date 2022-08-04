package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

/**
 * Tune formats (used for vehicle buzzer/tone generation).
 */
public enum class TuneFormat(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Format is QBasic 1.1 Play: https://www.qbasic.net/en/reference/qb11/Statement/PLAY-006.htm.
   */
  TUNE_FORMAT_QBASIC1_1(1L),
  /**
   * Format is Modern Music Markup Language (MML):
   * https://en.wikipedia.org/wiki/Music_Macro_Language#Modern_MML.
   */
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
