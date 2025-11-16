package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Radio link information. Tx: ground-side device, Rx: vehicle-side device.
 *         The values of the fields in this message do normally not or only slowly change with time,
 * and for most times the message can be send at a low rate, like 0.2 Hz.
 *         If values change then the message should temporarily be send more often to inform the
 * system about the changes.
 *         The target_system field should normally be set to the system id of the system the link is
 * connected to, typically the flight controller.
 *         The target_component field can normally be set to 0, so that all components of the system
 * can receive the message.
 *       
 *
 * @param targetSystem System ID (ID of target system, normally flight controller).
 * @param targetComponent Component ID (normally 0 for broadcast).
 * @param type Radio link type. 0: unknown/generic type.
 * @param mode Operation mode. Radio link dependent. UINT8_MAX: ignore/unknown.
 * @param txPower Tx transmit power in dBm. INT8_MAX: unknown.
 * units = dBm
 * @param rxPower Rx transmit power in dBm. INT8_MAX: unknown.
 * units = dBm
 * @param txFrameRate Frame rate in Hz (frames per second) for Tx to Rx transmission. 0: unknown.
 * units = Hz
 * @param rxFrameRate Frame rate in Hz (frames per second) for Rx to Tx transmission. Normally equal
 * to tx_packet_rate. 0: unknown.
 * units = Hz
 * @param modeStr Operation mode as human readable string. Radio link dependent. Terminated by NULL
 * if the string length is less than 6 chars and WITHOUT NULL termination if the length is exactly 6
 * chars - applications have to provide 6+1 bytes storage if the mode is stored as string. Use a
 * zero-length string if not known.
 * @param bandStr Frequency band as human readable string. Radio link dependent. Terminated by NULL
 * if the string length is less than 6 chars and WITHOUT NULL termination if the length is exactly 6
 * chars - applications have to provide 6+1 bytes storage if the mode is stored as string. Use a
 * zero-length string if not known.
 * @param txSerDataRate Maximum data rate of serial stream in bytes/s for Tx to Rx transmission. 0:
 * unknown. UINT16_MAX: data rate is 64 KBytes/s or larger.
 * @param rxSerDataRate Maximum data rate of serial stream in bytes/s for Rx to Tx transmission. 0:
 * unknown. UINT16_MAX: data rate is 64 KBytes/s or larger.
 * @param txReceiveSensitivity Receive sensitivity of Tx in inverted dBm. 1..255 represents -1..-255
 * dBm, 0: unknown.
 * @param rxReceiveSensitivity Receive sensitivity of Rx in inverted dBm. 1..255 represents -1..-255
 * dBm, 0: unknown.
 */
