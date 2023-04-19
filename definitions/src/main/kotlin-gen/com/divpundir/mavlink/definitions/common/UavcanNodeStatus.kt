package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt64
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit

/**
 * General status information of an UAVCAN node. Please refer to the definition of the UAVCAN
 * message "uavcan.protocol.NodeStatus" for the background information. The UAVCAN specification is
 * available at http://uavcan.org.
 */
@GeneratedMavMessage(
  id = 310u,
  crcExtra = 28,
)
public data class UavcanNodeStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since the start-up of the node.
   */
  @GeneratedMavField(type = "uint32_t")
  public val uptimeSec: UInt = 0u,
  /**
   * Generalized node health status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val health: MavEnumValue<UavcanNodeHealth> = MavEnumValue.fromValue(0u),
  /**
   * Generalized operating mode.
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: MavEnumValue<UavcanNodeMode> = MavEnumValue.fromValue(0u),
  /**
   * Not used currently.
   */
  @GeneratedMavField(type = "uint8_t")
  public val subMode: UByte = 0u,
  /**
   * Vendor-specific status information.
   */
  @GeneratedMavField(type = "uint16_t")
  public val vendorSpecificStatusCode: UShort = 0u,
) : MavMessage<UavcanNodeStatus> {
  public override val instanceMetadata: MavMessage.Metadata<UavcanNodeStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(uptimeSec)
    outputBuffer.encodeUInt16(vendorSpecificStatusCode)
    outputBuffer.encodeEnumValue(health.value, 1)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeUInt8(subMode)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt64(timeUsec)
    outputBuffer.encodeUInt32(uptimeSec)
    outputBuffer.encodeUInt16(vendorSpecificStatusCode)
    outputBuffer.encodeEnumValue(health.value, 1)
    outputBuffer.encodeEnumValue(mode.value, 1)
    outputBuffer.encodeUInt8(subMode)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 310u

    private const val CRC_EXTRA: Byte = 28

    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    private val DESERIALIZER: MavDeserializer<UavcanNodeStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeUsec = inputBuffer.decodeUInt64()
      val uptimeSec = inputBuffer.decodeUInt32()
      val vendorSpecificStatusCode = inputBuffer.decodeUInt16()
      val health = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavcanNodeHealth.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mode = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = UavcanNodeMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val subMode = inputBuffer.decodeUInt8()

      UavcanNodeStatus(
        timeUsec = timeUsec,
        uptimeSec = uptimeSec,
        health = health,
        mode = mode,
        subMode = subMode,
        vendorSpecificStatusCode = vendorSpecificStatusCode,
      )
    }


    private val METADATA: MavMessage.Metadata<UavcanNodeStatus> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UavcanNodeStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): UavcanNodeStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var uptimeSec: UInt = 0u

    public var health: MavEnumValue<UavcanNodeHealth> = MavEnumValue.fromValue(0u)

    public var mode: MavEnumValue<UavcanNodeMode> = MavEnumValue.fromValue(0u)

    public var subMode: UByte = 0u

    public var vendorSpecificStatusCode: UShort = 0u

    public fun build(): UavcanNodeStatus = UavcanNodeStatus(
      timeUsec = timeUsec,
      uptimeSec = uptimeSec,
      health = health,
      mode = mode,
      subMode = subMode,
      vendorSpecificStatusCode = vendorSpecificStatusCode,
    )
  }
}
