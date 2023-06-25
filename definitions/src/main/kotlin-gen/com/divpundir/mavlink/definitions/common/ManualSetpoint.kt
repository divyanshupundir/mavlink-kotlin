package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt32
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Setpoint in roll, pitch, yaw and thrust from the operator
 */
@GeneratedMavMessage(
  id = 81u,
  crcExtra = 106,
)
public data class ManualSetpoint(
  /**
   * Timestamp (time since system boot).
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Desired roll rate
   */
  @GeneratedMavField(type = "float")
  public val roll: Float = 0F,
  /**
   * Desired pitch rate
   */
  @GeneratedMavField(type = "float")
  public val pitch: Float = 0F,
  /**
   * Desired yaw rate
   */
  @GeneratedMavField(type = "float")
  public val yaw: Float = 0F,
  /**
   * Collective thrust, normalized to 0 .. 1
   */
  @GeneratedMavField(type = "float")
  public val thrust: Float = 0F,
  /**
   * Flight mode switch position, 0.. 255
   */
  @GeneratedMavField(type = "uint8_t")
  public val modeSwitch: UByte = 0u,
  /**
   * Override mode switch position, 0.. 255
   */
  @GeneratedMavField(type = "uint8_t")
  public val manualOverrideSwitch: UByte = 0u,
) : MavMessage<ManualSetpoint> {
  public override val instanceCompanion: MavMessage.MavCompanion<ManualSetpoint> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(thrust)
    buffer.encodeUInt8(modeSwitch)
    buffer.encodeUInt8(manualOverrideSwitch)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt32(timeBootMs)
    buffer.encodeFloat(roll)
    buffer.encodeFloat(pitch)
    buffer.encodeFloat(yaw)
    buffer.encodeFloat(thrust)
    buffer.encodeUInt8(modeSwitch)
    buffer.encodeUInt8(manualOverrideSwitch)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ManualSetpoint> {
    public override val id: UInt = 81u

    public override val crcExtra: Byte = 106

    public override fun deserialize(bytes: ByteArray): ManualSetpoint {
      val buffer = Buffer().write(bytes)

      val timeBootMs = buffer.decodeUInt32()
      val roll = buffer.decodeFloat()
      val pitch = buffer.decodeFloat()
      val yaw = buffer.decodeFloat()
      val thrust = buffer.decodeFloat()
      val modeSwitch = buffer.decodeUInt8()
      val manualOverrideSwitch = buffer.decodeUInt8()

      return ManualSetpoint(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        thrust = thrust,
        modeSwitch = modeSwitch,
        manualOverrideSwitch = manualOverrideSwitch,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ManualSetpoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var roll: Float = 0F

    public var pitch: Float = 0F

    public var yaw: Float = 0F

    public var thrust: Float = 0F

    public var modeSwitch: UByte = 0u

    public var manualOverrideSwitch: UByte = 0u

    public fun build(): ManualSetpoint = ManualSetpoint(
      timeBootMs = timeBootMs,
      roll = roll,
      pitch = pitch,
      yaw = yaw,
      thrust = thrust,
      modeSwitch = modeSwitch,
      manualOverrideSwitch = manualOverrideSwitch,
    )
  }
}
