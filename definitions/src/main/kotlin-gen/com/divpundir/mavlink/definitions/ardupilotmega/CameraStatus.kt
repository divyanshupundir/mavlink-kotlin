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
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(p1)
    output.encodeFloat(p2)
    output.encodeFloat(p3)
    output.encodeFloat(p4)
    output.encodeUInt16(imgIdx)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(camIdx)
    output.encodeEnumValue(eventId.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeFloat(p1)
    output.encodeFloat(p2)
    output.encodeFloat(p3)
    output.encodeFloat(p4)
    output.encodeUInt16(imgIdx)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(camIdx)
    output.encodeEnumValue(eventId.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<CameraStatus> {
    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    public override val id: UInt = 179u

    public override val crcExtra: Byte = -67

    public override fun deserialize(source: BufferedSource): CameraStatus {
      val timeUsec = source.decodeUInt64()
      val p1 = source.decodeFloat()
      val p2 = source.decodeFloat()
      val p3 = source.decodeFloat()
      val p4 = source.decodeFloat()
      val imgIdx = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val camIdx = source.decodeUInt8()
      val eventId = source.decodeEnumValue(1).let { value ->
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
