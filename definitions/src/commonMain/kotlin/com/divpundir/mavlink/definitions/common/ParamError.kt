package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Parameter set/get error. Returned from a MAVLink node in response to an error in the parameter
 * protocol, for example failing to set a parameter because it does not exist.
 *       
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param paramId Parameter id. Terminated by NULL if the length is less than 16 human-readable
 * chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have
 * to provide 16+1 bytes storage if the ID is stored as string
 * @param paramIndex Parameter index. Will be -1 if the param ID field should be used as an
 * identifier (else the param id will be ignored)
 * @param error Error being returned to client.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 345u,
  crcExtra = -47,
)
public data class ParamError(
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
   * Parameter id. Terminated by NULL if the length is less than 16 human-readable chars and WITHOUT
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1
   * bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Parameter index. Will be -1 if the param ID field should be used as an identifier (else the
   * param id will be ignored)
   */
  @GeneratedMavField(type = "int16_t")
  public val paramIndex: Short = 0,
  /**
   * Error being returned to client.
   */
  @GeneratedMavField(type = "uint8_t")
  public val error: MavEnumValue<MavParamError> = MavEnumValue.fromValue(0u),
) : MavMessage<ParamError> {
  override val instanceCompanion: MavMessage.MavCompanion<ParamError> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(paramIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(error.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(paramIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    encoder.encodeEnumValue(error.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamError> {
    private const val SIZE_V1: Int = 21

    private const val SIZE_V2: Int = 21

    override val id: UInt = 345u

    override val crcExtra: Byte = -47

    override fun deserialize(bytes: ByteArray): ParamError {
      val decoder = MavDataDecoder(bytes)

      val paramIndex = decoder.safeDecodeInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val paramId = decoder.safeDecodeString(16)
      val error = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavParamError.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return ParamError(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramIndex = paramIndex,
        error = error,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamError =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var paramId: String = ""

    public var paramIndex: Short = 0

    public var error: MavEnumValue<MavParamError> = MavEnumValue.fromValue(0u)

    public fun build(): ParamError = ParamError(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      paramId = paramId,
      paramIndex = paramIndex,
      error = error,
    )
  }
}
