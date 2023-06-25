package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeFloatArray
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * The location of a landing target. See: https://mavlink.io/en/services/landing_target.html
 */
@GeneratedMavMessage(
  id = 149u,
  crcExtra = -56,
)
public data class LandingTarget(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * The ID of the target if multiple targets are present
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetNum: UByte = 0u,
  /**
   * Coordinate frame used for following fields.
   */
  @GeneratedMavField(type = "uint8_t")
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u),
  /**
   * X-axis angular offset of the target from the center of the image
   */
  @GeneratedMavField(type = "float")
  public val angleX: Float = 0F,
  /**
   * Y-axis angular offset of the target from the center of the image
   */
  @GeneratedMavField(type = "float")
  public val angleY: Float = 0F,
  /**
   * Distance to the target from the vehicle
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Size of target along x-axis
   */
  @GeneratedMavField(type = "float")
  public val sizeX: Float = 0F,
  /**
   * Size of target along y-axis
   */
  @GeneratedMavField(type = "float")
  public val sizeY: Float = 0F,
  /**
   * X Position of the landing target in MAV_FRAME
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val x: Float = 0F,
  /**
   * Y Position of the landing target in MAV_FRAME
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val y: Float = 0F,
  /**
   * Z Position of the landing target in MAV_FRAME
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val z: Float = 0F,
  /**
   * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  @GeneratedMavField(
    type = "float[4]",
    extension = true,
  )
  public val q: List<Float> = emptyList(),
  /**
   * Type of landing target
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val type: MavEnumValue<LandingTargetType> = MavEnumValue.fromValue(0u),
  /**
   * Boolean indicating whether the position fields (x, y, z, q, type) contain valid target position
   * information (valid: 1, invalid: 0). Default is 0 (invalid).
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val positionValid: UByte = 0u,
) : MavMessage<LandingTarget> {
  public override val instanceCompanion: MavMessage.MavCompanion<LandingTarget> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(angleX)
    buffer.encodeFloat(angleY)
    buffer.encodeFloat(distance)
    buffer.encodeFloat(sizeX)
    buffer.encodeFloat(sizeY)
    buffer.encodeUInt8(targetNum)
    buffer.encodeEnumValue(frame.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(angleX)
    buffer.encodeFloat(angleY)
    buffer.encodeFloat(distance)
    buffer.encodeFloat(sizeX)
    buffer.encodeFloat(sizeY)
    buffer.encodeUInt8(targetNum)
    buffer.encodeEnumValue(frame.value, 1)
    buffer.encodeFloat(x)
    buffer.encodeFloat(y)
    buffer.encodeFloat(z)
    buffer.encodeFloatArray(q, 16)
    buffer.encodeEnumValue(type.value, 1)
    buffer.encodeUInt8(positionValid)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LandingTarget> {
    public override val id: UInt = 149u

    public override val crcExtra: Byte = -56

    public override fun deserialize(bytes: ByteArray): LandingTarget {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val angleX = buffer.decodeFloat()
      val angleY = buffer.decodeFloat()
      val distance = buffer.decodeFloat()
      val sizeX = buffer.decodeFloat()
      val sizeY = buffer.decodeFloat()
      val targetNum = buffer.decodeUInt8()
      val frame = buffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val x = buffer.decodeFloat()
      val y = buffer.decodeFloat()
      val z = buffer.decodeFloat()
      val q = buffer.decodeFloatArray(16)
      val type = buffer.decodeEnumValue(1).let { value ->
        val entry = LandingTargetType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val positionValid = buffer.decodeUInt8()

      return LandingTarget(
        timeUsec = timeUsec,
        targetNum = targetNum,
        frame = frame,
        angleX = angleX,
        angleY = angleY,
        distance = distance,
        sizeX = sizeX,
        sizeY = sizeY,
        x = x,
        y = y,
        z = z,
        q = q,
        type = type,
        positionValid = positionValid,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LandingTarget =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var targetNum: UByte = 0u

    public var frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0u)

    public var angleX: Float = 0F

    public var angleY: Float = 0F

    public var distance: Float = 0F

    public var sizeX: Float = 0F

    public var sizeY: Float = 0F

    public var x: Float = 0F

    public var y: Float = 0F

    public var z: Float = 0F

    public var q: List<Float> = emptyList()

    public var type: MavEnumValue<LandingTargetType> = MavEnumValue.fromValue(0u)

    public var positionValid: UByte = 0u

    public fun build(): LandingTarget = LandingTarget(
      timeUsec = timeUsec,
      targetNum = targetNum,
      frame = frame,
      angleX = angleX,
      angleY = angleY,
      distance = distance,
      sizeX = sizeX,
      sizeY = sizeY,
      x = x,
      y = y,
      z = z,
      q = q,
      type = type,
      positionValid = positionValid,
    )
  }
}
