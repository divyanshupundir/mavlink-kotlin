package xyz.urbanmatrix.mavlink.definitions.ardupilotmega

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeUint16
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeUint16
import xyz.urbanmatrix.mavlink.serialization.encodeUint8

/**
 * Status of key hardware.
 */
@GeneratedMavMessage(
  id = 165,
  crc = 21,
)
public data class Hwstatus(
  /**
   * Board voltage.
   */
  public val vcc: Int = 0,
  /**
   * I2C error count.
   */
  public val i2cerr: Int = 0,
) : MavMessage<Hwstatus> {
  public override val instanceMetadata: MavMessage.Metadata<Hwstatus> = METADATA

  public override fun serialize(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint16(vcc)
    outputBuffer.encodeUint8(i2cerr)
    return outputBuffer.array()
  }

  public companion object {
    private const val ID: Int = 165

    private const val CRC: Int = 21

    private const val SIZE: Int = 3

    private val DESERIALIZER: MavDeserializer<Hwstatus> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val vcc = inputBuffer.decodeUint16()
      val i2cerr = inputBuffer.decodeUint8()

      Hwstatus(
        vcc = vcc,
        i2cerr = i2cerr,
      )
    }


    private val METADATA: MavMessage.Metadata<Hwstatus> = MavMessage.Metadata(ID, CRC, DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<Hwstatus> = METADATA

    public fun builder(builderAction: Builder.() -> Unit) = Builder().apply(builderAction).build()
  }

  public class Builder {
    public var vcc: Int = 0

    public var i2cerr: Int = 0

    public fun build(): Hwstatus = Hwstatus(
      vcc = vcc,
      i2cerr = i2cerr,
    )
  }
}
