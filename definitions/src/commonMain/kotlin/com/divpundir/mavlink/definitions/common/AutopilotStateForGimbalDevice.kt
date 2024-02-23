package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeFloatArray
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeFloatArray
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeUInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.ULong
import kotlin.Unit
import kotlin.collections.List

/**
 * Low level message containing autopilot state relevant for a gimbal device. This message is to be
 * sent from the autopilot to the gimbal device component. The data of this message are for the gimbal
 * device's estimator corrections, in particular horizon compensation, as well as indicates autopilot
 * control intentions, e.g. feed forward angular control in the z-axis.
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param timeBootUs Timestamp (time since system boot).
 * units = us
 * @param q Quaternion components of autopilot attitude: w, x, y, z (1 0 0 0 is the null-rotation,
 * Hamilton convention).
 * @param qEstimatedDelayUs Estimated delay of the attitude data. 0 if unknown.
 * units = us
 * @param vx X Speed in NED (North, East, Down). NAN if unknown.
 * units = m/s
 * @param vy Y Speed in NED (North, East, Down). NAN if unknown.
 * units = m/s
 * @param vz Z Speed in NED (North, East, Down). NAN if unknown.
 * units = m/s
 * @param vEstimatedDelayUs Estimated delay of the speed data. 0 if unknown.
 * units = us
 * @param feedForwardAngularVelocityZ Feed forward Z component of angular velocity (positive: yawing
 * to the right). NaN to be ignored. This is to indicate if the autopilot is actively yawing.
 * units = rad/s
 * @param estimatorStatus Bitmap indicating which estimator outputs are valid.
 * @param landedState The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is
 * unknown.
 * @param angularVelocityZ Z component of angular velocity in NED (North, East, Down). NaN if
 * unknown.
 * units = rad/s
 */
@GeneratedMavMessage(
  id = 286u,
  crcExtra = -46,
)
public data class AutopilotStateForGimbalDevice(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Timestamp (time since system boot).
   * units = us
   */
  @GeneratedMavField(type = "uint64_t")
  public val timeBootUs: ULong = 0uL,
  /**
   * Quaternion components of autopilot attitude: w, x, y, z (1 0 0 0 is the null-rotation, Hamilton
   * convention).
   */
  @GeneratedMavField(type = "float[4]")
  public val q: List<Float> = emptyList(),
  /**
   * Estimated delay of the attitude data. 0 if unknown.
   * units = us
   */
  @GeneratedMavField(type = "uint32_t")
  public val qEstimatedDelayUs: UInt = 0u,
  /**
   * X Speed in NED (North, East, Down). NAN if unknown.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vx: Float = 0F,
  /**
   * Y Speed in NED (North, East, Down). NAN if unknown.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vy: Float = 0F,
  /**
   * Z Speed in NED (North, East, Down). NAN if unknown.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val vz: Float = 0F,
  /**
   * Estimated delay of the speed data. 0 if unknown.
   * units = us
   */
  @GeneratedMavField(type = "uint32_t")
  public val vEstimatedDelayUs: UInt = 0u,
  /**
   * Feed forward Z component of angular velocity (positive: yawing to the right). NaN to be
   * ignored. This is to indicate if the autopilot is actively yawing.
   * units = rad/s
   */
  @GeneratedMavField(type = "float")
  public val feedForwardAngularVelocityZ: Float = 0F,
  /**
   * Bitmap indicating which estimator outputs are valid.
   */
  @GeneratedMavField(type = "uint16_t")
  public val estimatorStatus: MavBitmaskValue<EstimatorStatusFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
   */
  @GeneratedMavField(type = "uint8_t")
  public val landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u),
  /**
   * Z component of angular velocity in NED (North, East, Down). NaN if unknown.
   * units = rad/s
   */
  @GeneratedMavField(
    type = "float",
    extension = true,
  )
  public val angularVelocityZ: Float = 0F,
) : MavMessage<AutopilotStateForGimbalDevice> {
  override val instanceCompanion: MavMessage.MavCompanion<AutopilotStateForGimbalDevice> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeBootUs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeUInt32(qEstimatedDelayUs)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeUInt32(vEstimatedDelayUs)
    encoder.encodeFloat(feedForwardAngularVelocityZ)
    encoder.encodeBitmaskValue(estimatorStatus.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(landedState.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeBootUs)
    encoder.encodeFloatArray(q, 16)
    encoder.encodeUInt32(qEstimatedDelayUs)
    encoder.encodeFloat(vx)
    encoder.encodeFloat(vy)
    encoder.encodeFloat(vz)
    encoder.encodeUInt32(vEstimatedDelayUs)
    encoder.encodeFloat(feedForwardAngularVelocityZ)
    encoder.encodeBitmaskValue(estimatorStatus.value, 2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeEnumValue(landedState.value, 1)
    encoder.encodeFloat(angularVelocityZ)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AutopilotStateForGimbalDevice> {
    private const val SIZE_V1: Int = 53

    private const val SIZE_V2: Int = 57

    override val id: UInt = 286u

    override val crcExtra: Byte = -46

    override fun deserialize(bytes: ByteArray): AutopilotStateForGimbalDevice {
      val decoder = MavDataDecoder(bytes)

      val timeBootUs = decoder.safeDecodeUInt64()
      val q = decoder.safeDecodeFloatArray(16)
      val qEstimatedDelayUs = decoder.safeDecodeUInt32()
      val vx = decoder.safeDecodeFloat()
      val vy = decoder.safeDecodeFloat()
      val vz = decoder.safeDecodeFloat()
      val vEstimatedDelayUs = decoder.safeDecodeUInt32()
      val feedForwardAngularVelocityZ = decoder.safeDecodeFloat()
      val estimatorStatus = decoder.safeDecodeBitmaskValue(2).let { value ->
        val flags = EstimatorStatusFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val landedState = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MavLandedState.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val angularVelocityZ = decoder.safeDecodeFloat()

      return AutopilotStateForGimbalDevice(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        timeBootUs = timeBootUs,
        q = q,
        qEstimatedDelayUs = qEstimatedDelayUs,
        vx = vx,
        vy = vy,
        vz = vz,
        vEstimatedDelayUs = vEstimatedDelayUs,
        feedForwardAngularVelocityZ = feedForwardAngularVelocityZ,
        estimatorStatus = estimatorStatus,
        landedState = landedState,
        angularVelocityZ = angularVelocityZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AutopilotStateForGimbalDevice =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var timeBootUs: ULong = 0uL

    public var q: List<Float> = emptyList()

    public var qEstimatedDelayUs: UInt = 0u

    public var vx: Float = 0F

    public var vy: Float = 0F

    public var vz: Float = 0F

    public var vEstimatedDelayUs: UInt = 0u

    public var feedForwardAngularVelocityZ: Float = 0F

    public var estimatorStatus: MavBitmaskValue<EstimatorStatusFlags> =
        MavBitmaskValue.fromValue(0u)

    public var landedState: MavEnumValue<MavLandedState> = MavEnumValue.fromValue(0u)

    public var angularVelocityZ: Float = 0F

    public fun build(): AutopilotStateForGimbalDevice = AutopilotStateForGimbalDevice(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      timeBootUs = timeBootUs,
      q = q,
      qEstimatedDelayUs = qEstimatedDelayUs,
      vx = vx,
      vy = vy,
      vz = vz,
      vEstimatedDelayUs = vEstimatedDelayUs,
      feedForwardAngularVelocityZ = feedForwardAngularVelocityZ,
      estimatorStatus = estimatorStatus,
      landedState = landedState,
      angularVelocityZ = angularVelocityZ,
    )
  }
}
