package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Send a block of log data to remote location.
 */
@GeneratedMavMessage(
  id = 184u,
  crcExtra = -97,
)
public data class RemoteLogDataBlock(
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
  public val seqno: MavEnumValue<MavRemoteLogDataBlockCommands> = MavEnumValue.fromValue(0u),
  /**
   * Log data block.
   */
  @GeneratedMavField(type = "uint8_t[200]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<RemoteLogDataBlock> {
  public override val instanceCompanion: MavMessage.MavCompanion<RemoteLogDataBlock> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(seqno.value, 4)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(data, 200)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(seqno.value, 4)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8Array(data, 200)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RemoteLogDataBlock> {
    public override val id: UInt = 184u

    public override val crcExtra: Byte = -97

    public override fun deserialize(bytes: ByteArray): RemoteLogDataBlock {
      val buffer = Buffer().write(bytes)

      val seqno = buffer.decodeEnumValue(4).let { value ->
        val entry = MavRemoteLogDataBlockCommands.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val data = buffer.decodeUInt8Array(200)

      return RemoteLogDataBlock(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seqno = seqno,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RemoteLogDataBlock =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seqno: MavEnumValue<MavRemoteLogDataBlockCommands> = MavEnumValue.fromValue(0u)

    public var `data`: List<UByte> = emptyList()

    public fun build(): RemoteLogDataBlock = RemoteLogDataBlock(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seqno = seqno,
      data = data,
    )
  }
}