@GeneratedMavMessage(
  id = 60_046u,
  crcExtra = -85,
)
public data class MlrsRadioLinkInformation(
  /**
   * System ID (ID of target system, normally flight controller).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID (normally 0 for broadcast).
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Radio link type. 0: unknown/generic type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val type: MavEnumValue<MlrsRadioLinkType> = MavEnumValue.fromValue(0u),
  /**
   * Operation mode. Radio link dependent. UINT8_MAX: ignore/unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: UByte = 0u,
  /**
   * Tx transmit power in dBm. INT8_MAX: unknown.
   * units = dBm
   */
  @GeneratedMavField(type = "int8_t")
  public val txPower: Byte = 0,
  /**
   * Rx transmit power in dBm. INT8_MAX: unknown.
   * units = dBm
   */
  @GeneratedMavField(type = "int8_t")
  public val rxPower: Byte = 0,
  /**
   * Frame rate in Hz (frames per second) for Tx to Rx transmission. 0: unknown.
   * units = Hz
   */
  @GeneratedMavField(type = "uint16_t")
  public val txFrameRate: UShort = 0u,
  /**
   * Frame rate in Hz (frames per second) for Rx to Tx transmission. Normally equal to
   * tx_packet_rate. 0: unknown.
   * units = Hz
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxFrameRate: UShort = 0u,
  /**
   * Operation mode as human readable string. Radio link dependent. Terminated by NULL if the string
   * length is less than 6 chars and WITHOUT NULL termination if the length is exactly 6 chars -
   * applications have to provide 6+1 bytes storage if the mode is stored as string. Use a zero-length
   * string if not known.
   */
  @GeneratedMavField(type = "char[6]")
  public val modeStr: String = "",
  /**
   * Frequency band as human readable string. Radio link dependent. Terminated by NULL if the string
   * length is less than 6 chars and WITHOUT NULL termination if the length is exactly 6 chars -
   * applications have to provide 6+1 bytes storage if the mode is stored as string. Use a zero-length
   * string if not known.
   */
  @GeneratedMavField(type = "char[6]")
  public val bandStr: String = "",
  /**
   * Maximum data rate of serial stream in bytes/s for Tx to Rx transmission. 0: unknown.
   * UINT16_MAX: data rate is 64 KBytes/s or larger.
   */
  @GeneratedMavField(type = "uint16_t")
  public val txSerDataRate: UShort = 0u,
  /**
   * Maximum data rate of serial stream in bytes/s for Rx to Tx transmission. 0: unknown.
   * UINT16_MAX: data rate is 64 KBytes/s or larger.
   */
  @GeneratedMavField(type = "uint16_t")
  public val rxSerDataRate: UShort = 0u,
  /**
   * Receive sensitivity of Tx in inverted dBm. 1..255 represents -1..-255 dBm, 0: unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val txReceiveSensitivity: UByte = 0u,
  /**
   * Receive sensitivity of Rx in inverted dBm. 1..255 represents -1..-255 dBm, 0: unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val rxReceiveSensitivity: UByte = 0u,
) : MavMessage<MlrsRadioLinkInformation> {
  override val instanceCompanion: MavMessage.MavCompanion<MlrsRadioLinkInformation> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(txFrameRate)
    encoder.encodeUInt16(rxFrameRate)
    encoder.encodeUInt16(txSerDataRate)
    encoder.encodeUInt16(rxSerDataRate)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(mode)
    encoder.encodeInt8(txPower)
    encoder.encodeInt8(rxPower)
    encoder.encodeString(modeStr, 6)
    encoder.encodeString(bandStr, 6)
    encoder.encodeUInt8(txReceiveSensitivity)
    encoder.encodeUInt8(rxReceiveSensitivity)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(txFrameRate)
    encoder.encodeUInt16(rxFrameRate)
    encoder.encodeUInt16(txSerDataRate)
    encoder.encodeUInt16(rxSerDataRate)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(type.value, 1)
    encoder.encodeUInt8(mode)
    encoder.encodeInt8(txPower)
    encoder.encodeInt8(rxPower)
    encoder.encodeString(modeStr, 6)
    encoder.encodeString(bandStr, 6)
    encoder.encodeUInt8(txReceiveSensitivity)
    encoder.encodeUInt8(rxReceiveSensitivity)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MlrsRadioLinkInformation> {
    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    override val id: UInt = 60_046u

    override val crcExtra: Byte = -85

    override fun deserialize(bytes: ByteArray): MlrsRadioLinkInformation {
      val decoder = MavDataDecoder(bytes)

      val txFrameRate = decoder.safeDecodeUInt16()
      val rxFrameRate = decoder.safeDecodeUInt16()
      val txSerDataRate = decoder.safeDecodeUInt16()
      val rxSerDataRate = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val type = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MlrsRadioLinkType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mode = decoder.safeDecodeUInt8()
      val txPower = decoder.safeDecodeInt8()
      val rxPower = decoder.safeDecodeInt8()
      val modeStr = decoder.safeDecodeString(6)
      val bandStr = decoder.safeDecodeString(6)
      val txReceiveSensitivity = decoder.safeDecodeUInt8()
      val rxReceiveSensitivity = decoder.safeDecodeUInt8()

      return MlrsRadioLinkInformation(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        type = type,
        mode = mode,
        txPower = txPower,
        rxPower = rxPower,
        txFrameRate = txFrameRate,
        rxFrameRate = rxFrameRate,
        modeStr = modeStr,
        bandStr = bandStr,
        txSerDataRate = txSerDataRate,
        rxSerDataRate = rxSerDataRate,
        txReceiveSensitivity = txReceiveSensitivity,
        rxReceiveSensitivity = rxReceiveSensitivity,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MlrsRadioLinkInformation =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var type: MavEnumValue<MlrsRadioLinkType> = MavEnumValue.fromValue(0u)

    public var mode: UByte = 0u

    public var txPower: Byte = 0

    public var rxPower: Byte = 0

    public var txFrameRate: UShort = 0u

    public var rxFrameRate: UShort = 0u

    public var modeStr: String = ""

    public var bandStr: String = ""

    public var txSerDataRate: UShort = 0u

    public var rxSerDataRate: UShort = 0u

    public var txReceiveSensitivity: UByte = 0u

    public var rxReceiveSensitivity: UByte = 0u

    public fun build(): MlrsRadioLinkInformation = MlrsRadioLinkInformation(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      type = type,
      mode = mode,
      txPower = txPower,
      rxPower = rxPower,
      txFrameRate = txFrameRate,
      rxFrameRate = rxFrameRate,
      modeStr = modeStr,
      bandStr = bandStr,
      txSerDataRate = txSerDataRate,
      rxSerDataRate = rxSerDataRate,
      txReceiveSensitivity = txReceiveSensitivity,
      rxReceiveSensitivity = rxReceiveSensitivity,
    )
  }
}
