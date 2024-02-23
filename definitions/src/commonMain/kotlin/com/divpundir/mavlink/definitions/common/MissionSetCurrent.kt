package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeUInt16
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeUInt16
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.UByte
import kotlin.UInt
import kotlin.UShort
import kotlin.Unit

/**
 *
 *         Set the mission item with sequence number seq as the current item and emit
 * MISSION_CURRENT (whether or not the mission number changed).
 *         If a mission is currently being executed, the system will continue to this new mission
 * item on the shortest path, skipping any intermediate mission items.
 *         Note that mission jump repeat counters are not reset (see MAV_CMD_DO_JUMP param2).
 *
 *         This message may trigger a mission state-machine change on some systems: for example from
 * MISSION_STATE_NOT_STARTED or MISSION_STATE_PAUSED to MISSION_STATE_ACTIVE.
 *         If the system is in mission mode, on those systems this command might therefore start,
 * restart or resume the mission.
 *         If the system is not in mission mode this message must not trigger a switch to mission
 * mode.
 *       
 *
 * @param targetSystem System ID
 * @param targetComponent Component ID
 * @param seq Sequence
 */
@Deprecated(message = "")
@GeneratedMavMessage(
  id = 41u,
  crcExtra = 28,
)
public data class MissionSetCurrent(
  /**
   * System ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: UByte = 0u,
  /**
   * Component ID
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetComponent: UByte = 0u,
  /**
   * Sequence
   */
  @GeneratedMavField(type = "uint16_t")
  public val seq: UShort = 0u,
) : MavMessage<MissionSetCurrent> {
  override val instanceCompanion: MavMessage.MavCompanion<MissionSetCurrent> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeUInt16(seq)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<MissionSetCurrent> {
    private const val SIZE_V1: Int = 4

    private const val SIZE_V2: Int = 4

    override val id: UInt = 41u

    override val crcExtra: Byte = 28

    override fun deserialize(bytes: ByteArray): MissionSetCurrent {
      val decoder = MavDataDecoder(bytes)

      val seq = decoder.safeDecodeUInt16()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return MissionSetCurrent(
        targetSystem = targetSystem,
        targetComponent = targetComponent,
        seq = seq,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): MissionSetCurrent =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public var seq: UShort = 0u

    public fun build(): MissionSetCurrent = MissionSetCurrent(
      targetSystem = targetSystem,
      targetComponent = targetComponent,
      seq = seq,
    )
  }
}
