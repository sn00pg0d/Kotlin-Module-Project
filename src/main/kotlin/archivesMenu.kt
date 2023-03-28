class archivesMenu {
    private val notesMenus = mutableListOf<notesMenu>()

    fun createArchive(name: String) {
        notesMenus.add(notesMenu(name))
    }

    fun getArchives(): List<notesMenu> {
        return notesMenus.toList()
    }
}