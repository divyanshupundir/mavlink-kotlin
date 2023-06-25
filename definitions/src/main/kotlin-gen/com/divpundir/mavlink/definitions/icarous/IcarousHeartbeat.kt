package com.divpundir.mavlink.definitions.icarous

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
 * ICAROUS heartbeat
 */
@GeneratedMavMessage(
  id = 42_000u,
  crcExtra = -29,
)
public data class IcarousHeartbeat(
  /**
   * See the FMS_STATE enum.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<IcarousFmsState> = MavEnumValue.fromValue(0u),
) : MavMessage<IcarousHeartbeat> {
  public override val instanceCompanion: MavMessage.MavCompanion<IcarousHeartbeat> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(status.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(status.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<IcarousHeartbeat> {
    public override val id: UInt = 42_000u

    public override val crcExtra: Byte = -29

    public override fun deserialize(bytes: ByteArray): IcarousHeartbeat {
      val buffer = Buffer().write(bytes)

      val status = buffer.decodeEnumValue(1).let { value ->
        val entry = IcarousFmsState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return IcarousHeartbeat(
        status = status,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): IcarousHeartbeat =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavEnumValue<IcarousFmsState> = MavEnumValue.fromValue(0u)

    public fun build(): IcarousHeartbeat = IcarousHeartbeat(
      status = status,
    )
  }
}
