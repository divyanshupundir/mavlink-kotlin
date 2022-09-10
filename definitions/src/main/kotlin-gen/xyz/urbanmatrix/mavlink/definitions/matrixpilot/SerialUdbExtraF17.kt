package xyz.urbanmatrix.mavlink.definitions.matrixpilot

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
 * Backwards compatible version of SERIAL_UDB_EXTRA F17 format
 */
@GeneratedMavMessage(
  id = 183,
  crc = 175,
)
public data class SerialUdbExtraF17(
  /**
   * SUE Feed Forward Gain
   */
  @GeneratedMavField(type = "float")
  public val sueFeedForward: Float = 0F,
  /**
   * SUE Max Turn Rate when Navigating
   */
  @GeneratedMavField(type = "float")
  public val sueTurnRateNav: Float = 0F,
  /**
   * SUE Max Turn Rate in Fly By Wire Mode
   */
  @GeneratedMavField(type = "float")
  public val sueTurnRateFbw: Float = 0F,
) : MavMessage<SerialUdbExtraF17> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF17> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueFeedForward)
    outputBuffer.encodeFloat(sueTurnRateNav)
    outputBuffer.encodeFloat(sueTurnRateFbw)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueFeedForward)
    outputBuffer.encodeFloat(sueTurnRateNav)
    outputBuffer.encodeFloat(sueTurnRateFbw)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 183

    private const val CRC: Int = 175

    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF17> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueFeedForward = inputBuffer.decodeFloat()
      val sueTurnRateNav = inputBuffer.decodeFloat()
      val sueTurnRateFbw = inputBuffer.decodeFloat()

      SerialUdbExtraF17(
        sueFeedForward = sueFeedForward,
        sueTurnRateNav = sueTurnRateNav,
        sueTurnRateFbw = sueTurnRateFbw,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF17> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF17> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueFeedForward: Float = 0F

    public var sueTurnRateNav: Float = 0F

    public var sueTurnRateFbw: Float = 0F

    public fun build(): SerialUdbExtraF17 = SerialUdbExtraF17(
      sueFeedForward = sueFeedForward,
      sueTurnRateNav = sueTurnRateNav,
      sueTurnRateFbw = sueTurnRateFbw,
    )
  }
}
