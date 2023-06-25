package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<LogRequestEnd> {
    public override val id: UInt = 122u

    public override val crcExtra: Byte = -53

    public override fun deserialize(bytes: ByteArray): LogRequestEnd {
      val buffer = Buffer().write(bytes)

      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

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
