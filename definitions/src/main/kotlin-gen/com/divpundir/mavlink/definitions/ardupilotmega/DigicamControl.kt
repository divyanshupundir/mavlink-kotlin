package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer

/**
 * Control on-board Camera Control System to take shots.
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
  public override val instanceCompanion: MavMessage.MavCompanion<DigicamControl> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(extraValue)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(session)
    buffer.encodeUInt8(zoomPos)
    buffer.encodeInt8(zoomStep)
    buffer.encodeUInt8(focusLock)
    buffer.encodeUInt8(shot)
    buffer.encodeUInt8(commandId)
    buffer.encodeUInt8(extraParam)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeFloat(extraValue)
    buffer.encodeUInt8(targetSystem)
    buffer.encodeUInt8(targetComponent)
    buffer.encodeUInt8(session)
    buffer.encodeUInt8(zoomPos)
    buffer.encodeInt8(zoomStep)
    buffer.encodeUInt8(focusLock)
    buffer.encodeUInt8(shot)
    buffer.encodeUInt8(commandId)
    buffer.encodeUInt8(extraParam)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DigicamControl> {
    public override val id: UInt = 155u

    public override val crcExtra: Byte = 22

    public override fun deserialize(bytes: ByteArray): DigicamControl {
      val buffer = Buffer().write(bytes)

      val extraValue = buffer.decodeFloat()
      val targetSystem = buffer.decodeUInt8()
      val targetComponent = buffer.decodeUInt8()
      val session = buffer.decodeUInt8()
      val zoomPos = buffer.decodeUInt8()
      val zoomStep = buffer.decodeInt8()
      val focusLock = buffer.decodeUInt8()
      val shot = buffer.decodeUInt8()
      val commandId = buffer.decodeUInt8()
      val extraParam = buffer.decodeUInt8()

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
