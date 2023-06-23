package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.Short
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Bind a RC channel to a parameter. The parameter should change according to the RC channel value.
 */
@GeneratedMavMessage(
  id = 50u,
  crcExtra = 78,
)
public data class ParamMapRc(
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
   * ignored), send -2 to disable any existing map for this rc_channel_index.
   */
  @GeneratedMavField(type = "int16_t")
  public val paramIndex: Short = 0,
  /**
   * Index of parameter RC channel. Not equal to the RC channel id. Typically corresponds to a
   * potentiometer-knob on the RC.
   */
  @GeneratedMavField(type = "uint8_t")
  public val parameterRcChannelIndex: UByte = 0u,
  /**
   * Initial parameter value
   */
  @GeneratedMavField(type = "float")
  public val paramValue0: Float = 0F,
  /**
   * Scale, maps the RC range [-1, 1] to a parameter value
   */
  @GeneratedMavField(type = "float")
  public val scale: Float = 0F,
  /**
   * Minimum param value. The protocol does not define if this overwrites an onboard minimum value.
   * (Depends on implementation)
   */
  @GeneratedMavField(type = "float")
  public val paramValueMin: Float = 0F,
  /**
   * Maximum param value. The protocol does not define if this overwrites an onboard maximum value.
   * (Depends on implementation)
   */
  @GeneratedMavField(type = "float")
  public val paramValueMax: Float = 0F,
) : MavMessage<ParamMapRc> {
  public override val instanceCompanion: MavMessage.MavCompanion<ParamMapRc> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(paramValue0)
    output.encodeFloat(scale)
    output.encodeFloat(paramValueMin)
    output.encodeFloat(paramValueMax)
    output.encodeInt16(paramIndex)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(paramId, 16)
    output.encodeUInt8(parameterRcChannelIndex)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(paramValue0)
    output.encodeFloat(scale)
    output.encodeFloat(paramValueMin)
    output.encodeFloat(paramValueMax)
    output.encodeInt16(paramIndex)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeString(paramId, 16)
    output.encodeUInt8(parameterRcChannelIndex)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<ParamMapRc> {
    private const val SIZE_V1: Int = 37

    private const val SIZE_V2: Int = 37

    public override val id: UInt = 50u

    public override val crcExtra: Byte = 78

    public override fun deserialize(source: BufferedSource): ParamMapRc {
      val paramValue0 = source.decodeFloat()
      val scale = source.decodeFloat()
      val paramValueMin = source.decodeFloat()
      val paramValueMax = source.decodeFloat()
      val paramIndex = source.decodeInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val paramId = source.decodeString(16)
      val parameterRcChannelIndex = source.decodeUInt8()

      return ParamMapRc(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): ParamMapRc =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var paramId: String = ""

    public var paramIndex: Short = 0

    public var parameterRcChannelIndex: UByte = 0u

    public var paramValue0: Float = 0F

    public var scale: Float = 0F

    public var paramValueMin: Float = 0F

    public var paramValueMax: Float = 0F

    public fun build(): ParamMapRc = ParamMapRc(
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
}
