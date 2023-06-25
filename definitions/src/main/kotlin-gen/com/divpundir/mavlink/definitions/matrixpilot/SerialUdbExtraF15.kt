package com.divpundir.mavlink.definitions.matrixpilot

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.decodeUInt8Array
import com.divpundir.mavlink.serialization.encodeUInt8Array
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit
import kotlin.collections.List
import okio.Buffer

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format
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
  public override val instanceCompanion: MavMessage.MavCompanion<SerialUdbExtraF15> = Companion

  public override fun serializeV1(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8Array(sueIdVehicleModelName, 40)
    buffer.encodeUInt8Array(sueIdVehicleRegistration, 20)
    return buffer.readByteArray()
  }

  public override fun serializeV2(): ByteArray {
    val buffer = Buffer()
    buffer.encodeUInt8Array(sueIdVehicleModelName, 40)
    buffer.encodeUInt8Array(sueIdVehicleRegistration, 20)
    return buffer.readByteArray().truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<SerialUdbExtraF15> {
    public override val id: UInt = 179u

    public override val crcExtra: Byte = 7

    public override fun deserialize(bytes: ByteArray): SerialUdbExtraF15 {
      val buffer = Buffer().write(bytes)

      val sueIdVehicleModelName = buffer.decodeUInt8Array(40)
      val sueIdVehicleRegistration = buffer.decodeUInt8Array(20)

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
