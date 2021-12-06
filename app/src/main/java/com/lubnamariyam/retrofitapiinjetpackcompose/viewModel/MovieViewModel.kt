package com.lubnamariyam.retrofitapiinjetpackcompose.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lubnamariyam.retrofitapiinjetpackcompose.model.Movie
import com.lubnamariyam.retrofitapiinjetpackcompose.network.ApiService
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val movieList = apiService.getMovies()
                movieListResponse = movieList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}