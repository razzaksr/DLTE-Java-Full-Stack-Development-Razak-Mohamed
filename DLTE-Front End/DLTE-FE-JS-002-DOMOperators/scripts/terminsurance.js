function status(){
    var fname=document.forms['term'].fullname.value;
    var age=document.forms['term'].age.value;
    var smkStatus=document.forms['term'].type.value;

    // find the exact plan for the customer
    if(age>=21&&age<=45){
        if(smkStatus==="non-smoker"){
            document.forms['term'].show.value=fname+" has eligible to get 1Cr of Term insurance from ICICI, UTI, Bajaj";
        }
        else{
            document.forms['term'].show.value=fname+" has eligible to get 50Lacks of Term insurance from Allianze, Adidta, Tata AIA";
        }
    }
    else if(age>45){
        if(smkStatus==="non-smoker"){
            document.forms['term'].show.value=fname+" has eligible to get 20lacks of Term insurance from HDB";
        }
        else{
            document.forms['term'].show.value=fname+" has eligible to get 10Lacks of Term insurance from Star health";
        }
    }
    else{
        document.forms['term'].show.value=fname+" hasn't eligible to apply term insurance";
    }

    //alert(fname+" "+age+" "+smkStatus);
}