package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F4: format
 *
 * @param sueRollStabilizationAilerons Serial UDB Extra Roll Stabilization with Ailerons Enabled
 * @param sueRollStabilizationRudder Serial UDB Extra Roll Stabilization with Rudder Enabled
 * @param suePitchStabilization Serial UDB Extra Pitch Stabilization Enabled
 * @param sueYawStabilizationRudder Serial UDB Extra Yaw Stabilization using Rudder Enabled
 * @param sueYawStabilizationAileron Serial UDB Extra Yaw Stabilization using Ailerons Enabled
 * @param sueAileronNavigation Serial UDB Extra Navigation with Ailerons Enabled
 * @param sueRudderNavigation Serial UDB Extra Navigation with Rudder Enabled
 * @param sueAltitudeholdStabilized Serial UDB Extra Type of Alitude Hold when in Stabilized Mode
 * @param sueAltitudeholdWaypoint Serial UDB Extra Type of Alitude Hold when in Waypoint Mode
 * @param sueRacingMode Serial UDB Extra Firmware racing mode enabled
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
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF4> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(sueRollStabilizationAilerons)
    encoder.encodeUInt8(sueRollStabilizationRudder)
    encoder.encodeUInt8(suePitchStabilization)
    encoder.encodeUInt8(sueYawStabilizationRudder)
    encoder.encodeUInt8(sueYawStabilizationAileron)
    encoder.encodeUInt8(sueAileronNavigation)
    encoder.encodeUInt8(sueRudderNavigation)
    encoder.encodeUInt8(sueAltitudeholdStabilized)
    encoder.encodeUInt8(sueAltitudeholdWaypoint)
    encoder.encodeUInt8(sueRacingMode)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(sueRollStabilizationAilerons)
    encoder.encodeUInt8(sueRollStabilizationRudder)
    encoder.encodeUInt8(suePitchStabilization)
    encoder.encodeUInt8(sueYawStabilizationRudder)
    encoder.encodeUInt8(sueYawStabilizationAileron)
    encoder.encodeUInt8(sueAileronNavigation)
    encoder.encodeUInt8(sueRudderNavigation)
    encoder.encodeUInt8(sueAltitudeholdStabilized)
    encoder.encodeUInt8(sueAltitudeholdWaypoint)
    encoder.encodeUInt8(sueRacingMode)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF4> {
    private const val SIZE_V1: Int = 10

    private const val SIZE_V2: Int = 10

    override val id: UInt = 172u

    override val crcExtra: Byte = -65

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF4 {
      val decoder = MavDataDecoder(bytes)

      val sueRollStabilizationAilerons = decoder.safeDecodeUInt8()
      val sueRollStabilizationRudder = decoder.safeDecodeUInt8()
      val suePitchStabilization = decoder.safeDecodeUInt8()
      val sueYawStabilizationRudder = decoder.safeDecodeUInt8()
      val sueYawStabilizationAileron = decoder.safeDecodeUInt8()
      val sueAileronNavigation = decoder.safeDecodeUInt8()
      val sueRudderNavigation = decoder.safeDecodeUInt8()
      val sueAltitudeholdStabilized = decoder.safeDecodeUInt8()
      val sueAltitudeholdWaypoint = decoder.safeDecodeUInt8()
      val sueRacingMode = decoder.safeDecodeUInt8()

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
