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
 * RPM sensor output.
 */
@GeneratedMavMessage(
  id = 226u,
  crcExtra = -49,
)
public data class Rpm(
  /**
   * RPM Sensor1.
   */
  @GeneratedMavField(type = "float")
  public val rpm1: Float = 0F,
  /**
   * RPM Sensor2.
   */
  @GeneratedMavField(type = "float")
  public val rpm2: Float = 0F,
) : MavMessage<Rpm> {
  public override val instanceCompanion: MavMessage.MavCompanion<Rpm> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(rpm1)
    buffer.encodeFloat(rpm2)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(rpm1)
    buffer.encodeFloat(rpm2)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Rpm> {
    public override val id: UInt = 226u

    public override val crcExtra: Byte = -49

    public override fun deserialize(bytes: ByteArray): Rpm {
      val buffer = Buffer().write(bytes)

      val rpm1 = buffer.decodeFloat()
      val rpm2 = buffer.decodeFloat()

      return Rpm(
        rpm1 = rpm1,
        rpm2 = rpm2,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Rpm =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var rpm1: Float = 0F

    public var rpm2: Float = 0F

    public fun build(): Rpm = Rpm(
      rpm1 = rpm1,
      rpm2 = rpm2,
    )
  }
}
