package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.api.WorkInProgress
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Current status about a high level gimbal manager. This message should be broadcast at a low
 * regular rate (e.g. 5Hz).
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 281,
  crc = 48,
)
public data class GimbalManagerStatus(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: Long = 0L,
  /**
   * High level gimbal manager flags currently applied.
   */
  @GeneratedMavField(type = "uint32_t")
  public val flags: MavEnumValue<GimbalManagerFlags> = MavEnumValue.fromValue(0),
  /**
   * Gimbal device ID that this gimbal manager is responsible for.
   */
  @GeneratedMavField(type = "uint8_t")
  public val gimbalDeviceId: Int = 0,
  /**
   * System ID of MAVLink component with primary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val primaryControlSysid: Int = 0,
  /**
   * Component ID of MAVLink component with primary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val primaryControlCompid: Int = 0,
  /**
   * System ID of MAVLink component with secondary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val secondaryControlSysid: Int = 0,
  /**
   * Component ID of MAVLink component with secondary control, 0 for none.
   */
  @GeneratedMavField(type = "uint8_t")
  public val secondaryControlCompid: Int = 0,
) : MavMessage<GimbalManagerStatus> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalManagerStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeEnumValue(flags.value, 4)
    outputBuffer.encodeUint8(gimbalDeviceId)
    outputBuffer.encodeUint8(primaryControlSysid)
    outputBuffer.encodeUint8(primaryControlCompid)
    outputBuffer.encodeUint8(secondaryControlSysid)
    outputBuffer.encodeUint8(secondaryControlCompid)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeEnumValue(flags.value, 4)
    outputBuffer.encodeUint8(gimbalDeviceId)
    outputBuffer.encodeUint8(primaryControlSysid)
    outputBuffer.encodeUint8(primaryControlCompid)
    outputBuffer.encodeUint8(secondaryControlSysid)
    outputBuffer.encodeUint8(secondaryControlCompid)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 281

    private const val CRC: Int = 48

    private const val SIZE: Int = 13

    private val DESERIALIZER: MavDeserializer<GimbalManagerStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val flags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = GimbalManagerFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val gimbalDeviceId = inputBuffer.decodeUint8()
      val primaryControlSysid = inputBuffer.decodeUint8()
      val primaryControlCompid = inputBuffer.decodeUint8()
      val secondaryControlSysid = inputBuffer.decodeUint8()
      val secondaryControlCompid = inputBuffer.decodeUint8()

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


    private val METADATA: MavMessage.Metadata<GimbalManagerStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalManagerStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: Long = 0L

    public var flags: MavEnumValue<GimbalManagerFlags> = MavEnumValue.fromValue(0)

    public var gimbalDeviceId: Int = 0

    public var primaryControlSysid: Int = 0

    public var primaryControlCompid: Int = 0

    public var secondaryControlSysid: Int = 0

    public var secondaryControlCompid: Int = 0

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
