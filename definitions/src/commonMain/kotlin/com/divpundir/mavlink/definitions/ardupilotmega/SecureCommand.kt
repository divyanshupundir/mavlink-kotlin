package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
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
 * Send a secure command. Data should be signed with a private key corresponding with a public key
 * known to the recipient. Signature should be over the concatenation of the sequence number
 * (little-endian format), the operation (little-endian format) the data and the session key. For
 * SECURE_COMMAND_GET_SESSION_KEY the session key should be zero length. The data array consists of the
 * data followed by the signature. The sum of the data_length and the sig_length cannot be more than
 * 220. The format of the data is command specific.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param sequence Sequence ID for tagging reply.
 * @param operation Operation being requested.
 * @param dataLength Data length.
 * @param sigLength Signature length.
 * @param data Signed data.
 */
@GeneratedMavMessage(
  id = 11_004u,
  crcExtra = 11,
)
public data class SecureCommand(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Sequence ID for tagging reply.
   */
  @GeneratedMavField(type = "uint32_t")
  public val sequence: UInt = 0u,
  /**
   * Operation being requested.
   */
  @GeneratedMavField(type = "uint32_t")
  public val operation: MavEnumValue<SecureCommandOp> = MavEnumValue.fromValue(0u),
  /**
   * Data length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val dataLength: UByte = 0u,
  /**
   * Signature length.
   */
  @GeneratedMavField(type = "uint8_t")
  public val sigLength: UByte = 0u,
  /**
   * Signed data.
   */
  @GeneratedMavField(type = "uint8_t[220]")
  public val `data`: List<UByte> = emptyList(),
) : MavMessage<SecureCommand> {
  override val instanceCompanion: MavMessage.MavCompanion<SecureCommand> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(sequence)
    encoder.encodeEnumValue(operation.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(dataLength)
    encoder.encodeUInt8(sigLength)
    encoder.encodeUInt8Array(data, 220)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(sequence)
    encoder.encodeEnumValue(operation.value, 4)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(dataLength)
    encoder.encodeUInt8(sigLength)
    encoder.encodeUInt8Array(data, 220)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SecureCommand> {
    private const val SIZE_V1: Int = 232

    private const val SIZE_V2: Int = 232

    override val id: UInt = 11_004u

    override val crcExtra: Byte = 11

    override fun deserialize(bytes: ByteArray): SecureCommand {
      val decoder = MavDataDecoder(bytes)

      val sequence = decoder.safeDecodeUInt32()
      val operation = decoder.safeDecodeEnumValue(4).let { value ->
        val entry = SecureCommandOp.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val dataLength = decoder.safeDecodeUInt8()
      val sigLength = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(220)

      return SecureCommand(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        sequence = sequence,
        operation = operation,
        dataLength = dataLength,
        sigLength = sigLength,
        data = data,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SecureCommand =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var sequence: UInt = 0u

    public var operation: MavEnumValue<SecureCommandOp> = MavEnumValue.fromValue(0u)

    public var dataLength: UByte = 0u

    public var sigLength: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public fun build(): SecureCommand = SecureCommand(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      sequence = sequence,
      operation = operation,
      dataLength = dataLength,
      sigLength = sigLength,
      data = data,
    )
  }
}
