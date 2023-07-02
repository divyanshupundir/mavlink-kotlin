package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Monitoring of power board status
 */
@GeneratedMavMessage(
  id = 8_013u,
  crcExtra = -34,
)
public data class SensPowerBoard(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   * Power board status register
   */
  @GeneratedMavField(type = "uint8_t")
  public val pwrBrdStatus: UByte = 0u,
  /**
   * Power board leds status
   */
  @GeneratedMavField(type = "uint8_t")
  public val pwrBrdLedStatus: UByte = 0u,
  /**
   * Power board system voltage
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdSystemVolt: Float = 0F,
  /**
   * Power board servo voltage
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdServoVolt: Float = 0F,
  /**
   * Power board digital voltage
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdDigitalVolt: Float = 0F,
  /**
   * Power board left motor current sensor
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdMotLAmp: Float = 0F,
  /**
   * Power board right motor current sensor
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdMotRAmp: Float = 0F,
  /**
   * Power board analog current sensor
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdAnalogAmp: Float = 0F,
  /**
   * Power board digital current sensor
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdDigitalAmp: Float = 0F,
  /**
   * Power board extension current sensor
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdExtAmp: Float = 0F,
  /**
   * Power board aux current sensor
   */
  @GeneratedMavField(type = "float")
  public val pwrBrdAuxAmp: Float = 0F,
) : MavMessage<SensPowerBoard> {
  public override val instanceCompanion: MavMessage.MavCompanion<SensPowerBoard> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(pwrBrdSystemVolt)
    encoder.encodeFloat(pwrBrdServoVolt)
    encoder.encodeFloat(pwrBrdDigitalVolt)
    encoder.encodeFloat(pwrBrdMotLAmp)
    encoder.encodeFloat(pwrBrdMotRAmp)
    encoder.encodeFloat(pwrBrdAnalogAmp)
    encoder.encodeFloat(pwrBrdDigitalAmp)
    encoder.encodeFloat(pwrBrdExtAmp)
    encoder.encodeFloat(pwrBrdAuxAmp)
    encoder.encodeUInt8(pwrBrdStatus)
    encoder.encodeUInt8(pwrBrdLedStatus)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(pwrBrdSystemVolt)
    encoder.encodeFloat(pwrBrdServoVolt)
    encoder.encodeFloat(pwrBrdDigitalVolt)
    encoder.encodeFloat(pwrBrdMotLAmp)
    encoder.encodeFloat(pwrBrdMotRAmp)
    encoder.encodeFloat(pwrBrdAnalogAmp)
    encoder.encodeFloat(pwrBrdDigitalAmp)
    encoder.encodeFloat(pwrBrdExtAmp)
    encoder.encodeFloat(pwrBrdAuxAmp)
    encoder.encodeUInt8(pwrBrdStatus)
    encoder.encodeUInt8(pwrBrdLedStatus)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensPowerBoard> {
    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    public override val id: UInt = 8_013u

    public override val crcExtra: Byte = -34

    public override fun deserialize(bytes: ByteArray): SensPowerBoard {
      val decoder = MavDataDecoder.wrap(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val pwrBrdSystemVolt = decoder.safeDecodeFloat()
      val pwrBrdServoVolt = decoder.safeDecodeFloat()
      val pwrBrdDigitalVolt = decoder.safeDecodeFloat()
      val pwrBrdMotLAmp = decoder.safeDecodeFloat()
      val pwrBrdMotRAmp = decoder.safeDecodeFloat()
      val pwrBrdAnalogAmp = decoder.safeDecodeFloat()
      val pwrBrdDigitalAmp = decoder.safeDecodeFloat()
      val pwrBrdExtAmp = decoder.safeDecodeFloat()
      val pwrBrdAuxAmp = decoder.safeDecodeFloat()
      val pwrBrdStatus = decoder.safeDecodeUInt8()
      val pwrBrdLedStatus = decoder.safeDecodeUInt8()

      return SensPowerBoard(
        timestamp = timestamp,
        pwrBrdStatus = pwrBrdStatus,
        pwrBrdLedStatus = pwrBrdLedStatus,
        pwrBrdSystemVolt = pwrBrdSystemVolt,
        pwrBrdServoVolt = pwrBrdServoVolt,
        pwrBrdDigitalVolt = pwrBrdDigitalVolt,
        pwrBrdMotLAmp = pwrBrdMotLAmp,
        pwrBrdMotRAmp = pwrBrdMotRAmp,
        pwrBrdAnalogAmp = pwrBrdAnalogAmp,
        pwrBrdDigitalAmp = pwrBrdDigitalAmp,
        pwrBrdExtAmp = pwrBrdExtAmp,
        pwrBrdAuxAmp = pwrBrdAuxAmp,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SensPowerBoard =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var pwrBrdStatus: UByte = 0u

    public var pwrBrdLedStatus: UByte = 0u

    public var pwrBrdSystemVolt: Float = 0F

    public var pwrBrdServoVolt: Float = 0F

    public var pwrBrdDigitalVolt: Float = 0F

    public var pwrBrdMotLAmp: Float = 0F

    public var pwrBrdMotRAmp: Float = 0F

    public var pwrBrdAnalogAmp: Float = 0F

    public var pwrBrdDigitalAmp: Float = 0F

    public var pwrBrdExtAmp: Float = 0F

    public var pwrBrdAuxAmp: Float = 0F

    public fun build(): SensPowerBoard = SensPowerBoard(
      timestamp = timestamp,
      pwrBrdStatus = pwrBrdStatus,
      pwrBrdLedStatus = pwrBrdLedStatus,
      pwrBrdSystemVolt = pwrBrdSystemVolt,
      pwrBrdServoVolt = pwrBrdServoVolt,
      pwrBrdDigitalVolt = pwrBrdDigitalVolt,
      pwrBrdMotLAmp = pwrBrdMotLAmp,
      pwrBrdMotRAmp = pwrBrdMotRAmp,
      pwrBrdAnalogAmp = pwrBrdAnalogAmp,
      pwrBrdDigitalAmp = pwrBrdDigitalAmp,
      pwrBrdExtAmp = pwrBrdExtAmp,
      pwrBrdAuxAmp = pwrBrdAuxAmp,
    )
  }
}
