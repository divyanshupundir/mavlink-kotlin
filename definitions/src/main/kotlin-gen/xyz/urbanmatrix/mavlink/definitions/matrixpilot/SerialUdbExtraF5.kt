package xyz.urbanmatrix.mavlink.definitions.matrixpilot

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
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format
 */
@GeneratedMavMessage(
  id = 173,
  crc = 54,
)
public data class SerialUdbExtraF5(
  /**
   * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation
   */
  public val sueYawkpAileron: Float = 0F,
  /**
   * Serial UDB YAWKD_AILERON Gain for Rate control of navigation
   */
  public val sueYawkdAileron: Float = 0F,
  /**
   * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization
   */
  public val sueRollkp: Float = 0F,
  /**
   * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization
   */
  public val sueRollkd: Float = 0F,
) : MavMessage<SerialUdbExtraF5> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF5> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(sueYawkpAileron)
    outputBuffer.encodeFloat(sueYawkdAileron)
    outputBuffer.encodeFloat(sueRollkp)
    outputBuffer.encodeFloat(sueRollkd)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 173

    private const val CRC: Int = 54

    private const val SIZE: Int = 16

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF5> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueYawkpAileron = inputBuffer.decodeFloat()
      val sueYawkdAileron = inputBuffer.decodeFloat()
      val sueRollkp = inputBuffer.decodeFloat()
      val sueRollkd = inputBuffer.decodeFloat()

      SerialUdbExtraF5(
        sueYawkpAileron = sueYawkpAileron,
        sueYawkdAileron = sueYawkdAileron,
        sueRollkp = sueRollkp,
        sueRollkd = sueRollkd,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF5> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF5> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueYawkpAileron: Float = 0F

    public var sueYawkdAileron: Float = 0F

    public var sueRollkp: Float = 0F

    public var sueRollkd: Float = 0F

    public fun build(): SerialUdbExtraF5 = SerialUdbExtraF5(
      sueYawkpAileron = sueYawkpAileron,
      sueYawkdAileron = sueYawkdAileron,
      sueRollkp = sueRollkp,
      sueRollkd = sueRollkd,
    )
  }
}
