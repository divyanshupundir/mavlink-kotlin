package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String

/**
 * Set a parameter value (write new value to permanent storage).
 *         The receiving component should acknowledge the new parameter value by broadcasting a
 * PARAM_VALUE message (broadcasting ensures that multiple GCS all have an up-to-date list of all
 * parameters). If the sending GCS did not receive a PARAM_VALUE within its timeout time, it should
 * re-send the PARAM_SET message. The parameter microservice is documented at
 * https://mavlink.io/en/services/parameter.html.
 *         PARAM_SET may also be called within the context of a transaction (started with
 * MAV_CMD_PARAM_TRANSACTION). Within a transaction the receiving component should respond with
 * PARAM_ACK_TRANSACTION to the setter component (instead of broadcasting PARAM_VALUE), and PARAM_SET
 * should be re-sent if this is ACK not received.
 */
@GeneratedMavMessage(
  id = 23,
  crc = 168,
)
public data class ParamSet(
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
   * Onboard parameter value
   */
  public val paramValue: Float = 0F,
  /**
   * Onboard parameter type.
   */
  public val paramType: MavEnumValue<MavParamType> = MavEnumValue.fromValue(0),
) : MavMessage<ParamSet> {
  public override val instanceMetadata: MavMessage.Metadata<ParamSet> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(paramValue)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeString(paramId, 16)
    outputBuffer.encodeEnumValue(paramType.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 23

    private const val CRC: Int = 168

    private const val SIZE: Int = 23

    private val DESERIALIZER: MavDeserializer<ParamSet> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val paramValue = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val paramId = inputBuffer.decodeString(16)
      val paramType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MavParamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      ParamSet(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
      )
    }


    private val METADATA: MavMessage.Metadata<ParamSet> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ParamSet> = METADATA
  }
}
