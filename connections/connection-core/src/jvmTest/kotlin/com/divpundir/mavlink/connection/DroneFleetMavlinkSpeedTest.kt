package com.divpundir.mavlink.connection

import io.dronefleet.mavlink.common.CommandLong
import io.dronefleet.mavlink.common.MavCmd
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadDeserializer
import io.dronefleet.mavlink.serialization.payload.reflection.ReflectionPayloadSerializer
import kotlin.test.Test
import kotlin.time.measureTime

class DroneFleetMavlinkSpeedTest {

    companion object {
        private const val WARMUP_ITERS = 5
        private const val ACTUAL_ITERS = 5

        private const val SERIALIZATION_ITERS = 1_000_000
        private const val DESERIALIZATION_ITERS = 100_000
    }

    @Test
    fun serialization() {
        val serializer = ReflectionPayloadSerializer()
        val cmd = CommandLong.builder()
            .targetSystem(1)
            .targetComponent(2)
            .command(MavCmd.MAV_CMD_DO_FOLLOW)
            .confirmation(3)
            .param1(4f)
            .param2(3f)
            .param3(4f)
            .param4(5f)
            .param5(6f)
            .param6(7f)
            .param7(2f)
            .build()

        for (i in 1..WARMUP_ITERS) {
            println("Warmup: ${serializationStep(serializer, cmd).inWholeMicroseconds} us")
        }

        for (i in 1..ACTUAL_ITERS) {
            println("Actual: ${serializationStep(serializer, cmd).inWholeMicroseconds} us")
        }
    }

    private fun serializationStep(
        serializer: ReflectionPayloadSerializer,
        cmd: CommandLong
    ) = measureTime {
        for (i in 1..SERIALIZATION_ITERS) {
            serializer.serialize(cmd)
        }
    }

    @Test
    fun deserialization() {
        val deserializer = ReflectionPayloadDeserializer()
        val data = ByteArray(200)

        for (i in 1..WARMUP_ITERS) {
            println("Warmup: ${deserializationStep(deserializer, data).inWholeMicroseconds} us")
        }

        for (i in 1..ACTUAL_ITERS) {
            println("Actual: ${deserializationStep(deserializer, data).inWholeMicroseconds} us")
        }
    }

    private fun deserializationStep(
        deserializer: ReflectionPayloadDeserializer,
        data: ByteArray
    ) = measureTime {
        for (i in 1..DESERIALIZATION_ITERS) {
            deserializer.deserialize(data, CommandLong::class.java)
        }
    }
}
