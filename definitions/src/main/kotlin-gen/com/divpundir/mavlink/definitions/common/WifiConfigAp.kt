package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement by
 * the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE
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
  public override val instanceMetadata: MavMessage.Metadata<WifiConfigAp> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(ssid, 32)
    outputBuffer.encodeString(password, 64)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(ssid, 32)
    outputBuffer.encodeString(password, 64)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeEnumValue(response.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 299u

    private const val CRC_EXTRA: Byte = 19

    private const val SIZE_V1: Int = 96

    private const val SIZE_V2: Int = 98

    private val DESERIALIZER: MavDeserializer<WifiConfigAp> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val ssid = inputBuffer.decodeString(32)
      val password = inputBuffer.decodeString(64)
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = WifiConfigApMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val response = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = WifiConfigApResponse.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      WifiConfigAp(
        ssid = ssid,
        password = password,
        mode = mode,
        response = response,
      )
    }


    private val METADATA: MavMessage.Metadata<WifiConfigAp> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WifiConfigAp> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): WifiConfigAp =
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
