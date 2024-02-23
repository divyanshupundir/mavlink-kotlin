package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format
 *
 * @param suePitchgain Serial UDB Extra PITCHGAIN Proportional Control
 * @param suePitchkd Serial UDB Extra Pitch Rate Control
 * @param sueRudderElevMix Serial UDB Extra Rudder to Elevator Mix
 * @param sueRollElevMix Serial UDB Extra Roll to Elevator Mix
 * @param sueElevatorBoost Gain For Boosting Manual Elevator control When Plane Stabilized
 */
@GeneratedMavMessage(
  id = 174u,
  crcExtra = 54,
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
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF6> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(suePitchgain)
    encoder.encodeFloat(suePitchkd)
    encoder.encodeFloat(sueRudderElevMix)
    encoder.encodeFloat(sueRollElevMix)
    encoder.encodeFloat(sueElevatorBoost)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(suePitchgain)
    encoder.encodeFloat(suePitchkd)
    encoder.encodeFloat(sueRudderElevMix)
    encoder.encodeFloat(sueRollElevMix)
    encoder.encodeFloat(sueElevatorBoost)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF6> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    override val id: UInt = 174u

    override val crcExtra: Byte = 54

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF6 {
      val decoder = MavDataDecoder(bytes)

      val suePitchgain = decoder.safeDecodeFloat()
      val suePitchkd = decoder.safeDecodeFloat()
      val sueRudderElevMix = decoder.safeDecodeFloat()
      val sueRollElevMix = decoder.safeDecodeFloat()
      val sueElevatorBoost = decoder.safeDecodeFloat()

      return SerialUdbExtraF6(
        suePitchgain = suePitchgain,
        suePitchkd = suePitchkd,
        sueRudderElevMix = sueRudderElevMix,
        sueRollElevMix = sueRollElevMix,
        sueElevatorBoost = sueElevatorBoost,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF6 =
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
