package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeFloatArray
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloatArray
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.collections.List

/**
 * The location of a landing target. See: https://mavlink.io/en/services/landing_target.html
 */
public data class LandingTarget(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * The ID of the target if multiple targets are present
   */
  public val targetNum: Int = 0,
  /**
   * Coordinate frame used for following fields.
   */
  public val frame: MavEnumValue<MavFrame> = MavEnumValue.fromValue(0),
  /**
   * X-axis angular offset of the target from the center of the image
   */
  public val angleX: Float = 0F,
  /**
   * Y-axis angular offset of the target from the center of the image
   */
  public val angleY: Float = 0F,
  /**
   * Distance to the target from the vehicle
   */
  public val distance: Float = 0F,
  /**
   * Size of target along x-axis
   */
  public val sizeX: Float = 0F,
  /**
   * Size of target along y-axis
   */
  public val sizeY: Float = 0F,
  /**
   * X Position of the landing target in MAV_FRAME
   */
  public val x: Float = 0F,
  /**
   * Y Position of the landing target in MAV_FRAME
   */
  public val y: Float = 0F,
  /**
   * Z Position of the landing target in MAV_FRAME
   */
  public val z: Float = 0F,
  /**
   * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)
   */
  public val q: List<Float> = emptyList(),
  /**
   * Type of landing target
   */
  public val type: MavEnumValue<LandingTargetType> = MavEnumValue.fromValue(0),
  /**
   * Boolean indicating whether the position fields (x, y, z, q, type) contain valid target position
   * information (valid: 1, invalid: 0). Default is 0 (invalid).
   */
  public val positionValid: Int = 0,
) : MavMessage<LandingTarget> {
  public override val instanceMetadata: MavMessage.Metadata<LandingTarget> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(60).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeUint8(targetNum)
    outputBuffer.encodeEnumValue(frame.value, 1)
    outputBuffer.encodeFloat(angleX)
    outputBuffer.encodeFloat(angleY)
    outputBuffer.encodeFloat(distance)
    outputBuffer.encodeFloat(sizeX)
    outputBuffer.encodeFloat(sizeY)
    outputBuffer.encodeFloat(x)
    outputBuffer.encodeFloat(y)
    outputBuffer.encodeFloat(z)
    outputBuffer.encodeFloatArray(q, 16)
    outputBuffer.encodeEnumValue(type.value, 1)
    outputBuffer.encodeUint8(positionValid)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 149

    private const val CRC: Int = 31

    private val DESERIALIZER: MavDeserializer<LandingTarget> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val targetNum = inputBuffer.decodeUint8()
      val frame = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavFrame.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val angleX = inputBuffer.decodeFloat()
      val angleY = inputBuffer.decodeFloat()
      val distance = inputBuffer.decodeFloat()
      val sizeX = inputBuffer.decodeFloat()
      val sizeY = inputBuffer.decodeFloat()
      val x = inputBuffer.decodeFloat()
      val y = inputBuffer.decodeFloat()
      val z = inputBuffer.decodeFloat()
      val q = inputBuffer.decodeFloatArray(16)
      val type = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = LandingTargetType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val positionValid = inputBuffer.decodeUint8()
      LandingTarget(
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


    private val METADATA: MavMessage.Metadata<LandingTarget> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LandingTarget> = METADATA
  }
}
