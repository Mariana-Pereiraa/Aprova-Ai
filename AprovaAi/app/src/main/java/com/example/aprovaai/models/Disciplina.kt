        package com.example.aprovaai.models
        import java.util.Date
        import com.example.aprovaai.R

        data class Disciplina(
            val id: Int,
            val name: String,
            val imageDisc: Int,
            val conteudos: List<EstudosConteudos>,
            var isFavorite: Boolean = false
        )

        val disciplinasList = listOf(
            Disciplina(
                id = 1 ,
                name = "Português",
                imageDisc = R.drawable.portugues,
                conteudos = listOf(EstudosConteudos(
                    id = 1,
                    name = "Literatura",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = false,
                    isRevisar = false,
                    anotacoes = "Estudar Literatura"
                ),
                    EstudosConteudos(
                        id = 2,
                        name = "Movimento Barroco",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        isRevisar = false,
                        anotacoes = "Estudar Movimento Barroco"
                    ),
                    EstudosConteudos(
                        id = 3,
                        name = "Quinhentismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        isRevisar = false,
                        anotacoes = "Estudar Quinhentismo"
                    ),
                    EstudosConteudos(
                        id = 4,
                        name = "Movimento Modernista",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Movimento Modernista"
                    ),
                    EstudosConteudos(
                        id = 5,
                        name = "Movimento Naturalista",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Movimento Naturalista"
                    ),
                    EstudosConteudos(
                        id = 6,
                        name = "Realismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Realismo"
                    ),
                    EstudosConteudos(
                        id = 7,
                        name = "Figuras de Linguagem",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Figuras de Linguagem"
                    ),
                    EstudosConteudos(
                        id = 8,
                        name = "Poesias Concretas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Poesias Concretas"
                    ),
                    EstudosConteudos(
                        id = 9,
                        name = "Literatura Contemporânea",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Literatura Contemporânea"
                    ),
                    EstudosConteudos(
                        id = 10,
                        name = "Funções da Linguagem",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Funções da Linguagem"
                    ),
                    EstudosConteudos(
                        id = 11,
                        name = "Gramática",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Gramática"
                    ),
                    EstudosConteudos(
                        id = 12,
                        name = "Semântica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Semântica"
                    ),
                    EstudosConteudos(
                        id = 13,
                        name = "Compreensão e interpretação de texto",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Compreensão e interpretação de texto"
                    ),
                    EstudosConteudos(
                        id = 14,
                        name = "Funções da Linguagem",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Funções da Linguagem"
                    ),
                    EstudosConteudos(
                        id = 15,
                        name = "Norma culta",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Norma Coloquial"
                    ),
                    EstudosConteudos(
                        id = 16,
                        name = "Morfologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Morfologia"
                    ),
                    EstudosConteudos(
                        id = 17,
                        name = "Linguística",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Linguística"
                    ),
                    EstudosConteudos(
                        id = 18,
                        name = "Sintaxe",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Sintaxe"
                    ),
                    EstudosConteudos(
                        id = 19,
                        name = "Gêneros textuais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Gêneros textuais"
                    ),
                    EstudosConteudos(
                        id = 20,
                        name = "Intertextualidade",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Intertextualidade"
                    ),
                    EstudosConteudos(
                        id = 21,
                        name = "Denotação e conotação",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Denotação e conotação"
                    ),
                    EstudosConteudos(
                        id = 22,
                        name = "Vanguardas europeias",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Vanguardas europeias"
                    ),
                    EstudosConteudos(
                        id = 23,
                        name = "Classe de palavras",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Classe de palavras"
                    ),
                    EstudosConteudos(
                        id = 24,
                        name = "Verbo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = false,
                        anotacoes = "Estudar Verbo"
                    ))
            ),

            Disciplina(
                id = 2,
                name = "Matemática",
                imageDisc = R.drawable.matematica,
                conteudos = listOf(EstudosConteudos(
                    id = 25 ,
                    name = "Área, volume e perímetros",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Área, volume e perímetros"
                ),
                    EstudosConteudos(
                        id = 26 ,
                        name = "Análise combinatória",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Análise combinatória"
                    ),
                    EstudosConteudos(
                        id = 27 ,
                        name = "Progressão aritmética",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Progressão aritmética"
                    ),
                    EstudosConteudos(
                        id = 28 ,
                        name = "Progressão geométrica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Progressão geométrica"
                    ),
                    EstudosConteudos(
                        id = 29 ,
                        name = "Funções de 1° grau",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Funções de 1° grau"
                    ),
                    EstudosConteudos(
                        id = 30 ,
                        name = "Funções de 2° grau",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Funções de 2° grau"
                    ),
                    EstudosConteudos(
                        id = 31 ,
                        name = "Equações de 1° grau",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Equações de 1° grau"
                    ),
                    EstudosConteudos(
                        id = 32 ,
                        name = "Equações de 2° grau",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Equações de 2° grau"
                    ),
                    EstudosConteudos(
                        id = 33 ,
                        name = "Grandezas proporcionais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Grandezas proporcionais"
                    ),
                    EstudosConteudos(
                        id = 34 ,
                        name = "Seno",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Seno"
                    ),
                    EstudosConteudos(
                        id = 35 ,
                        name = "Cosseno",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cosseno"
                    ),
                    EstudosConteudos(
                        id = 36 ,
                        name = "Tangente",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Tangente"
                    ),
                    EstudosConteudos(
                        id = 37 ,
                        name = "Probabilidade",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Probabilidade"
                    ),
                    EstudosConteudos(
                        id = 38 ,
                        name = "Metro cúbico",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Metro cúbico"
                    ),
                    EstudosConteudos(
                        id = 39 ,
                        name = "Porcentagem",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Porcentagem"
                    ),
                    EstudosConteudos(
                        id = 40 ,
                        name = "Trigonometria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Trigonometria"
                    ),
                    EstudosConteudos(
                        id = 41 ,
                        name = "Estatística - Média aritmética",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Média aritmética"
                    ),
                    EstudosConteudos(
                        id = 42 ,
                        name = "Estatística - Moda",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Moda"
                    ),
                    EstudosConteudos(
                        id = 43 ,
                        name = "Estatística - Mediana",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Área, volume e perímetros"
                    ),
                    EstudosConteudos(
                        id = 44 ,
                        name = "Geometria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Geometria"
                    ),
                    EstudosConteudos(
                        id = 45 ,
                        name = "Escalas, Razão e Proporção",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Escalas, Razão e Proporção"
                    ),
                    EstudosConteudos(
                        id = 46 ,
                        name = "Grandezas proporcionais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Grandezas proporcionais"
                    ),
                    EstudosConteudos(
                        id = 47 ,
                        name = "Aritmética",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Aritmética"
                    ),
                    EstudosConteudos(
                        id = 48 ,
                        name = "Gráficos e Tabelas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Gráficos e Tabelas"
                    ),
                    EstudosConteudos(
                        id = 49 ,
                        name = "Área de figuras planas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Área de figuras planas"
                    ),
                    EstudosConteudos(
                        id = 50 ,
                        name = "Área dos Polígonos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Área dos Polígonos"
                    ))
            ),

            Disciplina(
                id = 3,
                name = "Química",
                imageDisc = R.drawable.quimica,
                conteudos = listOf(EstudosConteudos(
                    id = 51,
                    name = "Neutralidade",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Neutralidade"
                ),
                    EstudosConteudos(
                        id = 52 ,
                        name = "Oxidação",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Oxidação"
                    ),
                    EstudosConteudos(
                        id = 53 ,
                        name = "Equilíbrios químicos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Equilíbrios químicos"
                    ),
                    EstudosConteudos(
                        id = 54 ,
                        name = "Estequiometria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Estequiometria"
                    ),
                    EstudosConteudos(
                        id = 55 ,
                        name = "Nomenclatura",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Nomenclatura"
                    ),
                    EstudosConteudos(
                        id = 56 ,
                        name = "Química e meio ambiente",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Química e meio ambiente"
                    ),
                    EstudosConteudos(
                        id = 57 ,
                        name = "Radiação",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Radiação"
                    ),
                    EstudosConteudos(
                        id = 58 ,
                        name = "Hidrocarbonetos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Hidrocarbonetos"
                    ),
                    EstudosConteudos(
                        id = 59 ,
                        name = "Soluções químicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Soluções químicas"
                    ),
                    EstudosConteudos(
                        id = 60 ,
                        name = "Compostos orgânicos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Compostos orgânicos"
                    ),
                    EstudosConteudos(
                        id = 61 ,
                        name = "Isomeria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Isomeria"
                    ),
                    EstudosConteudos(
                        id = 62 ,
                        name = "Funções orgânicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Funções orgânicas"
                    ),
                    EstudosConteudos(
                        id = 63 ,
                        name = "Combustíveis",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Combustíveis"
                    ),
                    EstudosConteudos(
                        id = 64 ,
                        name = "Funções orgânicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Funções orgânicas"
                    ),
                    EstudosConteudos(
                        id = 65 ,
                        name = "Cálculo de pH",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cálculo de pH"
                    ),
                    EstudosConteudos(
                        id = 66 ,
                        name = "Oxidação",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Oxidação"
                    ),
                    EstudosConteudos(
                        id = 67 ,
                        name = "Termoquímica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Termoquímica"
                    ),
                    EstudosConteudos(
                        id = 68 ,
                        name = "Reações orgânicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Reações orgânicas"
                    ),
                    EstudosConteudos(
                        id = 69 ,
                        name = "Físico-Química",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Físico-Química"
                    ),
                    EstudosConteudos(
                        id = 70 ,
                        name = "Química Orgânica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Química Orgânica"
                    ),
                    EstudosConteudos(
                        id = 71 ,
                        name = "Ligações químicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ligações químicas"
                    ),
                    EstudosConteudos(
                        id = 72 ,
                        name = "Polaridade e forças",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Polaridade e forças"
                    ),
                    EstudosConteudos(
                        id = 73 ,
                        name = "Reações orgânicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Reações orgânicas"
                    ),
                    EstudosConteudos(
                        id = 74 ,
                        name = "Eletroquímica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Eletroquímica"
                    ),
                    EstudosConteudos(
                        id = 75 ,
                        name = "Termoquímica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Termoquímica"
                    ),
                    EstudosConteudos(
                        id = 76 ,
                        name = "Estequiometria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Estequiometria"
                    ),
                    EstudosConteudos(
                        id = 77 ,
                        name = "Soluções",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Soluções"
                    ))
            ),

            Disciplina(
                id = 4,
                name = "Física",
                imageDisc = R.drawable.fisica,
                conteudos = listOf(EstudosConteudos(
                    id = 78,
                    name = "Análise dimensional",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Análise dimensional"
                ),
                    EstudosConteudos(
                        id = 79 ,
                        name = "Energia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Energia"
                    ),
                    EstudosConteudos(
                        id = 80 ,
                        name = "Correntes e potência elétrica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Correntes e potência elétrica"
                    ),
                    EstudosConteudos(
                        id = 81 ,
                        name = "Mecânica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Mecânica"
                    ),
                    EstudosConteudos(
                        id = 82 ,
                        name = "Fenômenos ondulatórios",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Fenômenos ondulatórios"
                    ),
                    EstudosConteudos(
                        id = 83 ,
                        name = "Eletricidade",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Eletricidade"
                    ),
                    EstudosConteudos(
                        id = 84 ,
                        name = "Termofísica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Termofísica"
                    ),
                    EstudosConteudos(
                        id = 85 ,
                        name = "Resistores",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Resistores"
                    ),

                    EstudosConteudos(
                        id = 86 ,
                        name = "Calorimetria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Calorimetria"
                    ),
                    EstudosConteudos(
                        id = 87 ,
                        name = "Trabalho e potência",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Trabalho e potência"
                    ),
                    EstudosConteudos(
                        id = 88 ,
                        name = "Trabalho e potência",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Trabalho e potência"
                    ),
                    EstudosConteudos(
                        id = 89 ,
                        name = "Impulso",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Impulso"
                    ),
                    EstudosConteudos(
                        id = 90 ,
                        name = "Quantidade de movimento",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Quantidade de movimento"
                    ),
                    EstudosConteudos(
                        id = 91 ,
                        name = "Introdução à óptica geométrica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Introdução à óptica geométrica"
                    ),
                    EstudosConteudos(
                        id = 92 ,
                        name = "Óptica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Óptica"
                    ))
            ),

            Disciplina(
                id = 5,
                name = "Biologia",
                imageDisc = R.drawable.biologia,
                conteudos = listOf(EstudosConteudos(
                    id = 93,
                    name = "Ciclos biogeoquímicos",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Ciclos biogeoquímicos"
                ),
                    EstudosConteudos(
                        id = 94,
                        name = "Genética",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Genética"
                    ),
                    EstudosConteudos(
                        id = 95,
                        name = "Biotecnologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Biotecnologia"
                    ),
                    EstudosConteudos(
                        id = 96,
                        name = "Biotecnologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Biotecnologia"
                    ),
                    EstudosConteudos(
                        id = 97,
                        name = "Evolução",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Evolução"
                    ),
                    EstudosConteudos(
                        id = 98,
                        name = "Fisiologia humana",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Fisiologia humana"
                    ),
                    EstudosConteudos(
                        id = 99,
                        name = "Biomas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Biomas"
                    ),
                    EstudosConteudos(
                        id = 100,
                        name = "Teia Alimentar",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Teia Alimentar"
                    ),
                    EstudosConteudos(
                        id = 101,
                        name = "Cadeia Alimentar",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cadeia Alimentar"
                    ),
                    EstudosConteudos(
                        id = 102,
                        name = "Fluxo de Energia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Fluxo de Energia"
                    ),
                    EstudosConteudos(
                        id = 103,
                        name = "Ambiente",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ambiente"
                    ),
                    EstudosConteudos(
                        id = 104,
                        name = "Citologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Citologia"
                    ),
                    EstudosConteudos(
                        id = 105,
                        name = "Humanidade",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Humanidade"
                    ),
                    EstudosConteudos(
                        id = 106,
                        name = "Histologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Histologia"
                    ),
                    EstudosConteudos(
                        id = 107,
                        name = "Fisiologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Fisiologia"
                    ),
                    EstudosConteudos(
                        id = 108,
                        name = "Sistema imunológico",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Sistema imunológico"
                    ),
                    EstudosConteudos(
                        id = 109,
                        name = "Ecossistemas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ecossistemas"
                    ),
                    EstudosConteudos(
                        id = 110,
                        name = "Fundamentos da ecologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Fundamentos da ecologia"
                    ),
                    EstudosConteudos(
                        id = 111,
                        name = "Ecologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ecologia"
                    ),
                    EstudosConteudos(
                        id = 112,
                        name = "DNA",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar DNA"
                    ),
                    EstudosConteudos(
                        id = 113,
                        name = "RNA",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar RNA"
                    ),
                    EstudosConteudos(
                        id = 114,
                        name = "Metabolismo Energético",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Metabolismo Energético"
                    ),
                    EstudosConteudos(
                        id = 115,
                        name = "Hormônios",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Hormônios"
                    ),
                    EstudosConteudos(
                        id = 116,
                        name = "Tecidos animais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Tecidos animais"
                    ),
                    EstudosConteudos(
                        id = 117,
                        name = "Tecidos vegetais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Tecidos vegetais"
                    ),
                    EstudosConteudos(
                        id = 118,
                        name = "Parasitologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Parasitologia"
                    ),
                    EstudosConteudos(
                        id = 117,
                        name = "Classificação das plantas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Classificação das plantas"
                    ),
                    EstudosConteudos(
                        id = 118,
                        name = "Parasitologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Parasitologia"
                    ),
                    EstudosConteudos(
                        id = 119,
                        name = "Exploração e uso de recursos naturais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Exploração e uso de recursos naturais"
                    ),
                    EstudosConteudos(
                        id = 120,
                        name = "Vírus",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Vírus"
                    )),
            ),

            Disciplina(
                id = 6,
                name = "Geografia",
                imageDisc = R.drawable.geografia,
                conteudos = listOf(EstudosConteudos(
                    id = 121,
                    name = "Agricultura Brasileira",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Agricultura Brasileira"
                ),
                    EstudosConteudos(
                        id = 122 ,
                        name = "Impactos no meio ambiente",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Impactos no meio ambiente"
                    ),
                    EstudosConteudos(
                        id = 123,
                        name = "Planos e blocos econômicos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Planos e blocos econômicos"
                    ),
                    EstudosConteudos(
                        id = 124,
                        name = "Geopolítica mundial",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Geopolítica mundial"
                    ),
                    EstudosConteudos(
                        id = 125,
                        name = "Migrações",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Migrações"
                    ),
                    EstudosConteudos(
                        id = 126,
                        name = "Desenvolvimento humano",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Desenvolvimento humano"
                    ),
                    EstudosConteudos(
                        id = 127,
                        name = "Desenvolvimento social",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Desenvolvimento social"
                    ),
                    EstudosConteudos(
                        id = 128,
                        name = "Uso de mapas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Uso de mapas"
                    ),
                    EstudosConteudos(
                        id = 129,
                        name = "Indústria brasileira",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Indústria brasileira"
                    ),
                    EstudosConteudos(
                        id = 130,
                        name = "Revolução Industrial",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Revolução Industrial"
                    ),
                    EstudosConteudos(
                        id = 131,
                        name = "Questão da água",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Questão da água"
                    ),
                    EstudosConteudos(
                        id = 132,
                        name = "Energias Renováveis",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Energias Renováveis"
                    ),
                    EstudosConteudos(
                        id = 133,
                        name = "Urbanização",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Urbanização"
                    ),
                    EstudosConteudos(
                        id = 134,
                        name = "Violência advinda da Urbanização",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Conteúdo de Violência advinda da Urbanização"
                    ),
                    EstudosConteudos(
                        id = 135,
                        name = "Conflitos por terra",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Conflitos por terra"
                    ),
                    EstudosConteudos(
                        id = 136,
                        name = "Impactos ambientais da poluição",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Impactos ambientais da poluição"
                    ),
                    EstudosConteudos(
                        id = 137,
                        name = "Crescimento populacional",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Crescimento populacional"
                    ),
                    EstudosConteudos(
                        id = 138,
                        name = "Transportes",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Transportes"
                    ),
                    EstudosConteudos(
                        id = 139,
                        name = "Geografia Agrária",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Geografia Agrária"
                    ),
                    EstudosConteudos(
                        id = 140,
                        name = "Meio Ambiente",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Meio Ambiente"
                    ),
                    EstudosConteudos(
                        id = 141,
                        name = "Demografia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Demografia"
                    ),
                    EstudosConteudos(
                        id = 142,
                        name = "Geopolítica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Geopolítica"
                    ),
                    EstudosConteudos(
                        id = 143,
                        name = "Cultura",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cultura"
                    ),
                    EstudosConteudos(
                        id = 144,
                        name = "Climatologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Climatologia"
                    ),
                    EstudosConteudos(
                        id = 145,
                        name = "Globalização",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Globalização"
                    ),
                    EstudosConteudos(
                        id = 146,
                        name = "Cartografia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cartografia"
                    ))
            ),

            Disciplina(
                id = 7,
                name = "História",
                imageDisc = R.drawable.historia,
                conteudos = listOf(EstudosConteudos(
                    id = 147,
                    name = "História do Brasil",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar História do Brasil"
                ),
                    EstudosConteudos(
                        id = 148 ,
                        name = "Ditadura no Brasil",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ditadura no Brasil"
                    ),
                    EstudosConteudos(
                        id = 149,
                        name = "Escravidão",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Conteúdo de Escravidão"
                    ),
                    EstudosConteudos(
                        id = 150,
                        name = "Revolução Industrial",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Revolução Industrial"
                    ),
                    EstudosConteudos(
                        id = 151,
                        name = "Revolução Russa",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Revolução Russa"
                    ),
                    EstudosConteudos(
                        id = 152,
                        name = "República oligárquica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar República oligárquica"
                    ),
                    EstudosConteudos(
                        id = 153,
                        name = "República liberal",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar República liberal"
                    ),
                    EstudosConteudos(
                        id = 154,
                        name = "Era Vargas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Era Vargas"
                    ),
                    EstudosConteudos(
                        id = 155,
                        name = "Conquistas trabalhistas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Conquistas trabalhistas"
                    ),
                    EstudosConteudos(
                        id = 156,
                        name = "Primeira Guerra Mundial",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Primeira Guerra Mundial"
                    ),
                    EstudosConteudos(
                        id = 157,
                        name = "Segunda Guerra Mundial",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Segunda Guerra Mundial"
                    ),
                    EstudosConteudos(
                        id = 158,
                        name = "Guerra Fria",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Guerra Fria"
                    ),
                    EstudosConteudos(
                        id = 159,
                        name = "Idade Contemporânea",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Idade Contemporânea"
                    ),
                    EstudosConteudos(
                        id = 160,
                        name = "Brasil Colônia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Brasil Colônia"
                    ),
                    EstudosConteudos(
                        id = 161,
                        name = "Primeiro Reinado",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Primeiro Reinado"
                    ),
                    EstudosConteudos(
                        id = 162,
                        name = "Segundo Reinado",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Segundo Reinado"
                    ),
                    EstudosConteudos(
                        id = 163,
                        name = "Governos pós-regime militar",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Governos pós-regime militar"
                    ),
                    EstudosConteudos(
                        id = 164,
                        name = "Redemocratização",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Redemocratização"
                    ),
                    EstudosConteudos(
                        id = 165,
                        name = "História Política",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar História Política"
                    ),
                    EstudosConteudos(
                        id = 166,
                        name = "República Velha",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "República Velha"
                    ),
                    EstudosConteudos(
                        id = 167,
                        name = "Patrimônio Histórico-Cultural e Memória",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Patrimônio Histórico-Cultural e Memória"
                    ),
                    EstudosConteudos(
                        id = 256,
                        name = "Constituição Federal de 1988",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Constituição Federal de 1988"
                    ))
            ),

            Disciplina(
                id = 8,
                name = "Sociologia",
                imageDisc = R.drawable.sociologia,
                conteudos = listOf(EstudosConteudos(
                    id = 168,
                    name = "Globalização",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Globalização"
                ),
                    EstudosConteudos(
                        id = 169 ,
                        name = "Relações de Trabalho",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Relações de Trabalho"
                    ),
                    EstudosConteudos(
                        id = 170,
                        name = "Cultura de massa",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Cultura de massa"
                    ),
                    EstudosConteudos(
                        id = 171,
                        name = "Marxismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Marxismo"
                    ),
                    EstudosConteudos(
                        id = 172,
                        name = "Contratualismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Contratualismo"
                    ),
                    EstudosConteudos(
                        id = 173,
                        name = "O papel das mulheres, negros e homossexuais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar O papel das mulheres, negros e homossexuais"
                    ),
                    EstudosConteudos(
                        id = 174,
                        name = "Direitos Humanos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Direitos Humanos"
                    ),
                    EstudosConteudos(
                        id = 175,
                        name = "Sociologia contemporânea",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Sociologia contemporânea"
                    ),
                    EstudosConteudos(
                        id = 176,
                        name = "Mundo do Trabalho",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Mundo do Trabalho"
                    ),
                    EstudosConteudos(
                        id = 177,
                        name = "Cultura e Indústria Cultural",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cultura e Indústria Cultural"
                    ),
                    EstudosConteudos(
                        id = 178,
                        name = "Ideologia",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ideologia"
                    ),
                    EstudosConteudos(
                        id = 179,
                        name = "Meios de Comunicação",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Meios de Comunicação"
                    ),
                    EstudosConteudos(
                        id = 180,
                        name = "Cidadania",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cidadania"
                    ),
                    EstudosConteudos(
                        id = 181,
                        name = "Economia e sociedade",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Economia e sociedade"
                    ),
                    EstudosConteudos(
                        id = 182,
                        name = "Comunismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Comunismo"
                    ),
                    EstudosConteudos(
                        id = 183,
                        name = "Socialismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Socialismo"
                    ),
                    EstudosConteudos(
                        id = 184,
                        name = "Max Weber",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Max Weber"
                    ),
                    EstudosConteudos(
                        id = 185,
                        name = "Karl Marx",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Karl Marx"
                    ),
                    EstudosConteudos(
                        id = 186,
                        name = "Émile Durkheim",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Émile Durkheim"
                    ),
                    EstudosConteudos(
                        id = 187,
                        name = "Friedrich Engels",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Friedrich Engels"
                    ),
                    EstudosConteudos(
                        id = 188,
                        name = "Movimentos sociais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Movimentos sociais"
                    ),
                    EstudosConteudos(
                        id = 189,
                        name = "Sociologia brasileira",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Sociologia brasileira"
                    ),
                    EstudosConteudos(
                        id = 190,
                        name = "Indústira Cultural",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Indústira Cultural"
                    ),
                    EstudosConteudos(
                        id = 191,
                        name = "Política",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Política"
                    ),
                    EstudosConteudos(
                        id = 192,
                        name = "Estado e cidadania",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Estado e cidadania"
                    ),
                    EstudosConteudos(
                        id = 193,
                        name = "Diversidade cultural",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Diversidade cultural"
                    ),
                    EstudosConteudos(
                        id = 194,
                        name = "Surgimento de classes",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Surgimento de classes"
                    ),
                    EstudosConteudos(
                        id = 195,
                        name = "Modelos de produção",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Modelos de produção"
                    ),
                    EstudosConteudos(
                        id = 196,
                        name = "Políticas públicas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Políticas públicas"
                    ),
                    EstudosConteudos(
                        id = 257,
                        name = "Desigualdade social",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Desigualdade social"
                    )),
            ),

            Disciplina(
                id = 9,
                name = "Filosofia",
                imageDisc = R.drawable.filosofia,
                conteudos = listOf(EstudosConteudos(
                    id = 197,
                    name = "Pré-Socráticos",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Pré-Socráticos"
                ),
                    EstudosConteudos(
                        id = 198 ,
                        name = "Fé e Razão: São Tomás",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Fé e Razão: São Tomás"
                    ),
                    EstudosConteudos(
                        id = 199,
                        name = "Fé e Razão: Santo Agostinho",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Fé e Razão: Santo Agostinho"
                    ),
                    EstudosConteudos(
                        id = 200,
                        name = "Pensadores da Grécia Antiga",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Pensadores da Grécia Antiga"
                    ),
                    EstudosConteudos(
                        id = 201,
                        name = "Contratualismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Contratualismo"
                    ),
                    EstudosConteudos(
                        id = 202,
                        name = "Aristóteles",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Aristóteles"
                    ),
                    EstudosConteudos(
                        id = 203,
                        name = "Escola Helenística",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Escola Helenística"
                    ),
                    EstudosConteudos(
                        id = 204,
                        name = "Ética e Justiça",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ética e Justiça"
                    ),
                    EstudosConteudos(
                        id = 205,
                        name = "Racionalismo moderno",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Racionalismo moderno"
                    ),
                    EstudosConteudos(
                        id = 206,
                        name = "Filosofia Antiga",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Filosofia Antiga"
                    ),
                    EstudosConteudos(
                        id = 207,
                        name = "Escola Sofística",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Escola Sofística"
                    ),
                    EstudosConteudos(
                        id = 208,
                        name = "Sócrates",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Sócrates"
                    ),
                    EstudosConteudos(
                        id = 209,
                        name = "Platão",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Platão"
                    ),
                    EstudosConteudos(
                        id = 210,
                        name = "Filosofia Contemporânea",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Filosofia Contemporânea"
                    ),
                    EstudosConteudos(
                        id = 211,
                        name = "Natureza do Conhecimento",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Natureza do Conhecimento"
                    ),
                    EstudosConteudos(
                        id = 212,
                        name = "Filosofia Moderna",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Filosofia Moderna"
                    ),
                    EstudosConteudos(
                        id = 213,
                        name = "Escola de Frankfurt",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Escola de Frankfurt"
                    ),
                    EstudosConteudos(
                        id = 214,
                        name = "Ética e Moral",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Ética e Moral"
                    ),
                    EstudosConteudos(
                        id = 215,
                        name = "Idealismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Idealismo"
                    ),
                    EstudosConteudos(
                        id = 216,
                        name = "Materialismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Materialismo"
                    ),
                    EstudosConteudos(
                        id = 217,
                        name = "Empirismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Empirismo"
                    ),
                    EstudosConteudos(
                        id = 218,
                        name = "Iluminismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Iluminismo"
                    ),
                    EstudosConteudos(
                        id = 219,
                        name = "Escolástica",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Escolástica"
                    ),
                    EstudosConteudos(
                        id = 220,
                        name = "Racionalismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Racionalismo"
                    ),
                    EstudosConteudos(
                        id = 221,
                        name = "René Descartes",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar René Descartes"
                    ),
                    EstudosConteudos(
                        id = 222,
                        name = "John Locke",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar John Locke"
                    ),
                    EstudosConteudos(
                        id = 223,
                        name = "Montesquieu",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Montesquieu"
                    ),
                    EstudosConteudos(
                        id = 224,
                        name = " Adam Smith",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar  Adam Smith"
                    ),
                    EstudosConteudos(
                        id = 225,
                        name = "Immanuel Kant",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Immanuel Kant"
                    ),
                    EstudosConteudos(
                        id = 226,
                        name = "Rousseau",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Rousseau"
                    ),
                    EstudosConteudos(
                        id = 227,
                        name = "Voltaire",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Voltaire"
                    ))
            ),

            Disciplina(
                id = 10,
                name = "Artes",
                imageDisc = R.drawable.artes,
                conteudos = listOf(EstudosConteudos(
                    id = 228,
                    name = "Arte Contemporânea",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Arte Contemporânea"
                ),
                    EstudosConteudos(
                        id = 229 ,
                        name = "Barroco",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Barroco"
                    ),
                    EstudosConteudos(
                        id = 230,
                        name = "Renascimento",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Renascimento"
                    ),
                    EstudosConteudos(
                        id = 231,
                        name = "Modernismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Modernismo"
                    ),
                    EstudosConteudos(
                        id = 232,
                        name = "Funções da Arte",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Funções da Arte"
                    ),
                    EstudosConteudos(
                        id = 233,
                        name = "Vanguardas Artísticas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Vanguardas Artísticas"
                    ),
                    EstudosConteudos(
                        id = 234,
                        name = "Semana de Arte Moderna",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Semana de Arte Moderna"
                    ),
                    EstudosConteudos(
                        id = 235,
                        name = "Matrizes africanas e indígenas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Matrizes africanas e indígenas"
                    ),
                    EstudosConteudos(
                        id = 236,
                        name = "Cubismo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Cubismo"
                    ),
                    EstudosConteudos(
                        id = 237,
                        name = "Movimentos artísticos e culturais",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Movimentos artísticos e culturais"
                    ))
            ),

            Disciplina(
                id = 11,
                name = "Inglês",
                imageDisc = R.drawable.ingles,
                conteudos = listOf(EstudosConteudos(
                    id = 238,
                    name = "Interpretação de Texto",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Interpretação de Texto"
                ),
                    EstudosConteudos(
                        id = 239 ,
                        name = "Gramática",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Gramática"
                    ),
                    EstudosConteudos(
                        id = 240,
                        name = "Vocabulário",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Vocabulário"
                    ),
                    EstudosConteudos(
                        id = 241,
                        name = "Expressões Idiomáticas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Expressões Idiomáticas"
                    ))
            ),

            Disciplina(
                id = 12,
                name = "Espanhol",
                imageDisc = R.drawable.espanhol,
                conteudos = listOf(
                    EstudosConteudos(
                        id = 242,
                        name = "Interpretação de Texto",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Interpretação de Texto",
                    ),
                    EstudosConteudos(
                        id = 243,
                        name = "Gramática",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Gramática"
                    ),
                    EstudosConteudos(
                        id = 244,
                        name = "Vocabulário",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Vocabulário"
                    ),
                    EstudosConteudos(
                        id = 245,
                        name = "Expressões Idiomáticas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Expressões Idiomáticas"
                    )
                )
            ),

            Disciplina(
                id = 13,
                name = "Ed. Física",
                imageDisc = R.drawable.educacaofisica,
                conteudos = listOf(EstudosConteudos(
                    id = 246,
                    name = "Práticas corporais e autonomia",
                    dataEstudo = Date(),
                    dificuldade = Dificuldade.FÁCIL,
                    checkEstudo = false,
                    resolucao = true,
                    anotacoes = "Praticar Práticas corporais e autonomia"
                ),
                    EstudosConteudos(
                        id = 247 ,
                        name = "Padrão estético contemporâneo",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Padrão estético contemporâneo"
                    ),
                    EstudosConteudos(
                        id = 248,
                        name = "Esportes",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Esportes"
                    ),
                    EstudosConteudos(
                        id = 249,
                        name = "Exercício físico e saúde",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Exercício físico e saúde"
                    ),
                    EstudosConteudos(
                        id = 250,
                        name = "Corpo e expressão artística/cultural",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Corpo e expressão artística/cultural"
                    ),
                    EstudosConteudos(
                        id = 251,
                        name = "Danças",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Danças"
                    ),
                    EstudosConteudos(
                        id = 252,
                        name = "Condicionamentos e esforços físicos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Condicionamentos e esforços físicos"
                    ),
                    EstudosConteudos(
                        id = 253,
                        name = "Lutas",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Lutas"
                    ),
                    EstudosConteudos(
                        id = 254,
                        name = "Exercício Jogos e brincadeiras",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Jogos e brincadeiras"
                    ),
                    EstudosConteudos(
                        id = 255,
                        name = "Jogos Olímpicos",
                        dataEstudo = Date(),
                        dificuldade = Dificuldade.FÁCIL,
                        checkEstudo = false,
                        resolucao = true,
                        anotacoes = "Praticar Jogos Olímpicos"
                    ))
            )
        )

    //buscar conteúdos dentro da disciplina
        fun getConteudosByDisciplina(disciplina: String): List<EstudosConteudos>? {
            return disciplinasList.find { it.name.equals(disciplina, ignoreCase = true) }?.conteudos
        }

    //buscar disciplinas ou conteúdos na tela inicial
    fun getDisciplinaOrConteudo(query: String): List<String> {
        val result = mutableListOf<String>()

        // Buscar na lista de disciplinas
        for (disciplina in disciplinasList) {
            if (disciplina.name.contains(query, ignoreCase = true)) {
                result.add("Disciplina: ${disciplina.name}")
            }

            // Buscar no conteúdo de cada disciplina
            for (conteudo in disciplina.conteudos) {
                if (conteudo.name.contains(query, ignoreCase = true)) {
                    result.add("Conteúdo: ${conteudo.name} - Disciplina: ${disciplina.name}")
                }
            }
        }
        return result
        }