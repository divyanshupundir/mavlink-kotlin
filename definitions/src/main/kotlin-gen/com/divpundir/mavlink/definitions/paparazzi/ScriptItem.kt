package com.divpundir.mavlink.definitions.paparazzi

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer

/**
 * Message encoding a mission script item. This message is emitted upon a request for the next
 * script item.
 */
@GeneratedMavMessage(
  id = 180u,
  crcExtra = -25,
)
public data class ScriptItem(
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
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
  /**
   * The name of the mission script, NULL terminated.
   */
  @GeneratedMavField(type = "char[50]")
  public val name: String = "",
) : MavMessage<ScriptItem> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScriptItem> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(seq)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeString(name, 50)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(seq)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeString(name, 50)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScriptItem> {
    public override val id: UInt = 180u

    public override val crcExtra: Byte = -25

    public override fun deserialize(bytes: ByteArray): ScriptItem {
      val buffer = Buffer().write(bytes)

      val seq = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val name = buffer.decodeString(50)

      return ScriptItem(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
        name = name,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScriptItem =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seq: UShort = 0u

    public var name: String = ""

    public fun build(): ScriptItem = ScriptItem(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
      name = name,
    )
  }
}
