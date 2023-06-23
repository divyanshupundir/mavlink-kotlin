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
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Request to read the onboard parameter with the param_id string id. Onboard parameters are stored
 * as key[const char*] -> value[float]. This allows to send a parameter to any other component (such as
 * the GCS) without the need of previous knowledge of possible parameter names. Thus the same GCS can
 * store different parameters for different autopilots. See also
 * https://mavlink.io/en/services/parameter.html for a full documentation of QGroundControl and IMU
 * code.
 */
@GeneratedMavMessage(
  id = 20u,
  crcExtra = -42,
)
public data class ParamRequestRead(
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
   * Parameter index. Send -1 to use the param ID field as identifier (else the param id will be
   * ignored)
   */
  @GeneratedMavField(type = "int16_t")
  public val paramIndex: Short = 0,
) : MavMessage<ParamRequestRead> {
  public override val instanceCompanion: MavMessage.MavCompanion<ParamRequestRead> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(paramIndex)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(paramId, 16)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(paramIndex)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(paramId, 16)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ParamRequestRead> {
    private const val SIZE_V1: Int = 20

    private const val SIZE_V2: Int = 20

    public override val id: UInt = 20u

    public override val crcExtra: Byte = -42

    public override fun deserialize(source: BufferedSource): ParamRequestRead {
      val paramIndex = source.decodeInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val paramId = source.decodeString(16)

      return ParamRequestRead(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        paramId = paramId,
        paramIndex = paramIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamRequestRead =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var paramId: String = ""

    public var paramIndex: Short = 0

    public fun build(): ParamRequestRead = ParamRequestRead(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      paramId = paramId,
      paramIndex = paramIndex,
    )
  }
}
