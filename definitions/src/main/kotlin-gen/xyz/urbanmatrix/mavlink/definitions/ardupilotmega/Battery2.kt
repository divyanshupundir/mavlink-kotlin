package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * 2nd Battery status
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 181,
  crc = 174,
)
public data class Battery2(
  /**
   * Voltage.
   */
  @GeneratedMavField(type = "uint16_t")
  public val voltage: Int = 0,
  /**
   * Battery current, -1: autopilot does not measure the current.
   */
  @GeneratedMavField(type = "int16_t")
  public val currentBattery: Int = 0,
) : MavMessage<Battery2> {
  public override val instanceMetadata: MavMessage.Metadata<Battery2> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(voltage)
    outputBuffer.encodeInt16(currentBattery)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(voltage)
    outputBuffer.encodeInt16(currentBattery)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 181

    private const val CRC: Int = 174

    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    private val DESERIALIZER: MavDeserializer<Battery2> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val voltage = inputBuffer.decodeUint16()
      val currentBattery = inputBuffer.decodeInt16()

      Battery2(
        voltage = voltage,
        currentBattery = currentBattery,
      )
    }


    private val METADATA: MavMessage.Metadata<Battery2> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Battery2> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): Battery2 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var voltage: Int = 0

    public var currentBattery: Int = 0

    public fun build(): Battery2 = Battery2(
      voltage = voltage,
      currentBattery = currentBattery,
    )
  }
}
