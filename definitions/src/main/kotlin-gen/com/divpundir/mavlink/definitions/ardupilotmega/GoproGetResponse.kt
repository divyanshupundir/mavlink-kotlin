package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
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
 * Response from a GOPRO_COMMAND get request.
 */
@GeneratedMavMessage(
  id = 217u,
  crcExtra = -54,
)
public data class GoproGetResponse(
  /**
   * Command ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0u),
  /**
   * Status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<GoproRequestStatus> = MavEnumValue.fromValue(0u),
  /**
   * Value.
   */
  @GeneratedMavField(type = "uint8_t[4]")
  public val `value`: List<UByte> = emptyList(),
) : MavMessage<GoproGetResponse> {
  public override val instanceCompanion: MavMessage.MavCompanion<GoproGetResponse> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(cmdId.value, 1)
    buffer.encodeEnumValue(status.value, 1)
    buffer.encodeUInt8Array(value, 4)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(cmdId.value, 1)
    buffer.encodeEnumValue(status.value, 1)
    buffer.encodeUInt8Array(value, 4)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproGetResponse> {
    public override val id: UInt = 217u

    public override val crcExtra: Byte = -54

    public override fun deserialize(bytes: ByteArray): GoproGetResponse {
      val buffer = Buffer().write(bytes)

      val cmdId = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproRequestStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val value = buffer.decodeUInt8Array(4)

      return GoproGetResponse(
        cmdId = cmdId,
        status = status,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GoproGetResponse =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0u)

    public var status: MavEnumValue<GoproRequestStatus> = MavEnumValue.fromValue(0u)

    public var `value`: List<UByte> = emptyList()

    public fun build(): GoproGetResponse = GoproGetResponse(
      cmdId = cmdId,
      status = status,
      value = value,
    )
  }
}
