package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint32
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint32
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Long

/**
 * Setpoint in roll, pitch, yaw and thrust from the operator
 */
public data class ManualSetpoint(
  /**
   * Timestamp (time since system boot).
   */
  public val timeBootMs: Long = 0L,
  /**
   * Desired roll rate
   */
  public val roll: Float = 0F,
  /**
   * Desired pitch rate
   */
  public val pitch: Float = 0F,
  /**
   * Desired yaw rate
   */
  public val yaw: Float = 0F,
  /**
   * Collective thrust, normalized to 0 .. 1
   */
  public val thrust: Float = 0F,
  /**
   * Flight mode switch position, 0.. 255
   */
  public val modeSwitch: Int = 0,
  /**
   * Override mode switch position, 0.. 255
   */
  public val manualOverrideSwitch: Int = 0,
) : MavMessage<ManualSetpoint> {
  public override val instanceMetadata: MavMessage.Metadata<ManualSetpoint> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(22).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(timeBootMs)
    outputBuffer.encodeFloat(roll)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(thrust)
    outputBuffer.encodeUint8(modeSwitch)
    outputBuffer.encodeUint8(manualOverrideSwitch)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 81

    private const val CRC: Int = 106

    private val DESERIALIZER: MavDeserializer<ManualSetpoint> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val timeBootMs = inputBuffer.decodeUint32()
      val roll = inputBuffer.decodeFloat()
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val thrust = inputBuffer.decodeFloat()
      val modeSwitch = inputBuffer.decodeUint8()
      val manualOverrideSwitch = inputBuffer.decodeUint8()
      ManualSetpoint(
        timeBootMs = timeBootMs,
        roll = roll,
        pitch = pitch,
        yaw = yaw,
        thrust = thrust,
        modeSwitch = modeSwitch,
        manualOverrideSwitch = manualOverrideSwitch,
      )
    }


    private val METADATA: MavMessage.Metadata<ManualSetpoint> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ManualSetpoint> = METADATA
  }
}
