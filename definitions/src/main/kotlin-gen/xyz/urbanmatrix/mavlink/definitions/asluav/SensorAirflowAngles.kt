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
 * Calibrated airflow angle measurements
 */
@GeneratedMavMessage(
  id = 8016,
  crc = 149,
)
public data class SensorAirflowAngles(
  /**
   * Timestamp
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   * Angle of attack
   */
  @GeneratedMavField(type = "float")
  public val angleofattack: Float = 0F,
  /**
   * Angle of attack measurement valid
   */
  @GeneratedMavField(type = "uint8_t")
  public val angleofattackValid: Int = 0,
  /**
   * Sideslip angle
   */
  @GeneratedMavField(type = "float")
  public val sideslip: Float = 0F,
  /**
   * Sideslip angle measurement valid
   */
  @GeneratedMavField(type = "uint8_t")
  public val sideslipValid: Int = 0,
) : MavMessage<SensorAirflowAngles> {
  public override val instanceMetadata: MavMessage.Metadata<SensorAirflowAngles> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(angleofattack)
    outputBuffer.encodeFloat(sideslip)
    outputBuffer.encodeUint8(angleofattackValid)
    outputBuffer.encodeUint8(sideslipValid)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(angleofattack)
    outputBuffer.encodeFloat(sideslip)
    outputBuffer.encodeUint8(angleofattackValid)
    outputBuffer.encodeUint8(sideslipValid)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8016

    private const val CRC: Int = 149

    private const val SIZE_V1: Int = 18

    private const val SIZE_V2: Int = 18

    private val DESERIALIZER: MavDeserializer<SensorAirflowAngles> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val angleofattack = inputBuffer.decodeFloat()
      val sideslip = inputBuffer.decodeFloat()
      val angleofattackValid = inputBuffer.decodeUint8()
      val sideslipValid = inputBuffer.decodeUint8()

      SensorAirflowAngles(
        timestamp = timestamp,
        angleofattack = angleofattack,
        angleofattackValid = angleofattackValid,
        sideslip = sideslip,
        sideslipValid = sideslipValid,
      )
    }


    private val METADATA: MavMessage.Metadata<SensorAirflowAngles> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensorAirflowAngles> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SensorAirflowAngles =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var angleofattack: Float = 0F

    public var angleofattackValid: Int = 0

    public var sideslip: Float = 0F

    public var sideslipValid: Int = 0

    public fun build(): SensorAirflowAngles = SensorAirflowAngles(
      timestamp = timestamp,
      angleofattack = angleofattack,
      angleofattackValid = angleofattackValid,
      sideslip = sideslip,
      sideslipValid = sideslipValid,
    )
  }
}
