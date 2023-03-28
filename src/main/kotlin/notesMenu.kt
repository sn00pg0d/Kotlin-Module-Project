import java.util.*

class notesMenu(val name: String) {
    private val notes = mutableListOf<Notes>()

    // это меню заметок (создание, просмотр)
    fun showNotesMenu(scanner: Scanner) {
        val nullCheck = nullCheck()

        while (true) {
            println("Список заметок:")
            println("0. Создать заметку")
            notes.forEachIndexed { index, note -> println("${index + 1}. ${note.name}") }
            println("${notes.size + 1}. Назад")

            val input = scanner.nextLine()

            if (nullCheck.validateInput(input)) {
                val number = input.toIntOrNull()
                if (number == null) {
                    nullCheck.viewDigitError()
                } else {
                    when (number) {
                        // создание заметки
                        0 -> createNote(scanner)
                        // просмотр заметки
                        in 1..notes.size -> {
                            notes[number - 1].showNote()
                        }
                        // выход
                        notes.size + 1 -> return
                        else -> nullCheck.viewDigitError()
                    }
                }
            }
        }
    }

    //создание заметки
    private fun createNote(scanner: Scanner) {
        println("Введите название заметки:")
        val noteName = scanner.nextLine()
        println("Введите текст заметки:")
        val noteText = scanner.nextLine()
        notes.add(Notes(noteName, noteText))
        println("Вы создали заметку - \"$noteName\"\n")
    }
}