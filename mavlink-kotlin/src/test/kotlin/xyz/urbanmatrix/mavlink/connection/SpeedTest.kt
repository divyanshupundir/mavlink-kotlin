package xyz.urbanmatrix.mavlink.connection

import org.junit.jupiter.api.Test
import xyz.urbanmatrix.mavlink.definitions.common.CommandLong
import xyz.urbanmatrix.mavlink.wrap

class SpeedTest {
    
    @Test
    fun serialization() {
        val cmd = CommandLong(
            1,
            2,
            xyz.urbanmatrix.mavlink.definitions.common.MavCmd.MAV_CMD_DO_FOLLOW.wrap(),
            3,
            4f,
            3f,
            4f,
            5f,
            6f,
            7f,
            2f
        )

        for (i in 1..10) {
            println("Warmup: ${serializationStep(cmd)}")
        }

        for (i in 1..10) {
            println("Test: ${serializationStep(cmd)}")
        }
    }

    private fun serializationStep(cmd: CommandLong): Long {
        val start = System.nanoTime()
        for (i in 1..1_000_000) {
            cmd.serialize()
        }
        val end = System.nanoTime()

        return (end - start) / 1000
    }

    @Test
    fun deserialization() {
        val data = ByteArray(200)

        for (i in 0..9) {
            println("Warmup: " + deserializationStep(data))
        }
        for (i in 0..9) {
            println("Test: " + deserializationStep(data))
        }
    }

    private fun deserializationStep(data: ByteArray): Long {
        val start = System.nanoTime()
        for (i in 1..100_000) {
            CommandLong.classMetadata.deserializer.deserialize(data)
        }
        val end = System.nanoTime()
        return (end - start) / 1000
    }
}
