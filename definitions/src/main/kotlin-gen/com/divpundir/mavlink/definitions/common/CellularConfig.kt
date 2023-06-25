package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Configure cellular modems.
 *         This message is re-emitted as an acknowledgement by the modem.
 *         The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE.
 */
@GeneratedMavMessage(
  id = 336u,
  crcExtra = -11,
)
public data class CellularConfig(
  /**
   * Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent
   * back as a response.
   */
  @GeneratedMavField(type = "uint8_t")
  public val enableLte: UByte = 0u,
  /**
   * Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current
   * setting when sent back as a response.
   */
  @GeneratedMavField(type = "uint8_t")
  public val enablePin: UByte = 0u,
  /**
   * PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a
   * response.
   */
  @GeneratedMavField(type = "char[16]")
  public val pin: String = "",
  /**
   * New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as
   * a response.
   */
  @GeneratedMavField(type = "char[16]")
  public val newPin: String = "",
  /**
   * Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a
   * response.
   */
  @GeneratedMavField(type = "char[32]")
  public val apn: String = "",
  /**
   * Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when
   * message is sent back as a response.
   */
  @GeneratedMavField(type = "char[16]")
  public val puk: String = "",
  /**
   * Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when
   * sent back as a response.
   */
  @GeneratedMavField(type = "uint8_t")
  public val roaming: UByte = 0u,
  /**
   * Message acceptance response (sent back to GS).
   */
  @GeneratedMavField(type = "uint8_t")
  public val response: MavEnumValue<CellularConfigResponse> = MavEnumValue.fromValue(0u),
) : MavMessage<CellularConfig> {
  public override val instanceCompanion: MavMessage.MavCompanion<CellularConfig> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(enableLte)
    buffer.encodeUInt8(enablePin)
    buffer.encodeString(pin, 16)
    buffer.encodeString(newPin, 16)
    buffer.encodeString(apn, 32)
    buffer.encodeString(puk, 16)
    buffer.encodeUInt8(roaming)
    buffer.encodeEnumValue(response.value, 1)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(enableLte)
    buffer.encodeUInt8(enablePin)
    buffer.encodeString(pin, 16)
    buffer.encodeString(newPin, 16)
    buffer.encodeString(apn, 32)
    buffer.encodeString(puk, 16)
    buffer.encodeUInt8(roaming)
    buffer.encodeEnumValue(response.value, 1)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<CellularConfig> {
    public override val id: UInt = 336u

    public override val crcExtra: Byte = -11

    public override fun deserialize(bytes: ByteArray): CellularConfig {
      val buffer = Buffer().write(bytes)

      val enableLte = buffer.decodeUInt8()
      val enablePin = buffer.decodeUInt8()
      val pin = buffer.decodeString(16)
      val newPin = buffer.decodeString(16)
      val apn = buffer.decodeString(32)
      val puk = buffer.decodeString(16)
      val roaming = buffer.decodeUInt8()
      val response = buffer.decodeEnumValue(1).let { value ->
        val entry = CellularConfigResponse.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return CellularConfig(
        enableLte = enableLte,
        enablePin = enablePin,
        pin = pin,
        newPin = newPin,
        apn = apn,
        puk = puk,
        roaming = roaming,
        response = response,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): CellularConfig =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var enableLte: UByte = 0u

    public var enablePin: UByte = 0u

    public var pin: String = ""

    public var newPin: String = ""

    public var apn: String = ""

    public var puk: String = ""

    public var roaming: UByte = 0u

    public var response: MavEnumValue<CellularConfigResponse> = MavEnumValue.fromValue(0u)

    public fun build(): CellularConfig = CellularConfig(
      enableLte = enableLte,
      enablePin = enablePin,
      pin = pin,
      newPin = newPin,
      apn = apn,
      puk = puk,
      roaming = roaming,
      response = response,
    )
  }
}
