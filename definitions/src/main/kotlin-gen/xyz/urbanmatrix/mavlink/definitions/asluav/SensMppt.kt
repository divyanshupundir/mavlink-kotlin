package xyz.urbanmatrix.mavlink.definitions.asluav

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking
 */
@GeneratedMavMessage(
  id = 8003,
  crc = 231,
)
public data class SensMppt(
  /**
   *  MPPT last timestamp 
   */
  public val mpptTimestamp: BigInteger = BigInteger.ZERO,
  /**
   *  MPPT1 voltage 
   */
  public val mppt1Volt: Float = 0F,
  /**
   *  MPPT1 current 
   */
  public val mppt1Amp: Float = 0F,
  /**
   *  MPPT1 pwm 
   */
  public val mppt1Pwm: Int = 0,
  /**
   *  MPPT1 status 
   */
  public val mppt1Status: Int = 0,
  /**
   *  MPPT2 voltage 
   */
  public val mppt2Volt: Float = 0F,
  /**
   *  MPPT2 current 
   */
  public val mppt2Amp: Float = 0F,
  /**
   *  MPPT2 pwm 
   */
  public val mppt2Pwm: Int = 0,
  /**
   *  MPPT2 status 
   */
  public val mppt2Status: Int = 0,
  /**
   * MPPT3 voltage 
   */
  public val mppt3Volt: Float = 0F,
  /**
   *  MPPT3 current 
   */
  public val mppt3Amp: Float = 0F,
  /**
   *  MPPT3 pwm 
   */
  public val mppt3Pwm: Int = 0,
  /**
   *  MPPT3 status 
   */
  public val mppt3Status: Int = 0,
) : MavMessage<SensMppt> {
  public override val instanceMetadata: MavMessage.Metadata<SensMppt> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(mpptTimestamp)
    outputBuffer.encodeFloat(mppt1Volt)
    outputBuffer.encodeFloat(mppt1Amp)
    outputBuffer.encodeFloat(mppt2Volt)
    outputBuffer.encodeFloat(mppt2Amp)
    outputBuffer.encodeFloat(mppt3Volt)
    outputBuffer.encodeFloat(mppt3Amp)
    outputBuffer.encodeUint16(mppt1Pwm)
    outputBuffer.encodeUint16(mppt2Pwm)
    outputBuffer.encodeUint16(mppt3Pwm)
    outputBuffer.encodeUint8(mppt1Status)
    outputBuffer.encodeUint8(mppt2Status)
    outputBuffer.encodeUint8(mppt3Status)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8003

    private const val CRC: Int = 231

    private const val SIZE: Int = 41

    private val DESERIALIZER: MavDeserializer<SensMppt> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mpptTimestamp = inputBuffer.decodeUint64()
      val mppt1Volt = inputBuffer.decodeFloat()
      val mppt1Amp = inputBuffer.decodeFloat()
      val mppt2Volt = inputBuffer.decodeFloat()
      val mppt2Amp = inputBuffer.decodeFloat()
      val mppt3Volt = inputBuffer.decodeFloat()
      val mppt3Amp = inputBuffer.decodeFloat()
      val mppt1Pwm = inputBuffer.decodeUint16()
      val mppt2Pwm = inputBuffer.decodeUint16()
      val mppt3Pwm = inputBuffer.decodeUint16()
      val mppt1Status = inputBuffer.decodeUint8()
      val mppt2Status = inputBuffer.decodeUint8()
      val mppt3Status = inputBuffer.decodeUint8()

      SensMppt(
        mpptTimestamp = mpptTimestamp,
        mppt1Volt = mppt1Volt,
        mppt1Amp = mppt1Amp,
        mppt1Pwm = mppt1Pwm,
        mppt1Status = mppt1Status,
        mppt2Volt = mppt2Volt,
        mppt2Amp = mppt2Amp,
        mppt2Pwm = mppt2Pwm,
        mppt2Status = mppt2Status,
        mppt3Volt = mppt3Volt,
        mppt3Amp = mppt3Amp,
        mppt3Pwm = mppt3Pwm,
        mppt3Status = mppt3Status,
      )
    }


    private val METADATA: MavMessage.Metadata<SensMppt> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensMppt> = METADATA
  }
}
