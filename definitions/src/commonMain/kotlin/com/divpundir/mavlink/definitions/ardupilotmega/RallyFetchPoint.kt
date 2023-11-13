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
 * Request a current rally point from MAV. MAV should respond with a RALLY_POINT message. MAV should
 * not respond if the request is invalid.
 */
@GeneratedMavMessage(
  id = 176u,
  crcExtra = -22,
)
public data class RallyFetchPoint(
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
   * Point index (first point is 0).
   */
  @GeneratedMavField(type = "uint8_t")
  public val idx: UByte = 0u,
) : MavMessage<RallyFetchPoint> {
  public override val instanceCompanion: MavMessage.MavCompanion<RallyFetchPoint> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(idx)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(idx)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<RallyFetchPoint> {
    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    public override val id: UInt = 176u

    public override val crcExtra: Byte = -22

    public override fun deserialize(bytes: ByteArray): RallyFetchPoint {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val idx = decoder.safeDecodeUInt8()

      return RallyFetchPoint(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        idx = idx,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): RallyFetchPoint =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var idx: UByte = 0u

    public fun build(): RallyFetchPoint = RallyFetchPoint(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      idx = idx,
    )
  }
}
