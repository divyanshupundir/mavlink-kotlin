package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavEnum
import com.divpundir.mavlink.api.GeneratedMavEnumEntry
import com.divpundir.mavlink.api.MavEnum
import kotlin.UInt

@GeneratedMavEnum
public enum class MavTunnelPayloadType(
  override val `value`: UInt,
) : MavEnum {
  /**
   * Encoding of payload unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED0(200u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED1(201u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED2(202u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED3(203u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED4(204u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED5(205u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED6(206u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED7(207u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED8(208u),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED9(209u),
  /**
   * Registered for ModalAI remote OSD protocol.
   */
  @GeneratedMavEnumEntry
  MODALAI_REMOTE_OSD(210u),
  /**
   * Registered for ModalAI ESC UART passthru protocol.
   */
  @GeneratedMavEnumEntry
  MODALAI_ESC_UART_PASSTHRU(211u),
  /**
   * Registered for ModalAI vendor use.
   */
  @GeneratedMavEnumEntry
  MODALAI_IO_UART_PASSTHRU(212u),
  ;

  public companion object : MavEnum.MavCompanion<MavTunnelPayloadType> {
    override fun getEntryFromValueOrNull(v: UInt): MavTunnelPayloadType? = when (v) {
      0u -> UNKNOWN
      200u -> STORM32_RESERVED0
      201u -> STORM32_RESERVED1
      202u -> STORM32_RESERVED2
      203u -> STORM32_RESERVED3
      204u -> STORM32_RESERVED4
      205u -> STORM32_RESERVED5
      206u -> STORM32_RESERVED6
      207u -> STORM32_RESERVED7
      208u -> STORM32_RESERVED8
      209u -> STORM32_RESERVED9
      210u -> MODALAI_REMOTE_OSD
      211u -> MODALAI_ESC_UART_PASSTHRU
      212u -> MODALAI_IO_UART_PASSTHRU
      else -> null
    }
  }
}
