package com.divpundir.mavlink.definitions.matrixpilot

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
 * Acknowldge success or failure of a flexifunction command
 */
@GeneratedMavMessage(
  id = 157u,
  crcExtra = -123,
)
public data class FlexifunctionCommand(
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
  /**
   * Flexifunction command type
   */
  @GeneratedMavField(type = "uint8_t")
  public val commandType: UByte = 0u,
) : MavMessage<FlexifunctionCommand> {
  public override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionCommand> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(commandType)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(commandType)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionCommand> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 157u

    public override val crcExtra: Byte = -123

    public override fun deserialize(bytes: ByteArray): FlexifunctionCommand {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val commandType = decoder.safeDecodeUInt8()

      return FlexifunctionCommand(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        commandType = commandType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionCommand =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var commandType: UByte = 0u

    public fun build(): FlexifunctionCommand = FlexifunctionCommand(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      commandType = commandType,
    )
  }
}
