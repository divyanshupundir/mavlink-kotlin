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
 * Request script item with the sequence number seq. The response of the system to this message
 * should be a SCRIPT_ITEM message.
 */
@GeneratedMavMessage(
  id = 181u,
  crcExtra = -127,
)
public data class ScriptRequest(
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
) : MavMessage<ScriptRequest> {
  public override val instanceCompanion: MavMessage.MavCompanion<ScriptRequest> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(seq)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16(seq)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScriptRequest> {
    public override val id: UInt = 181u

    public override val crcExtra: Byte = -127

    public override fun deserialize(bytes: ByteArray): ScriptRequest {
      val buffer = Buffer().write(bytes)

      val seq = buffer.decodeUInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()

      return ScriptRequest(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ScriptRequest =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seq: UShort = 0u

    public fun build(): ScriptRequest = ScriptRequest(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
    )
  }
}
