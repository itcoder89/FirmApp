package com.social.ekchat.Interfaces



class UniverSelObjctStatusTF{

    var  response:Any
    var  methodname:String
    var  status:Boolean
    var  msg:String

    constructor(redult: Any, methodname: String , status: Boolean, msg: String) {

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
