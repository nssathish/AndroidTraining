package com.example.lemonadepreparer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadepreparer.ui.theme.LemonadePreparerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadePreparerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Preview
@Composable
fun Lemonade(modifier: Modifier = Modifier.wrapContentSize(Alignment.Center)) {
    var choice by remember {
        mutableIntStateOf(1)
    }
    var choiceDescription by remember {
        mutableStateOf(labelOfChoice(1))
    }
    var squeezes by remember {
        mutableIntStateOf(Random.nextInt(2, 4))
    }
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow),
            contentAlignment = Alignment.TopCenter
        ) {
            Text(
                text = "Lemonade",
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp),
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    choice = when (choice) {
                        1 -> 2
                        2 -> {
                            if (squeezes == 0) {
                                squeezes = Random.nextInt(2, 4)
                                3
                            } else {
                                squeezes--
                                2
                            }
                        }

                        3 -> 4
                        else -> 1
                    }
                    choiceDescription = labelOfChoice(choice)
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6FFE6)
                )
            ) {
                Image(
                    painter = when (choice) {
                        1 -> painterResource(id = R.drawable.lemon_tree)
                        2 -> painterResource(id = R.drawable.lemon_squeeze)
                        3 -> painterResource(id = R.drawable.lemon_drink)
                        else -> painterResource(id = R.drawable.lemon_restart)
                    }, contentDescription = when (choice) {
                        1 -> "Lemon Tree"
                        2 -> "Lemon squeeze"
                        3 -> "Lemonade drink"
                        else -> "Lemonade restart"
                    }, modifier = Modifier
                        .background(
                            color = Color(0xFFE6FFE6),
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
            Text(
                text = choiceDescription,
                modifier = modifier.padding(20.dp),
                fontSize = 12.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

fun labelOfChoice(choice: Int): String {
    return when (choice) {
        1 -> "Tap the lemon tree to select a lemon."
        2 -> "Keep tapping the lemon to squeeze it."
        3 -> "Tap the lemonade to drink it."
        else -> "Tap the empty glass to start again."
    }
}