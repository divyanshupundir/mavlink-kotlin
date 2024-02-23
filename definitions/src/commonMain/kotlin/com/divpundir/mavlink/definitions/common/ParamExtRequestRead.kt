package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
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
 * Request to read the value of a parameter with either the param_id string id or param_index.
 * PARAM_EXT_VALUE should be emitted in response.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param paramId Parameter id, terminated by NULL if the length is less than 16 human-readable
 * chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have
 * to provide 16+1 bytes storage if the ID is stored as string
 * @param paramIndex Parameter index. Set to -1 to use the Parameter ID field as identifier (else
 * param_id will be ignored)
 */
@GeneratedMavMessage(
  id = 320u,
  crcExtra = -13,
)
public data class ParamExtRequestRead(
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
   * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT
   * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1
   * bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Parameter index. Set to -1 to use the Parameter ID field as identifier (else param_id will be
   * ignored)
   */
  @GeneratedMavField(type = "int16_t")
  public val paramIndex: Short = 0,
) : MavMessage<ParamExtRequestRead> {
  override val instanceCompanion: MavMessage.MavCompanion<ParamExtRequestRead> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt16(paramIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt16(paramIndex)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(paramId, 16)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamExtRequestRead> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    override val id: UInt = 320u

    override val crcExtra: Byte = -13

    override fun deserialize(bytes: ByteArray): ParamExtRequestRead {
      val decoder = MavDataDecoder(bytes)

      val paramIndex = decoder.safeDecodeInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val paramId = decoder.safeDecodeString(16)

      return ParamExtRequestRead(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramIndex = paramIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamExtRequestRead =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var paramId: String = ""

    public var paramIndex: Short = 0

    public fun build(): ParamExtRequestRead = ParamExtRequestRead(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      paramId = paramId,
      paramIndex = paramIndex,
    )
  }
}
