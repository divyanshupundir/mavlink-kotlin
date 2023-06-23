package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
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
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<UavcanNodeStatus> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(uptimeSec)
    output.encodeUInt16(vendorSpecificStatusCode)
    output.encodeEnumValue(health.value, 1)
    output.encodeEnumValue(mode.value, 1)
    output.encodeUInt8(subMode)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt64(timeUsec)
    output.encodeUInt32(uptimeSec)
    output.encodeUInt16(vendorSpecificStatusCode)
    output.encodeEnumValue(health.value, 1)
    output.encodeEnumValue(mode.value, 1)
    output.encodeUInt8(subMode)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<UavcanNodeStatus> {
    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    public override val id: UInt = 310u

    public override val crcExtra: Byte = 28

    public override fun deserialize(source: BufferedSource): UavcanNodeStatus {
      val timeUsec = source.decodeUInt64()
      val uptimeSec = source.decodeUInt32()
      val vendorSpecificStatusCode = source.decodeUInt16()
      val health = source.decodeEnumValue(1).let { value ->
        val entry = UavcanNodeHealth.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mode = source.decodeEnumValue(1).let { value ->
        val entry = UavcanNodeMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val subMode = source.decodeUInt8()

      return UavcanNodeStatus(
        timeUsec = timeUsec,
        uptimeSec = uptimeSec,
        health = health,
        mode = mode,
        subMode = subMode,
        vendorSpecificStatusCode = vendorSpecificStatusCode,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): UavcanNodeStatus =
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
