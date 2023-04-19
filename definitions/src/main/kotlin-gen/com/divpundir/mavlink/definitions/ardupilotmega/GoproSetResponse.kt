package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<GoproSetResponse> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeEnumValue(status.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeEnumValue(status.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 219u

    private const val CRC_EXTRA: Byte = -94

    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    private val DESERIALIZER: MavDeserializer<GoproSetResponse> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val cmdId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val status = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproRequestStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      GoproSetResponse(
        cmdId = cmdId,
        status = status,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproSetResponse> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproSetResponse> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GoproSetResponse =
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
