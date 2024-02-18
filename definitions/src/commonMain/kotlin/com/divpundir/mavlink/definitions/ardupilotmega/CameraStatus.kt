package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt16
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
import kotlin.UShort
import kotlin.Unit

/**
 * Camera Event.
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<CameraStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(p1)
    encoder.encodeFloat(p2)
    encoder.encodeFloat(p3)
    encoder.encodeFloat(p4)
    encoder.encodeUInt16(imgIdx)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(camIdx)
    encoder.encodeEnumValue(eventId.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeFloat(p1)
    encoder.encodeFloat(p2)
    encoder.encodeFloat(p3)
    encoder.encodeFloat(p4)
    encoder.encodeUInt16(imgIdx)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(camIdx)
    encoder.encodeEnumValue(eventId.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CameraStatus> {
    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    override val id: UInt = 179u

    override val crcExtra: Byte = -67

    override fun deserialize(bytes: ByteArray): CameraStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val p1 = decoder.safeDecodeFloat()
      val p2 = decoder.safeDecodeFloat()
      val p3 = decoder.safeDecodeFloat()
      val p4 = decoder.safeDecodeFloat()
      val imgIdx = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val camIdx = decoder.safeDecodeUInt8()
      val eventId = decoder.safeDecodeEnumValue(1).let { value ->
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
