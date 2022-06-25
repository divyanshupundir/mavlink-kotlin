package com.urbanmatrix.mavlink.common

import com.urbanmatrix.mavlink.api.MavDeserializer
import com.urbanmatrix.mavlink.api.MavMessage
import com.urbanmatrix.mavlink.serialization.decodeUint8
import com.urbanmatrix.mavlink.serialization.decodeUint8Array
import com.urbanmatrix.mavlink.serialization.encodeUint8
import com.urbanmatrix.mavlink.serialization.encodeUint8Array
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Deprecated
import kotlin.Int
import kotlin.collections.List

/**
 * Data for injecting into the onboard GPS (used for DGPS)
 */
@Deprecated(message = "")
public data class GpsInjectData(
  /**
   * Raw data (110 is enough for 12 satellites of RTCMv2)
   */
  public val `data`: List<Int> = emptyList(),
  /**
   * Data length
   */
  public val len: Int = 0,
  /**
   * Component ID
   */
  public val targetComponent: Int = 0,
  /**
   * System ID
   */
  public val targetSystem: Int = 0,
) : MavMessage<GpsInjectData> {
  public override val instanceMetadata: MavMessage.Metadata<GpsInjectData> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(113).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8Array(data, 110)
    outputBuffer.encodeUint8(len)
    outputBuffer.encodeUint8(targetComponent)
    outputBuffer.encodeUint8(targetSystem)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 123

    private const val CRC: Int = 75

    private val DESERIALIZER: MavDeserializer<GpsInjectData> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val data = inputBuffer.decodeUint8Array(110)
      val len = inputBuffer.decodeUint8()
      val targetComponent = inputBuffer.decodeUint8()
      val targetSystem = inputBuffer.decodeUint8()
      GpsInjectData(
        data = data,
        len = len,
        targetComponent = targetComponent,
        targetSystem = targetSystem,
      )
    }


    private val METADATA: MavMessage.Metadata<GpsInjectData> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<GpsInjectData> = METADATA
  }
}
