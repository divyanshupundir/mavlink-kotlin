package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
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
 * Read registers for a device.
 */
@GeneratedMavMessage(
  id = 11_000u,
  crcExtra = -122,
)
public data class DeviceOpRead(
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
   * First register to read.
   */
  @GeneratedMavField(type = "uint8_t")
  public val regstart: UByte = 0u,
  /**
   * Count of registers to read.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Bank number.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val bank: UByte = 0u,
) : MavMessage<DeviceOpRead> {
  public override val instanceCompanion: MavMessage.MavCompanion<DeviceOpRead> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(bustype.value, 1)
    buffer.encodeUInt8(bus)
    buffer.encodeUInt8(address)
    buffer.encodeString(busname, 40)
    buffer.encodeUInt8(regstart)
    buffer.encodeUInt8(count)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(requestId)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeEnumValue(bustype.value, 1)
    buffer.encodeUInt8(bus)
    buffer.encodeUInt8(address)
    buffer.encodeString(busname, 40)
    buffer.encodeUInt8(regstart)
    buffer.encodeUInt8(count)
    buffer.encodeUInt8(bank)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DeviceOpRead> {
    public override val id: UInt = 11_000u

    public override val crcExtra: Byte = -122

    public override fun deserialize(bytes: ByteArray): DeviceOpRead {
      val buffer = Buffer().write(bytes)

      val requestId = buffer.decodeUInt32()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val bustype = buffer.decodeEnumValue(1).let { value ->
        val entry = DeviceOpBustype.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val bus = buffer.decodeUInt8()
      val address = buffer.decodeUInt8()
      val busname = buffer.decodeString(40)
      val regstart = buffer.decodeUInt8()
      val count = buffer.decodeUInt8()
      val bank = buffer.decodeUInt8()

      return DeviceOpRead(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        requestId = requestId,
        bustype = bustype,
        bus = bus,
        address = address,
        busname = busname,
        regstart = regstart,
        count = count,
        bank = bank,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DeviceOpRead =
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

    public var bank: UByte = 0u

    public fun build(): DeviceOpRead = DeviceOpRead(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      requestId = requestId,
      bustype = bustype,
      bus = bus,
      address = address,
      busname = busname,
      regstart = regstart,
      count = count,
      bank = bank,
    )
  }
}
