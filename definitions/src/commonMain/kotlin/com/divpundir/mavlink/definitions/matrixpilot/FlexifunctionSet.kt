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
 * Depreciated but used as a compiler flag.  Do not remove
 *
 */
@GeneratedMavMessage(
  id = 150u,
  crcExtra = -75,
)
public data class FlexifunctionSet(
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
) : MavMessage<FlexifunctionSet> {
  override val instanceCompanion: MavMessage.MavCompanion<FlexifunctionSet> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FlexifunctionSet> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    override val id: UInt = 150u

    override val crcExtra: Byte = -75

    override fun deserialize(bytes: ByteArray): FlexifunctionSet {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return FlexifunctionSet(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FlexifunctionSet =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): FlexifunctionSet = FlexifunctionSet(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
