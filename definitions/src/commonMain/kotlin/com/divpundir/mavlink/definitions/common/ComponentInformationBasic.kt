package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavBitmaskValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeBitmaskValue
import com.divpundir.mavlink.serialization.encodeString
import com.divpundir.mavlink.serialization.encodeUInt32
import com.divpundir.mavlink.serialization.safeDecodeBitmaskValue
import com.divpundir.mavlink.serialization.safeDecodeString
import com.divpundir.mavlink.serialization.safeDecodeUInt32
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.UInt
import kotlin.Unit

/**
 * Basic component information data. Should be requested using MAV_CMD_REQUEST_MESSAGE on startup,
 * or when required.
 *
 * @param timeBootMs Timestamp (time since system boot).
 * units = ms
 * @param capabilities Component capability flags
 * @param timeManufactureS Date of manufacture as a UNIX Epoch time (since 1.1.1970) in seconds.
 * units = s
 * @param vendorName Name of the component vendor. Needs to be zero terminated. The field is
 * optional and can be empty/all zeros.
 * @param modelName Name of the component model. Needs to be zero terminated. The field is optional
 * and can be empty/all zeros.
 * @param softwareVersion Software version. The recommended format is SEMVER: 'major.minor.patch' 
 * (any format may be used). The field must be zero terminated if it has a value. The field is optional
 * and can be empty/all zeros.
 * @param hardwareVersion Hardware version. The recommended format is SEMVER: 'major.minor.patch' 
 * (any format may be used). The field must be zero terminated if it has a value. The field is optional
 * and can be empty/all zeros.
 * @param serialNumber Hardware serial number. The field must be zero terminated if it has a value.
 * The field is optional and can be empty/all zeros.
 */
@GeneratedMavMessage(
  id = 396u,
  crcExtra = 50,
)
public data class ComponentInformationBasic(
  /**
   * Timestamp (time since system boot).
   * units = ms
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeBootMs: UInt = 0u,
  /**
   * Component capability flags
   */
  @GeneratedMavField(type = "uint64_t")
  public val capabilities: MavBitmaskValue<MavProtocolCapability> = MavBitmaskValue.fromValue(0u),
  /**
   * Date of manufacture as a UNIX Epoch time (since 1.1.1970) in seconds.
   * units = s
   */
  @GeneratedMavField(type = "uint32_t")
  public val timeManufactureS: UInt = 0u,
  /**
   * Name of the component vendor. Needs to be zero terminated. The field is optional and can be
   * empty/all zeros.
   */
  @GeneratedMavField(type = "char[32]")
  public val vendorName: String = "",
  /**
   * Name of the component model. Needs to be zero terminated. The field is optional and can be
   * empty/all zeros.
   */
  @GeneratedMavField(type = "char[32]")
  public val modelName: String = "",
  /**
   * Software version. The recommended format is SEMVER: 'major.minor.patch'  (any format may be
   * used). The field must be zero terminated if it has a value. The field is optional and can be
   * empty/all zeros.
   */
  @GeneratedMavField(type = "char[24]")
  public val softwareVersion: String = "",
  /**
   * Hardware version. The recommended format is SEMVER: 'major.minor.patch'  (any format may be
   * used). The field must be zero terminated if it has a value. The field is optional and can be
   * empty/all zeros.
   */
  @GeneratedMavField(type = "char[24]")
  public val hardwareVersion: String = "",
  /**
   * Hardware serial number. The field must be zero terminated if it has a value. The field is
   * optional and can be empty/all zeros.
   */
  @GeneratedMavField(type = "char[32]")
  public val serialNumber: String = "",
) : MavMessage<ComponentInformationBasic> {
  override val instanceCompanion: MavMessage.MavCompanion<ComponentInformationBasic> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeBitmaskValue(capabilities.value, 8)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(timeManufactureS)
    encoder.encodeString(vendorName, 32)
    encoder.encodeString(modelName, 32)
    encoder.encodeString(softwareVersion, 24)
    encoder.encodeString(hardwareVersion, 24)
    encoder.encodeString(serialNumber, 32)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeBitmaskValue(capabilities.value, 8)
    encoder.encodeUInt32(timeBootMs)
    encoder.encodeUInt32(timeManufactureS)
    encoder.encodeString(vendorName, 32)
    encoder.encodeString(modelName, 32)
    encoder.encodeString(softwareVersion, 24)
    encoder.encodeString(hardwareVersion, 24)
    encoder.encodeString(serialNumber, 32)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<ComponentInformationBasic> {
    private const val SIZE_V1: Int = 160

    private const val SIZE_V2: Int = 160

    override val id: UInt = 396u

    override val crcExtra: Byte = 50

    override fun deserialize(bytes: ByteArray): ComponentInformationBasic {
      val decoder = MavDataDecoder(bytes)

      val capabilities = decoder.safeDecodeBitmaskValue(8).let { value ->
        val flags = MavProtocolCapability.getFlagsFromValue(value)
        if (flags.isNotEmpty()) MavBitmaskValue.of(flags) else MavBitmaskValue.fromValue(value)
      }
      val timeBootMs = decoder.safeDecodeUInt32()
      val timeManufactureS = decoder.safeDecodeUInt32()
      val vendorName = decoder.safeDecodeString(32)
      val modelName = decoder.safeDecodeString(32)
      val softwareVersion = decoder.safeDecodeString(24)
      val hardwareVersion = decoder.safeDecodeString(24)
      val serialNumber = decoder.safeDecodeString(32)

      return ComponentInformationBasic(
        timeBootMs = timeBootMs,
        capabilities = capabilities,
        timeManufactureS = timeManufactureS,
        vendorName = vendorName,
        modelName = modelName,
        softwareVersion = softwareVersion,
        hardwareVersion = hardwareVersion,
        serialNumber = serialNumber,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): ComponentInformationBasic =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var timeBootMs: UInt = 0u

    public var capabilities: MavBitmaskValue<MavProtocolCapability> = MavBitmaskValue.fromValue(0u)

    public var timeManufactureS: UInt = 0u

    public var vendorName: String = ""

    public var modelName: String = ""

    public var softwareVersion: String = ""

    public var hardwareVersion: String = ""

    public var serialNumber: String = ""

    public fun build(): ComponentInformationBasic = ComponentInformationBasic(
      timeBootMs = timeBootMs,
      capabilities = capabilities,
      timeManufactureS = timeManufactureS,
      vendorName = vendorName,
      modelName = modelName,
      softwareVersion = softwareVersion,
      hardwareVersion = hardwareVersion,
      serialNumber = serialNumber,
    )
  }
}
