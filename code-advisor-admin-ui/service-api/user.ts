const countAllUsers = async () => {
    const users = await fetch('/users/api/v1/user_profiles/total-users');  
    const data = await users.json();
    if(users.ok){
        return data;
    }else{
        throw data;
    }
}

export {countAllUsers};