package com.example.test.Autos

import com.example.test.Autos.Enums.BodyType
import com.example.test.Autos.Enums.Model

class SUV(
    modelName: Model? = null,
    modelSeries: String? = null,
    weight: Int? = null,
    motorCapacity: Int? = null): Auto(modelName, modelSeries, weight, motorCapacity, BodyType.SUV)
{
    override fun createSound() = println("WRRRR")
}