package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeInt16Array
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.decodeUInt32Array
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeInt16Array
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt32Array
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<EscInfo> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32Array(errorCount, 16)
    output.encodeUInt16(counter)
    output.encodeUInt16Array(failureFlags, 8)
    output.encodeInt16Array(temperature, 8)
    output.encodeUInt8(index)
    output.encodeUInt8(count)
    output.encodeEnumValue(connectionType.value, 1)
    output.encodeUInt8(info)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32Array(errorCount, 16)
    output.encodeUInt16(counter)
    output.encodeUInt16Array(failureFlags, 8)
    output.encodeInt16Array(temperature, 8)
    output.encodeUInt8(index)
    output.encodeUInt8(count)
    output.encodeEnumValue(connectionType.value, 1)
    output.encodeUInt8(info)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<EscInfo> {
    private const val SIZE_V1: Int = 46

    private const val SIZE_V2: Int = 46

    public override val id: UInt = 290u

    public override val crcExtra: Byte = -5

    public override fun deserialize(source: BufferedSource): EscInfo {
      val timeUsec = source.decodeUInt64()
      val errorCount = source.decodeUInt32Array(16)
      val counter = source.decodeUInt16()
      val failureFlags = source.decodeUInt16Array(8)
      val temperature = source.decodeInt16Array(8)
      val index = source.decodeUInt8()
      val count = source.decodeUInt8()
      val connectionType = source.decodeEnumValue(1).let { value ->
        val entry = EscConnectionType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val info = source.decodeUInt8()

      return EscInfo(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): EscInfo =
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
