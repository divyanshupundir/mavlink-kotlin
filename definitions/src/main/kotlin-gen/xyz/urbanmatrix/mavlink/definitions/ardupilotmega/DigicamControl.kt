package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeInt8
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Control on-board Camera Control System to take shots.
 */
@GeneratedMavMessage(
  id = 155,
  crc = 22,
)
public data class DigicamControl(
  /**
   * System ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * Component ID.
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: Int = 0,
  /**
   * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens.
   */
  @GeneratedMavField(type = "uint8_t")
  public val session: Int = 0,
  /**
   * 1 to N //Zoom's absolute position (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val zoomPos: Int = 0,
  /**
   * -100 to 100 //Zooming step value to offset zoom from the current position.
   */
  @GeneratedMavField(type = "int8_t")
  public val zoomStep: Int = 0,
  /**
   * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus.
   */
  @GeneratedMavField(type = "uint8_t")
  public val focusLock: Int = 0,
  /**
   * 0: ignore, 1: shot or start filming.
   */
  @GeneratedMavField(type = "uint8_t")
  public val shot: Int = 0,
  /**
   * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed
   * or pooled just once.
   */
  @GeneratedMavField(type = "uint8_t")
  public val commandId: Int = 0,
  /**
   * Extra parameters enumeration (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val extraParam: Int = 0,
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
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(session)
    outputBuffer.encodeUint8(zoomPos)
    outputBuffer.encodeInt8(zoomStep)
    outputBuffer.encodeUint8(focusLock)
    outputBuffer.encodeUint8(shot)
    outputBuffer.encodeUint8(commandId)
    outputBuffer.encodeUint8(extraParam)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(session)
    outputBuffer.encodeUint8(zoomPos)
    outputBuffer.encodeInt8(zoomStep)
    outputBuffer.encodeUint8(focusLock)
    outputBuffer.encodeUint8(shot)
    outputBuffer.encodeUint8(commandId)
    outputBuffer.encodeUint8(extraParam)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 155

    private const val CRC: Int = 22

    private const val SIZE_V1: Int = 13

    private const val SIZE_V2: Int = 13

    private val DESERIALIZER: MavDeserializer<DigicamControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val extraValue = inputBuffer.decodeFloat()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val session = inputBuffer.decodeUint8()
      val zoomPos = inputBuffer.decodeUint8()
      val zoomStep = inputBuffer.decodeInt8()
      val focusLock = inputBuffer.decodeUint8()
      val shot = inputBuffer.decodeUint8()
      val commandId = inputBuffer.decodeUint8()
      val extraParam = inputBuffer.decodeUint8()

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

    public fun builder(builderAction: Builder.() -> Unit): DigicamControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var session: Int = 0

    public var zoomPos: Int = 0

    public var zoomStep: Int = 0

    public var focusLock: Int = 0

    public var shot: Int = 0

    public var commandId: Int = 0

    public var extraParam: Int = 0

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
