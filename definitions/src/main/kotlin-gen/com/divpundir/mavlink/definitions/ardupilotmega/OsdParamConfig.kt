package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Configure an OSD parameter slot.
 */
@GeneratedMavMessage(
  id = 11_033u,
  crcExtra = -61,
)
public data class OsdParamConfig(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Request ID - copied to reply.
   */
  @GeneratedMavField(type = "uint32_t")
  public val requestId: UInt = 0u,
  /**
   * OSD parameter screen index.
   */
  @GeneratedMavField(type = "uint8_t")
  public val osdScreen: UByte = 0u,
  /**
   * OSD parameter display index.
   */
  @GeneratedMavField(type = "uint8_t")
  public val osdIndex: UByte = 0u,
  /**
   * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and
   * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to
   * provide 16+1 bytes storage if the ID is stored as string
   */
  @GeneratedMavField(type = "char[16]")
  public val paramId: String = "",
  /**
   * Config type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val configType: MavEnumValue<OsdParamConfigType> = MavEnumValue.fromValue(0u),
  /**
   * OSD parameter minimum value.
   */
  @GeneratedMavField(type = "float")
  public val minValue: Float = 0F,
  /**
   * OSD parameter maximum value.
   */
  @GeneratedMavField(type = "float")
  public val maxValue: Float = 0F,
  /**
   * OSD parameter increment.
   */
  @GeneratedMavField(type = "float")
  public val increment: Float = 0F,
) : MavMessage<OsdParamConfig> {
  public override val instanceCompanion: MavMessage.MavCompanion<OsdParamConfig> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeFloat(minValue)
    buffer.encodeFloat(maxValue)
    buffer.encodeFloat(increment)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(osdScreen)
    buffer.encodeUInt8(osdIndex)
    buffer.encodeString(paramId, 16)
    buffer.encodeEnumValue(configType.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeFloat(minValue)
    buffer.encodeFloat(maxValue)
    buffer.encodeFloat(increment)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(osdScreen)
    buffer.encodeUInt8(osdIndex)
    buffer.encodeString(paramId, 16)
    buffer.encodeEnumValue(configType.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OsdParamConfig> {
    public override val id: UInt = 11_033u

    public override val crcExtra: Byte = -61

    public override fun deserialize(bytes: ByteArray): OsdParamConfig {
      val buffer = Buffer().write(bytes)

      val requestId = buffer.decodeUInt32()
      val minValue = buffer.decodeFloat()
      val maxValue = buffer.decodeFloat()
      val increment = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val osdScreen = buffer.decodeUInt8()
      val osdIndex = buffer.decodeUInt8()
      val paramId = buffer.decodeString(16)
      val configType = buffer.decodeEnumValue(1).let { value ->
        val entry = OsdParamConfigType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return OsdParamConfig(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        requestId = requestId,
        osdScreen = osdScreen,
        osdIndex = osdIndex,
        paramId = paramId,
        configType = configType,
        minValue = minValue,
        maxValue = maxValue,
        increment = increment,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OsdParamConfig =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var requestId: UInt = 0u

    public var osdScreen: UByte = 0u

    public var osdIndex: UByte = 0u

    public var paramId: String = ""

    public var configType: MavEnumValue<OsdParamConfigType> = MavEnumValue.fromValue(0u)

    public var minValue: Float = 0F

    public var maxValue: Float = 0F

    public var increment: Float = 0F

    public fun build(): OsdParamConfig = OsdParamConfig(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      requestId = requestId,
      osdScreen = osdScreen,
      osdIndex = osdIndex,
      paramId = paramId,
      configType = configType,
      minValue = minValue,
      maxValue = maxValue,
      increment = increment,
    )
  }
}
