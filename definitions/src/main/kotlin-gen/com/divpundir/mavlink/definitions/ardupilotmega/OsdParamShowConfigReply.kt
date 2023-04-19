package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Read configured OSD parameter reply.
 */
@GeneratedMavMessage(
  id = 11036u,
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
  public override val instanceMetadata: MavMessage.Metadata<OsdParamShowConfigReply> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeFloat(minValue)
    outputBuffer.encodeFloat(maxValue)
    outputBuffer.encodeFloat(increment)
    outputBuffer.encodeEnumValue(result.value, 1)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeEnumValue(configType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeFloat(minValue)
    outputBuffer.encodeFloat(maxValue)
    outputBuffer.encodeFloat(increment)
    outputBuffer.encodeEnumValue(result.value, 1)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeEnumValue(configType.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11036u

    private const val CRC_EXTRA: Byte = -79

    private const val SIZE_V1: Int = 34

    private const val SIZE_V2: Int = 34

    private val DESERIALIZER: MavDeserializer<OsdParamShowConfigReply> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUInt32()
      val minValue = inputBuffer.decodeFloat()
      val maxValue = inputBuffer.decodeFloat()
      val increment = inputBuffer.decodeFloat()
      val result = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = OsdParamConfigError.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val paramId = inputBuffer.decodeString(16)
      val configType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = OsdParamConfigType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      OsdParamShowConfigReply(
        requestId = requestId,
        result = result,
        paramId = paramId,
        configType = configType,
        minValue = minValue,
        maxValue = maxValue,
        increment = increment,
      )
    }


    private val METADATA: MavMessage.Metadata<OsdParamShowConfigReply> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OsdParamShowConfigReply> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): OsdParamShowConfigReply =
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
