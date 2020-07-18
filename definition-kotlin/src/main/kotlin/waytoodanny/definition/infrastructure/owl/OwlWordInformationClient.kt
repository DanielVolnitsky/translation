package waytoodanny.definition.infrastructure.owl

import io.vavr.control.Either
import java.lang.IllegalArgumentException

class OwlWordInformationClient {

    fun wordInformation(word: String): Either<Exception, OwlWordInformationDTO> {
        //TODO
        return Either.left(IllegalArgumentException())
    }
}