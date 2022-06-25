package com.urbanmatrix.mavlink.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.encodeFloat
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F18 format
 */
public data class SerialUdbExtraF18(
  /**
   * SUE Angle of Attack Normal
   */
  public val angleOfAttackNormal: Float = 0F,
  /**
   * SUE Angle of Attack Inverted
   */
  public val angleOfAttackInverted: Float = 0F,
  /**
   * SUE Elevator Trim Normal
   */
  public val elevatorTrimNormal: Float = 0F,
  /**
   * SUE Elevator Trim Inverted
   */
  public val elevatorTrimInverted: Float = 0F,
  /**
   * SUE reference_speed
   */
  public val referenceSpeed: Float = 0F,
) : MavMessage<SerialUdbExtraF18> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF18> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(20).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(angleOfAttackNormal)
    outputBuffer.encodeFloat(angleOfAttackInverted)
    outputBuffer.encodeFloat(elevatorTrimNormal)
    outputBuffer.encodeFloat(elevatorTrimInverted)
    outputBuffer.encodeFloat(referenceSpeed)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 184

    private const val CRC: Int = 41

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF18> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val angleOfAttackNormal = inputBuffer.decodeFloat()
      val angleOfAttackInverted = inputBuffer.decodeFloat()
      val elevatorTrimNormal = inputBuffer.decodeFloat()
      val elevatorTrimInverted = inputBuffer.decodeFloat()
      val referenceSpeed = inputBuffer.decodeFloat()
      SerialUdbExtraF18(
        angleOfAttackNormal = angleOfAttackNormal,
        angleOfAttackInverted = angleOfAttackInverted,
        elevatorTrimNormal = elevatorTrimNormal,
        elevatorTrimInverted = elevatorTrimInverted,
        referenceSpeed = referenceSpeed,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF18> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF18> = METADATA
  }
}
