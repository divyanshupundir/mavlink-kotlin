package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeInt32
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeInt16
import com.divpundir.mavlink.serialization.safeDecodeInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Short
import kotlin.UInt
import kotlin.Unit

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA - F2: Part B
 */
@GeneratedMavMessage(
  id = 171u,
  crcExtra = -11,
)
public data class SerialUdbExtraF2B(
  /**
   * Serial UDB Extra Time
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueTime: UInt = 0u,
  /**
   * Serial UDB Extra PWM Input Channel 1
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput1: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 2
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput2: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 3
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput3: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 4
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput4: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 5
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput5: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 6
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput6: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 7
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput7: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 8
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput8: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 9
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput9: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 10
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput10: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 11
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput11: Short = 0,
  /**
   * Serial UDB Extra PWM Input Channel 12
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput12: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 1
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput1: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 2
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput2: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 3
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput3: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 4
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput4: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 5
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput5: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 6
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput6: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 7
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput7: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 8
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput8: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 9
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput9: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 10
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput10: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 11
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput11: Short = 0,
  /**
   * Serial UDB Extra PWM Output Channel 12
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput12: Short = 0,
  /**
   * Serial UDB Extra IMU Location X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuLocationX: Short = 0,
  /**
   * Serial UDB Extra IMU Location Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuLocationY: Short = 0,
  /**
   * Serial UDB Extra IMU Location Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuLocationZ: Short = 0,
  /**
   * Serial UDB Location Error Earth X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueLocationErrorEarthX: Short = 0,
  /**
   * Serial UDB Location Error Earth Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueLocationErrorEarthY: Short = 0,
  /**
   * Serial UDB Location Error Earth Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueLocationErrorEarthZ: Short = 0,
  /**
   * Serial UDB Extra Status Flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueFlags: UInt = 0u,
  /**
   * Serial UDB Extra Oscillator Failure Count
   */
  @GeneratedMavField(type = "int16_t")
  public val sueOscFails: Short = 0,
  /**
   * Serial UDB Extra IMU Velocity X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuVelocityX: Short = 0,
  /**
   * Serial UDB Extra IMU Velocity Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuVelocityY: Short = 0,
  /**
   * Serial UDB Extra IMU Velocity Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuVelocityZ: Short = 0,
  /**
   * Serial UDB Extra Current Waypoint Goal X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWaypointGoalX: Short = 0,
  /**
   * Serial UDB Extra Current Waypoint Goal Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWaypointGoalY: Short = 0,
  /**
   * Serial UDB Extra Current Waypoint Goal Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWaypointGoalZ: Short = 0,
  /**
   * Aeroforce in UDB X Axis
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAeroX: Short = 0,
  /**
   * Aeroforce in UDB Y Axis
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAeroY: Short = 0,
  /**
   * Aeroforce in UDB Z axis
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAeroZ: Short = 0,
  /**
   * SUE barometer temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBaromTemp: Short = 0,
  /**
   * SUE barometer pressure
   */
  @GeneratedMavField(type = "int32_t")
  public val sueBaromPress: Int = 0,
  /**
   * SUE barometer altitude
   */
  @GeneratedMavField(type = "int32_t")
  public val sueBaromAlt: Int = 0,
  /**
   * SUE battery voltage
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBatVolt: Short = 0,
  /**
   * SUE battery current
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBatAmp: Short = 0,
  /**
   * SUE battery milli amp hours used
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBatAmpHours: Short = 0,
  /**
   * Sue autopilot desired height
   */
  @GeneratedMavField(type = "int16_t")
  public val sueDesiredHeight: Short = 0,
  /**
   * Serial UDB Extra Stack Memory Free
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMemoryStackFree: Short = 0,
) : MavMessage<SerialUdbExtraF2B> {
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF2B> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(sueTime)
    encoder.encodeUInt32(sueFlags)
    encoder.encodeInt32(sueBaromPress)
    encoder.encodeInt32(sueBaromAlt)
    encoder.encodeInt16(suePwmInput1)
    encoder.encodeInt16(suePwmInput2)
    encoder.encodeInt16(suePwmInput3)
    encoder.encodeInt16(suePwmInput4)
    encoder.encodeInt16(suePwmInput5)
    encoder.encodeInt16(suePwmInput6)
    encoder.encodeInt16(suePwmInput7)
    encoder.encodeInt16(suePwmInput8)
    encoder.encodeInt16(suePwmInput9)
    encoder.encodeInt16(suePwmInput10)
    encoder.encodeInt16(suePwmInput11)
    encoder.encodeInt16(suePwmInput12)
    encoder.encodeInt16(suePwmOutput1)
    encoder.encodeInt16(suePwmOutput2)
    encoder.encodeInt16(suePwmOutput3)
    encoder.encodeInt16(suePwmOutput4)
    encoder.encodeInt16(suePwmOutput5)
    encoder.encodeInt16(suePwmOutput6)
    encoder.encodeInt16(suePwmOutput7)
    encoder.encodeInt16(suePwmOutput8)
    encoder.encodeInt16(suePwmOutput9)
    encoder.encodeInt16(suePwmOutput10)
    encoder.encodeInt16(suePwmOutput11)
    encoder.encodeInt16(suePwmOutput12)
    encoder.encodeInt16(sueImuLocationX)
    encoder.encodeInt16(sueImuLocationY)
    encoder.encodeInt16(sueImuLocationZ)
    encoder.encodeInt16(sueLocationErrorEarthX)
    encoder.encodeInt16(sueLocationErrorEarthY)
    encoder.encodeInt16(sueLocationErrorEarthZ)
    encoder.encodeInt16(sueOscFails)
    encoder.encodeInt16(sueImuVelocityX)
    encoder.encodeInt16(sueImuVelocityY)
    encoder.encodeInt16(sueImuVelocityZ)
    encoder.encodeInt16(sueWaypointGoalX)
    encoder.encodeInt16(sueWaypointGoalY)
    encoder.encodeInt16(sueWaypointGoalZ)
    encoder.encodeInt16(sueAeroX)
    encoder.encodeInt16(sueAeroY)
    encoder.encodeInt16(sueAeroZ)
    encoder.encodeInt16(sueBaromTemp)
    encoder.encodeInt16(sueBatVolt)
    encoder.encodeInt16(sueBatAmp)
    encoder.encodeInt16(sueBatAmpHours)
    encoder.encodeInt16(sueDesiredHeight)
    encoder.encodeInt16(sueMemoryStackFree)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(sueTime)
    encoder.encodeUInt32(sueFlags)
    encoder.encodeInt32(sueBaromPress)
    encoder.encodeInt32(sueBaromAlt)
    encoder.encodeInt16(suePwmInput1)
    encoder.encodeInt16(suePwmInput2)
    encoder.encodeInt16(suePwmInput3)
    encoder.encodeInt16(suePwmInput4)
    encoder.encodeInt16(suePwmInput5)
    encoder.encodeInt16(suePwmInput6)
    encoder.encodeInt16(suePwmInput7)
    encoder.encodeInt16(suePwmInput8)
    encoder.encodeInt16(suePwmInput9)
    encoder.encodeInt16(suePwmInput10)
    encoder.encodeInt16(suePwmInput11)
    encoder.encodeInt16(suePwmInput12)
    encoder.encodeInt16(suePwmOutput1)
    encoder.encodeInt16(suePwmOutput2)
    encoder.encodeInt16(suePwmOutput3)
    encoder.encodeInt16(suePwmOutput4)
    encoder.encodeInt16(suePwmOutput5)
    encoder.encodeInt16(suePwmOutput6)
    encoder.encodeInt16(suePwmOutput7)
    encoder.encodeInt16(suePwmOutput8)
    encoder.encodeInt16(suePwmOutput9)
    encoder.encodeInt16(suePwmOutput10)
    encoder.encodeInt16(suePwmOutput11)
    encoder.encodeInt16(suePwmOutput12)
    encoder.encodeInt16(sueImuLocationX)
    encoder.encodeInt16(sueImuLocationY)
    encoder.encodeInt16(sueImuLocationZ)
    encoder.encodeInt16(sueLocationErrorEarthX)
    encoder.encodeInt16(sueLocationErrorEarthY)
    encoder.encodeInt16(sueLocationErrorEarthZ)
    encoder.encodeInt16(sueOscFails)
    encoder.encodeInt16(sueImuVelocityX)
    encoder.encodeInt16(sueImuVelocityY)
    encoder.encodeInt16(sueImuVelocityZ)
    encoder.encodeInt16(sueWaypointGoalX)
    encoder.encodeInt16(sueWaypointGoalY)
    encoder.encodeInt16(sueWaypointGoalZ)
    encoder.encodeInt16(sueAeroX)
    encoder.encodeInt16(sueAeroY)
    encoder.encodeInt16(sueAeroZ)
    encoder.encodeInt16(sueBaromTemp)
    encoder.encodeInt16(sueBatVolt)
    encoder.encodeInt16(sueBatAmp)
    encoder.encodeInt16(sueBatAmpHours)
    encoder.encodeInt16(sueDesiredHeight)
    encoder.encodeInt16(sueMemoryStackFree)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF2B> {
    private const val SIZE_V1: Int = 108

    private const val SIZE_V2: Int = 108

    public override val id: UInt = 171u

    public override val crcExtra: Byte = -11

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF2B {
      val decoder = MavDataDecoder(bytes)

      val sueTime = decoder.safeDecodeUInt32()
      val sueFlags = decoder.safeDecodeUInt32()
      val sueBaromPress = decoder.safeDecodeInt32()
      val sueBaromAlt = decoder.safeDecodeInt32()
      val suePwmInput1 = decoder.safeDecodeInt16()
      val suePwmInput2 = decoder.safeDecodeInt16()
      val suePwmInput3 = decoder.safeDecodeInt16()
      val suePwmInput4 = decoder.safeDecodeInt16()
      val suePwmInput5 = decoder.safeDecodeInt16()
      val suePwmInput6 = decoder.safeDecodeInt16()
      val suePwmInput7 = decoder.safeDecodeInt16()
      val suePwmInput8 = decoder.safeDecodeInt16()
      val suePwmInput9 = decoder.safeDecodeInt16()
      val suePwmInput10 = decoder.safeDecodeInt16()
      val suePwmInput11 = decoder.safeDecodeInt16()
      val suePwmInput12 = decoder.safeDecodeInt16()
      val suePwmOutput1 = decoder.safeDecodeInt16()
      val suePwmOutput2 = decoder.safeDecodeInt16()
      val suePwmOutput3 = decoder.safeDecodeInt16()
      val suePwmOutput4 = decoder.safeDecodeInt16()
      val suePwmOutput5 = decoder.safeDecodeInt16()
      val suePwmOutput6 = decoder.safeDecodeInt16()
      val suePwmOutput7 = decoder.safeDecodeInt16()
      val suePwmOutput8 = decoder.safeDecodeInt16()
      val suePwmOutput9 = decoder.safeDecodeInt16()
      val suePwmOutput10 = decoder.safeDecodeInt16()
      val suePwmOutput11 = decoder.safeDecodeInt16()
      val suePwmOutput12 = decoder.safeDecodeInt16()
      val sueImuLocationX = decoder.safeDecodeInt16()
      val sueImuLocationY = decoder.safeDecodeInt16()
      val sueImuLocationZ = decoder.safeDecodeInt16()
      val sueLocationErrorEarthX = decoder.safeDecodeInt16()
      val sueLocationErrorEarthY = decoder.safeDecodeInt16()
      val sueLocationErrorEarthZ = decoder.safeDecodeInt16()
      val sueOscFails = decoder.safeDecodeInt16()
      val sueImuVelocityX = decoder.safeDecodeInt16()
      val sueImuVelocityY = decoder.safeDecodeInt16()
      val sueImuVelocityZ = decoder.safeDecodeInt16()
      val sueWaypointGoalX = decoder.safeDecodeInt16()
      val sueWaypointGoalY = decoder.safeDecodeInt16()
      val sueWaypointGoalZ = decoder.safeDecodeInt16()
      val sueAeroX = decoder.safeDecodeInt16()
      val sueAeroY = decoder.safeDecodeInt16()
      val sueAeroZ = decoder.safeDecodeInt16()
      val sueBaromTemp = decoder.safeDecodeInt16()
      val sueBatVolt = decoder.safeDecodeInt16()
      val sueBatAmp = decoder.safeDecodeInt16()
      val sueBatAmpHours = decoder.safeDecodeInt16()
      val sueDesiredHeight = decoder.safeDecodeInt16()
      val sueMemoryStackFree = decoder.safeDecodeInt16()

      return SerialUdbExtraF2B(
        sueTime = sueTime,
        suePwmInput1 = suePwmInput1,
        suePwmInput2 = suePwmInput2,
        suePwmInput3 = suePwmInput3,
        suePwmInput4 = suePwmInput4,
        suePwmInput5 = suePwmInput5,
        suePwmInput6 = suePwmInput6,
        suePwmInput7 = suePwmInput7,
        suePwmInput8 = suePwmInput8,
        suePwmInput9 = suePwmInput9,
        suePwmInput10 = suePwmInput10,
        suePwmInput11 = suePwmInput11,
        suePwmInput12 = suePwmInput12,
        suePwmOutput1 = suePwmOutput1,
        suePwmOutput2 = suePwmOutput2,
        suePwmOutput3 = suePwmOutput3,
        suePwmOutput4 = suePwmOutput4,
        suePwmOutput5 = suePwmOutput5,
        suePwmOutput6 = suePwmOutput6,
        suePwmOutput7 = suePwmOutput7,
        suePwmOutput8 = suePwmOutput8,
        suePwmOutput9 = suePwmOutput9,
        suePwmOutput10 = suePwmOutput10,
        suePwmOutput11 = suePwmOutput11,
        suePwmOutput12 = suePwmOutput12,
        sueImuLocationX = sueImuLocationX,
        sueImuLocationY = sueImuLocationY,
        sueImuLocationZ = sueImuLocationZ,
        sueLocationErrorEarthX = sueLocationErrorEarthX,
        sueLocationErrorEarthY = sueLocationErrorEarthY,
        sueLocationErrorEarthZ = sueLocationErrorEarthZ,
        sueFlags = sueFlags,
        sueOscFails = sueOscFails,
        sueImuVelocityX = sueImuVelocityX,
        sueImuVelocityY = sueImuVelocityY,
        sueImuVelocityZ = sueImuVelocityZ,
        sueWaypointGoalX = sueWaypointGoalX,
        sueWaypointGoalY = sueWaypointGoalY,
        sueWaypointGoalZ = sueWaypointGoalZ,
        sueAeroX = sueAeroX,
        sueAeroY = sueAeroY,
        sueAeroZ = sueAeroZ,
        sueBaromTemp = sueBaromTemp,
        sueBaromPress = sueBaromPress,
        sueBaromAlt = sueBaromAlt,
        sueBatVolt = sueBatVolt,
        sueBatAmp = sueBatAmp,
        sueBatAmpHours = sueBatAmpHours,
        sueDesiredHeight = sueDesiredHeight,
        sueMemoryStackFree = sueMemoryStackFree,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF2B =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueTime: UInt = 0u

    public var suePwmInput1: Short = 0

    public var suePwmInput2: Short = 0

    public var suePwmInput3: Short = 0

    public var suePwmInput4: Short = 0

    public var suePwmInput5: Short = 0

    public var suePwmInput6: Short = 0

    public var suePwmInput7: Short = 0

    public var suePwmInput8: Short = 0

    public var suePwmInput9: Short = 0

    public var suePwmInput10: Short = 0

    public var suePwmInput11: Short = 0

    public var suePwmInput12: Short = 0

    public var suePwmOutput1: Short = 0

    public var suePwmOutput2: Short = 0

    public var suePwmOutput3: Short = 0

    public var suePwmOutput4: Short = 0

    public var suePwmOutput5: Short = 0

    public var suePwmOutput6: Short = 0

    public var suePwmOutput7: Short = 0

    public var suePwmOutput8: Short = 0

    public var suePwmOutput9: Short = 0

    public var suePwmOutput10: Short = 0

    public var suePwmOutput11: Short = 0

    public var suePwmOutput12: Short = 0

    public var sueImuLocationX: Short = 0

    public var sueImuLocationY: Short = 0

    public var sueImuLocationZ: Short = 0

    public var sueLocationErrorEarthX: Short = 0

    public var sueLocationErrorEarthY: Short = 0

    public var sueLocationErrorEarthZ: Short = 0

    public var sueFlags: UInt = 0u

    public var sueOscFails: Short = 0

    public var sueImuVelocityX: Short = 0

    public var sueImuVelocityY: Short = 0

    public var sueImuVelocityZ: Short = 0

    public var sueWaypointGoalX: Short = 0

    public var sueWaypointGoalY: Short = 0

    public var sueWaypointGoalZ: Short = 0

    public var sueAeroX: Short = 0

    public var sueAeroY: Short = 0

    public var sueAeroZ: Short = 0

    public var sueBaromTemp: Short = 0

    public var sueBaromPress: Int = 0

    public var sueBaromAlt: Int = 0

    public var sueBatVolt: Short = 0

    public var sueBatAmp: Short = 0

    public var sueBatAmpHours: Short = 0

    public var sueDesiredHeight: Short = 0

    public var sueMemoryStackFree: Short = 0

    public fun build(): SerialUdbExtraF2B = SerialUdbExtraF2B(
      sueTime = sueTime,
      suePwmInput1 = suePwmInput1,
      suePwmInput2 = suePwmInput2,
      suePwmInput3 = suePwmInput3,
      suePwmInput4 = suePwmInput4,
      suePwmInput5 = suePwmInput5,
      suePwmInput6 = suePwmInput6,
      suePwmInput7 = suePwmInput7,
      suePwmInput8 = suePwmInput8,
      suePwmInput9 = suePwmInput9,
      suePwmInput10 = suePwmInput10,
      suePwmInput11 = suePwmInput11,
      suePwmInput12 = suePwmInput12,
      suePwmOutput1 = suePwmOutput1,
      suePwmOutput2 = suePwmOutput2,
      suePwmOutput3 = suePwmOutput3,
      suePwmOutput4 = suePwmOutput4,
      suePwmOutput5 = suePwmOutput5,
      suePwmOutput6 = suePwmOutput6,
      suePwmOutput7 = suePwmOutput7,
      suePwmOutput8 = suePwmOutput8,
      suePwmOutput9 = suePwmOutput9,
      suePwmOutput10 = suePwmOutput10,
      suePwmOutput11 = suePwmOutput11,
      suePwmOutput12 = suePwmOutput12,
      sueImuLocationX = sueImuLocationX,
      sueImuLocationY = sueImuLocationY,
      sueImuLocationZ = sueImuLocationZ,
      sueLocationErrorEarthX = sueLocationErrorEarthX,
      sueLocationErrorEarthY = sueLocationErrorEarthY,
      sueLocationErrorEarthZ = sueLocationErrorEarthZ,
      sueFlags = sueFlags,
      sueOscFails = sueOscFails,
      sueImuVelocityX = sueImuVelocityX,
      sueImuVelocityY = sueImuVelocityY,
      sueImuVelocityZ = sueImuVelocityZ,
      sueWaypointGoalX = sueWaypointGoalX,
      sueWaypointGoalY = sueWaypointGoalY,
      sueWaypointGoalZ = sueWaypointGoalZ,
      sueAeroX = sueAeroX,
      sueAeroY = sueAeroY,
      sueAeroZ = sueAeroZ,
      sueBaromTemp = sueBaromTemp,
      sueBaromPress = sueBaromPress,
      sueBaromAlt = sueBaromAlt,
      sueBatVolt = sueBatVolt,
      sueBatAmp = sueBatAmp,
      sueBatAmpHours = sueBatAmpHours,
      sueDesiredHeight = sueDesiredHeight,
      sueMemoryStackFree = sueMemoryStackFree,
    )
  }
}
