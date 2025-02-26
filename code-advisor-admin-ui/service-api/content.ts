import exp from "constants";

const getTotalContent = async () => {
    const content = await fetch('/contents/api/v1/contents/total-content');  
    const data = await content.json();
    if(content.ok){
        return data;
    }else{
        throw data;
    }
}

export {getTotalContent};