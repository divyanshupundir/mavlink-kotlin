package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavEnumValue
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeEnumValue
import com.divpundir.mavlink.serialization.encodeFloat
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeEnumValue
import com.divpundir.mavlink.serialization.safeDecodeFloat
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
 * Fuel status.
 *         This message provides "generic" fuel level information for  in a GCS and for triggering
 * failsafes in an autopilot.
 *         The fuel type and associated units for fields in this message are defined in the enum
 * MAV_FUEL_TYPE.
 *
 *         The reported `consumed_fuel` and `remaining_fuel` must only be supplied if measured: they
 * must not be inferred from the `maximum_fuel` and the other value.
 *         A recipient can assume that if these fields are supplied they are accurate.
 *         If not provided, the recipient can infer `remaining_fuel` from `maximum_fuel` and
 * `consumed_fuel` on the assumption that the fuel was initially at its maximum (this is what battery
 * monitors assume).
 *         Note however that this is an assumption, and the UI should prompt the user appropriately
 * (i.e. notify user that they should fill the tank before boot).
 *
 *         This kind of information may also be sent in fuel-specific messages such as
 * BATTERY_STATUS_V2.
 *         If both messages are sent for the same fuel system, the ids and corresponding information
 * must match.
 *
 *         This should be streamed (nominally at 0.1 Hz).
 *       
 *
 * @param id Fuel ID. Must match ID of other messages for same fuel system, such as
 * BATTERY_STATUS_V2.
 * @param maximumFuel Capacity when full. Must be provided.
 * @param consumedFuel Consumed fuel (measured). This value should not be inferred: if not measured
 * set to NaN. NaN: field not provided.
 * @param remainingFuel Remaining fuel until empty (measured). The value should not be inferred: if
 * not measured set to NaN. NaN: field not provided.
 * @param percentRemaining Percentage of remaining fuel, relative to full. Values: [0-100],
 * UINT8_MAX: field not provided.
 * units = %
 * @param flowRate Positive value when emptying/using, and negative if filling/replacing. NaN: field
 * not provided.
 * @param temperature Fuel temperature. NaN: field not provided.
 * units = K
 * @param fuelType Fuel type. Defines units for fuel capacity and consumption fields above.
 */
@GeneratedMavMessage(
  id = 371u,
  crcExtra = 10,
)
public data class FuelStatus(
  /**
   * Fuel ID. Must match ID of other messages for same fuel system, such as BATTERY_STATUS_V2.
   */
  @GeneratedMavField(type = "uint8_t")
  public val id: UByte = 0u,
  /**
   * Capacity when full. Must be provided.
   */
  @GeneratedMavField(type = "float")
  public val maximumFuel: Float = 0F,
  /**
   * Consumed fuel (measured). This value should not be inferred: if not measured set to NaN. NaN:
   * field not provided.
   */
  @GeneratedMavField(type = "float")
  public val consumedFuel: Float = 0F,
  /**
   * Remaining fuel until empty (measured). The value should not be inferred: if not measured set to
   * NaN. NaN: field not provided.
   */
  @GeneratedMavField(type = "float")
  public val remainingFuel: Float = 0F,
  /**
   * Percentage of remaining fuel, relative to full. Values: [0-100], UINT8_MAX: field not provided.
   * units = %
   */
  @GeneratedMavField(type = "uint8_t")
  public val percentRemaining: UByte = 0u,
  /**
   * Positive value when emptying/using, and negative if filling/replacing. NaN: field not provided.
   */
  @GeneratedMavField(type = "float")
  public val flowRate: Float = 0F,
  /**
   * Fuel temperature. NaN: field not provided.
   * units = K
   */
  @GeneratedMavField(type = "float")
  public val temperature: Float = 0F,
  /**
   * Fuel type. Defines units for fuel capacity and consumption fields above.
   */
  @GeneratedMavField(type = "uint32_t")
  public val fuelType: MavEnumValue<MavFuelType> = MavEnumValue.fromValue(0u),
) : MavMessage<FuelStatus> {
  override val instanceCompanion: MavMessage.MavCompanion<FuelStatus> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeFloat(maximumFuel)
    encoder.encodeFloat(consumedFuel)
    encoder.encodeFloat(remainingFuel)
    encoder.encodeFloat(flowRate)
    encoder.encodeFloat(temperature)
    encoder.encodeEnumValue(fuelType.value, 4)
    encoder.encodeUInt8(id)
    encoder.encodeUInt8(percentRemaining)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeFloat(maximumFuel)
    encoder.encodeFloat(consumedFuel)
    encoder.encodeFloat(remainingFuel)
    encoder.encodeFloat(flowRate)
    encoder.encodeFloat(temperature)
    encoder.encodeEnumValue(fuelType.value, 4)
    encoder.encodeUInt8(id)
    encoder.encodeUInt8(percentRemaining)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<FuelStatus> {
    private const val SIZE_V1: Int = 26

    private const val SIZE_V2: Int = 26

    override val id: UInt = 371u

    override val crcExtra: Byte = 10

    override fun deserialize(bytes: ByteArray): FuelStatus {
      val decoder = MavDataDecoder(bytes)

      val maximumFuel = decoder.safeDecodeFloat()
      val consumedFuel = decoder.safeDecodeFloat()
      val remainingFuel = decoder.safeDecodeFloat()
      val flowRate = decoder.safeDecodeFloat()
      val temperature = decoder.safeDecodeFloat()
      val fuelType = decoder.safeDecodeEnumValue(4).let { value ->
        val entry = MavFuelType.getEntryFromValueOrNull(value)
        if (entry != null) MavEnumValue.of(entry) else MavEnumValue.fromValue(value)
      }
      val id = decoder.safeDecodeUInt8()
      val percentRemaining = decoder.safeDecodeUInt8()

      return FuelStatus(
        id = id,
        maximumFuel = maximumFuel,
        consumedFuel = consumedFuel,
        remainingFuel = remainingFuel,
        percentRemaining = percentRemaining,
        flowRate = flowRate,
        temperature = temperature,
        fuelType = fuelType,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): FuelStatus =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var id: UByte = 0u

    public var maximumFuel: Float = 0F

    public var consumedFuel: Float = 0F

    public var remainingFuel: Float = 0F

    public var percentRemaining: UByte = 0u

    public var flowRate: Float = 0F

    public var temperature: Float = 0F

    public var fuelType: MavEnumValue<MavFuelType> = MavEnumValue.fromValue(0u)

    public fun build(): FuelStatus = FuelStatus(
      id = id,
      maximumFuel = maximumFuel,
      consumedFuel = consumedFuel,
      remainingFuel = remainingFuel,
      percentRemaining = percentRemaining,
      flowRate = flowRate,
      temperature = temperature,
      fuelType = fuelType,
    )
  }
}
