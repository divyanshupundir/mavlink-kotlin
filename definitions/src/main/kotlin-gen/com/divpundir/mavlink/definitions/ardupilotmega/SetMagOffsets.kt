package com.divpundir.mavlink.definitions.ardupilotmega

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeInt16
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.encodeInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Deprecated
import kotlin.Int
import kotlin.Short
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import okio.Buffer
import okio.BufferedSource

/**
 * Set the magnetometer offsets
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 151u,
  crcExtra = -37,
)
public data class SetMagOffsets(
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
   * Magnetometer X offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsX: Short = 0,
  /**
   * Magnetometer Y offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsY: Short = 0,
  /**
   * Magnetometer Z offset.
   */
  @GeneratedMavField(type = "int16_t")
  public val magOfsZ: Short = 0,
) : MavMessage<SetMagOffsets> {
  public override val instanceCompanion: MavMessage.MavCompanion<SetMagOffsets> = Companion

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(magOfsX)
    output.encodeInt16(magOfsY)
    output.encodeInt16(magOfsZ)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeInt16(magOfsX)
    output.encodeInt16(magOfsY)
    output.encodeInt16(magOfsZ)
    output.encodeUInt8(targetSystem)
    output.encodeUInt8(targetComponent)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<SetMagOffsets> {
    private const val SIZE_V1: Int = 8

    private const val SIZE_V2: Int = 8

    public override val id: UInt = 151u

    public override val crcExtra: Byte = -37

    public override fun deserialize(source: BufferedSource): SetMagOffsets {
      val magOfsX = source.decodeInt16()
      val magOfsY = source.decodeInt16()
      val magOfsZ = source.decodeInt16()
      val targetSystem = source.decodeUInt8()
      val targetComponent = source.decodeUInt8()

      return SetMagOffsets(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        magOfsX = magOfsX,
        magOfsY = magOfsY,
        magOfsZ = magOfsZ,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SetMagOffsets =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var magOfsX: Short = 0

    public var magOfsY: Short = 0

    public var magOfsZ: Short = 0

    public fun build(): SetMagOffsets = SetMagOffsets(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      magOfsX = magOfsX,
      magOfsY = magOfsY,
      magOfsZ = magOfsZ,
    )
  }
}
