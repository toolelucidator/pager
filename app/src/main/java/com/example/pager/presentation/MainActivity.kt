/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.pager.presentation

import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat.Actions
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.HorizontalPageIndicator
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.PageIndicatorState
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.pager.R
import com.example.pager.presentation.theme.PagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()
    val pagerState = rememberPagerState(initialPage = 0)

    PagerTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            SwipeDismissableNavHost(
                navController = navController,
                startDestination = "start",
                modifier = Modifier.fillMaxSize(),

                ) {
                composable("start") {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { navController.navigate("second") }) {
                            Text(text = "Start")
                        }
                    }
                }
                composable("second") {
                    val shape = if (LocalConfiguration.current.isScreenRound) CircleShape else null
                    //Page2()
                    Box(modifier = Modifier.fillMaxSize()) {

                        //HorizontalPager
                        HorizontalPager(
                            count = 2,
                            state = pagerState,
                            modifier = Modifier.align(Alignment.Center)
                            //modifier = Modifier.fillMaxSize()
                        ) { page ->
                            if (page == 0) {
                                Box() {
                                    Text("Esta es la página 1 ")
                                }
                            }
                            if (page == 1) {
                                Box() {
                                    Text("Esta es la página 2 ")
                                }
                            }

                        }
                        HorizontalPagerIndicator(
                            modifier = Modifier.align(
                                Alignment.BottomCenter
                            ), pagerState = PagerState(),
                            pageCount = 2,
                            indicatorShape = CircleShape,
                            activeColor = Color.Blue,
                            inactiveColor = Color.Red,
                            indicatorWidth = 12.dp,


                            )

                    }

                }
            }
        }
    }
}


