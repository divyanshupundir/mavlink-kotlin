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
 * Request to set a GOPRO_COMMAND with a desired.
 */
@GeneratedMavMessage(
  id = 218u,
  crcExtra = 17,
)
public data class GoproSetRequest(
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
   * Command ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0u),
  /**
   * Value.
   */
  @GeneratedMavField(type = "uint8_t[4]")
  public val `value`: List<UByte> = emptyList(),
) : MavMessage<GoproSetRequest> {
  public override val instanceMetadata: MavMessage.Metadata<GoproSetRequest> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeUInt8Array(value, 4)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(cmdId.value, 1)
    outputBuffer.encodeUInt8Array(value, 4)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 218u

    private const val CRC_EXTRA: Byte = 17

    private const val SIZE_V1: Int = 7

    private const val SIZE_V2: Int = 7

    private val DESERIALIZER: MavDeserializer<GoproSetRequest> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val cmdId = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val value = inputBuffer.decodeUInt8Array(4)

      GoproSetRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        cmdId = cmdId,
        value = value,
      )
    }


    private val METADATA: MavMessage.Metadata<GoproSetRequest> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GoproSetRequest> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GoproSetRequest =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0u)

    public var `value`: List<UByte> = emptyList()

    public fun build(): GoproSetRequest = GoproSetRequest(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      cmdId = cmdId,
      value = value,
    )
  }
}
