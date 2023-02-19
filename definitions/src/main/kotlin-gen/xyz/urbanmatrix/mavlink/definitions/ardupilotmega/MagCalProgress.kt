package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.definitions.common.MagCalStatus
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8Array
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

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
  public override val instanceMetadata: MavMessage.Metadata<MagCalProgress> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(directionX)
    outputBuffer.encodeFloat(directionY)
    outputBuffer.encodeFloat(directionZ)
    outputBuffer.encodeUInt8(compassId)
    outputBuffer.encodeUInt8(calMask)
    outputBuffer.encodeEnumValue(calStatus.value, 1)
    outputBuffer.encodeUInt8(attempt)
    outputBuffer.encodeUInt8(completionPct)
    outputBuffer.encodeUInt8Array(completionMask, 10)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(directionX)
    outputBuffer.encodeFloat(directionY)
    outputBuffer.encodeFloat(directionZ)
    outputBuffer.encodeUInt8(compassId)
    outputBuffer.encodeUInt8(calMask)
    outputBuffer.encodeEnumValue(calStatus.value, 1)
    outputBuffer.encodeUInt8(attempt)
    outputBuffer.encodeUInt8(completionPct)
    outputBuffer.encodeUInt8Array(completionMask, 10)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 191u

    private const val CRC_EXTRA: Byte = 92

    private const val SIZE_V1: Int = 27

    private const val SIZE_V2: Int = 27

    private val DESERIALIZER: MavDeserializer<MagCalProgress> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val directionX = inputBuffer.decodeFloat()
      val directionY = inputBuffer.decodeFloat()
      val directionZ = inputBuffer.decodeFloat()
      val compassId = inputBuffer.decodeUInt8()
      val calMask = inputBuffer.decodeUInt8()
      val calStatus = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = MagCalStatus.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val attempt = inputBuffer.decodeUInt8()
      val completionPct = inputBuffer.decodeUInt8()
      val completionMask = inputBuffer.decodeUInt8Array(10)

      MagCalProgress(
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


    private val METADATA: MavMessage.Metadata<MagCalProgress> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<MagCalProgress> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): MagCalProgress =
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
