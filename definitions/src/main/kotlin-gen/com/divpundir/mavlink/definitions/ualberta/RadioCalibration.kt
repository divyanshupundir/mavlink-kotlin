package com.divpundir.mavlink.definitions.ualberta

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt16Array
import com.divpundir.mavlink.serialization.encodeUInt16Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

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
    val buffer = Buffer()
    buffer.encodeUInt16Array(aileron, 6)
    buffer.encodeUInt16Array(elevator, 6)
    buffer.encodeUInt16Array(rudder, 6)
    buffer.encodeUInt16Array(gyro, 4)
    buffer.encodeUInt16Array(pitch, 10)
    buffer.encodeUInt16Array(throttle, 10)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt16Array(aileron, 6)
    buffer.encodeUInt16Array(elevator, 6)
    buffer.encodeUInt16Array(rudder, 6)
    buffer.encodeUInt16Array(gyro, 4)
    buffer.encodeUInt16Array(pitch, 10)
    buffer.encodeUInt16Array(throttle, 10)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RadioCalibration> {
    public override val id: UInt = 221u

    public override val crcExtra: Byte = 71

    public override fun deserialize(bytes: ByteArray): RadioCalibration {
      val buffer = Buffer().write(bytes)

      val aileron = buffer.decodeUInt16Array(6)
      val elevator = buffer.decodeUInt16Array(6)
      val rudder = buffer.decodeUInt16Array(6)
      val gyro = buffer.decodeUInt16Array(4)
      val pitch = buffer.decodeUInt16Array(10)
      val throttle = buffer.decodeUInt16Array(10)

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
