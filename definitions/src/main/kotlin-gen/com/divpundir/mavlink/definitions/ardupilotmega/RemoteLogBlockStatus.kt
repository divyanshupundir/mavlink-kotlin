package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
  public override val instanceCompanion: MavMessage.MavCompanion<RemoteLogBlockStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(seqno)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(status.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(seqno)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(status.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RemoteLogBlockStatus> {
    public override val id: UInt = 185u

    public override val crcExtra: Byte = -70

    public override fun deserialize(bytes: ByteArray): RemoteLogBlockStatus {
      val buffer = Buffer().write(bytes)

      val seqno = buffer.decodeUInt32()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val status = buffer.decodeEnumValue(1).let { value ->
        val entry = MavRemoteLogDataBlockStatuses.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return RemoteLogBlockStatus(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seqno = seqno,
        status = status,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RemoteLogBlockStatus =
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
