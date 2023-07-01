package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(seqno)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(status.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(seqno)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(status.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RemoteLogBlockStatus> {
    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    public override val id: UInt = 185u

    public override val crcExtra: Byte = -70

    public override fun deserialize(bytes: ByteArray): RemoteLogBlockStatus {
      val decoder = MavDataDecoder.wrap(bytes)

      val seqno = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val status = decoder.safeDecodeEnumValue(1).let { value ->
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
