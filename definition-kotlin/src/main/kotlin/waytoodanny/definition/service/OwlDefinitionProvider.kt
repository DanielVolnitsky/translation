package waytoodanny.definition.service

import io.vavr.control.Either
import org.springframework.stereotype.Service
import waytoodanny.definition.domain.Definition
import waytoodanny.definition.usecase.GetWordDefinition

@Service
class OwlDefinitionProvider : GetWordDefinition {

    override fun definition(word: String): Either<Exception, Definition> {
        return Either.right(Definition(word, "stub definition"))
    }
}