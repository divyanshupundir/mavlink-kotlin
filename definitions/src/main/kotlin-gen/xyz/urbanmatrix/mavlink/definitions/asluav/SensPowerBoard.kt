package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Power board status register
   */
  @GeneratedMavField(type = "uint8_t")
  public val pwrBrdStatus: Int = 0,
  /**
   * Power board leds status
   */
  @GeneratedMavField(type = "uint8_t")
  public val pwrBrdLedStatus: Int = 0,
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8013

    private const val CRC: Int = 222

    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var pwrBrdStatus: Int = 0

    public var pwrBrdLedStatus: Int = 0

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
