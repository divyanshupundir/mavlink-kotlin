package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * Camera Event.
 */
@GeneratedMavMessage(
  id = 179u,
  crcExtra = -67,
)
public data class CameraStatus(
  /**
   * Image timestamp (since UNIX epoch, according to camera clock).
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
   * Event type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val eventId: MavEnumValue<CameraStatusTypes> = MavEnumValue.fromValue(0u),
  /**
   * Parameter 1 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  @GeneratedMavField(type = "float")
  public val p1: Float = 0F,
  /**
   * Parameter 2 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  @GeneratedMavField(type = "float")
  public val p2: Float = 0F,
  /**
   * Parameter 3 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  @GeneratedMavField(type = "float")
  public val p3: Float = 0F,
  /**
   * Parameter 4 (meaning depends on event_id, see CAMERA_STATUS_TYPES enum).
   */
  @GeneratedMavField(type = "float")
  public val p4: Float = 0F,
) : MavMessage<CameraStatus> {
  public override val instanceMetadata: MavMessage.Metadata<CameraStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(p1)
    outputBuffer.encodeFloat(p2)
    outputBuffer.encodeFloat(p3)
    outputBuffer.encodeFloat(p4)
    outputBuffer.encodeUInt16(imgIdx)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(camIdx)
    outputBuffer.encodeEnumValue(eventId.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeFloat(p1)
    outputBuffer.encodeFloat(p2)
    outputBuffer.encodeFloat(p3)
    outputBuffer.encodeFloat(p4)
    outputBuffer.encodeUInt16(imgIdx)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(camIdx)
    outputBuffer.encodeEnumValue(eventId.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 179u

    private const val CRC_EXTRA: Byte = -67

    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    private val DESERIALIZER: MavDeserializer<CameraStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val p1 = inputBuffer.decodeFloat()
      val p2 = inputBuffer.decodeFloat()
      val p3 = inputBuffer.decodeFloat()
      val p4 = inputBuffer.decodeFloat()
      val imgIdx = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val camIdx = inputBuffer.decodeUInt8()
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


    private val METADATA: MavMessage.Metadata<CameraStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CameraStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): CameraStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var targetSystem: UByte = 0u

    public var camIdx: UByte = 0u

    public var imgIdx: UShort = 0u

    public var eventId: MavEnumValue<CameraStatusTypes> = MavEnumValue.fromValue(0u)

    public var p1: Float = 0F

    public var p2: Float = 0F

    public var p3: Float = 0F

    public var p4: Float = 0F

    public fun build(): CameraStatus = CameraStatus(
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
}
