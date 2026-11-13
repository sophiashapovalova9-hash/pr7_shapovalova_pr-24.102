package com.example.pr7_shapovalova_pr_24102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pr7_shapovalova_pr_24102.ui.theme.Pr7_shapovalova_pr24102Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceType)
        setContent {
            Pr7_shapovalova_pr24102Theme {
                var screen by remember { mutableStateOf("splash") }

                when (screen) {
                    "splash" -> SplashScreen(
                        onGoRegistration = { screen = "registration" },
                        onGoLogin = { screen = "login" }
                    )
                    "registration" -> RegistrationScreen(
                        onBack = { screen = "splash" }
                    )
                    "login" -> LoginScreen(
                        onBack = { screen = "splash" }
                    )
                }
            }
        }
    }
}

@Composable
fun SplashScreen(
    onGoRegistration: () -> Unit,
    onGoLogin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF6480))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Моё приложение",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onGoRegistration,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFFFF6480)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Регистрация")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onGoLogin,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6480), contentColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Войти")
        }
    }
}

@Composable
fun RegistrationScreen(
    onBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Создать аккаунт",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6480), contentColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Create Account")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onBack) {
            Text(text = "Уже есть аккаунт? Войти", color = Color(0xFFFF6480))
        }
    }
}

@Composable
fun LoginScreen(
    onBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Войти",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                val it = null
                email = it
            },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                val it = null
                password = it
            },
            label = { Text("Пароль") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6480), contentColor = Color.White),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Войти")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onBack) {
            Text(text = "Нет аккаунта? Зарегистрироваться", color = Color(0xFFFF6480))
        }
    }
}