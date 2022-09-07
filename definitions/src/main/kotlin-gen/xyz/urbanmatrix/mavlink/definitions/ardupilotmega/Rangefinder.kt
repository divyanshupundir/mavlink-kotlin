package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeFloat

/**
 * Rangefinder reporting.
 */
@GeneratedMavMessage(
  id = 173,
  crc = 83,
)
public data class Rangefinder(
  /**
   * Distance.
   */
  public val distance: Float = 0F,
  /**
   * Raw voltage if available, zero otherwise.
   */
  public val voltage: Float = 0F,
) : MavMessage<Rangefinder> {
  public override val instanceMetadata: MavMessage.Metadata<Rangefinder> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(voltage)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 173

    private const val CRC: Int = 83

    private const val SIZE: Int = 8

    private val DESERIALIZER: MavDeserializer<Rangefinder> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val distance = inputBuffer.decodeFloat()
      val voltage = inputBuffer.decodeFloat()

      Rangefinder(
        distance = distance,
        voltage = voltage,
      )
    }


    private val METADATA: MavMessage.Metadata<Rangefinder> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Rangefinder> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var distance: Float = 0F

    public var voltage: Float = 0F

    public fun build(): Rangefinder = Rangefinder(
      distance = distance,
      voltage = voltage,
    )
  }
}
