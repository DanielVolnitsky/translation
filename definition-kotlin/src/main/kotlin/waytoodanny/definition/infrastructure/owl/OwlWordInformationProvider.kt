package waytoodanny.definition.infrastructure.owl

import io.vavr.control.Either
import org.springframework.stereotype.Service
import waytoodanny.definition.domain.WordInformation
import waytoodanny.definition.usecase.GetWordInformation
import java.lang.IllegalArgumentException

@Service
class OwlWordInformationProvider : GetWordInformation {

    override fun wordInformation(word: String): Either<Exception, WordInformation> {
        //TODO
        return Either.left(IllegalArgumentException())
    }
}