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
 * Start firmware update with encapsulated data.
 */
@GeneratedMavMessage(
  id = 50_004u,
  crcExtra = -16,
)
public data class CubepilotFirmwareUpdateStart(
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
   * FW Size.
   */
  @GeneratedMavField(type = "uint32_t")
  public val size: UInt = 0u,
  /**
   * FW CRC.
   */
  @GeneratedMavField(type = "uint32_t")
  public val crc: UInt = 0u,
) : MavMessage<CubepilotFirmwareUpdateStart> {
  public override val instanceCompanion: MavMessage.MavCompanion<CubepilotFirmwareUpdateStart> =
      Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt32(size)
    encoder.encodeUInt32(crc)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt32(size)
    encoder.encodeUInt32(crc)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CubepilotFirmwareUpdateStart> {
    private const val SIZE_V1: Int = 10

    private const val SIZE_V2: Int = 10

    public override val id: UInt = 50_004u

    public override val crcExtra: Byte = -16

    public override fun deserialize(bytes: ByteArray): CubepilotFirmwareUpdateStart {
      val decoder = MavDataDecoder.wrap(bytes)

      val size = decoder.safeDecodeUInt32()
      val crc = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return CubepilotFirmwareUpdateStart(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        size = size,
        crc = crc,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CubepilotFirmwareUpdateStart =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var size: UInt = 0u

    public var crc: UInt = 0u

    public fun build(): CubepilotFirmwareUpdateStart = CubepilotFirmwareUpdateStart(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      size = size,
      crc = crc,
    )
  }
}
