package com.marcocastope.galaxy.domain.repository

import com.marcocastope.galaxy.domain.entities.Planet

interface GalaxyRepository {

    fun getAllPlanets(): List<Planet>
    fun getPlanet(name: String): Planet
    fun savePlanet(planet: Planet)
}