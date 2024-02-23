package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit

/**
 * Atmospheric sensors (temperature, humidity, ...) 
 *
 * @param timestamp Time since system boot
 * units = us
 * @param tempambient  Ambient temperature
 * units = degC
 * @param humidity  Relative humidity
 * units = %
 */
@GeneratedMavMessage(
  id = 8_009u,
  crcExtra = -112,
)
public data class SensAtmos(
  /**
   * Time since system boot
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timestamp: ULong = 0uL,
  /**
   *  Ambient temperature
   * units = degC
   */
  @GeneratedMavField(type = "float")
  public val tempambient: Float = 0F,
  /**
   *  Relative humidity
   * units = %
   */
  @GeneratedMavField(type = "float")
  public val humidity: Float = 0F,
) : MavMessage<SensAtmos> {
  override val instanceCompanion: MavMessage.MavCompanion<SensAtmos> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(tempambient)
    encoder.encodeFloat(humidity)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timestamp)
    encoder.encodeFloat(tempambient)
    encoder.encodeFloat(humidity)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SensAtmos> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 16

    override val id: UInt = 8_009u

    override val crcExtra: Byte = -112

    override fun deserialize(bytes: ByteArray): SensAtmos {
      val decoder = MavDataDecoder(bytes)

      val timestamp = decoder.safeDecodeUInt64()
      val tempambient = decoder.safeDecodeFloat()
      val humidity = decoder.safeDecodeFloat()

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
