// temporary storage of bank employee's
const bankerDb=[
    {
        "bankerid":8765678,
        "bankername":"razakmohamed",
        "bankerpin":"Razak@123",
        "bankerage":31,
        "bakeraddress":"Salem, Tamilnadu, India"
    },
    {
        "bankerid":4565634,
        "bankername":"sridhar",
        "bankerpin":"Moorthy@123",
        "bankerage":45,
        "bakeraddress":"Banglore, India"
    },
    {
        "bankerid":9876678,
        "bankername":"arun",
        "bankerpin":"arun@123",
        "bankerage":45,
        "bakeraddress":"Hubli, Karnataka, India"
    }
]

const validate=()=>{
    var id=document.forms['log'].bankerId.value
    var pin=document.forms['log'].bankerPin.value
    document.getElementById("errid").innerHTML=""
    document.getElementById("errpin").innerHTML=""
    bankerDb.map((val)=>{
        if(val.bankerid==id&&val.bankerpin==pin){
            //alert(JSON.stringify(val))
            //return true
            // alert(id+" "+pin)
            window.location="http://127.0.0.1:5500/DLTE-FE-BankUC-ClientSide/nav.html"
            sessionStorage.setItem("logged",val.bankername)
            // navigating whole page
            // window.location.assign()
            // window.location.href=""
        }
    })
    document.getElementById("errid").innerHTML="Invalid Banker ID"
    document.getElementById("errpin").innerHTML="Invalid Banker PIN"
}