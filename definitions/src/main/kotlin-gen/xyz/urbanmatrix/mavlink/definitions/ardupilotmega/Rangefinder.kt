package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

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
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Raw voltage if available, zero otherwise.
   */
  @GeneratedMavField(type = "float")
  public val voltage: Float = 0F,
) : MavMessage<Rangefinder> {
  public override val instanceMetadata: MavMessage.Metadata<Rangefinder> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(voltage)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(voltage)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 173

    private const val CRC: Int = 83

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

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

    public fun builder(builderAction: Builder.() -> Unit): Rangefinder =
        Builder().apply(builderAction).build()
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
