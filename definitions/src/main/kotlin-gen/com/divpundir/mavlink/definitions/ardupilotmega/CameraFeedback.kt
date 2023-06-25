package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt32
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Camera Capture Feedback.
 */
@GeneratedMavMessage(
  id = 180u,
  crcExtra = 52,
)
public data class CameraFeedback(
  /**
   * Image timestamp (since UNIX epoch), as passed in by CAMERA_STATUS message (or autopilot if no
   * CCB).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Camera ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val camIdx: UByte = 0u,
  /**
   * Image index.
   */
  @GeneratedMavField(type = "uint16_t")
  public val imgIdx: UShort = 0u,
  /**
   * Latitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  @GeneratedMavField(type = "int32_t")
  public val lng: Int = 0,
  /**
   * Altitude (MSL).
   */
  @GeneratedMavField(type = "float")
  public val altMsl: Float = 0F,
  /**
   * Altitude (Relative to HOME location).
   */
  @GeneratedMavField(type = "float")
  public val altRel: Float = 0F,
  /**
   * Camera Roll angle (earth frame, +-180).
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Camera Pitch angle (earth frame, +-180).
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Camera Yaw (earth frame, 0-360, true).
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Focal Length.
   */
  @GeneratedMavField(type = "float")
  public val focLen: Float = 0F,
  /**
   * Feedback flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavEnumValue<CameraFeedbackFlags> = MavEnumValue.fromValue(0u),
  /**
   * Completed image captures.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val completedCaptures: UShort = 0u,
) : MavMessage<CameraFeedback> {
  public override val instanceCompanion: MavMessage.MavCompanion<CameraFeedback> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeFloat(altMsl)
    buffer.encodeFloat(altRel)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(focLen)
    buffer.encodeUInt16(imgIdx)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(camIdx)
    buffer.encodeEnumValue(flags.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeInt32(lat)
    buffer.encodeInt32(lng)
    buffer.encodeFloat(altMsl)
    buffer.encodeFloat(altRel)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(focLen)
    buffer.encodeUInt16(imgIdx)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(camIdx)
    buffer.encodeEnumValue(flags.value, 1)
    buffer.encodeUInt16(completedCaptures)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraFeedback> {
    public override val id: UInt = 180u

    public override val crcExtra: Byte = 52

    public override fun deserialize(bytes: ByteArray): CameraFeedback {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val lat = buffer.decodeInt32()
      val lng = buffer.decodeInt32()
      val altMsl = buffer.decodeFloat()
      val altRel = buffer.decodeFloat()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val focLen = buffer.decodeFloat()
      val imgIdx = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val camIdx = buffer.decodeUInt8()
      val flags = buffer.decodeEnumValue(1).let { value ->
        val entry = CameraFeedbackFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val completedCaptures = buffer.decodeUInt16()

      return CameraFeedback(
        timeUsec = timeUsec,
        targetSystem = targetSystem,
        camIdx = camIdx,
        imgIdx = imgIdx,
        lat = lat,
        lng = lng,
        altMsl = altMsl,
        altRel = altRel,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        focLen = focLen,
        flags = flags,
        completedCaptures = completedCaptures,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraFeedback =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var targetSystem: UByte = 0u

    public var camIdx: UByte = 0u

    public var imgIdx: UShort = 0u

    public var lat: Int = 0

    public var lng: Int = 0

    public var altMsl: Float = 0F

    public var altRel: Float = 0F

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var focLen: Float = 0F

    public var flags: MavEnumValue<CameraFeedbackFlags> = MavEnumValue.fromValue(0u)

    public var completedCaptures: UShort = 0u

    public fun build(): CameraFeedback = CameraFeedback(
      timeUsec = timeUsec,
      targetSystem = targetSystem,
      camIdx = camIdx,
      imgIdx = imgIdx,
      lat = lat,
      lng = lng,
      altMsl = altMsl,
      altRel = altRel,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      focLen = focLen,
      flags = flags,
      completedCaptures = completedCaptures,
    )
  }
}
