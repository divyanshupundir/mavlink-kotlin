package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * PID tuning information.
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
  public override val instanceCompanion: MavMessage.MavCompanion<PidTuning> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(desired)
    buffer.encodeFloat(achieved)
    buffer.encodeFloat(ff)
    buffer.encodeFloat(p)
    buffer.encodeFloat(i)
    buffer.encodeFloat(d)
    buffer.encodeEnumValue(axis.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(desired)
    buffer.encodeFloat(achieved)
    buffer.encodeFloat(ff)
    buffer.encodeFloat(p)
    buffer.encodeFloat(i)
    buffer.encodeFloat(d)
    buffer.encodeEnumValue(axis.value, 1)
    buffer.encodeFloat(srate)
    buffer.encodeFloat(pdmod)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PidTuning> {
    public override val id: UInt = 194u

    public override val crcExtra: Byte = 98

    public override fun deserialize(bytes: ByteArray): PidTuning {
      val buffer = Buffer().write(bytes)

      val desired = buffer.decodeFloat()
      val achieved = buffer.decodeFloat()
      val ff = buffer.decodeFloat()
      val p = buffer.decodeFloat()
      val i = buffer.decodeFloat()
      val d = buffer.decodeFloat()
      val axis = buffer.decodeEnumValue(1).let { value ->
        val entry = PidTuningAxis.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val srate = buffer.decodeFloat()
      val pdmod = buffer.decodeFloat()

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
