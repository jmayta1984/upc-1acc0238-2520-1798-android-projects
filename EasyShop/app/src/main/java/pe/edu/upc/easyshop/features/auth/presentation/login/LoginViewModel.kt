package pe.edu.upc.easyshop.features.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyshop.features.auth.domain.models.User
import pe.edu.upc.easyshop.features.auth.domain.repositories.AuthRepository

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun updateUsername(value: String) {
        _username.value = value
    }


    fun updatePassword(value: String) {
        _password.value = value
    }

    fun login() {
        viewModelScope.launch {
            _user.value = repository.login(_username.value, _password.value)
        }
    }

}