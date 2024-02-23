package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Status text message. These messages are printed in yellow in the COMM console of QGroundControl.
 * WARNING: They consume quite some bandwidth, so use only for important status and error messages. If
 * implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10
 * Hz).
 *
 * @param severity Severity of status. Relies on the definitions within RFC-5424.
 * @param text Status text message, without null termination character
 * @param id Unique (opaque) identifier for this statustext message.  May be used to reassemble a
 * logical long-statustext message from a sequence of chunks.  A value of zero indicates this is the
 * only chunk in the sequence and the message can be emitted immediately.
 * @param chunkSeq This chunk's sequence number; indexing is from zero.  Any null character in the
 * text field is taken to mean this was the last chunk.
 */
@GeneratedMavMessage(
  id = 253u,
  crcExtra = 83,
)
public data class Statustext(
  /**
   * Severity of status. Relies on the definitions within RFC-5424.
   */
  @GeneratedMavField(type = "uint8_t")
  public val severity: MavEnumValue<MavSeverity> = MavEnumValue.fromValue(0u),
  /**
   * Status text message, without null termination character
   */
  @GeneratedMavField(type = "char[50]")
  public val text: String = "",
  /**
   * Unique (opaque) identifier for this statustext message.  May be used to reassemble a logical
   * long-statustext message from a sequence of chunks.  A value of zero indicates this is the only
   * chunk in the sequence and the message can be emitted immediately.
   */
  @GeneratedMavField(
    type = "uint16_t",
    extension = true,
  )
  public val id: UShort = 0u,
  /**
   * This chunk's sequence number; indexing is from zero.  Any null character in the text field is
   * taken to mean this was the last chunk.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val chunkSeq: UByte = 0u,
) : MavMessage<Statustext> {
  override val instanceCompanion: MavMessage.MavCompanion<Statustext> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(severity.value, 1)
    encoder.encodeString(text, 50)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(severity.value, 1)
    encoder.encodeString(text, 50)
    encoder.encodeUInt16(id)
    encoder.encodeUInt8(chunkSeq)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Statustext> {
    private const val SIZE_V1: Int = 51

    private const val SIZE_V2: Int = 54

    override val id: UInt = 253u

    override val crcExtra: Byte = 83

    override fun deserialize(bytes: ByteArray): Statustext {
      val decoder = MavDataDecoder(bytes)

      val severity = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavSeverity.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val text = decoder.safeDecodeString(50)
      val id = decoder.safeDecodeUInt16()
      val chunkSeq = decoder.safeDecodeUInt8()

      return Statustext(
        severity = severity,
        text = text,
        id = id,
        chunkSeq = chunkSeq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Statustext =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var severity: MavEnumValue<MavSeverity> = MavEnumValue.fromValue(0u)

    public var text: String = ""

    public var id: UShort = 0u

    public var chunkSeq: UByte = 0u

    public fun build(): Statustext = Statustext(
      severity = severity,
      text = text,
      id = id,
      chunkSeq = chunkSeq,
    )
  }
}
