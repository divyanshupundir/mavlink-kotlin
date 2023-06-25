package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * The pressure readings for the typical setup of one absolute and differential pressure sensor. The
 * units are as specified in each field.
 */
@GeneratedMavMessage(
  id = 29u,
  crcExtra = 115,
)
public data class ScaledPressure(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Absolute pressure
   */
  @GeneratedMavField(type = "float")
  public val pressAbs: Float = 0F,
  /**
   * Differential pressure 1
   */
  @GeneratedMavField(type = "float")
  public val pressDiff: Float = 0F,
  /**
   * Absolute pressure temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC.
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperaturePressDiff: Short = 0,
) : MavMessage<ScaledPressure> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScaledPressure> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(pressAbs)
    buffer.encodeFloat(pressDiff)
    buffer.encodeInt16(temperature)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(pressAbs)
    buffer.encodeFloat(pressDiff)
    buffer.encodeInt16(temperature)
    buffer.encodeInt16(temperaturePressDiff)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScaledPressure> {
    public override val id: UInt = 29u

    public override val crcExtra: Byte = 115

    public override fun deserialize(bytes: ByteArray): ScaledPressure {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val pressAbs = buffer.decodeFloat()
      val pressDiff = buffer.decodeFloat()
      val temperature = buffer.decodeInt16()
      val temperaturePressDiff = buffer.decodeInt16()

      return ScaledPressure(
        timeBootMs = timeBootMs,
        pressAbs = pressAbs,
        pressDiff = pressDiff,
        temperature = temperature,
        temperaturePressDiff = temperaturePressDiff,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScaledPressure =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var pressAbs: Float = 0F

    public var pressDiff: Float = 0F

    public var temperature: Short = 0

    public var temperaturePressDiff: Short = 0

    public fun build(): ScaledPressure = ScaledPressure(
      timeBootMs = timeBootMs,
      pressAbs = pressAbs,
      pressDiff = pressDiff,
      temperature = temperature,
      temperaturePressDiff = temperaturePressDiff,
    )
  }
}
