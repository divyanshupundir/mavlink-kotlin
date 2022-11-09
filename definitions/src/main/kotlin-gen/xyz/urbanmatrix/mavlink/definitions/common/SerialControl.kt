package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavBitmaskValue
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.encodeBitmaskValue
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change
 * just the baudrate.
 */
@GeneratedMavMessage(
  id = 126,
  crc = 220,
)
public data class SerialControl(
  /**
   * Serial control device type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0),
  /**
   * Bitmap of serial control flags.
   */
  @GeneratedMavField(type = "uint8_t")
  public val flags: MavBitmaskValue<SerialControlFlag> = MavBitmaskValue.fromValue(0),
  /**
   * Timeout for reply data
   */
  @GeneratedMavField(type = "uint16_t")
  public val timeout: Int = 0,
  /**
   * Baudrate of transfer. Zero means no change.
   */
  @GeneratedMavField(type = "uint32_t")
  public val baudrate: Long = 0L,
  /**
   * how many bytes in this transfer
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: Int = 0,
  /**
   * serial data
   */
  @GeneratedMavField(type = "uint8_t[70]")
  public val `data`: List<Int> = emptyList(),
  /**
   * System ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetComponent: Int = 0,
) : MavMessage<SerialControl> {
  public override val instanceMetadata: MavMessage.Metadata<SerialControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(baudrate)
    outputBuffer.encodeUint16(timeout)
    outputBuffer.encodeEnumValue(device.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 70)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(baudrate)
    outputBuffer.encodeUint16(timeout)
    outputBuffer.encodeEnumValue(device.value, 1)
    outputBuffer.encodeBitmaskValue(flags.value, 1)
    outputBuffer.encodeUint8(count)
    outputBuffer.encodeUint8Array(data, 70)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 126

    private const val CRC: Int = 220

    private const val SIZE_V1: Int = 79

    private const val SIZE_V2: Int = 81

    private val DESERIALIZER: MavDeserializer<SerialControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val baudrate = inputBuffer.decodeUint32()
      val timeout = inputBuffer.decodeUint16()
      val device = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = SerialControlDev.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val flags = inputBuffer.decodeBitmaskValue(1).let { value ->
        val flags = SerialControlFlag.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var device: MavEnumValue<SerialControlDev> = MavEnumValue.fromValue(0)

    public var flags: MavBitmaskValue<SerialControlFlag> = MavBitmaskValue.fromValue(0)

    public var timeout: Int = 0

    public var baudrate: Long = 0L

    public var count: Int = 0

    public var `data`: List<Int> = emptyList()

    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

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
