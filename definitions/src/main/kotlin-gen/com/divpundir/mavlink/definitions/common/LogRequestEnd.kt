package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
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
 * Stop log transfer and resume normal logging
 */
@GeneratedMavMessage(
  id = 122u,
  crcExtra = -53,
)
public data class LogRequestEnd(
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
) : MavMessage<LogRequestEnd> {
  public override val instanceCompanion: MavMessage.MavCompanion<LogRequestEnd> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<LogRequestEnd> {
    private const val SIZE_V1: Int = 2

    private const val SIZE_V2: Int = 2

    public override val id: UInt = 122u

    public override val crcExtra: Byte = -53

    public override fun deserialize(source: BufferedSource): LogRequestEnd {
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return LogRequestEnd(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): LogRequestEnd =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): LogRequestEnd = LogRequestEnd(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
