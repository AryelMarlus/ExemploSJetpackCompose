package com.example.exemplosjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exemplosjetpackcompose.ui.theme.ExemploSJetpackComposeTheme
import java.security.SecureRandom

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExemploSJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    criarPersonagem()
                }
            }
        }
    }
}

@Composable
fun criarPersonagem(){
    Column(
        Modifier.
        background(color = Color(0xFF3F51B5)).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Olá, bem vindo à criação de personagem Old Dragon",
            style = TextStyle(color = Color.DarkGray, fontSize = 20.sp))
        Spacer(modifier = Modifier.size(16.dp))
        Text("Escolha o modo de distribuição de atributos")
        Spacer(modifier = Modifier.size(16.dp))
        Text("Força")
        TextField(rolar3d6(),{})
        Text("Destreza")
        TextField(rolar3d6(),{})
    }
}

@Preview(showBackground = true)
@Composable
fun previa() {
    ExemploSJetpackComposeTheme {
        criarPersonagem()
    }
}

fun rolar3d6(): String{
    var sr = SecureRandom()
    var d1 = sr.nextInt(5) + 1
    var d2 = sr.nextInt(5) + 1
    var d3 = sr.nextInt(5) + 1
    return (d1+d2+d3).toString()
}