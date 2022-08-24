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
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint64

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
  public val timestamp: BigInteger = BigInteger.ZERO,
  /**
   *  Ambient temperature
   */
  public val tempambient: Float = 0F,
  /**
   *  Relative humidity
   */
  public val humidity: Float = 0F,
) : MavMessage<SensAtmos> {
  public override val instanceMetadata: MavMessage.Metadata<SensAtmos> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timestamp)
    outputBuffer.encodeFloat(tempambient)
    outputBuffer.encodeFloat(humidity)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 8009

    private const val CRC: Int = 144

    private const val SIZE: Int = 16

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
  }
}
