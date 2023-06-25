package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Request to read the value of a parameter with either the param_id string id or param_index.
 * PARAM_EXT_VALUE should be emitted in response.
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
  public override val instanceCompanion: MavMessage.MavCompanion<ParamExtRequestRead> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(paramIndex)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeString(paramId, 16)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeInt16(paramIndex)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeString(paramId, 16)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ParamExtRequestRead> {
    public override val id: UInt = 320u

    public override val crcExtra: Byte = -13

    public override fun deserialize(bytes: ByteArray): ParamExtRequestRead {
      val buffer = Buffer().write(bytes)

      val paramIndex = buffer.decodeInt16()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val paramId = buffer.decodeString(16)

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
