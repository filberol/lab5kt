package lab5.data.commands

import lab5.data.exceptions.RedundantArgsException
import lab5.data.objects.Person
import lab5.data.utilities.CollectionManager
import lab5.data.utilities.LanguageManager

class PrintCollectionCommand(
    private val language: LanguageManager,
    private val collection: CollectionManager,
): AbstractCommand(language) {

    fun execute(arguments: ArrayList<String>, comparator: Comparator<Person>, range: Int): Boolean {
        if (arguments.isNotEmpty()) {
            throw RedundantArgsException(language)
        } else {
            collection.sortWith(comparator)
            collection.printCollection(range-1)
        }
        return false
    }

    fun safeExecute(arguments: ArrayList<String>, comparator: Comparator<Person>, range: Int): Boolean {
        try {
            execute(arguments, comparator, range)
        } catch (e: RedundantArgsException) {
            println(e.message)
            if (ProceedCommand(language).safeExecute()) {
                collection.sortWith(comparator)
                collection.printCollection(range-1)
            } else return false
        }
        return true
    }
}