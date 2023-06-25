package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Response from a PARAM_EXT_SET message.
 */
@GeneratedMavMessage(
  id = 324u,
  crcExtra = -124,
)
public data class ParamExtAck(
  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1
   * bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)
   */
  @GeneratedMavField(type = "char[128]")
  public val paramValue: String = "",
  /**
   * Parameter type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val paramType: MavEnumValue<MavParamExtType> = MavEnumValue.fromValue(0u),
  /**
   * Result code.
   */
  @GeneratedMavField(type = "uint8_t")
  public val paramResult: MavEnumValue<ParamAck> = MavEnumValue.fromValue(0u),
) : MavMessage<ParamExtAck> {
  public override val instanceCompanion: MavMessage.MavCompanion<ParamExtAck> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeString(paramId, 16)
    buffer.encodeString(paramValue, 128)
    buffer.encodeEnumValue(paramType.value, 1)
    buffer.encodeEnumValue(paramResult.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeString(paramId, 16)
    buffer.encodeString(paramValue, 128)
    buffer.encodeEnumValue(paramType.value, 1)
    buffer.encodeEnumValue(paramResult.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamExtAck> {
    public override val id: UInt = 324u

    public override val crcExtra: Byte = -124

    public override fun deserialize(bytes: ByteArray): ParamExtAck {
      val buffer = Buffer().write(bytes)

      val paramId = buffer.decodeString(16)
      val paramValue = buffer.decodeString(128)
      val paramType = buffer.decodeEnumValue(1).let { value ->
        val entry = MavParamExtType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val paramResult = buffer.decodeEnumValue(1).let { value ->
        val entry = ParamAck.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ParamExtAck(
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
        paramResult = paramResult,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamExtAck =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var paramId: String = ""

    public var paramValue: String = ""

    public var paramType: MavEnumValue<MavParamExtType> = MavEnumValue.fromValue(0u)

    public var paramResult: MavEnumValue<ParamAck> = MavEnumValue.fromValue(0u)

    public fun build(): ParamExtAck = ParamExtAck(
      paramId = paramId,
      paramValue = paramValue,
      paramType = paramType,
      paramResult = paramResult,
    )
  }
}
