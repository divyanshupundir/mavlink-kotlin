package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavEnumValue
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint32
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeEnumValue
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint32
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled.
 */
@GeneratedMavMessage(
  id = 162,
  crc = 189,
)
public data class FenceStatus(
  /**
   * Breach status (0 if currently inside fence, 1 if outside).
   */
  @GeneratedMavField(type = "uint8_t")
  public val breachStatus: Int = 0,
  /**
   * Number of fence breaches.
   */
  @GeneratedMavField(type = "uint16_t")
  public val breachCount: Int = 0,
  /**
   * Last breach type.
   */
  @GeneratedMavField(type = "uint8_t")
  public val breachType: MavEnumValue<FenceBreach> = MavEnumValue.fromValue(0),
  /**
   * Time (since boot) of last breach.
   */
  @GeneratedMavField(type = "uint32_t")
  public val breachTime: Long = 0L,
  /**
   * Active action to prevent fence breach
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val breachMitigation: MavEnumValue<FenceMitigate> = MavEnumValue.fromValue(0),
) : MavMessage<FenceStatus> {
  public override val instanceMetadata: MavMessage.Metadata<FenceStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(breachTime)
    outputBuffer.encodeUint16(breachCount)
    outputBuffer.encodeUint8(breachStatus)
    outputBuffer.encodeEnumValue(breachType.value, 1)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint32(breachTime)
    outputBuffer.encodeUint16(breachCount)
    outputBuffer.encodeUint8(breachStatus)
    outputBuffer.encodeEnumValue(breachType.value, 1)
    outputBuffer.encodeEnumValue(breachMitigation.value, 1)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 162

    private const val CRC: Int = 189

    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 9

    private val DESERIALIZER: MavDeserializer<FenceStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val breachTime = inputBuffer.decodeUint32()
      val breachCount = inputBuffer.decodeUint16()
      val breachStatus = inputBuffer.decodeUint8()
      val breachType = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = FenceBreach.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val breachMitigation = inputBuffer.decodeEnumValue(1).let { value ->
        val entry = FenceMitigate.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      FenceStatus(
        breachStatus = breachStatus,
        breachCount = breachCount,
        breachType = breachType,
        breachTime = breachTime,
        breachMitigation = breachMitigation,
      )
    }


    private val METADATA: MavMessage.Metadata<FenceStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<FenceStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var breachStatus: Int = 0

    public var breachCount: Int = 0

    public var breachType: MavEnumValue<FenceBreach> = MavEnumValue.fromValue(0)

    public var breachTime: Long = 0L

    public var breachMitigation: MavEnumValue<FenceMitigate> = MavEnumValue.fromValue(0)

    public fun build(): FenceStatus = FenceStatus(
      breachStatus = breachStatus,
      breachCount = breachCount,
      breachType = breachType,
      breachTime = breachTime,
      breachMitigation = breachMitigation,
    )
  }
}
