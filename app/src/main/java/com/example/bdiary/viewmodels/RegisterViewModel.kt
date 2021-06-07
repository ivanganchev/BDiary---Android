package com.example.bdiary.viewmodels
import androidx.lifecycle.*
import com.example.bdiary.repositories.AuthRepository
import com.example.bdiary.models.User
import com.example.bdiary.models.responseObjects.AuthResponse
import com.example.bdiary.util.Resource
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class   RegisterViewModel @Inject
constructor(
        private val authRepo: AuthRepository,
): ViewModel() {

    private lateinit var user: User

    fun setUser(user: User) {
        this.user = user
    }

    private var _dataState: MutableLiveData<Resource<AuthResponse>> = MutableLiveData()

    val dataState: LiveData<Resource<AuthResponse>>
        get() = _dataState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            authRepo.register(user).collect {
                _dataState.postValue(it)
            }
        }
    }
}
