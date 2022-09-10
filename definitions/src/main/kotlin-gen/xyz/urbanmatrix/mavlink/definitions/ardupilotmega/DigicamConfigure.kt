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
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Configure on-board Camera Control System.
 */
@GeneratedMavMessage(
  id = 154,
  crc = 84,
)
public data class DigicamConfigure(
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
   * Mode enumeration from 1 to N //P, TV, AV, M, etc. (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: Int = 0,
  /**
   * Divisor number //e.g. 1000 means 1/1000 (0 means ignore).
   */
  @GeneratedMavField(type = "uint16_t")
  public val shutterSpeed: Int = 0,
  /**
   * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val aperture: Int = 0,
  /**
   * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val iso: Int = 0,
  /**
   * Exposure type enumeration from 1 to N (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val exposureType: Int = 0,
  /**
   * Command Identity (incremental loop: 0 to 255). //A command sent multiple times will be executed
   * or pooled just once.
   */
  @GeneratedMavField(type = "uint8_t")
  public val commandId: Int = 0,
  /**
   * Main engine cut-off time before camera trigger (0 means no cut-off).
   */
  @GeneratedMavField(type = "uint8_t")
  public val engineCutOff: Int = 0,
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
) : MavMessage<DigicamConfigure> {
  public override val instanceMetadata: MavMessage.Metadata<DigicamConfigure> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUint16(shutterSpeed)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(mode)
    outputBuffer.encodeUint8(aperture)
    outputBuffer.encodeUint8(iso)
    outputBuffer.encodeUint8(exposureType)
    outputBuffer.encodeUint8(commandId)
    outputBuffer.encodeUint8(engineCutOff)
    outputBuffer.encodeUint8(extraParam)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUint16(shutterSpeed)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(mode)
    outputBuffer.encodeUint8(aperture)
    outputBuffer.encodeUint8(iso)
    outputBuffer.encodeUint8(exposureType)
    outputBuffer.encodeUint8(commandId)
    outputBuffer.encodeUint8(engineCutOff)
    outputBuffer.encodeUint8(extraParam)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 154

    private const val CRC: Int = 84

    private const val SIZE: Int = 15

    private val DESERIALIZER: MavDeserializer<DigicamConfigure> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val extraValue = inputBuffer.decodeFloat()
      val shutterSpeed = inputBuffer.decodeUint16()
      val targetSystem = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val mode = inputBuffer.decodeUint8()
      val aperture = inputBuffer.decodeUint8()
      val iso = inputBuffer.decodeUint8()
      val exposureType = inputBuffer.decodeUint8()
      val commandId = inputBuffer.decodeUint8()
      val engineCutOff = inputBuffer.decodeUint8()
      val extraParam = inputBuffer.decodeUint8()

      DigicamConfigure(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        mode = mode,
        shutterSpeed = shutterSpeed,
        aperture = aperture,
        iso = iso,
        exposureType = exposureType,
        commandId = commandId,
        engineCutOff = engineCutOff,
        extraParam = extraParam,
        extraValue = extraValue,
      )
    }


    private val METADATA: MavMessage.Metadata<DigicamConfigure> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DigicamConfigure> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var targetComponent: Int = 0

    public var mode: Int = 0

    public var shutterSpeed: Int = 0

    public var aperture: Int = 0

    public var iso: Int = 0

    public var exposureType: Int = 0

    public var commandId: Int = 0

    public var engineCutOff: Int = 0

    public var extraParam: Int = 0

    public var extraValue: Float = 0F

    public fun build(): DigicamConfigure = DigicamConfigure(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      mode = mode,
      shutterSpeed = shutterSpeed,
      aperture = aperture,
      iso = iso,
      exposureType = exposureType,
      commandId = commandId,
      engineCutOff = engineCutOff,
      extraParam = extraParam,
      extraValue = extraValue,
    )
  }
}
