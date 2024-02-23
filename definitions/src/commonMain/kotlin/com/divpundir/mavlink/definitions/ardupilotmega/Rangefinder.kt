package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Rangefinder reporting.
 *
 * @param distance Distance.
 * units = m
 * @param voltage Raw voltage if available, zero otherwise.
 * units = V
 */
@GeneratedMavMessage(
  id = 173u,
  crcExtra = 83,
)
public data class Rangefinder(
  /**
   * Distance.
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Raw voltage if available, zero otherwise.
   * units = V
   */
  @GeneratedMavField(type = "float")
  public val voltage: Float = 0F,
) : MavMessage<Rangefinder> {
  override val instanceCompanion: MavMessage.MavCompanion<Rangefinder> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(distance)
    encoder.encodeFloat(voltage)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(distance)
    encoder.encodeFloat(voltage)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Rangefinder> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    override val id: UInt = 173u

    override val crcExtra: Byte = 83

    override fun deserialize(bytes: ByteArray): Rangefinder {
      val decoder = MavDataDecoder(bytes)

      val distance = decoder.safeDecodeFloat()
      val voltage = decoder.safeDecodeFloat()

      return Rangefinder(
        distance = distance,
        voltage = voltage,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Rangefinder =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var distance: Float = 0F

    public var voltage: Float = 0F

    public fun build(): Rangefinder = Rangefinder(
      distance = distance,
      voltage = voltage,
    )
  }
}
