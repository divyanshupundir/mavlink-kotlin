package xyz.urbanmatrix.mavlink.definitions.matrixpilot

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeInt16
import xyz.urbanmatrix.mavlink.serialization.decodeInt32
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeInt16
import xyz.urbanmatrix.mavlink.serialization.encodeInt32
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA - F2: Part B
 */
@GeneratedMavMessage(
  id = 171,
  crc = 245,
)
public data class SerialUdbExtraF2B(
  /**
   * Serial UDB Extra Time
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueTime: Long = 0L,
  /**
   * Serial UDB Extra PWM Input Channel 1
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput1: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 2
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput2: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 3
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput3: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 4
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput4: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 5
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput5: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 6
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput6: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 7
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput7: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 8
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput8: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 9
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput9: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 10
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput10: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 11
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput11: Int = 0,
  /**
   * Serial UDB Extra PWM Input Channel 12
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmInput12: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 1
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput1: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 2
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput2: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 3
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput3: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 4
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput4: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 5
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput5: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 6
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput6: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 7
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput7: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 8
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput8: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 9
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput9: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 10
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput10: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 11
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput11: Int = 0,
  /**
   * Serial UDB Extra PWM Output Channel 12
   */
  @GeneratedMavField(type = "int16_t")
  public val suePwmOutput12: Int = 0,
  /**
   * Serial UDB Extra IMU Location X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuLocationX: Int = 0,
  /**
   * Serial UDB Extra IMU Location Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuLocationY: Int = 0,
  /**
   * Serial UDB Extra IMU Location Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuLocationZ: Int = 0,
  /**
   * Serial UDB Location Error Earth X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueLocationErrorEarthX: Int = 0,
  /**
   * Serial UDB Location Error Earth Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueLocationErrorEarthY: Int = 0,
  /**
   * Serial UDB Location Error Earth Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueLocationErrorEarthZ: Int = 0,
  /**
   * Serial UDB Extra Status Flags
   */
  @GeneratedMavField(type = "uint32_t")
  public val sueFlags: Long = 0L,
  /**
   * Serial UDB Extra Oscillator Failure Count
   */
  @GeneratedMavField(type = "int16_t")
  public val sueOscFails: Int = 0,
  /**
   * Serial UDB Extra IMU Velocity X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuVelocityX: Int = 0,
  /**
   * Serial UDB Extra IMU Velocity Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuVelocityY: Int = 0,
  /**
   * Serial UDB Extra IMU Velocity Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueImuVelocityZ: Int = 0,
  /**
   * Serial UDB Extra Current Waypoint Goal X
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWaypointGoalX: Int = 0,
  /**
   * Serial UDB Extra Current Waypoint Goal Y
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWaypointGoalY: Int = 0,
  /**
   * Serial UDB Extra Current Waypoint Goal Z
   */
  @GeneratedMavField(type = "int16_t")
  public val sueWaypointGoalZ: Int = 0,
  /**
   * Aeroforce in UDB X Axis
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAeroX: Int = 0,
  /**
   * Aeroforce in UDB Y Axis
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAeroY: Int = 0,
  /**
   * Aeroforce in UDB Z axis
   */
  @GeneratedMavField(type = "int16_t")
  public val sueAeroZ: Int = 0,
  /**
   * SUE barometer temperature
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBaromTemp: Int = 0,
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
  public val sueBatVolt: Int = 0,
  /**
   * SUE battery current
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBatAmp: Int = 0,
  /**
   * SUE battery milli amp hours used
   */
  @GeneratedMavField(type = "int16_t")
  public val sueBatAmpHours: Int = 0,
  /**
   * Sue autopilot desired height
   */
  @GeneratedMavField(type = "int16_t")
  public val sueDesiredHeight: Int = 0,
  /**
   * Serial UDB Extra Stack Memory Free
   */
  @GeneratedMavField(type = "int16_t")
  public val sueMemoryStackFree: Int = 0,
) : MavMessage<SerialUdbExtraF2B> {
  public override val instanceMetadata: MavMessage.Metadata<SerialUdbExtraF2B> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTime)
    outputBuffer.encodeUint32(sueFlags)
    outputBuffer.encodeInt32(sueBaromPress)
    outputBuffer.encodeInt32(sueBaromAlt)
    outputBuffer.encodeInt16(suePwmInput1)
    outputBuffer.encodeInt16(suePwmInput2)
    outputBuffer.encodeInt16(suePwmInput3)
    outputBuffer.encodeInt16(suePwmInput4)
    outputBuffer.encodeInt16(suePwmInput5)
    outputBuffer.encodeInt16(suePwmInput6)
    outputBuffer.encodeInt16(suePwmInput7)
    outputBuffer.encodeInt16(suePwmInput8)
    outputBuffer.encodeInt16(suePwmInput9)
    outputBuffer.encodeInt16(suePwmInput10)
    outputBuffer.encodeInt16(suePwmInput11)
    outputBuffer.encodeInt16(suePwmInput12)
    outputBuffer.encodeInt16(suePwmOutput1)
    outputBuffer.encodeInt16(suePwmOutput2)
    outputBuffer.encodeInt16(suePwmOutput3)
    outputBuffer.encodeInt16(suePwmOutput4)
    outputBuffer.encodeInt16(suePwmOutput5)
    outputBuffer.encodeInt16(suePwmOutput6)
    outputBuffer.encodeInt16(suePwmOutput7)
    outputBuffer.encodeInt16(suePwmOutput8)
    outputBuffer.encodeInt16(suePwmOutput9)
    outputBuffer.encodeInt16(suePwmOutput10)
    outputBuffer.encodeInt16(suePwmOutput11)
    outputBuffer.encodeInt16(suePwmOutput12)
    outputBuffer.encodeInt16(sueImuLocationX)
    outputBuffer.encodeInt16(sueImuLocationY)
    outputBuffer.encodeInt16(sueImuLocationZ)
    outputBuffer.encodeInt16(sueLocationErrorEarthX)
    outputBuffer.encodeInt16(sueLocationErrorEarthY)
    outputBuffer.encodeInt16(sueLocationErrorEarthZ)
    outputBuffer.encodeInt16(sueOscFails)
    outputBuffer.encodeInt16(sueImuVelocityX)
    outputBuffer.encodeInt16(sueImuVelocityY)
    outputBuffer.encodeInt16(sueImuVelocityZ)
    outputBuffer.encodeInt16(sueWaypointGoalX)
    outputBuffer.encodeInt16(sueWaypointGoalY)
    outputBuffer.encodeInt16(sueWaypointGoalZ)
    outputBuffer.encodeInt16(sueAeroX)
    outputBuffer.encodeInt16(sueAeroY)
    outputBuffer.encodeInt16(sueAeroZ)
    outputBuffer.encodeInt16(sueBaromTemp)
    outputBuffer.encodeInt16(sueBatVolt)
    outputBuffer.encodeInt16(sueBatAmp)
    outputBuffer.encodeInt16(sueBatAmpHours)
    outputBuffer.encodeInt16(sueDesiredHeight)
    outputBuffer.encodeInt16(sueMemoryStackFree)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(sueTime)
    outputBuffer.encodeUint32(sueFlags)
    outputBuffer.encodeInt32(sueBaromPress)
    outputBuffer.encodeInt32(sueBaromAlt)
    outputBuffer.encodeInt16(suePwmInput1)
    outputBuffer.encodeInt16(suePwmInput2)
    outputBuffer.encodeInt16(suePwmInput3)
    outputBuffer.encodeInt16(suePwmInput4)
    outputBuffer.encodeInt16(suePwmInput5)
    outputBuffer.encodeInt16(suePwmInput6)
    outputBuffer.encodeInt16(suePwmInput7)
    outputBuffer.encodeInt16(suePwmInput8)
    outputBuffer.encodeInt16(suePwmInput9)
    outputBuffer.encodeInt16(suePwmInput10)
    outputBuffer.encodeInt16(suePwmInput11)
    outputBuffer.encodeInt16(suePwmInput12)
    outputBuffer.encodeInt16(suePwmOutput1)
    outputBuffer.encodeInt16(suePwmOutput2)
    outputBuffer.encodeInt16(suePwmOutput3)
    outputBuffer.encodeInt16(suePwmOutput4)
    outputBuffer.encodeInt16(suePwmOutput5)
    outputBuffer.encodeInt16(suePwmOutput6)
    outputBuffer.encodeInt16(suePwmOutput7)
    outputBuffer.encodeInt16(suePwmOutput8)
    outputBuffer.encodeInt16(suePwmOutput9)
    outputBuffer.encodeInt16(suePwmOutput10)
    outputBuffer.encodeInt16(suePwmOutput11)
    outputBuffer.encodeInt16(suePwmOutput12)
    outputBuffer.encodeInt16(sueImuLocationX)
    outputBuffer.encodeInt16(sueImuLocationY)
    outputBuffer.encodeInt16(sueImuLocationZ)
    outputBuffer.encodeInt16(sueLocationErrorEarthX)
    outputBuffer.encodeInt16(sueLocationErrorEarthY)
    outputBuffer.encodeInt16(sueLocationErrorEarthZ)
    outputBuffer.encodeInt16(sueOscFails)
    outputBuffer.encodeInt16(sueImuVelocityX)
    outputBuffer.encodeInt16(sueImuVelocityY)
    outputBuffer.encodeInt16(sueImuVelocityZ)
    outputBuffer.encodeInt16(sueWaypointGoalX)
    outputBuffer.encodeInt16(sueWaypointGoalY)
    outputBuffer.encodeInt16(sueWaypointGoalZ)
    outputBuffer.encodeInt16(sueAeroX)
    outputBuffer.encodeInt16(sueAeroY)
    outputBuffer.encodeInt16(sueAeroZ)
    outputBuffer.encodeInt16(sueBaromTemp)
    outputBuffer.encodeInt16(sueBatVolt)
    outputBuffer.encodeInt16(sueBatAmp)
    outputBuffer.encodeInt16(sueBatAmpHours)
    outputBuffer.encodeInt16(sueDesiredHeight)
    outputBuffer.encodeInt16(sueMemoryStackFree)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 171

    private const val CRC: Int = 245

    private const val SIZE_V1: Int = 108

    private const val SIZE_V2: Int = 108

    private val DESERIALIZER: MavDeserializer<SerialUdbExtraF2B> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val sueTime = inputBuffer.decodeUint32()
      val sueFlags = inputBuffer.decodeUint32()
      val sueBaromPress = inputBuffer.decodeInt32()
      val sueBaromAlt = inputBuffer.decodeInt32()
      val suePwmInput1 = inputBuffer.decodeInt16()
      val suePwmInput2 = inputBuffer.decodeInt16()
      val suePwmInput3 = inputBuffer.decodeInt16()
      val suePwmInput4 = inputBuffer.decodeInt16()
      val suePwmInput5 = inputBuffer.decodeInt16()
      val suePwmInput6 = inputBuffer.decodeInt16()
      val suePwmInput7 = inputBuffer.decodeInt16()
      val suePwmInput8 = inputBuffer.decodeInt16()
      val suePwmInput9 = inputBuffer.decodeInt16()
      val suePwmInput10 = inputBuffer.decodeInt16()
      val suePwmInput11 = inputBuffer.decodeInt16()
      val suePwmInput12 = inputBuffer.decodeInt16()
      val suePwmOutput1 = inputBuffer.decodeInt16()
      val suePwmOutput2 = inputBuffer.decodeInt16()
      val suePwmOutput3 = inputBuffer.decodeInt16()
      val suePwmOutput4 = inputBuffer.decodeInt16()
      val suePwmOutput5 = inputBuffer.decodeInt16()
      val suePwmOutput6 = inputBuffer.decodeInt16()
      val suePwmOutput7 = inputBuffer.decodeInt16()
      val suePwmOutput8 = inputBuffer.decodeInt16()
      val suePwmOutput9 = inputBuffer.decodeInt16()
      val suePwmOutput10 = inputBuffer.decodeInt16()
      val suePwmOutput11 = inputBuffer.decodeInt16()
      val suePwmOutput12 = inputBuffer.decodeInt16()
      val sueImuLocationX = inputBuffer.decodeInt16()
      val sueImuLocationY = inputBuffer.decodeInt16()
      val sueImuLocationZ = inputBuffer.decodeInt16()
      val sueLocationErrorEarthX = inputBuffer.decodeInt16()
      val sueLocationErrorEarthY = inputBuffer.decodeInt16()
      val sueLocationErrorEarthZ = inputBuffer.decodeInt16()
      val sueOscFails = inputBuffer.decodeInt16()
      val sueImuVelocityX = inputBuffer.decodeInt16()
      val sueImuVelocityY = inputBuffer.decodeInt16()
      val sueImuVelocityZ = inputBuffer.decodeInt16()
      val sueWaypointGoalX = inputBuffer.decodeInt16()
      val sueWaypointGoalY = inputBuffer.decodeInt16()
      val sueWaypointGoalZ = inputBuffer.decodeInt16()
      val sueAeroX = inputBuffer.decodeInt16()
      val sueAeroY = inputBuffer.decodeInt16()
      val sueAeroZ = inputBuffer.decodeInt16()
      val sueBaromTemp = inputBuffer.decodeInt16()
      val sueBatVolt = inputBuffer.decodeInt16()
      val sueBatAmp = inputBuffer.decodeInt16()
      val sueBatAmpHours = inputBuffer.decodeInt16()
      val sueDesiredHeight = inputBuffer.decodeInt16()
      val sueMemoryStackFree = inputBuffer.decodeInt16()

      SerialUdbExtraF2B(
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


    private val METADATA: MavMessage.Metadata<SerialUdbExtraF2B> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<SerialUdbExtraF2B> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueTime: Long = 0L

    public var suePwmInput1: Int = 0

    public var suePwmInput2: Int = 0

    public var suePwmInput3: Int = 0

    public var suePwmInput4: Int = 0

    public var suePwmInput5: Int = 0

    public var suePwmInput6: Int = 0

    public var suePwmInput7: Int = 0

    public var suePwmInput8: Int = 0

    public var suePwmInput9: Int = 0

    public var suePwmInput10: Int = 0

    public var suePwmInput11: Int = 0

    public var suePwmInput12: Int = 0

    public var suePwmOutput1: Int = 0

    public var suePwmOutput2: Int = 0

    public var suePwmOutput3: Int = 0

    public var suePwmOutput4: Int = 0

    public var suePwmOutput5: Int = 0

    public var suePwmOutput6: Int = 0

    public var suePwmOutput7: Int = 0

    public var suePwmOutput8: Int = 0

    public var suePwmOutput9: Int = 0

    public var suePwmOutput10: Int = 0

    public var suePwmOutput11: Int = 0

    public var suePwmOutput12: Int = 0

    public var sueImuLocationX: Int = 0

    public var sueImuLocationY: Int = 0

    public var sueImuLocationZ: Int = 0

    public var sueLocationErrorEarthX: Int = 0

    public var sueLocationErrorEarthY: Int = 0

    public var sueLocationErrorEarthZ: Int = 0

    public var sueFlags: Long = 0L

    public var sueOscFails: Int = 0

    public var sueImuVelocityX: Int = 0

    public var sueImuVelocityY: Int = 0

    public var sueImuVelocityZ: Int = 0

    public var sueWaypointGoalX: Int = 0

    public var sueWaypointGoalY: Int = 0

    public var sueWaypointGoalZ: Int = 0

    public var sueAeroX: Int = 0

    public var sueAeroY: Int = 0

    public var sueAeroZ: Int = 0

    public var sueBaromTemp: Int = 0

    public var sueBaromPress: Int = 0

    public var sueBaromAlt: Int = 0

    public var sueBatVolt: Int = 0

    public var sueBatAmp: Int = 0

    public var sueBatAmpHours: Int = 0

    public var sueDesiredHeight: Int = 0

    public var sueMemoryStackFree: Int = 0

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
