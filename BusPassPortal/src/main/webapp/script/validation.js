function validate(){
	var flag=false;
	var userName=f1.userName.value
	var userpasswd=f1.userPwd.value
	if(userName==""||userName==null){
		document.getElementById('userErrMsg').innerHTML="* Please enter user Name"
			flag=false;
	}else if(userpasswd==""||userpasswd==null){
		document.getElementById('pwdErrMsg').innerHTML="* Please enter user Password"
			document.getElementById('userErrMsg').innerHTML=""
			flag=false;
	}else{
		flag=true;
	}
	
	return flag;
}