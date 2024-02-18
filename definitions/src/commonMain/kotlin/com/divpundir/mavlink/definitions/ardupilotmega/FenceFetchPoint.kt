package com.divpundir.mavlink.definitions.ardupilotmega

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
 * Request a current fence point from MAV.
 *
 */
@GeneratedMavMessage(
  id = 161u,
  crcExtra = 68,
)
public data class FenceFetchPoint(
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
   * Point index (first point is 1, 0 is for return point).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: UByte = 0u,
) : MavMessage<FenceFetchPoint> {
  override val instanceCompanion: MavMessage.MavCompanion<FenceFetchPoint> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(idx)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(idx)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FenceFetchPoint> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    override val id: UInt = 161u

    override val crcExtra: Byte = 68

    override fun deserialize(bytes: ByteArray): FenceFetchPoint {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idx = decoder.safeDecodeUInt8()

      return FenceFetchPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FenceFetchPoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idx: UByte = 0u

    public fun build(): FenceFetchPoint = FenceFetchPoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
    )
  }
}
