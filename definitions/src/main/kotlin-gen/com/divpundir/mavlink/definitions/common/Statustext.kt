package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
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
 * Status text message. These messages are printed in yellow in the COMM console of QGroundControl.
 * WARNING: They consume quite some bandwidth, so use only for important status and error messages. If
 * implemented wisely, these messages are buffered on the MCU and sent only at a limited rate (e.g. 10
 * Hz).
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
  public override val instanceCompanion: MavMessage.MavCompanion<Statustext> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(severity.value, 1)
    output.encodeString(text, 50)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeEnumValue(severity.value, 1)
    output.encodeString(text, 50)
    output.encodeUInt16(id)
    output.encodeUInt8(chunkSeq)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<Statustext> {
    private const val SIZE_V1: Int = 51

    private const val SIZE_V2: Int = 54

    public override val id: UInt = 253u

    public override val crcExtra: Byte = 83

    public override fun deserialize(source: BufferedSource): Statustext {
      val severity = source.decodeEnumValue(1).let { value ->
        val entry = MavSeverity.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val text = source.decodeString(50)
      val id = source.decodeUInt16()
      val chunkSeq = source.decodeUInt8()

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
