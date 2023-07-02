package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeFloat(roll)
    encoder.encodeFloat(pitch)
    encoder.encodeFloat(yaw)
    encoder.encodeFloat(yawAbsolute)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MountOrientation> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 265u

    public override val crcExtra: Byte = 26

    public override fun deserialize(bytes: ByteArray): MountOrientation {
      val decoder = MavDataDecoder.wrap(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val roll = decoder.safeDecodeFloat()
      val pitch = decoder.safeDecodeFloat()
      val yaw = decoder.safeDecodeFloat()
      val yawAbsolute = decoder.safeDecodeFloat()

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
