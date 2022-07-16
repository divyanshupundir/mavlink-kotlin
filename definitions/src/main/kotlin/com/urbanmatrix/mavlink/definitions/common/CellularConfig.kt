package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializationException
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String

/**
 * Configure cellular modems.
 *         This message is re-emitted as an acknowledgement by the modem.
 *         The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE.
 */
public data class CellularConfig(
  /**
   * Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent
   * back as a response.
   */
  public val enableLte: Int = 0,
  /**
   * Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current
   * setting when sent back as a response.
   */
  public val enablePin: Int = 0,
  /**
   * PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a
   * response.
   */
  public val pin: String = "",
  /**
   * New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as
   * a response.
   */
  public val newPin: String = "",
  /**
   * Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a
   * response.
   */
  public val apn: String = "",
  /**
   * Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when
   * message is sent back as a response.
   */
  public val puk: String = "",
  /**
   * Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when
   * sent back as a response.
   */
  public val roaming: Int = 0,
  /**
   * Message acceptance response (sent back to GS).
   */
  public val response: MavEnumValue<CellularConfigResponse> = MavEnumValue.fromValue(0),
) : MavMessage<CellularConfig> {
  public override val instanceMetadata: MavMessage.Metadata<CellularConfig> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(enableLte)
    outputBuffer.encodeUint8(enablePin)
    outputBuffer.encodeString(pin, 16)
    outputBuffer.encodeString(newPin, 16)
    outputBuffer.encodeString(apn, 32)
    outputBuffer.encodeString(puk, 16)
    outputBuffer.encodeUint8(roaming)
    outputBuffer.encodeEnumValue(response.value, 1)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 336

    private const val CRC: Int = 228

    private const val SIZE: Int = 84

    private val DESERIALIZER: MavDeserializer<CellularConfig> = MavDeserializer { bytes ->
      if (bytes.size != SIZE) {
        throw MavDeserializationException(
          """Invalid ByteArray size for CellularConfig: Expected=$SIZE Actual=${bytes.size}"""
        )
      }

      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val enableLte = inputBuffer.decodeUint8()
      val enablePin = inputBuffer.decodeUint8()
      val pin = inputBuffer.decodeString(16)
      val newPin = inputBuffer.decodeString(16)
      val apn = inputBuffer.decodeString(32)
      val puk = inputBuffer.decodeString(16)
      val roaming = inputBuffer.decodeUint8()
      val response = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = CellularConfigResponse.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      CellularConfig(
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


    private val METADATA: MavMessage.Metadata<CellularConfig> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<CellularConfig> = METADATA
  }
}
