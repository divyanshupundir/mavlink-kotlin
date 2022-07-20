package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavEnum
import kotlin.Long

public enum class GoproRequestStatus(
  public override val `value`: Long,
) : MavEnum {
  /**
   * The write message with ID indicated succeeded.
   */
  GOPRO_REQUEST_SUCCESS(0L),
  /**
   * The write message with ID indicated failed.
   */
  GOPRO_REQUEST_FAILED(1L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): GoproRequestStatus? = when (v) {
      0L -> GOPRO_REQUEST_SUCCESS
      1L -> GOPRO_REQUEST_FAILED
      else -> null
    }
  }
}
