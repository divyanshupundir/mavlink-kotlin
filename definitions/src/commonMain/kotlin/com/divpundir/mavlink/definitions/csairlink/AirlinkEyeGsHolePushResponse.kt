package com.divpundir.mavlink.definitions.csairlink

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Response information about the connected device
 *
 * @param respType Hole push response type
 * @param ipVersion ip version
 * @param ipAddress4 ip 4 address
 * @param ipAddress6 ip 6 address
 * @param ipPort port
 */
@GeneratedMavMessage(
  id = 52_003u,
  crcExtra = -90,
)
public data class AirlinkEyeGsHolePushResponse(
  /**
   * Hole push response type
   */
  @GeneratedMavField(type = "uint8_t")
  public val respType: MavEnumValue<AirlinkEyeGsHolePushRespType> = MavEnumValue.fromValue(0u),
  /**
   * ip version
   */
  @GeneratedMavField(type = "uint8_t")
  public val ipVersion: MavEnumValue<AirlinkEyeIpVersion> = MavEnumValue.fromValue(0u),
  /**
   * ip 4 address
   */
  @GeneratedMavField(type = "uint8_t[4]")
  public val ipAddress4: List<UByte> = emptyList(),
  /**
   * ip 6 address
   */
  @GeneratedMavField(type = "uint8_t[16]")
  public val ipAddress6: List<UByte> = emptyList(),
  /**
   * port
   */
  @GeneratedMavField(type = "uint32_t")
  public val ipPort: UInt = 0u,
) : MavMessage<AirlinkEyeGsHolePushResponse> {
  override val instanceCompanion: MavMessage.MavCompanion<AirlinkEyeGsHolePushResponse> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(ipPort)
    encoder.encodeEnumValue(respType.value, 1)
    encoder.encodeEnumValue(ipVersion.value, 1)
    encoder.encodeUInt8Array(ipAddress4, 4)
    encoder.encodeUInt8Array(ipAddress6, 16)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(ipPort)
    encoder.encodeEnumValue(respType.value, 1)
    encoder.encodeEnumValue(ipVersion.value, 1)
    encoder.encodeUInt8Array(ipAddress4, 4)
    encoder.encodeUInt8Array(ipAddress6, 16)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AirlinkEyeGsHolePushResponse> {
    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 26

    override val id: UInt = 52_003u

    override val crcExtra: Byte = -90

    override fun deserialize(bytes: ByteArray): AirlinkEyeGsHolePushResponse {
      val decoder = MavDataDecoder(bytes)

      val ipPort = decoder.safeDecodeUInt32()
      val respType = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AirlinkEyeGsHolePushRespType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val ipVersion = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = AirlinkEyeIpVersion.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val ipAddress4 = decoder.safeDecodeUInt8Array(4)
      val ipAddress6 = decoder.safeDecodeUInt8Array(16)

      return AirlinkEyeGsHolePushResponse(
        respType = respType,
        ipVersion = ipVersion,
        ipAddress4 = ipAddress4,
        ipAddress6 = ipAddress6,
        ipPort = ipPort,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AirlinkEyeGsHolePushResponse =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var respType: MavEnumValue<AirlinkEyeGsHolePushRespType> = MavEnumValue.fromValue(0u)

    public var ipVersion: MavEnumValue<AirlinkEyeIpVersion> = MavEnumValue.fromValue(0u)

    public var ipAddress4: List<UByte> = emptyList()

    public var ipAddress6: List<UByte> = emptyList()

    public var ipPort: UInt = 0u

    public fun build(): AirlinkEyeGsHolePushResponse = AirlinkEyeGsHolePushResponse(
      respType = respType,
      ipVersion = ipVersion,
      ipAddress4 = ipAddress4,
      ipAddress6 = ipAddress6,
      ipPort = ipPort,
    )
  }
}
