package com.divpundir.mavlink.definitions.asluav

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeFloat
import com.divpundir.mavlink.serialization.decodeUInt8
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.Float
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource

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

  public override fun serializeV1(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(motorRpm)
    output.encodeUInt8(ledStatus)
    output.encodeUInt8(satcomStatus)
    output.encodeUInt8Array(servoStatus, 8)
    return output
  }

  public override fun serializeV2(): BufferedSource {
    val output = Buffer()
    output.encodeFloat(motorRpm)
    output.encodeUInt8(ledStatus)
    output.encodeUInt8(satcomStatus)
    output.encodeUInt8Array(servoStatus, 8)
    output.truncateZeros()
    return output
  }

  public companion object : MavMessage.MavCompanion<AsluavStatus> {
    private const val SIZE_V1: Int = 14

    private const val SIZE_V2: Int = 14

    public override val id: UInt = 8_006u

    public override val crcExtra: Byte = 97

    public override fun deserialize(source: BufferedSource): AsluavStatus {
      val motorRpm = source.decodeFloat()
      val ledStatus = source.decodeUInt8()
      val satcomStatus = source.decodeUInt8()
      val servoStatus = source.decodeUInt8Array(8)

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
