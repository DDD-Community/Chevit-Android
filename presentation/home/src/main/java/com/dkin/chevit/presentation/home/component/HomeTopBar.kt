package com.dkin.chevit.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.Logo
import com.dkin.chevit.presentation.resource.icon.Notification

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .padding(vertical = 18.dp, horizontal = 24.dp),
    ) {
        Row {
            Image(imageVector = ChevitIcon.Logo, contentDescription = "Logo")
            Spacer(modifier = Modifier.weight(1f, true))
            //알림 오픈스펙 제외
            //Image(imageVector = ChevitIcon.Notification, contentDescription = "Notification")
        }
    }
}
