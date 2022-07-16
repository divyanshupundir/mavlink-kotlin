package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt16
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt16
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String

/**
 * Bind a RC channel to a parameter. The parameter should change according to the RC channel value.
 */
public data class ParamMapRc(
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to
   * provide 16+1 bytes storage if the ID is stored as string
   */
  public val paramId: String = "",
  /**
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be
   * ignored), send -2 to disable any existing map for this rc_channel_index.
   */
  public val paramIndex: Int = 0,
  /**
   * Index of parameter RC channel. Not equal to the RC channel id. Typically corresponds to a
   * potentiometer-knob on the RC.
   */
  public val parameterRcChannelIndex: Int = 0,
  /**
   * Initial parameter value
   */
  public val paramValue0: Float = 0F,
  /**
   * Scale, maps the RC range [-1, 1] to a parameter value
   */
  public val scale: Float = 0F,
  /**
   * Minimum param value. The protocol does not define if this overwrites an onboard minimum value.
   * (Depends on implementation)
   */
  public val paramValueMin: Float = 0F,
  /**
   * Maximum param value. The protocol does not define if this overwrites an onboard maximum value.
   * (Depends on implementation)
   */
  public val paramValueMax: Float = 0F,
) : MavMessage<ParamMapRc> {
  public override val instanceMetadata: MavMessage.Metadata<ParamMapRc> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(paramValue0)
    outputBuffer.encodeFloat(scale)
    outputBuffer.encodeFloat(paramValueMin)
    outputBuffer.encodeFloat(paramValueMax)
    outputBuffer.encodeInt16(paramIndex)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeUint8(parameterRcChannelIndex)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 50

    private const val CRC: Int = 121

    private const val SIZE: Int = 37

    private val DESERIALIZER: MavDeserializer<ParamMapRc> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for ParamMapRc: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val paramValue0 = inputBuffer.decodeFloat()
      val scale = inputBuffer.decodeFloat()
      val paramValueMin = inputBuffer.decodeFloat()
      val paramValueMax = inputBuffer.decodeFloat()
      val paramIndex = inputBuffer.decodeInt16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val paramId = inputBuffer.decodeString(16)
      val parameterRcChannelIndex = inputBuffer.decodeUint8()

      ParamMapRc(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramIndex = paramIndex,
        parameterRcChannelIndex = parameterRcChannelIndex,
        paramValue0 = paramValue0,
        scale = scale,
        paramValueMin = paramValueMin,
        paramValueMax = paramValueMax,
      )
    }


    private val METADATA: MavMessage.Metadata<ParamMapRc> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ParamMapRc> = METADATA
  }
}
