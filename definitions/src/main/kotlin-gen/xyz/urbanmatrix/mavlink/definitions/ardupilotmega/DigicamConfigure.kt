package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeFloat
import xyz.urbanmatrix.mavlink.serialization.decodeUInt16
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeFloat
import xyz.urbanmatrix.mavlink.serialization.encodeUInt16
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Configure on-board Camera Control System.
 */
@GeneratedMavMessage(
  id = 154u,
  crcExtra = 84,
)
public data class DigicamConfigure(
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
   * Mode enumeration from 1 to N //P, TV, AV, M, etc. (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: UByte = 0u,
  /**
   * Divisor number //e.g. 1000 means 1/1000 (0 means ignore).
   */
  @GeneratedMavField(type = "uint16_t")
  public val shutterSpeed: UShort = 0u,
  /**
   * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val aperture: UByte = 0u,
  /**
   * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val iso: UByte = 0u,
  /**
   * Exposure type enumeration from 1 to N (0 means ignore).
   */
  @GeneratedMavField(type = "uint8_t")
  public val exposureType: UByte = 0u,
  /**
   * Command Identity (incremental loop: 0 to 255). //A command sent multiple times will be executed
   * or pooled just once.
   */
  @GeneratedMavField(type = "uint8_t")
  public val commandId: UByte = 0u,
  /**
   * Main engine cut-off time before camera trigger (0 means no cut-off).
   */
  @GeneratedMavField(type = "uint8_t")
  public val engineCutOff: UByte = 0u,
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
) : MavMessage<DigicamConfigure> {
  public override val instanceMetadata: MavMessage.Metadata<DigicamConfigure> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUInt16(shutterSpeed)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(mode)
    outputBuffer.encodeUInt8(aperture)
    outputBuffer.encodeUInt8(iso)
    outputBuffer.encodeUInt8(exposureType)
    outputBuffer.encodeUInt8(commandId)
    outputBuffer.encodeUInt8(engineCutOff)
    outputBuffer.encodeUInt8(extraParam)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeFloat(extraValue)
    outputBuffer.encodeUInt16(shutterSpeed)
    outputBuffer.encodeUInt8(targetSystem)
    outputBuffer.encodeUInt8(targetComponent)
    outputBuffer.encodeUInt8(mode)
    outputBuffer.encodeUInt8(aperture)
    outputBuffer.encodeUInt8(iso)
    outputBuffer.encodeUInt8(exposureType)
    outputBuffer.encodeUInt8(commandId)
    outputBuffer.encodeUInt8(engineCutOff)
    outputBuffer.encodeUInt8(extraParam)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 154u

    private const val CRC_EXTRA: Byte = 84

    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    private val DESERIALIZER: MavDeserializer<DigicamConfigure> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val extraValue = inputBuffer.decodeFloat()
      val shutterSpeed = inputBuffer.decodeUInt16()
      val targetSystem = inputBuffer.decodeUInt8()
      val targetComponent = inputBuffer.decodeUInt8()
      val mode = inputBuffer.decodeUInt8()
      val aperture = inputBuffer.decodeUInt8()
      val iso = inputBuffer.decodeUInt8()
      val exposureType = inputBuffer.decodeUInt8()
      val commandId = inputBuffer.decodeUInt8()
      val engineCutOff = inputBuffer.decodeUInt8()
      val extraParam = inputBuffer.decodeUInt8()

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


    private val METADATA: MavMessage.Metadata<DigicamConfigure> = MavMessage.Metadata(ID, CRC_EXTRA,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<DigicamConfigure> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): DigicamConfigure =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var mode: UByte = 0u

    public var shutterSpeed: UShort = 0u

    public var aperture: UByte = 0u

    public var iso: UByte = 0u

    public var exposureType: UByte = 0u

    public var commandId: UByte = 0u

    public var engineCutOff: UByte = 0u

    public var extraParam: UByte = 0u

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
