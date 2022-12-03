package xyz.urbanmatrix.mavlink.definitions.common

import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.ByteArray
import kotlin.Int
import kotlin.String
import kotlin.Unit
import xyz.urbanmatrix.mavlink.api.GeneratedMavField
import xyz.urbanmatrix.mavlink.api.GeneratedMavMessage
import xyz.urbanmatrix.mavlink.api.MavDeserializer
import xyz.urbanmatrix.mavlink.api.MavMessage
import xyz.urbanmatrix.mavlink.serialization.decodeString
import xyz.urbanmatrix.mavlink.serialization.decodeUint8
import xyz.urbanmatrix.mavlink.serialization.encodeString
import xyz.urbanmatrix.mavlink.serialization.encodeUint8
import xyz.urbanmatrix.mavlink.serialization.truncateZeros

/**
 * Request to control this MAV
 */
@GeneratedMavMessage(
  id = 5,
  crc = 217,
)
public data class ChangeOperatorControl(
  /**
   * System the GCS requests control for
   */
  @GeneratedMavField(type = "uint8_t")
  public val targetSystem: Int = 0,
  /**
   * 0: request control of this MAV, 1: Release control of this MAV
   */
  @GeneratedMavField(type = "uint8_t")
  public val controlRequest: Int = 0,
  /**
   * 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in
   * general use the safest mode possible initially and then gradually move down the encryption level
   * if it gets a NACK message indicating an encryption mismatch.
   */
  @GeneratedMavField(type = "uint8_t")
  public val version: Int = 0,
  /**
   * Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL
   * terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-"
   */
  @GeneratedMavField(type = "char[25]")
  public val passkey: String = "",
) : MavMessage<ChangeOperatorControl> {
  public override val instanceMetadata: MavMessage.Metadata<ChangeOperatorControl> = METADATA

  public override fun serializeV1(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V1).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(controlRequest)
    outputBuffer.encodeUint8(version)
    outputBuffer.encodeString(passkey, 25)
    return outputBuffer.array()
  }

  public override fun serializeV2(): ByteArray {
    val outputBuffer = ByteBuffer.allocate(SIZE_V2).order(ByteOrder.LITTLE_ENDIAN)
    outputBuffer.encodeUint8(targetSystem)
    outputBuffer.encodeUint8(controlRequest)
    outputBuffer.encodeUint8(version)
    outputBuffer.encodeString(passkey, 25)
    return outputBuffer.array().truncateZeros()
  }

  public companion object {
    private const val ID: Int = 5

    private const val CRC: Int = 217

    private const val SIZE_V1: Int = 28

    private const val SIZE_V2: Int = 28

    private val DESERIALIZER: MavDeserializer<ChangeOperatorControl> = MavDeserializer { bytes ->
      val inputBuffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN)
      val targetSystem = inputBuffer.decodeUint8()
      val controlRequest = inputBuffer.decodeUint8()
      val version = inputBuffer.decodeUint8()
      val passkey = inputBuffer.decodeString(25)

      ChangeOperatorControl(
        targetSystem = targetSystem,
        controlRequest = controlRequest,
        version = version,
        passkey = passkey,
      )
    }


    private val METADATA: MavMessage.Metadata<ChangeOperatorControl> = MavMessage.Metadata(ID, CRC,
        DESERIALIZER)

    public val classMetadata: MavMessage.Metadata<ChangeOperatorControl> = METADATA

    public fun builder(builderAction: Builder.() -> Unit): ChangeOperatorControl =
        Builder().apply(builderAction).build()
  }

  public class Builder {
    public var targetSystem: Int = 0

    public var controlRequest: Int = 0

    public var version: Int = 0

    public var passkey: String = ""

    public fun build(): ChangeOperatorControl = ChangeOperatorControl(
      targetSystem = targetSystem,
      controlRequest = controlRequest,
      version = version,
      passkey = passkey,
    )
  }
}
