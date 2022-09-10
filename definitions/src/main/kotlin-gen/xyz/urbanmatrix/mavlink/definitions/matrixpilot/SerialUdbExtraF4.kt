package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F4: format
 */
@GeneratedMavMessage(
  id = 172,
  crc = 191,
)
public data class SerialUdbExtraF4(
  /**
   * Serial UDB Extra Roll Stabilization with Ailerons Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRollStabilizationAilerons: Int = 0,
  /**
   * Serial UDB Extra Roll Stabilization with Rudder Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRollStabilizationRudder: Int = 0,
  /**
   * Serial UDB Extra Pitch Stabilization Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val suePitchStabilization: Int = 0,
  /**
   * Serial UDB Extra Yaw Stabilization using Rudder Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueYawStabilizationRudder: Int = 0,
  /**
   * Serial UDB Extra Yaw Stabilization using Ailerons Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueYawStabilizationAileron: Int = 0,
  /**
   * Serial UDB Extra Navigation with Ailerons Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAileronNavigation: Int = 0,
  /**
   * Serial UDB Extra Navigation with Rudder Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRudderNavigation: Int = 0,
  /**
   * Serial UDB Extra Type of Alitude Hold when in Stabilized Mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAltitudeholdStabilized: Int = 0,
  /**
   * Serial UDB Extra Type of Alitude Hold when in Waypoint Mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAltitudeholdWaypoint: Int = 0,
  /**
   * Serial UDB Extra Firmware racing mode enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRacingMode: Int = 0,
) : MavMessage<SerialUdbExtraF4> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF4> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
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

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
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
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 172

    private const val CRC: Int = 191

    private const val SIZE_V1: Int = 10

    private const val SIZE_V2: Int = 10

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

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueRollStabilizationAilerons: Int = 0

    public var sueRollStabilizationRudder: Int = 0

    public var suePitchStabilization: Int = 0

    public var sueYawStabilizationRudder: Int = 0

    public var sueYawStabilizationAileron: Int = 0

    public var sueAileronNavigation: Int = 0

    public var sueRudderNavigation: Int = 0

    public var sueAltitudeholdStabilized: Int = 0

    public var sueAltitudeholdWaypoint: Int = 0

    public var sueRacingMode: Int = 0

    public fun build(): SerialUdbExtraF4 = SerialUdbExtraF4(
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
}
