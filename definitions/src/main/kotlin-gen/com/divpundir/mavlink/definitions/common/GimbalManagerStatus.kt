package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.decodeBitmaskValue
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low
 * regular rate (e.g. 5Hz).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 281u,
  crcExtra = 48,
)
public data class GimbalManagerStatus(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * High level gimbal manager flags currently applied.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Gimbal device ID that this gimbal manager is responsible for.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: UByte = 0u,
  /**
   * System ID of MAVLink component with primary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val primaryControlSysid: UByte = 0u,
  /**
   * Component ID of MAVLink component with primary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val primaryControlCompid: UByte = 0u,
  /**
   * System ID of MAVLink component with secondary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val secondaryControlSysid: UByte = 0u,
  /**
   * Component ID of MAVLink component with secondary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val secondaryControlCompid: UByte = 0u,
) : MavMessage<GimbalManagerStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalManagerStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeBitmaskValue(flags.value, 4)
    outputBuffer.encodeUInt8(gimbalDeviceId)
    outputBuffer.encodeUInt8(primaryControlSysid)
    outputBuffer.encodeUInt8(primaryControlCompid)
    outputBuffer.encodeUInt8(secondaryControlSysid)
    outputBuffer.encodeUInt8(secondaryControlCompid)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt32(timeBootMs)
    outputBuffer.encodeBitmaskValue(flags.value, 4)
    outputBuffer.encodeUInt8(gimbalDeviceId)
    outputBuffer.encodeUInt8(primaryControlSysid)
    outputBuffer.encodeUInt8(primaryControlCompid)
    outputBuffer.encodeUInt8(secondaryControlSysid)
    outputBuffer.encodeUInt8(secondaryControlCompid)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 281u

    private const val CRC_EXTRA: Byte = 48

    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    private val DESERIALIZER: MavDeserializer<GimbalManagerStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUInt32()
      val flags = inputBuffer.decodeBitmaskValue(4).let { value ->
        val flags = GimbalManagerFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val gimbalDeviceId = inputBuffer.decodeUInt8()
      val primaryControlSysid = inputBuffer.decodeUInt8()
      val primaryControlCompid = inputBuffer.decodeUInt8()
      val secondaryControlSysid = inputBuffer.decodeUInt8()
      val secondaryControlCompid = inputBuffer.decodeUInt8()

      GimbalManagerStatus(
        timeBootMs = timeBootMs,
        flags = flags,
        gimbalDeviceId = gimbalDeviceId,
        primaryControlSysid = primaryControlSysid,
        primaryControlCompid = primaryControlCompid,
        secondaryControlSysid = secondaryControlSysid,
        secondaryControlCompid = secondaryControlCompid,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalManagerStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalManagerStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): GimbalManagerStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var flags: MavBitmaskValue<GimbalManagerFlags> = MavBitmaskValue.fromValue(0u)

    public var gimbalDeviceId: UByte = 0u

    public var primaryControlSysid: UByte = 0u

    public var primaryControlCompid: UByte = 0u

    public var secondaryControlSysid: UByte = 0u

    public var secondaryControlCompid: UByte = 0u

    public fun build(): GimbalManagerStatus = GimbalManagerStatus(
      timeBootMs = timeBootMs,
      flags = flags,
      gimbalDeviceId = gimbalDeviceId,
      primaryControlSysid = primaryControlSysid,
      primaryControlCompid = primaryControlCompid,
      secondaryControlSysid = secondaryControlSysid,
      secondaryControlCompid = secondaryControlCompid,
    )
  }
}
