package com.marcocastope.galaxy.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.marcocastope.galaxy.domain.entities.Planet
import com.marcocastope.galaxy.domain.repository.GalaxyRepository
import com.marcocastope.galaxy.domain.usecases.SavePlanetUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: GalaxyRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        val savePlanetUseCase = SavePlanetUseCase(repository)
        viewModel = MainViewModel(savePlanetUseCase)
    }

    @Test
    fun savePlanet_callsSaveRepository() {
        viewModel.savePlanet("Jupiter")
        verify(repository).savePlanet(any())
    }

    @Test(expected = IllegalArgumentException::class)
    fun savePlanet_withEmptyData_shouldThrowException() {
        viewModel.savePlanet("")
    }

    @Test
    fun savePlanet_withCorrectData() {
        val namePlanet = "Jupiter"
        viewModel.savePlanet(namePlanet)
        verify(repository).savePlanet(Planet(namePlanet))
    }
}