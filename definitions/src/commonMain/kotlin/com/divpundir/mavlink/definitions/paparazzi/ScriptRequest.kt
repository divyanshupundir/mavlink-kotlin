package com.divpundir.mavlink.definitions.paparazzi

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Request script item with the sequence number seq. The response of the system to this message
 * should be a SCRIPT_ITEM message.
 *
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
  override val instanceCompanion: MavMessage.MavCompanion<ScriptRequest> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ScriptRequest> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    override val id: UInt = 181u

    override val crcExtra: Byte = -127

    override fun deserialize(bytes: ByteArray): ScriptRequest {
      val decoder = MavDataDecoder(bytes)

      val seq = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

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
