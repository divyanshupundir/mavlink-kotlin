package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Unit
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
 * The pressure readings for the typical setup of one absolute and differential pressure sensor. The
 * units are as specified in each field.
 */
@GeneratedMavMessage(
  id = 29,
  crc = 115,
)
public data class ScaledPressure(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Absolute pressure
   */
  public val pressAbs: Float = 0F,
  /**
   * Differential pressure 1
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
) : MavMessage<ScaledPressure> {
  public override val instanceMetadata: MavMessage.Metadata<ScaledPressure> = METADATA

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
    private const val ID: Int = 29

    private const val CRC: Int = 115

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<ScaledPressure> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val pressAbs = inputBuffer.decodeFloat()
      val pressDiff = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeInt16()
      val temperaturePressDiff = inputBuffer.decodeInt16()

      ScaledPressure(
        timeBootMs = timeBootMs,
        pressAbs = pressAbs,
        pressDiff = pressDiff,
        temperature = temperature,
        temperaturePressDiff = temperaturePressDiff,
      )
    }


    private val METADATA: MavMessage.Metadata<ScaledPressure> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScaledPressure> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var pressAbs: Float = 0F

    public var pressDiff: Float = 0F

    public var temperature: Int = 0

    public var temperaturePressDiff: Int = 0

    public fun build(): ScaledPressure = ScaledPressure(
      timeBootMs = timeBootMs,
      pressAbs = pressAbs,
      pressDiff = pressDiff,
      temperature = temperature,
      temperaturePressDiff = temperaturePressDiff,
    )
  }
}
