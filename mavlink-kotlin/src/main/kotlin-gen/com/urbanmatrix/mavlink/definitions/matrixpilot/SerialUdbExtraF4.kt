package com.urbanmatrix.mavlink.definitions.matrixpilot

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F4: format
 */
public data class SerialUdbExtraF4(
  /**
   * Serial UDB Extra Roll Stabilization with Ailerons Enabled
   */
  public val sueRollStabilizationAilerons: Int = 0,
  /**
   * Serial UDB Extra Roll Stabilization with Rudder Enabled
   */
  public val sueRollStabilizationRudder: Int = 0,
  /**
   * Serial UDB Extra Pitch Stabilization Enabled
   */
  public val suePitchStabilization: Int = 0,
  /**
   * Serial UDB Extra Yaw Stabilization using Rudder Enabled
   */
  public val sueYawStabilizationRudder: Int = 0,
  /**
   * Serial UDB Extra Yaw Stabilization using Ailerons Enabled
   */
  public val sueYawStabilizationAileron: Int = 0,
  /**
   * Serial UDB Extra Navigation with Ailerons Enabled
   */
  public val sueAileronNavigation: Int = 0,
  /**
   * Serial UDB Extra Navigation with Rudder Enabled
   */
  public val sueRudderNavigation: Int = 0,
  /**
   * Serial UDB Extra Type of Alitude Hold when in Stabilized Mode
   */
  public val sueAltitudeholdStabilized: Int = 0,
  /**
   * Serial UDB Extra Type of Alitude Hold when in Waypoint Mode
   */
  public val sueAltitudeholdWaypoint: Int = 0,
  /**
   * Serial UDB Extra Firmware racing mode enabled
   */
  public val sueRacingMode: Int = 0,
) : MavMessage<SerialUdbExtraF4> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF4> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(sueRollStabilizationAilerons)
    outputBuffer.encodeUint8(sueRollStabilizationRudder)
    outputBuffer.encodeUint8(suePitchStabilization)
    outputBuffer.encodeUint8(sueYawStabilizationRudder)
    outputBuffer.encodeUint8(sueYawStabilizationAileron)
    outputBuffer.encodeUint8(sueAileronNavigation)
    outputBuffer.encodeUint8(sueRudderNavigation)
    outputBuffer.encodeUint8(sueAltitudeholdStabilized)
    outputBuffer.encodeUint8(sueAltitudeholdWaypoint)
    outputBuffer.encodeUint8(sueRacingMode)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 172

    private const val CRC: Int = 191

    private const val SIZE: Int = 10

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF4> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueRollStabilizationAilerons = inputBuffer.decodeUint8()
      val sueRollStabilizationRudder = inputBuffer.decodeUint8()
      val suePitchStabilization = inputBuffer.decodeUint8()
      val sueYawStabilizationRudder = inputBuffer.decodeUint8()
      val sueYawStabilizationAileron = inputBuffer.decodeUint8()
      val sueAileronNavigation = inputBuffer.decodeUint8()
      val sueRudderNavigation = inputBuffer.decodeUint8()
      val sueAltitudeholdStabilized = inputBuffer.decodeUint8()
      val sueAltitudeholdWaypoint = inputBuffer.decodeUint8()
      val sueRacingMode = inputBuffer.decodeUint8()

      SerialUdbExtraF4(
        sueRollStabilizationAilerons = sueRollStabilizationAilerons,
        sueRollStabilizationRudder = sueRollStabilizationRudder,
        suePitchStabilization = suePitchStabilization,
        sueYawStabilizationRudder = sueYawStabilizationRudder,
        sueYawStabilizationAileron = sueYawStabilizationAileron,
        sueAileronNavigation = sueAileronNavigation,
        sueRudderNavigation = sueRudderNavigation,
        sueAltitudeholdStabilized = sueAltitudeholdStabilized,
        sueAltitudeholdWaypoint = sueAltitudeholdWaypoint,
        sueRacingMode = sueRacingMode,
      )
    }


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF4> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF4> = METADATA
  }
}
