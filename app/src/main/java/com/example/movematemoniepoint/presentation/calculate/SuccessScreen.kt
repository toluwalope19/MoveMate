package com.example.movematemoniepoint.presentation.calculate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movematemoniepoint.R
import com.example.movematemoniepoint.presentation.calculate.components.CalculateButton
import com.example.movematemoniepoint.ui.theme.MoveMateMoniepointTheme

@Composable
fun SuccessScreen(onBackToHome: () -> Unit) {

    var visible by remember { mutableStateOf(false) }
    val targetAmount = 1434
    val animatedAmount = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        animatedAmount.animateTo(
            targetValue = targetAmount.toFloat(),
            animationSpec = tween(durationMillis = 2000)
        )
    }

    val displayedAmount = animatedAmount.value.toInt()


    LaunchedEffect(Unit) {
        visible = true
    }

    // Whole screen container
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 1000)
            ) + fadeIn(animationSpec = tween(durationMillis = 1000))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.movemate_logo),
                    contentDescription = "MoveMate Logo",
                    modifier = Modifier.size(150.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Image(
                    painter = painterResource(R.drawable.ic_pack),
                    contentDescription = "Box"
                )

                Spacer(modifier = Modifier.height(24.dp))

                val contentWidth = 300.dp
                Box(
                    modifier = Modifier
                        .width(contentWidth)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Total Estimated Amount",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(
                                text = "$$displayedAmount",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = Color(0xFF00B386)
                                )
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "USD",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = Color(0xFF00B386),
                                    fontWeight = FontWeight.Normal
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "This amount is estimated. It may vary if you change your location or weight",
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(36.dp))

                CalculateButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    onClick = { onBackToHome() },
                    text = "Back to home"
                )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun EstimateSuccessScreenPreview() {
    MoveMateMoniepointTheme {
        SuccessScreen(onBackToHome = {})
    }
}

