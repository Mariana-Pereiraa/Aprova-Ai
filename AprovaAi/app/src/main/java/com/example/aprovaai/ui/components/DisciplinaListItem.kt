package com.example.aprovaai.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.Disciplina
import androidx.compose.material3.*
import androidx.compose.ui.unit.sp
import com.example.aprovaai.ui.theme.BlueBase
import com.example.aprovaai.ui.theme.GrayDark
import com.example.aprovaai.ui.theme.GrayLight


@Composable
fun DisciplinaListItem(
    disciplina: Disciplina,
    onDisciplinaSelected: (Disciplina) -> Unit,
    onFavoriteToggle: (Disciplina) -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(80.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = GrayLight)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(id = disciplina.imageDisc),
                    contentDescription = "${disciplina.name} Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(16.dp))
                

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    IconButton(
                        onClick = { onFavoriteToggle(disciplina) },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = if(disciplina.isFavorite) Icons.Default.Favorite
                            else Icons.Default.FavoriteBorder,
                            contentDescription = "Toggle Favoritos",
                            tint = if(disciplina.isFavorite) BlueBase
                            else GrayDark,
                                    modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { onDisciplinaSelected(disciplina) },
                        modifier = Modifier.height(40.dp)
                            .weight(1f),
                        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 2.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueBase)
                    ) {
                        Text(text = "${disciplina.name}",
                            fontSize = 17.sp)

                    }

                }


            }





            }
        }
    }

//@Preview
//@Composable
//private fun DisciplinaListItemPrev() {
//    DisciplinaListItem(
//        disciplina = Disciplina(
//            name = "Matemática",
//            imageDisc = R.drawable.ic_menu_add,
//            conteudos = EstudosConteudos(
//                id = 1,
//                name = "Álgebra",
//                dataEstudo = "2023-10-01",
//                dificuldade = 3
//            )
//        ),
//        onDisciplinaSelected = {},
//        onRevisarToggle = {}
//    ) {
//        // Preview
//    }
//}