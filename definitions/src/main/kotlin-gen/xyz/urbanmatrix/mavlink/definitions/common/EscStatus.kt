package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.decodeInt32Array
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeFloatArray
import xyz.urbanmatrix.mavlink.serialization.encodeInt32Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * ESC information for higher rate streaming. Recommended streaming rate is ~10 Hz. Information that
 * changes more slowly is sent in ESC_INFO. It should typically only be streamed on high-bandwidth
 * links (i.e. to a companion computer).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 291u,
  crcExtra = 10,
)
public data class EscStatus(
  /**
   * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4.
   */
  @GeneratedMavField(type = "uint8_t")
  public val index: UByte = 0u,
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Reported motor RPM from each ESC (negative for reverse rotation).
   */
  @GeneratedMavField(type = "int32_t[4]")
  public val rpm: List<Int> = emptyList(),
  /**
   * Voltage measured from each ESC.
   */
  @GeneratedMavField(type = "float[4]")
  public val voltage: List<Float> = emptyList(),
  /**
   * Current measured from each ESC.
   */
  @GeneratedMavField(type = "float[4]")
  public val current: List<Float> = emptyList(),
) : MavMessage<EscStatus> {
  public override val instanceMetadata: MavMessage.Metadata<EscStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeInt32Array(rpm, 16)
    outputBuffer.encodeFloatArray(voltage, 16)
    outputBuffer.encodeFloatArray(current, 16)
    outputBuffer.encodeUInt8(index)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeInt32Array(rpm, 16)
    outputBuffer.encodeFloatArray(voltage, 16)
    outputBuffer.encodeFloatArray(current, 16)
    outputBuffer.encodeUInt8(index)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 291u

    private const val CRC_EXTRA: Byte = 10

    private const val SIZE_V1: Int = 57

    private const val SIZE_V2: Int = 57

    private val DESERIALIZER: MavDeserializer<EscStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val rpm = inputBuffer.decodeInt32Array(16)
      val voltage = inputBuffer.decodeFloatArray(16)
      val current = inputBuffer.decodeFloatArray(16)
      val index = inputBuffer.decodeUInt8()

      EscStatus(
        index = index,
        timeUsec = timeUsec,
        rpm = rpm,
        voltage = voltage,
        current = current,
      )
    }


    private val METADATA: MavMessage.Metadata<EscStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): EscStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var index: UByte = 0u

    public var timeUsec: ULong = 0uL

    public var rpm: List<Int> = emptyList()

    public var voltage: List<Float> = emptyList()

    public var current: List<Float> = emptyList()

    public fun build(): EscStatus = EscStatus(
      index = index,
      timeUsec = timeUsec,
      rpm = rpm,
      voltage = voltage,
      current = current,
    )
  }
}
