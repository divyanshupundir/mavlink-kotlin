package com.divpundir.mavlink.definitions.ardupilotmega

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
 * Request a current fence point from MAV.
 */
@GeneratedMavMessage(
  id = 161u,
  crcExtra = 68,
)
public data class FenceFetchPoint(
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
   * Point index (first point is 1, 0 is for return point).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: UByte = 0u,
) : MavMessage<FenceFetchPoint> {
  public override val instanceMetadata: MavMessage.Metadata<FenceFetchPoint> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(idx)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(idx)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 161u

    private const val CRC_EXTRA: Byte = 68

    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    private val DESERIALIZER: MavDeserializer<FenceFetchPoint> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val idx = inputBuffer.decodeUInt8()

      FenceFetchPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
      )
    }


    private val METADATA: MavMessage.Metadata<FenceFetchPoint> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FenceFetchPoint> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): FenceFetchPoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idx: UByte = 0u

    public fun build(): FenceFetchPoint = FenceFetchPoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
    )
  }
}
