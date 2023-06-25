package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right).
 */
@GeneratedMavMessage(
  id = 30u,
  crcExtra = 39,
)
public data class Attitude(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Roll angle (-pi..+pi)
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch angle (-pi..+pi)
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw angle (-pi..+pi)
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Roll angular speed
   */
  @GeneratedMavField(type = "float")
  public val rollspeed: Float = 0F,
  /**
   * Pitch angular speed
   */
  @GeneratedMavField(type = "float")
  public val pitchspeed: Float = 0F,
  /**
   * Yaw angular speed
   */
  @GeneratedMavField(type = "float")
  public val yawspeed: Float = 0F,
) : MavMessage<Attitude> {
  public override val instanceCompanion: MavMessage.MavCompanion<Attitude> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(rollspeed)
    buffer.encodeFloat(pitchspeed)
    buffer.encodeFloat(yawspeed)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(rollspeed)
    buffer.encodeFloat(pitchspeed)
    buffer.encodeFloat(yawspeed)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Attitude> {
    public override val id: UInt = 30u

    public override val crcExtra: Byte = 39

    public override fun deserialize(bytes: ByteArray): Attitude {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val rollspeed = buffer.decodeFloat()
      val pitchspeed = buffer.decodeFloat()
      val yawspeed = buffer.decodeFloat()

      return Attitude(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        rollspeed = rollspeed,
        pitchspeed = pitchspeed,
        yawspeed = yawspeed,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Attitude =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var rollspeed: Float = 0F

    public var pitchspeed: Float = 0F

    public var yawspeed: Float = 0F

    public fun build(): Attitude = Attitude(
      timeBootMs = timeBootMs,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      rollspeed = rollspeed,
      pitchspeed = pitchspeed,
      yawspeed = yawspeed,
    )
  }
}
