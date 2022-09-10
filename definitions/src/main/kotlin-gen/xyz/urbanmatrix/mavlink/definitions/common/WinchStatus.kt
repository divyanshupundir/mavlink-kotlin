package xyz.urbanmatrix.mavlink.definitions.common

import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUint64
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUint64
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Winch status.
 */
@GeneratedMavMessage(
  id = 9005,
  crc = 117,
)
public data class WinchStatus(
  /**
   * Timestamp (synced to UNIX time or since system boot).
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: BigInteger = BigInteger.ZERO,
  /**
   * Length of line released. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val lineLength: Float = 0F,
  /**
   * Speed line is being released or retracted. Positive values if being released, negative values
   * if being retracted, NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val speed: Float = 0F,
  /**
   * Tension on the line. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val tension: Float = 0F,
  /**
   * Voltage of the battery supplying the winch. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val voltage: Float = 0F,
  /**
   * Current draw from the winch. NaN if unknown
   */
  @GeneratedMavField(type = "float")
  public val current: Float = 0F,
  /**
   * Temperature of the motor. INT16_MAX if unknown
   */
  @GeneratedMavField(type = "int16_t")
  public val temperature: Int = 0,
  /**
   * Status flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val status: MavEnumValue<MavWinchStatusFlag> = MavEnumValue.fromValue(0),
) : MavMessage<WinchStatus> {
  public override val instanceMetadata: MavMessage.Metadata<WinchStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(lineLength)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(tension)
    outputBuffer.encodeFloat(voltage)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeEnumValue(status.value, 4)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint64(timeUsec)
    outputBuffer.encodeFloat(lineLength)
    outputBuffer.encodeFloat(speed)
    outputBuffer.encodeFloat(tension)
    outputBuffer.encodeFloat(voltage)
    outputBuffer.encodeFloat(current)
    outputBuffer.encodeEnumValue(status.value, 4)
    outputBuffer.encodeInt16(temperature)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 9005

    private const val CRC: Int = 117

    private const val SIZE: Int = 34

    private val DESERIALIZER: MavDeserializer<WinchStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUint64()
      val lineLength = inputBuffer.decodeFloat()
      val speed = inputBuffer.decodeFloat()
      val tension = inputBuffer.decodeFloat()
      val voltage = inputBuffer.decodeFloat()
      val current = inputBuffer.decodeFloat()
      val status = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = MavWinchStatusFlag.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val temperature = inputBuffer.decodeInt16()

      WinchStatus(
        timeUsec = timeUsec,
        lineLength = lineLength,
        speed = speed,
        tension = tension,
        voltage = voltage,
        current = current,
        temperature = temperature,
        status = status,
      )
    }


    private val METADATA: MavMessage.Metadata<WinchStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<WinchStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: BigInteger = BigInteger.ZERO

    public var lineLength: Float = 0F

    public var speed: Float = 0F

    public var tension: Float = 0F

    public var voltage: Float = 0F

    public var current: Float = 0F

    public var temperature: Int = 0

    public var status: MavEnumValue<MavWinchStatusFlag> = MavEnumValue.fromValue(0)

    public fun build(): WinchStatus = WinchStatus(
      timeUsec = timeUsec,
      lineLength = lineLength,
      speed = speed,
      tension = tension,
      voltage = voltage,
      current = current,
      temperature = temperature,
      status = status,
    )
  }
}
