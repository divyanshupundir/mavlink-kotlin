package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
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
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<CameraStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(p1)
    buffer.encodeFloat(p2)
    buffer.encodeFloat(p3)
    buffer.encodeFloat(p4)
    buffer.encodeUInt16(imgIdx)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(camIdx)
    buffer.encodeEnumValue(eventId.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt64(timeUsec)
    buffer.encodeFloat(p1)
    buffer.encodeFloat(p2)
    buffer.encodeFloat(p3)
    buffer.encodeFloat(p4)
    buffer.encodeUInt16(imgIdx)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(camIdx)
    buffer.encodeEnumValue(eventId.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraStatus> {
    public override val id: UInt = 179u

    public override val crcExtra: Byte = -67

    public override fun deserialize(bytes: ByteArray): CameraStatus {
      val buffer = Buffer().write(bytes)

      val timeUsec = buffer.decodeUInt64()
      val p1 = buffer.decodeFloat()
      val p2 = buffer.decodeFloat()
      val p3 = buffer.decodeFloat()
      val p4 = buffer.decodeFloat()
      val imgIdx = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val camIdx = buffer.decodeUInt8()
      val eventId = buffer.decodeEnumValue(1).let { value ->
        val entry = CameraStatusTypes.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return CameraStatus(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): CameraStatus =
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
