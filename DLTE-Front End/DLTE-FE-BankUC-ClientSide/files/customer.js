let customerDb=[
    {
        "customerId":981290200,
        "customerName":"Razak Mohamed Shahul Hameed",
        "customerPin":"Razak@123",
        "customerStatus":"active",
        "accountNumber":98765678765567,
        "accountBalance":987.4,
        "Aadhaar":98789873445,
        "pan":"ABCDE1234E",
        "mobile":87656765654,
        "email":"razaksrmd@gmail.com"
    },
    {
        "customerId":87656784,
        "customerName":"Abdul Razak",
        "customerPin":"Razak@123",
        "customerStatus":"active",
        "accountNumber":12222222222233,
        "accountBalance":987.4,
        "Aadhaar":8888888888888,
        "pan":"EEEEE6773W",
        "mobile":9876787687,
        "email":"abdul@gmail.com"
    },
    {
        "customerId":93264535,
        "customerName":"Sabarinathan S",
        "customerPin":"Sabari@123",
        "customerStatus":"active",
        "accountNumber":8765676564555,
        "accountBalance":987.4,
        "Aadhaar":1233843434,
        "pan":"BSCDE1213E",
        "mobile":9876567345,
        "email":"sabariragu@gmail.com"
    },
    {
        "customerId":8765678987,
        "customerName":"Sridhar Moorthy",
        "customerPin":"sridhar@123",
        "customerStatus":"active",
        "accountNumber":98764656577575,
        "accountBalance":987.4,
        "Aadhaar":1111111233,
        "pan":"DECF7647D",
        "mobile":98765676563,
        "email":"sridharmoorthy@gmail.com"
    },
    {
        "customerId":12343234,
        "customerName":"Kirtan",
        "customerPin":"kirtan@123",
        "customerStatus":"active",
        "accountNumber":56787656734,
        "accountBalance":987.4,
        "Aadhaar":11111222222222,
        "pan":"EFGHE7881E",
        "mobile":98765678734,
        "email":"kirtan@gmail.com"
    },
]

const authenticate=()=>{

    document.getElementById("errid").innerHTML=""
    document.getElementById("errname").innerHTML=""
    document.getElementById("errpin").innerHTML=""
    document.getElementById("erremail").innerHTML=""
    
    var custId=document.forms['newone'].customerid.value;
    var custName=document.forms['newone'].fullname.value;
    var custPin=document.forms['newone'].pin.value;
    var custEmail=document.forms['newone'].email.value;

    try{
        if(custId==""){
            throw "Customer Id Shouldn't empty"
        }
        else if(!(/[0-9]/).test(custId)){
            throw "Customer Id is not valid"
        }
    }
    catch(errmsg){
        document.getElementById("errid").innerHTML=errmsg
    }

    try{
        if(custName==""){
            throw "Customer Name Shouldn't empty"
        }
        else if((/^[a-zA-Z]/).test(custName)){
            throw "Customer Name is not valid"
        }
    }
    catch(errmsg){
        document.getElementById("errname").innerHTML=errmsg
    }

    try{
        if(custPin==""){
            throw "Customer PIN Shouldn't empty"
        }
        else if(!(/(?=.*[0-9])(?=.*[$#@!*])[a-zA-Z0-9$#@!*]{8,}/).test(custPin)){
            throw "Customer PIN is not valid"
        }
    }
    catch(errmsg){
        document.getElementById("errpin").innerHTML=errmsg
    }

    try{
        if(custEmail==""){
            throw "Customer Email Shouldn't empty"
        }
        // razaksrmd@gmail.com
        else{
            var rate=custEmail.indexOf("@")
            var dot=custEmail.lastIndexOf(".")
            //alert(rate+" "+dot)
            if(rate<1 || (dot-rate < 3) ){
                throw "Customer Email is not valid"
            }
        }
    }
    catch(errmsg){
        document.getElementById("erremail").innerHTML=errmsg
    }
}

const collect=(criteria)=>{
    var txt=""
    customerDb.map((val)=>{
        if(val.customerName.includes(criteria)){
            txt+="<tr><td>"+val.customerId+"</td><td>"+
            val.customerName+"</td><td>"+val.accountNumber+"</td></tr>";
        }
    })
    document.getElementById("view").innerHTML=txt
}

const iterate=()=>{
    var txt=""
    customerDb.map((val)=>{
        txt+="<tr><td>"+val.customerId+"</td><td>"+
        val.customerName+"</td><td>"+val.accountNumber+"</td></tr>";
    })
    document.getElementById("view").innerHTML=txt
}