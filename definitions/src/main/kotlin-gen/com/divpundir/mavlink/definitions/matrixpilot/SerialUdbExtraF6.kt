package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format
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
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF6> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(suePitchgain)
    buffer.encodeFloat(suePitchkd)
    buffer.encodeFloat(sueRudderElevMix)
    buffer.encodeFloat(sueRollElevMix)
    buffer.encodeFloat(sueElevatorBoost)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(suePitchgain)
    buffer.encodeFloat(suePitchkd)
    buffer.encodeFloat(sueRudderElevMix)
    buffer.encodeFloat(sueRollElevMix)
    buffer.encodeFloat(sueElevatorBoost)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF6> {
    public override val id: UInt = 174u

    public override val crcExtra: Byte = 54

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF6 {
      val buffer = Buffer().write(bytes)

      val suePitchgain = buffer.decodeFloat()
      val suePitchkd = buffer.decodeFloat()
      val sueRudderElevMix = buffer.decodeFloat()
      val sueRollElevMix = buffer.decodeFloat()
      val sueElevatorBoost = buffer.decodeFloat()

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
