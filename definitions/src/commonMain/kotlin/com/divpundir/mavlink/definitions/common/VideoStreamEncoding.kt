package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

/**
 * Video stream encodings
 */
@GeneratedMavEnum
public enum class VideoStreamEncoding(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Stream encoding is unknown
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Stream encoding is H.264
   */
  @GeneratedMavEnumEntry
  H264(1u),
  /**
   * Stream encoding is H.265
   */
  @GeneratedMavEnumEntry
  H265(2u),
  ;

  public companion object : MavEnum.MavCompanion<VideoStreamEncoding> {
    override fun getEntryFromValueOrNull(v: UInt): VideoStreamEncoding? = when (v) {
      0u -> UNKNOWN
      1u -> H264
      2u -> H265
      else -> null
    }
  }
}
