package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Depreciated but used as a compiler flag.  Do not remove
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
  public override val instanceMetadata: MavMessage.Metadata<FlexifunctionSet> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 150u

    private const val CRC_EXTRA: Byte = -75

    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    private val DESERIALIZER: MavDeserializer<FlexifunctionSet> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      FlexifunctionSet(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }


    private val METADATA: MavMessage.Metadata<FlexifunctionSet> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FlexifunctionSet> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FlexifunctionSet =
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
