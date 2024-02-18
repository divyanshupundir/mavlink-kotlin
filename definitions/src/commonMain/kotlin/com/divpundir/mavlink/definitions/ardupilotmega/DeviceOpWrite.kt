package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Write registers for a device.
 *
 */
@GeneratedMavMessage(
  id = 11_002u,
  crcExtra = -22,
)
public data class DeviceOpWrite(
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
   * The bus type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val bustype: MavEnumValue<DeviceOpBustype> = MavEnumValue.fromValue(0u),
  /**
   * Bus number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val bus: UByte = 0u,
  /**
   * Bus address.
   */
  @GeneratedMavField(type = "uint8_t")
  public val address: UByte = 0u,
  /**
   * Name of device on bus (for SPI).
   */
  @GeneratedMavField(type = "char[40]")
  public val busname: String = "",
  /**
   * First register to write.
   */
  @GeneratedMavField(type = "uint8_t")
  public val regstart: UByte = 0u,
  /**
   * Count of registers to write.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Write data.
   */
  @GeneratedMavField(type = "uint8_t[128]")
  public val `data`: List<UByte> = emptyList(),
  /**
   * Bank number.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val bank: UByte = 0u,
) : MavMessage<DeviceOpWrite> {
  override val instanceCompanion: MavMessage.MavCompanion<DeviceOpWrite> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(bustype.value, 1)
    encoder.encodeUInt8(bus)
    encoder.encodeUInt8(address)
    encoder.encodeString(busname, 40)
    encoder.encodeUInt8(regstart)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 128)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(requestId)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(bustype.value, 1)
    encoder.encodeUInt8(bus)
    encoder.encodeUInt8(address)
    encoder.encodeString(busname, 40)
    encoder.encodeUInt8(regstart)
    encoder.encodeUInt8(count)
    encoder.encodeUInt8Array(data, 128)
    encoder.encodeUInt8(bank)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DeviceOpWrite> {
    private const val SIZE_V1: Int = 179

    private const val SIZE_V2: Int = 180

    override val id: UInt = 11_002u

    override val crcExtra: Byte = -22

    override fun deserialize(bytes: ByteArray): DeviceOpWrite {
      val decoder = MavDataDecoder(bytes)

      val requestId = decoder.safeDecodeUInt32()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val bustype = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = DeviceOpBustype.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val bus = decoder.safeDecodeUInt8()
      val address = decoder.safeDecodeUInt8()
      val busname = decoder.safeDecodeString(40)
      val regstart = decoder.safeDecodeUInt8()
      val count = decoder.safeDecodeUInt8()
      val data = decoder.safeDecodeUInt8Array(128)
      val bank = decoder.safeDecodeUInt8()

      return DeviceOpWrite(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        requestId = requestId,
        bustype = bustype,
        bus = bus,
        address = address,
        busname = busname,
        regstart = regstart,
        count = count,
        data = data,
        bank = bank,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DeviceOpWrite =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var requestId: UInt = 0u

    public var bustype: MavEnumValue<DeviceOpBustype> = MavEnumValue.fromValue(0u)

    public var bus: UByte = 0u

    public var address: UByte = 0u

    public var busname: String = ""

    public var regstart: UByte = 0u

    public var count: UByte = 0u

    public var `data`: List<UByte> = emptyList()

    public var bank: UByte = 0u

    public fun build(): DeviceOpWrite = DeviceOpWrite(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      requestId = requestId,
      bustype = bustype,
      bus = bus,
      address = address,
      busname = busname,
      regstart = regstart,
      count = count,
      data = data,
      bank = bank,
    )
  }
}
