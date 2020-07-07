package com.samples.composesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.Shape
import androidx.ui.graphics.vector.VectorAsset
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Favorite
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            buildApp()
        }
    }

    @Composable
    fun buildApp() {
        MaterialTheme {
            val fabShape = CircleShape
            Scaffold(
                bottomAppBar = {
                    buildBottomBar(fabConfiguration = it, cutOutShape = fabShape)
                },
                floatingActionButton = {
                    buildFAB(fabShape = fabShape)
                },
                floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked
            ) {
                Text(text = "Hello World!")
            }
        }
    }

    @Composable
    fun buildBottomBar(fabConfiguration: BottomAppBar.FabConfiguration?, cutOutShape: Shape?) {

        BottomAppBar(fabConfiguration = fabConfiguration, cutoutShape = cutOutShape) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(modifier = Modifier.weight(1f)) {
                    Box(modifier = Modifier.width(8.dp))
                    buildBottomMenuItem(
                        iconAsset = Icons.Filled.Favorite,
                        text = "Item 1",
                        click = {})
                    buildBottomMenuItem(
                        iconAsset = Icons.Filled.Favorite,
                        text = "Item 2",
                        click = {})
                }
                Box(modifier = Modifier.weight(1f)) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.width(8.dp))
                        buildBottomMenuItem(
                            iconAsset = Icons.Filled.Favorite,
                            text = "Item 3",
                            click = {})
                        buildBottomMenuItem(
                            iconAsset = Icons.Filled.Favorite,
                            text = "Item 4",
                            click = {})
                    }
                }
            }

        }
    }

    @Composable
    fun buildBottomMenuItem(iconAsset: VectorAsset, text: String, click: () -> Unit) {
        Column(
            horizontalGravity = Alignment.CenterHorizontally,
            modifier = Modifier.absolutePadding(left = 8.dp, right = 8.dp)
        ) {
            IconButton(click, modifier = Modifier.preferredSize(24.dp)) {
                Icon(iconAsset)
            }
            Text(text = text)
        }
    }

    @Composable
    fun buildFAB(fabShape: Shape) {
        FloatingActionButton(
            shape = fabShape,
            onClick = { /* doSomething() */ },
            backgroundColor = MaterialTheme.colors.primary,
            icon = { Icon(Icons.Filled.Favorite, tint = Color.White) }
        )
    }

    @Preview
    @Composable
    fun AppPreview() {
        buildApp()
    }
}
