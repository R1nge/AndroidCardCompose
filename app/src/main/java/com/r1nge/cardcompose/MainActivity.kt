package com.r1nge.cardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.r1nge.cardcompose.ui.theme.CardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardComposeTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val painter = painterResource(id = R.drawable.ic_launcher_background)
                    val description = "Android Icon"
                    val title = "Android Icon Title"
                    LazyVerticalStaggeredGrid(
                        columns = StaggeredGridCells.Fixed(3),
                        verticalItemSpacing = 4.dp,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            items(5) {
                                BoxedImageCard(
                                    painter = painter,
                                    contentDescription = description,
                                    title = title,
                                    modifier = Modifier
                                )
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }


    @Composable
    fun BoxedImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)
        ) {
            ImageCard(painter, contentDescription, title)
        }
    }

    @Composable
    fun ImageCard(
        painter: Painter,
        contentDescription: String,
        title: String,
        modifier: Modifier = Modifier
    ) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ),
                                startY = 300f
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomStart
                ) {
                    Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
        }
    }
}