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
 * Wind estimation.
 */
@GeneratedMavMessage(
  id = 168,
  crc = 1,
)
public data class Wind(
  /**
   * Wind direction (that wind is coming from).
   */
  @GeneratedMavField(type = "float")
  public val direction: Float = 0F,
  /**
   * Wind speed in ground plane.
   */
  @GeneratedMavField(type = "float")
  public val speed: Float = 0F,
  /**
   * Vertical wind speed.
   */
  @GeneratedMavField(type = "float")
  public val speedZ: Float = 0F,
) : MavMessage<Wind> {
  public override val instanceMetadata: MavMessage.Metadata<Wind> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(direction)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(speedZ)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(direction)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(speedZ)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 168

    private const val CRC: Int = 1

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<Wind> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val direction = inputBuffer.decodeFloat()
      val speed = inputBuffer.decodeFloat()
      val speedZ = inputBuffer.decodeFloat()

      Wind(
        direction = direction,
        speed = speed,
        speedZ = speedZ,
      )
    }


    private val METADATA: MavMessage.Metadata<Wind> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Wind> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Wind =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var direction: Float = 0F

    public var speed: Float = 0F

    public var speedZ: Float = 0F

    public fun build(): Wind = Wind(
      direction = direction,
      speed = speed,
      speedZ = speedZ,
    )
  }
}
