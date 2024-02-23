package com.divpundir.mavlink.definitions.common

import com.divpundir.mavlink.api.GeneratedMavField
import com.divpundir.mavlink.api.GeneratedMavMessage
import com.divpundir.mavlink.api.MavMessage
import com.divpundir.mavlink.serialization.MavDataDecoder
import com.divpundir.mavlink.serialization.MavDataEncoder
import com.divpundir.mavlink.serialization.encodeInt64
import com.divpundir.mavlink.serialization.encodeUInt8
import com.divpundir.mavlink.serialization.safeDecodeInt64
import com.divpundir.mavlink.serialization.safeDecodeUInt8
import com.divpundir.mavlink.serialization.truncateZeros
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.UByte
import kotlin.UInt
import kotlin.Unit

/**
 *
 *         Time synchronization message.
 *         The message is used for both timesync requests and responses.
 *         The request is sent with `ts1=syncing component timestamp` and `tc1=0`, and may be
 * broadcast or targeted to a specific system/component.
 *         The response is sent with `ts1=syncing component timestamp` (mirror back unchanged), and
 * `tc1=responding component timestamp`, with the `target_system` and `target_component` set to ids of
 * the original request.
 *         Systems can determine if they are receiving a request or response based on the value of
 * `tc`.
 *         If the response has `target_system==target_component==0` the remote system has not been
 * updated to use the component IDs and cannot reliably timesync; the requestor may report an error.
 *         Timestamps are UNIX Epoch time or time since system boot in nanoseconds (the timestamp
 * format can be inferred by checking for the magnitude of the number; generally it doesn't matter as
 * only the offset is used).
 *         The message sequence is repeated numerous times with results being filtered/averaged to
 * estimate the offset.
 *       
 *
 * @param tc1 Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component.
 * units = ns
 * @param ts1 Time sync timestamp 2. Timestamp of syncing component (mirrored in response).
 * units = ns
 * @param targetSystem Target system id. Request: 0 (broadcast) or id of specific system. Response
 * must contain system id of the requesting component.
 * @param targetComponent Target component id. Request: 0 (broadcast) or id of specific component.
 * Response must contain component id of the requesting component.
 */
@GeneratedMavMessage(
  id = 111u,
  crcExtra = 34,
)
public data class Timesync(
  /**
   * Time sync timestamp 1. Syncing: 0. Responding: Timestamp of responding component.
   * units = ns
   */
  @GeneratedMavField(type = "int64_t")
  public val tc1: Long = 0L,
  /**
   * Time sync timestamp 2. Timestamp of syncing component (mirrored in response).
   * units = ns
   */
  @GeneratedMavField(type = "int64_t")
  public val ts1: Long = 0L,
  /**
   * Target system id. Request: 0 (broadcast) or id of specific system. Response must contain system
   * id of the requesting component.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetSystem: UByte = 0u,
  /**
   * Target component id. Request: 0 (broadcast) or id of specific component. Response must contain
   * component id of the requesting component.
   */
  @GeneratedMavField(
    type = "uint8_t",
    extension = true,
  )
  public val targetComponent: UByte = 0u,
) : MavMessage<Timesync> {
  override val instanceCompanion: MavMessage.MavCompanion<Timesync> = Companion

  override fun serializeV1(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V1)
    encoder.encodeInt64(tc1)
    encoder.encodeInt64(ts1)
    return encoder.bytes
  }

  override fun serializeV2(): ByteArray {
    val encoder = MavDataEncoder(SIZE_V2)
    encoder.encodeInt64(tc1)
    encoder.encodeInt64(ts1)
    encoder.encodeUInt8(targetSystem)
    encoder.encodeUInt8(targetComponent)
    return encoder.bytes.truncateZeros()
  }

  public companion object : MavMessage.MavCompanion<Timesync> {
    private const val SIZE_V1: Int = 16

    private const val SIZE_V2: Int = 18

    override val id: UInt = 111u

    override val crcExtra: Byte = 34

    override fun deserialize(bytes: ByteArray): Timesync {
      val decoder = MavDataDecoder(bytes)

      val tc1 = decoder.safeDecodeInt64()
      val ts1 = decoder.safeDecodeInt64()
      val targetSystem = decoder.safeDecodeUInt8()
      val targetComponent = decoder.safeDecodeUInt8()

      return Timesync(
        tc1 = tc1,
        ts1 = ts1,
        targetSystem = targetSystem,
        targetComponent = targetComponent,
      )
    }

    public operator fun invoke(builderAction: Builder.() -> Unit): Timesync =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var tc1: Long = 0L

    public var ts1: Long = 0L

    public var targetSystem: UByte = 0u

    public var targetComponent: UByte = 0u

    public fun build(): Timesync = Timesync(
      tc1 = tc1,
      ts1 = ts1,
      targetSystem = targetSystem,
      targetComponent = targetComponent,
    )
  }
}
