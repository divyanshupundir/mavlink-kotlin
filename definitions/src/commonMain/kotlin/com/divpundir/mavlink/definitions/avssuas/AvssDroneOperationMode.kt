package com.divpundir.mavlink.definitions.avssuas

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
  public override val instanceCompanion: MavMessage.MavCompanion<AvssDroneOperationMode> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt8(m300OperationMode)
    encoder.encodeUInt8(horseflyOperationMode)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt8(m300OperationMode)
    encoder.encodeUInt8(horseflyOperationMode)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssDroneOperationMode> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 60_053u

    public override val crcExtra: Byte = 45

    public override fun deserialize(bytes: ByteArray): AvssDroneOperationMode {
      val decoder = MavDataDecoder(bytes)

      val timeBootMs = decoder.safeDecodeUInt32()
      val m300OperationMode = decoder.safeDecodeUInt8()
      val horseflyOperationMode = decoder.safeDecodeUInt8()

      return AvssDroneOperationMode(
        timeBootMs = timeBootMs,
        m300OperationMode = m300OperationMode,
        horseflyOperationMode = horseflyOperationMode,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AvssDroneOperationMode =
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
