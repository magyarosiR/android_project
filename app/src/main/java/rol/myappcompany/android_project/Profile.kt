package rol.myappcompany.android_project

class Profile {
    var id = 0
    var name = ""
    var adress = ""
    var phone_number = 0
    var email = ""

    constructor(name: String, adress: String, phone_number: Int, email: String){
        this.name = name
        this.adress = adress
        this.phone_number = phone_number
        this.email = email
    }
    constructor(){

    }
}