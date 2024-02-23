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
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param paramId Onboard parameter id, terminated by NULL if the length is less than 16
 * human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars -
 * applications have to provide 16+1 bytes storage if the ID is stored as string
 * @param paramValue Onboard parameter value
 * @param paramType Onboard parameter type.
 */
@GeneratedMavMessage(
  id = 23u,
  crcExtra = -88,
)
public data class ParamSet(
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
) : MavMessage<ParamSet> {
  override val instanceCompanion: MavMessage.MavCompanion<ParamSet> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(paramValue)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(paramValue)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(paramType.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamSet> {
    private const val SIZE_V1: Int = 23

    private const val SIZE_V2: Int = 23

    override val id: UInt = 23u

    override val crcExtra: Byte = -88

    override fun deserialize(bytes: ByteArray): ParamSet {
      val decoder = MavDataDecoder(bytes)

      val paramValue = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val paramId = decoder.safeDecodeString(16)
      val paramType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavParamType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ParamSet(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramValue = paramValue,
        paramType = paramType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamSet =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var paramId: String = ""

    public var paramValue: Float = 0F

    public var paramType: MavEnumValue<MavParamType> = MavEnumValue.fromValue(0u)

    public fun build(): ParamSet = ParamSet(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      paramId = paramId,
      paramValue = paramValue,
      paramType = paramType,
    )
  }
}
