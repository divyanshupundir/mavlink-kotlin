package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.String
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Read configured OSD parameter reply.
 */
@GeneratedMavMessage(
  id = 11_036u,
  crcExtra = -79,
)
public data class OsdParamShowConfigReply(
  /**
   * Request ID - copied from request.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: UInt = 0u,
  /**
   * Config error type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0u),
  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to
   * provide 16+1 bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Config type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val configType: MavEnumValue<OsdParamConfigType> = MavEnumValue.fromValue(0u),
  /**
   * OSD parameter minimum value.
   */
  @GeneratedMavField(type = "float")
  public val minValue: Float = 0F,
  /**
   * OSD parameter maximum value.
   */
  @GeneratedMavField(type = "float")
  public val maxValue: Float = 0F,
  /**
   * OSD parameter increment.
   */
  @GeneratedMavField(type = "float")
  public val increment: Float = 0F,
) : MavMessage<OsdParamShowConfigReply> {
  public override val instanceCompanion: MavMessage.MavCompanion<OsdParamShowConfigReply> =
      Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeFloat(minValue)
    buffer.encodeFloat(maxValue)
    buffer.encodeFloat(increment)
    buffer.encodeEnumValue(result.value, 1)
    buffer.encodeString(paramId, 16)
    buffer.encodeEnumValue(configType.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeFloat(minValue)
    buffer.encodeFloat(maxValue)
    buffer.encodeFloat(increment)
    buffer.encodeEnumValue(result.value, 1)
    buffer.encodeString(paramId, 16)
    buffer.encodeEnumValue(configType.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OsdParamShowConfigReply> {
    public override val id: UInt = 11_036u

    public override val crcExtra: Byte = -79

    public override fun deserialize(bytes: ByteArray): OsdParamShowConfigReply {
      val buffer = Buffer().write(bytes)

      val requestId = buffer.decodeUInt32()
      val minValue = buffer.decodeFloat()
      val maxValue = buffer.decodeFloat()
      val increment = buffer.decodeFloat()
      val result = buffer.decodeEnumValue(1).let { value ->
        val entry = OsdParamConfigError.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val paramId = buffer.decodeString(16)
      val configType = buffer.decodeEnumValue(1).let { value ->
        val entry = OsdParamConfigType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return OsdParamShowConfigReply(
        requestId = requestId,
        result = result,
        paramId = paramId,
        configType = configType,
        minValue = minValue,
        maxValue = maxValue,
        increment = increment,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OsdParamShowConfigReply =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var requestId: UInt = 0u

    public var result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0u)

    public var paramId: String = ""

    public var configType: MavEnumValue<OsdParamConfigType> = MavEnumValue.fromValue(0u)

    public var minValue: Float = 0F

    public var maxValue: Float = 0F

    public var increment: Float = 0F

    public fun build(): OsdParamShowConfigReply = OsdParamShowConfigReply(
      requestId = requestId,
      result = result,
      paramId = paramId,
      configType = configType,
      minValue = minValue,
      maxValue = maxValue,
      increment = increment,
    )
  }
}
