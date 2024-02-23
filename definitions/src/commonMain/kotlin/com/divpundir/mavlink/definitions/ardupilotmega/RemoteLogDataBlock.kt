package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Send a block of log data to remote location.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param seqno Log data block sequence number.
 * @param data Log data block.
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
  override val instanceCompanion: MavMessage.MavCompanion<RemoteLogDataBlock> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(seqno.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(data, 200)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(seqno.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8Array(data, 200)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RemoteLogDataBlock> {
    private const val SIZE_V1: Int = 206

    private const val SIZE_V2: Int = 206

    override val id: UInt = 184u

    override val crcExtra: Byte = -97

    override fun deserialize(bytes: ByteArray): RemoteLogDataBlock {
      val decoder = MavDataDecoder(bytes)

      val seqno = decoder.safeDecodeEnumValue(4).let { value ->
        val entry = MavRemoteLogDataBlockCommands.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(200)

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
