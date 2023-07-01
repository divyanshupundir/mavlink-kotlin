package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeFloat
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Extended state information for ASLUAVs
 */
@GeneratedMavMessage(
  id = 8_006u,
  crcExtra = 97,
)
public data class AsluavStatus(
  /**
   *  Status of the position-indicator LEDs
   */
  @GeneratedMavField(type = "uint8_t")
  public val ledStatus: UByte = 0u,
  /**
   *  Status of the IRIDIUM satellite communication system
   */
  @GeneratedMavField(type = "uint8_t")
  public val satcomStatus: UByte = 0u,
  /**
   *  Status vector for up to 8 servos
   */
  @GeneratedMavField(type = "uint8_t[8]")
  public val servoStatus: List<UByte> = emptyList(),
  /**
   *  Motor RPM 
   */
  @GeneratedMavField(type = "float")
  public val motorRpm: Float = 0F,
) : MavMessage<AsluavStatus> {
  public override val instanceCompanion: MavMessage.MavCompanion<AsluavStatus> = Companion

  public override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V1)
    encoder.encodeFloat(motorRpm)
    encoder.encodeUInt8(ledStatus)
    encoder.encodeUInt8(satcomStatus)
    encoder.encodeUInt8Array(servoStatus, 8)
    return encoder.bytes
  }

  public override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder.allocate(SIZE_V2)
    encoder.encodeFloat(motorRpm)
    encoder.encodeUInt8(ledStatus)
    encoder.encodeUInt8(satcomStatus)
    encoder.encodeUInt8Array(servoStatus, 8)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<AsluavStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    public override val id: UInt = 8_006u

    public override val crcExtra: Byte = 97

    public override fun deserialize(bytes: ByteArray): AsluavStatus {
      val decoder = MavDataDecoder.wrap(bytes)

      val motorRpm = decoder.safeDecodeFloat()
      val ledStatus = decoder.safeDecodeUInt8()
      val satcomStatus = decoder.safeDecodeUInt8()
      val servoStatus = decoder.safeDecodeUInt8Array(8)

      return AsluavStatus(
        ledStatus = ledStatus,
        satcomStatus = satcomStatus,
        servoStatus = servoStatus,
        motorRpm = motorRpm,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): AsluavStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var ledStatus: UByte = 0u

    public var satcomStatus: UByte = 0u

    public var servoStatus: List<UByte> = emptyList()

    public var motorRpm: Float = 0F

    public fun build(): AsluavStatus = AsluavStatus(
      ledStatus = ledStatus,
      satcomStatus = satcomStatus,
      servoStatus = servoStatus,
      motorRpm = motorRpm,
    )
  }
}
