package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F4: format
 */
@GeneratedMavMessage(
  id = 172u,
  crcExtra = -65,
)
public data class SerialUdbExtraF4(
  /**
   * Serial UDB Extra Roll Stabilization with Ailerons Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRollStabilizationAilerons: UByte = 0u,
  /**
   * Serial UDB Extra Roll Stabilization with Rudder Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRollStabilizationRudder: UByte = 0u,
  /**
   * Serial UDB Extra Pitch Stabilization Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val suePitchStabilization: UByte = 0u,
  /**
   * Serial UDB Extra Yaw Stabilization using Rudder Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueYawStabilizationRudder: UByte = 0u,
  /**
   * Serial UDB Extra Yaw Stabilization using Ailerons Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueYawStabilizationAileron: UByte = 0u,
  /**
   * Serial UDB Extra Navigation with Ailerons Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAileronNavigation: UByte = 0u,
  /**
   * Serial UDB Extra Navigation with Rudder Enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRudderNavigation: UByte = 0u,
  /**
   * Serial UDB Extra Type of Alitude Hold when in Stabilized Mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAltitudeholdStabilized: UByte = 0u,
  /**
   * Serial UDB Extra Type of Alitude Hold when in Waypoint Mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueAltitudeholdWaypoint: UByte = 0u,
  /**
   * Serial UDB Extra Firmware racing mode enabled
   */
  @GeneratedMavField(type = "uint8_t")
  public val sueRacingMode: UByte = 0u,
) : MavMessage<SerialUdbExtraF4> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF4> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(sueRollStabilizationAilerons)
    output.encodeUInt8(sueRollStabilizationRudder)
    output.encodeUInt8(suePitchStabilization)
    output.encodeUInt8(sueYawStabilizationRudder)
    output.encodeUInt8(sueYawStabilizationAileron)
    output.encodeUInt8(sueAileronNavigation)
    output.encodeUInt8(sueRudderNavigation)
    output.encodeUInt8(sueAltitudeholdStabilized)
    output.encodeUInt8(sueAltitudeholdWaypoint)
    output.encodeUInt8(sueRacingMode)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeUInt8(sueRollStabilizationAilerons)
    output.encodeUInt8(sueRollStabilizationRudder)
    output.encodeUInt8(suePitchStabilization)
    output.encodeUInt8(sueYawStabilizationRudder)
    output.encodeUInt8(sueYawStabilizationAileron)
    output.encodeUInt8(sueAileronNavigation)
    output.encodeUInt8(sueRudderNavigation)
    output.encodeUInt8(sueAltitudeholdStabilized)
    output.encodeUInt8(sueAltitudeholdWaypoint)
    output.encodeUInt8(sueRacingMode)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF4> {
    private const val SIZE_V1: Int = 10

    private const val SIZE_V2: Int = 10

    public override val id: UInt = 172u

    public override val crcExtra: Byte = -65

    public override fun deserialize(source: BufferedSource): SerialUdbExtraF4 {
      val sueRollStabilizationAilerons = source.decodeUInt8()
      val sueRollStabilizationRudder = source.decodeUInt8()
      val suePitchStabilization = source.decodeUInt8()
      val sueYawStabilizationRudder = source.decodeUInt8()
      val sueYawStabilizationAileron = source.decodeUInt8()
      val sueAileronNavigation = source.decodeUInt8()
      val sueRudderNavigation = source.decodeUInt8()
      val sueAltitudeholdStabilized = source.decodeUInt8()
      val sueAltitudeholdWaypoint = source.decodeUInt8()
      val sueRacingMode = source.decodeUInt8()

      return SerialUdbExtraF4(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF4 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueRollStabilizationAilerons: UByte = 0u

    public var sueRollStabilizationRudder: UByte = 0u

    public var suePitchStabilization: UByte = 0u

    public var sueYawStabilizationRudder: UByte = 0u

    public var sueYawStabilizationAileron: UByte = 0u

    public var sueAileronNavigation: UByte = 0u

    public var sueRudderNavigation: UByte = 0u

    public var sueAltitudeholdStabilized: UByte = 0u

    public var sueAltitudeholdWaypoint: UByte = 0u

    public var sueRacingMode: UByte = 0u

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
