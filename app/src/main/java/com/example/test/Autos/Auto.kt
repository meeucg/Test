package com.example.test.Autos

import com.example.test.Autos.Enums.BodyType
import com.example.test.Autos.Enums.Model
import kotlin.random.Random

open class Auto(
    modelName: Model? = null,
    modelSeries: String? = null,
    weight: Int? = null,
    motorCapacity: Int? = null,
    bodyType: BodyType? = null
)
{
    val modelName: Model = modelName
        ?: Model.entries[Random.nextInt(0, Model.entries.size - 1)]

    val modelSeries: String = modelSeries
        ?: "S${Random.nextInt(0, 100)}"

    val weight: Int = weight
        ?: Random.nextInt(1, 4)

    val motorCapacity: Int = motorCapacity
        ?: (Random.nextInt(2, 20) * 100)

    val bodyType: BodyType = bodyType
        ?: BodyType.entries[Random.nextInt(0, BodyType.entries.size - 1)]

    open fun createSound() = println("*Default car sound*")

    override fun toString(): String {
        return """
            |Model: $modelName
            |Series: $modelSeries
            |HP: $motorCapacity
            |Weight: ${weight*1000}kg
            |Body type: ${bodyType.name}
        """.trimMargin()
    }
}