package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
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
  public override val instanceCompanion: MavMessage.MavCompanion<GoproSetRequest> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(cmdId.value, 1)
    buffer.encodeUInt8Array(value, 4)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(cmdId.value, 1)
    buffer.encodeUInt8Array(value, 4)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproSetRequest> {
    public override val id: UInt = 218u

    public override val crcExtra: Byte = 17

    public override fun deserialize(bytes: ByteArray): GoproSetRequest {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val cmdId = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val value = buffer.decodeUInt8Array(4)

      return GoproSetRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        cmdId = cmdId,
        value = value,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GoproSetRequest =
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
