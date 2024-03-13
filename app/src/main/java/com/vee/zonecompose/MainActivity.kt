package com.vee.zonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vee.zonecompose.data.repository.FakeNoteRepository
import com.vee.zonecompose.enum.ScreensEnum
import com.vee.zonecompose.modules.HomeScreen
import com.vee.zonecompose.modules.home.HomeViewModel
import com.vee.zonecompose.modules.welcome.WelcomeScreen
import com.vee.zonecompose.ui.theme.BACKGROUND
import com.vee.zonecompose.ui.theme.ZoneComposeTheme


class MainActivity : ComponentActivity() {
    val navigation by lazy {
        AppNavigationViewModel(
            app = application,
            fakeNoteRepository = FakeNoteRepository(application)
        )
    }
    val homeViewModel by lazy {
        HomeViewModel(
            app = application,
            fakeNoteRepository = FakeNoteRepository(application)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZoneComposeTheme {
                val screen = remember {
                    mutableStateOf(ScreensEnum.WelCome)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BACKGROUND
                ) {
                    when (screen.value) {
                        ScreensEnum.WelCome -> WelcomeScreen("Vikesh")
                        ScreensEnum.AddNote -> HomeScreen("Vikesh",homeViewModel = homeViewModel)
                        ScreensEnum.Settings -> HomeScreen("Vikesh",homeViewModel = homeViewModel)
                        ScreensEnum.Home -> HomeScreen("Vikesh",homeViewModel = homeViewModel)
                        else -> WelcomeScreen("Vikesh")
                    }

                    navigation.currentScreen.observe(this) {
                        screen.value = it
                    }
                }
            }
        }

        navigation.handleSplash()
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    WelcomeScreen("Android")
}