package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lemonade("Rajat")
                }
            }
        }
    }
}



@Composable
fun Lemonade(name:String){
    var current by remember{ mutableStateOf(0)}

    when (current) {
        0->{
            Column(modifier=Modifier
                .wrapContentSize(Alignment.Center)
                .fillMaxSize()
                .background(Color.Cyan),
                horizontalAlignment=Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Text(
                    text="Welcome $name!",
                    fontSize=40.sp
                )
                Button(onClick= { current=1},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                    modifier=Modifier
                        .height(60.dp)
                        .width(120.dp))
                {
                    Text(text="Start",
                        fontSize=28.sp)
                }
            }
        }
        1 -> {
            Column(
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.Tree),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Spacer(modifier=Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = stringResource(R.string.LemonTree),
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .clickable {current=2 }
                        .border(width=2.dp,color= Color(105,205,216),shape= CutCornerShape(4.dp))
                        .padding(14.dp)
                )
            }
        }
        2 -> {
            Column(
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.Lemon),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Spacer(modifier=Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = stringResource(R.string.Lemons),
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .border(width=2.dp,color= Color(105,205,216),shape= CutCornerShape(4.dp))
                        .padding(14.dp)
                        .clickable {current=(2..3).random() }
                )
            }
        }
        3 -> {
            Column(
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.Lemonade),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Spacer(modifier=Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = stringResource(R.string.GlassFull),
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .clickable {current=4 }
                        .border(width=2.dp,color= Color(105,205,216),shape= CutCornerShape(4.dp))
                        .padding(14.dp)

                )
            }
        }
        4 -> {
            Column(
                modifier = Modifier
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .wrapContentSize(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.EmptyGlass),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
                Spacer(modifier=Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = stringResource(R.string.GlassEmpty),
                    modifier = Modifier
                        .wrapContentSize(Alignment.Center)
                        .clickable {current=1 }
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .border(width=2.dp,color= Color(105,205,216),shape= CutCornerShape(4.dp))
                        .padding(14.dp)

                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        Lemonade("Rajat")
    }
}