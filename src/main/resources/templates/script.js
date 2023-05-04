function questionComponent(){

}

async function getData(subject) {
    try {
        const response = await fetch(`http://127.0.0.1:8080/questions/${subject}`);
        if (!response.ok) throw "No response";
        return await response.json();
    } catch {
        alert("gebasz van");
    }
}

function sortByTitle(){

}

function sortByTimeStamp(){

}

function sortByAnswerCount(){

}

