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
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format
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
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF5> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(sueYawkpAileron)
    buffer.encodeFloat(sueYawkdAileron)
    buffer.encodeFloat(sueRollkp)
    buffer.encodeFloat(sueRollkd)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(sueYawkpAileron)
    buffer.encodeFloat(sueYawkdAileron)
    buffer.encodeFloat(sueRollkp)
    buffer.encodeFloat(sueRollkd)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF5> {
    public override val id: UInt = 173u

    public override val crcExtra: Byte = 54

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF5 {
      val buffer = Buffer().write(bytes)

      val sueYawkpAileron = buffer.decodeFloat()
      val sueYawkdAileron = buffer.decodeFloat()
      val sueRollkp = buffer.decodeFloat()
      val sueRollkd = buffer.decodeFloat()

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
