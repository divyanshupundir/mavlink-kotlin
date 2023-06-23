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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(rpm1)
    output.encodeFloat(rpm2)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(rpm1)
    output.encodeFloat(rpm2)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Rpm> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 226u

    public override val crcExtra: Byte = -49

    public override fun deserialize(source: BufferedSource): Rpm {
      val rpm1 = source.decodeFloat()
      val rpm2 = source.decodeFloat()

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
