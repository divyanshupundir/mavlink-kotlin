package com.urbanmatrix.mavlink.definitions.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * 3 axis gimbal measurements.
 */
public data class GimbalReport(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * Time since last update.
   */
  public val deltaTime: Float = 0F,
  /**
   * Delta angle X.
   */
  public val deltaAngleX: Float = 0F,
  /**
   * Delta angle Y.
   */
  public val deltaAngleY: Float = 0F,
  /**
   * Delta angle X.
   */
  public val deltaAngleZ: Float = 0F,
  /**
   * Delta velocity X.
   */
  public val deltaVelocityX: Float = 0F,
  /**
   * Delta velocity Y.
   */
  public val deltaVelocityY: Float = 0F,
  /**
   * Delta velocity Z.
   */
  public val deltaVelocityZ: Float = 0F,
  /**
   * Joint ROLL.
   */
  public val jointRoll: Float = 0F,
  /**
   * Joint EL.
   */
  public val jointEl: Float = 0F,
  /**
   * Joint AZ.
   */
  public val jointAz: Float = 0F,
) : MavMessage<GimbalReport> {
  public override val instanceMetadata: MavMessage.Metadata<GimbalReport> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(deltaTime)
    outputBuffer.encodeFloat(deltaAngleX)
    outputBuffer.encodeFloat(deltaAngleY)
    outputBuffer.encodeFloat(deltaAngleZ)
    outputBuffer.encodeFloat(deltaVelocityX)
    outputBuffer.encodeFloat(deltaVelocityY)
    outputBuffer.encodeFloat(deltaVelocityZ)
    outputBuffer.encodeFloat(jointRoll)
    outputBuffer.encodeFloat(jointEl)
    outputBuffer.encodeFloat(jointAz)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 200

    private const val CRC: Int = 134

    private const val SIZE: Int = 42

    private val DESERIALIZER: MavDeserializer<GimbalReport> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val deltaTime = inputBuffer.decodeFloat()
      val deltaAngleX = inputBuffer.decodeFloat()
      val deltaAngleY = inputBuffer.decodeFloat()
      val deltaAngleZ = inputBuffer.decodeFloat()
      val deltaVelocityX = inputBuffer.decodeFloat()
      val deltaVelocityY = inputBuffer.decodeFloat()
      val deltaVelocityZ = inputBuffer.decodeFloat()
      val jointRoll = inputBuffer.decodeFloat()
      val jointEl = inputBuffer.decodeFloat()
      val jointAz = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()

      GimbalReport(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        deltaTime = deltaTime,
        deltaAngleX = deltaAngleX,
        deltaAngleY = deltaAngleY,
        deltaAngleZ = deltaAngleZ,
        deltaVelocityX = deltaVelocityX,
        deltaVelocityY = deltaVelocityY,
        deltaVelocityZ = deltaVelocityZ,
        jointRoll = jointRoll,
        jointEl = jointEl,
        jointAz = jointAz,
      )
    }


    private val METADATA: MavMessage.Metadata<GimbalReport> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GimbalReport> = METADATA
  }
}
