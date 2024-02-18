package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.safeDecodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format
 *
 */
@GeneratedMavMessage(
  id = 179u,
  crcExtra = 7,
)
public data class SerialUdbExtraF15(
  /**
   * Serial UDB Extra Model Name Of Vehicle
   */
  @GeneratedMavField(type = "uint8_t[40]")
  public val sueIdVehicleModelName: List<UByte> = emptyList(),
  /**
   * Serial UDB Extra Registraton Number of Vehicle
   */
  @GeneratedMavField(type = "uint8_t[20]")
  public val sueIdVehicleRegistration: List<UByte> = emptyList(),
) : MavMessage<SerialUdbExtraF15> {
  override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF15> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt8Array(sueIdVehicleModelName, 40)
    encoder.encodeUInt8Array(sueIdVehicleRegistration, 20)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt8Array(sueIdVehicleModelName, 40)
    encoder.encodeUInt8Array(sueIdVehicleRegistration, 20)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF15> {
    private const val SIZE_V1: Int = 60

    private const val SIZE_V2: Int = 60

    override val id: UInt = 179u

    override val crcExtra: Byte = 7

    override fun deserialize(bytes: ByteArray): SerialUdbExtraF15 {
      val decoder = MavDataDecoder(bytes)

      val sueIdVehicleModelName = decoder.safeDecodeUInt8Array(40)
      val sueIdVehicleRegistration = decoder.safeDecodeUInt8Array(20)

      return SerialUdbExtraF15(
        sueIdVehicleModelName = sueIdVehicleModelName,
        sueIdVehicleRegistration = sueIdVehicleRegistration,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): SerialUdbExtraF15 =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var sueIdVehicleModelName: List<UByte> = emptyList()

    public var sueIdVehicleRegistration: List<UByte> = emptyList()

    public fun build(): SerialUdbExtraF15 = SerialUdbExtraF15(
      sueIdVehicleModelName = sueIdVehicleModelName,
      sueIdVehicleRegistration = sueIdVehicleRegistration,
    )
  }
}
