package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavDeserializer
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeInt8
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeInt8
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

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
  public override val instanceMetadata: MavMessage.Metadata<DigicamControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(session)
    outputBuffer.encodeUInt8(zoomPos)
    outputBuffer.encodeInt8(zoomStep)
    outputBuffer.encodeUInt8(focusLock)
    outputBuffer.encodeUInt8(shot)
    outputBuffer.encodeUInt8(commandId)
    outputBuffer.encodeUInt8(extraParam)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(session)
    outputBuffer.encodeUInt8(zoomPos)
    outputBuffer.encodeInt8(zoomStep)
    outputBuffer.encodeUInt8(focusLock)
    outputBuffer.encodeUInt8(shot)
    outputBuffer.encodeUInt8(commandId)
    outputBuffer.encodeUInt8(extraParam)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 155u

    private const val CRC_EXTRA: Byte = 22

    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    private val DESERIALIZER: MavDeserializer<DigicamControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val extraValue = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val session = inputBuffer.decodeUInt8()
      val zoomPos = inputBuffer.decodeUInt8()
      val zoomStep = inputBuffer.decodeInt8()
      val focusLock = inputBuffer.decodeUInt8()
      val shot = inputBuffer.decodeUInt8()
      val commandId = inputBuffer.decodeUInt8()
      val extraParam = inputBuffer.decodeUInt8()

      DigicamControl(
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


    private val METADATA: MavMessage.Metadata<DigicamControl> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DigicamControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DigicamControl =
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
