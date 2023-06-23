package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(cmdId.value, 1)
    output.encodeEnumValue(status.value, 1)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(cmdId.value, 1)
    output.encodeEnumValue(status.value, 1)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GoproSetResponse> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    public override val id: UInt = 219u

    public override val crcExtra: Byte = -94

    public override fun deserialize(source: BufferedSource): GoproSetResponse {
      val cmdId = source.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = source.decodeEnumValue(1).let { value ->
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
