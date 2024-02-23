package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Tune formats (used for vehicle buzzer/tone generation).
 */
@GeneratedMavEnum
public enum class TuneFormat(
  override val `value`: UInt,
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

  public companion object : MavEnum.MavCompanion<TuneFormat> {
    override fun getEntryFromValueOrNull(v: UInt): TuneFormat? = when (v) {
      1u -> QBASIC1_1
      2u -> MML_MODERN
      else -> null
    }
  }
}
