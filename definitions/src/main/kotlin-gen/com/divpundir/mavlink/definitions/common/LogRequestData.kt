package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Request a chunk of a log
 */
@GeneratedMavMessage(
  id = 119u,
  crcExtra = 116,
)
public data class LogRequestData(
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
   * Log id (from LOG_ENTRY reply)
   */
  @GeneratedMavField(type = "uint16_t")
  public val id: UShort = 0u,
  /**
   * Offset into the log
   */
  @GeneratedMavField(type = "uint32_t")
  public val ofs: UInt = 0u,
  /**
   * Number of bytes
   */
  @GeneratedMavField(type = "uint32_t")
  public val count: UInt = 0u,
) : MavMessage<LogRequestData> {
  public override val instanceCompanion: MavMessage.MavCompanion<LogRequestData> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(ofs)
    output.encodeUInt32(count)
    output.encodeUInt16(id)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(ofs)
    output.encodeUInt32(count)
    output.encodeUInt16(id)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LogRequestData> {
    private const val SIZE_V1: Int = 12

    private const val SIZE_V2: Int = 12

    public override val id: UInt = 119u

    public override val crcExtra: Byte = 116

    public override fun deserialize(source: BufferedSource): LogRequestData {
      val ofs = source.decodeUInt32()
      val count = source.decodeUInt32()
      val id = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return LogRequestData(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        id = id,
        ofs = ofs,
        count = count,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogRequestData =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var id: UShort = 0u

    public var ofs: UInt = 0u

    public var count: UInt = 0u

    public fun build(): LogRequestData = LogRequestData(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      id = id,
      ofs = ofs,
      count = count,
    )
  }
}
