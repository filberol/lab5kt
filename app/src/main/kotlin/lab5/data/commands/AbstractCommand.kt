package lab5.data.commands

import lab5.data.exceptions.*
import lab5.data.utilities.LanguageManager

/**
 * Abstract command when executing anything will return a boolean value as a feedback of the execution of the command.
 */
abstract class AbstractCommand(lang: LanguageManager) {
    /**
     * Specified langHolder returns language needed to print to console.
     */
    private var language: LanguageManager

    /**
     * Some commands not needing arguments will throw exception if try to use them with.
     * You will be asked to proceed or not the following command.
     */
    init {
        language = lang
    }

    /**
     * Unprotected execute command throwing pile of Exceptions to your face.
     * @throws ExecuteException Major error in executing the command.
     * @throws SyntaxException Just in case you don't understand what's written.
     * @throws RedundantArgsException Just in case you don't understand what's needed.
     * @throws NotEnoughArgsException Some commands require arguments.
     */
    @Throws(ExecuteException::class, SyntaxException::class, RedundantArgsException::class,
            NotEnoughArgsException::class,)
    open fun execute(): Boolean {return true}

    /**
     * Protected execute command recursively calling usual execution and watching after exceptions.
     */
    open fun safeExecute(): Boolean {return true}
}