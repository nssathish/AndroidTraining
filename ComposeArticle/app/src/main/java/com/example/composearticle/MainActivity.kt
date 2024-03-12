package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticle(
                        stringResource(R.string.jetpack_compose_article_text1),
                        stringResource(R.string.jetpack_compose_article_text2),
                        stringResource(R.string.jetpack_compose_article_text3)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(
    text1: String, text2: String, text3: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        TitleImage(modifier = modifier)
        Text(
            text = text1,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )
        Text(
            text = text3,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )
    }
}

@Composable
fun TitleImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = null,
        modifier = modifier,
        alpha = 1.0F,
        contentScale = ContentScale.Fit,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticle(
                stringResource(R.string.jetpack_compose_article_text1),
                stringResource(R.string.jetpack_compose_article_text2),
                stringResource(R.string.jetpack_compose_article_text3)
        )
    }
}