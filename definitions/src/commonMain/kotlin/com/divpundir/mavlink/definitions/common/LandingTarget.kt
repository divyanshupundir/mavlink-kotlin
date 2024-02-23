package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * The location of a landing target. See: https://mavlink.io/en/services/landing_target.html
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param targetNum The ID of the target if multiple targets are present
 * @param frame Coordinate frame used for following fields.
 * @param angleX X-axis angular offset of the target from the center of the image
 * units = rad
 * @param angleY Y-axis angular offset of the target from the center of the image
 * units = rad
 * @param distance Distance to the target from the vehicle
 * units = m
 * @param sizeX Size of target along x-axis
 * units = rad
 * @param sizeY Size of target along y-axis
 * units = rad
 * @param x X Position of the landing target in MAV_FRAME
 * units = m
 * @param y Y Position of the landing target in MAV_FRAME
 * units = m
 * @param z Z Position of the landing target in MAV_FRAME
 * units = m
 * @param q Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
 * @param type Type of landing target
 * @param positionValid Boolean indicating whether the position fields (x, y, z, q, type) contain
 * valid target position information (valid: 1, invalid: 0). Default is 0 (invalid).
 */
@GeneratedMavMessage(
  id = 149u,
  crcExtra = -56,
)
public data class LandingTarget(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
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
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val angleX: Float = 0F,
  /**
   * Y-axis angular offset of the target from the center of the image
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val angleY: Float = 0F,
  /**
   * Distance to the target from the vehicle
   * units = m
   */
  @GeneratedMavField(type = "float")
  public val distance: Float = 0F,
  /**
   * Size of target along x-axis
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val sizeX: Float = 0F,
  /**
   * Size of target along y-axis
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val sizeY: Float = 0F,
  /**
   * X Position of the landing target in MAV_FRAME
   * units = m
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val x: Float = 0F,
  /**
   * Y Position of the landing target in MAV_FRAME
   * units = m
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val y: Float = 0F,
  /**
   * Z Position of the landing target in MAV_FRAME
   * units = m
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
  override val instanceCompanion: MavMessage.MavCompanion<LandingTarget> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(angleX)
    encoder.encodeFloat(angleY)
    encoder.encodeFloat(distance)
    encoder.encodeFloat(sizeX)
    encoder.encodeFloat(sizeY)
    encoder.encodeUInt8(targetNum)
    encoder.encodeEnumValue(frame.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(angleX)
    encoder.encodeFloat(angleY)
    encoder.encodeFloat(distance)
    encoder.encodeFloat(sizeX)
    encoder.encodeFloat(sizeY)
    encoder.encodeUInt8(targetNum)
    encoder.encodeEnumValue(frame.value, 1)
    encoder.encodeFloat(x)
    encoder.encodeFloat(y)
    encoder.encodeFloat(z)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(positionValid)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LandingTarget> {
    private const val SIZE_V1: Int = 30

    private const val SIZE_V2: Int = 60

    override val id: UInt = 149u

    override val crcExtra: Byte = -56

    override fun deserialize(bytes: ByteArray): LandingTarget {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val angleX = decoder.safeDecodeFloat()
      val angleY = decoder.safeDecodeFloat()
      val distance = decoder.safeDecodeFloat()
      val sizeX = decoder.safeDecodeFloat()
      val sizeY = decoder.safeDecodeFloat()
      val targetNum = decoder.safeDecodeUInt8()
      val frame = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val x = decoder.safeDecodeFloat()
      val y = decoder.safeDecodeFloat()
      val z = decoder.safeDecodeFloat()
      val q = decoder.safeDecodeFloatArray(16)
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = LandingTargetType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val positionValid = decoder.safeDecodeUInt8()

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
