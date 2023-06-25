package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Heartbeat from a HeroBus attached GoPro.
 */
@GeneratedMavMessage(
  id = 215u,
  crcExtra = 101,
)
public data class GoproHeartbeat(
  /**
   * Status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val status: MavEnumValue<GoproHeartbeatStatus> = MavEnumValue.fromValue(0u),
  /**
   * Current capture mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val captureMode: MavEnumValue<GoproCaptureMode> = MavEnumValue.fromValue(0u),
  /**
   * Additional status bits.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<GoproHeartbeatFlags> = MavBitmaskValue.fromValue(0u),
) : MavMessage<GoproHeartbeat> {
  public override val instanceCompanion: MavMessage.MavCompanion<GoproHeartbeat> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(status.value, 1)
    buffer.encodeEnumValue(captureMode.value, 1)
    buffer.encodeBitmaskValue(flags.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeEnumValue(status.value, 1)
    buffer.encodeEnumValue(captureMode.value, 1)
    buffer.encodeBitmaskValue(flags.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproHeartbeat> {
    public override val id: UInt = 215u

    public override val crcExtra: Byte = 101

    public override fun deserialize(bytes: ByteArray): GoproHeartbeat {
      val buffer = Buffer().write(bytes)

      val status = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproHeartbeatStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val captureMode = buffer.decodeEnumValue(1).let { value ->
        val entry = GoproCaptureMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = buffer.decodeBitmaskValue(1).let { value ->
        val flags = GoproHeartbeatFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }

      return GoproHeartbeat(
        status = status,
        captureMode = captureMode,
        flags = flags,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): GoproHeartbeat =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var status: MavEnumValue<GoproHeartbeatStatus> = MavEnumValue.fromValue(0u)

    public var captureMode: MavEnumValue<GoproCaptureMode> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<GoproHeartbeatFlags> = MavBitmaskValue.fromValue(0u)

    public fun build(): GoproHeartbeat = GoproHeartbeat(
      status = status,
      captureMode = captureMode,
      flags = flags,
    )
  }
}
