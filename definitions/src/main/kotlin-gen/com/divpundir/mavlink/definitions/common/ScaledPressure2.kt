package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * Barometer readings for 2nd barometer
 */
@GeneratedMavMessage(
  id = 137u,
  crcExtra = -61,
)
public data class ScaledPressure2(
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
) : MavMessage<ScaledPressure2> {
  public override val instanceMetadata: MavMessage.Metadata<ScaledPressure2> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(pressAbs)
    outputBuffer.encodeFloat(pressDiff)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeFloat(pressAbs)
    outputBuffer.encodeFloat(pressDiff)
    outputBuffer.encodeInt16(temperature)
    outputBuffer.encodeInt16(temperaturePressDiff)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 137u

    private const val CRC_EXTRA: Byte = -61

    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 16

    private val DESERIALIZER: MavDeserializer<ScaledPressure2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val pressAbs = inputBuffer.decodeFloat()
      val pressDiff = inputBuffer.decodeFloat()
      val temperature = inputBuffer.decodeInt16()
      val temperaturePressDiff = inputBuffer.decodeInt16()

      ScaledPressure2(
        timeBootMs = timeBootMs,
        pressAbs = pressAbs,
        pressDiff = pressDiff,
        temperature = temperature,
        temperaturePressDiff = temperaturePressDiff,
      )
    }


    private val METADATA: MavMessage.Metadata<ScaledPressure2> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ScaledPressure2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ScaledPressure2 =
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
