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
 * Backwards compatible version of SERIAL_UDB_EXTRA F7: format
 *
 */
@GeneratedMavMessage(
  id = 175u,
  crcExtra = -85,
)
public data class SerialUdbExtraF7(
  /**
   * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation
   */
  @GeneratedMavField(type = "float")
  public val sueYawkpRudder: Float = 0F,
  /**
   * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation
   */
  @GeneratedMavField(type = "float")
  public val sueYawkdRudder: Float = 0F,
  /**
   * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization
   */
  @GeneratedMavField(type = "float")
  public val sueRollkpRudder: Float = 0F,
  /**
   * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization
   */
  @GeneratedMavField(type = "float")
  public val sueRollkdRudder: Float = 0F,
  /**
   * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized
   */
  @GeneratedMavField(type = "float")
  public val sueRudderBoost: Float = 0F,
  /**
   * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down
   */
  @GeneratedMavField(type = "float")
  public val sueRtlPitchDown: Float = 0F,
) : MavMessage<SerialUdbExtraF7> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF7> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(sueYawkpRudder)
    encoder.encodeFloat(sueYawkdRudder)
    encoder.encodeFloat(sueRollkpRudder)
    encoder.encodeFloat(sueRollkdRudder)
    encoder.encodeFloat(sueRudderBoost)
    encoder.encodeFloat(sueRtlPitchDown)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(sueYawkpRudder)
    encoder.encodeFloat(sueYawkdRudder)
    encoder.encodeFloat(sueRollkpRudder)
    encoder.encodeFloat(sueRollkdRudder)
    encoder.encodeFloat(sueRudderBoost)
    encoder.encodeFloat(sueRtlPitchDown)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF7> {
    private const val SIZE_V1: Int = 24

    private const val SIZE_V2: Int = 24

    override val id: UInt = 175u

    override val crcExtra: Byte = -85

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF7 {
      val decoder = MavDataDecoder(bytes)

      val sueYawkpRudder = decoder.safeDecodeFloat()
      val sueYawkdRudder = decoder.safeDecodeFloat()
      val sueRollkpRudder = decoder.safeDecodeFloat()
      val sueRollkdRudder = decoder.safeDecodeFloat()
      val sueRudderBoost = decoder.safeDecodeFloat()
      val sueRtlPitchDown = decoder.safeDecodeFloat()

      return SerialUdbExtraF7(
        sueYawkpRudder = sueYawkpRudder,
        sueYawkdRudder = sueYawkdRudder,
        sueRollkpRudder = sueRollkpRudder,
        sueRollkdRudder = sueRollkdRudder,
        sueRudderBoost = sueRudderBoost,
        sueRtlPitchDown = sueRtlPitchDown,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF7 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueYawkpRudder: Float = 0F

    public var sueYawkdRudder: Float = 0F

    public var sueRollkpRudder: Float = 0F

    public var sueRollkdRudder: Float = 0F

    public var sueRudderBoost: Float = 0F

    public var sueRtlPitchDown: Float = 0F

    public fun build(): SerialUdbExtraF7 = SerialUdbExtraF7(
      sueYawkpRudder = sueYawkpRudder,
      sueYawkdRudder = sueYawkdRudder,
      sueRollkpRudder = sueRollkpRudder,
      sueRollkdRudder = sueRollkdRudder,
      sueRudderBoost = sueRudderBoost,
      sueRtlPitchDown = sueRtlPitchDown,
    )
  }
}
