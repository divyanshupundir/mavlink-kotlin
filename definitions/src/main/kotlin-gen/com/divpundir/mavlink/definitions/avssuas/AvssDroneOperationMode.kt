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
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeUInt8(m300OperationMode)
    buffer.encodeUInt8(horseflyOperationMode)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeUInt8(m300OperationMode)
    buffer.encodeUInt8(horseflyOperationMode)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AvssDroneOperationMode> {
    public override val id: UInt = 60_053u

    public override val crcExtra: Byte = 45

    public override fun deserialize(bytes: ByteArray): AvssDroneOperationMode {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val m300OperationMode = buffer.decodeUInt8()
      val horseflyOperationMode = buffer.decodeUInt8()

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
