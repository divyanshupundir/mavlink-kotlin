package xyz.urbanmatrix.mavlink.definitions.ualberta

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * System status specific to ualberta uav
 */
@GeneratedMavMessage(
  id = 222,
  crc = 15,
)
public data class UalbertaSysStatus(
  /**
   * System mode, see UALBERTA_AUTOPILOT_MODE ENUM
   */
  public val mode: Int = 0,
  /**
   * Navigation mode, see UALBERTA_NAV_MODE ENUM
   */
  public val navMode: Int = 0,
  /**
   * Pilot mode, see UALBERTA_PILOT_MODE
   */
  public val pilot: Int = 0,
) : MavMessage<UalbertaSysStatus> {
  public override val instanceMetadata: MavMessage.Metadata<UalbertaSysStatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(mode)
    outputBuffer.encodeUint8(navMode)
    outputBuffer.encodeUint8(pilot)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 222

    private const val CRC: Int = 15

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<UalbertaSysStatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val mode = inputBuffer.decodeUint8()
      val navMode = inputBuffer.decodeUint8()
      val pilot = inputBuffer.decodeUint8()

      UalbertaSysStatus(
        mode = mode,
        navMode = navMode,
        pilot = pilot,
      )
    }


    private val METADATA: MavMessage.Metadata<UalbertaSysStatus> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<UalbertaSysStatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var mode: Int = 0

    public var navMode: Int = 0

    public var pilot: Int = 0

    public fun build(): UalbertaSysStatus = UalbertaSysStatus(
      mode = mode,
      navMode = navMode,
      pilot = pilot,
    )
  }
}
