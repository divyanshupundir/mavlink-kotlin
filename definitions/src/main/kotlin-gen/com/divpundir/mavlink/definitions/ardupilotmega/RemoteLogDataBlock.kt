package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

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
  public override val instanceMetadata: MavMessage.Metadata<RemoteLogDataBlock> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(seqno.value, 4)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(data, 200)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(seqno.value, 4)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8Array(data, 200)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 184u

    private const val CRC_EXTRA: Byte = -97

    private const val SIZE_V1: Int = 206

    private const val SIZE_V2: Int = 206

    private val DESERIALIZER: MavDeserializer<RemoteLogDataBlock> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val seqno = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavRemoteLogDataBlockCommands.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val data = inputBuffer.decodeUInt8Array(200)

      RemoteLogDataBlock(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seqno = seqno,
        data = data,
      )
    }


    private val METADATA: MavMessage.Metadata<RemoteLogDataBlock> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<RemoteLogDataBlock> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): RemoteLogDataBlock =
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
