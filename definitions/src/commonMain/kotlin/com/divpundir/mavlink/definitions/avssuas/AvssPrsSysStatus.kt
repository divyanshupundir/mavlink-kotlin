package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 *  AVSS PRS system status.
 *
 * @param timeBootMs Timestamp (time since PRS boot).
 * units = ms
 * @param errorStatus PRS error statuses
 * @param batteryStatus Estimated battery run-time without a remote connection and PRS battery
 * voltage
 * @param armStatus PRS arm statuses
 * @param chargeStatus PRS battery charge statuses
 */
@GeneratedMavMessage(
  id = 60_050u,
  crcExtra = -36,
)
public data class AvssPrsSysStatus(
  /**
   * Timestamp (time since PRS boot).
   * units = ms
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
  override val instanceCompanion: MavMessage.MavCompanion<AvssPrsSysStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(errorStatus)
    encoder.encodeUInt32(batteryStatus)
    encoder.encodeUInt8(armStatus)
    encoder.encodeUInt8(chargeStatus)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(errorStatus)
    encoder.encodeUInt32(batteryStatus)
    encoder.encodeUInt8(armStatus)
    encoder.encodeUInt8(chargeStatus)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssPrsSysStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    override val id: UInt = 60_050u

    override val crcExtra: Byte = -36

    override fun deserialize(bytes: ByteArray): AvssPrsSysStatus {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val errorStatus = decoder.safeDecodeUInt32()
      val batteryStatus = decoder.safeDecodeUInt32()
      val armStatus = decoder.safeDecodeUInt8()
      val chargeStatus = decoder.safeDecodeUInt8()

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
