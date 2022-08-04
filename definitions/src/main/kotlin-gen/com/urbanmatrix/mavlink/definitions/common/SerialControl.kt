package com.urbanmatrix.mavlink.definitions.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeUint16
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeUint16
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.collections.List

/**
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change
 * just the baudrate.
 */
public data class SerialControl(
  /**
   * Serial control device type.
   */
  public val device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0),
  /**
   * Bitmap of serial control flags.
   */
  public val flags: MavEnumValue<SerialControlFlag> = MavEnumValue.fromValue(0),
  /**
   * Timeout for reply data
   */
  public val timeout: Int = 0,
  /**
   * Baudrate of transfer. Zero means no change.
   */
  public val baudrate: Long = 0L,
  /**
   * how many bytes in this transfer
   */
  public val count: Int = 0,
  /**
   * serial data
   */
  public val `data`: List<Int> = emptyList(),
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
) : MavMessage<SerialControl> {
  public override val instanceMetadata: MavMessage.Metadata<SerialControl> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(baudrate)
    outputBuffer.encodeUint16(timeout)
    outputBuffer.encodeEnumValue(device.value, 1)
    outputBuffer.encodeEnumValue(flags.value, 1)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 70)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 126

    private const val CRC: Int = 220

    private const val SIZE: Int = 81

    private val DESERIALIZER: MavDeserializer<SerialControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val baudrate = inputBuffer.decodeUint32()
      val timeout = inputBuffer.decodeUint16()
      val device = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = SerialControlDev.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = SerialControlFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val count = inputBuffer.decodeUint8()
      val data = inputBuffer.decodeUint8Array(70)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      SerialControl(
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


    private val METADATA: MavMessage.Metadata<SerialControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialControl> = METADATA
  }
}
