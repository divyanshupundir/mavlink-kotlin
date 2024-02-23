package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MagCalStatus
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Reports progress of compass calibration.
 *
 * @param compassId Compass being calibrated.
 * @param calMask Bitmask of compasses being calibrated.
 * @param calStatus Calibration Status.
 * @param attempt Attempt number.
 * @param completionPct Completion percentage.
 * units = %
 * @param completionMask Bitmask of sphere sections (see
 * http://en.wikipedia.org/wiki/Geodesic_grid).
 * @param directionX Body frame direction vector for display.
 * @param directionY Body frame direction vector for display.
 * @param directionZ Body frame direction vector for display.
 */
@GeneratedMavMessage(
  id = 191u,
  crcExtra = 92,
)
public data class MagCalProgress(
  /**
   * Compass being calibrated.
   */
  @GeneratedMavField(type = "uint8_t")
  public val compassId: UByte = 0u,
  /**
   * Bitmask of compasses being calibrated.
   */
  @GeneratedMavField(type = "uint8_t")
  public val calMask: UByte = 0u,
  /**
   * Calibration Status.
   */
  @GeneratedMavField(type = "uint8_t")
  public val calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0u),
  /**
   * Attempt number.
   */
  @GeneratedMavField(type = "uint8_t")
  public val attempt: UByte = 0u,
  /**
   * Completion percentage.
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val completionPct: UByte = 0u,
  /**
   * Bitmask of sphere sections (see http://en.wikipedia.org/wiki/Geodesic_grid).
   */
  @GeneratedMavField(type = "uint8_t[10]")
  public val completionMask: List<UByte> = emptyList(),
  /**
   * Body frame direction vector for display.
   */
  @GeneratedMavField(type = "float")
  public val directionX: Float = 0F,
  /**
   * Body frame direction vector for display.
   */
  @GeneratedMavField(type = "float")
  public val directionY: Float = 0F,
  /**
   * Body frame direction vector for display.
   */
  @GeneratedMavField(type = "float")
  public val directionZ: Float = 0F,
) : MavMessage<MagCalProgress> {
  override val instanceCompanion: MavMessage.MavCompanion<MagCalProgress> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(directionX)
    encoder.encodeFloat(directionY)
    encoder.encodeFloat(directionZ)
    encoder.encodeUInt8(compassId)
    encoder.encodeUInt8(calMask)
    encoder.encodeEnumValue(calStatus.value, 1)
    encoder.encodeUInt8(attempt)
    encoder.encodeUInt8(completionPct)
    encoder.encodeUInt8Array(completionMask, 10)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(directionX)
    encoder.encodeFloat(directionY)
    encoder.encodeFloat(directionZ)
    encoder.encodeUInt8(compassId)
    encoder.encodeUInt8(calMask)
    encoder.encodeEnumValue(calStatus.value, 1)
    encoder.encodeUInt8(attempt)
    encoder.encodeUInt8(completionPct)
    encoder.encodeUInt8Array(completionMask, 10)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MagCalProgress> {
    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 27

    override val id: UInt = 191u

    override val crcExtra: Byte = 92

    override fun deserialize(bytes: ByteArray): MagCalProgress {
      val decoder = MavDataDecoder(bytes)

      val directionX = decoder.safeDecodeFloat()
      val directionY = decoder.safeDecodeFloat()
      val directionZ = decoder.safeDecodeFloat()
      val compassId = decoder.safeDecodeUInt8()
      val calMask = decoder.safeDecodeUInt8()
      val calStatus = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val attempt = decoder.safeDecodeUInt8()
      val completionPct = decoder.safeDecodeUInt8()
      val completionMask = decoder.safeDecodeUInt8Array(10)

      return MagCalProgress(
        compassId = compassId,
        calMask = calMask,
        calStatus = calStatus,
        attempt = attempt,
        completionPct = completionPct,
        completionMask = completionMask,
        directionX = directionX,
        directionY = directionY,
        directionZ = directionZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MagCalProgress =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var compassId: UByte = 0u

    public var calMask: UByte = 0u

    public var calStatus: MavEnumValue<MagCalStatus> = MavEnumValue.fromValue(0u)

    public var attempt: UByte = 0u

    public var completionPct: UByte = 0u

    public var completionMask: List<UByte> = emptyList()

    public var directionX: Float = 0F

    public var directionY: Float = 0F

    public var directionZ: Float = 0F

    public fun build(): MagCalProgress = MagCalProgress(
      compassId = compassId,
      calMask = calMask,
      calStatus = calStatus,
      attempt = attempt,
      completionPct = completionPct,
      completionMask = completionMask,
      directionX = directionX,
      directionY = directionY,
      directionZ = directionZ,
    )
  }
}
