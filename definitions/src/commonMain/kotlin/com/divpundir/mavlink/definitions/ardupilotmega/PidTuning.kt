package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * PID tuning information.
 *
 */
@GeneratedMavMessage(
  id = 194u,
  crcExtra = 98,
)
public data class PidTuning(
  /**
   * Axis.
   */
  @GeneratedMavField(type = "uint8_t")
  public val axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0u),
  /**
   * Desired rate.
   */
  @GeneratedMavField(type = "float")
  public val desired: Float = 0F,
  /**
   * Achieved rate.
   */
  @GeneratedMavField(type = "float")
  public val achieved: Float = 0F,
  /**
   * FF component.
   */
  @GeneratedMavField(type = "float")
  public val ff: Float = 0F,
  /**
   * P component.
   */
  @GeneratedMavField(type = "float")
  public val p: Float = 0F,
  /**
   * I component.
   */
  @GeneratedMavField(type = "float")
  public val i: Float = 0F,
  /**
   * D component.
   */
  @GeneratedMavField(type = "float")
  public val d: Float = 0F,
  /**
   * Slew rate.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val srate: Float = 0F,
  /**
   * P/D oscillation modifier.
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val pdmod: Float = 0F,
) : MavMessage<PidTuning> {
  override val instanceCompanion: MavMessage.MavCompanion<PidTuning> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(desired)
    encoder.encodeFloat(achieved)
    encoder.encodeFloat(ff)
    encoder.encodeFloat(p)
    encoder.encodeFloat(i)
    encoder.encodeFloat(d)
    encoder.encodeEnumValue(axis.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(desired)
    encoder.encodeFloat(achieved)
    encoder.encodeFloat(ff)
    encoder.encodeFloat(p)
    encoder.encodeFloat(i)
    encoder.encodeFloat(d)
    encoder.encodeEnumValue(axis.value, 1)
    encoder.encodeFloat(srate)
    encoder.encodeFloat(pdmod)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PidTuning> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 33

    override val id: UInt = 194u

    override val crcExtra: Byte = 98

    override fun deserialize(bytes: ByteArray): PidTuning {
      val decoder = MavDataDecoder(bytes)

      val desired = decoder.safeDecodeFloat()
      val achieved = decoder.safeDecodeFloat()
      val ff = decoder.safeDecodeFloat()
      val p = decoder.safeDecodeFloat()
      val i = decoder.safeDecodeFloat()
      val d = decoder.safeDecodeFloat()
      val axis = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val srate = decoder.safeDecodeFloat()
      val pdmod = decoder.safeDecodeFloat()

      return PidTuning(
        axis = axis,
        desired = desired,
        achieved = achieved,
        ff = ff,
        p = p,
        i = i,
        d = d,
        srate = srate,
        pdmod = pdmod,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): PidTuning =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var axis: MavEnumValue<PidTuningAxis> = MavEnumValue.fromValue(0u)

    public var desired: Float = 0F

    public var achieved: Float = 0F

    public var ff: Float = 0F

    public var p: Float = 0F

    public var i: Float = 0F

    public var d: Float = 0F

    public var srate: Float = 0F

    public var pdmod: Float = 0F

    public fun build(): PidTuning = PidTuning(
      axis = axis,
      desired = desired,
      achieved = achieved,
      ff = ff,
      p = p,
      i = i,
      d = d,
      srate = srate,
      pdmod = pdmod,
    )
  }
}
