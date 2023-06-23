package com.divpundir.mavlink.definitions.avssuas

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeUInt8(m300OperationMode)
    output.encodeUInt8(horseflyOperationMode)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(timeBootMs)
    output.encodeUInt8(m300OperationMode)
    output.encodeUInt8(horseflyOperationMode)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AvssDroneOperationMode> {
    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    public override val id: UInt = 60_053u

    public override val crcExtra: Byte = 45

    public override fun deserialize(source: BufferedSource): AvssDroneOperationMode {
      val timeBootMs = source.decodeUInt32()
      val m300OperationMode = source.decodeUInt8()
      val horseflyOperationMode = source.decodeUInt8()

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
