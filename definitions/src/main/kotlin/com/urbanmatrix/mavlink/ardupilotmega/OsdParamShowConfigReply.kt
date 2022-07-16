package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint32
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String

/**
 * Read configured OSD parameter reply.
 */
public data class OsdParamShowConfigReply(
  /**
   * Request ID - copied from request.
   */
  public val requestId: Long = 0L,
  /**
   * Config error type.
   */
  public val result: MavEnumValue<OsdParamConfigError> = MavEnumValue.fromValue(0),
  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to
   * provide 16+1 bytes storage if the ID is stored as string
   */
  public val paramId: String = "",
  /**
   * Config type.
   */
  public val configType: MavEnumValue<OsdParamConfigType> = MavEnumValue.fromValue(0),
  /**
   * OSD parameter minimum value.
   */
  public val minValue: Float = 0F,
  /**
   * OSD parameter maximum value.
   */
  public val maxValue: Float = 0F,
  /**
   * OSD parameter increment.
   */
  public val increment: Float = 0F,
) : MavMessage<OsdParamShowConfigReply> {
  public override val instanceMetadata: MavMessage.Metadata<OsdParamShowConfigReply> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeFloat(minValue)
    outputBuffer.encodeFloat(maxValue)
    outputBuffer.encodeFloat(increment)
    outputBuffer.encodeEnumValue(result.value, 1)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeEnumValue(configType.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11036

    private const val CRC: Int = 73

    private const val SIZE: Int = 34

    private val DESERIALIZER: MavDeserializer<OsdParamShowConfigReply> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for OsdParamShowConfigReply: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
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
        CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<OsdParamShowConfigReply> = METADATA
  }
}
