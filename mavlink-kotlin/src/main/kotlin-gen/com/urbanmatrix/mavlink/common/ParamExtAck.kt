package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeString
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Response from a PARAM_EXT_SET message.
 */
public data class ParamExtAck(
  /**
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1
   * bytes storage if the ID is stored as string
   */
  public val paramId: String = "",
  /**
   * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)
   */
  public val paramValue: String = "",
  /**
   * Parameter type.
   */
  public val paramType: MavEnumValue<MavParamExtType> = MavEnumValue.fromValue(0),
  /**
   * Result code.
   */
  public val paramResult: MavEnumValue<ParamAck> = MavEnumValue.fromValue(0),
) : MavMessage<ParamExtAck> {
  public override val instanceMetadata: MavMessage.Metadata<ParamExtAck> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(146).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeString(paramValue, 128)
    outputBuffer.encodeEnumValue(paramType.value, 1)
    outputBuffer.encodeEnumValue(paramResult.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 324

    private const val CRC: Int = 23

    private val DESERIALIZER: MavDeserializer<ParamExtAck> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val paramId = inputBuffer.decodeString(16)
      val paramValue = inputBuffer.decodeString(128)
      val paramType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavParamExtType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val paramResult = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = ParamAck.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      ParamExtAck(
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
        paramResult = paramResult,
      )
    }


    private val METADATA: MavMessage.Metadata<ParamExtAck> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ParamExtAck> = METADATA
  }
}
