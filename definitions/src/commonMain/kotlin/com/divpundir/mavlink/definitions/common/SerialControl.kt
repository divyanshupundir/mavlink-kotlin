package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change
 * just the baudrate.
 *
 * @param device Serial control device type.
 * @param flags Bitmap of serial control flags.
 * @param timeout Timeout for reply data
 * units = ms
 * @param baudrate Baudrate of transfer. Zero means no change.
 * units = bits/s
 * @param count how many bytes in this transfer
 * units = bytes
 * @param data serial data
 * @param targetSystem System ID
 * @param targetComponent Component ID
 */
@GeneratedMavMessage(
  id = 126u,
  crcExtra = -36,
)
public data class SerialControl(
  /**
   * Serial control device type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0u),
  /**
   * Bitmap of serial control flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<SerialControlFlag> = MavBitmaskValue.fromValue(0u),
  /**
   * Timeout for reply data
   * units = ms
   */
  @GeneratedMavField(type = "uint16_t")
  public val timeout: UShort = 0u,
  /**
   * Baudrate of transfer. Zero means no change.
   * units = bits/s
   */
  @GeneratedMavField(type = "uint32_t")
  public val baudrate: UInt = 0u,
  /**
   * how many bytes in this transfer
   * units = bytes
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * serial data
   */
  @GeneratedMavField(type = "uint8_t[70]")
  public val `data`: List<UByte> = emptyList(),
  /**
   * System ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetComponent: UByte = 0u,
) : MavMessage<SerialControl> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(baudrate)
    encoder.encodeUInt16(timeout)
    encoder.encodeEnumValue(device.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 70)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(baudrate)
    encoder.encodeUInt16(timeout)
    encoder.encodeEnumValue(device.value, 1)
    encoder.encodeBitmaskValue(flags.value, 1)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 70)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialControl> {
    private const val SIZE_V1: Int = 79

    private const val SIZE_V2: Int = 81

    override val id: UInt = 126u

    override val crcExtra: Byte = -36

    override fun deserialize(bytes: ByteArray): SerialControl {
      val decoder = MavDataDecoder(bytes)

      val baudrate = decoder.safeDecodeUInt32()
      val timeout = decoder.safeDecodeUInt16()
      val device = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = SerialControlDev.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = decoder.safeDecodeBitmaskValue(1).let { value ->
        val flags = SerialControlFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val count = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(70)
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return SerialControl(
        device = device,
        flags = flags,
        timeout = timeout,
        baudrate = baudrate,
        count = count,
        data = data,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0u)

    public var flags: MavBitmaskValue<SerialControlFlag> = MavBitmaskValue.fromValue(0u)

    public var timeout: UShort = 0u

    public var baudrate: UInt = 0u

    public var count: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): SerialControl = SerialControl(
      device = device,
      flags = flags,
      timeout = timeout,
      baudrate = baudrate,
      count = count,
      data = data,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
