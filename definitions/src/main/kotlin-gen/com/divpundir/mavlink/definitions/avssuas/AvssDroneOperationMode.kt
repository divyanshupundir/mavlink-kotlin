package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
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
 *  Drone operation mode.
 */
@GeneratedMavMessage(
  id = 60_053u,
  crcExtra = 45,
)
public data class AvssDroneOperationMode(
  /**
   * Timestamp (time since FC boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * DJI M300 operation mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val m300OperationMode: UByte = 0u,
  /**
   * horsefly operation mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val horseflyOperationMode: UByte = 0u,
) : MavMessage<AvssDroneOperationMode> {
  public override val instanceMetadata: MavMessage.Metadata<AvssDroneOperationMode> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt8(m300OperationMode)
    outputBuffer.encodeUInt8(horseflyOperationMode)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeUInt8(m300OperationMode)
    outputBuffer.encodeUInt8(horseflyOperationMode)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 60_053u

    private const val CRC_EXTRA: Byte = 45

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    private val DESERIALIZER: MavDeserializer<AvssDroneOperationMode> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val m300OperationMode = inputBuffer.decodeUInt8()
      val horseflyOperationMode = inputBuffer.decodeUInt8()

      AvssDroneOperationMode(
        timeBootMs = timeBootMs,
        m300OperationMode = m300OperationMode,
        horseflyOperationMode = horseflyOperationMode,
      )
    }


    private val METADATA: MavMessage.Metadata<AvssDroneOperationMode> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<AvssDroneOperationMode> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): AvssDroneOperationMode =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var m300OperationMode: UByte = 0u

    public var horseflyOperationMode: UByte = 0u

    public fun build(): AvssDroneOperationMode = AvssDroneOperationMode(
      timeBootMs = timeBootMs,
      m300OperationMode = m300OperationMode,
      horseflyOperationMode = horseflyOperationMode,
    )
  }
}
