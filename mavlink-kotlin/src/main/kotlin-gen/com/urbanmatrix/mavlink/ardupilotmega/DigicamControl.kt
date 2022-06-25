package com.urbanmatrix.mavlink.ardupilotmega

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeFloat
import com.urbanmatrix.mavlink.serialization.decodeInt8
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.encodeFloat
import com.urbanmatrix.mavlink.serialization.encodeInt8
import com.urbanmatrix.mavlink.serialization.encodeUint8
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int

/**
 * Control on-board Camera Control System to take shots.
 */
public data class DigicamControl(
  /**
   * System ID.
   */
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  public val targetComponent: Int = 0,
  /**
   * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens.
   */
  public val session: Int = 0,
  /**
   * 1 to N //Zoom's absolute position (0 means ignore).
   */
  public val zoomPos: Int = 0,
  /**
   * -100 to 100 //Zooming step value to offset zoom from the current position.
   */
  public val zoomStep: Int = 0,
  /**
   * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus.
   */
  public val focusLock: Int = 0,
  /**
   * 0: ignore, 1: shot or start filming.
   */
  public val shot: Int = 0,
  /**
   * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed
   * or pooled just once.
   */
  public val commandId: Int = 0,
  /**
   * Extra parameters enumeration (0 means ignore).
   */
  public val extraParam: Int = 0,
  /**
   * Correspondent value to given extra_param.
   */
  public val extraValue: Float = 0F,
) : MavMessage<DigicamControl> {
  public override val instanceMetadata: MavMessage.Metadata<DigicamControl> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(13).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(session)
    outputBuffer.encodeUint8(zoomPos)
    outputBuffer.encodeInt8(zoomStep)
    outputBuffer.encodeUint8(focusLock)
    outputBuffer.encodeUint8(shot)
    outputBuffer.encodeUint8(commandId)
    outputBuffer.encodeUint8(extraParam)
    outputBuffer.encodeFloat(extraValue)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 155

    private const val CRC: Int = 242

    private val DESERIALIZER: MavDeserializer<DigicamControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val session = inputBuffer.decodeUint8()
      val zoomPos = inputBuffer.decodeUint8()
      val zoomStep = inputBuffer.decodeInt8()
      val focusLock = inputBuffer.decodeUint8()
      val shot = inputBuffer.decodeUint8()
      val commandId = inputBuffer.decodeUint8()
      val extraParam = inputBuffer.decodeUint8()
      val extraValue = inputBuffer.decodeFloat()
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


    private val METADATA: MavMessage.Metadata<DigicamControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DigicamControl> = METADATA
  }
}
