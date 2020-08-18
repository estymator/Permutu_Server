let selectedArray = []


function selected(elem){
    let blockId =  document.getElementById(elem.id);
    if(blockId.style.backgroundColor === "pink"){
        blockId.style.backgroundColor = "gray";
        const index = selectedArray.indexOf(blockId.id);
        if(index > -1){
            selectedArray.splice(index,1);
        }
        console.log(selectedArray);

    }
    else{
        blockId.style.backgroundColor = "pink";
        selectedArray.push(blockId.id);
        console.log(selectedArray);
    }
}