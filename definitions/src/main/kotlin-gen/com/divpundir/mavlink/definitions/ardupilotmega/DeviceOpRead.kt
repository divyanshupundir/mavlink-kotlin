package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
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
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Read registers for a device.
 */
@GeneratedMavMessage(
  id = 11000u,
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
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpRead> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(bustype.value, 1)
    outputBuffer.encodeUInt8(bus)
    outputBuffer.encodeUInt8(address)
    outputBuffer.encodeString(busname, 40)
    outputBuffer.encodeUInt8(regstart)
    outputBuffer.encodeUInt8(count)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(requestId)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeEnumValue(bustype.value, 1)
    outputBuffer.encodeUInt8(bus)
    outputBuffer.encodeUInt8(address)
    outputBuffer.encodeString(busname, 40)
    outputBuffer.encodeUInt8(regstart)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeUInt8(bank)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 11000u

    private const val CRC_EXTRA: Byte = -122

    private const val SIZE_V1: Int = 51

    private const val SIZE_V2: Int = 52

    private val DESERIALIZER: MavDeserializer<DeviceOpRead> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUInt32()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val bustype = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = DeviceOpBustype.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val bus = inputBuffer.decodeUInt8()
      val address = inputBuffer.decodeUInt8()
      val busname = inputBuffer.decodeString(40)
      val regstart = inputBuffer.decodeUInt8()
      val count = inputBuffer.decodeUInt8()
      val bank = inputBuffer.decodeUInt8()

      DeviceOpRead(
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


    private val METADATA: MavMessage.Metadata<DeviceOpRead> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DeviceOpRead> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DeviceOpRead =
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
