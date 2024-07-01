package com.example.test.Autos

import com.example.test.Autos.Enums.BodyType
import com.example.test.Autos.Enums.Model

class Coupe(
    modelName: Model? = null,
    modelSeries: String? = null,
    weight: Int? = null,
    motorCapacity: Int? = null): Auto(modelName, modelSeries, weight, motorCapacity, BodyType.COUPE)
{
    override fun createSound() = println("BJJJJ")
}