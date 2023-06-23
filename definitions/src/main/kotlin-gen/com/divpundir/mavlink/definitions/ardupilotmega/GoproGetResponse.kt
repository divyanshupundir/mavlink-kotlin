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
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(cmdId.value, 1)
    output.encodeEnumValue(status.value, 1)
    output.encodeUInt8Array(value, 4)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(cmdId.value, 1)
    output.encodeEnumValue(status.value, 1)
    output.encodeUInt8Array(value, 4)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<GoproGetResponse> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 217u

    public override val crcExtra: Byte = -54

    public override fun deserialize(source: BufferedSource): GoproGetResponse {
      val cmdId = source.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = source.decodeEnumValue(1).let { value ->
        val entry = GoproRequestStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val value = source.decodeUInt8Array(4)

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
