// AppNavigation.kt
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.rickandmorty.presentation.character.characterGraph
import com.uvg.rickandmorty.presentation.login.loginScreen
import com.uvg.rickandmorty.presentation.login.profileScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    onLogin: (String) -> Unit,
    isLoggedIn: suspend () -> Boolean,
    onLogout: () -> Unit
) {
    val navController: NavHostController = rememberNavController()
    var startDestination by remember { mutableStateOf("login") }

    LaunchedEffect(Unit) {
        startDestination = if (isLoggedIn()) "profile" else "login"
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("login") {
            loginScreen(onLoginClick = { userName ->
                onLogin(userName)
                navController.navigate("profile/$userName")
            })
        }
        composable("profile/{userName}") { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            profileScreen(userName = userName, onLogoutClick = {
                onLogout()
                navController.navigate("login") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            })
        }
        characterGraph(navController)
    }
}