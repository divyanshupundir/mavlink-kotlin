package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message
 * supersedes SERVO_OUTPUT_RAW.
 *
 * @param timeUsec Timestamp (since system boot).
 * units = us
 * @param active Active outputs
 * @param actuator Servo / motor output array values. Zero values indicate unused channels.
 */
@GeneratedMavMessage(
  id = 375u,
  crcExtra = -5,
)
public data class ActuatorOutputStatus(
  /**
   * Timestamp (since system boot).
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeUsec: ULong = 0uL,
  /**
   * Active outputs
   */
  @GeneratedMavField(type = "uint32_t")
  public val active: UInt = 0u,
  /**
   * Servo / motor output array values. Zero values indicate unused channels.
   */
  @GeneratedMavField(type = "float[32]")
  public val actuator: List<Float> = emptyList(),
) : MavMessage<ActuatorOutputStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<ActuatorOutputStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(active)
    encoder.encodeFloatArray(actuator, 128)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeUsec)
    encoder.encodeUInt32(active)
    encoder.encodeFloatArray(actuator, 128)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ActuatorOutputStatus> {
    private const val SIZE_V1: Int = 140

    private const val SIZE_V2: Int = 140

    override val id: UInt = 375u

    override val crcExtra: Byte = -5

    override fun deserialize(bytes: ByteArray): ActuatorOutputStatus {
      val decoder = MavDataDecoder(bytes)

      val timeUsec = decoder.safeDecodeUInt64()
      val active = decoder.safeDecodeUInt32()
      val actuator = decoder.safeDecodeFloatArray(128)

      return ActuatorOutputStatus(
        timeUsec = timeUsec,
        active = active,
        actuator = actuator,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ActuatorOutputStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeUsec: ULong = 0uL

    public var active: UInt = 0u

    public var actuator: List<Float> = emptyList()

    public fun build(): ActuatorOutputStatus = ActuatorOutputStatus(
      timeUsec = timeUsec,
      active = active,
      actuator = actuator,
    )
  }
}
