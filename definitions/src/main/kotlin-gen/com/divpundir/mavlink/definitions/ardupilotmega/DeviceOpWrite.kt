package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Write registers for a device.
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
  public override val instanceCompanion: MavMessage.MavCompanion<DeviceOpWrite> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(bustype.value, 1)
    output.encodeUInt8(bus)
    output.encodeUInt8(address)
    output.encodeString(busname, 40)
    output.encodeUInt8(regstart)
    output.encodeUInt8(count)
    output.encodeUInt8Array(data, 128)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt32(requestId)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeEnumValue(bustype.value, 1)
    output.encodeUInt8(bus)
    output.encodeUInt8(address)
    output.encodeString(busname, 40)
    output.encodeUInt8(regstart)
    output.encodeUInt8(count)
    output.encodeUInt8Array(data, 128)
    output.encodeUInt8(bank)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<DeviceOpWrite> {
    private const val SIZE_V1: Int = 179

    private const val SIZE_V2: Int = 180

    public override val id: UInt = 11_002u

    public override val crcExtra: Byte = -22

    public override fun deserialize(source: BufferedSource): DeviceOpWrite {
      val requestId = source.decodeUInt32()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val bustype = source.decodeEnumValue(1).let { value ->
        val entry = DeviceOpBustype.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val bus = source.decodeUInt8()
      val address = source.decodeUInt8()
      val busname = source.decodeString(40)
      val regstart = source.decodeUInt8()
      val count = source.decodeUInt8()
      val data = source.decodeUInt8Array(128)
      val bank = source.decodeUInt8()

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
