package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Set a parameter value. In order to deal with message loss (and retransmission of PARAM_EXT_SET),
 * when setting a parameter value and the new value is the same as the current value, you will
 * immediately get a PARAM_ACK_ACCEPTED response. If the current state is PARAM_ACK_IN_PROGRESS, you
 * will accordingly receive a PARAM_ACK_IN_PROGRESS in response.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable
 * chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have
 * to provide 16+1 bytes storage if the ID is stored as string
 * @param paramValue Parameter value
 * @param paramType Parameter type.
 */
@GeneratedMavMessage(
  id = 323u,
  crcExtra = 78,
)
public data class ParamExtSet(
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
) : MavMessage<ParamExtSet> {
  override val instanceCompanion: MavMessage.MavCompanion<ParamExtSet> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    encoder.encodeString(paramValue, 128)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    encoder.encodeString(paramValue, 128)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamExtSet> {
    private const val SIZE_V1: Int = 147

    private const val SIZE_V2: Int = 147

    override val id: UInt = 323u

    override val crcExtra: Byte = 78

    override fun deserialize(bytes: ByteArray): ParamExtSet {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val paramId = decoder.safeDecodeString(16)
      val paramValue = decoder.safeDecodeString(128)
      val paramType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavParamExtType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ParamExtSet(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamExtSet =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var paramId: String = ""

    public var paramValue: String = ""

    public var paramType: MavEnumValue<MavParamExtType> = MavEnumValue.fromValue(0u)

    public fun build(): ParamExtSet = ParamExtSet(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      paramId = paramId,
      paramValue = paramValue,
      paramType = paramType,
    )
  }
}
