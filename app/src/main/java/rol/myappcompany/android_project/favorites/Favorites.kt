package rol.myappcompany.android_project.favorites

class Favorites {
    val fid: Int = 0
    var id: Int = 0
    var name: String? = ""
    var ImgSrcUrl: String? = ""

    constructor(id: Int, name: String?, ImgSrcUrl: String?){
        this.id = id
        this.name = name
        this.ImgSrcUrl = ImgSrcUrl
    }
    constructor(){ }

}