package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Read configured OSD parameter reply.
 *
 * @param requestId Request ID - copied from request.
 * @param result Config error type.
 * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16
 * human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars -
 * applications have to provide 16+1 bytes storage if the ID is stored as string
 * @param configType Config type.
 * @param minValue OSD parameter minimum value.
 * @param maxValue OSD parameter maximum value.
 * @param increment OSD parameter increment.
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
  override val instanceCompanion: MavMessage.MavCompanion<OsdParamShowConfigReply> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(requestId)
    encoder.encodeFloat(minValue)
    encoder.encodeFloat(maxValue)
    encoder.encodeFloat(increment)
    encoder.encodeEnumValue(result.value, 1)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(configType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(requestId)
    encoder.encodeFloat(minValue)
    encoder.encodeFloat(maxValue)
    encoder.encodeFloat(increment)
    encoder.encodeEnumValue(result.value, 1)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(configType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OsdParamShowConfigReply> {
    private const val SIZE_V1: Int = 34

    private const val SIZE_V2: Int = 34

    override val id: UInt = 11_036u

    override val crcExtra: Byte = -79

    override fun deserialize(bytes: ByteArray): OsdParamShowConfigReply {
      val decoder = MavDataDecoder(bytes)

      val requestId = decoder.safeDecodeUInt32()
      val minValue = decoder.safeDecodeFloat()
      val maxValue = decoder.safeDecodeFloat()
      val increment = decoder.safeDecodeFloat()
      val result = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = OsdParamConfigError.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val paramId = decoder.safeDecodeString(16)
      val configType = decoder.safeDecodeEnumValue(1).let { value ->
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
