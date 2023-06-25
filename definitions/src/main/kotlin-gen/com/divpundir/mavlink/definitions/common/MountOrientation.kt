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
import kotlin.Deprecated
import kotlin.Float
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Orientation of a mount
 */
@Deprecated(message =
    "This message is being superseded by MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW. The message can still be used to communicate with legacy gimbals implementing it.")
@GeneratedMavMessage(
  id = 265u,
  crcExtra = 26,
)
public data class MountOrientation(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Roll in global frame (set to NaN for invalid).
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Pitch in global frame (set to NaN for invalid).
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Yaw relative to vehicle (set to NaN for invalid).
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Yaw in absolute frame relative to Earth's North, north is 0 (set to NaN for invalid).
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val yawAbsolute: Float = 0F,
) : MavMessage<MountOrientation> {
  public override val instanceCompanion: MavMessage.MavCompanion<MountOrientation> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(yawAbsolute)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountOrientation> {
    public override val id: UInt = 265u

    public override val crcExtra: Byte = 26

    public override fun deserialize(bytes: ByteArray): MountOrientation {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val yawAbsolute = buffer.decodeFloat()

      return MountOrientation(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        yawAbsolute = yawAbsolute,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MountOrientation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var yawAbsolute: Float = 0F

    public fun build(): MountOrientation = MountOrientation(
      timeBootMs = timeBootMs,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      yawAbsolute = yawAbsolute,
    )
  }
}
