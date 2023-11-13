package com.divpundir.mavlink.definitions.cubepilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * offset response to encapsulated data.
 */
@GeneratedMavMessage(
  id = 50_005u,
  crcExtra = -104,
)
public data class CubepilotFirmwareUpdateResp(
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
   * FW Offset.
   */
  @GeneratedMavField(type = "uint32_t")
  public val offset: UInt = 0u,
) : MavMessage<CubepilotFirmwareUpdateResp> {
  public override val instanceCompanion: MavMessage.MavCompanion<CubepilotFirmwareUpdateResp> =
      Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(offset)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(offset)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CubepilotFirmwareUpdateResp> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 50_005u

    public override val crcExtra: Byte = -104

    public override fun deserialize(bytes: ByteArray): CubepilotFirmwareUpdateResp {
      val decoder = MavDataDecoder(bytes)

      val offset = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return CubepilotFirmwareUpdateResp(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        offset = offset,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CubepilotFirmwareUpdateResp =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var offset: UInt = 0u

    public fun build(): CubepilotFirmwareUpdateResp = CubepilotFirmwareUpdateResp(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      offset = offset,
    )
  }
}
