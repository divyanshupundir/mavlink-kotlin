package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

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

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(sueRollStabilizationAilerons)
    buffer.encodeUInt8(sueRollStabilizationRudder)
    buffer.encodeUInt8(suePitchStabilization)
    buffer.encodeUInt8(sueYawStabilizationRudder)
    buffer.encodeUInt8(sueYawStabilizationAileron)
    buffer.encodeUInt8(sueAileronNavigation)
    buffer.encodeUInt8(sueRudderNavigation)
    buffer.encodeUInt8(sueAltitudeholdStabilized)
    buffer.encodeUInt8(sueAltitudeholdWaypoint)
    buffer.encodeUInt8(sueRacingMode)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8(sueRollStabilizationAilerons)
    buffer.encodeUInt8(sueRollStabilizationRudder)
    buffer.encodeUInt8(suePitchStabilization)
    buffer.encodeUInt8(sueYawStabilizationRudder)
    buffer.encodeUInt8(sueYawStabilizationAileron)
    buffer.encodeUInt8(sueAileronNavigation)
    buffer.encodeUInt8(sueRudderNavigation)
    buffer.encodeUInt8(sueAltitudeholdStabilized)
    buffer.encodeUInt8(sueAltitudeholdWaypoint)
    buffer.encodeUInt8(sueRacingMode)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF4> {
    public override val id: UInt = 172u

    public override val crcExtra: Byte = -65

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF4 {
      val buffer = Buffer().write(bytes)

      val sueRollStabilizationAilerons = buffer.decodeUInt8()
      val sueRollStabilizationRudder = buffer.decodeUInt8()
      val suePitchStabilization = buffer.decodeUInt8()
      val sueYawStabilizationRudder = buffer.decodeUInt8()
      val sueYawStabilizationAileron = buffer.decodeUInt8()
      val sueAileronNavigation = buffer.decodeUInt8()
      val sueRudderNavigation = buffer.decodeUInt8()
      val sueAltitudeholdStabilized = buffer.decodeUInt8()
      val sueAltitudeholdWaypoint = buffer.decodeUInt8()
      val sueRacingMode = buffer.decodeUInt8()

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
