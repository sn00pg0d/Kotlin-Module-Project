import java.util.*
import kotlin.system.exitProcess

fun loading() {
    println("Идет загрузка программы \"Архивариус\" версии 0.0.1a")
    Timer().schedule(object : TimerTask() {
        override fun run() {
            print(".")
        }
    }, 500)
    Timer().schedule(object : TimerTask() {
        override fun run() {
            print("..")
        }
    }, 1000)
    Timer().schedule(object : TimerTask() {
        override fun run() {
            print("...")
        }
    }, 2000)
    Timer().schedule(object : TimerTask() {
        override fun run() {
            print("..")
        }
    }, 3700)
    Timer().schedule(object : TimerTask() {
        override fun run() {
            print("Done\n\n")
        }
    }, 3900)
    Timer().schedule(object : TimerTask() {
        override fun run() {
            println("%ERROR_NAME% добро пожаловать в программу \"Архивариус\"!\n")
        }
    }, 4400)
}

fun main() {
    loading()
    val scanner = Scanner(System.`in`)
    val archivesMenu = archivesMenu()
    val nullCheck = nullCheck()
    Timer().schedule(object : TimerTask() {
        override fun run() {
            while (true) {
                val archives = archivesMenu.getArchives()
                println("Вот список Ваших архивов:")
                println("0. Создать архив")
                archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
                println("${archives.size + 1}. Выход")

                val input = scanner.nextLine()

                if (nullCheck.validateInput(input)) {
                    val number = input.toIntOrNull()
                    if (number == null) {
                        nullCheck.viewDigitError()
                    } else {
                        when (number) {
                            // создание архива
                            0 -> {
                                println("Введите название архива:")
                                val archiveName = scanner.nextLine()
                                if (archiveName.isNullOrBlank()) {
                                    nullCheck.viewDigitError()
                                } else {
                                    archivesMenu.createArchive(archiveName)
                                    println("Вы создали архив - \"$archiveName\"\n")
                                }
                            }
                            // переход в архив
                            in 1..archives.size -> {
                                archives[number - 1].showNotesMenu(scanner)
                            }
                            // выход
                            archives.size + 1 -> {
                                println("До свидания!")
                                exitProcess(555)
                            }

                            else -> nullCheck.viewDigitError()
                        }
                    }
                }
            }
        }
    }, 4800)
}
