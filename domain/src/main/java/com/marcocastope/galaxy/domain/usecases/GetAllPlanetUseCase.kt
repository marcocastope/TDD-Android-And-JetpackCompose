package com.marcocastope.galaxy.domain.usecases

import com.marcocastope.galaxy.domain.entities.Planet
import com.marcocastope.galaxy.domain.repository.GalaxyRepository

class GetAllPlanetUseCase(private val repository: GalaxyRepository) {

    fun invoke(): List<Planet> = repository.getAllPlanets()
}