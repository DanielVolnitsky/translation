package waytoodanny.definition.infrastructure.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import waytoodanny.definition.usecase.GetWordDefinition

@RestController
class DefinitionController constructor(val getWordDefinition: GetWordDefinition) {

    @GetMapping("/{word}/definition")
    fun greeting(@PathVariable word: String): ResponseEntity<String> =
            getWordDefinition.definition(word)
                    .fold(
                            { ResponseEntity.notFound().build() },
                            { definition -> ResponseEntity.ok(definition.value) }
                    )
}