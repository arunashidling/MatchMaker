package com.smb.smbmatchmaker.presentation.smb_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.matchmaker.presentation.Screen
import com.smb.smbmatchmaker.presentation.smb_list.components.SearchField
import com.smb.smbmatchmaker.presentation.smb_list.components.SmbListItem




@Composable
fun SmbListScreen (
    navController: NavController,
    viewModel: SmbListViewModel = hiltViewModel()

) {
    var credentials by remember { mutableStateOf(Credentials()) }
    val state = viewModel.state.value
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {

        SearchField(
           // value = credentials.login
        //    onChange = { "" },
       //     modifier = Modifier.fillMaxWidth()

                    value = credentials.search,
            onChange = { data -> credentials = credentials.copy(search = data) },
            modifier = Modifier.fillMaxWidth()
        )

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {


               // Spacer(modifier = Modifier.height(40.dp))

                items(state.smbList) { smbItem ->
                    SmbListItem(smbItem = smbItem,
                        onItemClick = {
                            navController.navigate(Screen.SmbDetailScreen.route + "/${smbItem.id}")
                        }
                    )
                    Divider(color = MaterialTheme.colors.background)
                }

            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )


            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }


}

data class Credentials(
    var search: String = "",
    // var pwd: String =  "",
    //var remember: Boolean = false
) {
    fun isNotEmpty(): Boolean {
        return search.isNotEmpty()
    }
}


