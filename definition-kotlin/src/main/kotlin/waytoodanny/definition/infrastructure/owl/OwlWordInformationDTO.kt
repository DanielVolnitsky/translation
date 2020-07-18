package waytoodanny.definition.infrastructure.owl

data class OwlWordInformationDTO(var word: String = "",
                                 var definitions: List<Definition> = emptyList()) {

    data class Definition(var example: String = "",
                          var definition: String = "",
                          var type: String = "")
}