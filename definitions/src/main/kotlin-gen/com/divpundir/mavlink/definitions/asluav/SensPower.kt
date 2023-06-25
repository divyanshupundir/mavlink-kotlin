package com.divpundir.mavlink.definitions.asluav

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
 * Voltage and current sensor data
 */
@GeneratedMavMessage(
  id = 8_002u,
  crcExtra = -38,
)
public data class SensPower(
  /**
   *  Power board voltage sensor reading
   */
  @GeneratedMavField(type = "float")
  public val adc121VspbVolt: Float = 0F,
  /**
   *  Power board current sensor reading
   */
  @GeneratedMavField(type = "float")
  public val adc121CspbAmp: Float = 0F,
  /**
   *  Board current sensor 1 reading
   */
  @GeneratedMavField(type = "float")
  public val adc121Cs1Amp: Float = 0F,
  /**
   *  Board current sensor 2 reading
   */
  @GeneratedMavField(type = "float")
  public val adc121Cs2Amp: Float = 0F,
) : MavMessage<SensPower> {
  public override val instanceCompanion: MavMessage.MavCompanion<SensPower> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(adc121VspbVolt)
    buffer.encodeFloat(adc121CspbAmp)
    buffer.encodeFloat(adc121Cs1Amp)
    buffer.encodeFloat(adc121Cs2Amp)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(adc121VspbVolt)
    buffer.encodeFloat(adc121CspbAmp)
    buffer.encodeFloat(adc121Cs1Amp)
    buffer.encodeFloat(adc121Cs2Amp)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensPower> {
    public override val id: UInt = 8_002u

    public override val crcExtra: Byte = -38

    public override fun deserialize(bytes: ByteArray): SensPower {
      val buffer = Buffer().write(bytes)

      val adc121VspbVolt = buffer.decodeFloat()
      val adc121CspbAmp = buffer.decodeFloat()
      val adc121Cs1Amp = buffer.decodeFloat()
      val adc121Cs2Amp = buffer.decodeFloat()

      return SensPower(
        adc121VspbVolt = adc121VspbVolt,
        adc121CspbAmp = adc121CspbAmp,
        adc121Cs1Amp = adc121Cs1Amp,
        adc121Cs2Amp = adc121Cs2Amp,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SensPower =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var adc121VspbVolt: Float = 0F

    public var adc121CspbAmp: Float = 0F

    public var adc121Cs1Amp: Float = 0F

    public var adc121Cs2Amp: Float = 0F

    public fun build(): SensPower = SensPower(
      adc121VspbVolt = adc121VspbVolt,
      adc121CspbAmp = adc121CspbAmp,
      adc121Cs1Amp = adc121Cs1Amp,
      adc121Cs2Amp = adc121Cs2Amp,
    )
  }
}
