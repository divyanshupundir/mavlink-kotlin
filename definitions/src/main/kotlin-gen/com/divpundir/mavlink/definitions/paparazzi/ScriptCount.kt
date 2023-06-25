package com.divpundir.mavlink.definitions.paparazzi

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * This message is emitted as response to SCRIPT_REQUEST_LIST by the MAV to get the number of
 * mission scripts.
 */
@GeneratedMavMessage(
  id = 183u,
  crcExtra = -70,
)
public data class ScriptCount(
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
   * Number of script items in the sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val count: UShort = 0u,
) : MavMessage<ScriptCount> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScriptCount> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(count)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(count)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScriptCount> {
    public override val id: UInt = 183u

    public override val crcExtra: Byte = -70

    public override fun deserialize(bytes: ByteArray): ScriptCount {
      val buffer = Buffer().write(bytes)

      val count = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return ScriptCount(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        count = count,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScriptCount =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var count: UShort = 0u

    public fun build(): ScriptCount = ScriptCount(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      count = count,
    )
  }
}
