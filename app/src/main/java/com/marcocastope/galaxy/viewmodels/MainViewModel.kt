package com.marcocastope.galaxy.viewmodels

import androidx.lifecycle.ViewModel
import com.marcocastope.galaxy.domain.entities.Planet
import com.marcocastope.galaxy.domain.usecases.SavePlanetUseCase

class MainViewModel(private val savePlanetUseCase: SavePlanetUseCase) : ViewModel() {

    fun savePlanet(name: String) {
        if (name.isEmpty())
            throw IllegalArgumentException("name should data content")
        savePlanetUseCase.invoke(Planet(name))
    }

}