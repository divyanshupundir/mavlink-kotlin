package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 * Configure on-board Camera Control System.
 *
 * @param targetSystem System ID.
 * @param targetComponent Component ID.
 * @param mode Mode enumeration from 1 to N //P, TV, AV, M, etc. (0 means ignore).
 * @param shutterSpeed Divisor number //e.g. 1000 means 1/1000 (0 means ignore).
 * @param aperture F stop number x 10 //e.g. 28 means 2.8 (0 means ignore).
 * @param iso ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore).
 * @param exposureType Exposure type enumeration from 1 to N (0 means ignore).
 * @param commandId Command Identity (incremental loop: 0 to 255). //A command sent multiple times
 * will be executed or pooled just once.
 * @param engineCutOff Main engine cut-off time before camera trigger (0 means no cut-off).
 * units = ds
 * @param extraParam Extra parameters enumeration (0 means ignore).
 * @param extraValue Correspondent value to given extra_param.
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
   * units = ds
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
  override val instanceCompanion: MavMessage.MavCompanion<DigicamConfigure> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(extraValue)
    encoder.encodeUInt16(shutterSpeed)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(mode)
    encoder.encodeUInt8(aperture)
    encoder.encodeUInt8(iso)
    encoder.encodeUInt8(exposureType)
    encoder.encodeUInt8(commandId)
    encoder.encodeUInt8(engineCutOff)
    encoder.encodeUInt8(extraParam)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(extraValue)
    encoder.encodeUInt16(shutterSpeed)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    encoder.encodeUInt8(mode)
    encoder.encodeUInt8(aperture)
    encoder.encodeUInt8(iso)
    encoder.encodeUInt8(exposureType)
    encoder.encodeUInt8(commandId)
    encoder.encodeUInt8(engineCutOff)
    encoder.encodeUInt8(extraParam)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<DigicamConfigure> {
    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    override val id: UInt = 154u

    override val crcExtra: Byte = 84

    override fun deserialize(bytes: ByteArray): DigicamConfigure {
      val decoder = MavDataDecoder(bytes)

      val extraValue = decoder.safeDecodeFloat()
      val shutterSpeed = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()
      val mode = decoder.safeDecodeUInt8()
      val aperture = decoder.safeDecodeUInt8()
      val iso = decoder.safeDecodeUInt8()
      val exposureType = decoder.safeDecodeUInt8()
      val commandId = decoder.safeDecodeUInt8()
      val engineCutOff = decoder.safeDecodeUInt8()
      val extraParam = decoder.safeDecodeUInt8()

      return DigicamConfigure(
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

    public operator fun invoke(builderAction: Builder.() -> Unit): DigicamConfigure =
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
