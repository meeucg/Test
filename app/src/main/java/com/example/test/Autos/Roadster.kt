package com.example.test.Autos

import com.example.test.Autos.Enums.BodyType
import com.example.test.Autos.Enums.Model

class Roadster(
    modelName: Model? = null,
    modelSeries: String? = null,
    weight: Int? = null,
    motorCapacity: Int? = null): Auto(modelName, modelSeries, weight, motorCapacity,
    BodyType.ROADSTER
)
{
    override fun createSound() = println("WIIIII")
}