package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
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

/**
 * Addition to message AUTOPILOT_STATE_FOR_GIMBAL_DEVICE.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param timeBootUs Timestamp (time since system boot).
 * units = us
 * @param windX Wind X speed in NED (North,Est, Down). NAN if unknown.
 * units = m/s
 * @param windY Wind Y speed in NED (North, East, Down). NAN if unknown.
 * units = m/s
 * @param windCorrectionAngle Correction angle due to wind. NaN if unknown.
 * units = rad
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 60_000u,
  crcExtra = 4,
)
public data class AutopilotStateForGimbalDeviceExt(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID.
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
   * Wind X speed in NED (North,Est, Down). NAN if unknown.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val windX: Float = 0F,
  /**
   * Wind Y speed in NED (North, East, Down). NAN if unknown.
   * units = m/s
   */
  @GeneratedMavField(type = "float")
  public val windY: Float = 0F,
  /**
   * Correction angle due to wind. NaN if unknown.
   * units = rad
   */
  @GeneratedMavField(type = "float")
  public val windCorrectionAngle: Float = 0F,
) : MavMessage<AutopilotStateForGimbalDeviceExt> {
  override val instanceCompanion: MavMessage.MavCompanion<AutopilotStateForGimbalDeviceExt> =
      Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt64(timeBootUs)
    encoder.encodeFloat(windX)
    encoder.encodeFloat(windY)
    encoder.encodeFloat(windCorrectionAngle)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt64(timeBootUs)
    encoder.encodeFloat(windX)
    encoder.encodeFloat(windY)
    encoder.encodeFloat(windCorrectionAngle)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AutopilotStateForGimbalDeviceExt> {
    private const val SIZE_V1: Int = 22

    private const val SIZE_V2: Int = 22

    override val id: UInt = 60_000u

    override val crcExtra: Byte = 4

    override fun deserialize(bytes: ByteArray): AutopilotStateForGimbalDeviceExt {
      val decoder = MavDataDecoder(bytes)

      val timeBootUs = decoder.safeDecodeUInt64()
      val windX = decoder.safeDecodeFloat()
      val windY = decoder.safeDecodeFloat()
      val windCorrectionAngle = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return AutopilotStateForGimbalDeviceExt(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        timeBootUs = timeBootUs,
        windX = windX,
        windY = windY,
        windCorrectionAngle = windCorrectionAngle,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AutopilotStateForGimbalDeviceExt
        = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var timeBootUs: ULong = 0uL

    public var windX: Float = 0F

    public var windY: Float = 0F

    public var windCorrectionAngle: Float = 0F

    public fun build(): AutopilotStateForGimbalDeviceExt = AutopilotStateForGimbalDeviceExt(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      timeBootUs = timeBootUs,
      windX = windX,
      windY = windY,
      windCorrectionAngle = windCorrectionAngle,
    )
  }
}
