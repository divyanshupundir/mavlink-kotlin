package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.definitions.common.MagCalStatus
import com.divpundir.mavlink.serialization.decodeEnumValue
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

/**
 * Reports progress of compass calibration.
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
  public override val instanceCompanion: MavMessage.MavCompanion<MagCalProgress> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(directionX)
    output.encodeFloat(directionY)
    output.encodeFloat(directionZ)
    output.encodeUInt8(compassId)
    output.encodeUInt8(calMask)
    output.encodeEnumValue(calStatus.value, 1)
    output.encodeUInt8(attempt)
    output.encodeUInt8(completionPct)
    output.encodeUInt8Array(completionMask, 10)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(directionX)
    output.encodeFloat(directionY)
    output.encodeFloat(directionZ)
    output.encodeUInt8(compassId)
    output.encodeUInt8(calMask)
    output.encodeEnumValue(calStatus.value, 1)
    output.encodeUInt8(attempt)
    output.encodeUInt8(completionPct)
    output.encodeUInt8Array(completionMask, 10)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<MagCalProgress> {
    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 27

    public override val id: UInt = 191u

    public override val crcExtra: Byte = 92

    public override fun deserialize(source: BufferedSource): MagCalProgress {
      val directionX = source.decodeFloat()
      val directionY = source.decodeFloat()
      val directionZ = source.decodeFloat()
      val compassId = source.decodeUInt8()
      val calMask = source.decodeUInt8()
      val calStatus = source.decodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val attempt = source.decodeUInt8()
      val completionPct = source.decodeUInt8()
      val completionMask = source.decodeUInt8Array(10)

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
