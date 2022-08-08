package com.urbanmatrix.mavlink.definitions.asluav

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Monitoring of power board status
 */
@GeneratedMavMessage(
  id = 8013,
  crc = 222,
)
public data class SensPowerBoard(
  /**
   * Timestamp
   */
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Power board status register
   */
  public val pwrBrdStatus: Int = 0,
  /**
   * Power board leds status
   */
  public val pwrBrdLedStatus: Int = 0,
  /**
   * Power board system voltage
   */
  public val pwrBrdSystemVolt: Float = 0F,
  /**
   * Power board servo voltage
   */
  public val pwrBrdServoVolt: Float = 0F,
  /**
   * Power board digital voltage
   */
  public val pwrBrdDigitalVolt: Float = 0F,
  /**
   * Power board left motor current sensor
   */
  public val pwrBrdMotLAmp: Float = 0F,
  /**
   * Power board right motor current sensor
   */
  public val pwrBrdMotRAmp: Float = 0F,
  /**
   * Power board analog current sensor
   */
  public val pwrBrdAnalogAmp: Float = 0F,
  /**
   * Power board digital current sensor
   */
  public val pwrBrdDigitalAmp: Float = 0F,
  /**
   * Power board extension current sensor
   */
  public val pwrBrdExtAmp: Float = 0F,
  /**
   * Power board aux current sensor
   */
  public val pwrBrdAuxAmp: Float = 0F,
) : MavMessage<SensPowerBoard> {
  public override val instanceMetadata: MavMessage.Metadata<SensPowerBoard> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(pwrBrdSystemVolt)
    outputBuffer.encodeFloat(pwrBrdServoVolt)
    outputBuffer.encodeFloat(pwrBrdDigitalVolt)
    outputBuffer.encodeFloat(pwrBrdMotLAmp)
    outputBuffer.encodeFloat(pwrBrdMotRAmp)
    outputBuffer.encodeFloat(pwrBrdAnalogAmp)
    outputBuffer.encodeFloat(pwrBrdDigitalAmp)
    outputBuffer.encodeFloat(pwrBrdExtAmp)
    outputBuffer.encodeFloat(pwrBrdAuxAmp)
    outputBuffer.encodeUint8(pwrBrdStatus)
    outputBuffer.encodeUint8(pwrBrdLedStatus)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8013

    private const val CRC: Int = 222

    private const val SIZE: Int = 46

    private val DESERIALIZER: MavDeserializer<SensPowerBoard> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val pwrBrdSystemVolt = inputBuffer.decodeFloat()
      val pwrBrdServoVolt = inputBuffer.decodeFloat()
      val pwrBrdDigitalVolt = inputBuffer.decodeFloat()
      val pwrBrdMotLAmp = inputBuffer.decodeFloat()
      val pwrBrdMotRAmp = inputBuffer.decodeFloat()
      val pwrBrdAnalogAmp = inputBuffer.decodeFloat()
      val pwrBrdDigitalAmp = inputBuffer.decodeFloat()
      val pwrBrdExtAmp = inputBuffer.decodeFloat()
      val pwrBrdAuxAmp = inputBuffer.decodeFloat()
      val pwrBrdStatus = inputBuffer.decodeUint8()
      val pwrBrdLedStatus = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<SensPowerBoard> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensPowerBoard> = METADATA
  }
}
