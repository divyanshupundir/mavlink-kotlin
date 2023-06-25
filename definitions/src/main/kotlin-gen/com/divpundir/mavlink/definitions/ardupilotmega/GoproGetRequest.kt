package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Request a GOPRO_COMMAND response from the GoPro.
 */
@GeneratedMavMessage(
  id = 216u,
  crcExtra = 50,
)
public data class GoproGetRequest(
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
) : MavMessage<GoproGetRequest> {
  public override val instanceCompanion: MavMessage.MavCompanion<GoproGetRequest> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(cmdId.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(cmdId.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproGetRequest> {
    public override val id: UInt = 216u

    public override val crcExtra: Byte = 50

    public override fun deserialize(bytes: ByteArray): GoproGetRequest {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val cmdId = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproCommand.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return GoproGetRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        cmdId = cmdId,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GoproGetRequest =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var cmdId: MavEnumValue<GoproCommand> = MavEnumValue.fromValue(0u)

    public fun build(): GoproGetRequest = GoproGetRequest(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      cmdId = cmdId,
    )
  }
}
