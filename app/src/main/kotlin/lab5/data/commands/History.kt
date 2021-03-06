package lab5.data.commands

import lab5.data.exceptions.RedundantArgsException
import lab5.data.utilities.HistoryManager
import lab5.data.utilities.LanguageManager

/**
 * Prints executed commands and their execution time.
 * Number of stored commands is stored in the config file.
 */
class History(
    private val language: LanguageManager
): AbstractCommand(language) {

    @Throws(RedundantArgsException::class)
    private fun execute(arguments: ArrayList<String>
                        , history: HistoryManager): Boolean {
        if (arguments.isNotEmpty()) {
            throw RedundantArgsException(language)
        } else {
            history.printHistory()
        }
        return true
    }

    fun safeExecute(arguments: ArrayList<String>
                    , history: HistoryManager): Boolean {
        try {
            execute(arguments, history)
        } catch (e: RedundantArgsException) {
            println(e.message)
            if (Proceed(language).safeExecute()) {
                history.printHistory()
            } else return false
        }
        return true
    }
}