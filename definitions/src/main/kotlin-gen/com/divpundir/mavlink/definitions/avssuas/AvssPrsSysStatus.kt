package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 *  AVSS PRS system status.
 */
@GeneratedMavMessage(
  id = 60_050u,
  crcExtra = -36,
)
public data class AvssPrsSysStatus(
  /**
   * Timestamp (time since PRS boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * PRS error statuses
   */
  @GeneratedMavField(type = "uint32_t")
  public val errorStatus: UInt = 0u,
  /**
   * Estimated battery run-time without a remote connection and PRS battery voltage
   */
  @GeneratedMavField(type = "uint32_t")
  public val batteryStatus: UInt = 0u,
  /**
   * PRS arm statuses
   */
  @GeneratedMavField(type = "uint8_t")
  public val armStatus: UByte = 0u,
  /**
   * PRS battery charge statuses
   */
  @GeneratedMavField(type = "uint8_t")
  public val chargeStatus: UByte = 0u,
) : MavMessage<AvssPrsSysStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<AvssPrsSysStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeUInt32(errorStatus)
    output.encodeUInt32(batteryStatus)
    output.encodeUInt8(armStatus)
    output.encodeUInt8(chargeStatus)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeUInt32(errorStatus)
    output.encodeUInt32(batteryStatus)
    output.encodeUInt8(armStatus)
    output.encodeUInt8(chargeStatus)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AvssPrsSysStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    public override val id: UInt = 60_050u

    public override val crcExtra: Byte = -36

    public override fun deserialize(source: BufferedSource): AvssPrsSysStatus {
      val timeBootMs = source.decodeUInt32()
      val errorStatus = source.decodeUInt32()
      val batteryStatus = source.decodeUInt32()
      val armStatus = source.decodeUInt8()
      val chargeStatus = source.decodeUInt8()

      return AvssPrsSysStatus(
        timeBootMs = timeBootMs,
        errorStatus = errorStatus,
        batteryStatus = batteryStatus,
        armStatus = armStatus,
        chargeStatus = chargeStatus,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AvssPrsSysStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var errorStatus: UInt = 0u

    public var batteryStatus: UInt = 0u

    public var armStatus: UByte = 0u

    public var chargeStatus: UByte = 0u

    public fun build(): AvssPrsSysStatus = AvssPrsSysStatus(
      timeBootMs = timeBootMs,
      errorStatus = errorStatus,
      batteryStatus = batteryStatus,
      armStatus = armStatus,
      chargeStatus = chargeStatus,
    )
  }
}
