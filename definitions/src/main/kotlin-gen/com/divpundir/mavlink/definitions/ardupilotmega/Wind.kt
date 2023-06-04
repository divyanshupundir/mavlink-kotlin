package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Wind estimation.
 */
@GeneratedMavMessage(
  id = 168u,
  crcExtra = 1,
)
public data class Wind(
  /**
   * Wind direction (that wind is coming from).
   */
  @GeneratedMavField(type = "float")
  public val direction: Float = 0F,
  /**
   * Wind speed in ground plane.
   */
  @GeneratedMavField(type = "float")
  public val speed: Float = 0F,
  /**
   * Vertical wind speed.
   */
  @GeneratedMavField(type = "float")
  public val speedZ: Float = 0F,
) : MavMessage<Wind> {
  public override val instanceCompanion: MavMessage.MavCompanion<Wind> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(direction)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(speedZ)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(direction)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(speedZ)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Wind> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 168u

    public override val crcExtra: Byte = 1

    public override fun deserialize(bytes: ByteArray): Wind {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val direction = inputBuffer.decodeFloat()
      val speed = inputBuffer.decodeFloat()
      val speedZ = inputBuffer.decodeFloat()

      return Wind(
        direction = direction,
        speed = speed,
        speedZ = speedZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Wind =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var direction: Float = 0F

    public var speed: Float = 0F

    public var speedZ: Float = 0F

    public fun build(): Wind = Wind(
      direction = direction,
      speed = speed,
      speedZ = speedZ,
    )
  }
}
