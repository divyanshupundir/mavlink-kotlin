package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.GeneratedMavMessage
import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeString
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeString
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List

/**
 * Write registers for a device.
 */
@GeneratedMavMessage(
  id = 11002,
  crc = 234,
)
public data class DeviceOpWrite(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Request ID - copied to reply.
   */
  public val requestId: Long = 0L,
  /**
   * The bus type.
   */
  public val bustype: MavEnumValue<DeviceOpBustype> = MavEnumValue.fromValue(0),
  /**
   * Bus number.
   */
  public val bus: Int = 0,
  /**
   * Bus address.
   */
  public val address: Int = 0,
  /**
   * Name of device on bus (for SPI).
   */
  public val busname: String = "",
  /**
   * First register to write.
   */
  public val regstart: Int = 0,
  /**
   * Count of registers to write.
   */
  public val count: Int = 0,
  /**
   * Write data.
   */
  public val `data`: List<Int> = emptyList(),
  /**
   * Bank number.
   */
  public val bank: Int = 0,
) : MavMessage<DeviceOpWrite> {
  public override val instanceMetadata: MavMessage.Metadata<DeviceOpWrite> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(requestId)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeEnumValue(bustype.value, 1)
    outputBuffer.encodeUint8(bus)
    outputBuffer.encodeUint8(address)
    outputBuffer.encodeString(busname, 40)
    outputBuffer.encodeUint8(regstart)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 128)
    outputBuffer.encodeUint8(bank)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 11002

    private const val CRC: Int = 234

    private const val SIZE: Int = 180

    private val DESERIALIZER: MavDeserializer<DeviceOpWrite> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val requestId = inputBuffer.decodeUint32()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val bustype = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = DeviceOpBustype.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val bus = inputBuffer.decodeUint8()
      val address = inputBuffer.decodeUint8()
      val busname = inputBuffer.decodeString(40)
      val regstart = inputBuffer.decodeUint8()
      val count = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(128)
      val bank = inputBuffer.decodeUint8()

      DeviceOpWrite(
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


    private val METADATA: MavMessage.Metadata<DeviceOpWrite> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DeviceOpWrite> = METADATA
  }
}
