package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA8E9CB)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //1. Background
        Column(
            modifier = Modifier.weight(8f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //2. Image
            Avatar()
            //3. Name
            Name()
            //4. Position
            Designation()
        }
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.Top
        ) {
            //5. mobile number
            ComposeDemographics(iconId = R.drawable.call_icon, contentId = R.string.contact1)
            //6. Social Media Handler
            ComposeDemographics(
                iconId = R.drawable.share_icon,
                contentId = R.string.social_media_handle1
            )
            //7. Email
            ComposeDemographics(iconId = R.drawable.mail_icon, contentId = R.string.email1)
        }
    }
}

@Composable
fun ComposeDemographics(iconId: Int, contentId: Int) {
    Row {
        Image(
            painter = painterResource(id = iconId), contentDescription = null, modifier = Modifier
                .padding(end = 8.dp, bottom = 8.dp)
                .size(28.dp)
                .weight(0.4f), Alignment.CenterEnd
        )
        Text(
            text = stringResource(contentId), modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp), fontSize = 20.sp
        )
    }
}

@Composable
fun Designation() {
    Text(
        text = stringResource(id = R.string.user_designation2),
        modifier = Modifier.padding(bottom = 32.dp),
        color = Color(0xFF008300),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun Name() {
    Text(
        text = stringResource(id = R.string.user_name2),
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
        fontSize = 32.sp,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun Avatar() {
    Image(
        painter = painterResource(id = R.drawable.android_logo),
        contentDescription = null,
        alpha = 1F,
        modifier = Modifier
            .size(116.dp)
            .background(Color.Black)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}