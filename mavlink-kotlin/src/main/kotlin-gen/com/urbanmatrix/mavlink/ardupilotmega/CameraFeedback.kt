package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt32
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt32
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint64
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Camera Capture Feedback.
 */
public data class CameraFeedback(
  /**
   * Image timestamp (since UNIX epoch), as passed in by CAMERA_STATUS message (or autopilot if no
   * CCB).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Latitude.
   */
  public val lat: Int = 0,
  /**
   * Longitude.
   */
  public val lng: Int = 0,
  /**
   * Altitude (MSL).
   */
  public val altMsl: Float = 0F,
  /**
   * Altitude (Relative to HOME location).
   */
  public val altRel: Float = 0F,
  /**
   * Camera Roll angle (earth frame, +-180).
   */
  public val roll: Float = 0F,
  /**
   * Camera Pitch angle (earth frame, +-180).
   */
  public val pitch: Float = 0F,
  /**
   * Camera Yaw (earth frame, 0-360, true).
   */
  public val yaw: Float = 0F,
  /**
   * Focal Length.
   */
  public val focLen: Float = 0F,
  /**
   * Image index.
   */
  public val imgIdx: Int = 0,
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Camera ID.
   */
  public val camIdx: Int = 0,
  /**
   * Feedback flags.
   */
  public val flags: MavEnumValue<CameraFeedbackFlags> = MavEnumValue.fromValue(0),
  /**
   * Completed image captures.
   */
  public val completedCaptures: Int = 0,
) : MavMessage<CameraFeedback> {
  public override val instanceMetadata: MavMessage.Metadata<CameraFeedback> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(47).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeInt32(lat)
    outputBuffer.encodeInt32(lng)
    outputBuffer.encodeFloat(altMsl)
    outputBuffer.encodeFloat(altRel)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(focLen)
    outputBuffer.encodeUint16(imgIdx)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(camIdx)
    outputBuffer.encodeEnumValue(flags.value, 1)
    outputBuffer.encodeUint16(completedCaptures)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 180

    private const val CRC: Int = 52

    private val DESERIALIZER: MavDeserializer<CameraFeedback> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val lat = inputBuffer.decodeInt32()
      val lng = inputBuffer.decodeInt32()
      val altMsl = inputBuffer.decodeFloat()
      val altRel = inputBuffer.decodeFloat()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val focLen = inputBuffer.decodeFloat()
      val imgIdx = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val camIdx = inputBuffer.decodeUint8()
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraFeedbackFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val completedCaptures = inputBuffer.decodeUint16()
      CameraFeedback(
        timeUsec = timeUsec,
        lat = lat,
        lng = lng,
        altMsl = altMsl,
        altRel = altRel,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        focLen = focLen,
        imgIdx = imgIdx,
        targetSystem = targetSystem,
        camIdx = camIdx,
        flags = flags,
        completedCaptures = completedCaptures,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraFeedback> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraFeedback> = METADATA
  }
}
