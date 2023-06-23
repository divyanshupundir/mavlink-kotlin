package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 */
@GeneratedMavMessage(
  id = 8_009u,
  crcExtra = -112,
)
public data class SensAtmos(
  /**
   * Time since system boot
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  Ambient temperature
   */
  @GeneratedMavField(type = "float")
  public val tempambient: Float = 0F,
  /**
   *  Relative humidity
   */
  @GeneratedMavField(type = "float")
  public val humidity: Float = 0F,
) : MavMessage<SensAtmos> {
  public override val instanceCompanion: MavMessage.MavCompanion<SensAtmos> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(tempambient)
    output.encodeFloat(humidity)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timestamp)
    output.encodeFloat(tempambient)
    output.encodeFloat(humidity)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SensAtmos> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    public override val id: UInt = 8_009u

    public override val crcExtra: Byte = -112

    public override fun deserialize(source: BufferedSource): SensAtmos {
      val timestamp = source.decodeUInt64()
      val tempambient = source.decodeFloat()
      val humidity = source.decodeFloat()

      return SensAtmos(
        timestamp = timestamp,
        tempambient = tempambient,
        humidity = humidity,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SensAtmos =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timestamp: ULong = 0uL

    public var tempambient: Float = 0F

    public var humidity: Float = 0F

    public fun build(): SensAtmos = SensAtmos(
      timestamp = timestamp,
      tempambient = tempambient,
      humidity = humidity,
    )
  }
}
