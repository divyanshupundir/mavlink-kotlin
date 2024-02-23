package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Read a configured an OSD parameter slot.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param requestId Request ID - copied to reply.
 * @param osdScreen OSD parameter screen index.
 * @param osdIndex OSD parameter display index.
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
  override val instanceCompanion: MavMessage.MavCompanion<OsdParamShowConfig> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(osdScreen)
    encoder.encodeUInt8(osdIndex)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(osdScreen)
    encoder.encodeUInt8(osdIndex)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<OsdParamShowConfig> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    override val id: UInt = 11_035u

    override val crcExtra: Byte = -128

    override fun deserialize(bytes: ByteArray): OsdParamShowConfig {
      val decoder = MavDataDecoder(bytes)

      val requestId = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val osdScreen = decoder.safeDecodeUInt8()
      val osdIndex = decoder.safeDecodeUInt8()

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
