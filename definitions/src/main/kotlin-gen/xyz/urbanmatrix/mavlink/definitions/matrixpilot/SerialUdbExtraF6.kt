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
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format
 */
@GeneratedMavMessage(
  id = 174,
  crc = 54,
)
public data class SerialUdbExtraF6(
  /**
   * Serial UDB Extra PITCHGAIN Proportional Control
   */
  @GeneratedMavField(type = "float")
  public val suePitchgain: Float = 0F,
  /**
   * Serial UDB Extra Pitch Rate Control
   */
  @GeneratedMavField(type = "float")
  public val suePitchkd: Float = 0F,
  /**
   * Serial UDB Extra Rudder to Elevator Mix
   */
  @GeneratedMavField(type = "float")
  public val sueRudderElevMix: Float = 0F,
  /**
   * Serial UDB Extra Roll to Elevator Mix
   */
  @GeneratedMavField(type = "float")
  public val sueRollElevMix: Float = 0F,
  /**
   * Gain For Boosting Manual Elevator control When Plane Stabilized
   */
  @GeneratedMavField(type = "float")
  public val sueElevatorBoost: Float = 0F,
) : MavMessage<SerialUdbExtraF6> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF6> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(suePitchgain)
    outputBuffer.encodeFloat(suePitchkd)
    outputBuffer.encodeFloat(sueRudderElevMix)
    outputBuffer.encodeFloat(sueRollElevMix)
    outputBuffer.encodeFloat(sueElevatorBoost)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(suePitchgain)
    outputBuffer.encodeFloat(suePitchkd)
    outputBuffer.encodeFloat(sueRudderElevMix)
    outputBuffer.encodeFloat(sueRollElevMix)
    outputBuffer.encodeFloat(sueElevatorBoost)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 174

    private const val CRC: Int = 54

    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF6> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val suePitchgain = inputBuffer.decodeFloat()
      val suePitchkd = inputBuffer.decodeFloat()
      val sueRudderElevMix = inputBuffer.decodeFloat()
      val sueRollElevMix = inputBuffer.decodeFloat()
      val sueElevatorBoost = inputBuffer.decodeFloat()

      SerialUdbExtraF6(
        suePitchgain = suePitchgain,
        suePitchkd = suePitchkd,
        sueRudderElevMix = sueRudderElevMix,
        sueRollElevMix = sueRollElevMix,
        sueElevatorBoost = sueElevatorBoost,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF6> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF6> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): SerialUdbExtraF6 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var suePitchgain: Float = 0F

    public var suePitchkd: Float = 0F

    public var sueRudderElevMix: Float = 0F

    public var sueRollElevMix: Float = 0F

    public var sueElevatorBoost: Float = 0F

    public fun build(): SerialUdbExtraF6 = SerialUdbExtraF6(
      suePitchgain = suePitchgain,
      suePitchkd = suePitchkd,
      sueRudderElevMix = sueRudderElevMix,
      sueRollElevMix = sueRollElevMix,
      sueElevatorBoost = sueElevatorBoost,
    )
  }
}
