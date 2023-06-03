package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List

/**
 * Complete set of calibration parameters for the radio
 */
@GeneratedMavMessage(
  id = 221u,
  crcExtra = 71,
)
public data class RadioCalibration(
  /**
   * Aileron setpoints: left, center, right
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val aileron: List<UShort> = emptyList(),
  /**
   * Elevator setpoints: nose down, center, nose up
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val elevator: List<UShort> = emptyList(),
  /**
   * Rudder setpoints: nose left, center, nose right
   */
  @GeneratedMavField(type = "uint16_t[3]")
  public val rudder: List<UShort> = emptyList(),
  /**
   * Tail gyro mode/gain setpoints: heading hold, rate mode
   */
  @GeneratedMavField(type = "uint16_t[2]")
  public val gyro: List<UShort> = emptyList(),
  /**
   * Pitch curve setpoints (every 25%)
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val pitch: List<UShort> = emptyList(),
  /**
   * Throttle curve setpoints (every 25%)
   */
  @GeneratedMavField(type = "uint16_t[5]")
  public val throttle: List<UShort> = emptyList(),
) : MavMessage<RadioCalibration> {
  public override val instanceCompanion: MavMessage.MavCompanion<RadioCalibration> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16Array(aileron, 6)
    outputBuffer.encodeUInt16Array(elevator, 6)
    outputBuffer.encodeUInt16Array(rudder, 6)
    outputBuffer.encodeUInt16Array(gyro, 4)
    outputBuffer.encodeUInt16Array(pitch, 10)
    outputBuffer.encodeUInt16Array(throttle, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt16Array(aileron, 6)
    outputBuffer.encodeUInt16Array(elevator, 6)
    outputBuffer.encodeUInt16Array(rudder, 6)
    outputBuffer.encodeUInt16Array(gyro, 4)
    outputBuffer.encodeUInt16Array(pitch, 10)
    outputBuffer.encodeUInt16Array(throttle, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RadioCalibration> {
    private const val SIZE_V1: Int = 42

    private const val SIZE_V2: Int = 42

    public override val id: UInt = 221u

    public override val crcExtra: Byte = 71

    public override fun deserialize(bytes: ByteArray): RadioCalibration {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val aileron = inputBuffer.decodeUInt16Array(6)
      val elevator = inputBuffer.decodeUInt16Array(6)
      val rudder = inputBuffer.decodeUInt16Array(6)
      val gyro = inputBuffer.decodeUInt16Array(4)
      val pitch = inputBuffer.decodeUInt16Array(10)
      val throttle = inputBuffer.decodeUInt16Array(10)

      return RadioCalibration(
        aileron = aileron,
        elevator = elevator,
        rudder = rudder,
        gyro = gyro,
        pitch = pitch,
        throttle = throttle,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RadioCalibration =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var aileron: List<UShort> = emptyList()

    public var elevator: List<UShort> = emptyList()

    public var rudder: List<UShort> = emptyList()

    public var gyro: List<UShort> = emptyList()

    public var pitch: List<UShort> = emptyList()

    public var throttle: List<UShort> = emptyList()

    public fun build(): RadioCalibration = RadioCalibration(
      aileron = aileron,
      elevator = elevator,
      rudder = rudder,
      gyro = gyro,
      pitch = pitch,
      throttle = throttle,
    )
  }
}
