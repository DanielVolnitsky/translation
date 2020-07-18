package waytoodanny.definition.usecase

import io.vavr.control.Either
import waytoodanny.definition.domain.WordInformation

interface GetWordInformation {
    fun wordInformation(word: String): Either<Exception, WordInformation>
}