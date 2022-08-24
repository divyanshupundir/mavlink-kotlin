package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32

/**
 * Barometer readings for 2nd barometer
 */
@GeneratedMavMessage(
  id = 137,
  crc = 195,
)
public data class ScaledPressure2(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Absolute pressure
   */
  public val pressAbs: Float = 0F,
  /**
   * Differential pressure
   */
  public val pressDiff: Float = 0F,
  /**
   * Absolute pressure temperature
   */
  public val temperature: Int = 0,
  /**
   * Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC.
   */
  public val temperaturePressDiff: Int = 0,
) : MavMessage<ScaledPressure2> {
  public override val instanceMetadata: MavMessage.Metadata<ScaledPressure2> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(pressAbs)
    outputBuffer.encodeFloat(pressDiff)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeInt16(temperaturePressDiff)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 137

    private const val CRC: Int = 195

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<ScaledPressure2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val pressAbs = inputBuffer.decodeFloat()
      val pressDiff = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeInt16()
      val temperaturePressDiff = inputBuffer.decodeInt16()

      ScaledPressure2(
        timeBootMs = timeBootMs,
        pressAbs = pressAbs,
        pressDiff = pressDiff,
        temperature = temperature,
        temperaturePressDiff = temperaturePressDiff,
      )
    }


    private val METADATA: MavMessage.Metadata<ScaledPressure2> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScaledPressure2> = METADATA
  }
}
