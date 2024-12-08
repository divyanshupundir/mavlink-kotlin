package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MavResult
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Reply from secure command.
 *
 * @param sequence Sequence ID from request.
 * @param operation Operation that was requested.
 * @param result Result of command.
 * @param dataLength Data length.
 * @param data Reply data.
 */
@GeneratedMavMessage(
  id = 11_005u,
  crcExtra = 93,
)
public data class SecureCommandReply(
  /**
   * Sequence ID from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val sequence: UInt = 0u,
  /**
   * Operation that was requested.
   */
  @GeneratedMavField(type = "uint32_t")
  public val operation: MavEnumValue<SecureCommandOp> = MavEnumValue.fromValue(0u),
  /**
   * Result of command.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: MavEnumValue<MavResult> = MavEnumValue.fromValue(0u),
  /**
   * Data length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val dataLength: UByte = 0u,
  /**
   * Reply data.
   */
  @GeneratedMavField(type = "uint8_t[220]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<SecureCommandReply> {
  override val instanceCompanion: MavMessage.MavCompanion<SecureCommandReply> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(sequence)
    encoder.encodeEnumValue(operation.value, 4)
    encoder.encodeEnumValue(result.value, 1)
    encoder.encodeUInt8(dataLength)
    encoder.encodeUInt8Array(data, 220)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(sequence)
    encoder.encodeEnumValue(operation.value, 4)
    encoder.encodeEnumValue(result.value, 1)
    encoder.encodeUInt8(dataLength)
    encoder.encodeUInt8Array(data, 220)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SecureCommandReply> {
    private const val SIZE_V1: Int = 230

    private const val SIZE_V2: Int = 230

    override val id: UInt = 11_005u

    override val crcExtra: Byte = 93

    override fun deserialize(bytes: ByteArray): SecureCommandReply {
      val decoder = MavDataDecoder(bytes)

      val sequence = decoder.safeDecodeUInt32()
      val operation = decoder.safeDecodeEnumValue(4).let { value ->
        val entry = SecureCommandOp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val result = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavResult.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val dataLength = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(220)

      return SecureCommandReply(
        sequence = sequence,
        operation = operation,
        result = result,
        dataLength = dataLength,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SecureCommandReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sequence: UInt = 0u

    public var operation: MavEnumValue<SecureCommandOp> = MavEnumValue.fromValue(0u)

    public var result: MavEnumValue<MavResult> = MavEnumValue.fromValue(0u)

    public var dataLength: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): SecureCommandReply = SecureCommandReply(
      sequence = sequence,
      operation = operation,
      result = result,
      dataLength = dataLength,
      data = data,
    )
  }
}
