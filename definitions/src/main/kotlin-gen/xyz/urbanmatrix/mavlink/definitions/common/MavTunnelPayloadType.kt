package xyz.urbanmatrix.mavlink.definitions.common

import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnum
import xyz.urbanmatrix.mavlink.api.GeneratedMavEnumEntry
import xyz.urbanmatrix.mavlink.api.MavEnum

@GeneratedMavEnum
public enum class MavTunnelPayloadType(
  public override val `value`: Long,
) : MavEnum {
  /**
   * Encoding of payload unknown.
   */
  @GeneratedMavEnumEntry
  UNKNOWN(0L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED0(200L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED1(201L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED2(202L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED3(203L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED4(204L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED5(205L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED6(206L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED7(207L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED8(208L),
  /**
   * Registered for STorM32 gimbal controller.
   */
  @GeneratedMavEnumEntry
  STORM32_RESERVED9(209L),
  ;

  public companion object {
    public fun getEntryFromValueOrNull(v: Long): MavTunnelPayloadType? = when (v) {
      0L -> UNKNOWN
      200L -> STORM32_RESERVED0
      201L -> STORM32_RESERVED1
      202L -> STORM32_RESERVED2
      203L -> STORM32_RESERVED3
      204L -> STORM32_RESERVED4
      205L -> STORM32_RESERVED5
      206L -> STORM32_RESERVED6
      207L -> STORM32_RESERVED7
      208L -> STORM32_RESERVED8
      209L -> STORM32_RESERVED9
      else -> null
    }
  }
}
