package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Control vehicle tone generation (buzzer).
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param tune tune in board specific format
 * @param tune2 tune extension (appended to tune)
 */
@Deprecated(message = "New version explicitly defines format. More interoperable.")
@GeneratedMavMessage(
  id = 258u,
  crcExtra = -69,
)
public data class PlayTune(
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
   * tune in board specific format
   */
  @GeneratedMavField(type = "char[30]")
  public val tune: String = "",
  /**
   * tune extension (appended to tune)
   */
  @GeneratedMavField(
    type = "char[200]",
    extension = true,
  )
  public val tune2: String = "",
) : MavMessage<PlayTune> {
  override val instanceCompanion: MavMessage.MavCompanion<PlayTune> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(tune, 30)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeString(tune, 30)
    encoder.encodeString(tune2, 200)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PlayTune> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 232

    override val id: UInt = 258u

    override val crcExtra: Byte = -69

    override fun deserialize(bytes: ByteArray): PlayTune {
      val decoder = MavDataDecoder(bytes)

      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val tune = decoder.safeDecodeString(30)
      val tune2 = decoder.safeDecodeString(200)

      return PlayTune(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        tune = tune,
        tune2 = tune2,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): PlayTune =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var tune: String = ""

    public var tune2: String = ""

    public fun build(): PlayTune = PlayTune(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      tune = tune,
      tune2 = tune2,
    )
  }
}
