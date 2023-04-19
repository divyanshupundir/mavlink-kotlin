package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Request a list of available logs. On some systems calling this may stop on-board logging until
 * LOG_REQUEST_END is called. If there are no log files available this request shall be answered with
 * one LOG_ENTRY message with id = 0 and num_logs = 0.
 */
@GeneratedMavMessage(
  id = 117u,
  crcExtra = -128,
)
public data class LogRequestList(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * First log id (0 for first available)
   */
  @GeneratedMavField(type = "uint16_t")
  public val start: UShort = 0u,
  /**
   * Last log id (0xffff for last available)
   */
  @GeneratedMavField(type = "uint16_t")
  public val end: UShort = 0u,
) : MavMessage<LogRequestList> {
  public override val instanceMetadata: MavMessage.Metadata<LogRequestList> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(start)
    outputBuffer.encodeUInt16(end)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16(start)
    outputBuffer.encodeUInt16(end)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 117u

    private const val CRC_EXTRA: Byte = -128

    private const val SIZE_V1: Int = 6

    private const val SIZE_V2: Int = 6

    private val DESERIALIZER: MavDeserializer<LogRequestList> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val start = inputBuffer.decodeUInt16()
      val end = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()

      LogRequestList(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        start = start,
        end = end,
      )
    }


    private val METADATA: MavMessage.Metadata<LogRequestList> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<LogRequestList> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): LogRequestList =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var start: UShort = 0u

    public var end: UShort = 0u

    public fun build(): LogRequestList = LogRequestList(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      start = start,
      end = end,
    )
  }
}
