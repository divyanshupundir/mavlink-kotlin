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
 * Wind estimation.
 *
 * @param direction Wind direction (that wind is coming from).
 * units = deg
 * @param speed Wind speed in ground plane.
 * units = m/s
 * @param speedZ Vertical wind speed.
 * units = m/s
 */
@GeneratedMavMessage(
  id = 168u,
  crcExtra = 1,
)
public data class Wind(
  /**
   * Wind direction (that wind is coming from).
   * units = deg
   */
  @GeneratedMavField(type = "float")
  public val direction: Float = 0F,
  /**
   * Wind speed in ground plane.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val speed: Float = 0F,
  /**
   * Vertical wind speed.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val speedZ: Float = 0F,
) : MavMessage<Wind> {
  override val instanceCompanion: MavMessage.MavCompanion<Wind> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(direction)
    encoder.encodeFloat(speed)
    encoder.encodeFloat(speedZ)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(direction)
    encoder.encodeFloat(speed)
    encoder.encodeFloat(speedZ)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Wind> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    override val id: UInt = 168u

    override val crcExtra: Byte = 1

    override fun deserialize(bytes: ByteArray): Wind {
      val decoder = MavDataDecoder(bytes)

      val direction = decoder.safeDecodeFloat()
      val speed = decoder.safeDecodeFloat()
      val speedZ = decoder.safeDecodeFloat()

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
