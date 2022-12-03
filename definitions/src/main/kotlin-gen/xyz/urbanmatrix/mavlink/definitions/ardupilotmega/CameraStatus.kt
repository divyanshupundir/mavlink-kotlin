package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Camera Event.
 */
@GeneratedMavMessage(
  id = 179,
  crc = 189,
)
public data class CameraStatus(
  /**
   * Image timestamp (since UNIX epoch, according to camera clock).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Camera ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val camIdx: Int = 0,
  /**
   * Image index.
   */
  @GeneratedMavField(type = "uint16_t")
  public val imgIdx: Int = 0,
  /**
   * Event type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val eventId: MavEnumValue<CameraStatusTypes> = MavEnumValue.fromValue(0),
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(p1)
    outputBuffer.encodeFloat(p2)
    outputBuffer.encodeFloat(p3)
    outputBuffer.encodeFloat(p4)
    outputBuffer.encodeUint16(imgIdx)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(camIdx)
    outputBuffer.encodeEnumValue(eventId.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 179

    private const val CRC: Int = 189

    private const val SIZE_V1: Int = 29

    private const val SIZE_V2: Int = 29

    private val DESERIALIZER: MavDeserializer<CameraStatus> = MavDeserializer { bytes ->
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

    public fun builder(builderAction: Builder.() -> Unit): CameraStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var targetSystem: Int = 0

    public var camIdx: Int = 0

    public var imgIdx: Int = 0

    public var eventId: MavEnumValue<CameraStatusTypes> = MavEnumValue.fromValue(0)

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
