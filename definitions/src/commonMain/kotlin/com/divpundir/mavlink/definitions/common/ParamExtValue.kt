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
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Emit the value of a parameter. The inclusion of param_count and param_index in the message allows
 * the recipient to keep track of received parameters and allows them to re-request missing parameters
 * after a loss or timeout.
 *
 * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable
 * chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have
 * to provide 16+1 bytes storage if the ID is stored as string
 * @param paramValue Parameter value
 * @param paramType Parameter type.
 * @param paramCount Total number of parameters
 * @param paramIndex Index of this parameter
 */
@GeneratedMavMessage(
  id = 322u,
  crcExtra = -13,
)
public data class ParamExtValue(
  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1
   * bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Parameter value
   */
  @GeneratedMavField(type = "char[128]")
  public val paramValue: String = "",
  /**
   * Parameter type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val paramType: MavEnumValue<MavParamExtType> = MavEnumValue.fromValue(0u),
  /**
   * Total number of parameters
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramCount: UShort = 0u,
  /**
   * Index of this parameter
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramIndex: UShort = 0u,
) : MavMessage<ParamExtValue> {
  override val instanceCompanion: MavMessage.MavCompanion<ParamExtValue> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(paramCount)
    encoder.encodeUInt16(paramIndex)
    encoder.encodeString(paramId, 16)
    encoder.encodeString(paramValue, 128)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(paramCount)
    encoder.encodeUInt16(paramIndex)
    encoder.encodeString(paramId, 16)
    encoder.encodeString(paramValue, 128)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamExtValue> {
    private const val SIZE_V1: Int = 149

    private const val SIZE_V2: Int = 149

    override val id: UInt = 322u

    override val crcExtra: Byte = -13

    override fun deserialize(bytes: ByteArray): ParamExtValue {
      val decoder = MavDataDecoder(bytes)

      val paramCount = decoder.safeDecodeUInt16()
      val paramIndex = decoder.safeDecodeUInt16()
      val paramId = decoder.safeDecodeString(16)
      val paramValue = decoder.safeDecodeString(128)
      val paramType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavParamExtType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ParamExtValue(
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
        paramCount = paramCount,
        paramIndex = paramIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamExtValue =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var paramId: String = ""

    public var paramValue: String = ""

    public var paramType: MavEnumValue<MavParamExtType> = MavEnumValue.fromValue(0u)

    public var paramCount: UShort = 0u

    public var paramIndex: UShort = 0u

    public fun build(): ParamExtValue = ParamExtValue(
      paramId = paramId,
      paramValue = paramValue,
      paramType = paramType,
      paramCount = paramCount,
      paramIndex = paramIndex,
    )
  }
}
