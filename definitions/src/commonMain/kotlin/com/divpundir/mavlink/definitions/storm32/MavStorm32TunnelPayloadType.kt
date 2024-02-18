package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavStorm32TunnelPayloadType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Registered for STorM32 gimbal controller. For communication with gimbal or camera.
   */
  @GeneratedMavEnumEntry
  STORM32_CH1_IN(200u),
  /**
   * Registered for STorM32 gimbal controller. For communication with gimbal or camera.
   */
  @GeneratedMavEnumEntry
  STORM32_CH1_OUT(201u),
  /**
   * Registered for STorM32 gimbal controller. For communication with gimbal.
   */
  @GeneratedMavEnumEntry
  STORM32_CH2_IN(202u),
  /**
   * Registered for STorM32 gimbal controller. For communication with gimbal.
   */
  @GeneratedMavEnumEntry
  STORM32_CH2_OUT(203u),
  /**
   * Registered for STorM32 gimbal controller. For communication with camera.
   */
  @GeneratedMavEnumEntry
  STORM32_CH3_IN(204u),
  /**
   * Registered for STorM32 gimbal controller. For communication with camera.
   */
  @GeneratedMavEnumEntry
  STORM32_CH3_OUT(205u),
  ;

  public companion object : MavEnum.MavCompanion<MavStorm32TunnelPayloadType> {
    override fun getEntryFromValueOrNull(v: UInt): MavStorm32TunnelPayloadType? = when (v) {
      200u -> STORM32_CH1_IN
      201u -> STORM32_CH1_OUT
      202u -> STORM32_CH2_IN
      203u -> STORM32_CH2_OUT
      204u -> STORM32_CH3_IN
      205u -> STORM32_CH3_OUT
      else -> null
    }
  }
}
