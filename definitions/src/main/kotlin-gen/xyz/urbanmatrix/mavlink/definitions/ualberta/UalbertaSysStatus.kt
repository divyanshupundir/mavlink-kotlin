package xyz.urbanmatrix.mavlink.definitions.ualberta

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUInt8
import xyz.urbanmatrix.mavlink.serialization.encodeUInt8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * System status specific to ualberta uav
 */
@GeneratedMavMessage(
  id = 222u,
  crcExtra = 15,
)
public data class UalbertaSysStatus(
  /**
   * System mode, see UALBERTA_AUTOPILOT_MODE ENUM
   */
  @GeneratedMavField(type = "uint8_t")
  public val mode: UByte = 0u,
  /**
   * Navigation mode, see UALBERTA_NAV_MODE ENUM
   */
  @GeneratedMavField(type = "uint8_t")
  public val navMode: UByte = 0u,
  /**
   * Pilot mode, see UALBERTA_PILOT_MODE
   */
  @GeneratedMavField(type = "uint8_t")
  public val pilot: UByte = 0u,
) : MavMessage<UalbertaSysStatus> {
  public override val instanceMetadata: MavMessage.Metadata<UalbertaSysStatus> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(mode)
    outputBuffer.encodeUInt8(navMode)
    outputBuffer.encodeUInt8(pilot)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUInt8(mode)
    outputBuffer.encodeUInt8(navMode)
    outputBuffer.encodeUInt8(pilot)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: UInt = 222u

    private const val CRC_EXTRA: Byte = 15

    private const val SIZE_V1: Int = 3

    private const val SIZE_V2: Int = 3

    private val DESERIALIZER: MavDeserializer<UalbertaSysStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mode = inputBuffer.decodeUInt8()
      val navMode = inputBuffer.decodeUInt8()
      val pilot = inputBuffer.decodeUInt8()

      UalbertaSysStatus(
        mode = mode,
        navMode = navMode,
        pilot = pilot,
      )
    }


    private val METADATA: MavMessage.Metadata<UalbertaSysStatus> = MavMessage.Metadata(ID,
        CRC_EXTRA, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UalbertaSysStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): UalbertaSysStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mode: UByte = 0u

    public var navMode: UByte = 0u

    public var pilot: UByte = 0u

    public fun build(): UalbertaSysStatus = UalbertaSysStatus(
      mode = mode,
      navMode = navMode,
      pilot = pilot,
    )
  }
}
