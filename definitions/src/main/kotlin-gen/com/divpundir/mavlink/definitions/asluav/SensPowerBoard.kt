package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeFloat(pwrBrdSystemVolt)
    buffer.encodeFloat(pwrBrdServoVolt)
    buffer.encodeFloat(pwrBrdDigitalVolt)
    buffer.encodeFloat(pwrBrdMotLAmp)
    buffer.encodeFloat(pwrBrdMotRAmp)
    buffer.encodeFloat(pwrBrdAnalogAmp)
    buffer.encodeFloat(pwrBrdDigitalAmp)
    buffer.encodeFloat(pwrBrdExtAmp)
    buffer.encodeFloat(pwrBrdAuxAmp)
    buffer.encodeUInt8(pwrBrdStatus)
    buffer.encodeUInt8(pwrBrdLedStatus)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timestamp)
    buffer.encodeFloat(pwrBrdSystemVolt)
    buffer.encodeFloat(pwrBrdServoVolt)
    buffer.encodeFloat(pwrBrdDigitalVolt)
    buffer.encodeFloat(pwrBrdMotLAmp)
    buffer.encodeFloat(pwrBrdMotRAmp)
    buffer.encodeFloat(pwrBrdAnalogAmp)
    buffer.encodeFloat(pwrBrdDigitalAmp)
    buffer.encodeFloat(pwrBrdExtAmp)
    buffer.encodeFloat(pwrBrdAuxAmp)
    buffer.encodeUInt8(pwrBrdStatus)
    buffer.encodeUInt8(pwrBrdLedStatus)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensPowerBoard> {
    public override val id: UInt = 8_013u

    public override val crcExtra: Byte = -34

    public override fun deserialize(bytes: ByteArray): SensPowerBoard {
      val buffer = Buffer().write(bytes)

      val timestamp = buffer.decodeUInt64()
      val pwrBrdSystemVolt = buffer.decodeFloat()
      val pwrBrdServoVolt = buffer.decodeFloat()
      val pwrBrdDigitalVolt = buffer.decodeFloat()
      val pwrBrdMotLAmp = buffer.decodeFloat()
      val pwrBrdMotRAmp = buffer.decodeFloat()
      val pwrBrdAnalogAmp = buffer.decodeFloat()
      val pwrBrdDigitalAmp = buffer.decodeFloat()
      val pwrBrdExtAmp = buffer.decodeFloat()
      val pwrBrdAuxAmp = buffer.decodeFloat()
      val pwrBrdStatus = buffer.decodeUInt8()
      val pwrBrdLedStatus = buffer.decodeUInt8()

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
