package com.social.ekchat.Interfaces



class UniverSelObjct{

    var  response:Any
    var  methodname:String
    var  status:String
    var  msg:String

    constructor(redult: Any, methodname: String , status: String, msg: String) {

        if(redult==null){
            this.response = ""
        }else{
            this.response = redult
        }

        this.methodname = methodname
        this.status = status
        this.msg = msg
    }
}
