package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<Statustext> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(severity.value, 1)
    outputBuffer.encodeString(text, 50)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(severity.value, 1)
    outputBuffer.encodeString(text, 50)
    outputBuffer.encodeUInt16(id)
    outputBuffer.encodeUInt8(chunkSeq)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 253u

    private const val CRC_EXTRA: Byte = 83

    private const val SIZE_V1: Int = 51

    private const val SIZE_V2: Int = 54

    private val DESERIALIZER: MavDeserializer<Statustext> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val severity = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavSeverity.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val text = inputBuffer.decodeString(50)
      val id = inputBuffer.decodeUInt16()
      val chunkSeq = inputBuffer.decodeUInt8()

      Statustext(
        severity = severity,
        text = text,
        id = id,
        chunkSeq = chunkSeq,
      )
    }


    private val METADATA: MavMessage.Metadata<Statustext> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Statustext> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Statustext =
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
