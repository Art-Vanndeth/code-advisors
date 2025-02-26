
const getAllQuestions = async () => {
    const questions = await fetch('/forums/api/v1/questions');  
    const data = await questions.json();
    if(questions.ok){
        return data;
    }else{
        throw data;
    }
}

const getTotalAnswers = async () => {
    const answers = await fetch('/forums/api/v1/answers/total');  
    const data = await answers.json();
    if(answers.ok){
        return data;
    }else{
        throw data;
    }
}

export {getAllQuestions, getTotalAnswers};