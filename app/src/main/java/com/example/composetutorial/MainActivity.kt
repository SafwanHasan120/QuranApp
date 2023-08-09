package com.example.composetutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import androidx.compose.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.Purple200
import com.example.composetutorial.ui.theme.Purple500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .wrapContentSize(Alignment.Center)) {
                WelcomeCard(msg = Message("Safwan"))
                ReadingCard()
                viewButton()
            }

        }
    }
}


data class Message(val name: String)

val ubuntuFamily = FontFamily(
    Font(R.font.ubuntu_bold, FontWeight.Bold),
    Font(R.font.ubuntu_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.ubuntu_medium, FontWeight.Medium),
    Font(R.font.ubuntu_regular, FontWeight.Normal),
    Font(R.font.ubuntu_light, FontWeight.Light)
)

val notoSansFamily = FontFamily(
    Font(R.font.notosansarabic, FontWeight.Normal)
)

@Composable
fun WelcomeCard(msg: Message){
    Row{
        Column(modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)){
            Text(text = "السلام عليكم",
                textAlign = TextAlign.Center,
                fontFamily = notoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 45.sp)
            Text(text = msg.name,
                textAlign = TextAlign.Center,
                fontFamily = ubuntuFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 35.sp)
        }
    }
}


@Composable
fun ReadingCard(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
        .clip(shape = RoundedCornerShape(16.dp))) {
        Box(modifier = Modifier
            .size(350.dp)
            .background(color = Purple500)
            .border(width = 4.dp, color = Purple200, shape = RoundedCornerShape(16.dp))
            .wrapContentSize(align = Alignment.Center)
            ){

        }

    }
}

@Preview
@Composable
fun viewButton(){
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)
        .padding(top = 50.dp)
        ){
        Box(modifier = Modifier
            .size(150.dp, 40.dp)
            .clickable(onClick = {

                context.startActivity(Intent(context, ViewLog::class.java))
            })
            .clip(shape= RoundedCornerShape(16.dp))
            .background(Purple500)
            .border(
                width = 4.dp,
                color = Purple200,
                shape = RoundedCornerShape(16.dp)
            )
            .wrapContentSize(align = Alignment.Center)

            ){
            Text(text = "View",
                textAlign = TextAlign.Center,
                fontFamily = ubuntuFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp)

        }
    }

}


