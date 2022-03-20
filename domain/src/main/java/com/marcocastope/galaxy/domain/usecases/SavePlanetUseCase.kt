package com.marcocastope.galaxy.domain.usecases

import com.marcocastope.galaxy.domain.entities.Planet
import com.marcocastope.galaxy.domain.repository.GalaxyRepository

class SavePlanetUseCase(private val repository: GalaxyRepository) {

    fun invoke(planet: Planet) = repository.savePlanet(planet)
}