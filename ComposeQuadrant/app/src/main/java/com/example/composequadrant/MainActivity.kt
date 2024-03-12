package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    /**
     * Color(0xFFEADDFF)
     * Color(0xFFD0BCFF)
     * Color(0xFFB69DF8)
     * Color(0xFFF6EDFF)
     */
    val text1a: String = stringResource(id = R.string.composable_article_1a)
    val text1b: String = stringResource(id = R.string.composable_article_1b)
    val text2a = stringResource(id = R.string.composable_article_2a)
    val text2b = stringResource(id = R.string.composable_article_2b)
    val text3a = stringResource(id = R.string.composable_article_3a)
    val text3b = stringResource(id = R.string.composable_article_3b)
    val text4a = stringResource(id = R.string.composable_article_4a)
    val text4b = stringResource(id = R.string.composable_article_4b)
    Row (
        Modifier
            .fillMaxHeight()
    ) {
        Box(
            Modifier
                .size(200.dp, 380.dp)
                .align(Alignment.Top)
                .background(Color(0xFFEADDFF)),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = text1a,
                modifier = Modifier
                    .padding(bottom = 168.dp),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = text1b,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
            )
        }
        Box(
            Modifier
                .size(200.dp, 380.dp)
                .align(Alignment.Top)
                .background(Color(0xFFD0BCFF)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text2a,
                modifier = Modifier
                    .padding(bottom = 168.dp),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = text2b,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
            )
        }
    }
    Row(
        Modifier
            .fillMaxHeight()
    ) {
        Box(
            Modifier
                .size(200.dp, 380.dp)
                .align(Alignment.Bottom)
                .background(Color(0xFFB69DF8)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text3a,
                modifier = Modifier
                    .padding(bottom = 168.dp),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = text3b,
                modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp)
            )
        }
        Box(
            Modifier
                .size(200.dp, 380.dp)
                .align(Alignment.Bottom)
                .background(Color(0xFFF6EDFF)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text4a,
                modifier = Modifier
                    .padding(bottom = 168.dp),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = text4b,
                modifier = Modifier
                    .padding(start = 12.dp, end = 12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Quadrant()
    }
}