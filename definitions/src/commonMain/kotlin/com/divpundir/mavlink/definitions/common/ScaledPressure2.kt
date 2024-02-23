package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * Barometer readings for 2nd barometer
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param pressAbs Absolute pressure
 * units = hPa
 * @param pressDiff Differential pressure
 * units = hPa
 * @param temperature Absolute pressure temperature
 * units = cdegC
 * @param temperaturePressDiff Differential pressure temperature (0, if not available). Report
 * values of 0 (or 1) as 1 cdegC.
 * units = cdegC
 */
@GeneratedMavMessage(
  id = 137u,
  crcExtra = -61,
)
public data class ScaledPressure2(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Absolute pressure
   * units = hPa
   */
  @GeneratedMavField(type = "float")
  public val pressAbs: Float = 0F,
  /**
   * Differential pressure
   * units = hPa
   */
  @GeneratedMavField(type = "float")
  public val pressDiff: Float = 0F,
  /**
   * Absolute pressure temperature
   * units = cdegC
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Short = 0,
  /**
   * Differential pressure temperature (0, if not available). Report values of 0 (or 1) as 1 cdegC.
   * units = cdegC
   */
  @GeneratedMavField(
    type = "int16_t",
    extension = true,
  )
  public val temperaturePressDiff: Short = 0,
) : MavMessage<ScaledPressure2> {
  override val instanceCompanion: MavMessage.MavCompanion<ScaledPressure2> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(pressAbs)
    encoder.encodeFloat(pressDiff)
    encoder.encodeInt16(temperature)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(pressAbs)
    encoder.encodeFloat(pressDiff)
    encoder.encodeInt16(temperature)
    encoder.encodeInt16(temperaturePressDiff)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScaledPressure2> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 16

    override val id: UInt = 137u

    override val crcExtra: Byte = -61

    override fun deserialize(bytes: ByteArray): ScaledPressure2 {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val pressAbs = decoder.safeDecodeFloat()
      val pressDiff = decoder.safeDecodeFloat()
      val temperature = decoder.safeDecodeInt16()
      val temperaturePressDiff = decoder.safeDecodeInt16()

      return ScaledPressure2(
        timeBootMs = timeBootMs,
        pressAbs = pressAbs,
        pressDiff = pressDiff,
        temperature = temperature,
        temperaturePressDiff = temperaturePressDiff,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScaledPressure2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var pressAbs: Float = 0F

    public var pressDiff: Float = 0F

    public var temperature: Short = 0

    public var temperaturePressDiff: Short = 0

    public fun build(): ScaledPressure2 = ScaledPressure2(
      timeBootMs = timeBootMs,
      pressAbs = pressAbs,
      pressDiff = pressDiff,
      temperature = temperature,
      temperaturePressDiff = temperaturePressDiff,
    )
  }
}
