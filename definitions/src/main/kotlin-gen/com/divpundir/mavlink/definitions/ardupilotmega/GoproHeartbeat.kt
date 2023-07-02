package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.Unit

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
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeEnumValue(captureMode.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeEnumValue(status.value, 1)
    encoder.encodeEnumValue(captureMode.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproHeartbeat> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 215u

    public override val crcExtra: Byte = 101

    public override fun deserialize(bytes: ByteArray): GoproHeartbeat {
      val decoder = MavDataDecoder.wrap(bytes)

      val status = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GoproHeartbeatStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val captureMode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = GoproCaptureMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
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
