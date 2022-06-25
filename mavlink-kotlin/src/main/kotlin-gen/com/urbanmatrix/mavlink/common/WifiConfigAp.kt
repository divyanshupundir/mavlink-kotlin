package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeString
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement by
 * the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE
 */
public data class WifiConfigAp(
  /**
   * Name of Wi-Fi network (SSID). Blank to leave it unchanged when setting. Current SSID when sent
   * back as a response.
   */
  public val ssid: String = "",
  /**
   * Password. Blank for an open AP. MD5 hash when message is sent back as a response.
   */
  public val password: String = "",
  /**
   * WiFi Mode.
   */
  public val mode: MavEnumValue<WifiConfigApMode> = MavEnumValue.fromValue(0),
  /**
   * Message acceptance response (sent back to GS).
   */
  public val response: MavEnumValue<WifiConfigApResponse> = MavEnumValue.fromValue(0),
) : MavMessage<WifiConfigAp> {
  public override val instanceMetadata: MavMessage.Metadata<WifiConfigAp> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(98).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeString(ssid, 32)
    outputBuffer.encodeString(password, 64)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeEnumValue(response.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 299

    private const val CRC: Int = 186

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


    private val METADATA: MavMessage.Metadata<WifiConfigAp> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WifiConfigAp> = METADATA
  }
}
