package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(distance)
    buffer.encodeFloat(voltage)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(distance)
    buffer.encodeFloat(voltage)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Rangefinder> {
    public override val id: UInt = 173u

    public override val crcExtra: Byte = 83

    public override fun deserialize(bytes: ByteArray): Rangefinder {
      val buffer = Buffer().write(bytes)

      val distance = buffer.decodeFloat()
      val voltage = buffer.decodeFloat()

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
