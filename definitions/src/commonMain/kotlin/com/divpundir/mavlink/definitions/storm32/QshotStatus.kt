package com.divpundir.mavlink.definitions.storm32

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.api.WorkInProgress
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Information about the shot operation.
 */
@WorkInProgress
@GeneratedMavMessage(
  id = 60_020u,
  crcExtra = -54,
)
public data class QshotStatus(
  /**
   * Current shot mode.
   */
  @GeneratedMavField(type = "uint16_t")
  public val mode: MavEnumValue<MavQshotMode> = MavEnumValue.fromValue(0u),
  /**
   * Current state in the shot. States are specific to the selected shot mode.
   */
  @GeneratedMavField(type = "uint16_t")
  public val shotState: UShort = 0u,
) : MavMessage<QshotStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<QshotStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeEnumValue(mode.value, 2)
    encoder.encodeUInt16(shotState)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeEnumValue(mode.value, 2)
    encoder.encodeUInt16(shotState)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<QshotStatus> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    public override val id: UInt = 60_020u

    public override val crcExtra: Byte = -54

    public override fun deserialize(bytes: ByteArray): QshotStatus {
      val decoder = MavDataDecoder(bytes)

      val mode = decoder.safeDecodeEnumValue(2).let { value ->
        val entry = MavQshotMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val shotState = decoder.safeDecodeUInt16()

      return QshotStatus(
        mode = mode,
        shotState = shotState,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): QshotStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mode: MavEnumValue<MavQshotMode> = MavEnumValue.fromValue(0u)

    public var shotState: UShort = 0u

    public fun build(): QshotStatus = QshotStatus(
      mode = mode,
      shotState = shotState,
    )
  }
}
