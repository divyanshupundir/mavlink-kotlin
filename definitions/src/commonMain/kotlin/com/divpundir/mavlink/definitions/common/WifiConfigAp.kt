package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement by
 * the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE
 *
 * @param ssid Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID
 * when sent back as a response.
 * @param password Password. Blank for an open AP. MD5 hash when message is sent back as a response.
 * @param mode WiFi Mode.
 * @param response Message acceptance response (sent back to GS).
 */
@GeneratedMavMessage(
  id = 299u,
  crcExtra = 19,
)
public data class WifiConfigAp(
  /**
   * Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent
   * back as a response.
   */
  @GeneratedMavField(type = "char[32]")
  public val ssid: String = "",
  /**
   * Password. Blank for an open AP. MD5 hash when message is sent back as a response.
   */
  @GeneratedMavField(type = "char[64]")
  public val password: String = "",
  /**
   * WiFi Mode.
   */
  @GeneratedMavField(
    type = "int8_t",
    extension = true,
  )
  public val mode: MavEnumValue<WifiConfigApMode> = MavEnumValue.fromValue(0u),
  /**
   * Message acceptance response (sent back to GS).
   */
  @GeneratedMavField(
    type = "int8_t",
    extension = true,
  )
  public val response: MavEnumValue<WifiConfigApResponse> = MavEnumValue.fromValue(0u),
) : MavMessage<WifiConfigAp> {
  override val instanceCompanion: MavMessage.MavCompanion<WifiConfigAp> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeString(ssid, 32)
    encoder.encodeString(password, 64)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeString(ssid, 32)
    encoder.encodeString(password, 64)
    encoder.encodeEnumValue(mode.value, 1)
    encoder.encodeEnumValue(response.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<WifiConfigAp> {
    private const val SIZE_V1: Int = 96

    private const val SIZE_V2: Int = 98

    override val id: UInt = 299u

    override val crcExtra: Byte = 19

    override fun deserialize(bytes: ByteArray): WifiConfigAp {
      val decoder = MavDataDecoder(bytes)

      val ssid = decoder.safeDecodeString(32)
      val password = decoder.safeDecodeString(64)
      val mode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = WifiConfigApMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val response = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = WifiConfigApResponse.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return WifiConfigAp(
        ssid = ssid,
        password = password,
        mode = mode,
        response = response,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): WifiConfigAp =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var ssid: String = ""

    public var password: String = ""

    public var mode: MavEnumValue<WifiConfigApMode> = MavEnumValue.fromValue(0u)

    public var response: MavEnumValue<WifiConfigApResponse> = MavEnumValue.fromValue(0u)

    public fun build(): WifiConfigAp = WifiConfigAp(
      ssid = ssid,
      password = password,
      mode = mode,
      response = response,
    )
  }
}
