package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Request a GOPRO_COMMAND response from the GoPro.
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<GoproGetRequest> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(cmdId.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(cmdId.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<GoproGetRequest> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    override val id: UInt = 216u

    override val crcExtra: Byte = 50

    override fun deserialize(bytes: ByteArray): GoproGetRequest {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val cmdId = decoder.safeDecodeEnumValue(1).let { value ->
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
