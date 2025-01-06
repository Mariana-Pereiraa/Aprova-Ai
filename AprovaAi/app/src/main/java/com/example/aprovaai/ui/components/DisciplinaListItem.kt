package com.example.aprovaai.ui.components

import androidx.compose.foundation.Image
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
    onRevisarToggle: (Disciplina) -> Unit
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

                Text(
                    text = disciplina.name,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
                    modifier = Modifier.weight(1f)
                )
//                COLOCAR DENTRO DE CONTEÚDO
//                IconButton(
//                    onClick = { onRevisarToggle(disciplina) }
//                ) {
//                    Icon(
//                       imageVector = if(disciplina.conteudos.isRevisar) Icons.Default.CheckBox
//                                        else Icons.Default.CheckBoxOutlineBlank,
//                        contentDescription = "Toggle Revisar",
//                       tint = if(disciplina.conteudos.isRevisar) BlueBase
//                              else GrayDark
//                    )
//                }
//            }


                Button(
                    onClick = { onDisciplinaSelected(disciplina) },
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueBase)
                ) {
                    Text(text = "Abrir",
                        fontSize = 14.sp)

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