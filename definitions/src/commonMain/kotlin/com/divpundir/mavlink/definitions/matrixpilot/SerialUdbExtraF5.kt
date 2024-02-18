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
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format
 *
 */
@GeneratedMavMessage(
  id = 173u,
  crcExtra = 54,
)
public data class SerialUdbExtraF5(
  /**
   * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation
   */
  @GeneratedMavField(type = "float")
  public val sueYawkpAileron: Float = 0F,
  /**
   * Serial UDB YAWKD_AILERON Gain for Rate control of navigation
   */
  @GeneratedMavField(type = "float")
  public val sueYawkdAileron: Float = 0F,
  /**
   * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization
   */
  @GeneratedMavField(type = "float")
  public val sueRollkp: Float = 0F,
  /**
   * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization
   */
  @GeneratedMavField(type = "float")
  public val sueRollkd: Float = 0F,
) : MavMessage<SerialUdbExtraF5> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF5> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(sueYawkpAileron)
    encoder.encodeFloat(sueYawkdAileron)
    encoder.encodeFloat(sueRollkp)
    encoder.encodeFloat(sueRollkd)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(sueYawkpAileron)
    encoder.encodeFloat(sueYawkdAileron)
    encoder.encodeFloat(sueRollkp)
    encoder.encodeFloat(sueRollkd)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF5> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    override val id: UInt = 173u

    override val crcExtra: Byte = 54

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF5 {
      val decoder = MavDataDecoder(bytes)

      val sueYawkpAileron = decoder.safeDecodeFloat()
      val sueYawkdAileron = decoder.safeDecodeFloat()
      val sueRollkp = decoder.safeDecodeFloat()
      val sueRollkd = decoder.safeDecodeFloat()

      return SerialUdbExtraF5(
        sueYawkpAileron = sueYawkpAileron,
        sueYawkdAileron = sueYawkdAileron,
        sueRollkp = sueRollkp,
        sueRollkd = sueRollkd,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF5 =
        Builder().apply(builderAction).build()
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
