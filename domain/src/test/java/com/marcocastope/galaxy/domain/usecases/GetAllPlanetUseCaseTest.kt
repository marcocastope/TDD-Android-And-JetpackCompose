package com.marcocastope.galaxy.domain.usecases

import com.marcocastope.galaxy.domain.entities.Planet
import com.marcocastope.galaxy.domain.repository.GalaxyRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetAllPlanetUseCaseTest {


    private lateinit var repository: GalaxyRepository
    private lateinit var getPlanetsUseCaseTest: GetAllPlanetUseCase

    @Before
    fun setup() {
        repository = mock()
        getPlanetsUseCaseTest = GetAllPlanetUseCase(repository)
    }

    @Test
    fun getAllPlanets_returnsCorrectData() {
        val planets = listOf(Planet("Marte"), Planet("Jupiter"))
        whenever(repository.getAllPlanets()).thenReturn(planets)

        assertEquals(planets, repository.getAllPlanets())
    }
}