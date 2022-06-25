package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavEnumValue
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeEnumValue
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeEnumValue
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * High level message to control a gimbal manually. The angles or angular rates are unitless; the
 * actual rates will depend on internal gimbal manager settings/configuration (e.g. set by parameters).
 * This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can
 * be set to NaN according to use case.
 */
public data class GimbalManagerSetManualControl(
  /**
   * High level gimbal manager flags.
   */
  public val flags: MavEnumValue<GimbalManagerFlags> = MavEnumValue.fromValue(0),
  /**
   * Pitch angle unitless (-1..1, positive: up, negative: down, NaN to be ignored).
   */
  public val pitch: Float = 0F,
  /**
   * Yaw angle unitless (-1..1, positive: to the right, negative: to the left, NaN to be ignored).
   */
  public val yaw: Float = 0F,
  /**
   * Pitch angular rate unitless (-1..1, positive: up, negative: down, NaN to be ignored).
   */
  public val pitchRate: Float = 0F,
  /**
   * Yaw angular rate unitless (-1..1, positive: to the right, negative: to the left, NaN to be
   * ignored).
   */
  public val yawRate: Float = 0F,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal
   * device components. Send command multiple times for more than one gimbal (but not all gimbals).
   */
  public val gimbalDeviceId: Int = 0,
) : MavMessage<GimbalManagerSetManualControl> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalManagerSetManualControl> =
      METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(23).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeEnumValue(flags.value, 4)
    outputBuffer.encodeFloat(pitch)
    outputBuffer.encodeFloat(yaw)
    outputBuffer.encodeFloat(pitchRate)
    outputBuffer.encodeFloat(yawRate)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(gimbalDeviceId)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 288

    private const val CRC: Int = 20

    private val DESERIALIZER: MavDeserializer<GimbalManagerSetManualControl> = MavDeserializer {
        bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val flags = inputBuffer.decodeEnumValue(4).let { value ->
        val entry = GimbalManagerFlags.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val pitch = inputBuffer.decodeFloat()
      val yaw = inputBuffer.decodeFloat()
      val pitchRate = inputBuffer.decodeFloat()
      val yawRate = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val gimbalDeviceId = inputBuffer.decodeUint8()
      GimbalManagerSetManualControl(
        flags = flags,
        pitch = pitch,
        yaw = yaw,
        pitchRate = pitchRate,
        yawRate = yawRate,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        gimbalDeviceId = gimbalDeviceId,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalManagerSetManualControl> =
        MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalManagerSetManualControl> = METADATA
  }
}
