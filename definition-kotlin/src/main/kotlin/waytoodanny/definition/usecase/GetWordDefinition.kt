package waytoodanny.definition.usecase

import io.vavr.control.Either
import waytoodanny.definition.domain.Definition

interface GetWordDefinition {
    fun definition(word: String): Either<Exception, Definition>
}