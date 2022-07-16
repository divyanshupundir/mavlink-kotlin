package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint64
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
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
 * Camera Event.
 */
public data class CameraStatus(
  /**
   * Image timestamp (since UNIX epoch, according to camera clock).
   */
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Camera ID.
   */
  public val camIdx: Int = 0,
  /**
   * Image index.
   */
  public val imgIdx: Int = 0,
  /**
   * Event type.
   */
  public val eventId: MavEnumValue<CameraStatusTypes> = MavEnumValue.fromValue(0),
  /**
   * Parameter 1 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  public val p1: Float = 0F,
  /**
   * Parameter 2 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  public val p2: Float = 0F,
  /**
   * Parameter 3 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  public val p3: Float = 0F,
  /**
   * Parameter 4 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  public val p4: Float = 0F,
) : MavMessage<CameraStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CameraStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(p1)
    outputBuffer.encodeFloat(p2)
    outputBuffer.encodeFloat(p3)
    outputBuffer.encodeFloat(p4)
    outputBuffer.encodeUint16(imgIdx)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(camIdx)
    outputBuffer.encodeEnumValue(eventId.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 179

    private const val CRC: Int = 189

    private const val SIZE: Int = 29

    private val DESERIALIZER: MavDeserializer<CameraStatus> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for CameraStatus: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val p1 = inputBuffer.decodeFloat()
      val p2 = inputBuffer.decodeFloat()
      val p3 = inputBuffer.decodeFloat()
      val p4 = inputBuffer.decodeFloat()
      val imgIdx = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val camIdx = inputBuffer.decodeUint8()
      val eventId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CameraStatusTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      CameraStatus(
        timeUsec = timeUsec,
        targetSystem = targetSystem,
        camIdx = camIdx,
        imgIdx = imgIdx,
        eventId = eventId,
        p1 = p1,
        p2 = p2,
        p3 = p3,
        p4 = p4,
      )
    }


    private val METADATA: MavMessage.Metadata<CameraStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraStatus> = METADATA
  }
}
