package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Emit the value of a onboard parameter. The inclusion of param_count and param_index in the
 * message allows the recipient to keep track of received parameters and allows him to re-request
 * missing parameters after a loss or timeout. The parameter microservice is documented at
 * https://mavlink.io/en/services/parameter.html
 *
 * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16
 * human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars -
 * applications have to provide 16+1 bytes storage if the ID is stored as string
 * @param paramValue Onboard parameter value
 * @param paramType Onboard parameter type.
 * @param paramCount Total number of onboard parameters
 * @param paramIndex Index of this onboard parameter
 */
@GeneratedMavMessage(
  id = 22u,
  crcExtra = -36,
)
public data class ParamValue(
  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to
   * provide 16+1 bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Onboard parameter value
   */
  @GeneratedMavField(type = "float")
  public val paramValue: Float = 0F,
  /**
   * Onboard parameter type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val paramType: MavEnumValue<MavParamType> = MavEnumValue.fromValue(0u),
  /**
   * Total number of onboard parameters
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramCount: UShort = 0u,
  /**
   * Index of this onboard parameter
   */
  @GeneratedMavField(type = "uint16_t")
  public val paramIndex: UShort = 0u,
) : MavMessage<ParamValue> {
  override val instanceCompanion: MavMessage.MavCompanion<ParamValue> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(paramValue)
    encoder.encodeUInt16(paramCount)
    encoder.encodeUInt16(paramIndex)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(paramValue)
    encoder.encodeUInt16(paramCount)
    encoder.encodeUInt16(paramIndex)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamValue> {
    private const val SIZE_V1: Int = 25

    private const val SIZE_V2: Int = 25

    override val id: UInt = 22u

    override val crcExtra: Byte = -36

    override fun deserialize(bytes: ByteArray): ParamValue {
      val decoder = MavDataDecoder(bytes)

      val paramValue = decoder.safeDecodeFloat()
      val paramCount = decoder.safeDecodeUInt16()
      val paramIndex = decoder.safeDecodeUInt16()
      val paramId = decoder.safeDecodeString(16)
      val paramType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavParamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ParamValue(
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
        paramCount = paramCount,
        paramIndex = paramIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamValue =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var paramId: String = ""

    public var paramValue: Float = 0F

    public var paramType: MavEnumValue<MavParamType> = MavEnumValue.fromValue(0u)

    public var paramCount: UShort = 0u

    public var paramIndex: UShort = 0u

    public fun build(): ParamValue = ParamValue(
      paramId = paramId,
      paramValue = paramValue,
      paramType = paramType,
      paramCount = paramCount,
      paramIndex = paramIndex,
    )
  }
}
