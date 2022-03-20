package com.marcocastope.galaxy.domain.usecases

import com.marcocastope.galaxy.domain.entities.Planet
import com.marcocastope.galaxy.domain.repository.GalaxyRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class SavePlanetUseCaseTest {

    @Mock
    private lateinit var repository: GalaxyRepository
    private lateinit var savePlanetUseCase: SavePlanetUseCase

    @Before
    fun setup() {
        savePlanetUseCase = SavePlanetUseCase(repository)
    }

    @Test
    fun saveNewPlanet_callsRepository() {
        savePlanetUseCase.invoke(Planet("Marte"))
        verify(repository).savePlanet(any())
    }

}