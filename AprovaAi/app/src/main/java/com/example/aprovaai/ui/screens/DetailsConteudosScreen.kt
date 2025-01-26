package com.example.aprovaai.ui.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aprovaai.models.EstudosConteudos
import com.example.aprovaai.models.Dificuldade
import com.example.aprovaai.models.Disciplina
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import com.example.aprovaai.notifications.StudyReminderReceiver
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsConteudosScreen(
    conteudos: EstudosConteudos,
    onConteudoSelected: (EstudosConteudos) -> Unit,
    disciplina: Disciplina,
    context: Context,
    navController: NavController,
    isNotificationsEnabled: Boolean
) {
    // Estados para gerenciar as interações
    var dataEstudo by remember { mutableStateOf("") }
    var dificuldadeSelecionada by remember { mutableStateOf(conteudos.dificuldade.name) }
    val opcoesDificuldade = Dificuldade.values().map { it.name }
    var checkEstudo by remember { mutableStateOf(conteudos.checkEstudo) }
    var resolucao by remember { mutableStateOf(conteudos.resolucao) }
    var revisar by remember { mutableStateOf(conteudos.isRevisar) }
    var anotacoes by remember { mutableStateOf(conteudos.anotacoes) }

    val context = LocalContext.current
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    var selectedYear by remember { mutableStateOf(calendar.get(Calendar.YEAR)) }
    var selectedMonth by remember { mutableStateOf(calendar.get(Calendar.MONTH)) }
    var selectedDay by remember { mutableStateOf(calendar.get(Calendar.DAY_OF_MONTH)) }
    var selectedHour by remember { mutableStateOf(0) }
    var selectedMinute by remember { mutableStateOf(0) }

    if (showDatePicker) {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                selectedYear = year
                selectedMonth = month
                selectedDay = dayOfMonth
                showDatePicker = false
                showTimePicker = true
            },
            selectedYear,
            selectedMonth,
            selectedDay
        ).show()
    }

    if (showTimePicker) {
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                selectedHour = hourOfDay
                selectedMinute = minute
                showTimePicker = false
            },
            selectedHour,
            selectedMinute,
            true
        ).show()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = disciplina.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = conteudos.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    showDatePicker = true
                }) {
                    Text("Data do Estudo")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Data do Estudo: $selectedDay/${selectedMonth + 1}/$selectedYear às $selectedHour:$selectedMinute",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))
        }

        item {
            Text(
                text = "Dificuldade:",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))

            DropdownDificuldade(
                dificuldadeSelecionada,
                opcoesDificuldade,
                onDificuldadeSelecionada = { dificuldadeSelecionada = it }
            )
        }

        item {
            CheckboxComLabel(
                label = "Estudei todo o conteúdo?",
                checked = checkEstudo,
                onCheckedChange = { checkEstudo = it }
            )
            CheckboxComLabel(
                label = "Resolvi questões?",
                checked = resolucao,
                onCheckedChange = { resolucao = it }
            )
            CheckboxComLabel(
                label = "Preciso revisar?",
                checked = revisar,
                onCheckedChange = { revisar = it }
            )
        }

        item {
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Defina uma data e horário para lembrete:", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    showDatePicker = true
                }) {
                    Text("Selecione a Data e Horário")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Data e Hora selecionadas: $selectedDay/${selectedMonth + 1}/$selectedYear às $selectedHour:$selectedMinute",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Button(onClick = {
                    if (isNotificationsEnabled) {
                        agendarAlarme(context, selectedYear, selectedMonth, selectedDay, selectedHour, selectedMinute, conteudos.name, isNotificationsEnabled)
                        Toast.makeText(context, "Lembrete de estudo agendado!", Toast.LENGTH_SHORT).show()
                        Log.d("DetailsConteudosScreen", "Lembrete de estudo agendado")
                    }
                    else {
                        Toast.makeText(context, "Notificações desativadas. Alarme não agendado.", Toast.LENGTH_SHORT).show()
                        Log.d("DetailsConteudosScreen", "Notificações desativadas. Alarme não agendado.")
                    }
                    navController.popBackStack()
                }) {
                    Text("Agendar Lembrete")
                }
            }


        }

        item {
            Text(
                text = "Anotações:",
                style = MaterialTheme.typography.bodyLarge
            )
            OutlinedTextField(
                value = anotacoes,
                onValueChange = { anotacoes = it },
                label = { Text("Escreva aqui") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    Toast.makeText(context, "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }) {
                    Text("Salvar")
                }
            }
        }
    }
}

@Composable
fun DropdownDificuldade(
    dificuldadeSelecionada: String,
    opcoes: List<String>,
    onDificuldadeSelecionada: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(onClick = { expanded = !expanded }) {
            Text(dificuldadeSelecionada)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opcoes.forEach { dificuldade ->
                DropdownMenuItem(
                    text = { Text(dificuldade) },
                    onClick = {
                        onDificuldadeSelecionada(dificuldade)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CheckboxComLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

fun agendarAlarme(
    context: Context,
    year: Int,
    month: Int,
    day: Int,
    hour: Int,
    minute: Int,
    contentText: String,
    notificationsEnabled: Boolean
) {
    if (!notificationsEnabled) {
        Toast.makeText(context, "Notificações desativadas. Alarme não agendado.", Toast.LENGTH_SHORT).show()
        Log.d("agendarAlarme", "Notificações desativadas. Alarme não agendado.")
        return
    }

    try {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, StudyReminderReceiver::class.java).apply {
            putExtra("CONTENT_TEXT", "Hora de estudar: $contentText")
        }
        Log.d("agendarAlarme", "Criando PendingIntent")
        val pendingIntent = PendingIntent.getBroadcast(
            context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, day)
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            if (before(Calendar.getInstance())) {
                add(Calendar.DATE, 1) // Se a hora já passou, programe para o próximo dia
            }
        }
        Log.d("agendarAlarme", "Hora do alarme: ${calendar.time}")

        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        Log.d("agendarAlarme", "Alarme agendado para: ${calendar.time}")
    } catch (e: Exception) {
        Log.e("agendarAlarme", "Erro ao agendar o alarme", e)
    }
}

