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
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
@GeneratedMavMessage(
  id = 8009,
  crc = 144,
)
public data class SensAtmos(
  /**
   * Time since system boot
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   *  Ambient temperature
   */
  @GeneratedMavField(type = "float")
  public val tempambient: Float = 0F,
  /**
   *  Relative humidity
   */
  @GeneratedMavField(type = "float")
  public val humidity: Float = 0F,
) : MavMessage<SensAtmos> {
  public override val instanceMetadata: MavMessage.Metadata<SensAtmos> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(tempambient)
    outputBuffer.encodeFloat(humidity)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(tempambient)
    outputBuffer.encodeFloat(humidity)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 8009

    private const val CRC: Int = 144

    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<SensAtmos> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timestamp = inputBuffer.decodeUint64()
      val tempambient = inputBuffer.decodeFloat()
      val humidity = inputBuffer.decodeFloat()

      SensAtmos(
        timestamp = timestamp,
        tempambient = tempambient,
        humidity = humidity,
      )
    }


    private val METADATA: MavMessage.Metadata<SensAtmos> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SensAtmos> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: BigInteger = BigInteger.ZERO

    public var tempambient: Float = 0F

    public var humidity: Float = 0F

    public fun build(): SensAtmos = SensAtmos(
      timestamp = timestamp,
      tempambient = tempambient,
      humidity = humidity,
    )
  }
}
