package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

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
  public override val instanceCompanion: MavMessage.MavCompanion<DigicamConfigure> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(extraValue)
    output.encodeUInt16(shutterSpeed)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(mode)
    output.encodeUInt8(aperture)
    output.encodeUInt8(iso)
    output.encodeUInt8(exposureType)
    output.encodeUInt8(commandId)
    output.encodeUInt8(engineCutOff)
    output.encodeUInt8(extraParam)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(extraValue)
    output.encodeUInt16(shutterSpeed)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.encodeUInt8(mode)
    output.encodeUInt8(aperture)
    output.encodeUInt8(iso)
    output.encodeUInt8(exposureType)
    output.encodeUInt8(commandId)
    output.encodeUInt8(engineCutOff)
    output.encodeUInt8(extraParam)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<DigicamConfigure> {
    private const val SIZE_V1: Int = 15

    private const val SIZE_V2: Int = 15

    public override val id: UInt = 154u

    public override val crcExtra: Byte = 84

    public override fun deserialize(source: BufferedSource): DigicamConfigure {
      val extraValue = source.decodeFloat()
      val shutterSpeed = source.decodeUInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()
      val mode = source.decodeUInt8()
      val aperture = source.decodeUInt8()
      val iso = source.decodeUInt8()
      val exposureType = source.decodeUInt8()
      val commandId = source.decodeUInt8()
      val engineCutOff = source.decodeUInt8()
      val extraParam = source.decodeUInt8()

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
