package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeInt16Array
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16Array
import xyz.urbanmatrix.mavlink.serialization.decodeUInt32Array
import xyz.urbanmatrix.mavlink.serialization.decodeUInt64
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeInt16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt32Array
import xyz.urbanmatrix.mavlink.serialization.encodeUInt64
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * ESC information for lower rate streaming. Recommended streaming rate 1Hz. See ESC_STATUS for
 * higher-rate ESC data.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 290u,
  crcExtra = -5,
)
public data class EscInfo(
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
   * Counter of data packets received.
   */
  @GeneratedMavField(type = "uint16_t")
  public val counter: UShort = 0u,
  /**
   * Total number of ESCs in all messages of this type. Message fields with an index higher than
   * this should be ignored because they contain invalid data.
   */
  @GeneratedMavField(type = "uint8_t")
  public val count: UByte = 0u,
  /**
   * Connection type protocol for all ESC.
   */
  @GeneratedMavField(type = "uint8_t")
  public val connectionType: MavEnumValue<EscConnectionType> = MavEnumValue.fromValue(0u),
  /**
   * Information regarding online/offline status of each ESC.
   */
  @GeneratedMavField(type = "uint8_t")
  public val info: UByte = 0u,
  /**
   * Bitmap of ESC failure flags.
   */
  @GeneratedMavField(type = "uint16_t[4]")
  public val failureFlags: List<UShort> = emptyList(),
  /**
   * Number of reported errors by each ESC since boot.
   */
  @GeneratedMavField(type = "uint32_t[4]")
  public val errorCount: List<UInt> = emptyList(),
  /**
   * Temperature of each ESC. INT16_MAX: if data not supplied by ESC.
   */
  @GeneratedMavField(type = "int16_t[4]")
  public val temperature: List<Short> = emptyList(),
) : MavMessage<EscInfo> {
  public override val instanceMetadata: MavMessage.Metadata<EscInfo> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32Array(errorCount, 16)
    outputBuffer.encodeUInt16(counter)
    outputBuffer.encodeUInt16Array(failureFlags, 8)
    outputBuffer.encodeInt16Array(temperature, 8)
    outputBuffer.encodeUInt8(index)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeEnumValue(connectionType.value, 1)
    outputBuffer.encodeUInt8(info)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32Array(errorCount, 16)
    outputBuffer.encodeUInt16(counter)
    outputBuffer.encodeUInt16Array(failureFlags, 8)
    outputBuffer.encodeInt16Array(temperature, 8)
    outputBuffer.encodeUInt8(index)
    outputBuffer.encodeUInt8(count)
    outputBuffer.encodeEnumValue(connectionType.value, 1)
    outputBuffer.encodeUInt8(info)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 290u

    private const val CRC_EXTRA: Byte = -5

    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    private val DESERIALIZER: MavDeserializer<EscInfo> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val errorCount = inputBuffer.decodeUInt32Array(16)
      val counter = inputBuffer.decodeUInt16()
      val failureFlags = inputBuffer.decodeUInt16Array(8)
      val temperature = inputBuffer.decodeInt16Array(8)
      val index = inputBuffer.decodeUInt8()
      val count = inputBuffer.decodeUInt8()
      val connectionType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = EscConnectionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val info = inputBuffer.decodeUInt8()

      EscInfo(
        index = index,
        timeUsec = timeUsec,
        counter = counter,
        count = count,
        connectionType = connectionType,
        info = info,
        failureFlags = failureFlags,
        errorCount = errorCount,
        temperature = temperature,
      )
    }


    private val METADATA: MavMessage.Metadata<EscInfo> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<EscInfo> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): EscInfo =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var index: UByte = 0u

    public var timeUsec: ULong = 0uL

    public var counter: UShort = 0u

    public var count: UByte = 0u

    public var connectionType: MavEnumValue<EscConnectionType> = MavEnumValue.fromValue(0u)

    public var info: UByte = 0u

    public var failureFlags: List<UShort> = emptyList()

    public var errorCount: List<UInt> = emptyList()

    public var temperature: List<Short> = emptyList()

    public fun build(): EscInfo = EscInfo(
      index = index,
      timeUsec = timeUsec,
      counter = counter,
      count = count,
      connectionType = connectionType,
      info = info,
      failureFlags = failureFlags,
      errorCount = errorCount,
      temperature = temperature,
    )
  }
}
