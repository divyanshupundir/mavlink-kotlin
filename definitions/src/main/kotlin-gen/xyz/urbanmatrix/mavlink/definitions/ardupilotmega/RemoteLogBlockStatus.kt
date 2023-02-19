package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Send Status of each log block that autopilot board might have sent.
 */
@GeneratedMavMessage(
  id = 185u,
  crcExtra = -70,
)
public data class RemoteLogBlockStatus(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Log data block sequence number.
   */
  @GeneratedMavField(type = "uint32_t")
  public val seqno: UInt = 0u,
  /**
   * Log data block status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<MavRemoteLogDataBlockStatuses> = MavEnumValue.fromValue(0u),
) : MavMessage<RemoteLogBlockStatus> {
  public override val instanceMetadata: MavMessage.Metadata<RemoteLogBlockStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(seqno)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(status.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(seqno)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(status.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 185u

    private const val CRC_EXTRA: Byte = -70

    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    private val DESERIALIZER: MavDeserializer<RemoteLogBlockStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seqno = inputBuffer.decodeUInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavRemoteLogDataBlockStatuses.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      RemoteLogBlockStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seqno = seqno,
        status = status,
      )
    }


    private val METADATA: MavMessage.Metadata<RemoteLogBlockStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RemoteLogBlockStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RemoteLogBlockStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seqno: UInt = 0u

    public var status: MavEnumValue<MavRemoteLogDataBlockStatuses> = MavEnumValue.fromValue(0u)

    public fun build(): RemoteLogBlockStatus = RemoteLogBlockStatus(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seqno = seqno,
      status = status,
    )
  }
}
