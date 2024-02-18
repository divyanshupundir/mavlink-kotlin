package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 * Control on-board Camera Control System to take shots.
 *
 */
@GeneratedMavMessage(
  id = 155u,
  crcExtra = 22,
)
public data class DigicamControl(
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
   * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens.
   */
  @GeneratedMavField(type = "uint8_t")
  public val session: UByte = 0u,
  /**
   * 1 to N //Zoom's absolute position (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val zoomPos: UByte = 0u,
  /**
   * -100 to 100 //Zooming step value to offset zoom from the current position.
   */
  @GeneratedMavField(type = "int8_t")
  public val zoomStep: Byte = 0,
  /**
   * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus.
   */
  @GeneratedMavField(type = "uint8_t")
  public val focusLock: UByte = 0u,
  /**
   * 0: ignore, 1: shot or start filming.
   */
  @GeneratedMavField(type = "uint8_t")
  public val shot: UByte = 0u,
  /**
   * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed
   * or pooled just once.
   */
  @GeneratedMavField(type = "uint8_t")
  public val commandId: UByte = 0u,
  /**
   * Extra parameters enumeration (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val extraParam: UByte = 0u,
  /**
   * Correspondent value to given extra_param.
   */
  @GeneratedMavField(type = "float")
  public val extraValue: Float = 0F,
) : MavMessage<DigicamControl> {
  override val instanceCompanion: MavMessage.MavCompanion<DigicamControl> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(extraValue)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(session)
    encoder.encodeUInt8(zoomPos)
    encoder.encodeInt8(zoomStep)
    encoder.encodeUInt8(focusLock)
    encoder.encodeUInt8(shot)
    encoder.encodeUInt8(commandId)
    encoder.encodeUInt8(extraParam)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(extraValue)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(session)
    encoder.encodeUInt8(zoomPos)
    encoder.encodeInt8(zoomStep)
    encoder.encodeUInt8(focusLock)
    encoder.encodeUInt8(shot)
    encoder.encodeUInt8(commandId)
    encoder.encodeUInt8(extraParam)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DigicamControl> {
    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    override val id: UInt = 155u

    override val crcExtra: Byte = 22

    override fun deserialize(bytes: ByteArray): DigicamControl {
      val decoder = MavDataDecoder(bytes)

      val extraValue = decoder.safeDecodeFloat()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val session = decoder.safeDecodeUInt8()
      val zoomPos = decoder.safeDecodeUInt8()
      val zoomStep = decoder.safeDecodeInt8()
      val focusLock = decoder.safeDecodeUInt8()
      val shot = decoder.safeDecodeUInt8()
      val commandId = decoder.safeDecodeUInt8()
      val extraParam = decoder.safeDecodeUInt8()

      return DigicamControl(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        session = session,
        zoomPos = zoomPos,
        zoomStep = zoomStep,
        focusLock = focusLock,
        shot = shot,
        commandId = commandId,
        extraParam = extraParam,
        extraValue = extraValue,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): DigicamControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var session: UByte = 0u

    public var zoomPos: UByte = 0u

    public var zoomStep: Byte = 0

    public var focusLock: UByte = 0u

    public var shot: UByte = 0u

    public var commandId: UByte = 0u

    public var extraParam: UByte = 0u

    public var extraValue: Float = 0F

    public fun build(): DigicamControl = DigicamControl(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      session = session,
      zoomPos = zoomPos,
      zoomStep = zoomStep,
      focusLock = focusLock,
      shot = shot,
      commandId = commandId,
      extraParam = extraParam,
      extraValue = extraValue,
    )
  }
}
