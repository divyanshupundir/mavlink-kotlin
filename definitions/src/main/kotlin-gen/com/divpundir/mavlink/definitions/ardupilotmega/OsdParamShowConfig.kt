package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Read a configured an OSD parameter slot.
 */
@GeneratedMavMessage(
  id = 11_035u,
  crcExtra = -128,
)
public data class OsdParamShowConfig(
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
) : MavMessage<OsdParamShowConfig> {
  public override val instanceCompanion: MavMessage.MavCompanion<OsdParamShowConfig> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(osdScreen)
    buffer.encodeUInt8(osdIndex)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(osdScreen)
    buffer.encodeUInt8(osdIndex)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OsdParamShowConfig> {
    public override val id: UInt = 11_035u

    public override val crcExtra: Byte = -128

    public override fun deserialize(bytes: ByteArray): OsdParamShowConfig {
      val buffer = Buffer().write(bytes)

      val requestId = buffer.decodeUInt32()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val osdScreen = buffer.decodeUInt8()
      val osdIndex = buffer.decodeUInt8()

      return OsdParamShowConfig(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        requestId = requestId,
        osdScreen = osdScreen,
        osdIndex = osdIndex,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): OsdParamShowConfig =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var requestId: UInt = 0u

    public var osdScreen: UByte = 0u

    public var osdIndex: UByte = 0u

    public fun build(): OsdParamShowConfig = OsdParamShowConfig(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      requestId = requestId,
      osdScreen = osdScreen,
      osdIndex = osdIndex,
    )
  }
}
