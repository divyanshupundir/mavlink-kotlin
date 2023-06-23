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
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Barometer readings for 3rd barometer
 */
@GeneratedMavMessage(
  id = 143u,
  crcExtra = -125,
)
public data class ScaledPressure3(
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
   * Differential pressure
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
) : MavMessage<ScaledPressure3> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScaledPressure3> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeFloat(pressAbs)
    output.encodeFloat(pressDiff)
    output.encodeInt16(temperature)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeFloat(pressAbs)
    output.encodeFloat(pressDiff)
    output.encodeInt16(temperature)
    output.encodeInt16(temperaturePressDiff)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ScaledPressure3> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 143u

    public override val crcExtra: Byte = -125

    public override fun deserialize(source: BufferedSource): ScaledPressure3 {
      val timeBootMs = source.decodeUInt32()
      val pressAbs = source.decodeFloat()
      val pressDiff = source.decodeFloat()
      val temperature = source.decodeInt16()
      val temperaturePressDiff = source.decodeInt16()

      return ScaledPressure3(
        timeBootMs = timeBootMs,
        pressAbs = pressAbs,
        pressDiff = pressDiff,
        temperature = temperature,
        temperaturePressDiff = temperaturePressDiff,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScaledPressure3 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var pressAbs: Float = 0F

    public var pressDiff: Float = 0F

    public var temperature: Short = 0

    public var temperaturePressDiff: Short = 0

    public fun build(): ScaledPressure3 = ScaledPressure3(
      timeBootMs = timeBootMs,
      pressAbs = pressAbs,
      pressDiff = pressDiff,
      temperature = temperature,
      temperaturePressDiff = temperaturePressDiff,
    )
  }
}
