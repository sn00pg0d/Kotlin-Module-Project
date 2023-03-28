class nullCheck {

    fun validateInput(input: String?): Boolean {
        when {
            input.isNullOrEmpty() -> {
                println("Ничего не введено. Попробуйте еще раз\n")
                return false
            }
        }
        return true
    }

    fun viewDigitError() {
        println("Неверный ввод. Попробуйте еще раз\n")
    }
}