package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt32
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
 * Illuminator status
 *
 * @param uptimeMs Time since the start-up of the illuminator in ms
 * units = ms
 * @param enable 0: Illuminators OFF, 1: Illuminators ON
 * @param modeBitmask Supported illuminator modes
 * @param errorStatus Errors
 * @param mode Illuminator mode
 * @param brightness Illuminator brightness
 * units = %
 * @param strobePeriod Illuminator strobing period in seconds
 * units = s
 * @param strobeDutyCycle Illuminator strobing duty cycle
 * units = %
 * @param tempC Temperature in Celsius
 * @param minStrobePeriod Minimum strobing period in seconds
 * units = s
 * @param maxStrobePeriod Maximum strobing period in seconds
 * units = s
 */
@GeneratedMavMessage(
  id = 440u,
  crcExtra = 66,
)
public data class IlluminatorStatus(
  /**
   * Time since the start-up of the illuminator in ms
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val uptimeMs: UInt = 0u,
  /**
   * 0: Illuminators OFF, 1: Illuminators ON
   */
  @GeneratedMavField(type = "uint8_t")
  public val enable: UByte = 0u,
  /**
   * Supported illuminator modes
   */
  @GeneratedMavField(type = "uint8_t")
  public val modeBitmask: MavEnumValue<IlluminatorMode> = MavEnumValue.fromValue(0u),
  /**
   * Errors
   */
  @GeneratedMavField(type = "uint32_t")
  public val errorStatus: MavBitmaskValue<IlluminatorErrorFlags> = MavBitmaskValue.fromValue(0u),
  /**
   * Illuminator mode
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: MavEnumValue<IlluminatorMode> = MavEnumValue.fromValue(0u),
  /**
   * Illuminator brightness
   * units = %
   */
  @GeneratedMavField(type = "float")
  public val brightness: Float = 0F,
  /**
   * Illuminator strobing period in seconds
   * units = s
   */
  @GeneratedMavField(type = "float")
  public val strobePeriod: Float = 0F,
  /**
   * Illuminator strobing duty cycle
   * units = %
   */
  @GeneratedMavField(type = "float")
  public val strobeDutyCycle: Float = 0F,
  /**
   * Temperature in Celsius
   */
  @GeneratedMavField(type = "float")
  public val tempC: Float = 0F,
  /**
   * Minimum strobing period in seconds
   * units = s
   */
  @GeneratedMavField(type = "float")
  public val minStrobePeriod: Float = 0F,
  /**
   * Maximum strobing period in seconds
   * units = s
   */
  @GeneratedMavField(type = "float")
  public val maxStrobePeriod: Float = 0F,
) : MavMessage<IlluminatorStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<IlluminatorStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt32(uptimeMs)
    encoder.encodeBitmaskValue(errorStatus.value, 4)
    encoder.encodeFloat(brightness)
    encoder.encodeFloat(strobePeriod)
    encoder.encodeFloat(strobeDutyCycle)
    encoder.encodeFloat(tempC)
    encoder.encodeFloat(minStrobePeriod)
    encoder.encodeFloat(maxStrobePeriod)
    encoder.encodeUInt8(enable)
    encoder.encodeEnumValue(modeBitmask.value, 1)
    encoder.encodeEnumValue(mode.value, 1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt32(uptimeMs)
    encoder.encodeBitmaskValue(errorStatus.value, 4)
    encoder.encodeFloat(brightness)
    encoder.encodeFloat(strobePeriod)
    encoder.encodeFloat(strobeDutyCycle)
    encoder.encodeFloat(tempC)
    encoder.encodeFloat(minStrobePeriod)
    encoder.encodeFloat(maxStrobePeriod)
    encoder.encodeUInt8(enable)
    encoder.encodeEnumValue(modeBitmask.value, 1)
    encoder.encodeEnumValue(mode.value, 1)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<IlluminatorStatus> {
    private const val SIZE_V1: Int = 35

    private const val SIZE_V2: Int = 35

    override val id: UInt = 440u

    override val crcExtra: Byte = 66

    override fun deserialize(bytes: ByteArray): IlluminatorStatus {
      val decoder = MavDataDecoder(bytes)

      val uptimeMs = decoder.safeDecodeUInt32()
      val errorStatus = decoder.safeDecodeBitmaskValue(4).let { value ->
        val flags = IlluminatorErrorFlags.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val brightness = decoder.safeDecodeFloat()
      val strobePeriod = decoder.safeDecodeFloat()
      val strobeDutyCycle = decoder.safeDecodeFloat()
      val tempC = decoder.safeDecodeFloat()
      val minStrobePeriod = decoder.safeDecodeFloat()
      val maxStrobePeriod = decoder.safeDecodeFloat()
      val enable = decoder.safeDecodeUInt8()
      val modeBitmask = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IlluminatorMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val mode = decoder.safeDecodeEnumValue(1).let { value ->
        val entry = IlluminatorMode.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }

      return IlluminatorStatus(
        uptimeMs = uptimeMs,
        enable = enable,
        modeBitmask = modeBitmask,
        errorStatus = errorStatus,
        mode = mode,
        brightness = brightness,
        strobePeriod = strobePeriod,
        strobeDutyCycle = strobeDutyCycle,
        tempC = tempC,
        minStrobePeriod = minStrobePeriod,
        maxStrobePeriod = maxStrobePeriod,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): IlluminatorStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var uptimeMs: UInt = 0u

    public var enable: UByte = 0u

    public var modeBitmask: MavEnumValue<IlluminatorMode> = MavEnumValue.fromValue(0u)

    public var errorStatus: MavBitmaskValue<IlluminatorErrorFlags> = MavBitmaskValue.fromValue(0u)

    public var mode: MavEnumValue<IlluminatorMode> = MavEnumValue.fromValue(0u)

    public var brightness: Float = 0F

    public var strobePeriod: Float = 0F

    public var strobeDutyCycle: Float = 0F

    public var tempC: Float = 0F

    public var minStrobePeriod: Float = 0F

    public var maxStrobePeriod: Float = 0F

    public fun build(): IlluminatorStatus = IlluminatorStatus(
      uptimeMs = uptimeMs,
      enable = enable,
      modeBitmask = modeBitmask,
      errorStatus = errorStatus,
      mode = mode,
      brightness = brightness,
      strobePeriod = strobePeriod,
      strobeDutyCycle = strobeDutyCycle,
      tempC = tempC,
      minStrobePeriod = minStrobePeriod,
      maxStrobePeriod = maxStrobePeriod,
    )
  }
}
