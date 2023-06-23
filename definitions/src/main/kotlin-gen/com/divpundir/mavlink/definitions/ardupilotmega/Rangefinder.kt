package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Rangefinder reporting.
 */
@GeneratedMavMessage(
  id = 173u,
  crcExtra = 83,
)
public data class Rangefinder(
  /**
   * Distance.
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Raw voltage if available, zero otherwise.
   */
  @GeneratedMavField(type = "float")
  public val voltage: Float = 0F,
) : MavMessage<Rangefinder> {
  public override val instanceCompanion: MavMessage.MavCompanion<Rangefinder> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(distance)
    output.encodeFloat(voltage)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(distance)
    output.encodeFloat(voltage)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Rangefinder> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 173u

    public override val crcExtra: Byte = 83

    public override fun deserialize(source: BufferedSource): Rangefinder {
      val distance = source.decodeFloat()
      val voltage = source.decodeFloat()

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
