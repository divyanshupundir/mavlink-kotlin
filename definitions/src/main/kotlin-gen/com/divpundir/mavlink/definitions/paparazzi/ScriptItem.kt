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
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seq)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(name, 50)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt16(seq)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(name, 50)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ScriptItem> {
    private const val SIZE_V1: Int = 54

    private const val SIZE_V2: Int = 54

    public override val id: UInt = 180u

    public override val crcExtra: Byte = -25

    public override fun deserialize(source: BufferedSource): ScriptItem {
      val seq = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val name = source.decodeString(50)

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
