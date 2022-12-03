package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Configure WiFi AP SSID, password, and mode. This message is re-emitted as an acknowledgement by
 * the AP. The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE
 */
@GeneratedMavMessage(
  id = 299,
  crc = 19,
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
  public val mode: MavEnumValue<WifiConfigApMode> = MavEnumValue.fromValue(0),
  /**
   * Message acceptance response (sent back to GS).
   */
  @GeneratedMavField(
    type = "int8_t",
    extension = true,
  )
  public val response: MavEnumValue<WifiConfigApResponse> = MavEnumValue.fromValue(0),
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
    private const val ID: Int = 299

    private const val CRC: Int = 19

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


    private val METADATA: MavMessage.Metadata<WifiConfigAp> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WifiConfigAp> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): WifiConfigAp =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var ssid: String = ""

    public var password: String = ""

    public var mode: MavEnumValue<WifiConfigApMode> = MavEnumValue.fromValue(0)

    public var response: MavEnumValue<WifiConfigApResponse> = MavEnumValue.fromValue(0)

    public fun build(): WifiConfigAp = WifiConfigAp(
      ssid = ssid,
      password = password,
      mode = mode,
      response = response,
    )
  }
}
