package waytoodanny.definition.infrastructure.owl

data class OwlWordInformationDTO(val word: String, val definitions: List<Definition>) {

    data class Definition(val example: String,
                          val definition: String,
                          val type: String)
}