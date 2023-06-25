package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Response from a GOPRO_COMMAND set request.
 */
@GeneratedMavMessage(
  id = 219u,
  crcExtra = -94,
)
public data class GoproSetResponse(
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
) : MavMessage<GoproSetResponse> {
  public override val instanceCompanion: MavMessage.MavCompanion<GoproSetResponse> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(cmdId.value, 1)
    buffer.encodeEnumValue(status.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(cmdId.value, 1)
    buffer.encodeEnumValue(status.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproSetResponse> {
    public override val id: UInt = 219u

    public override val crcExtra: Byte = -94

    public override fun deserialize(bytes: ByteArray): GoproSetResponse {
      val buffer = Buffer().write(bytes)

      val cmdId = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproRequestStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return GoproSetResponse(
        cmdId = cmdId,
        status = status,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GoproSetResponse =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0u)

    public var status: MavEnumValue<GoproRequestStatus> = MavEnumValue.fromValue(0u)

    public fun build(): GoproSetResponse = GoproSetResponse(
      cmdId = cmdId,
      status = status,
    )
  }
}
