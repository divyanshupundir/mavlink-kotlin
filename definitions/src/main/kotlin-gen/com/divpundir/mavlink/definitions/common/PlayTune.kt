package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeString
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
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
  public override val instanceCompanion: MavMessage.MavCompanion<PlayTune> = Companion

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeString(tune, 30)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeString(tune, 30)
    outputBuffer.encodeString(tune2, 200)
    return outputBuffer.array().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<PlayTune> {
    private const val SIZE_V1: Int = 32

    private const val SIZE_V2: Int = 232

    public override val id: UInt = 258u

    public override val crcExtra: Byte = -69

    public override fun deserialize(bytes: ByteArray): PlayTune {
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val tune = inputBuffer.decodeString(30)
      val tune2 = inputBuffer.decodeString(200)

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
