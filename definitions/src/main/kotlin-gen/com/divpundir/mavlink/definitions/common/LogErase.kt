package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Erase all logs
 */
@GeneratedMavMessage(
  id = 121u,
  crcExtra = -19,
)
public data class LogErase(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
) : MavMessage<LogErase> {
  public override val instanceCompanion: MavMessage.MavCompanion<LogErase> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogErase> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    public override val id: UInt = 121u

    public override val crcExtra: Byte = -19

    public override fun deserialize(bytes: ByteArray): LogErase {
      val decoder = MavDataDecoder.wrap(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return LogErase(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogErase =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): LogErase = LogErase(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
