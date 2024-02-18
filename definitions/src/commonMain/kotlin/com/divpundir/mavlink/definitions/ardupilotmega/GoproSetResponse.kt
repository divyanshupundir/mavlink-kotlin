package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

/**
 * Response from a GOPRO_COMMAND set request.
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<GoproSetResponse> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(cmdId.value, 1)
    encoder.encodeEnumValue(status.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(cmdId.value, 1)
    encoder.encodeEnumValue(status.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproSetResponse> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    override val id: UInt = 219u

    override val crcExtra: Byte = -94

    override fun deserialize(bytes: ByteArray): GoproSetResponse {
      val decoder = MavDataDecoder(bytes)

      val cmdId = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = decoder.safeDecodeEnumValue(1).let { value ->
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
