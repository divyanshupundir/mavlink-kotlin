package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceMetadata: MavMessage.Metadata<SensPowerBoard> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(pwrBrdSystemVolt)
    outputBuffer.encodeFloat(pwrBrdServoVolt)
    outputBuffer.encodeFloat(pwrBrdDigitalVolt)
    outputBuffer.encodeFloat(pwrBrdMotLAmp)
    outputBuffer.encodeFloat(pwrBrdMotRAmp)
    outputBuffer.encodeFloat(pwrBrdAnalogAmp)
    outputBuffer.encodeFloat(pwrBrdDigitalAmp)
    outputBuffer.encodeFloat(pwrBrdExtAmp)
    outputBuffer.encodeFloat(pwrBrdAuxAmp)
    outputBuffer.encodeUInt8(pwrBrdStatus)
    outputBuffer.encodeUInt8(pwrBrdLedStatus)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timestamp)
    outputBuffer.encodeFloat(pwrBrdSystemVolt)
    outputBuffer.encodeFloat(pwrBrdServoVolt)
    outputBuffer.encodeFloat(pwrBrdDigitalVolt)
    outputBuffer.encodeFloat(pwrBrdMotLAmp)
    outputBuffer.encodeFloat(pwrBrdMotRAmp)
    outputBuffer.encodeFloat(pwrBrdAnalogAmp)
    outputBuffer.encodeFloat(pwrBrdDigitalAmp)
    outputBuffer.encodeFloat(pwrBrdExtAmp)
    outputBuffer.encodeFloat(pwrBrdAuxAmp)
    outputBuffer.encodeUInt8(pwrBrdStatus)
    outputBuffer.encodeUInt8(pwrBrdLedStatus)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 8_013u

    private const val CRC_EXTRA: Byte = -34

    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    private val DESERIALIZER: MavDeserializer<SensPowerBoard> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUInt64()
      val pwrBrdSystemVolt = inputBuffer.decodeFloat()
      val pwrBrdServoVolt = inputBuffer.decodeFloat()
      val pwrBrdDigitalVolt = inputBuffer.decodeFloat()
      val pwrBrdMotLAmp = inputBuffer.decodeFloat()
      val pwrBrdMotRAmp = inputBuffer.decodeFloat()
      val pwrBrdAnalogAmp = inputBuffer.decodeFloat()
      val pwrBrdDigitalAmp = inputBuffer.decodeFloat()
      val pwrBrdExtAmp = inputBuffer.decodeFloat()
      val pwrBrdAuxAmp = inputBuffer.decodeFloat()
      val pwrBrdStatus = inputBuffer.decodeUInt8()
      val pwrBrdLedStatus = inputBuffer.decodeUInt8()

      SensPowerBoard(
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


    private val METADATA: MavMessage.Metadata<SensPowerBoard> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensPowerBoard> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensPowerBoard =
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
