package com.lubnamariyam.retrofitapiinjetpackcompose.view

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.google.android.material.color.MaterialColors
import com.lubnamariyam.retrofitapiinjetpackcompose.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .clip(RoundedCornerShape(20.dp))
            .background(color = MaterialTheme.colors.surface)
            .border(width = 1.dp, color = MaterialTheme.colors.onSurface),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = movie.imageUrl,
                        builder = {
                            scale(Scale.FILL)
                            placeholder(coil.compose.base.R.drawable.notification_action_background)
                        }
                    ),
                    contentDescription = movie.desc,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(1f)
                        .width(0.dp)
                ) {
                    Text(
                        text = movie.name,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = movie.desc,
                        style = MaterialTheme.typography.body2,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                    Text(
                        text = movie.category,
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onSurface,
                        overflow = TextOverflow.Clip,
                        modifier = Modifier
                            .background(color = MaterialTheme.colors.secondary)
                            .align(Alignment.End)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                }
            }
        }
    )
}
