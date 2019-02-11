package mkobandroiddep.com.ktlnexmple.model


class ModelApi{

    lateinit var title: String
    lateinit var descriptor: String
    lateinit var categoryName: String

    constructor(title: String, descriptor: String, categoryName: String) {
        this.title = title
        this.descriptor = descriptor
        this.categoryName = categoryName
    }
    constructor()
}



