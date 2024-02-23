package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
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
 *
 * @param timeUsec Timestamp (UNIX Epoch time or time since system boot). The receiving end can
 * infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the
 * number.
 * units = us
 * @param uptimeSec Time since the start-up of the node.
 * units = s
 * @param health Generalized node health status.
 * @param mode Generalized operating mode.
 * @param subMode Not used currently.
 * @param vendorSpecificStatusCode Vendor-specific status information.
 */
@GeneratedMavMessage(
  id = 310u,
  crcExtra = 28,
)
public data class UavcanNodeStatus(
  /**
   * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp
   * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number.
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Time since the start-up of the node.
   * units = s
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
  override val instanceCompanion: MavMessage.MavCompanion<UavcanNodeStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(uptimeSec)
    encoder.encodeUInt16(vendorSpecificStatusCode)
    encoder.encodeEnumValue(health.value, 1)
    encoder.encodeEnumValue(mode.value, 1)
    encoder.encodeUInt8(subMode)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(uptimeSec)
    encoder.encodeUInt16(vendorSpecificStatusCode)
    encoder.encodeEnumValue(health.value, 1)
    encoder.encodeEnumValue(mode.value, 1)
    encoder.encodeUInt8(subMode)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<UavcanNodeStatus> {
    private const val SIZE_V1: Int = 17

    private const val SIZE_V2: Int = 17

    override val id: UInt = 310u

    override val crcExtra: Byte = 28

    override fun deserialize(bytes: ByteArray): UavcanNodeStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val uptimeSec = decoder.safeDecodeUInt32()
      val vendorSpecificStatusCode = decoder.safeDecodeUInt16()
      val health = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UavcanNodeHealth.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = UavcanNodeMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val subMode = decoder.safeDecodeUInt8()

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
